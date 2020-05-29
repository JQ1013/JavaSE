package com.jqlmh.daimakuai;
/*
 * 类的成员之四：代码块
 * 
 * 1.代码块的作用：用来初始化类、对象
 * 2.代码块如果有修饰的话，只能使用static
 * 3.分类：静态代码块和非静态代码块
 * 
 * 
 * 4.静态代码块（可以定义多个，按照声明的顺序执行）
 * 		>内部可以有输出语句
 * 		>随着类的加载而执行
 * 		>作用：初始化类的信息
 * 		>静态代码块的执行优先于非静态代码块的执行
 * 		>可以调用静态结构、不可以调用非静态结构
 * 5.非静态代码块（可以定义多个，按照声明的顺序执行）
 * 		>内部可以有输出语句 	
 * 		>随着对象的创建而执行
 * 		>每创建一个对象，执行一次非静态代码块
 * 		>作用：可以在创建对象的时候，对对象的属性进行初始化
 * 		>静态结构和非静态结构都可以调用
 * 对对象属性可以赋值的位置：
 * 		①默认初始化
 * 		②显式初始化
 * 		③构造器
 * 		④对象.属性和对象.方法
 * 		⑤代码块中赋值
 */
public class BlockcTest {
	public static void main(String[] args) {
		String s1=Person.desc;
		Person p1=new Person();
		System.out.println(p1.age);
		System.out.println(Person.desc);  //我是一个爱学习的人
 
	}
}


class Person{
	
	//属性
	String name;
	int age;
	static String desc="我是一个人";
	
	//构造器
	public Person(){
		
	}

	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//静态代码块
	static{
		System.out.println("hello，static block");
		desc="我是一个爱学习的人";
		info(); //可以调用静态属性、方法
	}
	
	static{
		System.out.println("hello，static block-2");
		desc="我是一个爱学习的人";
	}
	
	
	//非静态代码块
	{
		System.out.println("hello， block");
		age=1;
		info();
		eat();
		
	}
	
	{
		System.out.println("hello， block-2");
		age=2;
	}
	
	//方法
	public void eat(){
		System.out.println("吃饭");
	}
	
	public static void info() {
		
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}