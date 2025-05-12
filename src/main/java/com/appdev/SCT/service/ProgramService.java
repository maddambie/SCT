package com.appdev.SCT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.appdev.SCT.model.Program;


import com.appdev.SCT.repository.ProgramRepository;

@Service
public class ProgramService {
	
	@Autowired
    private ProgramRepository ProgramRepository;
	
	public void findAll(Program program) {
		ProgramRepository.findAll();
    }
		
    public List<Program> findByCourseid(String courseid) {
        return ProgramRepository.findByCourseid(courseid);
    }
}


