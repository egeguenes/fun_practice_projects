import java.util.Random;
import java.util.Scanner;

public class E4 {

	private static Random rnd = new Random();
	private static Scanner scan = new Scanner(System.in);
	private static int[] array;
	private static int counter;
	
	public static void main(String[] args) {
		System.out.print("Die Laenge von Array : ");
		int b = scan.nextInt();
		array = new int[b];
		initArray(b);
		printArray(array);
	}

	public static void printArray(int[] arr) {
		try {
			if (arr[counter]>=0) {
				System.out.print("Element " + (counter+1) + " ");
				System.out.print(arr[counter] + "\n");
				counter++;
				printArray(arr);
			}

		} catch (Exception e) {

		}
	}

	public static void initArray(int a) {
		if (a>0) {
			array[a-1] = rnd.nextInt(100);
			initArray(a-1);
		} if (a==0) {
			array[a] = rnd.nextInt(100);
		}
	}
}