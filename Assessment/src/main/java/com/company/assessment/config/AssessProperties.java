/**
 * 
 */
package com.company.assessment.config;

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
@ConfigurationProperties(prefix = "asses.api")
public class AssessProperties {

	private String server;
	private String port;
	private String shipments;
	private String track;
	private String pricing;

}
