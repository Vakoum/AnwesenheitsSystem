package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BenutzerVerwaltung {
    private JFrame frame;
    private JTextField txtName;
    private JTextField txtNachname;
    private JPasswordField txtPasswort;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BenutzerVerwaltung window = new BenutzerVerwaltung();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BenutzerVerwaltung() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblName = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.getContentPane().add(lblName, gbc);

        txtName = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.getContentPane().add(txtName, gbc);
        txtName.setColumns(10);

        JLabel lblNachname = new JLabel("Nachname:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.getContentPane().add(lblNachname, gbc);

        txtNachname = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.getContentPane().add(txtNachname, gbc);
        txtNachname.setColumns(10);

        JLabel lblPasswort = new JLabel("Passwort:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.getContentPane().add(lblPasswort, gbc);

        txtPasswort = new JPasswordField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.getContentPane().add(txtPasswort, gbc);
        txtPasswort.setColumns(10);

        JButton btnHinzufuegen = new JButton("Hinzufügen");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        frame.getContentPane().add(btnHinzufuegen, gbc);

        btnHinzufuegen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String nachname = txtNachname.getText();
                String passwort = new String(txtPasswort.getPassword());

                // Hier kannst du den Code einfügen, um den Benutzer zu speichern oder weiterzuverarbeiten
                // Zum Beispiel kannst du eine Benutzerklasse erstellen und den erstellten Benutzer darin speichern
                // Benutzer benutzer = new Benutzer(name, nachname, passwort);
                // Speichern der Benutzerdaten in einer Datenbank, einer Liste, etc.

                JOptionPane.showMessageDialog(frame, "Benutzer hinzugefügt:\nName: " + name + "\nNachname: " + nachname + "\nPasswort: " + passwort);

                // Zurücksetzen der Eingabefelder
                txtName.setText("");
                txtNachname.setText("");
                txtPasswort.setText("");
            }
        });
    }
}
