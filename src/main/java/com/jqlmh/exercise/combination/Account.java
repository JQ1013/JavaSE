package com.jqlmh.exercise.combination;

public class Account {
	private int id;  //账号
	private double balance;  //余额
	private double annualInterestRate;  //年利率
	
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
	
	/**
	 * 
	* @Description  取款
	* @author Luminghao
	* @date 2019年6月5日下午6:54:55
	* @param amount
	 */
	public void withdraw(double amount) {
		if (amount<=balance) {  //balance是私有变量，但是在类内部是可以用的
			balance-=amount;
			System.out.println("成功取出"+amount);
		} else {
			System.out.println("您的余额不足");
		}
	}
	
	/**
	 * 
	* @Description 存款 
	* @author Luminghao
	* @date 2019年6月5日下午6:55:09
	* @param amount
	 */
	public void deposit(double amount) {
		this.setBalance(balance+amount);
		System.out.println("成功存入"+amount);
	}
	
	

}
