package com.jqlmh.duotai.exer;

public class FieldMethodTest {
	
	public static void main(String[] args) {
		Sub s1=new Sub();
		System.out.println(s1.count);
		s1.display();
		
		Base b1=s1; //多态   
		
		//== 对于引用数据类型来说比较的是引用数据类型变量的地址值是否相同
		System.out.println(b1==s1);
		System.out.println(b1.count);  //属性看左边
		b1.display();   //实际运行是子类的
		
	}
}

class Base{
	int count=10;
	public void display() {
		System.out.println(this.count);
	}
}

class Sub extends Base{
	int count=20;
	@Override
	public void display() {
		System.out.println(this.count);
	}
}