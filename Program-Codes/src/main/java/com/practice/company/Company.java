/**
 * 
 */
package com.practice.company;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 27-Jul-2023
 */
@Component
@Data
public class Company {

	private String companyName;

	private Address address;

	public Company(Address address) {
		this.address = address;
	}

}
