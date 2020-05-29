package com.jqlmh.exercise.combination;

public class Test {
	public static void main(String[] args) {
		Cutomer c=new Cutomer("卢","明皓");
		Account a=new Account(62170020, 2000, 0.0123);
		c.setAccount(a);
		
		a.deposit(100);
		a.withdraw(960);
		a.withdraw(2000);
		
	
		System.out.println("Customer ["+c.getFirstName()+c.getLastName()+"]has a account: id  is "+a.getId()+",annualInterestRate is "+a.getAnnualInterestRate()
		+"balance is "+a.getBalance());
		
	}

}
