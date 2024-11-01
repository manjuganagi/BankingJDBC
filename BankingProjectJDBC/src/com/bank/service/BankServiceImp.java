package com.bank.service;

import java.sql.SQLException;

import com.bank.beans.Account;

import com.bank.dao.BankDao;
import com.bank.dao.BankDaoImp;

public class BankServiceImp implements BankService{
	
	BankDao dao;
	
	public BankServiceImp() throws Exception {
		dao= new BankDaoImp();
	}

	public boolean validateAccountId(String id) {
		String regexId = "^[0-9]{7}[A-Za-z]{4}$";
		return id.matches(regexId);
	}

	public boolean validateAccountName(String name) {
		String regexName = "^[A-Z]{1}[a-z]{2,30}$";
		return name.matches(regexName);
	}

	public int depositAmount(String accId, int amt) throws SQLException {
		// TODO Auto-generated method stub
		return dao.depositAmount(accId, amt);
	}

	public int withdrawAmount(String accId, int amt) throws SQLException {
		// TODO Auto-generated method stub
		return dao.withdrawAmount(accId, amt);
	}

	public Account showAccountDetails(String accountNo) throws SQLException {
		return dao.showAccountDetails(accountNo);
		
	}

	public void createAccount(Account account) throws SQLException {
		dao.createAccount(account);
		
	}
	
	

}