/**
 * 
 */
package com.assignments.self.codeclinic.weather;

import java.util.Date;

import lombok.Data;

/**
 * @author somendu
 *
 */
@Data
public class WeatherEntry {

	Date when;
	float pressure;
	float humidity;

}
