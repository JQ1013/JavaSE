package com.jqlmh.exercise.object;
/*
 * Java的值传递机制:基本数据类型
 */
public class ValueTransferTest {
	public static void main(String[] args) {
		int m=10;
		int n=20;
		System.out.println("m="+m+",n="+n);
		
		System.out.println("************************");
		//交换
		/*int temp=m;
		m=n;
		n=temp;
		System.out.println("m="+m+",n="+n);*/
		ValueTransferTest test=new ValueTransferTest();
		
		//实验一
		test.swap(m,n);  //基本类型的值传递，将实参所保存的数据值赋给形参，实际上是形参交换了但是实参没有交换，因为形参交换完后就退出了栈空间
		System.out.println("m="+m+",n="+n);   //输出的实际是实参的值，而不是形参，所以是没有变的
		
		System.out.println("**************************");
		
		//实验二，方法内输出形参的值
		test.swapPrint(m, n);  //方法内输出形参的值，可以看到是交换了的
		System.out.println("m="+m+",n="+n);    //输出的实际是实参的值，而不是形参，所以是没有变的
	}
	
	//交换的方法
	public void swap(int m,int n) {
		int temp=m;
		m=n;
		n=temp;
	}
	
	public void swapPrint(int m,int n) {
		int temp=m;
		m=n;
		n=temp;
		System.out.println("m="+m+",n="+n);
	}


}
