package com.glearning.ems.service;

import java.util.List;

import com.glearning.ems.model.Employee;

/**
 * 
 * Employee Service Interface
 * 
 * @author Aditi Awasthi
 *
 * @since 05-Aug-2023
 */
public interface EmployeeService {

	public Employee createEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long id);

	public Employee updateEmployee(Employee employee, long id);

	public void deleteEmployee(Long id);

	public List<Employee> searchEmployeesByFirstName(String firstName);

	public List<Employee> getAllEmployeesSortedByFirstName(String order);

}
