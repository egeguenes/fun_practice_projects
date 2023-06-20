public class PiggyBank implements Lootable {
	private double money;

	PiggyBank() {
		money = 0.0;
	}

	public double loot() {
		double lootAmount = money;
		if (lootAmount>0.0) {
			System.out.println("LOOTED!");
			System.out.println(money + " wurde gelootet.");
			money = 0.0;
			return lootAmount;
		} else {
			System.out.println("LOOT ATTEMPT!" + "\nAber da gabs kein Geld :D");
			return 0.0;
		}
	}

	public void deposit(double geld) {
		if (geld > 0) {
			kontoStand += geld;
		}
	}
}