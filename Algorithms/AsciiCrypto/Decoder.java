public class Decoder {
	private int decoderOverlap;

	public Decoder( int number ) {
		this.decoderOverlap = number % 256;
	}

	public String decoder( String cipheredMessage ) {
		StringBuilder result = new StringBuilder();
        char[] messageChars = cipheredMessage.toCharArray();
        for (int i = 0; i < messageChars.length; i++) {
            result.append((char) ((messageChars[i] - decoderOverlap) % 65536));
        }
        return result.toString();
	}

	public int getDecoderOverlap() {
		return this.decoderOverlap;
	}

	public void setDecoderOverlap( int newDecoderOverlap ) {
		this.decoderOverlap = newDecoderOverlap;
	}
}