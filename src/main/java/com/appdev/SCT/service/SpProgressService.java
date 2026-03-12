package com.appdev.SCT.service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class SpProgressService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> runSPProgress(String program, int yearLevel,String studentId,int id, int queryType) {

        String sql = "CALL sp_progress(?, ?, ?, ?, ?)";

        return jdbcTemplate.queryForList(
                sql,
                program,
                yearLevel,
                studentId,
                id,
                queryType
        );
    }
}