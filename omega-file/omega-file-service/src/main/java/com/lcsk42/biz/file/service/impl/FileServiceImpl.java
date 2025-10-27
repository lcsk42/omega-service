package com.lcsk42.biz.file.service.impl;

import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.biz.file.mapper.FileMapper;
import com.lcsk42.biz.file.model.convert.FileConverter;
import com.lcsk42.biz.file.model.dto.FileMetadataDTO;
import com.lcsk42.biz.file.model.po.FilePO;
import com.lcsk42.biz.file.model.vo.FileVO;
import com.lcsk42.biz.file.service.FileService;
import com.lcsk42.frameworks.starter.common.util.IdUtil;
import com.lcsk42.frameworks.starter.convention.errorcode.FileErrorCode;
import com.lcsk42.frameworks.starter.convention.exception.ServiceException;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.impl.ServiceImpl;
import com.lcsk42.frameworks.starter.file.core.config.FileUploadProperties;
import com.lcsk42.frameworks.starter.web.util.ServletUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileServiceImpl extends ServiceImpl<FileMapper, FilePO>
        implements FileService {

    private final com.lcsk42.frameworks.starter.file.core.service.FileService fileService;

    private final FileUploadProperties fileUploadProperties;

    @Override
    public FileVO upload(MultipartFile file,
            BizSourceEnum bizSource,
            Boolean publicRead,
            String batchId,
            Long id,
            String fileName) {
        String path;
        String bucketName = getBucketName(publicRead);
        try {
            path = fileService.uploadFile(
                    file.getInputStream(),
                    fileName,
                    bucketName);
        } catch (IOException e) {
            throw new ServiceException();
        }

        FilePO filePO = FilePO.builder()
                .id(id)
                .name(fileName)
                .size(file.getSize())
                .bucketName(bucketName)
                .path(path)
                .fileType(FilenameUtils.getExtension(fileName))
                .fileUploadType(fileUploadProperties.getFileUploadType())
                .bizSource(bizSource)
                .publicRead(publicRead)
                .batchId(StringUtils.isBlank(batchId) ? IdUtil.generateStandardUuid() : batchId)
                .build();

        save(filePO);
        return FileConverter.INSTANCE.toT(filePO);
    }

    @Override
    public FileVO uploadTempFile(MultipartFile file, String batchId) {
        String fileName = file.getName();
        String path;
        try {
            path = fileService.uploadTemporaryFile(file.getInputStream(), fileName);
        } catch (IOException e) {
            throw new ServiceException();
        }
        FilePO filePO = FilePO.builder()
                .id(IdUtil.getSnowflakeNextId())
                .name(fileName)
                .size(file.getSize())
                .bucketName(fileUploadProperties.getBucketName())
                .path(path)
                .fileType(FilenameUtils.getExtension(fileName))
                .fileUploadType(fileUploadProperties.getFileUploadType())
                .bizSource(BizSourceEnum.DEFAULT)
                .publicRead(false)
                .batchId(StringUtils.isBlank(batchId) ? IdUtil.generateStandardUuid() : batchId)
                .build();

        save(filePO);
        return FileConverter.INSTANCE.toT(filePO);
    }

    @Override
    public List<FileVO> listByBatchId(String batchId) {
        return lambdaQuery()
                .eq(FilePO::getBatchId, batchId)
                .orderByDesc(FilePO::getCreateTime)
                .list()
                .stream()
                .map(FileConverter.INSTANCE::toT)
                .toList();
    }

    @Override
    public FileVO getById(Long id) {
        return lambdaQuery()
                .eq(FilePO::getId, id)
                .oneOpt()
                .map(FileConverter.INSTANCE::toT)
                .orElseGet(FileVO::new);
    }

    @Override
    public void deleteById(Long id) {
        FileVO adminFileVO = getById(id);
        fileService.deleteFile(adminFileVO.getPath(), adminFileVO.getBucketName());
        lambdaUpdate()
                .eq(FilePO::getId, id)
                .remove();
    }

    @Override
    public void deleteByBatchId(String batchId) {

        lambdaQuery()
                .eq(FilePO::getBatchId, batchId)
                .list()
                .forEach(filePO -> fileService.deleteFile(filePO.getPath(),
                        filePO.getBucketName()));

        lambdaUpdate()
                .eq(FilePO::getBatchId, batchId)
                .remove();
    }

    @Override
    public void download(Long id, HttpServletResponse response) {
        FileVO adminFileVO = getById(id);

        try (InputStream inputStream =
                fileService.downloadFile(adminFileVO.getPath(), adminFileVO.getBucketName())) {
            ServletUtil.write(response, inputStream, adminFileVO.getName(),
                    MediaType.APPLICATION_OCTET_STREAM_VALUE);
        } catch (IOException e) {
            throw FileErrorCode.IO_RUNTIME_EXCEPTION.toServiceException();
        }

    }

    @Override
    public URL generatePreSignedDownloadUrl(Long id) {
        FileVO adminFileVO = getById(id);
        return fileService.generatePreSignedDownloadUrl(adminFileVO.getPath(),
                adminFileVO.getBucketName(),
                Duration.ofDays(1));
    }

    @Override
    public URL generatePreSignedUploadUrl(BizSourceEnum bizSource,
            Boolean publicRead,
            String batchId,
            Long id,
            String fileName) {

        String path = fileService.buildKey(fileName, false);
        String bucketName = getBucketName(publicRead);

        FilePO filePO = FilePO.builder()
                .id(id)
                .name(fileName)
                .size(0L)
                .bucketName(bucketName)
                .path(path)
                .fileType(FilenameUtils.getExtension(fileName))
                .fileUploadType(fileUploadProperties.getFileUploadType())
                .bizSource(bizSource)
                .publicRead(publicRead)
                .batchId(StringUtils.isBlank(batchId) ? IdUtil.generateStandardUuid() : batchId)
                .build();
        save(filePO);

        return fileService.generatePreSignedUploadUrl(path, bucketName, Duration.ofMinutes(15));
    }

    @Override
    public void updateFileMetadata(FileMetadataDTO fileMetadataDTO) {
        lambdaUpdate()
                .set(
                        StringUtils.isNoneBlank(fileMetadataDTO.getName()),
                        FilePO::getName,
                        fileMetadataDTO.getName())
                .set(
                        Objects.nonNull(fileMetadataDTO.getSize()),
                        FilePO::getSize,
                        fileMetadataDTO.getSize())
                .set(
                        StringUtils.isNoneBlank(fileMetadataDTO.getName()),
                        FilePO::getFileType,
                        FilenameUtils.getExtension(fileMetadataDTO.getName()))
                .eq(FilePO::getId, fileMetadataDTO.getId())
                .update();
    }

    private String getBucketName(boolean publicRead) {
        return publicRead ? fileUploadProperties.getExtra().getPublicBucketName()
                : fileUploadProperties.getBucketName();
    }
}
