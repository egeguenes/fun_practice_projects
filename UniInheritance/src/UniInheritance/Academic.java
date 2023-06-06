package UniInheritance;

public class Academic extends Worker {
	private String department;
	private String title;
	
	
	public Academic(String nameSurname, String nummer, String eMail, String department, String title) {
		super(nameSurname, nummer, eMail);
		this.department = department;
		this.title = title;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void vorlesung() {
		System.out.println(this.getNameSurname() + " ist in der Vorlesung!");
	}
}
