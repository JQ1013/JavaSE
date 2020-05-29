package com.jqlmh.exception.exceptiontest;

public class StudentTest {
	public static void main(String[] args) {
		try {
			Student stu = new Student();
			stu.regist(-10);
			System.out.println(stu);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());  //getMessage()获取传入的字符串参数
		}
	}
}


class Student{
	private int id;
	public void regist(int id) throws Exception {
		if (id>0) {
			this.id=id;
		}else{
			//System.out.println("您输入的数据非法");
			//手动抛出一个异常对象
			//throw new RuntimeException("您输出的数据非法");
			throw new MyException("您输出的数据非法!!!!!!!!!!");  //传入的字符串参数
		}
	}
	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	
	
}