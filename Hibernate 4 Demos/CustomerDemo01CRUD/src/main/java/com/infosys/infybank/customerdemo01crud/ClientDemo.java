package com.infosys.infybank.customerdemo01crud;

import java.util.Scanner;

import org.hibernate.HibernateException;


public class ClientDemo {
        public static void main(String[] args) {
                CustomerDAO custdao = new CustomerDAO();
                try {
                        System.out.println("CREATE");
                        System.out.println("Enter the Customer details");
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Enter the Customer number");
                        int id = sc.nextInt();
                        System.out.println("Enter the Customer name");
                        String name = sc.next();
                        Customer cust = new Customer(id, name);
                        custdao.addCustomer(cust);
                        System.out.println("One record created");
                        System.out.println("READ");
                        System.out.println("Enter a customer number");
                        int id1 = sc.nextInt();
                        custdao.readCustomer(id1);
                        System.out.println("UPDATE");
                        System.out.println("Enter the customer number and new name");
                        System.out.println("Enter the customer number");
                        int id2= sc.nextInt();
                        System.out.println("Enter a name ");
                        String name1=sc.next();
                        custdao.updateCustomer(id2, name1);
                        System.out.println("updated");
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