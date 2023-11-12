class Sort012 {

    // a brute force solution(i guess) to sort all the 0 1 and 2s in the array

    public static void sort012(int a[], int n) {
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;
        for ( int i = 0 ; i < n ; i++ ) {
            if ( a[i] == 0 ) {
                counter0++;
            } else if ( a[i] == 1 ) {
                counter1++;
            } else {
                counter2++;
            }
        }
        for ( int i = 0 ; i < n ; i++ ) {
            if ( counter0 > 0 ) {
                a[i] = 0;
                counter0--;
            } else {
                if ( counter1 > 0 ) {
                    a[i] = 1;
                    counter1--;
                } else {
                    a[i] = 2;
                }
            }
        }
    }
}