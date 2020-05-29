package com.jqlmh.exercise.test;

public class PassObiect {
	public static void main(String[] args) {
		PassObiect po=new PassObiect();
		Circle c=new Circle();
		System.out.println("Radius\tArea");
		//使用匿名对象
		//po.printAreas(new Circle(), 5);
		
		//不实用匿名对象
		po.printAreas(c, 5);
		
		
	}
	
	
	/**
	 * 打印小于指定整数的所有半径值，以及对应的面积
	* @Description 
	* @author Luminghao
	* @date 2019年5月30日下午11:34:24
	* @param c
	* @param time
	 */
	public void printAreas(Circle c,int time) {
		for (int i = 1; i <= time; i++) {
			c.radius=i;
			double area=c.findArea();
			System.out.println(c.radius+"\t"+area);
		}
		System.out.println("Now radius is:"+(c.radius+1));  //此句可以放在main方法中，因为最好是把一个功能封装在一起
	}

}

class Circle {
	//半径
	double radius;
	/**
	 * 求圆的面积
	* @Description 
	* @author Luminghao
	* @date 2019年5月30日下午11:33:52
	* @return 圆的面积
	 */
	public double findArea() {
		return Math.PI*radius*radius;
	}

}