package com.jqlmh.innerclass;

public class InnerClassTest1 {
	
	//开发中很少见
	public void method(){
		//局部 内部类：方法内
		class AA{
			
		}
	}
	
	//内部类开发中应用举例：
	//返回一个实现了Comparable接口的类的对象
	public Comparable getComparable() {
		
		//创建一个实现了Comparable接口的类：局部内部类
		//方式一
		/*class MyComparable implements Comparable{

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		}
		return new MyComparable()*/;
		
		
		//方式二：创建了实现了接口的匿名实现类的匿名对象
		return new Comparable(){

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
	}

}
