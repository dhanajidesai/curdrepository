package mysql.database.com.register;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegisterModel {

	private String fname;
	private String lname;
	@Id
	private String email;
	private String password;
	private String phone_number;
	
	
	public RegisterModel() {

	}
	
	public RegisterModel(String fname, String lname, String email, String password, String phone_number) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	
}
