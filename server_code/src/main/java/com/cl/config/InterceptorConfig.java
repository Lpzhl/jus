package com.cl.config;

import com.cl.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;



@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

            @Bean
        public AuthorizationInterceptor getAuthorizationInterceptor() {
            return new AuthorizationInterceptor();
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
            super.addInterceptors(registry);
        }
    
    /**
     * springboot 2.0配置WebMvcConfigurationSupport之后，会导致默认配置被覆盖，要访问静态资源需要重写addResourceHandlers方法
     *
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");

        registry.addResourceHandler("/manage/**")
                .addResourceLocations("classpath:/manage/");

        registry.addResourceHandler("/client/**")
                .addResourceLocations("classpath:/client/");

        registry.addResourceHandler("/client-pc/**")
                .addResourceLocations("classpath:/client-pc/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(3600);
    }
}
