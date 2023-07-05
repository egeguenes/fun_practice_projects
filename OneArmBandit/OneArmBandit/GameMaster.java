import java.util.Scanner;

public class GameMaster {
	private static OneArmBandit numbers;
	private static OneArmBandit letters;
	private static int runde = 0;
	private static boolean numbersWon = false;
	private static boolean lettersWon = false; 
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		runGame();	
	}

	public static void runGame() {
		numbers = new OneArmBandit(new Number(1));
		letters = new OneArmBandit(new Letter('A'));
		System.out.println("\nWilkommen zum OneArmBandit!!\n");
		System.out.print("Tippen Sie <S> zum Spielen : ");
		String s = scan.nextLine().toUpperCase();

		switch (s) {
			case "S" :
				while (true) {
					runde++;
					System.out.println("Runde : " + runde);
					if (!lettersWon) {
						if (letters.spin()) {
							System.out.println("Letter Maschine ist in " + runde + " gewonnen!");
							lettersWon = true;
						}
					}
					System.out.println(letters.toString());
					if (!numbersWon) {
						if (numbers.spin()) {
							numbersWon = true;
						}
					}
					System.out.println(numbers.toString());
					System.out.println("------------------------");
					if (numbersWon && lettersWon) {
						System.out.println("Das Spiel wurde in " + runde + " Runden gewonnen!!!!!");
						break;
					}
				}
				break;
			default :
				System.out.println("Ungültige Index!");
				s = scan.nextLine().toUpperCase();
				break;
		}

		

	}
}