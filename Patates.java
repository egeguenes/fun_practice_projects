public class Patates {
    public static void main(String[] args) {
        System.out.println(quasifriends(48,75));
        System.out.println(quasifriends(31,12));
        System.out.println(quasifriends(0,-3));
    }

    static boolean quasifriends( int n , int m ) {
        if ( m <= 0 || n <= 0 ) {
            throw new IllegalArgumentException("Eingabe Fehler");
        }
        int nVersuch = 0;
        int mVersuch = 0;
        for ( int i = 2 ; i < n ; i++ ) {
            if ( n % i == 0 ) {
                nVersuch += i;
            }
        }
        for ( int i = 2 ; i < m ; i++ ) {
            if ( m % i == 0 ) {
                mVersuch += i;
            }
        }
        if ( (nVersuch==m) && (mVersuch==n) ) {
            return true;
        }
        return false;
    }

}
