import java.util.Random;

public class Pflichtaufgabe2{
	public static void main(String[] args){

		Random zeile = new Random();
		Random spalte = new Random();
		int counter = 0; 

		//zwei dimensionale (20x20) feld erstellen.
		char[][] feld = new char[20][20];

		//Alle Indexes des Feldes auf Minus setzen.
		for (int i = 0; i < 20; i++){
			for (int j = 0; j < 20; j++){
				feld[i][j] = '-'; 
			}
		}

		feld[spalte.nextInt(20)][zeile.nextInt(20)] = 'd'; 
	} 
}