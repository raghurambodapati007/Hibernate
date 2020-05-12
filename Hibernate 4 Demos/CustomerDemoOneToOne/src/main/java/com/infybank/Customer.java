package com.infybank;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	private int customerId;
	private String customerName;
	private Date dateOfBirth;
	private String address;
	private long phoneNo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lockerId", unique = true)
	private Locker locker;
 
	public Customer(int customerId, String customerName, Date dateOfBirth, String address, long phoneNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNo = phoneNo;
	}
 
	public Customer() {
		super();
	}
 
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
 
	public long getPhoneNo() {
		return phoneNo;
	}
 
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
 
	public Locker getLocker() {
		return locker;
	}
 
	public void setLocker(Locker locker) {
		this.locker = locker;
	}
}
