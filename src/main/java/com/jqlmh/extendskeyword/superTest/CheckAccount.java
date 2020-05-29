package com.jqlmh.extendskeyword.superTest;

public class CheckAccount extends Account {
	
	private double overdraft;
	
	
	public CheckAccount(int id, double balance, double annualInterestRate,double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft = overdraft;
	}


	@Override
	public void withdraw(double amount) {
		if (amount<=getBalance()) {
			//setBalance(getBalance()-amount);
			//方式二
			super.withdraw(amount); //调用父类的方法
		} else if (overdraft>=(amount-getBalance())) {
				overdraft=overdraft+getBalance()-amount;
				//setBalance(0);或者
				super.withdraw(getBalance());//调用父类的方法，将余额全部取完
		} else {
				System.out.println("您的可透支限额是"+overdraft);
		}
		
	}
	
	@Override
	public void show() {
		System.out.println("用户："+getId()+"的余额为："+getBalance()+"可透支限额为"+overdraft);
	}
}
