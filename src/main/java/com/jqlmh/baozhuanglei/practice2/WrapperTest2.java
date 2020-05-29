package com.jqlmh.baozhuanglei.practice2;

import java.util.Scanner;
import java.util.Vector;
/*
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出
     最高分，并输出学生成绩等级。
提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的
     长度。而向量类java.util.Vector可以根据需要动态伸缩。
创建Vector对象：Vector v=new Vector();
给向量添加元素：v.addElement(Object obj); //obj必须是对象
取出向量中的元素：Object obj=v.elementAt(0);
注意第一个元素的下标是0，返回值是Object类型的。
计算向量的长度：v.size();
若与最高分相差10分内：A等；20分内：B等；
  30分内：C等；其它：D等
 */
public class WrapperTest2 {
	public static void main(String[] args) {
		//1.实例化scanner对象，用于输入学生成绩
		Scanner s1=new Scanner(System.in);
		
		//2.创建向量对象
		Vector v=new Vector();
		
		//3.输入学生成绩，找出最大值，判断循环结束条件
		int maxScore=0;
		for(;;){
			System.out.println("请输入学生的分数（以负数代表输入结束:");
			//输入学生成绩
			int score=s1.nextInt();
			//判断循环结束条件
			if (score<0) {
				break;
			}
			if (score>100) {
				System.out.println("输入的成绩超过范围");
				continue;
			}
			//找出最大成绩
			if (score>maxScore) {
				maxScore=score;
			}
		
		//4.给向量添加元素
			//JDK5.0之前
//			Integer in1=new Integer(score);
//			v.addElement(in1); 多态
			
			//JDK5.0之后，自动装箱
			v.addElement(score);	
		}
		
		//5.取出向量中的元素，遍历	
		char level;
		for(int i=0;i<v.size();i++){
			
			Object obj=v.elementAt(i);
			//JDK5.0之前
//			Integer in1=(Integer)obj;
//			int score=in1.intValue();
			//JDK5.0之后
			int score=(int)obj;
			
			if (maxScore-score<=10) {
				level='A';
			}else if (maxScore-score<=20) {
				level='B';
			}else if (maxScore-score<=30) {
				level='C';
			}else {
				level='D';
			}
			
			System.out.println("student "+(i+1)+" score is"+score+",grade is "+level);
		}		
		
	}

}
