public class Decoder {
	private int decoderOverlap;

	public Decoder( int number ) {
		this.decoderOverlap = number % 256;
	}

	public String decoder( String cipheredMessage ) {
		String result = "";
		char[] messageChars = cipheredMessage.toCharArray();
		for ( int i = 0 ; i < messageChars.length ; i++ ) {
			result += (char) ((messageChars[i] - decoderOverlap) % 256) + "";
		}
		return result;
	}

	public int getDecoderOverlap() {
		return this.decoderOverlap;
	}

	public void setDecoderOverlap( int newDecoderOverlap ) {
		this.decoderOverlap = newDecoderOverlap;
	}
}