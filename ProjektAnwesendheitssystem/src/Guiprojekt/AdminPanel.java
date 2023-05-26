package GUIPROJEKT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Java_GUI extends JFrame {
    private JComboBox<String> nameComboBox;
    private JPasswordField passwordField;
    private AdminPanel adminPanel;

    public Java_GUI() {
        // Initialisierung des JFrame und anderer Komponenten

        adminPanel = new AdminPanel(this);
        setJMenuBar(adminPanel.createMenuBar());

        // Weitere Initialisierung und Anzeige des JFrame
    }

    // Weitere Methoden und Code der Java_GUI-Klasse

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Java_GUI();
            }
        });
    }
}

class AdminPanel {
    private Java_GUI javaGUI;
    private JMenuBar menuBar;

    public AdminPanel(Java_GUI javaGUI) {
        this.javaGUI = javaGUI;
    }

    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();

        JMenu adminMenu = new JMenu("Admin");

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

        adminMenu.add(addPersonMenuItem);
        adminMenu.add(editPersonMenuItem);
        adminMenu.add(removePersonMenuItem);

        menuBar.add(adminMenu);

        return menuBar;
    }

    private void addPerson() {
        // Implementiere die Logik zum Hinzufügen einer Person
    }

    private void editPerson() {
        // Implementiere die Logik zum Bearbeiten einer Person
    }

    private void removePerson() {
        // Implementiere die Logik zum Entfernen einer Person
    }
}
