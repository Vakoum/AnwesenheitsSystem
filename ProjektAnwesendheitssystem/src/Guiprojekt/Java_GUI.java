package ProjektAnwesendheitssystem.src.Guiprojekt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java_GUI extends JFrame {
    private JComboBox<String> nameComboBox;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private JButton loginButton;
    private JButton cancelButton;

    private Map<String, String> userPasswords;

    public Java_GUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialisiere die Benutzernamen und Passwörter
        userPasswords = new HashMap<>();
        userPasswords.put("Aldin Ajrovic", "fortnite");
        userPasswords.put("Filip Kuzmicz", "pole");
        userPasswords.put("Svetozar Perisin", "serbenschwein");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Name:");
        nameComboBox = new JComboBox<>();
        nameComboBox.addItem("-");
        nameComboBox.addItem("Aldin Ajrovic");
        nameComboBox.addItem("Filip Kuzmicz");
        nameComboBox.addItem("Svetozar Perisin");
        sortNames();

        JLabel passwordLabel = new JLabel("Passwort:");
        passwordField = new JPasswordField(20);

        showPasswordCheckBox = new JCheckBox("Passwort anzeigen");
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                passwordField.setEchoChar(checkBox.isSelected() ? '\u0000' : '\u2022');
            }
        });

        loginButton = new JButton("Anmelden");
        cancelButton = new JButton("Abbrechen");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nameComboBox.getSelectedItem();
                char[] password = passwordField.getPassword();

                if (isValidLogin(selectedName, password)) {
                    // Öffne die Admin GUI, wenn die Anmeldung erfolgreich ist
                    AdminGUI adminGUI = new AdminGUI();
                    adminGUI.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(Java_GUI.this, "Ungültige Anmeldedaten!", "Fehler", JOptionPane.ERROR_MESSAGE);
                    passwordField.setText("");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && e.isControlDown()) {
                    passwordField.setText("");
                }
            }
        });

        // Füge die Komponenten zum Panel hinzu

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

        add(panel);
        setVisible(true);
    }

    private boolean isValidLogin(String selectedName, char[] password) {
        String passwordString = new String(password);
        String storedPassword = userPasswords.get(selectedName);

        return storedPassword != null && storedPassword.equals(passwordString);
    }

    private void sortNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < nameComboBox.getItemCount(); i++) {
            names.add(nameComboBox.getItemAt(i));
        }
        Collections.sort(names);
        nameComboBox.removeAllItems();
        for (String name : names) {
            nameComboBox.addItem(name);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Java_GUI();
            }
        });
    }
}