package pseudocode;

//Student class created

public class Student {
	String first;
	String last;
	String email;
	String pass;
	
	Student(String first, String last, String email, String pass){
		this.first = first;
		this.last = last;
		this.email = email;
		this.pass = pass;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String toString() {
		return first+" "+last+" "+email+" "+pass;
	}
}
