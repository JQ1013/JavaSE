package com.jqlmh.exercise.practice;
/**
 * 算法第二种：求最值:最大值、最小值、和、平均值
* @Description
* @author Luminghao Email:13142187714@163.com
* @version
* @date 2019年5月21日下午11:18:40
*
 */
public class ArrayTest1 {
	public static void main(String[] args) {
		int[] arr=new int[10];
		double average=0;
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			arr[i]=(int)(Math.random()*90+10);
		}
		
		int max=arr[0];  //保险起见，把数组中的任意一个元素设为最大值和最小值
		int min=arr[0];
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i]>=max){
				max=arr[i];
			}
			if (arr[i]<=min) {
				min=arr[i];
			}
			sum+=arr[i];
			average=sum/arr.length;
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
		System.out.println(average);
	}

}
