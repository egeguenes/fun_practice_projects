// MasterMind Algorithm mit zusaetzlichen Aufgaben!

import java.util.Scanner;
import java.util.Random;

public class MasterMind1 {
    private static Scanner scan = new Scanner(System.in);
    private static Random rnd = new Random();
    private static int versuche = 0;
    private static int code[];
    
    public static void main(String[] args) {
        String codeString;
        if ((args.length != 0)) {
            int codeLength = Integer.parseInt(args[0]);
            if (lengthCheck(codeLength)) {
                initCode(codeLength);
                codeString = codeErsteller(codeLength);
            } else {
                int deneme = codeVersuch();
                codeString = codeErsteller(deneme);
            }
        } else {
            int deneme = codeVersuch();
            codeString = codeErsteller(deneme);
        }
        while (versuche!=10) {
            String annahme = scan.nextLine();
            if (annahme.equals(codeString)) {
                System.out.println("\nHerzlichen Glückwunsch!\nSie haben das Code gecrackt!");
            } else {
                if (annahme.length() == codeString.length()) {
                    codeChecker( annahme , codeString);
                    versuche++;
                }
            }
        }
        if (versuche == 10) {
            System.out.println("\nVerloren! Versuchanzahl : " + versuche );
        }
    }

    public static void codeChecker( String input , String codeString ) {
        assert input.length() == codeString.length();
        if (isStelleSame(codeString)) {
            System.out.println("Das Code enthaltet irewndwo gleiche Stellen, das hab ich noch nicht implementiert :D");
        } else {
            for (int i=0; i<input.length(); i++) {
                for (int j=0; j<input.length(); j++) {
                    if (input.charAt(i) == codeString.charAt(j) && i==j) {
                        System.out.println(input.charAt(i) + " ist der richtigen Stelle und korrekt!");
                    } else if (input.charAt(i) == codeString.charAt(j) && i!=j) {
                        System.out.println(input.charAt(i) + " ist zwar korrekt, aber in der falschen Stelle!");
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    public static String codeErsteller(int codeLength) {
        if (lengthCheck(codeLength)) {
            String code = "";
            for (int i=0; i<codeLength; i++) {
                int digit = rnd.nextInt(8) + 1;
                code += String.valueOf(digit);
            }
            return code;
        }
        return "Ha hah da gibts ein großes Bug in deinem Programm hahahah!!";
    }

    public static void initCode(int codeLength) {
        code = new int[codeLength];
    }

    public static boolean lengthCheck(int codeLength) {
        return codeLength<=8 && codeLength>=1;
    } 

    public static int codeVersuch() {
        System.out.print("Geben Sie eine Zahl ein, um die Laenge zu bestimmen : ");
        int codeVersuchInt = scan.nextInt();
        System.out.println();
        while (!lengthCheck(codeVersuchInt)) {
            System.out.print("Unzulaessig!!! Eine neue Zahl zwischen 1 und 8 bitte : ");
            codeVersuchInt = scan.nextInt();
            System.out.println();
        }
        initCode(codeVersuchInt);
        return codeVersuchInt;
    }

    public static boolean isStelleSame(String code) {
        for (int i=0; i<code.length(); i++) {
            for (int j=0; j<code.length()-1; j++) {
                if (code.charAt(i) == code.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int stelleSameInt(String code) {
        for (int i=0; i<code.length(); i++) {
            for (int j=0; j<code.length()-1; j++) {
                break;
            }
        }
        return 15;
    }
}