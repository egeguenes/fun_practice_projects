public class CheckingAccount extends BankAccount implements Lootable{
	
	private double dispoLimit;

	CheckingAccount(double kontoStand , String name , double dispoLimit) {
		super(kontoStand , name);
		this.dispoLimit = dispoLimit;
	}

	@Override
	public void withdraw(double num) {
		if (num>0 && getKontoStand() - num >= -dispoLimit) {
			getKontoStand(getkontoStand() - num);
		}
	}
	
	@Override
	public void loot() {
		double lootAmount = getKontoStand();
		if (lootAmount>0) {
			setKontoStand(0.0);
			return lootAmount;
		} else {
			return 0.0;
		}

	}

	public double getDispoLimit() {
		return dispoLimit;
	}

	public void setDispoLimit(double num) {
		dispoLimit = num;
	}
}