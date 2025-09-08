package com.example.EmployeeService.Controller;

import com.example.EmployeeService.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class employeeController {

    @Autowired
    private Environment env;

    //Get Methods
    @GetMapping("/api/{i}")
    public String api(@PathVariable int i) {
        return "Hello World!! Server is running on port "+env.getProperty("server.port")+
                " Value obtained in url is "+i;
    }

    @GetMapping("/api1")
    public String api1(@RequestParam int i) {
        return "Hello World!! Server is running on port "+env.getProperty("server.port")+
                " Value obtained in url is "+i;
    }

    //Post Methods
    @PostMapping("/api2")
    public ResponseEntity<String> api2(@RequestBody Employee emp){
        Employee emp1 = new Employee();
        emp1.setEmpid(emp.getEmpid());
        emp1.setEmpname(emp.getEmpname());
        emp1.setEmpage(emp.getEmpage());
        return new ResponseEntity<String>("Details added: "+emp1, HttpStatus.OK);
    }
    //Put Methods

    //Delete Methods

    //Caching

    //Filtering

    //Paging

    //Request Validation

}
