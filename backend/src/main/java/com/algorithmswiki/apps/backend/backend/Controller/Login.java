package com.algorithmswiki.apps.backend.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algorithmswiki.apps.backend.backend.JSONHelper;
import com.algorithmswiki.apps.backend.backend.JWTTokenGenerator;
import com.algorithmswiki.apps.backend.backend.Object.ErrorObject;
import com.algorithmswiki.apps.backend.backend.Object.LoginObject;
import com.algorithmswiki.apps.backend.backend.Service.CustomSQLService;

@RestController
public class Login {
    @Autowired
    private CustomSQLService customSQLService;

    @GetMapping("/api/login")
    public String login(@RequestParam String username, @RequestParam String password) throws Exception {
        boolean isValid = customSQLService.validateUser(username, password);

        if (isValid) {
            LoginObject loginObject = new LoginObject(JWTTokenGenerator.createJwtToken(username, password), null, 200);
            
            return JSONHelper.toJSON(loginObject).toString();
        } else {
            ErrorObject errorObject = new ErrorObject(500, "Invalid username or password. Please try again");

            return JSONHelper.toJSON(errorObject).toString();
        }
    }
}
