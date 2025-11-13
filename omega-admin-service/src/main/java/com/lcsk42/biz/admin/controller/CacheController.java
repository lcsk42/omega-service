package com.lcsk42.biz.admin.controller;

import com.lcsk42.frameworks.starter.cache.core.Cache;
import com.lcsk42.frameworks.starter.cache.core.util.CacheUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "CacheController")
@RequestMapping("/cache")
@RequiredArgsConstructor
public class CacheController {

    private final Cache cache;

    private static final String INCR_KEY = CacheUtil.buildKey("cache", "incr");

    @PostMapping
    public Long incr() {
        return cache.incr(INCR_KEY);
    }

    @GetMapping
    public Long get() {
        return cache.get(INCR_KEY, Long.class);
    }

    @DeleteMapping
    public boolean delete() {
        return cache.delete(INCR_KEY);
    }
}
