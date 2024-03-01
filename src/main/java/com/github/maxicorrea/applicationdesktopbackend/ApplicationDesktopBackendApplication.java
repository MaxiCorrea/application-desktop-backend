package com.github.maxicorrea.applicationdesktopbackend;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class ApplicationDesktopBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationDesktopBackendApplication.class, args);
  }

  @Value("${spring.application.version}")
  private String applicationVersion;

  @Bean
  public OpenAPI apiInfo() {
    return new OpenAPI().info(new Info().title("Application Desktop Backend")
        .description("Application Desktop Documentation").version(applicationVersion));
  }

  @Bean
  public GroupedOpenApi httpApi() {
    return GroupedOpenApi.builder().group("http").pathsToMatch("/**").build();
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
      }
    };
  }

}
