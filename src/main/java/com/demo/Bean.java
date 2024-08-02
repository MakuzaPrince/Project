package com.demo;

public class Bean {
	
	String email;
	String psswd;
	
	public Bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bean(String email, String psswd) {
		super();
		this.email = email;
		this.psswd = psswd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPsswd() {
		return psswd;
	}
	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}
	
}
