package com.practice.company;

import lombok.Data;

@Data
public class Address {

	private String street;
	private int number;

	public Address(String street, int number) {
		this.street = street;
		this.number = number;
	}

}
