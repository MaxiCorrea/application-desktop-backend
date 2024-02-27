package com.github.maxicorrea.applicationdesktopbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.github.maxicorrea.applicationdesktopbackend.adapters.output.persistense.ApplicationDesktopRepository;
import com.github.maxicorrea.applicationdesktopbackend.adapters.output.persistense.inmemory.ApplicationDesktopInMemoryRepository;


@SpringBootApplication
public class ApplicationDesktopBackendApplication {

	@Bean
	public ApplicationDesktopRepository applicationDesktopRepository() {
		return new ApplicationDesktopInMemoryRepository();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationDesktopBackendApplication.class, args);
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
