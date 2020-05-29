package com.jqlmh.exercise.practice;
/**
* 
* @Description 打印一个杨辉三角
* @author Luminghao Email:13142187714@163.com
* @version
* @date 2019年5月16日下午10:05:35
*
 */

/*
 * 1.第一行有一个元素，第n行有n个元素
 * 2.每一行的第一个元素和最后一个元素都是1
 * 3.从第三行开始，对于非第一个和非最后一个元素。即等于上面和左上元素之和
 * yanhui[i][j]=yanhui[i-1][j-1]+yanhui[i-1][j];
 */

public class YanghuiTriangle {
	public static void main(String[] args) {
		/*
		 * 使用二维数组打印杨辉三角
		 */
		//1.声明二维数组
		int[][] yanhui=new int[8][];
		
		//2.赋值
		for (int i = 0; i < yanhui.length; i++) {
			yanhui[i]=new int[i+1];             //注意这种声明方式
			yanhui[i][0]=1;
			yanhui[i][i]=1;  //对边界的值赋值为1
			
			for (int j = 1; j < yanhui[i].length-1; j++) {
				
				yanhui[i][j]=yanhui[i-1][j-1]+yanhui[i-1][j];
			}
		}
		
		//3.遍历
		for (int i = 0; i < yanhui.length; i++) {
			for (int j = 0; j < yanhui[i].length; j++) {
				System.out.print(yanhui[i][j]+" ");	
			}
			System.out.println();
		}
		
	}

}
