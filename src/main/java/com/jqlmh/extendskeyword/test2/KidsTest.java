package com.jqlmh.extendskeyword.test2;

public class KidsTest {
	public static void main(String[] args) {
		Kids someKid=new Kids(18);
		someKid.printAge();
		someKid.setSalary(1);
		someKid.setSex(0);
		
		someKid.manOrWoman();
		someKid.employeed();  //重写了
	}

}
