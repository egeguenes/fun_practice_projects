public class Patates {

    public static void main(String[] args) {
        int[] a = {5,2,-5,1,3,-5,-2,4,0};
        specialSort(a);
        for ( int i=0 ; i < a.length ; i++ ) {
            System.out.print(a[i] + " ");
        }
    }

    static void specialSort( int[] a ) {
        if ( a.length <= 0 ) {
            throw new IllegalArgumentException();
        }

        int n = 0;
        int[] newArray = new int[a.length];
        for ( int i = 0 ; i < newArray.length ; i++ ) {
            if ( a[i] == 0 ) {
                newArray[n] = 0;
                n++;
            }
        }
        for ( int b = n ; b < a.length ; b++ ) {
            for ( int c = b ; c < a.length - 1 ; c++ ) {
                if ( a[b] <= a[c+1] ) {
                    newArray[n] = a[b];
                    n++;
                }
            }
        }
        for ( int i = 0 ; i < a.length ; i++ ) {
            if ( newArray[i] == (-1 * newArray[i+1]) && ( newArray[i+1] < newArray[i]) ) {
                newArray[i] = newArray[i+1];
                newArray[i+1] = -1 * newArray[i];
            }
        }
        a = newArray;
    }
}