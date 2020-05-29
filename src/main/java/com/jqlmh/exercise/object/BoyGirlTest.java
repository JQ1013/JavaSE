package com.jqlmh.exercise.object;

public class BoyGirlTest {
	public static void main(String[] args) {
		Boy b=new Boy();
	
		b.setName("卢明皓");
		b.setAge(23);
		Girl g=new Girl();
		g.setName("姜覃");
		g.setAge(23);
		b.marry(g);
		b.shout();
		
		g.marry(b);
		
		System.out.println(g.compare(b));
	}
	
}
