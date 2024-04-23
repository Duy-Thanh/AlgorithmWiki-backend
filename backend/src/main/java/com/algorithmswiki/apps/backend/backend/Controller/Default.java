package com.algorithmswiki.apps.backend.backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algorithmswiki.apps.backend.backend.JSONHelper;
import com.algorithmswiki.apps.backend.backend.Object.ErrorObject;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class Default {
    @GetMapping("/Default")
    public String getDefault() throws JsonProcessingException {
        // Create object
        ErrorObject defaultObject = new ErrorObject(500, "API Endpoint not accepted GET method");
        
        String JSON = JSONHelper.toJSON(defaultObject);

        return JSON;
    }
}
