package com.appdev.SCT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.SCT.model.Teacher;
import com.appdev.SCT.repository.TeacherRepository;


@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void registerTeacher(Teacher Teacher) {
        teacherRepository.save(Teacher);
    }
}