package UniInheritance;

public class Worker {
	private String nameSurname;
	private String nummer;
	private String eMail;
	
	Worker(String nameSurname, String nummer, String eMail){
		this.nameSurname = nameSurname;
		this.nummer = nummer;
		this.eMail = eMail;
	}
	
	public String getNameSurname() {
		return nameSurname;
	}
	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}
	
	public String getNummer() {
		return nummer;
	}
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
	
	public String getEMail() {
		return eMail;
	}
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	
	public void enter() {
		System.out.println(this.nameSurname + " has entered to Uni!");
	}
	
	public void getOut() {
		System.out.println(this.nameSurname + " has gotten out of the Uni!");
	}
	
	public void mensa() {
		System.out.println(this.nameSurname + " is in the Mensa!");
	}
}
