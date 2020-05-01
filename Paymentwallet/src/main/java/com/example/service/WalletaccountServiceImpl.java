package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.WalletaccountdaoImpl;
import com.example.entity.Walletaccount;



@Service
@Transactional
public class WalletaccountServiceImpl implements WalletaccountService{
	
	@Autowired
	WalletaccountdaoImpl dao;


	@Override
	public Walletaccount addAccount(int userid,Walletaccount wa) {
		
		return dao.addAccount(userid,wa);
	}

	@Override
	public Walletaccount deleteaccount(int accountid) {
		
		return dao.deleteaccount(accountid);
	}
	
	public Walletaccount deposit(Walletaccount wa,double amount)
	{
		return dao.deposit(wa, amount);
	}
	public double getbalance(int id)
	{
		return dao.getbalance(id);
	}
	public Walletaccount fundTransfer(int fromaccountid,int toaccountid,double amount)
	{
		return dao.fundTransfer(fromaccountid,toaccountid,amount);
	}


}
