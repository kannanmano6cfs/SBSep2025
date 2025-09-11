package com.learning.payrollservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OTPData {

    @Id
    private int empid;
    private String email;
    private String otp;

    public OTPData() {
    }

    public OTPData(int empid, String email, String otp) {
        this.empid = empid;
        this.email = email;
        this.otp = otp;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
