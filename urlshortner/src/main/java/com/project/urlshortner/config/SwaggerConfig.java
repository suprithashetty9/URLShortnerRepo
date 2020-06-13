package com.project.urlshortner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.project.urlshortner")).paths(PathSelectors.any()).build()
				.useDefaultResponseMessages(false).apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("URL Shortner API").description(
				"API for short URL creation, implementation for forwarding URL to original ones with persistent storage")
				.title("URL Shortner Assessment")
				.description("A URL Shortner application to shorten the URL, which redirects to original one, showing the stored statistics")
				.licenseUrl("Spring Boot")
				.version("1.0.0").build();
	}
}
