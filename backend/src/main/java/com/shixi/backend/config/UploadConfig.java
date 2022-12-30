package com.shixi.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class UploadConfig {
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
//        return new StandardServletMultipartResolver();
    }

}