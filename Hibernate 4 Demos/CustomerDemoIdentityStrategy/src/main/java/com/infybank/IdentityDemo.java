package com.infybank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.hibernate.HibernateException;
public class IdentityDemo {
	public static void main(String[] args) {
        CustomerDAO customerdao = new CustomerDAO();
        try {
            System.out.println("Enter the Customer details");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Customer name");
            String name = sc.next();
            System.out.println("Enter the Customer date of birth in MM/dd/yyyy format");
            String datestr = sc.next();
            SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
            Date dob = (Date) formatter.parse(datestr);
            System.out.println("Enter the Customer address");
            String address = sc.next();
            System.out.println("Enter the Customer phoneNo");
            Long phone = sc.nextLong();
            Customer customer = new Customer(name, dob, address, phone);
            customerdao.addCustomer(customer);
            System.out.println("One record created");
            sc.close();
 
        } catch (HibernateException e) {
            System.out.print(e);
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
}
