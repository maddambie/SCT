package com.appdev.SCT.model;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
@Entity
@Table(name = "Course_list")
public class Course {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String Course;
	    
	    @Column(nullable = false, unique = false)
	    private String Department;

	    @Column(nullable = false, unique = true)
	    private String Program;

	    @Column(nullable = false, unique = false)
	    private String Degree;
	    
	    @Lob
	    @Column(nullable = false, columnDefinition = "TEXT" )
	    private String Description;
	    
	    public Course() {}

	    // ✅ Parameterized constructor
	    public Course(String course, String department, String program, String degree) {
	        this.Course = course;
	        this.Department = department;
	        this.Program = program;
	        this.Degree = degree;
	    }

	    // ✅ Add Getters (Required for Thymeleaf)
	    public Long getId() {
	        return id;
	    }

	    public String getCourse() {
	        return Course;
	    }

	    public String getDepartment() {
	        return Department;
	    }

	    public String getProgram() {
	        return Program;
	    }
	    
	    public String getDegree() {
	        return Degree;
	    }
	    
	    public String getDescription() {
	    	return Description;
	    }
}
