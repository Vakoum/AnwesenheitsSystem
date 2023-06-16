package newGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Employee.*;

public class LoginScreenState implements State {
    private JPanel panel;

    private JComboBox<Employee> nameComboBox;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private JButton loginButton;
    private JButton cancelButton;

    private WindowStateMachine stateMachine;

    public LoginScreenState(WindowStateMachine stateMachine) {
        this.stateMachine = stateMachine;
        initialize();
    }

    private void initialize() {
        createComponents();
        addComponentsToPanel();
    }

    private void createComponents() {
    	panel = new JPanel();
        nameComboBox = new JComboBox<>();
        passwordField = new JPasswordField(20);
        showPasswordCheckBox = new JCheckBox("Passwort anzeigen");
        loginButton = new JButton("Anmelden");
        cancelButton = new JButton("Abbrechen");
    }

    private void addComponentsToPanel() {
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Name:");

        for (Employee employee : stateMachine.getEmployeeRetriever().getEntitys()) {
            nameComboBox.addItem(employee);
        }

        JLabel passwordLabel = new JLabel("Passwort:");

        showPasswordCheckBox.addActionListener(e -> {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            passwordField.setEchoChar(checkBox.isSelected() ? '\u0000' : '\u2022');
        });

        loginButton.addActionListener(e -> login());

        cancelButton.addActionListener(e -> stateMachine.getMainFrame().dispose());

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && e.isControlDown()) {
                    passwordField.setText("");
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameComboBox, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(showPasswordCheckBox, gbc);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(loginButton, gbc);
        gbc.gridx = 1;
        panel.add(cancelButton, gbc);
    }

    private void login() {
        Employee selectedEmployee = (Employee) nameComboBox.getSelectedItem();
        char[] charPassword = passwordField.getPassword();
        String password = new String(charPassword);

        if (stateMachine.getEmployeeManager().isCorrectPassword(selectedEmployee, password)) {
        	stateMachine.setCurrentEmployee(selectedEmployee);
            passwordField.setText("");    
            if (selectedEmployee.getIs_admin()) {
                stateMachine.setCurrentState(stateMachine.getAdminControllerState());
            } else {
                stateMachine.setCurrentState(stateMachine.getEmployeeAttendanceInputState());
            }
        } else {
            JOptionPane.showMessageDialog(stateMachine.getMainFrame(), "Ungültige Anmeldedaten!", "Fehler", JOptionPane.ERROR_MESSAGE);
            passwordField.setText("");
        }
    }

    @Override
    public void setPanel() {
        stateMachine.getMainFrame().add(panel);
    }
}
