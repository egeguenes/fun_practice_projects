package Zoo;

public class Tiger extends Animal{
	
	public Tiger(String animalName , int animalAge) {
		super(animalName , animalAge);
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Roar!");
	}
}
