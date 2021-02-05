package com.atr.excelspringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.atr.excelspringboot.model.Employee;

@Service
public class EmployeeService {
	
	public List<Employee> getAllEmployees(){
		List<Employee> employee = new ArrayList<Employee>();
		employee.add(new Employee(1, "Ahmed", "Al Salih", "a.alsalih2@gmail.com"));
		employee.add(new Employee(2, "Omar", "Al Salih", "o.alsalih2@gmail.com"));
		employee.add(new Employee(3, "Abdul Rahman", "Al Salih", "x@gmail.com"));
		employee.add(new Employee(4, "Mohammed", "Al Salih", "x@gmail.com"));
		return employee;
		
	}

}
