package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {
    private JLabel adminLabel;
    private JButton addUserButton;
    private JButton deleteUserButton;
    private JButton editUserButton;

    public AdminGUI() {
        setTitle("Admin Panel");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ändere die Schließaktion auf DISPOSE_ON_CLOSE
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        adminLabel = new JLabel("Willkommen, Administrator!");

        addUserButton = new JButton("Benutzer hinzufügen");
        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AdminGUI.this, "Benutzer hinzufügen");
            }
        });

        deleteUserButton = new JButton("Benutzer löschen");
        deleteUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AdminGUI.this, "Benutzer löschen");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(adminLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(addUserButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(deleteUserButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(editUserButton, gbc);

        add(panel);
    }
}
