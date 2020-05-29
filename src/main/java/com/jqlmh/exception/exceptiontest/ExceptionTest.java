package com.jqlmh.exception.exceptiontest;


import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/*
 * 一、异常体系及结构
 * java.lang.Throwable
 * 		直接已知子类：		
 * 		|-----java.lang.Error:一般不编写针对性的代码进行处理
 * 		|-----java.lang.Exception :可以进行处理的异常
 * 				》编译时异常：（checked）：IOException、ClassNotFoundException
 * 				》运行时异常：（unchecked,RuntimeException）：NullPointerException、ArrayIndexOutOfBoundException、
 * 										ClassCastException、NumberFormatException、InputMismatchException、
 * 										ArithmeticException		
 * 面试题：常见异常有哪些？举例异常？								
 */
public class ExceptionTest {
	//**************************以下是编译时异常****************************************
	@Test
	public void test7(){
//		File file=new File("hello.txt");
//		FileInputStream fileInputStream=new FileInputStream(file);
//		int d=fileInputStream.read();   //read()从此输入流中读取一个数据字节
//		while(d!=-1){
//			System.out.print((char)d);
//			d=fileInputStream.read();
//		}
//		
//		fileInputStream.close();
		
	}
	
	//**************************以下是运行时异常****************************************
	//NullPointerException
	@Test
	public void test1(){
//		int[] arr=null;
//		System.out.println(arr[3]);
		
		String str1=null;
		System.out.println(str1.charAt(0));
	}
	
	//IndexOutOfBoundException
	@Test
		//ArrayIndexOutOfBoundException
	public void test2(){
//		int[] arr =new int[3];
//		System.out.println(arr[3]);
		
		//StringIndexOutOfBoundException
		String str1="AVB";
		System.out.println(str1.charAt(3));
		
	}
	
	//ClassNotFoundException
	@Test
	public void test3(){
		Object object = new Date();
		String string=(String)object;
	}
	
	
	//NumberFormatException
	@Test
	public void test4(){
		String str="123";
		str="abc";
		int num=Integer.parseInt(str);
	}
	
	
	//InputMismatchException:输入不匹配
	@Test
	public void test5(){
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		System.out.println(num);
		scanner.close();
	}
	
	//ArithmeticException
	@Test
	public void test6(){
		int nun=15/0;
	}
	
}
