package com.rohitthebest.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.rohitthebest.model.Employee;

public class EmployeeUtil_JDBC {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	public EmployeeUtil_JDBC() throws SQLException {

		String url = "jdbc:mysql://127.0.0.1:3306/employee_database";
		connection = DriverManager.getConnection(url, "rohit", "12345");
	}

	public boolean addEmployee(Employee employee) throws SQLException {

		if (findEmployee(employee.getEmployeeNo()) == null) {

			preparedStatement = connection
					.prepareStatement("INSERT INTO employee_table (employeeNo, name, salary) VALUES (?, ?, ?)");

			preparedStatement.setLong(1, employee.getEmployeeNo());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDouble(3, employee.getSalary());

			if (preparedStatement.executeUpdate() == 1) {

				return true;
			} else {

				return false;
			}

		} else {

			System.out.println("Employee already exists");
			return false;
		}
	}

	public boolean updateEmployee(Employee employee) throws SQLException {

		if (findEmployee(employee.getEmployeeNo()) != null) {

			preparedStatement = connection
					.prepareStatement("UPDATE employee_table SET name=?, salary=? WHERE employeeNo=?");

			preparedStatement.setString(1, employee.getName());
			preparedStatement.setDouble(2, employee.getSalary());
			preparedStatement.setLong(3, employee.getEmployeeNo());

			if (preparedStatement.executeUpdate() == 1) {

				return true;
			} else {

				return false;
			}

		} else {

			System.out.println("Employee does not exists");
			return false;
		}
	}
	
	public boolean deleteEmployeeByEmployeeNumber(long employeeNo) throws SQLException {

		Employee employee = findEmployee(employeeNo);

		if (employee != null) {

			preparedStatement = connection.prepareStatement("DELETE FROM employee_table WHERE employeeNo= ?");

			preparedStatement.setLong(1, employeeNo);

			if (preparedStatement.executeUpdate() == 1) {

				return true;
			} else {

				return false;
			}

		}

		return false;
	}
	
	public boolean deleteAllEmployee() throws SQLException {
		
		preparedStatement = 
				connection.prepareStatement("DELETE FROM employee_table");
		
		if (preparedStatement.executeUpdate() >= 0) {
			
			return true;
		}else {
			
			return false;
		}
	}

	public Employee findEmployee(long employeeNo) throws SQLException {

		preparedStatement = connection.prepareStatement("select * from employee_table where employeeNo=?");

		preparedStatement.setLong(1, employeeNo);

		rs = preparedStatement.executeQuery();

		while (rs.next()) {

			String name = rs.getString("name");
			double salary = rs.getDouble("salary");

			return new Employee(name, employeeNo, salary);
		}

		return null;

	}

	public List<Employee> findEmployee(String employeeName) throws SQLException {

		List<Employee> employeeList = new ArrayList<Employee>();

		preparedStatement = connection.prepareStatement("SELECT * FROM employee_table WHERE name=?");

		preparedStatement.setString(1, employeeName);

		rs = preparedStatement.executeQuery();

		while (rs.next()) {

			Employee e = new Employee(rs.getString("name"), rs.getLong("employeeNo"), rs.getDouble("salary"));

			employeeList.add(e);

		}

		return employeeList;

	}

	public List<Employee> getAllEmployeeBySorting(EmployeeSort sortMethod, boolean inAscendingOrder) throws SQLException {

		List<Employee> employeeList = new ArrayList<Employee>();
		
		switch (sortMethod) {

		case SORT_BY_NAME: {

			if (inAscendingOrder) {

				preparedStatement = connection.prepareStatement("SELECT * FROM employee_table ORDER BY name");

			} else {

				preparedStatement = connection.prepareStatement("SELECT * FROM employee_table ORDER BY name DESC");

			}

		}
			break;

		case SORT_BY_SALARY: {

			if (inAscendingOrder) {

				preparedStatement = connection.prepareStatement("SELECT * FROM employee_table ORDER BY salary");

			} else {

				preparedStatement = connection.prepareStatement("SELECT * FROM employee_table ORDER BY salary DESC");

			}
		}
			break;

		case SORT_BY_NAME_THEN_SALARY: {

			if (inAscendingOrder) {

				preparedStatement = connection.prepareStatement("SELECT * FROM employee_table ORDER BY name, salary");

			} else {

				preparedStatement = connection.prepareStatement("SELECT * FROM employee_table ORDER BY name DESC, salary DESC");

			}
		}
			break;

		case SORT_BY_SALARY_THEN_NAME: {

			if (inAscendingOrder) {

				preparedStatement = connection.prepareStatement("SELECT * FROM employee_table ORDER BY salary, name");

			} else {

				preparedStatement = connection.prepareStatement("SELECT * FROM employee_table ORDER BY salary DESC, name DESC");

			}
		}
			break;

		default:
			break;

		}
		
		rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			
			Employee e = new Employee(rs.getString("name"), rs.getLong("employeeNo"), rs.getDouble("salary"));

			employeeList.add(e);
		}
		
		return employeeList;
	}

	
	public boolean exportEmployessAsTxtFile(String basePath, String fileName) throws SQLException {

		List<Employee> employees = getAllEmployeeBySorting(EmployeeSort.SORT_BY_NAME, true);
		
		if (employees.isEmpty()) {

			System.out.println("Please add some employees....");
			return false;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(basePath + fileName + ".txt"))) {

			writer.write("Employee No.\t\tName\t\tSalary\n");

			for (Employee emp : employees) {

				String str = emp.getEmployeeNo() + "\t\t" + emp.getName() + "\t\t" + emp.getSalary();

				writer.write(str + "\n");

			}

			writer.flush();

			return true;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}

	}

	
	  public void printEmployee(List<Employee> employees) {
	  
	  employees.forEach(e -> System.out.println(e.toString()));
	  
	  }
	 

}
