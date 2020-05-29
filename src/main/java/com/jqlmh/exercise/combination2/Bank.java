package com.jqlmh.exercise.combination2;

public class Bank {
	private Customer[] customers=new Customer[10];;  //存放多个客户的数组
	private int numberOfCustomer;  //记录客户的个数
	
	public Bank(){
	
	}
	
	//添加客户
	public void addCustomer(String f,String l) {
		Customer s=new Customer(f, l);
			customers[numberOfCustomer]=s;
			numberOfCustomer++;
			
			//或者
			//customers[numberOfCustomer++]=s;
		
	}
	
	//获取客户的个数
	public int getNumberOfCustomers() {
		return numberOfCustomer;
	}
	
	//获取制定位置的客户
	public Customer getCustomer(int index) {
		if (index>=0&&index<numberOfCustomer) {
			return  customers[index];
		} else {
			return null;
		}
		
	}
	
	public void operateCustomer(Bank b, String f,String l,int index,double account,double depositamt,double withdrawamt) {
		b.addCustomer(f,l);
		b.getCustomer(index).setAccount(new Account(account));
		b.getCustomer(index).getAccount().withdraw(withdrawamt);
		b.getCustomer(index).getAccount().deposit(depositamt);
	}
}




	
