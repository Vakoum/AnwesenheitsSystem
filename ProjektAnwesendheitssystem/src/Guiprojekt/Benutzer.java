package ProjektAnwesendheitssystem.src.Guiprojekt;

public class Benutzer {
    private String name;
    private String nachname;
    private String passwort;

    public Benutzer(String name, String nachname, String passwort) {
        this.name = name;
        this.nachname = nachname;
        this.passwort = passwort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }


    @Override
    public String toString() {
        return "Benutzer: " + name + " " + nachname;
    }
}
