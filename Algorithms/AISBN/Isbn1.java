import java.util.Scanner;

public class Isbn1{
	public static void main(String[] args){
		Scanner ant = new Scanner(System.in);
		boolean dongu = false;
		String s1;
		if (args.length!=17){
			while(!dongu){
				System.out.println("Sie haben eine fehlerhafte ISBNNummer eingegeben!");
				System.out.println("Geben Sie bitte eine Neue ein : ");
				s1 = ant.next();
				if (s1.length()==17){
					if(isbnCheck(s1)){
						System.out.println("ISBN valid");
						dongu = true;
					} else{ 
						System.out.println("ISBN invalid");	
						dongu = true;
					} 
				dongu = true;
				}
			}
		} else {
			if(isbnCheck(args[0])){
				System.out.println("ISBN valid");
			} else{ 
				System.out.println("ISBN invalid");	
			} 

		} 
	}
	public static boolean isbnCheck(String s){
		int sum = 0;
		for (int i=0; i<s.length(); i++){
			if (s.charAt(i)>45){
				if (i%2==0){
					sum += (s.charAt(i)-48) * 3;
				} else {
					sum += (s.charAt(i)-48);
				}
			} else{
				i--;
			}
		}
		if (sum%10==(s.charAt(s.length()-1)-48)){
			return true;
		} 
		return false;
	}
}