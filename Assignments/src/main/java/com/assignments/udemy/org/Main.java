/**
 * 
 */
package com.assignments.udemy.org;

/**
 * @author Somendu
 *
 * @since 05-Sep-2020
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person p = new Employee();

		p.setFirstName("Here it i");

		Employee e = new Instructor();
		e.getFirstName();
		e.getSalary();

		// System.out.println(((Employee) p).getFirstName());

		String str = e.payNow("test", "test2");

		System.out.println(str);

		// () -> {return "Hello";}

	}

}
