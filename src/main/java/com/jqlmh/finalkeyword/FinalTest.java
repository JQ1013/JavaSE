package com.jqlmh.finalkeyword;
/*
 * final：最终的
 * 1.final可以修饰：类、方法、变量
 * 
 * 2.final修饰类:此类不能被其他类继承
 * 		比如：String类、System类、StringBuffer类
 * 3.final修饰方法：不能被重写
 * 		比如：Object类的getClass（）方法、
 * 
 * 4.final修饰变量：此时的变量称为一个常量
 * 		4.1final修饰属性，可以赋值的位置：显式初始化(使用场景：变量的值一样)、代码块初始化(使用场景：初始化涉及方法，抛出异常等)、构造器初始化（使用场景：每个对象的值不同）{每个构造器都要初始化}
 * 		4.2final修饰局部变量：
 * 					尤其是用final修饰形参时，表明此形参是一个常量，所以不能在方法体内对形参进行重新赋值；
 * 	static final：修饰方法：直接类调用，不能被继承
 * 				修饰属性：全局常量；
 */
public class FinalTest {
//	final int WIDTH; The blank final field WIDTH may not have been initialized
	
	final int WIDTH=10;
	final int LEFT;
	final int RIGHT;
//	final int DOWN;
	{
		LEFT=20;
	}
	public FinalTest() {
		RIGHT=30;
	}
	
	public FinalTest(int n){
		RIGHT=n;
	}
	
//	public void setDown(int down){
//		this.DOWN=down;
//	}
	public void doWidth() {
//		width=20;  The final field FinalTest.width cannot be assigned
	}
	
	
	public void show() {
		final int NUM=10;  //常量
//		num+=10;
		
	}
	
	
	public void show(final int num) {
//		num=10;
		System.out.println(num);
		
	}
	public static void main(String[] args) {
		int num=5;
		FinalTest f1=new FinalTest();
		f1.show(10);
	}
}



final class FinalA{
	
}

//class B extends FinalA{  //The type B cannot subclass the final class FinalA
	
//}

//class C extends String{} The type C cannot subclass the final class String

class AA{
	public final void show() {
		
	}
	
class BB extends AA{
//	@Override
//	public void show() {}  Cannot override the final method from AA
}	
}