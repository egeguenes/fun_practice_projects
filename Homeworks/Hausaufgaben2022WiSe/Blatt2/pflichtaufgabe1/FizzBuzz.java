// FizzBuzz algorithm und pflichtaufgabe

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] type = new String[n];

        for (int i=0 ; i<type.length ; i++ ) {
            
            if ( i == type.length - 1) {
                type[i] = fizzBuzzErsetzer(i+1);
            } else {
                type[i] = fizzBuzzErsetzer(i+1) + ",";
            }
        }
        arrayOutput(type);
    }

    public static String fizzBuzzErsetzer(int b) {
        if ( b%3==0 && b%5!=0 ) {
            return "Fizz" ;
        } else if ( b%3!=0 && b%5==0) {
            return "Buzz" ;
        } else if ( b%15==0 ) {
            return "FizzBuzz" ;
        } else {
            return String.valueOf(b);
        }
    }

    public static void arrayOutput(String[] string) {
        for (int i=0 ; i<string.length ; i++) {
            System.out.print(string[i]);
        }
    }
}