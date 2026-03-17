package com.appdev.SCT.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpEnrollmentService {
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    public List<Map<String, Object>> runSPEnrollment(Integer year_level,String studentid ,String courseid , int queryType, String subject) {

	        String sql = "CALL sp_enrollment(?, ?, ?, ?, ?)";

	        return jdbcTemplate.queryForList(
	                sql,
	                year_level,
	                studentid,
	                courseid,
	                queryType,
	                subject
	        );
	    }
}
