package com.jqlmh.exception.exceptiontest;
/*
 * 如何自定义异常类？
 * 1.继承于现有的异常结构：RuntimeException、Exception
 * 2.提供全局常量serialVersionUID
 * 3.通常需要编写几个重载的构造器
 * 4.自定义的异常通过throw抛出
 * 5.自定义异常最重要的是异常类的名字，当异常出现时，可以根据名字判断异常类型
 */
public class MyException extends Exception {
	static final long serialVersionUID = -7034897190745766939L;
	
	public MyException(){
		
	}
	
	public MyException(String msg){
		super(msg);
	}
}
