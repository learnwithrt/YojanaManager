package com.yojana.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int T_ID;
	String T_Name;
	int Project_ID;
	LocalDate T_start_date;
	LocalDate T_end_date;
	String T_description;
	String T_assigned_to;//Whom is the task assigned to
	int T_parent;//Which task is the parent of this task
	public Task() {
		
	}
	public Task(String t_Name, int project_ID, LocalDate t_start_date, LocalDate t_end_date, String t_description,
			String t_assigned_to, int t_parent) {
		super();
		T_Name = t_Name;
		Project_ID = project_ID;
		T_start_date = t_start_date;
		T_end_date = t_end_date;
		T_description = t_description;
		T_assigned_to = t_assigned_to;
		T_parent = t_parent;
	}
	public int getT_ID() {
		return T_ID;
	}
	public void setT_ID(int t_ID) {
		T_ID = t_ID;
	}
	public String getT_Name() {
		return T_Name;
	}
	public void setT_Name(String t_Name) {
		T_Name = t_Name;
	}
	public int getProject_ID() {
		return Project_ID;
	}
	public void setProject_ID(int project_ID) {
		Project_ID = project_ID;
	}
	public LocalDate getT_start_date() {
		return T_start_date;
	}
	public void setT_start_date(LocalDate t_start_date) {
		T_start_date = t_start_date;
	}
	public LocalDate getT_end_date() {
		return T_end_date;
	}
	public void setT_end_date(LocalDate t_end_date) {
		T_end_date = t_end_date;
	}
	public String getT_description() {
		return T_description;
	}
	public void setT_description(String t_description) {
		T_description = t_description;
	}
	public String getT_assigned_to() {
		return T_assigned_to;
	}
	public void setT_assigned_to(String t_assigned_to) {
		T_assigned_to = t_assigned_to;
	}
	public int getT_parent() {
		return T_parent;
	}
	public void setT_parent(int t_parent) {
		T_parent = t_parent;
	}
	
}
