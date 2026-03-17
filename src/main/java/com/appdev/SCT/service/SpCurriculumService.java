package com.appdev.SCT.service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class SpCurriculumService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> runSPCurriculum(String studentid,String courseid,int year_level, int queryType) {

        String sql = "CALL sp_curriculum(?, ?, ?, ?)";

        return jdbcTemplate.queryForList(
                sql,
                year_level,
                studentid,
                courseid,
                queryType
        );
    }
}