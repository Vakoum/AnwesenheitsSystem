package Gui;

import javax.swing.*;
import Employee.*;

public class ReusableComboBox {
	
	private EmployeeRetriever employeeRetriever;
	public ReusableComboBox() {
		employeeRetriever = new EmployeeRetriever();
	}
	
	public JComboBox<Employee> getComboBox(){
		JComboBox<Employee> box = new JComboBox<>();	
		for (Employee employee : employeeRetriever.getEntitys()) {
            box.addItem(employee);
		}
		return box;
	}
}