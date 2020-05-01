package com.example.dao;

import com.example.entity.Walletaccount;


public interface Walletaccountdao {
	
	public Walletaccount addAccount(int userid,Walletaccount wa) ;
	
	public Walletaccount deleteaccount(int accountid);
	
	
	public Walletaccount deposit(Walletaccount wa,double amount);
	
	
	public Walletaccount fundTransfer(int fromaccountid,int toaccountid,double amount);
	
	public double getbalance(int id);
}
