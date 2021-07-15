package com.lijinlin.project.config;

import com.lijinlin.project.config.interceptor.ReactInterceptor;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@JsonComponent
public class ReactWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ReactInterceptor()) // 拦截器要拦截的url规则
                .addPathPatterns("/**")
                // 拦截器屏蔽的url规则
                .excludePathPatterns("/**/remoteHessian.do_", "/error", "/index.html", "/static/**", "/**/callBack", "/**/**/callBack",
                        "/swagger-ui.html", "/swagger-resources/**", "/swagger-resources/**", "/webjars/**")

                // 拦截器的执行顺序
                .order(1);
    }
}
