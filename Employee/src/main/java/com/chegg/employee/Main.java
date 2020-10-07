package com.chegg.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Entry Point Class
 * 
 * @author Somendu
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
public class Main {
	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
	}
}
