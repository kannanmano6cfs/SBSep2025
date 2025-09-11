package com.learning.payrollservice.Controller;

import com.learning.payrollservice.Service.otpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class otpController {

    @Autowired
    private otpService otpsvc;

    @PostMapping("/send/{id}")
    public ResponseEntity<String> sendOtp(@PathVariable int id, @RequestParam String email){
        return new ResponseEntity<>(otpsvc.sendOTP(id,email), HttpStatus.OK);
    }

    @PostMapping("/verify/{id}")
    public ResponseEntity<String> verifyOtp(@PathVariable int id, @RequestParam String email, @RequestParam String otp){
        return new ResponseEntity<>(otpsvc.verifyOTP(id,email,otp), HttpStatus.OK);
    }
}
