package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Userdata")
public class Userdata {
	@Id
	private int userId;
	
	private String userName;
	//@Size(min=8, max=20, message="password must be minimum 8 characters")
	private String userPassword;
	//@Min(value=10)
	private long userPhoneno;
	//@Email(message="enter proper email id")
	private String userEmail;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="walletaccount_id")
	private Walletaccount walletaccount;
	
	
	public Walletaccount getWalletaccount() {
		return walletaccount;
	}

	public void setWalletaccount(Walletaccount walletaccount) {
		this.walletaccount = walletaccount;
	}

	public Userdata() {
		super();
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getUserPhoneno() {
		return userPhoneno;
	}

	public void setUserPhoneno(long userPhoneno) {
		this.userPhoneno = userPhoneno;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	

	
}