package com.appdev.SCT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev.SCT.model.Subject;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long> {
	 Subject findById(int id);

	Subject findByCourseid(String courseid);
}