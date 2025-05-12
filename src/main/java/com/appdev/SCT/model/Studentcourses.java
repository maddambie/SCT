package com.appdev.SCT.model;

import jakarta.persistence.Id;
//import jakarta.persistence.Lob;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
@Entity
@Table(name = "studentcourses")
public class Studentcourses {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = false)
	    private String studentid;
	    
	    @Column(nullable = false, unique = false)
	    private String courseid;

	    @Column(nullable = false, unique = false)
	    private String year_level;

	    @Column(nullable = false, unique = false)
	    private String status;
	    
	    
	    public Studentcourses() {}

	    // ✅ Parameterized constructor
	    public Studentcourses(String studentid, String courseid, String year_level, String status) {
	        this.studentid = studentid;
	        this.courseid = courseid;
	        this.year_level = year_level;
	        this.status = status;
	    }
	    
	    
	    public Long getId() {
	        return id;
	    }

	    public String getStudentid() {
	        return studentid;
	    }

	    public String getCourseid() {
	        return courseid;
	    }

	    public String getYear_level() {
	        return year_level;
	    }
	    
	    public String getStatus() {
	        return status;
	    }
}