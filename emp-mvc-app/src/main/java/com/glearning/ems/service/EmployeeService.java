package com.glearning.ems.service;

import java.util.List;

import com.glearning.ems.model.Employee;

public interface EmployeeService {

	List<Employee> viewAllEmployee();

	Employee saveEmployee(Employee employee);

	Employee findbyid(long id);

	Employee updateEmployee(long id, Employee employee);

	void deletebyId(long id);
//	public employee saveEmployee(employee employee);

}
