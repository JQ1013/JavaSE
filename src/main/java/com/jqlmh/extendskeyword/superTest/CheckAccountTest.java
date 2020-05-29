package com.jqlmh.extendskeyword.superTest;

public class CheckAccountTest {
	public static void main(String[] args) {
		CheckAccount c=new CheckAccount(1122, 20000, 0.045, 5000);
		c.withdraw(5000);
		c.show();
		c.withdraw(18000);
		c.show();
		c.withdraw(3000);
		c.show();
	}

}
