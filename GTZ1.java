/*Die Dezimalziffern einer natürlichen Zahl n, n ≥ 1, werden einzeln quadriert und addiert. An-
schließend wird mit der entstandenen Summe genauso verfahren. Die Ausgangszahl n ist fröhlich,
wenn man bei diesem Vorgehen schließlich auf die Zahl 1 stößt, ansonsten ist sie traurig. Beispiel-
sweise ist 7 eine fröhliche Zahl:
7: 72 = 49
49: 42 + 92 = 97
97: 92 + 72 = 130
130: 12 + 32 + 02 = 10
10: 12 + 02 = 1
Schreiben Sie ein Java-Programm, das alle fröhlichen Zahlen zwischen einer Unter- und einer Ober-
grenze berechnet und die zugehörigen Folgen ausgibt. Der Dialog soll folgendermaßen ablaufen:
Bitte geben Sie die untere Grenze ein: 5
Bitte geben Sie die obere Grenze ein: 30
7 -> 49 -> 97 -> 130 -> 10 -> 1
10 -> 1
13 -> 10 -> 1
19 -> 82 -> 68 -> 100 -> 1
23 -> 13 -> 10 -> 1
28 -> 68 -> 100 -> 1
*/
import java.util.Scanner;

public class GTZ1 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] s = {" untere " , " obere "};
		int[] grenze = new int[2];
		for (int i=0; i<2; i++) {
			System.out.print("Geben Sie bitte" + s[i] + "grenze ein : ");
			grenze[i] = scan.nextInt(); // grenze[0] => untere // grenze[1] => obere
		}
		for (int i=grenze[0] ; i<=grenze[1] ; i++) {
			if (gtzKontrol(i)) {
				int deneme = i;
				while (deneme!=1) {
					System.out.print(deneme);
					deneme = quad(deneme);
					System.out.print(" -> ");
					if (deneme==1) {
						System.out.print(1);
					}
				} System.out.println();
			}
		}
	} 

	public static boolean gtzKontrol(int num) {
		while(num!=1) {
			num = quad(num);
			if (num==4){
				return false;
			}
			if (num==1) {
				return true;
			}
		} return false;
	}

	public static int quad(int a) {
		int result = 0;
		while (a>0) {
			result += (a%10) * (a%10);
			a /= 10;
		}
		return result;
	}
}