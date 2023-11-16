import java.util.Scanner;

public class AsciiCrypto {

	public static void main( String[] args ) {

		Scanner scan = new Scanner(System.in);
		String message = scan.nextLine();
		Encoder enc = new Encoder(50);
		Decoder dec = new Decoder(50);

		String cipheredMessage = enc.encoder( message );

		System.out.println(cipheredMessage);

		String uncipheredMessage = dec.decoder(cipheredMessage);

		System.out.println(uncipheredMessage);
	}
}