public class Number extends Symbol {
	private int number;

	public Number(int number) {
		super();
		this.number = number;
	}

	@Override 
	public String asString() {
		return Integer.toString(number);
	}

	@Override
	public boolean equals(Symbol symbol) {
		if (symbol instanceof Number) {
			return this.number==((Number)symbol).number; 
		}	
		return false;
	}
}