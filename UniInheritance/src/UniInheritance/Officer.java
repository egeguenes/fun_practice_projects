package UniInheritance;

public class Officer extends Worker {
	private String facility;
	private String wDays;
	Officer(String nameSurname , String nummer , String eMail , String facility , String wDays){
		super(nameSurname , nummer , eMail);
		this.facility = facility;
		this.wDays = wDays;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getWDays() {
		return wDays;
	}
	public void setWDays(String wDays) {
		this.wDays = wDays;
	}
	public void work() {
		System.out.println(this.getNameSurname() + " is working!");
	}
		
}
