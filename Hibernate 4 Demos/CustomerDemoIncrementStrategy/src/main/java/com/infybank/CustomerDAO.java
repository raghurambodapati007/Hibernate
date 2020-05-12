package com.infybank;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDAO implements ICustomer {

	/* Method to create customer record */
	public void addCustomer(Customer c1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(c1);
		tx.commit();
		session.close();
	}
}
