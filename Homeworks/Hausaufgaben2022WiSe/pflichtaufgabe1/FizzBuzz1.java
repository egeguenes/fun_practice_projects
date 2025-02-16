// FizzBuzz Algorithm aber mit zusaetz Aufgaben!

import java.util.Scanner;

public class FizzBuzz1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bis zu welcher Zahl möchten Sie zaehlen ? ");
        int n = scan.nextInt();
        String[] type = new String[n];
        Scanner input = new Scanner(System.in);

        for (int i=1 ; i<=n ; i++) {
            String a = input.nextLine().toLowerCase();
            if ( a.equals(fizzBuzzErsetzer(i))) {
                type[i-1] = fizzBuzzErsetzer(i);
            } else {
                System.out.println("Es soll eigentlich " + fizzBuzzErsetzer(i) + " sein!!");
                type[i-1] = fizzBuzzErsetzer(i);
            }
            arrayOutputTeil(type, i);
            System.out.println();
        }

        arrayOutput(type);
    }

    public static String fizzBuzzErsetzer(int b) {
        if ( b%3==0 && b%5!=0 ) {
            return "fizz" ;
        } else if ( b%3!=0 && b%5==0) {
            return "buzz" ;
        } else if ( b%15==0 ) {
            return "fizzbuzz" ;
        } else {
            return String.valueOf(b);
        }
    }

    public static void arrayOutput(String[] string) {
        for (int i=0 ; i<string.length ; i++) {
            System.out.print(string[i]);
        }
    }

    public static void arrayOutputTeil(String[] string , int a) {
        for (int i=0 ; i<a ; i++) {
            System.out.print(string[i] + " , ");
        }
    }
}