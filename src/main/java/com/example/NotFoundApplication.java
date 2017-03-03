package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class NotFoundApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NotFoundApplication.class, args);
	}

	@Configuration
	public static class WebConfig extends WebMvcConfigurerAdapter {

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/404").setViewName("pageNotFound");
		}

		@Bean
		public EmbeddedServletContainerCustomizer containerCustomizer() {
			return (container) -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
					"/404"));
		}
	}
}
