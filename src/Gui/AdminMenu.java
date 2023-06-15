package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JMenu {
    private Java_GUI javaGUI;

    public AdminMenu(Java_GUI javaGUI) {
        super("Admin");

        this.javaGUI = javaGUI;

        JMenuItem addPersonMenuItem = new JMenuItem("Person hinzufügen");
        addPersonMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPerson();
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
        add(removePersonMenuItem);
    }

    private void addPerson() {
        // Implementiere die Logik zum Hinzufügen einer Person
        JOptionPane.showMessageDialog(javaGUI, "Person hinzufügen");
    }

    private void removePerson() {
        // Implementiere die Logik zum Entfernen einer Person
        JOptionPane.showMessageDialog(javaGUI, "Person entfernen");
    }
}