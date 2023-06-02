package ProjektAnwesendheitssystem.src.Guiprojekt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BenutzerVerwaltung {
    private JFrame frame;
    private JTextField txtName;
    private JTextField txtNachname;
    private JPasswordField txtPasswort;
    private AdminPanel adminPanel; // Referenz auf das AdminPanel

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

        // ActionListener für den Hinzufügen-Button
        btnHinzufuegen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String nachname = txtNachname.getText();
                String passwort = new String(txtPasswort.getPassword());

                // Methode zum Hinzufügen des Benutzers aufrufen
                benutzerHinzufuegen(name, nachname, passwort);
            }
        });

        // Erzeugen Sie das AdminPanel und fügen Sie es zum JFrame hinzu
        adminPanel = new AdminPanel(this);
        addAdminPanel();
    }

    // Methode zum Hinzufügen des Benutzers
    public void benutzerHinzufuegen(String name, String nachname, String passwort) {
        // Hier können Sie den Code einfügen, um den Benutzer zur Benutzerverwaltung hinzuzufügen
        // Zum Beispiel können Sie den Benutzer zur JTextArea hinzufügen, um ihn anzuzeigen
        adminPanel.benutzerHinzufuegen(name, nachname, passwort);
    }

    // Methode zum Hinzufügen des AdminPanel zum JFrame
    public void addAdminPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        frame.getContentPane().add(adminPanel, gbc);
        adminPanel.setVisible(false); // Setzen Sie die Sichtbarkeit auf false, damit das Panel standardmäßig nicht angezeigt wird
    }
}

class AdminPanel extends JPanel {
    private JTextArea txtBenutzer;

    public AdminPanel(BenutzerVerwaltung benutzerVerwaltung) {
        setBorder(BorderFactory.createTitledBorder("Admin Panel"));
        setLayout(new BorderLayout());

        txtBenutzer = new JTextArea();
        txtBenutzer.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtBenutzer);
        add(scrollPane, BorderLayout.CENTER);

        benutzerVerwaltung.addAdminPanel(); // Rufen Sie die Methode addAdminPanel() in der Hauptklasse auf, um das AdminPanel hinzuzufügen
    }

    public void benutzerHinzufuegen(String name, String nachname, String passwort) {
        // Hier können Sie den Code einfügen, um den Benutzer zur Benutzerverwaltung hinzuzufügen
        // Zum Beispiel können Sie den Benutzer zur JTextArea hinzufügen, um ihn anzuzeigen
        txtBenutzer.append(name + " " + nachname + " - " + passwort + "\n");

        // Zeige das AdminPanel an
        setVisible(true);
    }
}
