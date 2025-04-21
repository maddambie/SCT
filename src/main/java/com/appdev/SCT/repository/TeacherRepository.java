package com.appdev.SCT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.SCT.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}