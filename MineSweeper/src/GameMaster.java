import java.time.chrono.MinguoDate;
import java.util.Scanner;

public class GameMaster {

    private boolean gameEnd = false;
    private SpielField sf;
    private Scanner input = new Scanner(System.in);

    public GameMaster() {
        this.run();
    }

    public void run() {
        sf = new SpielField( 10 , 23 , 5 );
        sf.draw();
        this.turnMech();
    }

    private void turnMech() {
        while ( sf.allTrue() || !gameEnd ) {
            String[] commandParts = input.nextLine().split("");
            if ( commandParts.length != 2 ) {
                System.out.println("Ausgabe sollte Ziffern[indexNum] sein -- z.B H3 !");
            } else {
                int y = Integer.valueOf( commandParts[0].toUpperCase().charAt(0) - 65 );
                int x = Integer.valueOf( commandParts[1] );
                if ( sf.getPosition( x , y ) instanceof MinedLand) {
                    System.out.println("\nGame Ended, You Have LOST!\n");
                    gameEnd = true;
                } else {
                    sf.change( x , y );
                    sf.draw();
                }
            }
        }
    }

}
