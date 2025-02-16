package Zoo;

public class Main {
	public static void main(String[] args) {
		Animal animal = new Animal("Animal", 5);
        Tiger tiger = new Tiger("Tiger", 3);
        Elephant elephant = new Elephant("Elephant", 7, "Afrika");

        animal.printNameAndAge();
        animal.makeNoise();

        tiger.printNameAndAge();
        tiger.makeNoise();

        elephant.printNameAndAge();
        elephant.makeNoise();

        System.out.println("Anzahl der Tiere: " + Animal.getAnimalCount());
        System.out.println(animal.getAnimalCount());
        System.out.println(tiger.getAnimalCount());
        
	}

}
