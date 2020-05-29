package com.jqlmh.jiekou.jiekoujdk8;

public class SubclassTest {
	public static void main(String[] args) {
		Subclass s1=new Subclass();
//		s1.method();   接口中的静态方法不能用实现类对象调用
		//知识点1：接口中的静态方法，只能通过接口来调用
		//2.通过实现类的对象可以调用接口的默认方法
		//如果接口实现类重写了接口中的默认方法，调用时，仍然调用的是重写的方法
		//3.如果子类继承的父类和实现的接口中声明了同名同参数的默认方法，那么子类在没有重写此方法的情况下，默认调用的是父类的同名同参数的方法》》》》类优先原则
		//4.如果类在没有继承父类，并且实现多个接口，而这多个接口含有同名同参数的默认方法。那么在实现类没有重写此方法的情况下，报错。》》》》接口冲突
		CompareA.method();
		s1.method1();
		s1.method2(); //调用父类的同名方法 superclass
		
	}
}

class Subclass extends SuperClass implements CompareA,CompareB{
	@Override
	public void method1() {
		System.out.println("subclass重写方法");
	}

	@Override
	public void method2() {
		System.out.println("多个接口同名同参数的方法");
	}
	
	public void myMethod() {
		//5.如何在子类或实现类中调用父类、接口中的被重写的方法，
		method2();  //自己重写的方法
		super.method2(); //父类的方法
		
		//挑用接口中的默认方法
		CompareA.super.method2();
		CompareB.super.method2();
	}
}
