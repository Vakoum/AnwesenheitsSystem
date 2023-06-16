package newGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeAttandanceInput implements State{

	private WindowStateMachine stateMachine;
	private AttendanceTextBox textBox;
	
	private JPanel panel;
	private JTextArea textArea;
	private JPanel backButtonPanel;
	private JButton backButton;
	
	private JPanel bottomButtonPanel;
	private JButton shiftButton;
	private JButton breakButton;
	private JButton logoutButton;
	
	public EmployeeAttandanceInput(WindowStateMachine stateMachine) {
		this.stateMachine = stateMachine;
		instantiate();
	}
	
	public void instantiate() {
		createComponents();
		addComponentsToPanel();
	}
	
	public void createComponents() {
		panel = new JPanel(new BorderLayout());
		textBox = new AttendanceTextBox(stateMachine);
		textArea = new JTextArea();
		backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		backButton = createBackButton();
		
		bottomButtonPanel = new JPanel();
		shiftButton = new JButton("Start Shift");
		breakButton = new JButton("Start Break");
		logoutButton = new JButton("logout");
		
	}
	public void addComponentsToPanel() {
        panel.setLayout(new BorderLayout());

        textArea.setEditable(false);
        
        buttonLocic();
        
        bottomButtonPanel.setLayout(new GridLayout(1, 3));
        bottomButtonPanel.add(shiftButton);
        bottomButtonPanel.add(breakButton);
        bottomButtonPanel.add(logoutButton);
        
        panel.add(textArea, BorderLayout.CENTER);
		panel.add(bottomButtonPanel, BorderLayout.SOUTH);
	}
	@Override
	public void setPanel() {
		if(stateMachine.getShiftManager().employeeHasActiveShift(stateMachine.getCurrentEmployee()) != null) {
			textArea.setText(textBox.setText());			
		}
		if(stateMachine.getCurrentEmployee().getIs_admin()) {
			backButtonPanel.add(backButton);
			panel.add(backButtonPanel, BorderLayout.NORTH);			
		}
		else {
			if(panel.isAncestorOf(backButtonPanel)) {
				panel.remove(backButtonPanel);
			}
		}
        stateMachine.getMainFrame().add(panel);
	}
	
	//Created under time pressure
    private void buttonLocic() {
    	shiftButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(stateMachine.getShiftManager().employeeHasActiveShift(stateMachine.getCurrentEmployee()) == null &&
    		    		stateMachine.getShiftManager().getShiftHasActiveBreak(stateMachine.getCurrentEmployee()) == null) {
    					
    					stateMachine.getShiftManager().startShift(stateMachine.getCurrentEmployee());
    					
    		    		shiftButton.setEnabled(true);
    		    		shiftButton.setText("End Shift");
    		    		
    		    		breakButton.setEnabled(true);
    		    		breakButton.setText("start Break");
    		    		return;
    		    	}
    			if(stateMachine.getShiftManager().employeeHasActiveShift(stateMachine.getCurrentEmployee()) != null &&
    		    		stateMachine.getShiftManager().getShiftHasActiveBreak(stateMachine.getCurrentEmployee()) == null) {
    					
    					stateMachine.getShiftManager().endShift(stateMachine.getCurrentEmployee());
    					
    		    		shiftButton.setEnabled(true);
    		    		shiftButton.setText("Start Shift");
    		    		
    		    		breakButton.setEnabled(false);
    		    		breakButton.setText("start Break");
    		    		return;
    		    }
    		}
    	});
    	
    	breakButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(stateMachine.getShiftManager().employeeHasActiveShift(stateMachine.getCurrentEmployee()) != null &&
    		    		stateMachine.getShiftManager().getShiftHasActiveBreak(stateMachine.getCurrentEmployee()) == null) {
    					
    					stateMachine.getShiftManager().startBreak(stateMachine.getCurrentEmployee());
    					
    		    		shiftButton.setEnabled(false);
    		    		shiftButton.setText("End Shift");
    		    		
    		    		breakButton.setEnabled(true);
    		    		breakButton.setText("End Break");
    		    		return;
    		    }
    			if(stateMachine.getShiftManager().employeeHasActiveShift(stateMachine.getCurrentEmployee()) != null &&
    		    		stateMachine.getShiftManager().getShiftHasActiveBreak(stateMachine.getCurrentEmployee()) != null) {
    					
    					stateMachine.getShiftManager().endBreak(stateMachine.getCurrentEmployee());
    					
    		    		shiftButton.setEnabled(true);
    		    		shiftButton.setText("End Shift");
    		    		
    		    		breakButton.setEnabled(true);
    		    		breakButton.setText("start Break");
    		    		return;
    		    }
    		}
    	});
    	logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	stateMachine.setCurrentEmployee(null);
            	stateMachine.setCurrentState(stateMachine.getLoginScreenState());
            }
        });
    	
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
