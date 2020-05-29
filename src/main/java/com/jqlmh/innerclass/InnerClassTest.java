package com.jqlmh.innerclass;
/*
 * 类的成员之五：内部类
 * 1.Java允许将一个类A定义在另一个类B中，则A就是内部类，类B就是外部类
 * 
 * 2.内部类的分类：成员内部类（静态和非静态）和局部内部类（方法内、代码块内、构造器内）
 * 3.成员内部类：
 * 		一方面，作为外部类的成员：
 * 			>可以调用外部类的结构
 * 			>可以被static修饰
 * 			>可以被四种权限修饰符修饰
 * 		另一方面作为一个类：
 * 			>类内可以定义属性、方法、构造器
 * 			>可以被final继承，表示此类不能被继承。言外之意，不使用final修饰，就可以被继承
 * 			>可以被abstract修饰
 * 
 * 4.关注以下三个问题：
 * 		>如何实例化成员内部类的对象
 * 		>如何在成员内部类中去区分调用外部类的结构
 * 		>开发中局部内部类的使用：InnerClassTest1.java
 * 	
 */
public class InnerClassTest {
	public static void main(String[] args) {
		
		//创建Dog实例（静态成员内部类）
		Person.Dog dog=new Person.Dog();
		dog.show();
		
		//创建Bird实例（非静态成员内部类）
		//Person.Bird bird =new Person.Bird(); 错误的
		Person person=new Person();
		Person.Bird bird=person.new Bird();
		
		bird.sing();
		System.out.println();
		
		bird.display("海鸥");
		
		person.show();
	}
}

class Person{
	String name="小明";
	int age;
	
	public void eat() {
		System.out.println("人可以吃饭");
	}
	
	public void show(){
		Dog dog = new Dog();
		dog.show();  //外部类访问成员内部类的成员，需要“内部类.成员”或“内部类对象.成员”的方式
	}
	
	//静态成员内部类
	static class Dog{
		String name;
		int age;
		
		public Dog(){
			
		}
		
		public void show(){ 
			System.out.println("我是一只狗");
		}
	}
	
	//非静态内部类
	class Bird{
		String name="海燕";
		
		public Bird(){
			
		}
		public void sing(){
			System.out.println("鸟可以唱歌");
			eat();		//调用外部类的属性：外部类.this.属性---------省略了Person.this.eat()
			Person.this.eat();  //成员内部类可以直接使用外部类的所有成员，包括私有的数据
		}
		
		//属性重名的时候怎么调用
		public void display(String name) {
			System.out.println(name);  //方法的形参
			System.out.println(this.name);//内部类的属性
			System.out.println(Person.this.name); //外部类的属性
		}
	}
	
	public void method(){
		//局部 内部类：方法内
		class AA{
			
		}
	}
	
	{	//局部内部类：代码块内
		class BB{
			
		}
	}
	
	//局部内部类：构造器内
	public Person(){
		class CC{
			
		}
	}
}

