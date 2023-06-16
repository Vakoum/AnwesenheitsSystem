package newGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminControllerState implements State {
    private JPanel panel;

    private JLabel adminLabel;
    private JButton addUserButton;
    private JButton deleteUserButton;
    //private JButton 

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
    	panel = new JPanel();
        adminLabel = new JLabel();
        addUserButton = new JButton();
        deleteUserButton = new JButton();
    }

    private void addComponentsToPanel() {
        addUserButton.addActionListener(e -> {
        	stateMachine.setCurrentState(stateMachine.getAddEmployeeState());
        });

        deleteUserButton.addActionListener(e -> {
        	stateMachine.setCurrentState(stateMachine.getDeleteEmployeeState());
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(adminLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(addUserButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(deleteUserButton, gbc);
    }

    @Override
    public void setPanel() {
        stateMachine.getMainFrame().add(panel);
    }
}