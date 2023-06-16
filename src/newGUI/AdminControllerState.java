package newGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminControllerState implements State {
    private JPanel panel;

    private JButton addUserButton;
    private JButton deleteUserButton;
    private JButton employeeAttendanceButton;
    private JButton loginScreenButton;

    private WindowStateMachine stateMachine;

    public AdminControllerState(WindowStateMachine stateMachine) {
        this.stateMachine = stateMachine;
        initialize();
    }

    private void initialize() {
        createComponents();
        addComponentsToPanel();
    }

    private void createComponents() {
    	panel = new JPanel(new GridLayout(4, 1));
        addUserButton = new JButton("Erstelle neue Mitarbeiter");
        deleteUserButton = new JButton("Entferne Mitarbeiter");
        employeeAttendanceButton = new JButton("Mitarbeiter Anwesenheit");
        loginScreenButton = new JButton("Login Screen");
    }

    private void addComponentsToPanel() {
        addUserButton.addActionListener(e -> {
        	stateMachine.setCurrentState(stateMachine.getAddEmployeeState());
        });

        deleteUserButton.addActionListener(e -> {
        	stateMachine.setCurrentState(stateMachine.getDeleteEmployeeState());
        });
        employeeAttendanceButton.addActionListener(e -> {
        	stateMachine.setCurrentState(stateMachine.getEmployeeAttendanceInputState());
        });
        loginScreenButton.addActionListener(e -> {
        	stateMachine.setCurrentEmployee(null);
        	stateMachine.setCurrentState(stateMachine.getLoginScreenState());
        });
        
        panel.add(addUserButton);
        panel.add(deleteUserButton);
        panel.add(employeeAttendanceButton);
        panel.add(loginScreenButton);
    }

    @Override
    public void setPanel() {
        stateMachine.getMainFrame().add(panel);
    }
}