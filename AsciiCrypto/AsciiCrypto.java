import java.util.Scanner;

public class AsciiCrypto {

	public static void main( String[] args ) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Ceaser Cipher Adaptation by Ege Günes, nut the best but still something!\n");
		System.out.print("Message to be encoded: \n");
		String message = scan.nextLine();
		int key;
        while (true) {
            System.out.println("Enter the encryption key (an integer):");
            if (scan.hasNextInt()) {
                key = scan.nextInt();
                break; // exit the loop if a valid integer is provided
            } else {
                System.out.println("Invalid input. Please enter a valid integer for the key.");
                scan.next(); // consume the invalid input
            }
        }
		Encoder enc = new Encoder(key);
		Decoder dec = new Decoder(key);

		String cipheredMessage = enc.encoder(message);
        System.out.println("Encrypted message: " + cipheredMessage);

        String uncipheredMessage = dec.decoder(cipheredMessage);
        System.out.println("Decrypted message: " + uncipheredMessage);
        cipheredMessage = enc.encoder(message);
        System.out.println("Encrypted message (numeric values): " + getNumericValues(cipheredMessage));

        uncipheredMessage = dec.decoder(cipheredMessage);
        System.out.println("Decrypted message (numeric values): " + getNumericValues(uncipheredMessage));
	}
	private static String getNumericValues(String input) {
        StringBuilder numericValues = new StringBuilder();
        for (char c : input.toCharArray()) {
            numericValues.append((int) c).append(" ");
        }
        return numericValues.toString();
    }

}