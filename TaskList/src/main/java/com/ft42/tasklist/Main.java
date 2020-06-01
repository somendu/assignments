package com.ft42.tasklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Entry Point Class
 * 
 * @author admin
 *
 */
@SpringBootApplication
@EnableCaching
public class Main {
	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
	}
}
