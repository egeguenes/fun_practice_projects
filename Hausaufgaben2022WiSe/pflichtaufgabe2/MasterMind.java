import java.util.Scanner;
import java.util.Random;

public class MasterMind {
    private static Scanner scan = new Scanner(System.in);
    private static Random rnd = new Random();
    private static int versuche = 0;
    private static int code[];
    public static void main(String[] args) {
        System.out.println("\nWilkommen zu Mastermind\n" + "Sie sollen das von Ihnen entschiedene stelliges Code cracken!\n" + "Die Ziffern" + 
                        " sind untrerschiedlich und Sie bekommen ein Feedback, nachdem Sie eine Zahl eingegeben haben!\n");
        System.out.print("Geben Sie die Stelle(min 4, max 8) : ");
        int x = scan.nextInt();
        initCode(x);
        String codeSon = codeErsteller();
        while (versuche < 10) {
            String a = scan.nextLine();
            if (a.length()==code.length) {
                if (Integer.parseInt(a) > 0) {
                    if (a.equals(codeSon)) {
                        System.out.println("Sie haben das Code gecrackt!!\nIhre Eingabe : " + a + " | das Code : " + codeSon);
                        break;
                    } else {
                        codeControl(a , codeSon);
                        System.out.println();
                        versuche++;
                    }
                }
            } else {
                System.out.println("Die versuchende Zahl muss " + code.length + " stellig sein!\n");
            }
            
        }
        if (versuche == 10) {
            System.out.println("Ihre Versuchanzahl : " + versuche);
            System.out.println("Sie haben verloren! Das code war : " + codeSon);
        }
    }

    public static void initCode(int a) {
        code = new int[a];
    }

    public static void codeControl(String b , String c) {
        assert b.length()==code.length && c.length()==code.length;
        for (int i=0; i<code.length; i++) {
            for (int j=0; j<code.length; j++) {
                if (b.charAt(i) == c.charAt(j)) {
                    if (i==j) {
                        System.out.println(b.charAt(i) + " ist richtig und in der richtigen Stelle!");
                    } else {
                        System.out.println(b.charAt(i) + " ist richtig, aber in der falschen Stelle!");
                    }
                }
            }

        }
    }

    public static String codeErsteller() {
        String s = "";
        for (int i=0; i<code.length; i++) {
            code[i] = rnd.nextInt(8) + 1;
            s += String.valueOf(code[i]);
        }
        if (check(code)) {
            return s;
        } else {
            return codeErsteller();
        }
    }

    public static boolean check(int[] arr) {
        assert arr.length == code.length;
        for (int i=0; i<code.length-1; i++) {
            for (int j = i+1; j<code.length; j++) {
                if ( arr[i] == arr[j] ) {
                    return false;
                }
            }
        }
        return true;
    }
}