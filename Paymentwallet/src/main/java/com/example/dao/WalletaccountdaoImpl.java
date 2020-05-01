package com.example.dao;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.example.entity.Userdata;
import com.example.entity.Walletaccount;
import com.example.entity.Wallettransaction;
import com.example.exceptions.AccountWithUserIdExistsException;


@Repository
public class WalletaccountdaoImpl implements Walletaccountdao{
	
	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public Walletaccount addAccount(int userid,Walletaccount wa) {
		
		
		Userdata userdata=em.find(Userdata.class, userid);
		if(userdata==null)
		{
			return null;
		}
		if(userdata.getWalletaccount()==null)
		{
			Walletaccount walletaccount=em.merge(wa);
			userdata.setWalletaccount(walletaccount);
			return walletaccount ;
		}
		else
			throw new AccountWithUserIdExistsException("account with this userid exists");
	}
	
	
	@Override	
	public Walletaccount deleteaccount(int accountid) {
		Walletaccount wa=em.find(Walletaccount.class,accountid);
		if(wa!=null)
			{
			   em.remove(wa);
			}
        return wa;
	}
		
	@Override
	public Walletaccount deposit(Walletaccount wa, double amount) {
		
		  Walletaccount walletaccount=em.find(Walletaccount.class,wa.getAccountid());
		  long transactionID=new Random().nextInt(100000);
			if((walletaccount!=null)&&(amount>0))
			{
				Wallettransaction wt=new Wallettransaction();
				wt.setAccountid(wa.getAccountid());
				wt.setAccountbalance(walletaccount.getAccountbalance()+amount);
				wt.setAmount(amount);
				wt.setDescription("Deposited");
				LocalDate localdate=LocalDate.now();
				wt.setTransactionDate(localdate);
				wt.setTransactionID(transactionID);
				em.merge(wt);
				walletaccount.setAccountbalance(walletaccount.getAccountbalance()+amount);
				walletaccount.setStatus("Deposited");
				
				return walletaccount;
			}
			else
			{
				return null;
			}
	}
	
	@Override
      public Walletaccount fundTransfer(int fromaccountid, int toaccountid, double amount) {
    	  Walletaccount walletaccount1=em.find(Walletaccount.class,fromaccountid);
    	  Walletaccount walletaccount2=em.find(Walletaccount.class,toaccountid);
    	  long transactionID=new Random().nextInt(100000);
    	  if((walletaccount1!=null)&&(walletaccount2!=null)&&(walletaccount1.getAccountbalance()>amount))
    	  {
    		  Wallettransaction wt=new Wallettransaction();
				wt.setAccountid(fromaccountid);
				wt.setAccountbalance(walletaccount1.getAccountbalance()-amount);
				wt.setAmount(amount);
				wt.setDescription("Transfered money");
				LocalDate localdate=LocalDate.now();
				wt.setTransactionDate(localdate);
				wt.setTransactionID(transactionID);
				em.merge(wt);
    		  
    		  walletaccount1.setAccountbalance(walletaccount1.getAccountbalance()-amount);
    		  walletaccount1.setStatus("withdrawn(transfered to other account)");
    		  walletaccount2.setAccountbalance(walletaccount2.getAccountbalance()+amount);
    		  walletaccount2.setStatus("Deposited from other account");
    		  return walletaccount1;
    	  }
    	  else{
    		  return null;  
    	  }
	 }
	


	@Override
	public double getbalance(int id) {
		Walletaccount walletaccount=em.find(Walletaccount.class,id);
		double balance = 0;
		if(walletaccount!=null)
		{
		      balance=walletaccount.getAccountbalance();
		}
		return balance;
	}
	
}
