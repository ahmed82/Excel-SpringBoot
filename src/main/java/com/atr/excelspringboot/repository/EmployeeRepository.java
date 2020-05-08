package com.atr.excelspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atr.excelspringboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
