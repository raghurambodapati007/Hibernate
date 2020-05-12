package com.infybank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerDAO implements OtoOCustomer {
	SessionFactory factory;
	 
	/* Method to creates new customer record with new locker */
	public void addNewCustomerNewLocker(Customer c1,Locker l1) {
		c1.setLocker(l1);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(c1);       // saving the customer details internally saves the locker deteails also
		tx.commit();
		session.close();
	}
 
	/* Method to creates new customer record */
	public void addNewCustomerNoLocker(Customer c1) {
		// TODO Auto-generated method stub
		c1.setLocker(null);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(c1);       // saving the customer details internally saves the locker deteails also
		tx.commit();
		session.close();
	}
}
