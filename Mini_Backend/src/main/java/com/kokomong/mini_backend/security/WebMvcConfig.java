package com.kokomong.mini_backend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer { //연동하기 위한 클래스(프론트랑) //통신할때 허용하는 것.

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") ///뒤에 별은 /뒤에 모든걸 허용
                .allowedOrigins("*")
                .allowedHeaders("*")    //* 모든걸 다 담겠다.
                .exposedHeaders(HttpHeaders.AUTHORIZATION)
                .allowedMethods(    //이 메소드들 허용해줘
                        HttpMethod.GET.name(),
                        HttpMethod.HEAD.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name());
    }
}