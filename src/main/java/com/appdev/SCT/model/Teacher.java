package com.appdev.SCT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherId;
    private String fullN;
    private String email;
    private String phone;
    private String department;
    private String facultyId;
    private String password;
    private String eduBack;
    private int experience;
    
    public Teacher() {}
    // ✅ Parameterized constructor
    public Teacher(String teacherId, String fullN, String email, String phone, String department, String facultyId, String password, String eduBack, int experience) {
        this.teacherId = teacherId;
        this.fullN = fullN;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.facultyId = facultyId;
        this.password = password;
        this.eduBack = eduBack;
        this.experience = experience;
    }
      
    // Getters and Setters     
    public String getteacherId() {
    	return teacherId; 
    }
    public void setteacherId(String teacherId) {
    	this.teacherId = teacherId;
    }
	public String getFullName() {
		return fullN;
	}
	public void setFullName(String fullN) {
		this.fullN = fullN;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEducationalBackground() {
		return eduBack;
	}
	public void setEducationalBackground(String eduBack) {
		this.eduBack = eduBack;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
    
}