package com.jqlmh.abstractkeyword.practice2;

public abstract class Employee {
    private String name; //姓名
    private int number; //工号
    private MyDate birthday;//生日

    public Employee() {
        super();
    }

    public Employee(String name, int number, MyDate birthday) {
        super();
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    //抽象方法
    public abstract double earnings();

    //toString方法
    @Override
    public String toString() {
        return "Employee [name=" + name + ", number=" + number + ", birthday=" + birthday.toDateString() + "]";
    }


}
