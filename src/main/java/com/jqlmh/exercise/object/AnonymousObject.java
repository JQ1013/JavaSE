package com.jqlmh.exercise.object;

public class AnonymousObject {
	public static void main(String[] args) {
		PhoneMall p=new PhoneMall();
		p.show(new Phone());  //匿名对象的使用，不用显式地赋给对象一个变量名,但其实使用的是同一个对象，因为将对象赋给了一个形参
	}

}
class PhoneMall{
	public void show(Phone phone) {
		phone.call();
		phone.call();
		phone.palyGame();
		phone.palyGame();
	}
}
class Phone{
	double prince=5;
	public void call() {
		System.out.println("手机能打电话");
	}
	
	public void palyGame() {
		System.out.println("手机可以玩游戏说");
	}
}
