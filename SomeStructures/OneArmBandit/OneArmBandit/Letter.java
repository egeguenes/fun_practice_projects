public class Letter implements Symbol {
	private char letter;

	public Letter(char letter) {
		super();
		this.letter = letter;
	}

	public String asString() {
		return Character.toString(letter);
	}

	public boolean equals(Symbol symbol) {
		if (symbol instanceof Letter) {
			return this.letter==((Letter)symbol).letter;
		}
		return false;
	}
}