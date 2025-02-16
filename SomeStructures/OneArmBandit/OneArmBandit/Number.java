public class Number implements Symbol {
	private int number;

	public Number(int number) {
		super();
		this.number = number;
	}

	public String asString() {
		return Integer.toString(number);
	}

	public boolean equals(Symbol symbol) {
		if (symbol instanceof Number) {
			return this.number==((Number)symbol).number; 
		}	
		return false;
	}
}