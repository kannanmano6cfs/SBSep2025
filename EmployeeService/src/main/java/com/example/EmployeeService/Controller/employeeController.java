package com.example.EmployeeService.Controller;

import com.example.EmployeeService.Model.Employee;
import com.example.EmployeeService.Repository.employeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class employeeController {

    @Autowired
    private Environment env;

    @Autowired
    private employeeRepository repo;

    @Autowired
    private RestTemplate restTemplate;

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
    @PostMapping("/new/v1")
    public ResponseEntity<String> api2(@RequestBody Employee emp){
        repo.save(emp);
        return new ResponseEntity<String>("New Employee details added successfully" , HttpStatus.OK);
    }

    @PostMapping("/new/v2")
    public ResponseEntity<String> newemp(){
        Employee emp=new Employee();
        emp.setEmpname("Abhijit");
        emp.setEmpage(35);
        repo.save(emp);
        return new ResponseEntity<>("New Employee details added successfully" , HttpStatus.OK);
    }
    //Put Methods
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editEmployee(@PathVariable int id, @RequestBody Employee emp){
        Employee emp1 = repo.findById(id).orElseThrow();
        emp1.setEmpname(emp.getEmpname());
        emp1.setEmpage(emp.getEmpage());
        repo.save(emp1);
        return new ResponseEntity<>("Employee details updated successfully" , HttpStatus.OK);
    }

    //Delete Methods
    //To delete all the employee details
    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        repo.deleteAll();
        return new ResponseEntity<>("All Employee details deleted successfully" , HttpStatus.OK);
    }

    //To delete the employee by ID
    @DeleteMapping("/delete/v1/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        repo.deleteById(id);
        return new ResponseEntity<>("Employee details deleted successfully" , HttpStatus.OK);
    }

    //To delete the employee by name
    //    @DeleteMapping("/delete/v2/{name}")
    //    public ResponseEntity<String> deleteEmployeeV2(@PathVariable String name) {
    //        repo.deleteByEmpname(name);
    //        return new ResponseEntity<>("Employee details deleted successfully" , HttpStatus.OK);
    //    }

    //Inter-Service Communication
    private static final String deptsvc_API="http://localhost:8082/newemp";

    @GetMapping("/selectemp/{id}")
    @Transactional
    public ResponseEntity<String> selectEmployee(@PathVariable int id) {
        Optional<Employee> emp=repo.findById(id);

        ResponseEntity<String> response=restTemplate.postForEntity(deptsvc_API,emp,String.class);

        return response;
    }
    //Caching

    //Filtering

    //Paging

    //Request Validation

}
