package com.infosys.infybank.customerdemo03crudhibernate5;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDAO implements ICustomer {
        /* Method to create a customer record */
        public void addCustomer(Customer c1) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                session.save(c1);
                tx.commit();
                session.close();
        }
        /* Method to read customer details */
        public void readCustomer(int customerId) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Customer cust = session.get(Customer.class, customerId);
                System.out.println("Name : " + cust.getCustomerName());
                session.close();
        }
        /* Method to update a customer record */
        public void updateCustomer(Integer customerId, String name) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                Customer cust = session.get(Customer.class, customerId);
                cust.setCustomerName(name);
                session.update(cust);
                tx.commit();
                session.close();                
        }
        /* Method to delete a customer from the records */
        public void deleteCustomer(Integer customerId) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                Customer cust = session.get(Customer.class, customerId);
                session.delete(cust);
                tx.commit();
                session.close();
        }
}

