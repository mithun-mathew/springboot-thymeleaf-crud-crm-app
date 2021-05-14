package net.mithunmathew.springbootthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.mithunmathew.springbootthymeleaf.entity.Employee;
import net.mithunmathew.springbootthymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// retrieve from db
		List<Employee> employees = employeeService.findAll();
		
		// add employees to the Spring MVC model
		theModel.addAttribute("employees", employees);
		
		return "employee-list";
	}
}
