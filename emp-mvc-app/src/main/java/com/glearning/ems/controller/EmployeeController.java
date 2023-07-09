package com.glearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.ems.model.Employee;
import com.glearning.ems.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@GetMapping("/listEmployees")
	public String viewallEmployees(Model model) {
		System.out.println("View All ");
		List<Employee> viewallEmployees = this.employeeservice.viewAllEmployee();
		model.addAttribute("viewallEmployees", viewallEmployees);
		return "employee/list-employees";

	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		this.employeeservice.saveEmployee(employee);
		System.out.println(employee);
		return "redirect:/employees/listEmployees";

	}
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Employee foundEmployee = employeeservice.findbyid(id);
		model.addAttribute("employee", foundEmployee);
		return "employee/employee-form";
	}

	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(Model model, @RequestParam("id") long id, Employee employee) {
		Employee updateEmployee = this.employeeservice.updateEmployee(id, employee);
		model.addAttribute("updateEmployee", updateEmployee);
		return "";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		System.out.println(employee.toString());
		return "employee/employee-form";
	}
}