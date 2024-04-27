package com.algorithmswiki.apps.backend.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algorithmswiki.apps.backend.backend.Service.CustomSQLService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class Register {
    @Autowired
    private CustomSQLService customSQLService;

    // @GetMapping("/api/register")
    // public String register(@RequestParam String username, @RequestParam String password,
    //                        @RequestParam String fullname, @RequestParam String email) throws JsonProcessingException {
        
    // }
}
