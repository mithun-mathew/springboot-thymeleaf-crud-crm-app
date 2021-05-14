package net.mithunmathew.springbootthymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.mithunmathew.springbootthymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// auto generate code to operate on DB
	
	// sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();

}
