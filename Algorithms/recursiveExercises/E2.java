public class E2 {
	private static int summe = 0;
	
	public static void main(String[] args) {
		System.out.println(func(5));
	}

	public static int func(int n) {
		if (n==0) {
			return summe;
		} else {
			summe += n;
			return func(n-1);
		}
	}
}