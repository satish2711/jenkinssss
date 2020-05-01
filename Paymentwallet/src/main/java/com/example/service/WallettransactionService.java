package com.example.service;

import java.util.List;

import com.example.entity.Wallettransaction;

public interface WallettransactionService {
	
	List<Wallettransaction> getAllTransaction();
	
	List<Wallettransaction> getAllTransactionById(int accountid);

}
