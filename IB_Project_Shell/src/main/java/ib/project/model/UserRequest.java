package ib.project.model;

public class UserRequest {
	private String fname;
	private String lname;
	private String username;
	private String pass;
	private String email;
	
	
	public UserRequest() {
		super();
	}


	public UserRequest(String fname, String lname, String username, String pass, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.pass= pass;
		this.email = email;
	}


	public String getFirstname() {
		return fname;
	}


	public void setFirstname(String fname) {
		this.fname = fname;
	}


	public String getLastname() {
		return lname;
	}


	public void setLastname(String lname) {
		this.lname = lname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return pass;
	}


	public void setPassword(String password) {
		this.pass = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}
