/**
 * 
 */
package com.company.searchtext.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Mar 31, 2020
 */
@Configuration
public class DatasourceConfig {

	@Bean
	public DataSource datasource() {
		return DataSourceBuilder.create().driverClassName("oracle.jdbc.driver.OracleDriver")
				.url("jdbc:oracle:thin:@localhost:1521:xeher").username("hr").password("hr123").build();
	}
}
