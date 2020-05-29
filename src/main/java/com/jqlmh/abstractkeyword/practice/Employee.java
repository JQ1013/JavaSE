package com.jqlmh.abstractkeyword.practice;

/*
 * 编写一个Employee类，声明为抽象类，
	包含如下三个属性：name，id，salary。
	提供必要的构造器和抽象方法：work()。
	对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
	请使用继承的思想，设计CommonEmployee类和Manager类，要求类中提供必要的方法进行属性访问。
 */
public abstract class Employee {  //抽象类
    private String name;
    private int id;
    private double salary;

    public Employee() {
        super();
    }

    public Employee(String name, int id, double salary) {
        super();
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void work(); //抽象方法，无方法体
}



	

