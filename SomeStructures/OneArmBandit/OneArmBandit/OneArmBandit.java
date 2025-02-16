public class OneArmBandit {
	private SymbolWheel[] sWheel = new SymbolWheel[3];

	public OneArmBandit(Symbol symbol) {
		if (symbol instanceof Number) {
			for (int i=0; i<3; i++) {
				sWheel[i] = new NumberWheel();
			}
		} else {
			for (int i=0; i<3; i++) {
				sWheel[i] = new LetterWheel();
			}
		}
	}	

	public boolean spin() {
		for (int i=0; i<3; i++){
			sWheel[i].spin();
		}
		return sWheel[0].currentSymbol().equals(sWheel[1].currentSymbol()) && sWheel[1].currentSymbol().equals(sWheel[2].currentSymbol());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(sWheel[0].currentSymbolAsString()).append(" ").append(sWheel[1].currentSymbolAsString()).append(" ").append(sWheel[2].currentSymbolAsString());
		return sb.toString();
	}
}