package com.example.EmployeeService.Controller;

import com.example.EmployeeService.Model.Employee;
import com.example.EmployeeService.Repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class employeeController {

    @Autowired
    private Environment env;

    @Autowired
    private employeeRepository repo;

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

    // Data JPA Rest Methods
    //To Display all the employee details
    @GetMapping("/employees")
    public Iterable<Employee> employees() {
        return repo.findAll();
    }

    //To display the count of the employee details
    @GetMapping("/count")
    public ResponseEntity<String> count(){
        long ct=repo.count();
        return new ResponseEntity<>("Number of Employees is "+ct, HttpStatus.OK);
    }

    //To display the employee by empID (PathVariable)
    @GetMapping("/employee/v1/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Optional<Employee> emp=repo.findById(id);
        return emp.orElse(null);
    }

    //To display the employee by empname (RequestParam)
    @GetMapping("/employee/v2")
    public Employee getEmployeeV2(@RequestParam String name) {
        Optional<Employee> emp=repo.findByEmpname(name);
        return emp.orElse(null);
    }

    //To display the employee by empname with Custom Query (RequestParam)
    @GetMapping("/employee/v3")
    public Employee getEmployeeV3(@RequestParam String name) {
        Optional<Employee> emp=repo.findByEmpnameLike(name);
        return emp.orElse(null);
    }

    //Post Methods
    @PostMapping("/new")
    public ResponseEntity<String> api2(@RequestBody Employee emp){
        Employee emp1 = new Employee();
        emp1.setEmpid(emp.getEmpid());
        emp1.setEmpname(emp.getEmpname());
        emp1.setEmpage(emp.getEmpage());
        repo.save(emp1);
        return new ResponseEntity<String>("New Employee details added successfully" , HttpStatus.OK);
    }
    //Put Methods

    //Delete Methods

    //Caching

    //Filtering

    //Paging

    //Request Validation

}
