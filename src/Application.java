import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.rohitthebest.model.Employee;
import com.rohitthebest.util.EmployeeSort;
import com.rohitthebest.util.EmployeeUtil;

public class Application {

	public static void main(String[] args) {

		EmployeeUtil employeeUtil = new EmployeeUtil();

		populateEmployees(employeeUtil);

		employeeUtil.sortEmployees(EmployeeSort.SORT_BY_NAME, true);
		employeeUtil.printEmployee();

		LocalDateTime dateTime = LocalDateTime.now();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		
		String fileName = "employeeDetails_" + dateTime.format(dtf).toString();

		if (employeeUtil.exportEmployessAsTxtFile("R:\\", fileName)) {

			System.out.println("File successfully exported");
		}

		// System.out.println();

//		employeeUtil.sortEmployees(EmployeeSort.SORT_BY_SALARY, false);
//		employeeUtil.printEmployee();

//		employeeUtil.sortEmployees(EmployeeSort.SORT_BY_NAME_THEN_SALARY, false);
//		employeeUtil.printEmployee();

//		employeeUtil.sortEmployees(EmployeeSort.SORT_BY_SALARY_THEN_NAME, false);
//		employeeUtil.printEmployee();

		System.out.println();
		System.out.println(employeeUtil.findEmployee(40088026));
		System.out.println(employeeUtil.findEmployee(40088027));

		System.out.println();

		System.out.println(employeeUtil.findEmployee("Rohit"));

		System.out.println();

		if (employeeUtil.deleteEmployeeByEmployeeNumber(40089026)) {

			System.out.println("employee deleted");
		} else {

			System.out.println("employee not found");
		}

	}

	private static void populateEmployees(EmployeeUtil employeeUtil) {

		employeeUtil.addEmployee(new Employee("Rohit", 40088026, 15000.0));
		employeeUtil.addEmployee(new Employee("Rohit", 40089026, 19000.0));
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

//		employeeUtil.addEmployee(new Employee("Rohit", 40088027, 18000.0));
//		employeeUtil.addEmployee(new Employee("Rohit", 40088028, 14000.0));
//		employeeUtil.addEmployee(new Employee("Rohit", 40088029, 12000.0));
//		employeeUtil.addEmployee(new Employee("Rohit", 40088030, 16000.0));
//		employeeUtil.addEmployee(new Employee("Rohit", 40088023, 155000.0));
//		employeeUtil.addEmployee(new Employee("Rohit", 40088022, 121100.0));
//		employeeUtil.addEmployee(new Employee("Rohit", 40088021, 15010.0));
//		employeeUtil.addEmployee(new Employee("Rohit", 40088020, 15000.0));
//		employeeUtil.addEmployee(new Employee("Rohit", 40088050, 15040.0));
//		

//		employeeUtil.addEmployee(new Employee("Rohit", 40088027, 18000.0));
//		employeeUtil.addEmployee(new Employee("mohit", 40088028, 18000.0));
//		employeeUtil.addEmployee(new Employee("kohit", 40088029, 18000.0));
//		employeeUtil.addEmployee(new Employee("tohit", 40088030, 18000.0));
//		employeeUtil.addEmployee(new Employee("yohit", 40088023, 18000.0));
//		employeeUtil.addEmployee(new Employee("uohit", 40088022, 18000.0));
//		employeeUtil.addEmployee(new Employee("qohit", 40088021, 15010.0));
//		employeeUtil.addEmployee(new Employee("wohit", 40088020, 18000.0));
//		employeeUtil.addEmployee(new Employee("johit", 40088050, 18000.0));
//		

	}

}
