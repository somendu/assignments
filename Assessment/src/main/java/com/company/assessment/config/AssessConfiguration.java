package com.company.assessment.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Configuring required beans if any
 * 
 * @author somendu
 *
 */
@Configuration
@EnableAsync
@EnableAspectJAutoProxy
public class AssessConfiguration {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper om = new ObjectMapper();
		om.disable(Feature.AUTO_CLOSE_TARGET);
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		om.setSerializationInclusion(Include.NON_NULL);
		return om;
	}

	@Bean(name = "shipmentsExecutor")
	public Executor shipmentsExecutor() {

		ThreadPoolTaskExecutor shipmentsTask = new ThreadPoolTaskExecutor();
		shipmentsTask.setCorePoolSize(3);
		shipmentsTask.setMaxPoolSize(3);
		shipmentsTask.setQueueCapacity(100);
		shipmentsTask.setThreadNamePrefix("shipmentsTask-");
		shipmentsTask.initialize();
		return shipmentsTask;
	}

	@Bean(name = "trackExecutor")
	public Executor trackExecutor() {
		ThreadPoolTaskExecutor trackTask = new ThreadPoolTaskExecutor();
		trackTask.setCorePoolSize(3);

		trackTask.setMaxPoolSize(3);
		trackTask.setQueueCapacity(100);
		trackTask.setThreadNamePrefix("trackTask-");
		trackTask.initialize();

		return trackTask;
	}

	@Bean(name = "pricingExecutor")
	public Executor pricingExecutor() {
		ThreadPoolTaskExecutor pricingTask = new ThreadPoolTaskExecutor();
		pricingTask.setCorePoolSize(3);
		pricingTask.setMaxPoolSize(3);
		pricingTask.setQueueCapacity(100);
		pricingTask.setThreadNamePrefix("pricingTask-");
		pricingTask.initialize();
		return pricingTask;
	}

//	/**
//	 * After Every 5 minutes(300000 seconds) interval this method tries to find the
//	 * 60 minutes old game and remove them from map. So, if there is no activity on
//	 * a game last 60 minutes, It will destroy.
//	 */
//	@Scheduled(fixedRate = 5)
//	public void callThread() {
//		log.info("clearing the executors");
//
//		long diff = (System.currentTimeMillis() - startTime);
//
//		if (diff > 5) {
//			pricingExecutor();
//		}
//
//	}
}
