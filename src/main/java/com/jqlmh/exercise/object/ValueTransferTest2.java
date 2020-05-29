package com.jqlmh.exercise.object;
/*
 * Java值传递机制：引用数据类型
 */
public class ValueTransferTest2 {
	public static void main(String[] args) {
		Data data=new Data();
		data.m=10;
		data.n=20;
		System.out.println("m="+data.m+",n="+data.n);
		System.out.println("************************");
		
		//交换
		data.swap(data);
		System.out.println("m="+data.m+",n="+data.n);
		
	}

}

class Data{
	int m;
	int n;
	public void swap(Data data) {
		int temp=data.m;
		data.m=data.n;
		data.n=temp;
	}
}
