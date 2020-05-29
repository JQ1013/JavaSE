package com.jqlmh.abstractkeyword.practice2;

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] e = new Employee[10]; //Emloyee类型数组，存放各类雇员对象的引用
        e[0] = new SalariedEmployee("tom", 001, new MyDate(1995, 5, 26), 5000);
        e[1] = new HourlyEmployee("jack", 002, new MyDate(1996, 7, 30), 20, 80);
        //方式一
//		System.out.print("本月是：");
//		Scanner s1=new Scanner(System.in);
//		int nowmonth=s1.nextInt();

        //方式二
        Calendar c1 = Calendar.getInstance();
        int nowmonth = c1.get(c1.MONTH); //获取当前月份

        for (int i = 0; i < e.length; i++) {
            if (e[i] != null) {
                System.out.println(e[i].toString()); //输出员工类型和信息
                System.out.println("月工资为:");
                if (nowmonth == e[i].getBirthday().getMonth()) {  //检测本月是否为员工生日，如果是则输出工资增加信息
                    System.out.println(e[i].getName() + "本月工资增加100元");
                }
            }
        }
    }
}
