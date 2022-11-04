package com.practice.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.poc.model.Employee;
import com.practice.poc.service.EmployeeService;



@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/get-employee-by-id/{eid}") // 101
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "eid") int employeeId) {
	
		Employee emp = service.getEmpById(employeeId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee " + employeeId + " was found successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/get-all-employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		
		List<Employee> empList = service.getAllEmps();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employees were found successfully.");
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(empList, headers, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/add-employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		
		Employee emp = service.addEmp(employee);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee " + emp.getEmpId() + " was created successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/update-employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee emp = service.updateEmp(employee);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee " + emp.getEmpId() + " was updated successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/delete-employee/{eid}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(name = "eid") int employeeId) {
		Employee emp = service.deleteEmp(employeeId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee " + employeeId + " was deleted successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}
}
