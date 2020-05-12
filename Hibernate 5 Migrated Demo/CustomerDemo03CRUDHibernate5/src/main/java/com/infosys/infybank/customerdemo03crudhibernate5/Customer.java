package com.infosys.infybank.customerdemo03crudhibernate5;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "Customer_Details")
/*If Hibernate 4 was used
@NamedQueries({
	@NamedQuery(name ="Customer.findById",query="SELECT c FROM Customer c WHERE c.customerId =:CUSTOMERID"),
	@NamedQuery(name ="Customer.findByName",query="SELECT c FROM Customer c WHERE c.customerName =:CUSTOMERNAME")
	})
*/
@NamedQuery(name ="Customer.findById",query="SELECT c FROM Customer c WHERE c.customerId =:CUSTOMERID")
@NamedQuery(name ="Customer.findByName",query="SELECT c FROM Customer c WHERE c.customerName =:CUSTOMERNAME")

public class Customer {
  @Id
  @Column(name = "CUSTOMERID")
  private int customerId;
  @Column(name = "CUSTOMERNAME")
  private String customerName;
  
  @Column(name = "CUSTOMERDOB")
  private LocalDate dateOfBirth;
    public Customer() {
  }
      
  public Customer(int custId, String custName,LocalDate dateOfBirth) {
    this.customerId = custId;
    this.customerName = custName;
    this.dateOfBirth=dateOfBirth;
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

public LocalDate getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
  
}
