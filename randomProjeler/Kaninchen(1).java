import java.util.Random;

public class Kaninchen {
    public static void main(String[] args) {

        // eine 20x20 Matrize erstellen
        char[][] gebiet = new char[20][20];

        // die gebiet_Matrize mit '-' initialisieren
        for (int i = 0; i < gebiet.length; i++) {
            for (int j = 0; j < gebiet[i].length; j++) {
                gebiet[i][j] = '-';
            }
        }
        // das erste Kaninchen mithilfe der position_variable zufällig einem Index der gebiet_Matrize zuweisen
        Random position_variable = new Random();
        gebiet[position_variable.nextInt(20)][position_variable.nextInt(20)] = 'k';

        // Kaninchen-Counter erstellen und 1 dazu addieren
        int kaninchen_anzahl = 0;
        kaninchen_anzahl++;

        // die benötigten drei Phasen durchlaufen, bis die Anzahl der Kaninchen 400 beträgt
        while (kaninchen_anzahl < 400) {
            // 'k' den angrenzenden Feldern zuweisen
            for (int i = 0; i < gebiet.length; i++) {
                for (int j = 0; j < gebiet[i].length; j++) {
                    if (gebiet[i][j] == 'd') {
                        if (i > 0 && gebiet[i - 1][j] == '-') {
                            gebiet[i - 1][j] = 'k';
                            kaninchen_anzahl++;
                        }
                        if (i < 19 && gebiet[i + 1][j] == '-') {
                            gebiet[i + 1][j] = 'k';
                            kaninchen_anzahl++;
                        }
                        if (j > 0 && gebiet[i][j - 1] == '-') {
                            gebiet[i][j - 1] = 'k';
                            kaninchen_anzahl++;
                        }
                        if (j < 19 && gebiet[i][j + 1] == '-') {
                            gebiet[i][j + 1] = 'k';
                            kaninchen_anzahl++;
                        }
                    }
                }
            }
            //die vorlaeufigen Kaninchen 'k' mit 'd' ersetzen
            for (int i = 0; i < gebiet.length; i++) {
                for (int j = 0; j < gebiet[i].length; j++) {
                    if  (gebiet[i][j] == 'k') {
                        gebiet[i][j] = 'd';
                    }
                }
            }

            //das aktuelle Gebiet und Anzahl der Kaninchen ausgeben
            for (int i = 0; i < gebiet.length; i++) {
                for (int j = 0; j < gebiet[i].length; j++) {
                    System.out.print(gebiet[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Anzahl der Kaninchen: " + kaninchen_anzahl);
            System.out.println();
        }
    }
}

