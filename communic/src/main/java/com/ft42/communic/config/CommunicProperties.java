/**
 * 
 */
package com.ft42.communic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * Config for end points
 * 
 * @author somendu
 *
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "communic.api")
public class CommunicProperties {

	private String server;
	private String port;
	private String emailService;
	private String smsService;

}
