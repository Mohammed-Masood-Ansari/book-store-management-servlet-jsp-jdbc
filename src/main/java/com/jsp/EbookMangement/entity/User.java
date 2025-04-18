package com.jsp.EbookMangement.entity;

public class User {

	
	private int id;
	private String name;
	private String email;
	private String password;
	private long phno;
	
	private String adress;
	private String landmark;
	private String city;
	private String state;
	private String pincode;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(String email, String adress, String landmark, String city, String state, String pincode) {
		super();
		this.email = email;
		this.adress = adress;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public long getPhno() {
		return phno;
	}



	public void setPhno(long phno) {
		this.phno = phno;
	}



	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phno=" + phno
				+ ", adress=" + adress + ", landmark=" + landmark + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
	
	
	
	
	
}
