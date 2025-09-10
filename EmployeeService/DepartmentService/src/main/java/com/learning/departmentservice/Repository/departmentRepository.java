package com.learning.departmentservice.Repository;

import com.learning.departmentservice.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentRepository extends JpaRepository<Department, Integer> {
}
