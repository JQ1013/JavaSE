package com.jqlmh.exercise.practice;
/**
*数组的假复制 
* @Description
* @author Luminghao Email:13142187714@163.com
* @version
* @date 2019年5月21日下午11:42:35
*
 */
/*
(1)创建一个名为ArrayTest的类，在main()方法中声明array1和array2两个变量，
他们是int[]类型的数组。
(2)使用大括号{}，把array1初始化为8个素数：2,3,5,7,11,13,17,19。
(3)显示array1的内容。
(4)赋值array2变量等于array1，修改array2中的偶索引元素，使其等于索引值
(如array[0]=0,array[2]=2)。打印出array1。

思考：array1和array2是什么关系？
拓展：修改题目，实现array2对array1数组的复制
 */
//arr1和arr2的地址值是一样，都指向堆空间的一个数组实体
public class ArrayTest2 {
	public static void main(String[] args) {
		int arr1[]={2,3,5,7,11,13,17,19};
		int arr2[]; //没有新new一个数组实体
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]+"\t");
		}
		System.out.println();
		//赋值arr2变量等于arr1
		//不能称为数组的复制
		arr2=arr1;  //只是把arr1的地址给到了arr2了（是地址的赋值），但是实际只new了一个数组，堆空间只有一个数据
		for (int i = 0; i < arr2.length; i++) {
			if (i%2==0) {
				arr2[i]=i;
			}
		}
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]+"\t");
		}
		
	}

}
