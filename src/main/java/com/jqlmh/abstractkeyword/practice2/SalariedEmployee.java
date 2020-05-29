package com.jqlmh.abstractkeyword.practice2;

public class SalariedEmployee extends Employee {

    private double monthlySalary; //月工资

    public SalariedEmployee() {
        super();
    }

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    //实现抽象方法：返回月工资
    @Override
    public double earnings() {
        return monthlySalary;
    }

    //重写父类toString方法，返回员工类型和信息
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getName() + "的员工类型是月结工资员工," + super.toString();
    }
}
