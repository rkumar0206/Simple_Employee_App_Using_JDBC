package com.rohitthebest.model;

public class Employee {

	private String name;
	private long employeeNo;
	private double salary;
	
	public Employee(String name, long employeeNo, double salary) {
		
		this.name = name;
		this.employeeNo = employeeNo;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", employeeNo=" + employeeNo + ", salary=" + salary + "]";
	}

}
