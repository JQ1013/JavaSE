package com.jqlmh.exercise.practice;
/**
 * 算法第三种：数组的复制、反转、查找
* @Description
* @author Luminghao Email:13142187714@163.com
* @version
* @date 2019年5月21日下午11:54:31
*
 */
public class ArrayTest3 {
	public static void main(String[] args) {
		//数组的复制，区别于数组变量的赋值（arr2=arr1）
		/*String arr1[]={"AA","BB","CC","GG"};
		String arr2[]=new String[arr1.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=arr1[i];
			System.out.print(arr2[i]+" ");*/
		
		//数组的反转
		int[] arr={23,6,45,32,69,5,46};
		String arr2[]={"AA","BB","CC","DD","GG"};
		String dest="AA";  //需要搜索的元素
		int temp;
		//方法一
		/*for (int i = 0; i < arr.length/2; i++) {
			temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
			
		}*/
		//方法2
		/*for (int i = 0,j=arr.length-1; i < j; i++,j--) {
			temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}*/
		
		//数组查找
		//方法一：线性查找
		/*boolean flag=false;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i].equals(dest)) {
				System.out.println("找到目标元素，位置是"+i);
				flag=true;
				break;
			}
		}
		if (flag==false) {
			System.out.println("未找到指定元素");
		}*/
		
		//方法二：二分查找
		//先排序
		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i<arr.length-j; i++) {
				if (arr[i]>arr[i+1]) {
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		//遍历
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		
		boolean flag=false;
		int num=46;
		int start=0;
		int end=arr.length-1;
		//循环条件
		while(start<=end){
			int mid=(start+end)/2;
			if (num==arr[mid]) {
				System.out.println("找到元素"+num+"位置是"+mid);
				flag=true;
				break;
			}else if(num<arr[mid]) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}	
		
		if (flag==false) {
			System.out.println("没有找到元素"+num);
		}
	}
		
}
		



