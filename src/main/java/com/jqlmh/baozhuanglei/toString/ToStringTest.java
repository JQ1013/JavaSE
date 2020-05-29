package com.jqlmh.baozhuanglei.toString;

import com.jqlmh.baozhuanglei.equals.Customer;

import java.util.Date;

/*
 * 
 * Objecet类中toString（）的使用
 * 
 * 1.当我们输出一个对象的引用时，实际上就是调用当前对象的toString（）
 * 2.Object类中定义的toString（）：
 * 	public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    
   3. 像String、Date、File、包装类都重写了Obiect类的toString（）方法。
   		使得在调用对象的toString（）方法时，返回“实体内容”信息
   4.自定义类也可以重写toString（）方法，调用此方法时，返回对象的“实体内容”
 * 
 */
public class ToStringTest {
	public static void main(String[] args) {
		Customer c6=new Customer("tom", 23);
		System.out.println(c6.toString());  //输出地址值equals.Customer@6d06d69c
		System.out.println(c6);    //equals.Customer@6d06d69c
		
		String str1=new String("MM");
		System.out.println(str1.toString());  //MM
		
		
		Date date=new Date(545545545L);
		System.out.println(date.toString());  //Wed Jan 07 15:32:25 CST 1970
		
	}
	
	
}
