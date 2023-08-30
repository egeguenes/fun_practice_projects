public class Test {
    static int f(int n) {
        int k = 0;
        m: for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0 && n % j == 0)
                    continue m;
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        for (int i = 6; i <= 7; i++) {
            System.out.printf("f(%d) = %d%n", i, f(i));
        }
    }
}
