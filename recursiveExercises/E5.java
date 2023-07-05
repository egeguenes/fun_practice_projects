import java.util.Scanner;

public class E5 {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Geben Sie eine Zahl ein : ");
		int a = scan.nextInt();
		System.out.println("Number of digits : " + digit(a));
	}

	public static int digit(int n) {
		if (n==0) {
			return 0;
		}
		return 1 + digit(n/10);
	}
}
