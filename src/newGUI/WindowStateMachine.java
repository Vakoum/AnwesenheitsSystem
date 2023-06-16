package newGUI;

import javax.swing.*;

import Employee.*;
import Shift.*;

import java.awt.*;

public class WindowStateMachine {
	
	private Employee currentEmployee;
	
	private EmployeeRetriever employeeRetriever;
    private EmployeeManager employeeManager;
    private ShiftRetriever shiftRetriever;
    private ShiftManager shiftManager;
    
	
    private JFrame mainFrame;
    private State currentState;

    private State loginScreenState;
    private State adminControllerState;
    private State employeeAttandenceInput;
    private State addEmployeeState;
    private State deleteEmployeeState;

    public WindowStateMachine() {
        createFrame();
        initializeEntityClasses();
        loginScreenState = new LoginScreenState(this);
        adminControllerState = new AdminControllerState(this);
        employeeAttandenceInput = new EmployeeAttandanceInput(this);
        addEmployeeState = new AddEmployeeState(this);
        deleteEmployeeState = new DeleteEmployeeState(this);
        setCurrentState(loginScreenState);
    }
    private void initializeEntityClasses() {
    	employeeRetriever = new EmployeeRetriever();
    	employeeManager = new EmployeeManager();
    	shiftRetriever = new ShiftRetriever();
    	shiftManager = new ShiftManager();
    }
    public Employee getCurrentEmployee() {
    	return currentEmployee;
    }
    public void setCurrentEmployee(Employee currentEmployee) {
    	this.currentEmployee = currentEmployee;
    }
    public EmployeeRetriever getEmployeeRetriever() {
    	return employeeRetriever;
    }
    public EmployeeManager getEmployeeManager() {
    	return employeeManager;
    }
    public ShiftRetriever getShiftRetriever() {
    	return shiftRetriever;
    }
    public ShiftManager getShiftManager() {
    	return shiftManager;
    }
    
    public State getLoginScreenState() {
        return loginScreenState;
    }
    public State getAdminControllerState() {
        return adminControllerState;
    }
    public State getAddEmployeeState() {
    	return addEmployeeState;
    }
    public State getDeleteEmployeeState() {
    	return deleteEmployeeState;
    }
    public State getEmployeeAttendanceInputState() {
    	return employeeAttandenceInput;
    }
    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setCurrentState(State state) {
        currentState = state;
        mainFrame.getContentPane().removeAll();
        currentState.setPanel();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void createFrame() {
        mainFrame = new JFrame("AnwesenheitSystem");
        mainFrame.setSize(400, 250);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
