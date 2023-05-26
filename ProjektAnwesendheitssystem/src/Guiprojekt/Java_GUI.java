package Guiprojekt;
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
    private AdminPanel adminPanel;

    private Map<String, String> userPasswords;

    public Java_GUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null);

        adminPanel = new AdminPanel(this);
        setJMenuBar(adminPanel.createMenuBar());

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
                    JOptionPane.showMessageDialog(Java_GUI.this, "Anmeldung erfolgreich!");
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

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(showPasswordCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(cancelButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(loginButton, gbc);

        add(panel);

        setVisible(true);
    }

    private void sortNames() {
        List<String> names = new ArrayList<>();
        int itemCount = nameComboBox.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            String name = (String) nameComboBox.getItemAt(i);
            if (!name.equals("-")) {
                names.add(name);
            }
        }

        Collections.sort(names);

        nameComboBox.removeAllItems();
        nameComboBox.addItem("-");
        for (String name : names) {
            nameComboBox.addItem(name);
        }
    }

    private boolean isValidLogin(String selectedName, char[] password) {
        String storedPassword = userPasswords.get(selectedName);
        if (storedPassword != null) {
            String enteredPassword = new String(password);
            return storedPassword.equals(enteredPassword);
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Java_GUI();
            }
        });
    }
}