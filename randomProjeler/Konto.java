/**
 * Diese Klasse realisert Konten. Jedes Konto wird
 * durch den aktuellen Kontostand dargestellt. Außerdem
 * werden Methoden zum Einzahlen und Abheben sowie
 * zur Kontostandsabfrage zur Verfügung gestellt.
 *
 * @author Werner Struckmann
 * @version 1.0 vom 17. Oktober 2002
 * 
 */
public class Konto {
    int stand = 0;                     // Attribut der Klasse

    /**
     * Diese Methode erhöht den Betrag auf dem
     * Konto um den Wert des Parameters.
     * 
     * @param betrag eingezahlter Betrag
     */
    public boolean einzahlen(int betrag) {// Methode zum Einzahlen
        /*        if (betrag < 0) {
            return false;
        }
        */
        stand = stand + betrag;        // Ist betrag positiv?
        return true;
    }

    /**
     * Diese Methode erniedrigt den Betrag auf dem
     * Konto um den Wert des Parameters.
     * 
     * @param betrag ausgezahlter Betrag
     */
    public boolean abheben(int betrag) {  // Methode zum Abheben
        /*
        if ( betrag < 0) {
            return false;
        }
        */
        stand = stand - betrag;        // Ist betrag positiv?
        return true;
    }

    /**
     * Diese Methode liefert den Kontostand.
     *
     * @return Kontostand                          
     */
    public int abfrage() {             // Methode zur Abfrage
        return stand;
    }

    public boolean transfer(int betrag, Konto von) {
        if (von.abfrage() < betrag) {
            return true;
        }
        von.abheben(betrag);
        return einzahlen(betrag);
    }
}
