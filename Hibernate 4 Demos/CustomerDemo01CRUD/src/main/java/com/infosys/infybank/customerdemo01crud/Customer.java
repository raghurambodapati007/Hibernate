package com.infosys.infybank.customerdemo01crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Details")
public class Customer {
  @Id
  @Column(name = "CUSTOMERID")
  private int customerId;
  @Column(name = "CUSTOMERNAME")
  private String customerName;
    public Customer() {
  }
      
  public Customer(int custId, String custName) {
    this.customerId = custId;
    this.customerName = custName;
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
}
