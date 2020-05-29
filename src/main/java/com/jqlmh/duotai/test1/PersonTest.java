package com.jqlmh.duotai.test1;

import java.util.Date;

/*
 * 面向对象特征三：多态性
 * 1.理解多态性：可以理解为一个事物的多种形态
 * 2.何为多态性：
 * 		对象的多态性：父类的引用指向子类的对象；（或子类的对象赋给父类的引用）
 * 3.多态的使用：虚拟方法调用
 * 		有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在执行期，我们实际
 * 		执行的是子类重写的父类方法；
 * 		总结：编译，看左边；运行，看右边；
 * 4.多态性的使用前提：①类的继承关系 ②要有方法的重写	
 * 5.对象的多态性只适用于方法,不适用于属性（属性编译和运行都看左边）
 * 
 */

public class PersonTest {
	public static void main(String[] args) {
		Person p=new Person();
		p.eat();
		
		Man m=new Man();
		m.eat();
		m.age=25;
		m.earnMonkey();
		
		//**********************************************
		Person p2=new Man();
		//对象的多态性：父类的引用指向子类的对象
		Person P3=new Woman();
		//多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法 ---虚拟方法调用
		p2.eat();
		p2.walk();
		System.out.println(p2.id);  //100
		
		/*
		 * 不能调用子类所特由于的方法，属性；编译时，p2是Person类型
		 */
		
//		p2.name="tom";
//		p2.earnMoney(); 
//		p2.isSmoking=true;
		
			//有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，导致
			//编译时，只能调用父类中声明的属性和方法。子类特有的属性和方法不能调用。
			
			//如何才能调用子类特有的属性和方法？
		
		Man m1=(Man)p2;
		m1.earnMonkey();
		m1.isSmoking=true;
		
		//强制类型转换会有风险，可能出现转换不成功的情况 ClassCastException的异常
		
		//Woman w1=(Woman)p2;
		//w1.shopping();  报类型转换异常
		
		//instanceof：
		
		/*
		 * 1、instanceof关键字的使用
		 * 		a instanceof A  ：判断对象a是否是类A的实例，返回Boolean类型值
		 * 
		 * 2、使用情景：为了避免在向下转型是出现异常，在向下 转型之前，先进行instanceof的判断，
		 * 		返回true，就进行向下转型，返回false，就不进行向下转型。
		 * 
		 * 3、类B是类A的父类
		 * 		如果a instanceof A返回true，则 a instanceof B也返回true，
		 * 
		 */
		
		if (p2 instanceof Woman) {
			Woman w1=(Woman)p2;
			w1.shopping();
			System.out.println("**************Woman****************");
		}
		
		if (p2 instanceof Man) {
			Man m2=(Man)p2;
			m2.eat();;
			System.out.println("**************Man****************");
		}
		
		if (p2 instanceof Person) {
			System.out.println("Person");
		}
		if (p2 instanceof Object) {
			System.out.println("Object");
		}
		
		
		//联系
		//问题一：编译时通过，运行时不通过
		//举例一:
//		Person p3=new Woman();
//		Man m3=(Man)p3;
		
		//举例二：
//		Person p4=new Person();
//		Man m5=(Man)p4;
		
		//问题二：编译时通过，运行时ye1通过
		Object o1=new Woman();
		Person p1=(Person)o1;
		
		//问题三：编译不通过
		//Man m4=new Woman();
		
//		String str1=new Date();
	}

}
