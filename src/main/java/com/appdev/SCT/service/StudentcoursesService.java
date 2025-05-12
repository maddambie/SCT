package com.appdev.SCT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.appdev.SCT.model.Studentcourses;
import com.appdev.SCT.repository.StudentcoursesRepository;

@Service
public class StudentcoursesService {
	
	@Autowired
    private StudentcoursesRepository StudentcoursesRepository;
	
	public void findAll(Studentcourses Studentcourses) {
		StudentcoursesRepository.findAll();
    }
		
    public Studentcourses findBystudentid(String courseid) {
        return StudentcoursesRepository.findBystudentid(courseid);
    }
    
    public void Studentcourses (String studentid) {
        StudentcoursesRepository.findByStudentid(studentid);
    }
}


