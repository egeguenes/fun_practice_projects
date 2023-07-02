import java.util.Random;
import java.util.Scanner;

public class MasterMind {

    private static Random rnd = new Random();
    private static Scanner scan = new Scanner(System.in);
    private static int[] code = new int[4];
    
    //int a = rnd.nextInt(8) + 1 --> eine zufallige zahl von 1 bis 8;
    public static void main(String[] args) {
        String codeString = codeErsteller();
        int versuche = 0;
        System.out.println("\nWilkommen! In diesem Spiel ist Ihre Aufgabe : dieses Code zu cracken.\n" +
                            "Das code besteht aus 4 Ziffern, die unterschiedlich sind!\n" + 
                            "Außerdem sind die Ziffern von 1 bis 8\n");
        while (versuche != 10) {
            System.out.print("Geben Sie Ihre Annahme ein : ");
            String eingabe = scan.nextLine();
            if (eingabeControl(eingabe)) {
                if (codeRight( eingabe , codeString )) {
                    System.out.println("Sie hats gefunden : Code : " + codeString + "\tEingabe : " + eingabe);
                    break;
                } else {
                    codeControl( eingabe , codeString );
                    versuche++;
                }
            } else {
                System.out.println("Eingabe muss 4 stellig sein!\n");
                continue;
            }
        }
        if (versuche==10) {
            System.out.println(codeString);
        }
        

    }

    public static void codeControl(String a , String b) {
        if ( eingabeControl(a) ) {
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++) {
                    if ( a.charAt(i) == b.charAt(j)) {
                        if (i == j) {
                            System.out.println(Character.toString(a.charAt(i)) + " ist ricthig");
                        } else {
                            System.out.println(Character.toString(b.charAt(j)) + " ist enthalten!");
                        }
                    }
                }
            }
        }
    }

    public static boolean codeRight( String a , String b ) {
        if ( eingabeControl(a) && eingabeControl(b) ) {
            if ( a.equals(b) ) {
                return true;
            }
        }
        return false;
    }

    public static String codeErsteller() {
        for (int i=0; i<4; i++) {
            code[i] = rnd.nextInt(8) + 1;
        }

        if ((code[0] != code[1]) && (code[1] != code[2]) && (code[2] != code[3])) {
            String codeSon = "";
            for (int i=0; i<4; i++) {
                codeSon += String.valueOf(code[i]);
            }
            return codeSon;
        } else {
            return codeErsteller();
        }
    }

    public static boolean eingabeControl(String s) {
        if (s.length() == 4) {
            return true;
        }
        return false;
    }
    
}