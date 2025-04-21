package com.appdev.SCT.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String studentid;

	    @Column(nullable = false)
	    private String fullname;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String department;
	    
	    @Column(nullable = false)
	    private String yearlevel;
	    
	    @Column(nullable = false)
	    private String password; 

	    @Column(nullable = false)
	    private String program;

	    // ✅ Default constructor (Required by JPA)
	    public User() {}

	    // ✅ Parameterized constructor
	    public User(String studentid, String fullname, String email,String department,String yearlevel, String password, String program) {
	        this.studentid = studentid;
	        this.fullname = fullname;
	        this.email = email;
	        this.department = department;
	        this.yearlevel = yearlevel;
	        this.password = password;
	        this.program = program;
	    }

	    // ✅ Add Getters (Required for Thymeleaf)
	    public Long getId() {
	        return id;
	    }

	    public String getStudentid() {
	        return studentid;
	    }

	    public String getFullname() {
	        return fullname;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    public String getYearlevel() {
	        return yearlevel;
	    }

	    
	    
	    public String getPassword() {
	        return password;
	    }

	    public String getProgram() {
	        return program;
	    }

	    // ✅ Add Setters (Optional, but useful)
	    public void setId(Long id) {
	        this.id = id;
	    }

	    public void setStudentid(String studentid) {
	        this.studentid = studentid;
	    }

	    public void setFullname (String fullname) {
	        this.fullname = fullname;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public void setDepartment (String department) {
	        this.department = department;
	    }
	    
	    public void setYearlevel (String yearlevel) {
	        this.yearlevel = yearlevel;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public void setProgram(String program) {
	        this.program = program;
	    }
}

