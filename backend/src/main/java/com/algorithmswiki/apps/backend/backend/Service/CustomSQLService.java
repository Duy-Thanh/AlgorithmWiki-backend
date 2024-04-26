package com.algorithmswiki.apps.backend.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomSQLService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomSQLService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean validateUser(String username, String password) {
        String sql = "SELECT COUNT(*) FROM UserAccount WHERE username = ? AND userpass = ?";
        try {
            int count = jdbcTemplate.queryForObject(sql, new Object[]{username, password}, Integer.class);
            return count > 0;
        } catch (IncorrectResultSizeDataAccessException e) {
            return false;
        }
    }
}
