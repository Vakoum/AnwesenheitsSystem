<<<<<<< HEAD
package ProjektAnwesendheitssystem.src.Guiprojekt;

import javax.swing.*;
=======
package Guiprojekt;
>>>>>>> 72b1ef399cd74e28fd2de0faf86da94e6c623a81
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JMenu {
    private Java_GUI javaGUI;
    private JMenuItem addPersonMenuItem;
    private JMenuItem editPersonMenuItem;
    private JMenuItem deletePersonMenuItem;

    public AdminPanel(Java_GUI javaGUI) {
        this.javaGUI = javaGUI;
        setText("AdminPanel");

        addPersonMenuItem = new JMenuItem("Person hinzufügen");
        editPersonMenuItem = new JMenuItem("Person bearbeiten");
        deletePersonMenuItem = new JMenuItem("Person entfernen");

        add(addPersonMenuItem);
        add(editPersonMenuItem);
        add(deletePersonMenuItem);

        addPersonMenuItem.addActionListener(e -> {
            addPerson();
        });

        editPersonMenuItem.addActionListener(e -> {
            editPerson();
        });

        deletePersonMenuItem.addActionListener(e -> {
            deletePerson();
        });
    }

    private void addPerson() {
        String name = JOptionPane.showInputDialog(javaGUI, "Geben Sie den Namen der Person ein:");
        if (name != null && !name.isEmpty()) {
            // Fügen Sie den Code zum Hinzufügen der Person hier ein
            JOptionPane.showMessageDialog(javaGUI, "Person hinzugefügt: " + name);
        }
    }

    private void editPerson() {
        String name = JOptionPane.showInputDialog(javaGUI, "Geben Sie den Namen der zu bearbeitenden Person ein:");
        if (name != null && !name.isEmpty()) {
            // Fügen Sie den Code zum Bearbeiten der Person hier ein
            JOptionPane.showMessageDialog(javaGUI, "Person bearbeiten: " + name);
        }
    }

    private void deletePerson() {
        String name = JOptionPane.showInputDialog(javaGUI, "Geben Sie den Namen der zu löschenden Person ein:");
        if (name != null && !name.isEmpty()) {
            // Fügen Sie den Code zum Entfernen der Person hier ein
            JOptionPane.showMessageDialog(javaGUI, "Person entfernen: " + name);
        }
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(this);

        return menuBar;
    }

    public void showAdminPanel() {
        javaGUI.setJMenuBar(createMenuBar());
    }
}
