package com.jqlmh.innerclass;

public class InnerClassTest2 {
	/*
	 * 规定：
	 * 在局部内部类中的方法（show），如果要调用局部内部类所在方法声明的局部变量（num），则该变量必须声明为final；
	 * jdk7及以前：要求此变量要显式地声明为final
	 * jdk8及以后：可以省略final的声明
	 */
	
	
	//方法
	public void method(){
		int num=10;
		
		class AA{
			public void show(){
				//num=20;
				System.out.println(num);
			}
		}
	}
	
}
	
	

