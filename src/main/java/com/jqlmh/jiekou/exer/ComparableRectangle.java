package com.jqlmh.jiekou.exer;

public class ComparableRectangle extends Rectangle implements CompareObiect {
	
	
	
	public ComparableRectangle(double length, double width) {
		super(length, width);
	}

	@Override
	public int compareTo(Object o) {
		//对象引用一样，面积肯定一样
		if (this==o) {
			return 0;
		}
		
		//判断o的类型，如果是ComparableRectangle，则进行强转
		if (o instanceof ComparableRectangle) {
			ComparableRectangle co=(ComparableRectangle)o;
			
			//方式一
//			if (this.findArea()>co.findArea()) {
//				return 1;
//			} else if (this.findArea()==co.findArea()) {
//				return 0;
//			}else {
//				return -1;
//			}
			
			//方式二：当属性radius的类型为包装类Double时，可以调用包装类的compareTo()方法
			return this.findArea().compareTo(co.findArea());
			
		}else{
			//return 0;
			throw new RuntimeException("比较类型不匹配");  //如果o不是ComparableRectangle类型的对象引用，则抛出异常，比较对象不一致
		}
		
		
	}

}
