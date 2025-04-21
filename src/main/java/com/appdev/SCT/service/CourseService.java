package com.appdev.SCT.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.appdev.SCT.model.Course;
import com.appdev.SCT.repository.CourseRepository;

public class CourseService {
	
	@Autowired
    private CourseRepository CourseRepository;
	
	public void findAll(Course course) {
    	CourseRepository.findAll();
    }
}
