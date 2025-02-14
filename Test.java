public class Test {

    public static void main(String[] felder) {
        if ( felder.length != 9 ) {
            throw new IllegalArgumentException("ungültige laenge");
        }
        for ( String feld : felder ) {
            if ( !feld.equals("x") && !feld.equals("-") && !feld.equals("o") ) {
                throw new IllegalArgumentException("Illegal Argument");
            }
        }
        System.out.println(bestimmen(felder));
    }

    public static String bestimmen( String[] felder ) {
        int[][] optionen = {{0,1,2} , {3,4,5} , {6,7,8} , {0,3,6} , {1,4,7} , {2,5,8} , {0,4,8} , {2,4,6}};
        for ( int i=0 ; i < optionen.length ; i++ ) {
            if ( (felder[optionen[i][0]].equals(felder[optionen[i][1]])) && (felder[optionen[i][1]].equals(felder[optionen[i][2]])) ) {
                return felder[optionen[i][0]];
            }
        }
        return "-";
    }
}
