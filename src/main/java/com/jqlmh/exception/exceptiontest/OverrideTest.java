package com.jqlmh.exception.exceptiontest;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 方法重写的规则之一：
 * 子类重写的方法抛出的异常类型小于等于父类被重写的方法抛出的异常
 */
public class OverrideTest {

	public static void main(String[] args) {
		OverrideTest overrideTest = new OverrideTest(); 
		overrideTest.display(new SubClass());   //多态，调用的是子类的重写方法，如果子类抛出的异常比父类大，那么在display（）方法中处理的是父类方法的抛出的异常，对于子类抛出的异常则无法处理
	}
	
	public void display(SupClass s) {
		try {
			s.method1();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


class SupClass{
	public void method1() throws IOException {
		
	}
}

class SubClass extends SupClass{
	public void method1() throws FileNotFoundException{
		
	}
}