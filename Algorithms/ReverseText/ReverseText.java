public class ReverseText {
	
	public static void main(String[] args) throws IllegalArgumentException {
		if ( args.length == 1 ) {
			System.out.println(reverse(args[0]));
		} else {
			//throw IllegalArgumentException;
		}
	} 

	public static String reverse(String text) {
		String output = "";
		for ( int i=text.length() - 1 ; i >=0 ; i-- ) {
			output += "" + text.charAt(i);
		}
		return output;
	}
}