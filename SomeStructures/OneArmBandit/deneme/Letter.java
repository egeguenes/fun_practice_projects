public class Letter extends Symbol {
	private char letter;

	public Letter(char letter) {
		super();
		this.letter = letter;
	}

	@Override
	public String asString() {
		return Character.toString(letter);
	}

	@Override
	public boolean equals(Symbol symbol) {
		if (symbol instanceof Letter) {
			return this.letter==((Letter)symbol).letter;
		}
		return false;
	}
}