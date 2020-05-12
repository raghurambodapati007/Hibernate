package com.infybank;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMERID")
	int customerId;
	@Column(name = "CUSTOMERNAME")
	String customerName;
	@Temporal(TemporalType.DATE)
	@Column(name = "DATEOFBIRTH")
	Date dateOfBirth;
	@Column(name = "ADDRESS")
	String address;
 
	@Column(name = "PHONENO")
	Long phoneNo;
 
	public int getCustomerId() {
		return customerId;
	}
 
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
 
	public String getCustomerName() {
		return customerName;
	}
 
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
 
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
 
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
 
	public String getAddress() {
		return address;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}
 
	public double getPhoneNo() {
		return phoneNo;
	}
 
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
 
	public Customer(String customerName, Date dateOfBirth, String address, long phoneNo) {
		super();
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNo = phoneNo;
	}
 
        public Customer() {
		super();
	}

}
