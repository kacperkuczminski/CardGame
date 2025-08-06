package com.piwnicastudio.uno.configuration;

import org.hibernate.annotations.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ConcurrentMapCache playersCache = new ConcurrentMapCache("players");
        cacheManager.setCaches(List.of(playersCache));
        return cacheManager;
    }
}
