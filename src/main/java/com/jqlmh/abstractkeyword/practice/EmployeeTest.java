package com.jqlmh.abstractkeyword.practice;

public class EmployeeTest {
    public static void main(String[] args) {
        //多态
        Employee m1 = new Manager("曹老板", 2, 5000, 3000);
        m1.work();

        CommonEmployee c1 = new CommonEmployee();
        c1.work();
    }
}
