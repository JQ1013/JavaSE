package com.jqlmh.baozhuanglei.equals;

public class Customer {
	private String name;
	private int age;
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	//自动实现equals方法
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	//自动实现toString（）方法
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
	
	
	
	//手动实现equals（）方法
//	//比较两个对象的试题内容是否相同（即name，age是否相同）
//	@Override
//	public boolean equals(Object obj) {
//		//System.out.println("Customer equals().....");
//		if (this == obj) {
//            return true;
//        }
//		
//		if (obj instanceof Customer) {
//			Customer cust=(Customer)obj;
//			//比较两个对象的每个属性是否相同
//			
////			if (this.age==cust.age&&this.name.equals(cust.name)) {
////				return true;
////			}else {
////				return false;
////			}
//			
//			//或者：直接返回boolean值
//			return this.age==cust.age&&this.name.equals(cust.name);
//		}else {
//			return false;
//		}
//	}
	
	
	//手动重写toString（）方法
	/*@Override
	public String toString() {
		return "Customer[name="+name+",age="+age+"]";
	}*/
	
	
	
}
