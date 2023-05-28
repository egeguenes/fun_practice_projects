import java.util.Random;

public class Kaninchen{
    public static void main(String[] args){

        Random platz = new Random();

        //zwei dimensionale (20x20) feld erstellen.
        char[][] feld = new char[20][20];

        //Alle Indexes des Feldes auf Minus setzen.
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                feld[i][j] = '-'; 
            }
        }
        //Unser erstes Kaninchen.
        feld[platz.nextInt(20)][platz.nextInt(20)] = 'd'; 

        //Wir haben ein Kaninchen.
        int kAnzahl = 1;
        
        //Zeigt unsere erste Runde.
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                System.out.print(feld[i][j] + " ");
            } System.out.println();
        } System.out.println("Anzahl Kaninchen: " + kAnzahl);
    
        /*solange unsere Kaninchen Zahl kleiner ist als 400 (20x20), laufen unsere Whileschleife.
         * Zuerst haben wir unsere Array noch mal laufen lassen mit for Schleifen und das erste Kaninchen gefunden.
         * 
         */
        for (int i=0; i<20; i++){
                for (int j=0; j<20; j++){
                    if (feld[i][j] == 'd'){
                        System.out.println(i + "+" + j);
                    }
                }
            }
        while (kAnzahl < 400) {
            for (int i=0; i<20; i++){
                for (int j=0; j<20; j++){
                    if (feld[i][j] == 'd'){
                        if(i>0 && feld[i-1][j]=='-'){
                            feld[i-1][j] = 'k';
                            kAnzahl++;
                        } 
                        if (i<19 && feld[i+1][j]=='-'){
                            feld[i+1][j] = 'k';
                            kAnzahl++;
                        }
                        if (j<19 && feld[i][j+1]=='-'){
                            feld[i][j+1] = 'k';
                            kAnzahl++;
                        }
                        if (j>0 && feld[i][j-1]=='-'){
                            feld[i][j-1] = 'k';
                            kAnzahl++;
                    } 
                } 
            } 
            for (int i = 0; i < feld.length; i++) {
                for (int j = 0; j < feld[i].length; j++) {
                    if  (feld[i][j] == 'k') {
                        feld[i][j] = 'd';
                    }
                }
            }
            for (int a=0; a<20; a++){
                for (int b=0; b<20; b++){
                    System.out.print(feld[a][b] + " ");
                }
                System.out.println();
            } System.out.println("Anzahl der Kaninchen " + kAnzahl);
        }
    } 
}