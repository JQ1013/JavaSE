package com.jqlmh.jiekou.exer;
/*
 * 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
 * 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 */
public class ComparableCircle extends Circle implements CompareObiect {
	
	
	public ComparableCircle(double radius) {
		super(radius);
	}
		
	
	@Override
	public int compareTo(Object o) {
		//对象引用一样，面积肯定一样
		if (this==o) {
			return 0;
		}
		
		//判断o的类型，如果是ComparableRectangle，则进行强转
		if (o instanceof CompareObiect) {
			ComparableCircle circle=(ComparableCircle)o;
//			//方式一：直接比较radius
//			if (this.getRadius()>circle.getRadius()) {
//				return 1;
//			} else if (this.getRadius()==circle.getRadius()) {
//				return 0;
//			}else {
//				return -1;
//			}
			
			//方式二：当属性radius的类型为包装类Double时，可以调用包装类的方法
			return this.getRadius().compareTo(circle.getRadius());
			
		}else {
			//return 0;
			throw new RuntimeException("比较类型不匹配");
		}
		
		
	}


}
