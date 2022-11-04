package com.practice.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.poc.model.Employee;
import com.practice.poc.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmpById(int employeeId) {
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		if (empOptional.isPresent()) {
			return empOptional.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Employee> getAllEmps(){
		
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee addEmp(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmp(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee deleteEmp(int employeeId) {
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		if (empOptional.isPresent()) {
			Employee emp = empOptional.get();
			employeeRepository.delete(emp);
			return emp;
		} else {
			return null;
		}

	}
}
