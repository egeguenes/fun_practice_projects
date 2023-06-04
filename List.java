public class List{
	public static void main(String[] args) {
		int[] list = {15, 4, 6, 45, 5, 23};
		int sum = 0;
		for (int i=0; i<list.length; i++){
			sum += list[i];	
		}
		double average = sum / list.length;
		System.out.println(average);
		// es gibt den Durchschnitt der Zahlen aus.
	}
}