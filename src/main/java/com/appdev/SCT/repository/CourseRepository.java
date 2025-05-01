package com.appdev.SCT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.appdev.SCT.model.Course;
import com.appdev.SCT.model.User;


@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {
	 Course findById(int id);
}
