package com.appdev.SCT.model;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
@Entity
@Table(name = "program_list")
public class Program {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;	 


	    @Column(nullable = false, unique = false)
	    private String courseid;
	    
	    @Column(nullable = false, unique = false)
	    private String name;

	    @Column(nullable = false, unique = false)
	    private String description;

	    @Column(nullable = false, unique = false)
	    private String type;
	    
	    
	    public Program() {}

	    // ✅ Parameterized constructor
	    public Program(String courseid, String name, String description, String type) {
	        this.courseid = courseid;
	        this.name = name;
	        this.description = description;
	        this.type = type;
	    }

	    // ✅ Add Getters (Required for Thymeleaf)
	    public Long getId() {
	        return id;
	    }
	    public String getCourseid() {
	        return courseid;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    
	    public String getType() {
	    	return type;
	    }
}
