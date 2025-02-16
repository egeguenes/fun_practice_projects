package UniInheritance;

public class Main {
	public static void main(String[] args) {
		Officer w1 = new Officer("Ege" , "01" , "eguns@abc.de" , "Patates" , "Pazar");
		w1.work();
		Lehrer l1 = new Lehrer("Patlican" , "02" , "p@a.de" , "Patlican Odasi" , "Patlican" , "31");
		l1.eylem();
		l1.vorlesung();
	}
}
