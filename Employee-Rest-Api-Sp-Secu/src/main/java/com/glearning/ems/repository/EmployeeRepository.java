package com.glearning.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.ems.model.Employee;

/**
 * 
 * Employee Repository
 * 
 * @author Aditi Awasthi
 *
 * @since 05-Aug-2023
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByFirstNameContainingIgnoreCase(String firstName);

	List<Employee> findAllByOrderByFirstNameAsc();

	List<Employee> findAllByOrderByFirstNameDesc();

}
