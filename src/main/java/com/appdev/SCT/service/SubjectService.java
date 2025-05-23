package com.appdev.SCT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.SCT.model.Course;
import com.appdev.SCT.model.Subject;
import com.appdev.SCT.repository.SubjectRepository;

@Service  // <- ADD THIS
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public void findAll(Subject subject) {
        subjectRepository.findAll();
    }

    public List<Subject> findByCourseid(String courseid) {
        return subjectRepository.findByCourseid(courseid);
    }
    
    
    public List<Subject> findSubjectByCourseidAndYearLevel(String courseid ,int yearLevel, String studentid) {

		return subjectRepository.findSubjectByCourseidAndYearLevel(courseid, yearLevel, studentid);
    }
}
