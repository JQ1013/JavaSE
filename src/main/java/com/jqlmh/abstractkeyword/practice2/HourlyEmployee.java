package com.jqlmh.abstractkeyword.practice2;

public class HourlyEmployee extends Employee {
    private double wage;
    private int hour;


    public HourlyEmployee() {
        super();
    }


    public HourlyEmployee(String name, int number, MyDate birthday, double wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    //实现抽象方法：返回小时工资*工时
    @Override
    public double earnings() {
        return wage * hour;
    }

    //重写父类toString方法，返回员工类型和信息
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getName() + "的员工类型是小时工员工，" + super.toString();
    }
}
