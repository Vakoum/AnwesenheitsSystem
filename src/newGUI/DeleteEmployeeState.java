package newGUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Employee.*;

public class DeleteEmployeeState implements State {

	WindowStateMachine stateMachine;
	
	private JPanel panel;
    private JComboBox<Employee> employeeComboBox;
	
    private JPanel centerPanel;
    private GridBagConstraints gbc;
    private JPanel buttonPanel;
    
    private JPanel backButtonPanel;
    private JButton backButton;

    private JButton saveButton;
    
    public DeleteEmployeeState(WindowStateMachine stateMachine) {
    	this.stateMachine = stateMachine;
    	initiate();
    }
    public void initiate() {
    	createComponents();
    	addComponentsToPanel();
    }
    public void createComponents() {
    	panel = new JPanel();
    	employeeComboBox = new JComboBox<>();
        centerPanel = new JPanel();
        gbc = new GridBagConstraints();
        backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	backButton = createBackButton();
        buttonPanel = new JPanel();
        saveButton = new JButton("Entferne Mitarbeiter");
    }
    
    public void addComponentsToPanel() {
    	panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        centerPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        
        
        centerPanel.add(new JLabel("Mitarbeiter: "), gbc);

        gbc.gridy++;
        centerPanel.add(employeeComboBox, gbc);
        
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        addEmployee();
        buttonPanel.add(saveButton);
        
        backButtonPanel.add(backButton);
		panel.add(backButtonPanel, BorderLayout.NORTH);	
        
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void addEmployee() {
    	saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee selectedPerson = (Employee)employeeComboBox.getSelectedItem();
                stateMachine.getEmployeeManager().deleteEmployee(selectedPerson);
                stateMachine.setCurrentState(stateMachine.getAdminControllerState());
            }
        });
    }
    
    
    
	@Override
	public void setPanel() {
		for(Component component : employeeComboBox.getComponents()) {
			employeeComboBox.remove(component);
		}
		employeeComboBox.remove(employeeComboBox);
		for(Employee employee : stateMachine.getEmployeeRetriever().getEntitys()) {
        	employeeComboBox.addItem(employee);
        }
        centerPanel.add(employeeComboBox, gbc);
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