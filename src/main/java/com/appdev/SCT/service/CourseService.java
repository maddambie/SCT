package com.appdev.SCT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.SCT.model.Course;
import com.appdev.SCT.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
    private CourseRepository CourseRepository;
	
	public void findAll(Course course) {
    	CourseRepository.findAll();
    }
		
    public Course findById(int id) {
        return CourseRepository.findById(id); // Fetch user from database
	}
    
    public List<Course> findCoursesByProgramAndYearLevel(String program ,int yearLevel,String status) {

		return CourseRepository.findCoursesByProgramAndYearLevel(program, yearLevel,status);
    }
}


