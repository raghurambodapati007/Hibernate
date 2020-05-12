package com.infosys.infybank.employeedemo;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class ClientDemo {
      public static void main(String[] args) {
	   	SessionFactory factory;
        Configuration cfg=new Configuration().configure("/com/infosys/infybank/employeedemo/hibernate.cfg.xml");
        org.hibernate.service.ServiceRegistry serviceRegistry = new       
        ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        factory = cfg.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        EmpOperations empop=new EmpOperations();
        try{
            System.out.println("CREATE");
            System.out.println("Enter the emp details");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the emp no");
            int eid=sc.nextInt();
            System.out.println("Enter the emp name");
            String ename=sc.next();
            System.out.println("Enter the salary");
            int sal=sc.nextInt();
            Employee e1=new Employee(eid,ename,sal);
            empop.addEmployee(e1,session);
            System.out.println("One record created");

            System.out.println("READ");
            System.out.println("Listing the employee details");  
            empop.listEmployees(session);
            System.out.println("UPDATE");
            System.out.println("Enter the empid and new salary");
            System.out.println("Enter the emp no");
            int eid1=sc.nextInt();
            System.out.println("Enter the new  salary ");
            int sal1=sc.nextInt();
            empop.updateEmployee(eid1,sal1,session);
            System.out.println("updated");
            System.out.println("DELETE");
            System.out.println("Enter the empid to delete the employee details of an employee");
            int eid2=sc.nextInt();
            empop. deleteEmployee(eid2,session);
            empop.listEmployees(session);
            System.out.println("deleted");

        }
        catch (HibernateException e) {
        	System.out.println(e.getMessage());
         }
         finally {
               session.close();
         }
     }
}




