package com.appdev.SCT.model;

import jakarta.persistence.Id;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

//import jakarta.persistence.Lob;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
@Entity
@Table(name = "student_enrollment_hdr")
public class StudentEnrollmentHdr {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = false)
	    private String studentid;
	    
	    @Column(nullable = false, unique = false)
	    private String courseid;

	    @Column(nullable = false, unique = false)
	    private int year_level;

	    @Column(nullable = false, unique = false)
	    private int status;
	    
	    @CreationTimestamp
	    @Column(name = "created_date", updatable = false)
	    private LocalDateTime created_date;
	    
	    public StudentEnrollmentHdr() {}

	    // ✅ Parameterized constructor
	    public StudentEnrollmentHdr(String studentid, String courseid, int year_level, int status) {
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

	    public int getYear_level() {
	        return year_level;
	    }
	    
	    public int getStatus() {
	        return status;
	    }
	    
	    public LocalDateTime getCreated_date() {
	        return created_date;
	    }
}