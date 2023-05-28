package Patates;

public class Main{
	public static void main(String[] args) {

	Circle circle1 = new Circle(15.0);
	Circle circle2 = new Circle(3.0);
	
	System.out.println(circle2.kreisUmfang());
	System.out.println(circle1.kreisFlache());
	System.out.println(circle2.isLarger(circle2));
	System.out.println(Circle.averageRadius());
	circle1.setRadius(2.0);
	System.out.println(Circle.averageRadius());
	}
}