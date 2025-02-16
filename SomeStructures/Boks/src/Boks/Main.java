package Boks;

public class Main {
    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("Ege" , 10.0 , 100.0 , 80 , 23);
        Fighter fighter2 = new Fighter("Patat" , 15.0 , 100.0 , 120 , 38);
        //Fighter fighter3 = new Fighter("Atat" , 25 , 100 , 70 , 100);

        Match match1 = new Match(fighter1, fighter2, 80, 120);
        match1.run();

        //Match match2 = new Match(fighter1 , fighter3 , 80 , 100);
        //match2.run();
    }
}
