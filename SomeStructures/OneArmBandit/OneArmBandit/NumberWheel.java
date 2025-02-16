public class NumberWheel extends SymbolWheel {
	private Number nummer;
	private Symbol[] symbol = new Symbol[7];

	public NumberWheel() {
		super();
		for (int i=0; i<7; i++) {
			symbol[i] = new Number(i);
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