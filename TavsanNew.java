import java.util.Random;

public class TavsanNew{
	private static int[][] sayi = new int[20][20];
	private static char[][] type = new char[20][20];
	private static Random rnd = new Random();
	private static int kAnzahl = 1;
	private static int runde = 1;

	public static void main(String[] args) {
		First(type);
		type[rnd.nextInt(20)][rnd.nextInt(20)] = 'd';
		Print(type);
		while(kAnzahl<400){
			runde++;
			Yerlestirme(type);
			Umwandlung(type, sayi);
			Age(type, sayi);
			Print(type);
		}
	}
	public static void Umwandlung(char[][] type, int[][] sayi){
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				if (type[i][j]=='k'){
					type[i][j]='o';
					sayi[i][j]=0;
				}
			}
		}
	}
	public static void Age(char[][] type, int[][] sayi){
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				if (type[i][j]=='d' || type[i][j]=='o'){
					sayi[i][j]++;
				}
				if (sayi[i][j]==4){
					type[i][j] = 'd';
				}
				if (sayi[i][j]==8){
					type[i][j]='X';
				}
			}
		}
	}
	public static void Print(char[][] type){
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				System.out.print(type[i][j] + " ");
			} System.out.println();
		} System.out.println("Kaninchen Anzahl : " + kAnzahl + " Runde : " + runde);
	}
	public static void First(char[][] type){
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				type[i][j] = '-';
			} 
		}
	}
	public static void Yerlestirme(char[][] type){
		for (int i=0; i<20; i++){
			for (int j=0; j<20; j++){
				if(type[i][j]=='d'){
					int a = rnd.nextInt(2);
					if (i<19 && type[i+1][j]=='-' && a==1){
						type[i+1][j]='k';
						kAnzahl++;
					}
					if (j<19 && type[i][j+1]=='-' && a==1){
						type[i][j+1]='k';
						kAnzahl++;
					}
					if (i>0 && type[i-1][j]=='-' && a==1){
						type[i-1][j]='k';
						kAnzahl++;
					}
					if (j>0 && type[i][j-1]=='-' && a==1){
						type[i][j-1]='k';
						kAnzahl++;
					}
				}
			} 
		}
	}
}