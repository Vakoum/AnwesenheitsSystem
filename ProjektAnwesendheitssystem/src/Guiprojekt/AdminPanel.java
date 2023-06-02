package Guiprojekt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JPanel {
    private BenutzerVerwaltung javaGUI;
    private JTextField txtName;
    private JTextField txtNachname;
    private JPasswordField txtPasswort;

    public AdminPanel(BenutzerVerwaltung benutzerVerwaltung) {
        this.javaGUI = benutzerVerwaltung;
        //Anzeigebilder Erstellen
        JLabel lblName = new JLabel("Name:");
        add(lblName);

        txtName = new JTextField(20);
        add(txtName);

        JLabel lblNachname = new JLabel("Nachname:");
        add(lblNachname);

        txtNachname = new JTextField(20);
        add(txtNachname);

        JLabel lblPasswort = new JLabel("Passwort:");
        add(lblPasswort);

        txtPasswort = new JPasswordField(20);
        add(txtPasswort);

        JButton btnHinzufuegen = new JButton("Hinzufügen");
        btnHinzufuegen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String nachname = txtNachname.getText();
                String passwort = new String(txtPasswort.getPassword());

                // Erstelle den Benutzer
                Benutzer benutzer = new Benutzer(name, nachname, passwort);
                // Füge den Benutzer zum AdminPanel hinzu
                benutzerHinzufuegen(benutzer);

                // Zurücksetzen der Eingabefelder
                txtName.setText("");
                txtNachname.setText("");
                txtPasswort.setText("");

                JOptionPane.showInputDialog(benutzerVerwaltung, "Benutzer hinzugefügt: " + name + " " + nachname);
            }
        });
        add(btnHinzufuegen);
    }

    public void benutzerHinzufuegen(Benutzer benutzer) {
        // Hier kannst du den Code einfügen, um den Benutzer zur Benutzerverwaltung hinzuzufügen
    }

	public JMenuBar createMenuBar() {
		// TODO Auto-generated method stub
		return null;
	}
}
