import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.rohitthebest.model.Employee;
import com.rohitthebest.util.EmployeeSort;
import com.rohitthebest.util.EmployeeUtil_JDBC;

public class Application_JDBC {

	public static void main(String[] args) {

		try {
			
			
			EmployeeUtil_JDBC employeeUtil = new EmployeeUtil_JDBC();
			
			//populateEmployeesDatabase(employeeUtil);
			
//			Employee employee = new Employee("Rohit", 4008878, 10500.0);
//			
//			if (employeeUtil.addEmployee(employee)) {
//				
//				System.out.println("Employee inserted to the database");
//			}else {
//				
//				System.out.println("Something went wrong!!!");
//			}
//			
			//System.out.println(employeeUtil.findEmployee("Mohit"));
			
			//employeeUtil.printEmployee(employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_NAME, false));
			//employeeUtil.printEmployee(employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_SALARY, false));
			//employeeUtil.printEmployee(employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_NAME_THEN_SALARY, false));
			//employeeUtil.printEmployee(employeeUtil.getAllEmployeeBySorting(EmployeeSort.SORT_BY_SALARY_THEN_NAME, false));
			

//			if (employeeUtil.exportEmployessAsTxtFile("R:\\", "employee_detail_1")) {
//
//				System.out.println("File successfully exported");
//			}
			
//			if (employeeUtil.updateEmployee(new Employee("Raj", 40088026, 40000))) {
//				
//				System.out.println("Employee updated");
//			}
			
//			if (employeeUtil.deleteAllEmployee()) {
//				
//				System.out.println("Deleted all employees");
//			}else {
//				
//				System.out.println("Something went wrong");
//			}
//			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void populateEmployeesDatabase(EmployeeUtil_JDBC employeeUtil) {

		try {
			employeeUtil.addEmployee(new Employee("Mohit", 400448026, 16000.0));
			employeeUtil.addEmployee(new Employee("Sagar", 22088026, 11000.0));
			employeeUtil.addEmployee(new Employee("John", 40044026, 13000.0));
			employeeUtil.addEmployee(new Employee("Valan", 40085626, 155000.0));
			employeeUtil.addEmployee(new Employee("Nidhi", 40085066, 15200.0));
			employeeUtil.addEmployee(new Employee("Shubham", 46688026, 11000.0));
			employeeUtil.addEmployee(new Employee("Suraj", 400458026, 15040.0));
			employeeUtil.addEmployee(new Employee("Saket", 42288026, 15050.0));
			employeeUtil.addEmployee(new Employee("Satyam", 41188026, 25000.0));
			employeeUtil.addEmployee(new Employee("Priya", 11088026, 55000.0));
			employeeUtil.addEmployee(new Employee("Monu", 23088026, 17000.0));
			employeeUtil.addEmployee(new Employee("Siriyansh", 55088026, 18000.0));
			
			System.out.println("Populated employee table");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
