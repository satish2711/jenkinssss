package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="wallettransaction")
public class Wallettransaction 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transactionID", updatable = false, nullable = false)
	private Long transactionID;
	
	
	private double amount;
	private String description;
	private double accountbalance;
	private int accountid;
	 
	@Column(name="transactionDate",nullable=false)
	private LocalDate transactionDate;
	
	
	public Wallettransaction() {
		super();
	}
	
	
	public Wallettransaction(Long transactionID, double amount, String description, double accountbalance,
			int accountid, LocalDate transactionDate) {
		super();
		this.transactionID = transactionID;
		this.amount = amount;
		this.description = description;
		this.accountbalance = accountbalance;
		this.accountid = accountid;
		this.transactionDate = transactionDate;
	}


	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public long getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transactionDate=" + transactionDate + ", Amount="
				+ amount + ", description=" + description + ", Accountbalance=" + accountbalance + "]";
	}
	
}
