package com.company.kalah;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main Application starting point
 * 
 * @author somendu
 *
 */
@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class KalahApplication {

	public static void main(String[] args) {
		SpringApplication.run(KalahApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.search")).build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(

				"Kalh API", "Program for Kalah", "1.0", "Free to Use",
				new springfox.documentation.service.Contact("Somendu", "http://www.somendumaiti.com",
						"somendu.maiti@gmail.com"),
				"Free License", "http://www.somendumaiti.com", Collections.emptyList());
	}
}
