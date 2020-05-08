package com.atr.excelspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atr.excelspringboot.model.Employee;
import com.atr.excelspringboot.repository.EmployeeRepository;

@RestController
public class RestServiceController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/api")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

}
