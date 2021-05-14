package net.mithunmathew.springbootthymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.mithunmathew.springbootthymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
