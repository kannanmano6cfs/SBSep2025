package com.learning.payrollservice.Service;

import com.learning.payrollservice.Model.OTPData;
import com.learning.payrollservice.Repository.otpRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class otpService {

    @Autowired
    private otpRepository otpRepo;

    //send otp
    @Transactional
    public String sendOTP(int empid, String email){
        String otp=String.format("%06d", new Random().nextInt(999999));
        OTPData otpdata=new OTPData(empid,email,otp);
        otpRepo.save(otpdata);
        return "OTP "+otp+" sent successfully";
    }

    //verify otp
    @Transactional
    public String verifyOTP(int empid, String email, String otp){
        Optional<OTPData> otp1=otpRepo.findById(empid);
        if(otp1.isPresent()){
            if(otp1.get().getOtp().equals(otp)){
                return "OTP verified successfully";
            }
        }
        return "Invalid OTP";
    }
}
