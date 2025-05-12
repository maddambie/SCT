package com.appdev.SCT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appdev.SCT.model.Course;
import com.appdev.SCT.model.Studentcourses;


@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {
	 Course findById(int id);
	 
	 
	 @Query(value = """
	    SELECT a.* 
	    FROM course_list a 
	    JOIN studentcourses b ON a.program = b.courseid 
	    WHERE a.program = :program AND b.year_level = :yearLevel
	    LIMIT 1
	""", nativeQuery = true)
	List<Course> findCoursesByProgramAndYearLevel(@Param("program") String program,
	                                              @Param("yearLevel") int yearLevel);

}
