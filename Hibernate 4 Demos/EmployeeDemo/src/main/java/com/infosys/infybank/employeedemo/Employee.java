package com.infosys.infybank.employeedemo;

public class Employee {
    private int eno;
    private String ename;
    private int esalary;
    public Employee() {
    }
    public Employee(int eno, String ename, int esalary) {
        this.eno = eno;
        this.ename = ename;
        this.esalary = esalary;
    }
    public int getEno() {
        return eno;
    }
    public void setEno(int eno) {
        this.eno = eno;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public int getEsalary() {
        return esalary;
    }
    public void setEsalary(int esalary) {
        this.esalary = esalary;
    }     
}
