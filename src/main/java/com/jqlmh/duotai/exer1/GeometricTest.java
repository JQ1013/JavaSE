package com.jqlmh.duotai.exer1;

public class GeometricTest {
	public static void main(String[] args) {
		GeometricTest gt=new GeometricTest();
		Circle c=new Circle("red", 1, 1);
		MyRectangle m=new MyRectangle("green", 2, 10, 20);
		gt.equalsArea(c, m);
		gt.displayGeometricObject(m);
		
	}
	
	
	public void equalsArea(GeometricObject g1,GeometricObject g2){
		if (g1.findArea()==g2.findArea()) {
			System.out.println("两个图形的面积相等");
		} else {
			System.out.println("两个图形的面积不相等");
		}
	}
	
	public void displayGeometricObject(GeometricObject g){
		System.out.println("图形的面积是："+g.findArea());
	}

}
