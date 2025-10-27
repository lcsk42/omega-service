package com.lcsk42.biz.file.model.convert;

import com.lcsk42.biz.file.model.po.FilePO;
import com.lcsk42.biz.file.model.vo.FileVO;
import com.lcsk42.frameworks.starter.common.convert.BiConverter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileConverter extends BiConverter<FilePO, FileVO> {
    FileConverter INSTANCE = Mappers.getMapper(FileConverter.class);
}
