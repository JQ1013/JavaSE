package com.jqlmh.duotai.test1;
//多态性的使用举例一

public class AnimalTest {
	public static void main(String[] args) {
		AnimalTest at1=new AnimalTest();
		at1.funv(new Dog());  //狗的方法
		at1.funv(new Cat());  //猫的方法
	}
	
	
	public void funv(Animal animal){   //Animal animal=new Dog();
		animal.eat();
		animal.shout();
	}
	

}

	


class Animal{
	
	public void eat(){
		System.out.println("动物：进食");
	}
	
	public void shout() {
		System.out.println("动物：叫");
	}
}

class Dog extends Animal{
	@Override
	public void eat() {
		System.out.println("狗吃骨头");
	}
	
	@Override
	public void shout() {
		System.out.println("狗：汪汪汪");
	}
}

class Cat extends Animal{
	@Override
	public void eat() {
		System.out.println("猫：吃鱼");
	}
	
	@Override
	public void shout() {
		System.out.println("猫：喵喵喵");
	}
	
}
