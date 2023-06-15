public class GParadox{
	public static void main(String[] args){
		
		for (int i=2; i<=60; i++){
			System.out.println("p(" + i + ") = " + p(i));
			if (p(i)>= 0.5){
				System.out.println("p(" + i + ") GRÖßER!!!");
			}
		}
	}

	public static double p(double n){
		double product = 1.0;
		for (int i=1; i<=n; i++){
			product *= (365.0-i+1)/365.0;
		}
		return 1-product;
	}
}