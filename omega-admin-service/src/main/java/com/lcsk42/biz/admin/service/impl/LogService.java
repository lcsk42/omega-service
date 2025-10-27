package com.lcsk42.biz.admin.service.impl;

import com.lcsk42.frameworks.starter.log.core.model.LogRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogService implements com.lcsk42.frameworks.starter.log.core.service.LogService {

    @Async
    @Override
    public void handle(LogRecord logRecord) {
        log.info("LogServiceImpl: {}", logRecord);
    }
}
