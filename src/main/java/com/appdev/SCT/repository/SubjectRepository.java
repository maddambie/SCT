package com.appdev.SCT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appdev.SCT.model.Course;
import com.appdev.SCT.model.Subject;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long> {
	 Subject findById(int id);

	 List<Subject> findByCourseid(String courseid);
	 
	 @Query(value = """
					    SELECT a.* 
			    FROM subject a 
			    JOIN studentcourses b ON a.courseid = b.courseid and b.year_level = a.year_level
			    WHERE a.courseid = :courseid AND b.year_level = :yearLevel AND studentid = :studentid
			""", nativeQuery = true)
			List<Subject> findSubjectByCourseidAndYearLevel(@Param("courseid") String program,
			                                              @Param("yearLevel") int yearLevel,
															@Param("studentid") String studentid);
}