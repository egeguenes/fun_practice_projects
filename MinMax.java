import java.util.Scanner;

public class MinMax{
	public static void main(String[] args) {
		System.out.println("Array Length : ");
		Scanner ant = new Scanner(System.in);
		int lLength = ant.nextInt();
		int[] list = new int[lLength];
		for (int i=0; i<lLength; i++){
			System.out.println("Geben Sie bitte " + (i+1) + ". Zahl ein : ");
			list[i] = ant.nextInt();
		}
		int lMax = list[0];
		int lMin = list[0];
		for (int i=0; i<lLength; i++){
			if (list[i]>list[0]){
				lMax = list[i];
			}
			if (list[i]<list[0]){
				lMin = list[i];
			}
		}
		System.out.println("Max : " + lMax + " | Min : " + lMin);
	}
}