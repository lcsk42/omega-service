package com.lcsk42.biz.file.service.impl;

import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.biz.file.mapper.FileMapper;
import com.lcsk42.biz.file.model.dto.FileMetadataDTO;
import com.lcsk42.biz.file.model.po.FilePO;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileServiceImpl extends ServiceImpl<FileMapper, FilePO>
        implements FileService {

    private final com.lcsk42.frameworks.starter.file.core.service.FileService fileService;

    private final FileUploadProperties fileUploadProperties;

    @Override
    public FilePO upload(MultipartFile file,
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
                .fileName(fileName)
                .fileSize(file.getSize())
                .bucketName(bucketName)
                .filePath(path)
                .fileType(FilenameUtils.getExtension(fileName))
                .fileUploadType(fileUploadProperties.getFileUploadType())
                .bizSource(bizSource)
                .publicRead(publicRead)
                .batchId(StringUtils.isBlank(batchId) ? IdUtil.generateStandardUuid() : batchId)
                .build();

        save(filePO);
        return filePO;
    }

    @Override
    public FilePO uploadTempFile(MultipartFile file, String batchId) {
        String fileName = file.getName();
        String path;
        try {
            path = fileService.uploadTemporaryFile(file.getInputStream(), fileName);
        } catch (IOException e) {
            throw new ServiceException();
        }
        FilePO filePO = FilePO.builder()
                .id(IdUtil.getSnowflakeNextId())
                .fileName(fileName)
                .fileSize(file.getSize())
                .bucketName(fileUploadProperties.getBucketName())
                .filePath(path)
                .fileType(FilenameUtils.getExtension(fileName))
                .fileUploadType(fileUploadProperties.getFileUploadType())
                .bizSource(BizSourceEnum.DEFAULT)
                .publicRead(false)
                .batchId(StringUtils.isBlank(batchId) ? IdUtil.generateStandardUuid() : batchId)
                .build();

        save(filePO);
        return filePO;
    }

    @Override
    public Optional<FilePO> getById(Long id) {
        return lambdaQuery()
                .eq(FilePO::getId, id)
                .oneOpt();
    }

    @Override
    public List<FilePO> listByBatchId(String batchId) {
        return lambdaQuery()
                .eq(FilePO::getBatchId, batchId)
                .orderByDesc(FilePO::getCreateTime)
                .list();
    }

    @Override
    public Boolean deleteById(Long id) {
        return getById(id).map(filePO -> lambdaUpdate()
                .eq(FilePO::getId, id)
                .remove()).orElse(Boolean.FALSE);
    }

    @Override
    public Boolean deleteByBatchId(String batchId) {
        return lambdaUpdate()
                .eq(FilePO::getBatchId, batchId)
                .remove();
    }

    @Override
    public void download(Long id, HttpServletResponse response) {
        FilePO filePO = getById(id)
                .orElseThrow(FileErrorCode.FILE_NOT_FOUND::toServiceException);

        try (InputStream inputStream = fileService.downloadFile(
                filePO.getFilePath(), filePO.getBucketName())) {
            ServletUtil.write(response, inputStream, filePO.getFileName(),
                    MediaType.APPLICATION_OCTET_STREAM_VALUE);
        } catch (IOException e) {
            // 注意：如果 response 已经开始写入，这里抛异常可能无效
            throw FileErrorCode.FILE_IO_EXCEPTION.toServiceException();
        }
    }

    @Override
    public URL generatePreSignedDownloadUrl(Long id, Duration signatureDuration) {
        return getById(id).map(adminFileVO -> fileService.generatePreSignedDownloadUrl(
                adminFileVO.getFilePath(),
                adminFileVO.getBucketName(),
                signatureDuration)).orElse(null);
    }

    @Override
    public URL generatePreSignedUploadUrl(BizSourceEnum bizSource,
            Boolean publicRead,
            String batchId,
            Long id,
            String fileName,
            Duration signatureDuration) {

        String path = fileService.buildKey(fileName, false);
        String bucketName = getBucketName(publicRead);

        FilePO filePO = FilePO.builder()
                .id(id)
                .fileName(fileName)
                .fileSize(0L)
                .bucketName(bucketName)
                .filePath(path)
                .fileType(FilenameUtils.getExtension(fileName))
                .fileUploadType(fileUploadProperties.getFileUploadType())
                .bizSource(bizSource)
                .publicRead(publicRead)
                .batchId(StringUtils.isBlank(batchId) ? IdUtil.generateStandardUuid() : batchId)
                .build();
        save(filePO);

        return fileService.generatePreSignedUploadUrl(path, bucketName, signatureDuration);
    }

    @Override
    public FilePO updateFileMetadata(FileMetadataDTO fileMetadataDTO) {
        lambdaUpdate()
                .set(
                        StringUtils.isNoneBlank(fileMetadataDTO.getName()),
                        FilePO::getFileName,
                        fileMetadataDTO.getName())
                .set(
                        Objects.nonNull(fileMetadataDTO.getSize()),
                        FilePO::getFileSize,
                        fileMetadataDTO.getSize())
                .eq(FilePO::getId, fileMetadataDTO.getId())
                .update();
        return getById(fileMetadataDTO.getId()).orElseGet(FilePO::new);
    }

    private String getBucketName(boolean publicRead) {
        return publicRead ? fileUploadProperties.getExtra().getPublicBucketName()
                : fileUploadProperties.getBucketName();
    }
}
