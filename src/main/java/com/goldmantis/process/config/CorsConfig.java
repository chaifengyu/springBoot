package com.goldmantis.process.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//@Configuration
public class CorsConfig {
	
	private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://www.jtljia.com"); // 1
        corsConfiguration.addAllowedHeader("Content-Type"); // 2
        corsConfiguration.addAllowedMethod("GET"); // 3
        corsConfiguration.addAllowedMethod("POST"); // 3
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }
}
