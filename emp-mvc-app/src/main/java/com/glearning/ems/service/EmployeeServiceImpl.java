package com.glearning.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.ems.model.Employee;
import com.glearning.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeerepo;

	@Override
	public List<Employee> viewAllEmployee() {
		// TODO Auto-generated method stub
		return this.employeerepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Saving");
		return this.employeerepo.save(employee);
	}

	@Override
	public Employee findbyid(long id) {
		// TODO Auto-generated method stub
		return this.employeerepo.findById(id).orElseThrow();
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> findById = this.employeerepo.findById(id);
		if (findById.isPresent()) {
			Employee employee2 = findById.get();
			employee.setFirstName(employee2.getFirstName());
			employee.setFirstName(employee.getLastName());
			employee.setEmail(employee.getEmail());

			employeerepo.save(employee2);
		}
		return employee;
	}

	@Override
	public void deletebyId(long id) {
		// TODO Auto-generated method stub
		this.employeerepo.deleteById(id);

	}

}
