import java.util.Random;

public class KSim{
	public static void main(String[] args){
		char[][] type = new char[20][20];
		int[][] deneme = new int[20][20];
		Random rnd = new Random();
		Null(type);
		Null(deneme);
		type[rnd.nextInt(20)][rnd.nextInt(20)] = 'o';
		int kAnzahl = 1;
		int runde = 1;
		//
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				System.out.print(type[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Runde : " + runde + " Kaninchen Anzahl : " + kAnzahl);
		//
		while (kAnzahl < 400){
			runde++;
			Wachsen(deneme, type);
			Erwachsene(deneme, type);
			for (int i=0; i<20; i++){
				for (int j=0; j<20; j++){
					if (type[i][j]=='d'){
						if (i<19 && type[i+1][j]=='-'){
							if (Rnd()){
								type[i+1][j] = 'n';
								kAnzahl++;
							}
						}
						if (i>0 && type[i-1][j]=='-'){
							if (Rnd()){
								type[i-1][j] = 'n';
								kAnzahl++;
							}
						}
						if (j<19 && type[i][j+1]=='-'){
							if(Rnd()){
								type[i][j+1] = 'n';
								kAnzahl++;
							}
						}
						if (j>0 && type[i][j-1]=='-'){
							if (Rnd()){
								type[i][j-1] = 'n';
								kAnzahl++;
							}
						}
					}
				}
			} 
			Umwandlung(type);
			for (int i=0; i<20; i++){
				for (int j=0; j<20; j++){
					System.out.print(type[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("Runde : " + runde + " Kaninchen Anzahl : " + kAnzahl);
		}
	}	
	public static void Null(char[][] type){
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				type[i][j] = '-';
			}
		}
	}
	public static void Null(int[][] deneme){
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				deneme[i][j] = 0;
			}
		}
	}
	public static void Wachsen(int[][] deneme, char[][] type){
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				if (type[i][j]=='o' || type[i][j]=='d'){
					deneme[i][j]++;
				}
			}
		}
	}
	public static void Erwachsene(int[][] deneme, char[][] type){
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				if (deneme[i][j]==4){
					type[i][j] = 'd';
				}
				else if (deneme[i][j]==8){
					type[i][j]='X';
				}
			}
		}
	}
	public static boolean Rnd(){
		Random rnd = new Random();
		int a = rnd.nextInt(2);
		if (a==1){
			return true;
		}
		return false;
	}
	public static void Umwandlung(char[][] type){
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				if (type[i][j]=='n'){
					type[i][j] = 'o';
				}
			}
		}
	}
}