public class LetterWheel extends SymbolWheel {
	private Symbol[] symbol = new Symbol[7];

	public LetterWheel() {
		super();
		for (int i=0; i<symbol.length; i++) {
			symbol[i] = new Letter((char) ('A' + i)); // ASCII Tabelle :)
		}
	}

	@Override
	public Symbol currentSymbol() {
		return symbol[number];
	}

	@Override 
	public String currentSymbolAsString() {
		return symbol[number].asString();
	}
}