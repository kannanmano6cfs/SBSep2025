package com.example.EmployeeService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class employeeController {

    @Autowired
    private Environment env;

    @GetMapping("/api")
    public String api() {
        return "Hello World!! Server is running on port "+env.getProperty("server.port");
    }
}
