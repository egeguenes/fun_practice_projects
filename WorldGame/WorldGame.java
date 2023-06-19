import java.util.Scanner;
import java.util.Random;


public class WorldGame{
	private Scanner scan = new Scanner(System.in);
	private Random rnd = new Random();
	private int groesse = 5;
	private Map map;
	private Player[] spieler;
	private int[] spielerPunkte0;
	private int[] spielerPunkte1;

	public WorldGame(){
		for (int i=0; i<2; i++){
			System.out.println("Geben Sie den Namen von Spieler : " + (i+1));
			String name = scan.next();
			spieler[i] = new Player(name);
		}
	}

	public static void main(String[] args) {
		
	}
}