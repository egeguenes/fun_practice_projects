public abstract class BankAccount {
	
	private double kontoStand;
	private String name;

	public void deposit(double num) {
		if (num>0) {
			kontoStand += num;  
		}
	}

	public abstract void withdraw(); //nur wenn kontoStand>0 ist.

	public double getKontoStand() {
		return kontoStand;
	}

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public void setKontoStand(double num) {
		kontoStand = num;
	}
}