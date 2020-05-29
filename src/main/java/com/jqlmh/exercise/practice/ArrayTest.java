package com.jqlmh.exercise.practice;

public class ArrayTest {
	public static void main(String[] args) {
		int[][] arr=new int[][]{{1,2,6},{23,56,2},{3,5}};
		System.out.println(arr.length); //二维数组的长度
		System.out.println(arr[1].length);  //
		//默认初始化值
		System.out.println(arr); 
		System.out.println(arr[1]);
		System.out.println(arr[1][2]);
		//遍历二维数组
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
		}
		System.out.println();
		
		double[][] d=new double[4][];
		System.out.println(d[1]);
		//System.out.println(d[1][0]);
		
		System.out.println("***********************************");
		String[][] arr1=new String[4][3];
		System.out.println(arr1);
		System.out.println(arr1[1]);
		System.out.println(arr1[1][1]);
	}

}
