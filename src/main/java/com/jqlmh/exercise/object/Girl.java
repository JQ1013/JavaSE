package com.jqlmh.exercise.object;

public class Girl {
	private String name;
	private int age;
	
	public void setName(String i) {
		this.name=i;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void marry(Boy boy) {
		System.out.println("我想嫁给"+boy.getName());
		boy.marry(this);
	}
	/**
	 * 比较两个对象
	* @Description 
	* @author Luminghao
	* @date 2019年6月4日下午11:48:19
	* @param girl
	* @return 正数：当前对象大，负数：当前对象小；0：当前对象与形参对象相等
	 */
	public int compare(Boy boy) {
		if (this.age>boy.getAge()) {   //当前对象的属性和形参对象的属性
			return 1;
		} else if(this.age<boy.getAge()){
			return -1;
		}else {
			return 0;
		}
	}
}
