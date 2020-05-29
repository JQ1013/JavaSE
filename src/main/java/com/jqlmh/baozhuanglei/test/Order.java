package com.jqlmh.baozhuanglei.test;


import com.jqlmh.baozhuanglei.equals.Customer;

public class Order {
	private int orderId;
	private String orderName;
	private Customer cust;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		
		if (obj instanceof Order) {
			Order o=(Order)obj;
			return this.orderId==o.orderId&&   //比较基本数据类型用==
					this.orderName.equals(o.orderName);   //比较引用数据类型用equals（）
		}
		return false;
	}

}
