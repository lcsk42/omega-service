package com.lcsk42.biz.file.client.fallback;

import com.lcsk42.biz.file.client.FileClient;
import com.lcsk42.biz.file.common.enums.BizSourceEnum;
import com.lcsk42.biz.file.model.dto.FileMetadataDTO;
import com.lcsk42.biz.file.model.po.FilePO;
import com.lcsk42.biz.file.model.vo.FileVO;
import feign.Response;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class FileClientFallbackFactory implements FallbackFactory<FileClient> {
    @Override
    public FileClient create(Throwable cause) {
        return new FileClient() {
            @Override
            public FileVO upload(MultipartFile file, BizSourceEnum bizSource, Boolean publicRead,
                    String batchId, Long id, String name) {
                return new FileVO();
            }

            @Override
            public Response download(Long id) {
                return null;
            }

            @Override
            public URL generatePreSignedDownloadUrl(Long id, Duration signatureDuration) {
                return null;
            }

            @Override
            public FileVO getById(Long id) {
                return new FileVO();
            }

            @Override
            public List<FileVO> listByBatchId(String batchId) {
                return List.of();
            }

            @Override
            public Boolean deleteById(Long id) {
                return Boolean.FALSE;
            }

            @Override
            public Boolean deleteByBatchId(String batchId) {
                return Boolean.FALSE;
            }

            @Override
            public URL generatePreSignedUploadUrl(BizSourceEnum bizSource, Boolean publicRead,
                    String batchId, Long id, String name, Duration signatureDuration) {
                return null;
            }

            @Override
            public FilePO updateFileMetadata(FileMetadataDTO fileMetadataDTO) {
                return new FilePO();
            }
        };
    }
}
