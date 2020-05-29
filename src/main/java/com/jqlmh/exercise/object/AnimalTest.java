package com.jqlmh.exercise.object;
/**
 * 封装的引入
* @Description
* @author Luminghao Email:13142187714@163.com
* @version
* @date 2019年6月1日下午11:42:58
*
 */
public class AnimalTest {
	public static void main(String[] args) {
		Animal an=new Animal();
		//an.legs=-4; //报错，The field Animal.legs is not visible 属性不可见，因为我们已经给封装起来了，避免出现这中不合理的赋值
		an.name="狮子";
		an.age=4;
		an.setLegs(6);  //设置属性
		
		System.out.println(an.getLegs()); //获取属性的值并打印出来
		an.show();
	}

}

class Animal{
	String name;
	int age;
	private int legs;  //将属性封装起来，避免出现赋值的不合理性，这时候就不能再使用对象.属性来进行赋值了
	
	//将属性的赋值设为一个方法，可以设置属性的赋值的条件，如下：只有当赋的值大于0且为偶数时，才会给legs赋值，否则赋值为0
	
	//设置属性值
	public void setLegs(int le) {
		if (le>0&&le%2==0) {  
			legs=le;
		} else {
			legs=0;  //
		}
	}
	//获取属性值
	public int getLegs() {
		return legs;
	}
	public void eat() {
		System.out.println("动物吃东西");
	}
	
	public void show() {
		System.out.println(name+"有"+legs+"条腿，"+"现在已经"+age+"岁了");
	}
}
