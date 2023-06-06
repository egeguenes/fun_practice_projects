package Zoo;

public class Animal {
	private String animalName;
	private int animalAge;
	private static int animalCount = 0;
	
	Animal(String animalName , int animalAge){
		this.animalName = animalName;
		this.animalAge = animalAge;
		animalCount++;
	}
	public void printNameAndAge() {
		System.out.println("Animal Name : " + this.animalName + " | Animal Age : " + this.animalAge);
	}
	public static int getAnimalCount() {
		return animalCount;
	}
	public void makeNoise() {
		System.out.println("Generic Animal Noise ");
	}
	
}
