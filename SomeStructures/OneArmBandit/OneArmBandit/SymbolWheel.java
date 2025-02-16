import java.util.Random;

public abstract class SymbolWheel {
	int number;
	Random rnd = new Random();

	public void spin() {
		number = rnd.nextInt(7);
	}

	public abstract Symbol currentSymbol();

	public abstract String currentSymbolAsString();
}