package com.yojana.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@Column(name="User_ID")
	private String User_ID;
	@Column(nullable = false, name="User_Gender")
	private char User_Gender;
	@Column(nullable = false, name="User_Name")
	private String User_Name;
	@Column(nullable = false,unique=true, name="User_email")
	private String User_email;
	@Column(name="User_photo")
	private byte[] User_photo;
	@Column(nullable = false,name="User_password")	
	private String User_password;
	public User() {
		
	}
	public User(String user_ID, char user_Gender, String user_Name, String user_email, byte[]  user_photo,
			String user_password) {
		super();
		User_ID = user_ID;
		User_Gender = user_Gender;
		User_Name = user_Name;
		User_email = user_email;
		User_photo = user_photo;
		User_password = user_password;
	}
	public User(String user_ID, String user_password) {
		super();
		User_ID = user_ID;
		User_password = user_password;
	}
	public String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	public char getUser_Gender() {
		return User_Gender;
	}
	public void setUser_Gender(char user_Gender) {
		User_Gender = user_Gender;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getUser_email() {
		return User_email;
	}
	public void setUser_email(String user_email) {
		User_email = user_email;
	}
	public byte[] getUser_photo() {
		return User_photo;
	}
	public void setUser_photo(byte[] user_photo) {
		User_photo = user_photo;
	}
	public String getUser_password() {
		return User_password;
	}
	public void setUser_password(String user_password) {
		User_password = user_password;
	}
	
}
