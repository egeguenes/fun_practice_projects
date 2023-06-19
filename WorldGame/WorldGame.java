import java.util.Scanner;
import java.util.Random;


public class WorldGame{
	private Scanner scan = new Scanner(System.in);
	private Random rnd = new Random();
	private int groesse = 5;
	private Map map;
	private Player[] spieler = new Spieler[2];
	private int[] spielerPunkte0;
	private int[] spielerPunkte1;
	private int runde;

	public WorldGame(){
		map = new Map(5);
		Systm.out.println("Die Karte vom Spielbeginn : ");
		System.out.println(map.draw());

		for (int i=0; i<2; i++){
			System.out.println("Geben Sie den Namen von Spieler : " + (i+1));
			String name = scan.nextLine();
			spieler[i] = new Player(name);
		}
		int currentSpielerIndex = rnd.nextInt(2);
		System.out.println("Es wird entschieden, wer beginnt");
		System.out.println("...");
		System.out.println(spieler[currntSpielerIndex].getName() + " beginnt...");
		System.out.println();

		boolean patat = true;
		while ()
	}

	public static void main(String[] args) {
		
	}
}