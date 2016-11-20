
public class Student {
	private String ID;
	private String name;
	private String email;
	private double gpa;
	
	public Student(String iD, String name, String email, double gpa) {
		super();
		ID = iD;
		this.name = name;
		this.email = email;
		this.gpa = gpa;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	

}
