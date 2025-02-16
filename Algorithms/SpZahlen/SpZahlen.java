public class SpZahlen {
	
	public static void main(String[] args) {
		if ()
	}

	public static boolean sphenisch(int n) {
		int counter = 0;
		for ( int divider = 2 ; divider <= n ; divider++ ) {
			if ( n % divider == 0 ) {
				while ( n % divider == 0 ) {
					n /= divider;
				}
				counter++;
			}
		}
		if ( counter == 3 ) {
			return true;
		}
		return false;
	}
}