package Patates;

public class Circle{
	private double radius;
	private static double radienSum;
	private static int kreisAnzahl;
	private final double PI = Math.PI;
	
	public Circle(double radius){
		this.radius = radius;
		radienSum += this.radius;
		kreisAnzahl++;
	} public double kreisUmfang(){
		return PI*radius*2;
	} public double kreisFlache() {
		return PI*radius*radius;
	} public boolean isLarger(Circle other) {
		return this.radius>other.radius;
	} public static double averageRadius(){
		return radienSum/kreisAnzahl;
	} public double getRadius(double radius) {
		return radius;
	} public void setRadius(double radius) {
		radienSum -= this.radius;
		this.radius = radius;
		radienSum += radius;
	}
}