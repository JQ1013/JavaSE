package com.jqlmh.exercise.object;
/*
	定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。 
	创建20个学生对象，学号为1到20，年级和成绩都由随机数确定
	问题一：打印出3年级(state值为3）的学生信息。
	问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
	提示：
	1) 生成随机数：Math.random()，返回值类型double; 
	2) 四舍五入取整：Math.round(double d)，返回值类型long。*/


public class StudentTest {
	public static void main(String[] args) {
		//声明Student类型的数组
		Student[] stud=new Student[20];
		
		//给数组元素赋值，每一个元素都是一个Student类型的对象
		for (int i = 0; i < stud.length; i++) {
			stud[i]=new Student();
			
			//学号[1-20]
			stud[i].num=i+1;
			//年纪[1-12]
			stud[i].state=(int)(Math.random()*12+1);
			//分数[0,100]
			stud[i].score=(int)(Math.random()*100);
		}
		
		//实例化一个StudentTest对象，用于调用方法
		StudentTest test=new StudentTest();
		
		//1.遍历数组元素，调用定义的Print方法，形参为对象数组
		test.Print(stud);
		System.out.println("***********************************");
		
		//2.打印出3年级(state值为3）的学生信息。
		test.PrintState(stud, 3);
		System.out.println("***********************************");
		
		//3.使用冒泡排序按学生成绩排序，并遍历所有学生信息
		test.sort(stud);
		test.Print(stud);
	}
	
	/**
	 * 遍历每一个学生的信息
	 * @Description 
	 * @author Luminghao
	 * @date 2019年5月26日下午11:26:25
	 * @param stud
	 */
	public void Print(Student[] stud){
		for (int i = 0; i < stud.length; i++) {
			System.out.println(stud[i].info());
			}
		}

	/**
	* 遍历指定年级的学生信息
	* @Description 
	* @author Luminghao
	* @date 2019年5月26日下午11:26:33
	* @param stud
	* @param state
	*/
	public void PrintState(Student[] stud,int state) {
		for (int i = 0; i < stud.length; i++) {
			if (stud[i].state==state) {
				System.out.println(stud[i].info());
			}
		}
	}
	
	/**
	* 
	* @Description 用冒泡排序按照分数大小对每一个学生进行排序
	* @author Luminghao
	* @date 2019年5月26日下午11:34:42
	* @param stud
	* @param state
	*/
	public void sort(Student[] stud) {
		for (int i = 0; i < stud.length-1; i++) {
			for (int j = 0; j < stud.length-i-1; j++) {
				if (stud[j].score>stud[j+1].score) {
					Student temp=new Student();
					temp=stud[j];
					stud[j]=stud[j+1];
					stud[j+1]=temp;
				}
			}
		}
	}
}
	
	


//定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。 
class Student{
	int num; //学号
	int state;  //年级
	int score; //分数
	
	/**
	* 
	* @Description 返回对象的属性
	* @author Luminghao
	* @date 2019年5月26日下午11:40:10
	* @return 本对象的所有属性
	*/
	public String info(){
		return "学号:"+num+", 年纪 :"+state+", 分数:" +score;
	}
	
}