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
		
    public List<Studentcourses> findByCourseid(String courseid) {
        return StudentcoursesRepository.findByCourseid(courseid);
    }
    
    public List<Studentcourses> findByStudentid(String studentid) {
        return StudentcoursesRepository.findByStudentid(studentid);
    }
}


