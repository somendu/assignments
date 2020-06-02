/**
 * 
 */
package com.ft42.communic;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * Application starting class
 * 
 * @author somendu
 *
 */
@SpringBootApplication
@EnableCaching
@EnableSwagger2
@EnableScheduling
@ComponentScan({ "com.ft42.communic" })
public class MainApplication extends SpringBootServletInitializer {

	private static Class<MainApplication> application = MainApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(application, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(application);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.company")).build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(

				"Asses API", "Program for Assessment", "1.0", "Free to Use",
				new springfox.documentation.service.Contact("Somendu", "http://www.somendumaiti.com",
						"somendu.maiti@gmail.com"),
				"Free License", "http://www.somendumaiti.com", Collections.emptyList());
	}

}
