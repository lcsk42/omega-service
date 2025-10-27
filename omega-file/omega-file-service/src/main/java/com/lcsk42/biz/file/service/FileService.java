package com.lcsk42.biz.file.service;

import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.biz.file.model.dto.FileMetadataDTO;
import com.lcsk42.biz.file.model.po.FilePO;
import com.lcsk42.biz.file.model.vo.FileVO;
import com.lcsk42.frameworks.starter.database.mybatisplus.service.IService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.List;

public interface FileService extends IService<FilePO> {

    FileVO upload(MultipartFile file,
            BizSourceEnum bizSource,
            Boolean publicRead,
            String batchId,
            Long id,
            String fileName);

    FileVO uploadTempFile(MultipartFile file, String batchId);

    List<FileVO> listByBatchId(String batchId);

    FileVO getById(Long id);

    void deleteById(Long id);

    void deleteByBatchId(String batchId);

    void download(Long id, HttpServletResponse response);

    URL generatePreSignedDownloadUrl(Long id);

    URL generatePreSignedUploadUrl(BizSourceEnum bizSource, Boolean publicRead, String batchId,
            Long id, String fileName);

    void updateFileMetadata(FileMetadataDTO fileMetadataDTO);
}
