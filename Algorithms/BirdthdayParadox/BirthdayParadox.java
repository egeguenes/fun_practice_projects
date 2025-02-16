public class BirthdayParadox {
    public static void main(String[] args) {
        double p = 1.0;
        int n = 2;
        while (p > 0.5) {
            p *= (365.0 - (n - 1)) / 365.0;
            System.out.println("p(" + n + ") = " + (1 - p));
            n++;
        }
        System.out.println("Minimum number of people for probability > 50%: " + (n - 1));
    }
}