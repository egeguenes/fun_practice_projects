import java.util.Scanner;

public class Palindrom{
	public static void main(String[] args) {
		if (args.length>0){
			System.out.println(PalindromDetektor(args[0]));
		} else{
			System.out.println("Geben Sie ein Wort ein : ");
			Scanner scan = new Scanner(System.in);
			String patat = scan.next();
			System.out.println(PalindromDetektor(patat));
		}
		
	}
	public static boolean PalindromDetektor(String term){
		int len = term.length();
		term = term.toLowerCase();// to lower case
		for (int i=0; i<len/2; i++){
			if (term.charAt(i) != term.charAt(len-1-i)){
				return false;
			} 
		} return true;
		
	}
}