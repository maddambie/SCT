package com.appdev.SCT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev.SCT.model.Subject;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long> {
	 Subject findById(int id);

	 List<Subject> findByCourseid(String courseid);
}