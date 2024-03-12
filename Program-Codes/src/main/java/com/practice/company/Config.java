/**
 * 
 */
package com.practice.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 27-Jul-2023
 */
@Configuration
@ComponentScan(basePackageClasses = Company.class)
public class Config {

	@Bean
	public Address getAddress() {
		return new Address("High Street", 1000);
	}
}
