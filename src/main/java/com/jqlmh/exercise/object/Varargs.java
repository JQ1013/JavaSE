package com.jqlmh.exercise.object;
/*
 * 可变个数形参
 * 
 */
public class Varargs {
	public static void main(String[] args) {
		Varargs var=new Varargs();
		var.show(5);
		var.show("hello");
		var.show("nihao","nishi","hhhhh","对不起");
		var.show(new String[]{"nihao","duomo"}); //可以使用数组传入参数
	}
	public void show(int i) {
		System.out.println(i);
	}
	public void show(String string) {
		System.out.println(string);
	}
	public void show(String...strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.print(strings[i]);
		}
		
	}
	

}
