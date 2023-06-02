package ProjektAnwesendheitssystem.src.Guiprojekt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JMenu {
    private BenutzerVerwaltung benutzerVerwaltung; // Referenz auf das BenutzerVerwaltung-Objekt

    public AdminMenu(BenutzerVerwaltung benutzerVerwaltung) {
        super("Admin");

        this.benutzerVerwaltung = benutzerVerwaltung;

        JMenuItem addPersonMenuItem = new JMenuItem("Person hinzufügen");
        addPersonMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPerson();
            }
        });

      JMenuItem editPersonMenuItem = new JMenuItem("Person bearbeiten");
        editPersonMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPerson();
            }
        });

        JMenuItem removePersonMenuItem = new JMenuItem("Person entfernen");
        removePersonMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePerson();
            }
        });

        add(addPersonMenuItem);
        add(editPersonMenuItem);
        add(removePersonMenuItem);
    }

    private void addPerson() {
        // Implementiere die Logik zum Hinzufügen einer Person
        JOptionPane.showMessageDialog(null, "Person hinzufügen");
    }

    private void editPerson() {
        // Implementiere die Logik zum Bearbeiten einer Person
        JOptionPane.showMessageDialog(null, "Person bearbeiten");
    }

    private void removePerson() {
        // Implementiere die Logik zum Entfernen einer Person
        JOptionPane.showMessageDialog(null, "Person entfernen");
    }
}
