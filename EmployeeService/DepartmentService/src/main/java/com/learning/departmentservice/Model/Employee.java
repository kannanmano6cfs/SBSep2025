package com.learning.departmentservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int empid;
    private String empname;
    private int empage;

    public Employee() {
    }
    public Employee(int empid, String empname, int empage) {
        this.empid = empid;
        this.empname = empname;
        this.empage = empage;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public int getEmpage() {
        return empage;
    }

    public void setEmpage(int empage) {
        this.empage = empage;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", empage=" + empage +
                ']';
    }
}
