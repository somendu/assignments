package com.glearning.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glearning.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
