package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonHinzufügen {
    private JFrame frame;
    private JTextField nameField;
    private JTextField alterField;
    private JTextField ortField;
    private JComboBox<String> geschlechtComboBox;

    public PersonHinzufügen() {
        frame = new JFrame("Person hinzufÃ¼gen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Vorname:");
        nameField = new JTextField();

        JLabel alterLabel = new JLabel("Nachname:");
        alterField = new JTextField();

        JLabel ortLabel = new JLabel("Passort:");
        ortField = new JTextField();

        JLabel geschlechtLabel = new JLabel("ist Admin:");
        String[] geschlechtOptions = {"Ja", "Nein"};
        geschlechtComboBox = new JComboBox<>(geschlechtOptions);

        JButton speichernButton = new JButton("Speichern");
        speichernButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String alter = alterField.getText();
                String ort = ortField.getText();
                String geschlecht = (String) geschlechtComboBox.getSelectedItem();

                // Speichern der Daten
                speichernPerson(name, alter, ort, geschlecht);

                // ZurÃ¼cksetzen der Eingabefelder
                nameField.setText("");
                alterField.setText("");
                ortField.setText("");
                geschlechtComboBox.setSelectedIndex(0);
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(alterLabel);
        panel.add(alterField);
        panel.add(ortLabel);
        panel.add(ortField);
        panel.add(geschlechtLabel);
        panel.add(geschlechtComboBox);
        panel.add(new JLabel());
        panel.add(speichernButton);

        frame.add(panel, BorderLayout.CENTER);
    }

    private void speichernPerson(String name, String alter, String ort, String geschlecht) {
        // Hier kÃ¶nnen Sie den Code zum Speichern der Daten implementieren
        System.out.println("Daten gespeichert:");
        System.out.println("Vorname: " + name);
        System.out.println("Nachname: " + ort);
        System.out.println("Alter: " + alter);
        System.out.println("ist Admin: " + geschlecht);
    }

    public void run() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        PersonHinzufügen personHinzufügen = new PersonHinzufügen();
        personHinzufügen.run();
    }
}

