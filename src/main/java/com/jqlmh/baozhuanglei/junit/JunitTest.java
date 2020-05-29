package com.jqlmh.baozhuanglei.junit;

import java.util.Date;

import org.junit.Test;

/*
 * Java中的Junit测试
 * 步骤：
 * 1.选中当前工程-邮件：build path-add libraries-Junit 4-下一步
 * 2.创建一个Java类进行单元测试
 * 		此时的Java类要求：①此类事公共的（public）②提供一个公共的无参构造器
 * 
 * 3.在此类中声明单元测试方法
 * 		单元测试方法：方法权限是public，没有返回值，没有形参，习惯写成testxxx（）
 * 4.此单元测试方法 上需要声明注解@test，并在单元测试类中导入import org.junit.Test;
 * 5.声明好单元测试方法后，就可以在方法体内测试相关的代码
 * 
 * 6.写完代码后，左键双击方法名，右键：run as-Junit Test
 * 
 * 说明：1.如果执行结果没有任何异常：绿条
 * 		2.如果执行结果出现异常：红条
 */
public class JunitTest {
	
	int num=10;
	
	@Test
	public void testEquals() {
		String s1="MM";
		String s2="MM";
		System.out.println(s1.equals(s2));
		
		/*Object obj=new String("GG");
		Date date=(Date)obj*/;
		
		System.out.println(num);
		show();
	}
	
	public void show() {
		num=20;
		System.out.println("show().....");
	}
	
	@Test
	public void  testToString(){
		String s2="MM";
		System.out.println(s2.toString());
	}
	

}
