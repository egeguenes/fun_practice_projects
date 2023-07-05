import java.util.Scanner;
import java.util.Random;

public class E8 {
	private static Random rnd = new Random();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Geben Sie die Laenge ein : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		initArray(arr , n);
		printArray(arr , n);
		System.out.println("\nLargest Element : " + largestElement(arr , n));
		/*	long startTime = System.nanoTime();
			System.out.println("\nLargest Element : " + findMax(arr , 0 , n-1));
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;	
			System.out.println(totalTime);
		*/
	} //5651034 (Eges Code)
	  //6171591 (ChatgptCode)

	public static int largestElement(int[] arr , int n) {
		if (n==0) {
			return 0;
		}
		return Math.max(arr[n-1] , largestElement(arr , n-1));
	}

	public static void initArray(int[] arr , int n) {
		if (n==0) {
			return;
		}
		arr[n-1] = rnd.nextInt(100);
		initArray(arr , n-1);
	}

	public static void printArray(int[] arr , int n) {
		if (n==0) {
			return;
		}
		System.out.print(arr[n-1] + "\t");
		printArray(arr , n-1);
	}

	/*   Chatgpt
	public static int findMax(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int mid = (start + end) / 2;
        int leftMax = findMax(arr, start, mid);
        int rightMax = findMax(arr, mid + 1, end);
        return Math.max(leftMax, rightMax);
    }
    */
}