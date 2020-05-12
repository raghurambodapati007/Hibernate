package com.infosys.infybank.customerdemo03crudhibernate5;

import java.util.List;
import java.util.stream.Stream;

import org.hibernate.MultiIdentifierLoadAccess;
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

	/*
	 * Method to fetch multiple customer records using MultiIdentifierLoadAccess
	 * interface
	 */
	public void fetchMultipleEntities() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MultiIdentifierLoadAccess<Customer> multi = session.byMultipleIds(Customer.class);
		List<Customer> customers = multi.multiLoad(1005, 1006, 1007);
		System.out.println("Details of Customers are :");
		for (Customer customer : customers) {
			System.out.println("Name:" + customer.getCustomerName());
			System.out.println("DOB  :" + customer.getDateOfBirth());
			System.out.println("--------------------------------");
		}
		session.close();

	}

	/*
	 * Method to fetch customer details in a stream using the new stream() of query
	 * interface
	 */
	public void fetchResultSetAsStream() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Stream<Customer> customers = session.createQuery("SELECT c FROM Customer c", Customer.class).stream();
		customers.map(c -> c.getCustomerName() + " borned on " + c.getDateOfBirth());
		session.close();

	}

}
