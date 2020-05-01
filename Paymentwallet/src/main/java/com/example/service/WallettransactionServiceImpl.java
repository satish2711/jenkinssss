package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.WallettransactiondaoImpl;
import com.example.entity.Wallettransaction;

@Service
@Transactional
public class WallettransactionServiceImpl implements WallettransactionService{

	
	@Autowired
	WallettransactiondaoImpl dao;

	@Override
	public List<Wallettransaction> getAllTransaction() {
		
		return dao.getAllTransaction();
	}

	@Override
	public List<Wallettransaction> getAllTransactionById(int accountid) {
		
		return dao.getAllTransactionById(accountid);
	}


}
