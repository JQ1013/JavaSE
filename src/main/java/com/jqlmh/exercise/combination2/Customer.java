package com.jqlmh.exercise.combination2;

public class Customer {
	private String firstName;
	private String lastName;
	private Account account;
	
	public Customer(String f,String l) {
		this.firstName=f;
		this.lastName=l;
	}

	
	//获取客户的账户
	public Account getAccount() {
		return account;
	}
	
	//设置客户的账户
	public void setAccount(Account account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	

}
