import java.util.Scanner;

public class Isbn{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a 13-digit ISBN number (with or without dashes): ");
		String s1 = scanner.next();
		s1 = s1.replace("-", "");
		if (s1.length() != 13){
			System.out.println("Invalid ISBN: must be 13 digits long.");
			return;
		}
		int sum = 0;
		int multiplier = 1;
		for (int i = 0; i < 12; i++){
			int digit = Integer.parseInt(s1.substring(i, i + 1));
			sum += digit * multiplier;
			multiplier = (multiplier == 1) ? 3 : 1;
		}
		int checkDigit = 10 - (sum % 10);
		if (checkDigit == 10) checkDigit = 0;
		if (checkDigit != Integer.parseInt(s1.substring(12))) {
			System.out.println("Incorrect check digit. Correct ISBN: " + s1.substring(0, 12) + checkDigit);
		} else {
			System.out.println("Valid ISBN.");
		}
	}
}
