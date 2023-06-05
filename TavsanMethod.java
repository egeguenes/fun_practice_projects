import java.util.Random;

public class TavsanMethod{
	public static int rabbitCount = 1;
	public static void main(String[] args){
		char[][] feld = new char[20][20];
		Minus(feld);
		Random random = new Random();
		int xRandom = random.nextInt(20);
		int yRandom = random.nextInt(20);
		feld[xRandom][yRandom] = 'd';
		Print(feld);
		while (rabbitCount < 400){
			Vermehrung(feld);
			Umwandlung(feld);
			Print(feld);
		} 


	}
	public static void Minus(char[][] feld){
		for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
            	feld[i][j] = '-';
            }
        } 
	}
	public static void Print(char[][] feld){
		for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
            	System.out.print(feld[i][j] + " ");
            }
            System.out.println();
        }    System.out.println("Kaninchen Anzahl " + rabbitCount);
	}
	public static void Vermehrung(char[][] feld){
		for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
            	if (feld[i][j]=='d'){
            		if (i<19 && feld[i+1][j]=='-') {
            			feld[i+1][j] = 'y';
            			rabbitCount++;
            		}
            		if (j<19 && feld[i][j+1]=='-'){
            			feld[i][j+1] = 'y';
            			rabbitCount++;
            		}
            		if (j>0 && feld[i][j-1]=='-'){
            			feld[i][j-1] = 'y';
            			rabbitCount++;
            		}
            		if (i>0 && feld[i-1][j]=='-'){
            			feld[i-1][j] = 'y';
            			rabbitCount++;
            		}
            	}
            }
        }   
	}
	public static void Umwandlung(char[][] feld){
		for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
            	if (feld[i][j]=='y'){
            		feld[i][j] = 'd';
            	}
            }
        }
	}
}