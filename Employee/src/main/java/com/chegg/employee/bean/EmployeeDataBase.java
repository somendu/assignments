package com.chegg.employee.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class EmployeeDataBase {

	public static Supplier<Employee> EmployeeSupplier = () -> {
		return new Employee("Adam", 2000, "Sales", "male");
	};

	public static Optional<Employee> getOptionalEmployee() {

		Employee Employee = new Employee("Adam", 2000, "Sales", "male");

		return Optional.of(Employee);
	}

	/**
	 * Total of 6 Employees in the database.
	 * 
	 * @return
	 */
	public static List<Employee> getAllEmployees() {

		Employee Employee1 = new Employee("Adam", 6000, "Sales", "male");
		Employee Employee2 = new Employee("Jane", 4000, "HR", "female");

		Employee Employee3 = new Employee("Mark", 3000, "QA", "male");
		Employee Employee4 = new Employee("Rachel", 3000, "Dev", "female");

		Employee Employee5 = new Employee("Joey", 6000, "BA", "male");
		Employee Employee6 = new Employee("Monica", 7000, "PM", "female");

		Employee Employee7 = new Employee("Rafel", 3000, "QA", "male");
		Employee Employee8 = new Employee("Alex", 3000, "Dev", "female");

		Employee Employee9 = new Employee("Michael", 3000, "QA", "male");
		Employee Employee10 = new Employee("Nikita", 3000, "Dev", "female");

		List<Employee> Employees = Arrays.asList(Employee1, Employee2,
				Employee3, Employee4, Employee5, Employee6, Employee7,
				Employee8, Employee9, Employee10);
		return Employees;
	}
}
