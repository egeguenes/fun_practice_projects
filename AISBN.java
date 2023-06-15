//es gibt einen Fehler mit einer ISBN Nummer und ich konnte es leider nicht finden, woran es liegt!
public class AISBN{
	public static void main(String[] args) {
		String s = args[0];
		int n = 0;
		int summe = 0;
		int patat = s.length();
		for (int i=0; i<s.length()-1; i++){
			if(s.charAt(i) == 45){
				continue;
			} else {
				if (n%2==0){
					summe += (s.charAt(i)-48);
				} else {
					summe += ((s.charAt(i)-48)*3);
				}
				n++;
			}
		}
		int a = Math.max((10-summe%10), summe%10);
		if (a == (s.charAt(patat-1)-48)){
			System.out.println("ISBN : " + s + " ist gültig!");
		} else {
			System.out.println("ISBN : " + s + " ist leider nicht gültig :( ");
			s = s.substring(0,patat-1) + a;
			System.out.println("Richtige ISBN waere : " + s);
		}

	}	
}