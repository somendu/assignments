/**
 * 
 */
package com.assignments.stream;

import lombok.Data;

/**
 * @author Somendu
 *
 * @since 12-Sep-2020
 */

@Data
public class Employee {

	public int empId;
	public String firstName;
	public int age;
	public double salary;

	public Employee(int empId, String firstName, int age, double salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.age = age;
		this.salary = salary;
	}

}
