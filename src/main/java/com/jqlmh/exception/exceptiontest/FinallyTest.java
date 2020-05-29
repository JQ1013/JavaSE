package com.jqlmh.exception.exceptiontest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/*
 * try-catch-finally的使用
 * 
 * 1.finally是可选的
 * 2.finally中声明的是一定会执行的代码，即使catch又出现了异常，try中有return语句，catch中有return语句等情况；
 * 	（先执行finally中的语句，再return）,如果finally里面也有return，则返回finally的return的值
 * 3.像数据库连接、输入输出流、网络编程Socket等资源，JVM是不会自动回收的。我们需要手动的进行资源的释放。此时的资源
 * 	 的释放就需要声明在finally中。
 */
public class FinallyTest {
	@Test
	public void test1(){
		try {
			int num=9/0;
		}catch (ArithmeticException e) {
			//e.printStackTrace();
			int[] arr=new int[3];
			arr[3]=0;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println("我好帅啊");
		finally {
			System.out.println("我是finally");
		}
	}
	
	public int method() {
		try {
			int[] arr=new int[3];
			arr[3]=0;
			return 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return 2;
		}finally {
			System.out.println("我一定会执行");
			return 3;
		}
	}
	
	@Test
	public void test2(){
		int num=method();
		System.out.println(num );
	}
	
	@Test
	public void test3(){
		FileInputStream fileInputStream=null ;
		try {
			File file=new File("hello.txt");
			fileInputStream=new FileInputStream(file);
			int d=fileInputStream.read();  //read()从此输入流中读取一个数据字节
			while(d!=-1){
				System.out.print((char)d);
				d=fileInputStream.read();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (fileInputStream!=null) {  //如果不判断是否为null，可能出现空指针异常
					fileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
