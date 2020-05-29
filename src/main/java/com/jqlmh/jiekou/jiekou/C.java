package com.jqlmh.jiekou.jiekou;

interface A {
	int x = 0;
}

class B {
	int x = 1;
}

class C extends B implements A {
	public void pX() {
	//	System.out.println(x);
		System.out.println(super.x);
		System.out.println(A.x); //接口中的是全局常量：public static final；
	}

	public static void main(String[] args) {
		new C().pX();
	}
}