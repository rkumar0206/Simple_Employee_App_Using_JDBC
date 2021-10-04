package com.rohitthebest.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.rohitthebest.model.Employee;

public class EmployeeUtil {

	private ArrayList<Employee> employees;

	public EmployeeUtil() {
		super();

		employees = new ArrayList<Employee>();
	}

	public boolean addEmployee(Employee employee) {

		if (findEmployee(employee.getEmployeeNo()) == null) {

			employees.add(employee);
			return true;
		} else {

			System.out.println("Employee already exists");
			return false;
		}
	}

	public boolean deleteEmployeeByEmployeeNumber(long employeeNo) {

		Employee employee = findEmployee(employeeNo);

		if (employee != null) {

			employees.remove(employee);
			return true;
		}

		return false;
	}

	public Employee findEmployee(long employeeNo) {

		for (Employee emp : employees) {

			if (emp.getEmployeeNo() == employeeNo) {

				return emp;
			}
		}

		return null;
	}

	public List<Employee> findEmployee(String employeeName) {

		List<Employee> employeeList = new ArrayList<Employee>();

		for (Employee emp : employees) {

			if (emp.getName().equals(employeeName)) {

				employeeList.add(emp);
			}
		}

		return employeeList;
	}

	public void sortEmployees(EmployeeSort sortMethod, boolean inAscendingOrder) {

		switch (sortMethod) {

		case SORT_BY_NAME: {

			// Collections.sort(employees, Comparator.comparing(Employee::getName));

			if (inAscendingOrder) {

				employees.sort(Comparator.comparing(Employee::getName));

			} else {

				employees.sort(Comparator.comparing(Employee::getName).reversed());

				// Collections.reverse(employees);
			}

		}
			break;

		case SORT_BY_SALARY: {

			// Collections.sort(employees, Comparator.comparing(Employee::getSalary));

			if (inAscendingOrder) {

				employees.sort(Comparator.comparing(Employee::getSalary));
			} else {

				employees.sort(Comparator.comparing(Employee::getSalary).reversed());
				// Collections.reverse(employees);
			}
		}
			break;

		
		case SORT_BY_NAME_THEN_SALARY: {
			
			Comparator<Employee> employeeComparator = 
					Comparator.comparing(
							Employee::getName
					).thenComparing(Employee::getSalary);
			
			if (inAscendingOrder) {
				
				employees.sort(employeeComparator);
			} else {
				
				employees.sort(employeeComparator.reversed());
			}
		}
		break;
		
		
		case SORT_BY_SALARY_THEN_NAME: {
			
			Comparator<Employee> employeeComparator = 
					Comparator.comparing(
							Employee::getSalary
							).thenComparing(Employee::getName);
			
			if (inAscendingOrder) {
				
				employees.sort(employeeComparator);
			} else {
				
				employees.sort(employeeComparator.reversed());
			}
		}
		break;
		
		default:
			break;

		}
	}

	public boolean exportEmployessAsTxtFile(String basePath, String fileName) {
		
		if (employees.isEmpty()) {
			
			System.out.println("Please add some employees....");
			return false;
		}
		
		try(BufferedWriter writer = 
				new BufferedWriter(new FileWriter(basePath + fileName + ".txt"))) {
			
			writer.write("Employee No.\t\tName\t\tSalary\n");
			
			for(Employee emp : employees) {
				
				String str = emp.getEmployeeNo() + "\t\t" + emp.getName() + "\t\t" + emp.getSalary();
				
				writer.write(str + "\n");
				
			}
			
			writer.flush();

			
			return true;
		}catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void printEmployee() {

		employees.forEach(e -> System.out.println(e.toString()));
	}

}
