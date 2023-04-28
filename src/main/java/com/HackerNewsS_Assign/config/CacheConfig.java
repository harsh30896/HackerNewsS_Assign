package com.HackerNewsS_Assign.config;
import org.springframework.cache.CacheManager;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager getCacheManager(){
    ConcurrentMapCacheManager concurrentMapCacheManager = new ConcurrentMapCacheManager();
    concurrentMapCacheManager.setCacheNames(asList("storyInfo"));
    return concurrentMapCacheManager;
    }

private List<String> asList(String... keys){
    return Arrays.asList(keys);
    }
}
