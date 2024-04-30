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

    public boolean registerUser(String username, String password, 
                                String fullName, String email, 
                                String permission) {
        try {
            String reg_sql = "INSERT INTO UserAccount(username, userpass, fullName, email, permission) VALUES (?, ?, ?, ?, ?)";

            int rowAffected = jdbcTemplate.update(reg_sql, username, password, fullName, email, permission);
    
            return rowAffected > 0;    
        } catch (IncorrectResultSizeDataAccessException e) {
            return false;
        }
    }

    public Integer getUserIdByUsername(String username) {
        String query = "SELECT ID FROM UserAccount WHERE username = ?";
        try {
            Integer userId = jdbcTemplate.queryForObject(query, new Object[]{username}, Integer.class);
        
            return userId;    
        } catch (IncorrectResultSizeDataAccessException e) {
            return 0;
        }
    }

    public String getFullNameByUsername(String username) {
        try {
            String query = "SELECT fullName FROM UserAccount WHERE username = ?";
            String fullName = jdbcTemplate.queryForObject(query, new Object[]{username}, String.class);

            return fullName;
        } catch (IncorrectResultSizeDataAccessException e) {
            return "";
        }
    }

    public String getEmailByUsername(String username) {
        try {
            String query = "SELECT email FROM UserAccount WHERE username = ?";
            String email = jdbcTemplate.queryForObject(query, new Object[]{username}, String.class);

            return email;
        } catch (IncorrectResultSizeDataAccessException e) {
            return "";
        }
    }

    public String getPermissionByUsername(String username) {
        try {
            String query = "SELECT permission FROM UserAccount WHERE username = ?";
            String permission = jdbcTemplate.queryForObject(query, new Object[]{username}, String.class);

            return permission;
        } catch (IncorrectResultSizeDataAccessException e) {
            return "";
        }
    }
}

