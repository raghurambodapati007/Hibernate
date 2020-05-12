package com.infosys.infybank.employeedemo;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class EmpOperations implements EmployeeCRUDIntf{
    /* Method to  READ all the employees */
   public  void listEmployees( Session session ){
          Transaction tx = null;
          tx = session.beginTransaction();
          /*using hibernate query language session.createQuery("FROM Employee"), you will study more in HQL*/
          List employees = session.createQuery("FROM Employee").list();
          for (Iterator iterator = employees.iterator(); iterator.hasNext();){
            Employee employee = (Employee) iterator.next();
            System.out.print("Emp id: " + employee.getEno());
            System.out.print("   Name: " + employee.getEname());
            System.out.println("  Salary: " + employee.getEsalary());
         }
         tx.commit();
     }
    /* Method to create employee record */
   public  void addEmployee(Employee e1,Session session) {
        Transaction tx = null;
        tx = session.beginTransaction();
        session.save(e1);
        tx.commit();     
   } 
       /* Method to UPDATE salary for an employee */
   public  void updateEmployee(Integer employeeID, int salary,Session session ){
      Transaction tx = null;
      tx = session.beginTransaction();
      Employee employee = (Employee)session.get(Employee.class, employeeID);
      employee.setEsalary( salary );
      session.update(employee);
      tx.commit();
  }
    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer employeeID,Session session){
      Transaction tx = null;
      tx = session.beginTransaction();
      Employee employee = (Employee)session.get(Employee.class, employeeID);
      session.delete(employee);
      tx.commit();
  }
}


