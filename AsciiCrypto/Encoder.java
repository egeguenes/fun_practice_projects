public class Encoder {
	private int encoderOverlap;
	
	public Encoder( int number ) {	// an encoder with overlapping i elements
		this.encoderOverlap = number % 256;
	}

	public String encoder( String message ) {
		String cipheredMessage = "";
		char[] characters = message.toCharArray();
		for ( int i = 0 ; i < characters.length ; i++ ) {
			cipheredMessage += (char) (( characters[i] + encoderOverlap ) % 256 ) + "";
		}
		return cipheredMessage;
	}

	public int getEncoderOverlap() {
		return this.encoderOverlap;
	}

	public void setEncoderOverlap( int newEncoderOverlap ) {
		this.encoderOverlap = newEncoderOverlap % 256;
	}
}