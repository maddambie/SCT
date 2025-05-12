package com.appdev.SCT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev.SCT.model.Program;


@Repository
public interface ProgramRepository  extends JpaRepository<Program, Long> {

	 List<Program> findByCourseid(String courseid);
}