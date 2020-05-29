package com.jqlmh.exercise.practice;

import java.util.Arrays;

/**
 * 数组练习
* @Description
* @author Luminghao Email:13142187714@163.com
* @version
* @date 2019年5月25日上午1:48:47
*
 */
public class DayTest {
	public static void main(String[] args) {
		int[] arr=new int[]{34,5,22,-98,6,-76,0,-3};
		
		//1.冒泡排序
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		//2.反转
		for (int i = 0; i < arr.length/2; i++) {
			temp=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-1-i]=temp;
		}
		System.out.println(Arrays.toString(arr));
		
		//3.数组复制
		int[] arr2=new int[arr.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=arr[i];
		}
		System.out.println(Arrays.toString(arr2));
		
		//4.线性查找
		int num=-98;
		boolean flag=false;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i]==num) {
				System.out.println("找到指定元素，位置是："+i);
				flag=true;
				break;
			}
		}
		if (flag==false) {
			System.out.println("没有找到指定元素");
		}
	}

}
