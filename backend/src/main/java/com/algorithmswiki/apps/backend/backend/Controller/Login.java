package com.algorithmswiki.apps.backend.backend.Controller;

import java.util.Date;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algorithmswiki.apps.backend.backend.JSONHelper;
import com.algorithmswiki.apps.backend.backend.SHA512;
import com.algorithmswiki.apps.backend.backend.Object.ErrorObject;
import com.algorithmswiki.apps.backend.backend.Service.CustomSQLService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class Login {
    @Autowired
    private CustomSQLService customSQLService;

    @GetMapping("/api/login")
    public String login(@RequestParam String username, @RequestParam String password) throws JsonProcessingException {
        boolean isValid = customSQLService.validateUser(username, password);

        SHA512 sha512 = new SHA512();

        if (isValid) {
            String jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                .signWith(
                    SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(
                        sha512.get_SHA512_SecurePassword(
                            (username + password), 
                            "" + System.currentTimeMillis()
                        ).getBytes()
                    )
                )
                .compact();
            
            return jwtToken;
        } else {
            ErrorObject errorObject = new ErrorObject(500, "Invalid username or password. Please try again");

            return JSONHelper.toJSON(errorObject).toString();
        }
    }
}
