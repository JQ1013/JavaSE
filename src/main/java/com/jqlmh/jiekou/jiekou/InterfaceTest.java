package com.jqlmh.jiekou.jiekou;
/*
 * 接口的使用
 * 1.接口使用interface来定义
 * 2.Java中接口和类是并列的接口
 * 3.如何定义接口：定义接口的成员
 * 		3.1JDK7及以前：只能够定义全局常量和抽象方法
 * 			》全局常量：public static final的，但是书写时可以省略
 * 			》抽象方法：public abstract修饰的
 * 		3.2 JDK8：除了定义全局常量和抽象方法外，还可以定义静态方法、默认方法（略）
 * 4.接口不能定义构造器，意味着不能实例化
 * 5.Java开发中，接口通过让类去实现（implements）的方式来使用	
 * 		如果实现类覆盖了接口中的所有的抽象方法，则此实现类就可以实例化
 * 		如果实现类没有覆盖接口中的所有抽象方法，则此实现类仍为一个抽象类
 * 细节：子类重写父类方法叫重写（覆盖）overrides，类实现抽象方法叫实现
 * 
 * 6.Java可以实现多个接口》》》弥补了Java单继承的局限性
 * 		有继承有实现格式：class A extends B implements C,D{}
 * 7.接口和接口之间可以继承，而且可以多继承
 * 8.接口的具体使用，体现多态性
 * 9.接口，实际上可以看做是一种规范
 * 
 * 面试题：抽象类和接口有哪些异同
*/
public class InterfaceTest {
	public static void main(String[] args) {
		Plane p1=new Plane();
		p1.fly();
		p1.stop();
	}
}

interface Flyable{
	
	//JDK7及以前
	//全局变量
	public static final int MAXSPEED=7900; //第一宇宙速度
	int MINSPEED=1;  //省略了public static final
	
	//抽象方法
	public abstract void fly();
	
	void stop();//省略了public abstract
	
	//public Flyable(){}  不能声明构造
	
	//JDK8:静态方法
	public static void method(){}
}


interface attackable{
	void attact();
	
}

class Bullet extends Object implements Flyable,attackable,CC{

	@Override
	public void attact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
	
}

//可以不实现接口的抽象方法，但是要把类声明为抽象的 
abstract class Kite implements Flyable{
	
}
class Plane implements Flyable{

	@Override
	public void fly() {
		System.out.println("通过引擎起飞");
		
	}

	@Override
	public void stop() {
		System.out.println("驾驶员减速停止");
	}
	
}


interface AA{
	void method1();
}

interface BB{
	void method2();
}

//接口可以多继承
interface CC extends AA,BB{
	
}