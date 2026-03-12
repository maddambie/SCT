package com.appdev.SCT.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "student_enrollment_lin")
public class StudentEnrollmentLin {
	
	@Column
    private int id;
    @Column(nullable = false, unique = false)
    private String studentid;
    
    @Column(nullable = false, unique = false)
    private String subject_code;
    
    @Column(nullable = false, unique = false)
    private int completed;
    
    @Column(nullable = false, unique = false)
    private int status;
    
    @Column(nullable = true, unique = false)
    private Float prelim;
    
    @Column(nullable = true, unique = false)
    private Float midterm;
    
    @Column(name="final",nullable = true, unique = false)
    private Float finalGrade;
    
    @Column(nullable = true, unique = false)
    private String remarks;
}
