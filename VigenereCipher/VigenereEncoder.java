public class VigenereEncoder {
	private String message;
	private String key;

	public VigenereEncoder( String message , String key ) {
		this.message = message;
		this.key = key;
		if ( key.length() < message.length() ) {

		}
	}

	public void keyEditor( String message , String key ) {
		assert key.length() < message.length();
		char[] keyElements = key.toCharArray();
		for ( int i = 0 ; i < message.length() - key.length() ; i++ ) {
					
		}
	}
}