package org.logparser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:63342") // Укажите здесь ваш источник
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true); // Если нужно разрешить куки
    }
}
