package com.chegg.employee.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chegg.employee.bean.Employee;
import com.chegg.employee.bean.EmployeeDataBase;

/**
 * 
 * @author Somendu
 *
 * @since 21-Jul-2020
 */
@RestController
@RequestMapping("/api")
public class MainController {
	/**
	 * Simple REST method without params
	 * 
	 * @return String representing the greeting
	 * @throws IOException
	 */
	@RequestMapping(value = "/showInfo/{employeeName}", method = RequestMethod.GET)
	public Employee showInfo(@PathVariable String employeeName) {

		List<Employee> employeeList = EmployeeDataBase.getAllEmployees()
				.stream()
				.filter(employee -> employee.getName()
						.equalsIgnoreCase(employeeName))
				.collect(Collectors.toList());

		return employeeList.get(0);
	}

	@RequestMapping(value = "/sortbySalary", method = RequestMethod.GET)
	public List<Employee> sortbySalary() {

		List<Employee> employeeList = EmployeeDataBase.getAllEmployees()
				.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());

		// TODO Similar APi can be made using comparator for sorting by name,
		// gender etc
		return employeeList;
	}

	@RequestMapping(value = "/sortbySalaryGender", method = RequestMethod.GET)
	public List<Employee> sortbySalaryGender() {

		// Double comparison First is salary and then Gender

		List<Employee> employeeList = EmployeeDataBase.getAllEmployees()
				.stream()
				.sorted(Comparator.comparing(Employee::getSalary)
						.thenComparing(Employee::getGender))
				.collect(Collectors.toList());

		return employeeList;
	}

	@RequestMapping(value = "/salaryTotalByGender/{gender}", method = RequestMethod.GET)
	public double salaryCalculateByGender(@PathVariable String gender) {

		// Double comparison

		double salaryTotal = EmployeeDataBase.getAllEmployees().stream().filter(
				employee -> employee.getGender().equalsIgnoreCase(gender))

				.map(Employee::getSalary)

				.reduce(0.0, Double::sum);

		return salaryTotal;
	}

}
