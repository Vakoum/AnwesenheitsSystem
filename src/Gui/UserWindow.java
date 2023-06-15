package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserWindow {
    private JFrame userFrame;
    private JTextArea textArea;

    public UserWindow() {
        userFrame = new JFrame("Benutzerfenster");
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setSize(400, 300);
        userFrame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);

        userFrame.add(panel, BorderLayout.CENTER);

        // Laden des Pfeilbildes über den vollständigen Dateipfad
        ImageIcon arrowIcon = new ImageIcon("C:/Pfad/zur/arrow_left.png"); // Bitte Pfad anpassen
        if (arrowIcon.getImage() == null) {
            System.err.println("Fehler beim Laden des Pfeilbildes.");
        } else {
            JLabel arrowLabel = new JLabel(arrowIcon);
            userFrame.add(arrowLabel, BorderLayout.NORTH);
        }

        JButton kommenButton = new JButton("Kommen");
        kommenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Person kommt an: Ja");
            }
        });

        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Pause beginnt: Ja");
            }
        });
        textArea.setEditable(false);

        JButton logoutButton = new JButton("Ausloggen");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeUserWindow();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(kommenButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(logoutButton);

        userFrame.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void closeUserWindow() {
        userFrame.setVisible(false);
        System.exit(0);
    }

    public void run() {
        userFrame.setVisible(true);
    }

    public static void main(String[] args) {
        UserWindow userWindow = new UserWindow();
        userWindow.run();
    }
}
