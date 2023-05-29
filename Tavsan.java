import java.util.Random;

public class Tavsan{
	public static void main(String[] args){
		Random rnd = new Random();
		int kAnzahl = 0;
		int runde = 0;
		char[][] type = new char[20][20];

		for (int i = 0; i < type.length; i++) {
            for (int j = 0; j < type[i].length; j++) {
                type[i][j] = '-';
            }
        }

		type[rnd.nextInt(20)][rnd.nextInt(20)] = 'd';
		kAnzahl++;
		runde++;
		for (int i=0; i<type.length; i++){
			for (int j=0; j<type[i].length; j++){
				System.out.print(type[i][j] + " ");
			} System.out.println();
		} System.out.println("Kaninchen Anzahl : " + kAnzahl);

		while (kAnzahl<400){
			runde++;
			for (int i=0; i<type.length; i++){
				for (int j=0; j<type[i].length; j++){
					if (type[i][j] == 'd'){
						if (i<19 && type[i+1][j]=='-'){
							int a = rnd.nextInt(2);
							if (a==1){
								type[i+1][j] = 'k';
								kAnzahl++;
							}
						}
						if (j<19 && type[i][j+1]=='-'){
							int a = rnd.nextInt(2);
							if (a==1){
								type[i][j+1] = 'k';
								kAnzahl++;
							}
						}
						if (j>0 && type[i][j-1]=='-'){
							int a = rnd.nextInt(2);
							if (a==1){
								type[i][j-1] = 'k';
								kAnzahl++;
							}
						}
						if (i>0 && type[i-1][j]=='-'){
							int a = rnd.nextInt(2);
							if (a==1){
								type[i-1][j] = 'k';
								kAnzahl++;
							}
						}
				    }
				}
			} for (int i=0; i<type.length; i++){
				for (int j=0; j<type[i].length; j++){
					if (type[i][j]=='k'){
						type[i][j]='d';
					} 
				}
			}   for (int i=0; i<type.length; i++){
				    for (int j=0; j<type[i].length; j++){
					    System.out.print(type[i][j] + " ");
					} System.out.println();
				} System.out.println("Runde -> " + runde + " und Kaninchen Anzahl : " + kAnzahl);

		}
	}
}