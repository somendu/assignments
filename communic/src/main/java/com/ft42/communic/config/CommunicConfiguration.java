package com.ft42.communic.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

/**
 * Configuring required beans if any
 * 
 * @author somendu
 *
 */
@Configuration
@EnableAsync
@EnableAspectJAutoProxy
public class CommunicConfiguration {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {

		RestTemplate restTemplate = restTemplateBuilder.basicAuthentication("testclient", "OxYcool@123").build();

		return restTemplate;
	}

}
