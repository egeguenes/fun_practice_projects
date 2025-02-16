    /*Complete the Function below*/
    class GfG
    {
        public static int palinArray(int[] a, int n) {
            for ( int i = 0 ; i < n ; i++ ) {
                String output = "";
                while ( a[i] > 0 ) {
                    int num = a[i] % 10;
                    a[i] /= 10;
                    output += num + "";
                }
                if ( Integer.valueOf(output) != a[i] ) {
                    return 0;
                }
            }
            return 1;
        }
        
        public static void main( String[] args ) {
            int[] patates = {111, 222, 333, 444, 555}; 
            System.out.println(palinArray( patates , 5 ));
        }
    }