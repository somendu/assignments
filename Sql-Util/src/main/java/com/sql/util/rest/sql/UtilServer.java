package com.sql.util.rest.sql;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * Entry point for customer service
 * 
 * @author Somendu
 * @since Apr 2, 2020
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
public class UtilServer {

	protected Logger logger = Logger.getLogger(UtilServer.class.getName());

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "util-server");

		SpringApplication.run(UtilServer.class, args);
	}

}
