package com.learning.payrollservice.Repository;

import com.learning.payrollservice.Model.OTPData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface otpRepository extends JpaRepository<OTPData, Integer> {

}
