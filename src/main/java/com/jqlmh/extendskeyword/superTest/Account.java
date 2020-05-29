package com.jqlmh.extendskeyword.superTest;

public class Account {	
	private int id;  //账号
	private double balance; //余额
	private double annualInterestRate; //年利率
	
	public Account() {
		super();
	}
	
	
	public Account(int id, double balance, double annualInterestRate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public double getMonthlyInterest(){
		return annualInterestRate/12;
	}
	public void withdraw (double amount){
		if (balance>=amount) {
			balance-=amount;
			System.out.println("取款成功，本次共取："+amount+"元");
		} else {
			System.out.println("您的余额不足");
		}
	}
	public void deposit (double amount){
		balance+=amount;
		System.out.println("存款成功，本次共存"+amount+"元");
		
	}
	
	public void show() {
		System.out.println("用户："+getId()+"的余额为："+getBalance()+"月利率为"+getMonthlyInterest()*100+"%");
	}
}
