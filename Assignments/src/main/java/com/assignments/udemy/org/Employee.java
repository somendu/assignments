/**
 * 
 */
package com.assignments.udemy.org;

import lombok.Data;

/**
 * @author Somendu
 *
 * @since 05-Sep-2020
 */
@Data
public class Employee extends Person implements Payable {

	private int salary;

	@Override
	public double raiseSalary(double percentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
