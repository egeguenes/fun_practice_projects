public class GameMaster {
	private static OneArmBandit numbers;
	private static OneArmBandit letters;
	private static int runde = 0;
	public static boolean gameWon = false;
	public static int[] patates = new int[1000];
	public static long total = 0;

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		runGame(); // 1000 mal
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		double seconds = (double)totalTime / 1_000_000_000.0;
		System.out.println("Execution time in seconds: " + seconds);

		System.out.println("Duchtschnittliche Anzahl der Runde : " + ( total / patates.length ));
	}

	public static void runGame() {
		numbers = new OneArmBandit(new Number(1));
		letters = new OneArmBandit(new Letter('A'));
		for (int i=0; i<patates.length; i++) {
			runde = 0;
			gameWon = false;
			while (true) {
				runde++;
				//System.out.println("Runde : " + runde);
				if (numbers.spin() && letters.spin() && (numbers.getIndex()==letters.getIndex())) {
					gameWon = true;
				}
				//System.out.println(numbers.toString());
				//System.out.println(letters.toString());
				//System.out.println("------------------");
				if (gameWon) {
					//System.out.println("Das Spiel wurde in " + runde + " Runden gewonnen!!!!!");
					break;
				}
			}
			patates[i] = runde;
			total += patates[i];
		}
		
	}
}
