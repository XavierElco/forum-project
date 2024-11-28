package com.xav.codeproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {
    @Bean
    public SimpleDateFormat simpleDateFormate() {
        return new SimpleDateFormat("yyyy-mm-dd");


    }
}
