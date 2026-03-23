package com.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bank{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int accId;
	String accHolder;
	long accNumber;
	Double balance;
	
	public Bank() {
	}

	public Bank(String accHolder, long accNumber, Double balance) {
		super();
		this.accHolder = accHolder;
		this.accNumber = accNumber;
		this.balance = balance;
	}
	
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	
	
}
