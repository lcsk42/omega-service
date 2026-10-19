package com.lcsk42.biz.file.service;

import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.biz.file.model.dto.FileMetadataDTO;
import com.lcsk42.biz.file.model.po.FilePO;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.IService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public interface FileService extends IService<FilePO> {

    FilePO upload(MultipartFile file,
                  BizSourceEnum bizSource,
                  Boolean publicRead,
                  String batchId,
                  Long id,
                  String fileName);

    FilePO uploadTempFile(MultipartFile file, String batchId);

    Optional<FilePO> getById(Long id);

    List<FilePO> listByBatchId(String batchId);

    Boolean deleteById(Long id);

    Boolean deleteByBatchId(String batchId);

    void download(Long id, HttpServletResponse response);

    URL generatePreSignedDownloadUrl(Long id, Duration signatureDuration);

    URL generatePreSignedUploadUrl(BizSourceEnum bizSource, Boolean publicRead, String batchId,
                                   Long id, String fileName, Duration signatureDuration);

    FilePO updateFileMetadata(FileMetadataDTO fileMetadataDTO);
}
