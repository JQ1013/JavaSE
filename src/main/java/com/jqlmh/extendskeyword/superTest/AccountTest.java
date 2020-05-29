package com.jqlmh.extendskeyword.superTest;

public class AccountTest {
	public static void main(String[] args) {
		Account a=new Account(1122, 20000, 0.045);
		a.withdraw(2500);
		a.deposit(3000);
		a.show();
		
	}
}
