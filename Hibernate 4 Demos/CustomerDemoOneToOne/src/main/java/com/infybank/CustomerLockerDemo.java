package com.infybank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
 
import org.hibernate.HibernateException;

public class CustomerLockerDemo {
	public static void main(String[] args) {
		CustomerDAO customerdao = new CustomerDAO();
		try {
			System.out.println("Enter the Customer details");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Customer Id");
			int id = sc.nextInt();
			System.out.println("Enter the Customer name");
			String name = sc.next();
			System.out.println("Enter the Customer date of birth in MM/dd/yyyy format");
			String datestr = sc.next();
			SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
			Date dob = (Date) formatter.parse(datestr);
			System.out.println("Enter the Customer address");
			String address = sc.next();
			System.out.println("Enter the Customer phoneNo");
			long phone = sc.nextLong();
 
			System.out.println("Do you want to allocate Locker(Y/N)");
			String lock = sc.next();
			if (lock.compareToIgnoreCase("y")==0) {
				System.out.println("Enter the Locker Id");
				String lid = sc.next();
				System.out.println("Enter the locker type");
				String ltype = sc.next();
				System.out.println("Enter the rent");
				Double lrent = sc.nextDouble();
 
				Locker locker = new Locker(lid, ltype, lrent);
 
				Customer customer = new Customer(id, name, dob, address, phone);
				customerdao.addNewCustomerNewLocker(customer, locker);
				System.out.println("One record created");
				sc.close();
			} else {
				Customer customer = new Customer(id, name, dob, address, phone);
				customerdao.addNewCustomerNoLocker(customer);
				System.out.println("One record created");
				sc.close();
			}
 
		} catch (HibernateException e) {
			System.out.print(e);
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
