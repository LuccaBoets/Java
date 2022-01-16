package demo;
import demo.database.EmployeeDAO;

public class EmployeeApp {
	 public static void main(String[] args) {
	
		 EmployeeDAO employeeDal = new EmployeeDAO();

	      /* Add few employee records in database */
//	      Integer empID1 = employeeDal.addEmployee("Zara", "Ali", 2000);
//	      Integer empID2 = employeeDal.addEmployee("Daisy", "Das", 5000);
//	      Integer empID3 = employeeDal.addEmployee("John", "Paul", 5000);
//	      Integer empID4 = employeeDal.addEmployee("Mohd", "Yasee", 3000);

	      /* List down all the employees */
	      employeeDal.listEmployees();

	      /* Print Total employee's count */
	      employeeDal.countEmployee();

	      /* Print Total salary */
	      employeeDal.totalSalary();
	      
	      employeeDal.close();
	   }
}
