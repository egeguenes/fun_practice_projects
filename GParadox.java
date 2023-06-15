public class GParadox{
	public static void main(String[] args){
		double product = 1.0;
		int n = 2;
		for (int i=2; i<=365; i++){
			product *= (366.0-i)/365.0;
			System.out.println("p(" + i + ") = " + (1-product));
			if ((1-product) >= 0.5){
				System.out.println("p(" + i + ")" + " = " + (1-product));
				System.out.println("GRÖßER!!!!");
				System.out.println(i);
			}
		}
	}
}