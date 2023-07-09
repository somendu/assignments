package com.glearning.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.ems.model.Employee;
import com.glearning.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> viewAllEmployee() {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
		return employeeList;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		System.out.println("Saving");
		return this.employeeRepository.save(employee);
	}

	@Override
	public Employee findbyid(long id) {

		return this.employeeRepository.findById(id).orElseThrow();
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {

		Optional<Employee> findById = this.employeeRepository.findById(id);
		if (findById.isPresent()) {
			Employee employee2 = findById.get();
			employee.setFirstName(employee2.getFirstName());
			employee.setFirstName(employee.getLastName());
			employee.setEmail(employee.getEmail());

			employeeRepository.save(employee2);
		}
		return employee;
	}

	@Override
	public void deletebyId(long id) {

		this.employeeRepository.deleteById(id);

	}

}
