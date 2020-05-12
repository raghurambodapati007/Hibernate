package com.infosys.infybank.customerdemo03crudhibernate5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.hibernate.HibernateException;

public class ClientDemo {
	public static void main(String[] args) {
		CustomerDAO custdao = new CustomerDAO();
		try {
			Customer cust1= new Customer(1005,"Debashis",LocalDate.of(1993, 06, 13));
			Customer cust2= new Customer(1006,"Putun",LocalDate.of(1994, 06, 20));
			Customer cust3= new Customer(1007,"Jack",LocalDate.of(1995, 11, 22));
			custdao.addCustomer(cust1);
			custdao.addCustomer(cust2);
			custdao.addCustomer(cust3);
			// Insert
			System.out.println("CREATE");
			System.out.println("Enter the Customer details");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Customer number");
			int id = sc.nextInt();
			System.out.println("Enter the Customer name");
			String name = sc.next();
			// logic added to persist the LocalDate
			System.out.println("Enter the Customer DOB in dd-MMM-yyyy format(Correct format is 22-Apr-1993)");
			String dobInString = sc.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDate dateOfBirth = LocalDate.parse(dobInString, formatter);
			System.out.println(dateOfBirth);
			Customer cust = new Customer(id, name, dateOfBirth);
			custdao.addCustomer(cust);
			System.out.println("One record created");

			// Read
			System.out.println("READ");
			System.out.println("Enter a customer number");
			int id1 = sc.nextInt();
			custdao.readCustomer(id1);

			// Fetch multiple entities using MultiIdentifierLoadAccess interface
			custdao.fetchMultipleEntities();

			// Fetch the customer details as a stream
			custdao.fetchResultSetAsStream();

			// UPDATE
			System.out.println("UPDATE");
			System.out.println("Enter the customer number and new name");
			System.out.println("Enter the customer number");
			int id2 = sc.nextInt();
			System.out.println("Enter a name ");
			String name1 = sc.next();
			custdao.updateCustomer(id2, name1);
			System.out.println("updated");

			// DELETE
			System.out.println("DELETE");
			System.out.println("Enter the customerid to delete the customer details of a customer");
			int id3 = sc.nextInt();
			custdao.deleteCustomer(id3);
			System.out.println("deleted");
			sc.close();
		} catch (HibernateException e) {
			System.out.println("Exception " + e);
		}
	}
}