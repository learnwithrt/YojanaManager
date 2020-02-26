package com.yojana.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Project_ID;
	@Column(name="Project_Name",nullable=false,unique=true)
	private String Project_name;
	@Column(name="Project_Description")
	private String Project_description;
	@Column(name="Project_Duration",nullable=false)
	private int Project_Duration;//duration in months for the project
	@Column(name="Project_Manager",nullable=false)
	private String Project_Manager;
	@Column(name="Project_photo")
	private byte[] Project_photo;
	
	public Project() {
		
	}
	public Project(String project_name, String project_description, int project_Duration, String project_Manager,
			byte[] project_photo) {
		super();
		Project_name = project_name;
		Project_description = project_description;
		Project_Duration = project_Duration;
		Project_Manager = project_Manager;
		Project_photo = project_photo;
	}
	public int getProject_ID() {
		return Project_ID;
	}
	public void setProject_ID(int project_ID) {
		Project_ID = project_ID;
	}
	public String getProject_name() {
		return Project_name;
	}
	public void setProject_name(String project_name) {
		Project_name = project_name;
	}
	public String getProject_description() {
		return Project_description;
	}
	public void setProject_description(String project_description) {
		Project_description = project_description;
	}
	public int getProject_Duration() {
		return Project_Duration;
	}
	public void setProject_Duration(int project_Duration) {
		Project_Duration = project_Duration;
	}
	public String getProject_Manager() {
		return Project_Manager;
	}
	public void setProject_Manager(String project_Manager) {
		Project_Manager = project_Manager;
	}
	public byte[] getProject_photo() {
		return Project_photo;
	}
	public void setProject_photo(byte[] project_photo) {
		Project_photo = project_photo;
	}
	
	
}
