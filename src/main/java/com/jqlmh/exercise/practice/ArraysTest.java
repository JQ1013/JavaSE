package com.jqlmh.exercise.practice;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
* Arrays工具类的使用，java.util.Arrays类即为操作数组的工具类，包含了用来操作数组（比
如排序和搜索）的各种方法。
* @Description
* @author Luminghao Email:13142187714@163.com
* @version
* @date 2019年5月25日上午1:23:45
*
*/

/*
1 boolean equals(int[] a,int[] b) 判断两个数组是否相等。
2 String toString(int[] a) 输出数组信息。
3 void fill(int[] a,int val) 将指定值填充到数组之中。
4 void sort(int[] a) 对数组进行排序。
5 int binarySearch(int[] a,int key) 对排序后的数组进行二分法检索指定的值。
 */
public class ArraysTest {
	public static void main(String[] args) {
		//1 boolean equals(int[] a,int[] b) 判断两个数组是否相等。
		
		int[] arr1=new int[]{1,2,3,4};
		int[] arr2=new int[]{1,3,2,4};
		boolean isEqual=Arrays.equals(arr1, arr2);
		if (isEqual==true) {
			System.out.println("两个数组相等");
		} else {
			System.out.println("两个数组不相等");
		}
		
		//2 String toString(int[] a) 以字符串输出数组信息。相当于遍历
		
		System.out.println(Arrays.toString(arr1));
		
		//3 void fill(int[] a,int val) 将指定值填充到数组之中。
		Arrays.fill(arr2, 10);
		System.out.println(Arrays.toString(arr2));
		
		//4 void sort(int[] a) 对数组进行排序。快速排序
		int[] arr3=new int[]{23,45,89,6,23,795,23,456,23,4,1,3,46,3,1,64,6,312,31};
		Arrays.sort(arr3);
		System.out.println(Arrays.toString(arr3));
		
		//5 int binarySearch(int[] a,int key) 对排序后的数组进行二分法检索指定的值
		int index=Arrays.binarySearch(arr3, 5);
		if (index>0) {
			System.out.println("找到元素的位置为"+index);
		} else {
			System.out.println("未找到元素");

		}
		
	}

}
