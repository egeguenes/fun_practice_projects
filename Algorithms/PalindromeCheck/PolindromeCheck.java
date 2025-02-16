public class PolindromeCheck {
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("ERROR!");
		} else {
			System.out.println(check(args[0]));
		}
	}

	public static boolean check(String input) {
		String output = "";
		for (int i=input.length() - 1 ; i >= 0 ; i-- ) {
			output += input.charAt(i) + "";
		}
		if (output.equals(input)) {
			return true;
		}
		return false;
	}

}