package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="walletaccount")
public class Walletaccount 
{
	@Id
	int accountid;
	double accountbalance;
	String status;
	
	 
	public Walletaccount() {
		super();
	}
	
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", accountbalance=" + accountbalance + ", status=" + status + "]";
	}	
}
