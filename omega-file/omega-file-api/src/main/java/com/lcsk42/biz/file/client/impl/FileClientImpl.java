package com.lcsk42.biz.file.client.impl;

import com.lcsk42.biz.file.client.FileClient;
import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.biz.file.model.dto.FileMetadataDTO;
import com.lcsk42.biz.file.model.vo.FileVO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

public class FileClientImpl implements FileClient {
    @Override
    public FileVO upload(MultipartFile file, BizSourceEnum bizSource, Boolean publicRead,
            String batchId, Long id, String name) {
        return null;
    }

    @Override
    public void download(Long id, HttpServletResponse response) {}

    @Override
    public URL generatePreSignedDownloadUrl(Long id) {
        return null;
    }

    @Override
    public URL generatePreSignedUploadUrl(BizSourceEnum bizSource, Boolean publicRead,
            String batchId, Long id, String name) {
        return null;
    }

    @Override
    public void updateFileMetadata(FileMetadataDTO fileMetadataDTO) {

    }

    @Override
    public FileVO mockUpload() {
        FileVO fileVO = new FileVO();
        fileVO.setId(0L);
        return fileVO;
    }
}
