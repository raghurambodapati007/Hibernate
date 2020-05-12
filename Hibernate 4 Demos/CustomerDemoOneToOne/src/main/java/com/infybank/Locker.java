package com.infybank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locker")
public class Locker {
	@Id
	private String lockerId;
	private String lockerType;              
	private Double rent;
	
	public Locker() {
		super();
	}
	
	public Locker(String lockerId, String lockerType, Double rent) {
		super();
		this.lockerId = lockerId;
		this.lockerType = lockerType;
		this.rent = rent;
	}
	public String getLockerId() {
		return lockerId;
	}
	public void setLockerId(String lockerId) {
		this.lockerId = lockerId;
	}
	public String getLockerType() {
		return lockerType;
	}
	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}
	public Double getRent() {
		return rent;
	}
	public void setRent(Double rent) {
		this.rent = rent;
	}
	
}
