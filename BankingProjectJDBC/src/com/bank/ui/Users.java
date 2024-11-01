package com.bank.ui;

import java.util.Scanner;

import com.bank.beans.Account;


import com.bank.service.BankService;
import com.bank.service.BankServiceImp;

public class Users {

	public static void main(String[] args) throws Exception {
		
		
		
		BankService service = null;
		
		service = new BankServiceImp();
		
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("Choose any one");
			System.out.println("Enter 1 for Create account");
			System.out.println("Enter 2 for Deposit");
			System.out.println("Enter 3 for Withdraw");
			System.out.println("Enter 4 for ShowAccountDetails");
			System.out.println("Enter 5 for GetLoan");
			System.out.println("Enter 6 for PayLoan");
			System.out.println("Enter 7 for ShowLoanDetails");
			System.out.println("Enter 8 Exit");
			switch(scan.nextInt()) {
			case 1 :
					
					while(true) {
					System.out.println("Enter account Id");
					String accId = scan.next();
					if(service.validateAccountId(accId)) {	
					
						break;
						}else {
							System.out.println("Entered account No. is not in valid format");
							return;
						}
					}		//accountID
					
					while(true) {
						System.out.println("Enter user name");
						String uname = scan.next();
						if(service.validateAccountName(uname)) {
							break;
						}else {
							System.out.println("Entered Name is not in valid format");
							return;	
						}
					}		//accountName
					System.out.println("Enter address: ");
//					System.out.println("Enter City ");
//					String city = scan.next();
//					System.out.println("Enter State ");
//					String state = scan.next();
//					Address address = new Address(city,state);
//					account.setAddres(address);
				
					
					System.out.println("Enter deposit amount");
					
					
					System.out.println(" Applying Loans...");
					System.out.println("1 for Yes \n 2 for No :");
					int ch = scan.nextInt();
					if(ch==1) {
						System.out.println("Enter loanId");
						
						
						System.out.println("Enter loan Type \n Home\t Car \t  Education");
						System.out.println("Loan Type must be any of three");
							//taking input of enum type
						
						System.out.println("Enter loan amount");
					
						
						//System.out.println("");
						
					}
					System.out.println("Account is created");
				
					
			case 2:
					System.out.println("Enter accountId :");
					String accId = scan.next();
					System.out.println("Enter amount :");
					int amt = scan.nextInt();
					int bal=service.depositAmount(accId, amt);
					System.out.println("New balance :"+bal);
					break;
					
			case 3:
					System.out.println("Enter accountId :");
					String accIdw = scan.next();
					System.out.println("Enter amount :");
					int amtw = scan.nextInt();
					int balw=service.withdrawAmount(accIdw, amtw);
					System.out.println("New balance :"+balw);
					break;
					
			case 4:
					System.out.println("Enter AccountId :");
					String acnt = scan.next();
					Account act = service.showAccountDetails(acnt);
					if(act!=null) {
						System.out.println("Account Id : "+act.getAccountId());
						System.out.println("Account Name : "+act.getAccountName());
						System.out.println("Account holder address : "+act.getAddres());
						System.out.println("Deposit Amount : "+act.getDepositAmount());System.out.println();
						break;
					}else {
						System.out.println("Not found");
						break;
					}
					
			
					
			case 8:
					System.out.println("Thank you!");
					scan.close();
					break;
			}
		}

		

	}

}