public class Circle{
	private double radius;

	private static int circleAmount; 
	private static double radienSum;
	
	private static final double PI = Math.PI;

	public Circle(double radius){
		this.radius = radius;
		radienSum += radius;
		circleAmount++;
	}

	public double circleFlache(){
		return 2*PI*radius;
	}

	public double circleUmfang(){
		return PI*radius*radius; //Math.pow(radius, 2);
	}

	public boolean isLarger(Circle other){
		return this.radius>other.radius;
	}

	public static double averageRadius(){
		return radienSum/circleAmount;
	}

	public double getRadius(double radius){
		return radius;
	}

	public void setRadius(double radius){
		radienSum -= this.radius;
		this.radius = radius;
		radienSum += radius;
	}
}

public class Main{
	public static void main(String[] args){
		Circle circle1 = new Circle(5);
		Circle circle2 = new Circle(10);
		System.out.println("Umfang von Kreis 1 -> " + circle1.circleUmfang());
		System.out.println("Flache von Kreis 1 -> " + circle1.circleFlache());
		System.out.println("Umfang von Kreis 2 -> " + circle2.circleUmfang());
		System.out.println("Flache von Kreis 2 -> " + circle2.circleFlache());
		System.out.println("Zweites Kreis ist kleiner als die erste. " + circle1.isLarger(circle2));
		System.out.println("Die Summe von Radien -> " + Circle.averageRadius());
		circle1.setRadius(15);
		System.out.println("Neue Summe von Radien -> " + Circle.averageRadius());
	}
}