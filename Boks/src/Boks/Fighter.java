package Boks;

public class Fighter {
    String name;
	double damage;
	double health;
	int weight;
    int dodge;
	
	Fighter(String name, Double damage, Double health, int weight, int dodge){
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.weight = weight;
        this.dodge = dodge;
	}
    public double hit(Fighter foe) {
        
        if (foe.isDodge()){
            System.out.println(foe.name + " gelen Hasari blokladi!");
            return foe.health;
        }
        if (foe.health - this.damage < 0){
            System.out.println(this.name + " => " + foe.name + " " + this.damage + " vurdu!");
            return 0;
        }
        System.out.println(this.name + " => " + foe.name + " " + this.damage + " vurdu!");
		return foe.health - this.damage;
	}
    public boolean isDodge(){
        double randomValue = Math.random() * 100;  //0.0 to 99.9
        return randomValue <= this.dodge;
    }
}
