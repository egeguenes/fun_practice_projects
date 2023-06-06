package Zoo;

public class Elephant extends Animal{
	private String continent;
	
	public Elephant(String animalName , int animalAge , String continent) {
		super(animalName , animalAge);
		this.continent = continent;
	}
	public void printNameAndAge() {
		super.printNameAndAge();
		System.out.println("Continent : " + this.continent);
	}
	@Override
	public void makeNoise() {
		System.out.println("Bauuuwww");
	}
}
