package prime;

import java.util.Scanner;

/**
 * Main class for the prime checker
 * 
 * @author David Gemen
 */
public class PrimeMain {

    /**
     * main function, program starts here.
     * 
     * @param args command line arguments, first argument taken as number
     */
    public static void main(String[] args) {

        // get number with scanner
        System.out.print("Bitte Nummer eingeben: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        if (PrimeChecker.isPrime(number)) {
            System.out.println("Die Zahl ist eine Primzahl");
        } else {
            System.out.println("Die Zahl ist keine Primzahl");
        }
    }

}
