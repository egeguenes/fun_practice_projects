public class E1 {

	public static void main(String[] args) {
		System.out.println("natural numbers are : ");
		numberShow(1);
	}

	public static void numberShow(int n) {
		if (n<=50) {
			System.out.printf(n + "\t");
			numberShow(n+1);
		}
	}
}
