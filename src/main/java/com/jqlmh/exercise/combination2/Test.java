package com.jqlmh.exercise.combination2;

public class Test {
	public static void main(String[] args) {
		char a='a';
		Bank b=new Bank();
		b.addCustomer("姜","覃");
		b.getCustomer(0).setAccount(new Account(9999999));
		b.getCustomer(0).getAccount().withdraw(500);
		b.getCustomer(0).getAccount().deposit(200);
		
		double balance=b.getCustomer(0).getAccount().getBalance();
		System.out.println("客户"+b.getCustomer(0).getFirstName()+b.getCustomer(0).getLastName()+"的余额为"+balance);
		
		System.out.println("**************************************");
		
		b.addCustomer("卢", "明皓");
		
		Customer c=b.getCustomer(1);
		c.setAccount(new Account(5000));
		c.getAccount().deposit(5000);
		c.getAccount().withdraw(2000);
		System.out.println("客户"+c.getFirstName()+c.getLastName()+"的余额为"+c.getAccount().getBalance());
		
		System.out.println();
		System.out.println("客户数量为："+b.getNumberOfCustomers());
		
		b.addCustomer("范", "正杰");
		Customer c1=b.getCustomer(2);
		c1.setAccount(new Account(3000000));
		c1.getAccount().deposit(660);
		c1.getAccount().withdraw(200);
		
		b.addCustomer("李", "林芸");
		Customer c2=b.getCustomer(3);
		c2.setAccount(new Account(6000000.0));
		c2.getAccount().deposit(660);
		c2.getAccount().withdraw(200);
		
		b.addCustomer("刘", "彦君");
		Customer c3=b.getCustomer(4);
		c3.setAccount(new Account(6992));
		c3.getAccount().deposit(660);
		c3.getAccount().withdraw(200);
		
		b.addCustomer("曹", "博");
		Customer c4=b.getCustomer(5);
		c4.setAccount(new Account(2000000));
		c4.getAccount().deposit(660);
		c4.getAccount().withdraw(200);
		
		
		b.addCustomer("苏", "丹");
		Customer c5=b.getCustomer(6);
		c5.setAccount(new Account(8000));
		c5.getAccount().deposit(660);
		c5.getAccount().withdraw(200);
		
		b.operateCustomer(b, "妖", "姬", 7, 5000, 2000, 1000);  //将操作封装在方法中
		
		for (int i = 0; i < b.getNumberOfCustomers(); i++) {
			System.out.println("客户："+b.getCustomer(i).getFirstName()+b.getCustomer(i).getLastName()+"的余额为："
			+b.getCustomer(i).getAccount().getBalance());
		}
		
	}

}
