import java.util.Scanner;

public class E6 {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Geben Sie eine Zahl ein : ");
		int a = scan.nextInt();
		System.out.println("Die Summe von Digits : " + digitSum(a));
	}

	public static int digitSum(int n) {
		if (n==0) {
			return 0;
		}
		return n%10 + digitSum(n/10);
	}

}