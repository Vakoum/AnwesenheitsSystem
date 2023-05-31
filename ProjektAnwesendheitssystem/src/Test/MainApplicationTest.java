package Test;

import java.util.*;

import PreOrganized.*;

public class MainApplicationTest {
	
	public EntityContainer<Employee> employeeContainer;
	
	
 public static void main(String[] arg) {
	 Employee employee = new Employee(3, "aldin", "ist krank", "abc", false);
	 EmployeeWriter writer = new EmployeeWriter();
	 writer.insertEntity(employee);
 }
 
 public void setEmployeesToTable() {
	 List<Employee> employees = new EmployeeConverter().getEntitys();
	 employeeContainer = new EntityContainer<Employee>();
	 employeeContainer.setEmployeeList(employees);
 }
}
