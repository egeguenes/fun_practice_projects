package Boks;
import java.util.Random;

public class Match {
    Fighter f1;
	Fighter f2;
	int wMin;
	int wMax;
	
	Match(Fighter f1, Fighter f2, int wMin, int wMax) {
		this.f1 = f1;
		this.f2 = f2;
		this.wMin = wMin;
		this.wMax = wMax;
	}
	public void run() {
		if (isCheck()) {
			System.out.println("Match has started!!!");
			Random rnd = new Random();
            int first = rnd.nextInt(2);
			while (this.f1.health>0 && this.f2.health>0) {

                System.out.println("=====NEW ROUND=====");
				
				if(first==1){
                    this.f2.health = this.f1.hit(f2);
                    if (isWin()){
                        break;
                    }
                    this.f1.health = this.f2.hit(f1);
                } else {
                    this.f1.health = this.f2.hit(f1);
                    if (isWin()){
                        break;
                    }
                    this.f2.health = this.f1.hit(f2);
                }
	    	} System.out.println(this.f1.name + " Health : " + this.f1.health + " // " + this.f2.name + " Health : " + this.f2.health);
              System.out.println();
	    } else {
			System.out.println("Sikletler uyumsuz!");
		}
    
    }
	public boolean isCheck() {
		return (this.f1.weight>=wMin && this.f1.weight<=wMax) && (this.f2.weight<=wMax && this.f2.weight>=wMin);
	}    
    public boolean isWin(){
        if (this.f1.health == 0){
            System.out.println(this.f2.name + " kazandi!!!");
            System.out.println(this.f2.name + " Health : " + this.f2.health);
            return true;
        }
        if (this.f2.health == 0){
            System.out.println(this.f1.name + " kazandi!!!");
            System.out.println(this.f1.name + " Health : " + this.f1.health);
            return true;
        }
        return false;
    }
} /*this.f2.health = this.f1.hit(f2);
                    
if (isWin()){
    break;
}
this.f1.health = this.f2.hit(f1);
if (isWin()){
    break;
} */
