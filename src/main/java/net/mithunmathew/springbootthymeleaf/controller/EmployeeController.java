package net.mithunmathew.springbootthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "employees/employee-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save to db
		employeeService.save(theEmployee);
		
		// redirect to listing page
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormforUpdate")
	public String showFormforUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		// get the concerned employee
		Employee theEmployee = employeeService.findById(theId);
		
		// pre-populate form using this received value
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the employee
		employeeService.deleteById(theId);
		
		// redirect to listing page
		return "redirect:/employees/list";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("employeeName") String theName, Model theModel) {
		
		// search for the given string
		List<Employee> theEmployees = employeeService.searchBy(theName);
		
		// add to the model
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/employee-list";
	}
}
