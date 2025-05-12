package com.appdev.SCT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev.SCT.model.Course;
import com.appdev.SCT.model.Studentcourses;


@Repository
public interface StudentcoursesRepository extends JpaRepository<Studentcourses, Long> {

	List<Studentcourses> findByStudentid(String studentId);
	
	Studentcourses findBystudentid(String courseid);
	
	
}