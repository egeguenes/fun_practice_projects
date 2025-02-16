public class SavingsAccount extends BankAccount {
	
	SavingsAccount(double kontoStand , String name) {
		super(kontoStand , name);
	}

	@Override
	public void withdraw(double num) {
		if (num>kontoStand) {
			System.out.println("Sie haben nicht so viel Geld : Maximal dürfen Sie " + getKontoStand() + " Euro überziehen");
		} else {
			setKontoStand(getKontoStand() - num);
			System.out.println(num + " Euro wurde überzogen --> Aktuelles Kontostand : " + getKontoStand());
		}
	}
}