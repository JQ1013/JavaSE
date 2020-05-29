package com.jqlmh.exercise.combination2;

public class Account {
	private double balance;
	public Account(double init_balance){
		this.balance=init_balance;
	}
	
	public  double getBalance() {
		return balance;
	}
	
	public void deposit (double amt) {
		if (amt>0) {
			balance+=amt;
			System.out.println("存入"+amt+"元");
		}
	}
	
	public void withdraw(double amt) {
		if (amt<=this.balance) {
			balance-=amt;
			System.out.println("成功取出"+amt);
		} else {
			System.out.println("您的余额不足");
		}
	}
	
	

}
