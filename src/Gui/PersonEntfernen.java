package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonEntfernen {
    private JFrame frame;
    private JComboBox<String> personComboBox;

    public PersonEntfernen() {
        frame = new JFrame("Person entfernen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);

        JLabel personLabel = new JLabel("Person:");
        personComboBox = new JComboBox<>();
        personComboBox.addItem("Person 1");
        personComboBox.addItem("Person 2");
        personComboBox.addItem("Person 3");
        personComboBox.addItem("Person 4");

        centerPanel.add(personLabel, gbc);

        gbc.gridy++;
        centerPanel.add(personComboBox, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton speichernButton = new JButton("Speichern");
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPerson = (String) personComboBox.getSelectedItem();
                speichernPerson(selectedPerson);
            }
        });

        buttonPanel.add(speichernButton);

        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);

        // Zentriere das Fenster auf dem Bildschirm
        frame.setLocationRelativeTo(null);
    }

    private void speichernPerson(String selectedPerson) {
        // Hier können Sie den Code zum Speichern der ausgewählten Person implementieren
        System.out.println("Person gespeichert: " + selectedPerson);
    }

    public void run() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            PersonEntfernen personEntfernen = new PersonEntfernen();
            personEntfernen.run();
        });
    }
}

