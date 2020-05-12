package com.infosys.infybank.customerdemo02hql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class SelectDemo {
 
  public static void main(String[] args) {
		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;
		Configuration cfg = new Configuration().configure("/com/infosys/infybank/customerdemo02hql/hibernate.cfg.xml");
        cfg.addAnnotatedClass(Customer.class);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(
        cfg.getProperties()).buildServiceRegistry();
        sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
  try{ 
     
          
      //SELECT clause with from
      Query selectClause = session.createQuery("select cust.customerId from Customer cust");
      System.out.println("Displaying customer id from table customer");
      for(Iterator<Integer> li1= selectClause.iterate(); li1.hasNext();)  {
        Integer custId = li1.next();
        System.out.println("Customer Id : "+custId);
      }
      Query query = session.createQuery("from Customer");
      List<Customer> custList = query.list();
      ArrayList<Customer> alist=(ArrayList<Customer>)custList;
      for (Customer elist : alist) {
        System.out.println(elist);
      }
      //SELECT clause with from & where
      Query selectClause1 = session.createQuery("select cust.customerName from Customer cust where cust.customerId = 1002");
      System.out.println("Displaying Name from table employee whose id is 1002");
      for(Iterator<String> li2= selectClause1.iterate(); li2.hasNext();){
        String custName = li2.next();
        System.out.println("Customer Name : "+custName);
      }
  }
 catch (Exception e) {
  System.out.println(e.getMessage());
 }
 finally {
  session.close();
  }
}
}
