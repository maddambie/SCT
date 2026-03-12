package com.appdev.SCT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev.SCT.model.Course;
import com.appdev.SCT.model.StudentEnrollmentHdr;


@Repository
public interface StudentEnrollmentHdrRepository extends JpaRepository<StudentEnrollmentHdr, Long> {

	List<StudentEnrollmentHdr> findByStudentid(String studentId);
	
	StudentEnrollmentHdr findBystudentid(String courseid);
	
}