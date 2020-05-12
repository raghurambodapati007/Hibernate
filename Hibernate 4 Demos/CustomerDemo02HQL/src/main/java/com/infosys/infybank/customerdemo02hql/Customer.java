package com.infosys.infybank.customerdemo02hql;

import javax.persistence.Entity;
import javax.persistence.*;
@Entity
public class Customer {
  @Id
  private int customerId;
  private String customerName;
  public Customer(){
  }
  public Customer(String name){
    this.customerName = name;
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

