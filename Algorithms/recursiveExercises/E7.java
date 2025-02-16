import java.util.Scanner;

public class E7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------GCD-------");
		System.out.print("Zahl 1 : ");
		int n1 = scan.nextInt();
		System.out.print("Zahl 2 : ");
		int n2 = scan.nextInt();
		System.out.println("Der GGT von " + n1 + " und " + n2 + " ist : " + gcd(n1 , n2));
	}

	public static int gcd(int a , int b) {
		if (a%b==0) {
			return b;
		} else if (b%a==0) {
			return a;
		} else {
			if (b<a) {
				return gcd(a-b , b);
			} else {
				return gcd(a , b-a);
			}
		}
	}

	/*Besser Version--
	public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
    */
}