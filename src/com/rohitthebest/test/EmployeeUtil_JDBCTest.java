package com.rohitthebest.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.rohitthebest.model.Employee;
import com.rohitthebest.util.EmployeeSort;
import com.rohitthebest.util.EmployeeUtil_JDBC;

class EmployeeUtil_JDBCTest {

	EmployeeUtil_JDBC employeeUtil = null;

	public EmployeeUtil_JDBCTest() {

		try {

			employeeUtil = new EmployeeUtil_JDBC();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Test
	void testEmployee_insert_find_delete() {

		try {

			employeeUtil.addEmployee(new Employee("Test", 563828, 63555));

			Employee emp = employeeUtil.findEmployee(563828);

			if (emp == null) {

				fail();
			} else {

				assertEquals(emp.getEmployeeNo(), 563828);
			}

			employeeUtil.deleteEmployeeByEmployeeNumber(563828);

			Employee employee = employeeUtil.findEmployee(563828);

			if (employee != null) {

				// employee object is not deleted
				fail();
			}

		} catch (SQLException e) {
			fail();
			e.printStackTrace();
		}

	}

	@Test
	void test_updateEmployee() {

		try {

			employeeUtil.addEmployee(new Employee("Test", 563828, 63555));

			// checking if it updates employee with employeeNo not existing in the database

			boolean b = employeeUtil.updateEmployee(new Employee("Test2", 563827, 63555));

			if (b) {

				fail();
			}

			boolean b1 = employeeUtil.updateEmployee(new Employee("Test2", 563828, 635875));

			if (!b1) {

				fail();
			} else {

				Employee emp = employeeUtil.findEmployee(563828);
				assertEquals(emp.getName(), "Test2");

				// deleting the test employee

				employeeUtil.deleteEmployeeByEmployeeNumber(563828);
			}

		} catch (SQLException e) {

			fail();
			e.printStackTrace();
		}
	}

	@Test
	void test_getAllEmployee() {

		try {

			employeeUtil.addEmployee(new Employee("Test1", 564828, 15000));

			employeeUtil.addEmployee(new Employee("Test2", 565828, 18000));

			List<Employee> eList = employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_NAME, true);

			if (eList.isEmpty()) {

				fail();
			}

			eList = employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_NAME, false);

			if (eList.isEmpty()) {

				fail();
			}
			
			eList = employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_SALARY, true);
			
			if (eList.isEmpty()) {
				
				fail();
			}
			
			eList = employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_SALARY, false);
			
			if (eList.isEmpty()) {
				
				fail();
			}
			
			eList = employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_NAME_THEN_SALARY, true);
			
			if (eList.isEmpty()) {
				
				fail();
			}
			
			eList = employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_NAME_THEN_SALARY, false);
			
			if (eList.isEmpty()) {
				
				fail();
			}
			
			eList = employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_SALARY_THEN_NAME, true);
			
			if (eList.isEmpty()) {
				
				fail();
			}
			
			eList = employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_SALARY_THEN_NAME, false);
			
			if (eList.isEmpty()) {
				
				fail();
			}

			// deleting the employees
			
			employeeUtil.deleteEmployeeByEmployeeNumber(564828);
			employeeUtil.deleteEmployeeByEmployeeNumber(565828);

		} catch (SQLException e) {

			fail();
			e.printStackTrace();
		}

	}

}
