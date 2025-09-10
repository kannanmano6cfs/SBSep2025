package com.learning.departmentservice.Controller;

import com.learning.departmentservice.Model.Department;
import com.learning.departmentservice.Model.Employee;
import com.learning.departmentservice.Repository.departmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class departmentController {

    @Autowired
    private departmentRepository repo;

    @PostMapping("/newemp")
    @Transactional
    public ResponseEntity<String> newemp(@RequestBody Employee emp) {
        Department dept=new Department();
        dept.setDepname("HR");
        dept.setEmpid(emp.getEmpid());
        dept.setEmpname(emp.getEmpname());
        repo.save(dept);
        return new ResponseEntity<>("Department details added for employee", HttpStatus.OK);
    }

    @GetMapping("/departments")
    public Iterable<Department> getDepartments() {
        return repo.findAll();
    }
}
