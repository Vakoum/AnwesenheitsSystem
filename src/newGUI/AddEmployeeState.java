package newGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Employee.Employee;

public class AddEmployeeState implements State{
	
	
	private JPanel panel;
	private JPanel mainPanel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField passwordField;
    private JCheckBox adminCheckBox;

    private JButton savingButton;
    
    private JPanel backButtonPanel;
    private JButton backButton;
    
    WindowStateMachine stateMachine;
    
    public AddEmployeeState(WindowStateMachine stateMachine) {
    	this.stateMachine = stateMachine;
    	instantiate();
    }
    private void instantiate() {
    	createComponents();
    	addComponentsToPanel();
    }
    private void createComponents() {
    	panel = new JPanel();
    	mainPanel = new JPanel();
    	firstNameField = new JTextField();
    	lastNameField = new JTextField();
    	passwordField = new JTextField();
    	adminCheckBox = new JCheckBox();
    	savingButton = new JButton();
    	backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	backButton = createBackButton();
    }
    
    public void addComponentsToPanel() {
        mainPanel.setLayout(new GridLayout(5, 2));
        
        
    	 savingButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 String firstName = firstNameField.getText();
                 String lastName = lastNameField.getText();
                 String password = passwordField.getText();
                 boolean is_admin = adminCheckBox.isSelected();

                 Employee newEmployee = new Employee(0, firstName, lastName, password, is_admin);
                 stateMachine.getEmployeeManager().createEmployee(newEmployee);
                 stateMachine.setCurrentState(stateMachine.getAdminControllerState());
             }
         });

    	 backButtonPanel.add(backButton);
    	 panel.add(backButtonPanel, BorderLayout.NORTH);	
    	 
         mainPanel.add(new JLabel("Vorname"));
         mainPanel.add(firstNameField);
         mainPanel.add(new JLabel("Nachname"));
         mainPanel.add(lastNameField);
         mainPanel.add(new JLabel("Passwort"));
         mainPanel.add(passwordField);
         mainPanel.add(new JLabel("Is Admin"));
         mainPanel.add(adminCheckBox);
         mainPanel.add(new JLabel());
         mainPanel.add(savingButton);
         panel.add(mainPanel, BorderLayout.SOUTH);
    }
    
	@Override
	public void setPanel() {
		stateMachine.getMainFrame().add(panel);		
	}
private JButton createBackButton() {
    	
    	// get Arrow image
        ImageIcon backIcon = new ImageIcon("C:/Users/Administrator/Desktop/AnwesenheitsSystem/arrow.png"); 
        // Resize the image
        Image image = backIcon.getImage();
        Image resizedImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        // set button details
        JButton backButton = new JButton(resizedIcon);
        backButton.setPreferredSize(new Dimension(30, 30)); // Set the size of the button
        backButton.setBorderPainted(false); // Remove the button border
        backButton.setContentAreaFilled(false); // Remove the button background
        backButton.setFocusPainted(false); // Remove the focus border
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stateMachine.setCurrentState(stateMachine.getAdminControllerState());
            }
        });
        
        return backButton;
    }
}
