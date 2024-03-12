package com.assignments.udemy.stream.udemy;

import lombok.Data;

@Data
public class Bike {

	private String name;
	private String model;

	public Bike() {

	}

	public Bike(String name, String model) {
		this.name = name;
		this.model = model;
	}

	@Override
	public String toString() {
		return "Bike{" + "name='" + name + '\'' + ", model='" + model + '\''
				+ '}';
	}
}
