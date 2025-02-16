package UniInheritance;

public class Lehrer extends Academic {
	private String doorNummer;
	
	public Lehrer(String nameSurname, String nummer, String eMail , String department , String title , String doorNummer) {
		super(nameSurname, nummer, eMail, department, title);
		this.doorNummer = doorNummer;
	}
	public String getDoorNummer() {
		return doorNummer;
	}
	public void setDoorNummer(String doorNummer) {
		this.doorNummer = doorNummer;
	}
	public void eylem() {
		System.out.println(this.getNameSurname() + " patlican topladi ve " + this.getDoorNummer() + " odasina birakti!!");
	}
}
