package palindrome;

/**
 * Main class for the palindrome checker
 * 
 * @author David Gemen
 */
public class PalindromeMain {

    /**
     * main function, program starts here.
     * 
     * @param args command line arguments, all arguments taken as String.
     */
    public static void main(String[] args) {

        String term = args[0];
        term = term.toLowerCase(); // optional

        if (PalindromeChecker.isPalindrome(term)) {
            System.out.println("Der String ist ein Palindrom");
        } else {
            System.out.println("Der String ist kein Palindrom");
        }
    }
}
