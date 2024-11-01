package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bank.beans.Account;

import com.bank.beans.LoanType;


public class BankDaoImp implements BankDao {
	
	
	int amount = 0;
	
	String url="jdbc:mysql://localhost:3306/caps_buggers";
	String uname="root",password="root";
	
	
	Connection conn = DriverManager.getConnection(url,uname,password);
	
	
	public BankDaoImp() throws Exception {
		
	}
	
	

	public int depositAmount(String accId, int amt) throws SQLException {
		

		String getAmount = "select depositAmount from account_01 where accountId = ?";
		PreparedStatement pst = conn.prepareStatement(getAmount);
		
		pst.setString(1, accId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		int amount1 = rs.getInt(1)+amt;
		
		String depoUpdate = "update account_01 set depositAmount = ? where accountId = ?";
		PreparedStatement pst1 = conn.prepareStatement(depoUpdate);
		pst1.setInt(1, amount1);
		pst1.setString(2, accId);
		pst1.executeUpdate();
		
		
		return amount1;
	}

	public int withdrawAmount(String accId, int amt) throws SQLException {
		// TODO Auto-generated method stub

		
		String getAmount = "select depositAmount from account_01 where accountId = ?";
		PreparedStatement pst = conn.prepareStatement(getAmount);
		
		pst.setString(1, accId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		int amount1 = rs.getInt(1)-amt;
		
		String depoUpdate = "update account_01 set depositAmount = ? where accountId = ?";
		PreparedStatement pst1 = conn.prepareStatement(depoUpdate);
		pst1.setInt(1, amount1);
		pst1.setString(2, accId);
		pst1.executeUpdate();
		
		
		
		return amount1;
	}

	public Account showAccountDetails(String accountNo) throws SQLException {

		
		String getAccDetails = "select accountId,accountName,address,depositAmount from account_01 where accountId = ?";
		PreparedStatement pst = conn.prepareStatement(getAccDetails);
		pst.setString(1, accountNo);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Account acc =new Account();
		
		acc.setAccountId(rs.getString(1));
		acc.setAccountName(rs.getString(2));
		acc.setAddres(rs.getString(3));
		acc.setDepositAmount(rs.getDouble(4));
		
		return acc;
	}

	public void createAccount(Account account) throws SQLException {

		
		
		
		String insertSql = "insert into Account_01 "+
							"(accountId,accountName,address,depositAmount,loanID,loanAmount,loanType)"+"values(?,?,?,?,?,?,?)";
																																				/*+ t.getAccountId()+","+t.getAccountName()+","+t.getAddres()+","+t.getDepositAmount()+","+t.getLoanId()+","+t.getLoanAmount()+","+t.getLoanType()+")";*/
		
		
		PreparedStatement pst = conn.prepareStatement(insertSql);
		
		
		
		int c = pst.executeUpdate();
		System.out.println(c+" rows affected ");
	}

	

}