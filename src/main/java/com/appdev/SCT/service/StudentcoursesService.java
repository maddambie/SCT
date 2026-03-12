package com.appdev.SCT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.appdev.SCT.model.StudentEnrollmentHdr;
import com.appdev.SCT.repository.StudentEnrollmentHdrRepository;

@Service
public class StudentcoursesService {
	
	@Autowired
    private StudentEnrollmentHdrRepository StudentcoursesRepository;
	
	public void findAll(StudentEnrollmentHdr Studentcourses) {
		StudentcoursesRepository.findAll();
    }
		
    public StudentEnrollmentHdr findBystudentid(String courseid) {
        return StudentcoursesRepository.findBystudentid(courseid);
    }
    

    public void Studentcourses (String studentid) {
        StudentcoursesRepository.findByStudentid(studentid);
    }
    
    
}


