package com.appdev.SCT.service;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.SCT.model.Teacher;
import com.appdev.SCT.repository.TeacherRepository;


@Service
public class TeacherService {


    @Autowired
    private TeacherRepository TeacherRepository;

    public void save(Teacher teacher) {
    	TeacherRepository.save(teacher); 
    }
    
    public void findAll(Teacher teacher) {
    	TeacherRepository.findAll();
    }
    
    public Teacher findByteacherId(String teacherId) {
        return TeacherRepository.findByteacherId(teacherId); // Fetch user from database
    }
   public Teacher findByTeacherIdAndPassword(String teacherId, String password) {
        return TeacherRepository.findByTeacherIdAndPassword(teacherId, password);
    }


    	
}
