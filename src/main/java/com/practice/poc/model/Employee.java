package com.practice.poc.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int empId;
	
	@Column(name = "emp_name")
	private String  empName;
	
	@Column(name = "salary")
	private int salary;
	
	@Column(name = "department_name")
	private String departmentName;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, int salary, String departmentName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.departmentName = departmentName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentName, empId, empName, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(departmentName, other.departmentName) && empId == other.empId
				&& Objects.equals(empName, other.empName) && salary == other.salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", departmentName="
				+ departmentName + "]";
	}
	
	
}
