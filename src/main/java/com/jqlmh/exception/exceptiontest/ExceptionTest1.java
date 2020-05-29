package com.jqlmh.exception.exceptiontest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/*
 * 一、异常处理：抓抛模型
 * 过程一：抛的过程：Java程序的执行过程中如出现异常，会生成一个异常类对象，并此对象抛出
 * 				一旦抛出异常对象以后，其后的代码就不再执行
 * 
 * 过程二：抓的过程：可以理解为异常的处理方式，①try-catch-finally  ②throws
 * 		
 * 二、try-catch-finally的使用
 * 		try{
 * 			//可能出现异常的代码
 * 		}catch(异常类型1 变量名1){
 * 			//处理异常的方式1
 * 		}catch(异常类型2 变量名2){
 * 			//处理异常的方式2
 * 		}catch(异常类型3 变量名3){
 * 			//处理异常的方式3
 * 		}catch(异常类型4 变量名4){
 * 			//处理异常的方式4
 * 		}finally{
 *  		//一定会执行的代码
 * 		}
 * 	说明：1.finally是可选的
 * 		2.使用try将可能出现异常的代码包起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，根据此对象
 * 		的类型，去catch中进行匹配；
 * 		3.一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理。一旦处理完成，就跳出当前的try-catch
 * 		结构（在没有写finally的情况下）继续执行其后的代码
 * 		4.catch中的 异常类型如果没有子父类关系，则谁声明在上没有关系；
 * 		  catch中的 异常类型如果有子父类关系，则要求子类一定要声明在父类的上面。否则，报错
 * 		5.常用的异常对象的处理方式：①String getMessage() ②printStackTrace()
 * 		6.在try结构中定义的变量，在出了try结构以后，就不能再调用了； 
 * 
 * 体会：使用try-catch-finally处理编译时异常，使得程序在编译时不再报错。但是运行时仍可能报错。
 * 		相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现。
 * 
 */
public class ExceptionTest1 {
	
	@Test
	public void test1(){
		
		int num=0;
		try{
			String str="123";
			str="abc";
			num=Integer.parseInt(str);
			System.out.println("catch");
		}catch (NullPointerException e) {
			System.out.println("空指针异常");
		}catch (NumberFormatException e) {
			//System.out.println("出现数值转换异常了，别着急");
			
			//常用两个处理方式
			//getMessage():
			//System.out.println(e.getMessage());
			
			//printStackTrace()
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Exception异常");
		}
		System.out.println(num);
		System.out.println("try-catch外面");
	}
	
	
	@Test
	public void test7(){
		try{
			File file=new File("hello.txt");
			FileInputStream fileInputStream=new FileInputStream(file);
			int d=fileInputStream.read();  //read()从此输入流中读取一个数据字节
			while(d!=-1){
				System.out.println((char)d);
		}
		
			fileInputStream.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
