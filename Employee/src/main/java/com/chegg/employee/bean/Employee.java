package com.chegg.employee.bean;

import lombok.Data;

@Data
public class Employee {
	private String name;
	private double salary;
	private String department;
	private String gender;

	public Employee() {

	}

	/**
	 * @param name
	 * @param salary
	 * @param department
	 * @param gender
	 */
	public Employee(String name, double salary, String department,
			String gender) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", department="
				+ department + ", gender=" + gender + "]";
	}

}
