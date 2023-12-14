package com.glearning.ems.util;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.glearning.ems.model.Employee;
import com.glearning.ems.repository.EmployeeRepository;

/**
 * 
 * Employee Data Configuration
 * 
 * @author Aditi Awasthi
 *
 * @since 05-Aug-2023
 */
@Configuration
public class EmployeeData {

	@Autowired
	private EmployeeRepository employeeRepository;

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadEmployees(ApplicationReadyEvent event) {

		Employee employeeOne = new Employee();
		employeeOne.setFirstName("Aditi");
		employeeOne.setLastName("Awasthi");
		employeeOne.setEmail("aditi@gmail.com");

		Employee employeeTwo = new Employee();
		employeeTwo.setFirstName("Somendu");
		employeeTwo.setLastName("Maiti");
		employeeTwo.setEmail("somendu@gmail.com");

		Employee employeeThree = new Employee();
		employeeThree.setFirstName("Rahul");
		employeeThree.setLastName("Saxena");
		employeeThree.setEmail("rahul@gmail.com");

		Employee employeeFour = new Employee();
		employeeFour.setFirstName("Ramesh");
		employeeFour.setLastName("Tiwari");
		employeeFour.setEmail("ramesh@gmail.com");

		employeeRepository.save(employeeOne);
		employeeRepository.save(employeeTwo);
		employeeRepository.save(employeeThree);
		employeeRepository.save(employeeFour);

	}

}
