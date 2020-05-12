package com.infosys.infybank.employeedemo;

import org.hibernate.Session;
public interface EmployeeCRUDIntf {
   public  void listEmployees( Session session );
   public  void addEmployee(Employee e1,Session session);
   public  void updateEmployee(Integer employeeID, int salary,Session session );
   public  void deleteEmployee(Integer employeeID,Session session);
}



