package com.jqlmh.abstractkeyword.abstrcttest;

/*
 * 抽象类的匿名子类对象
 */
public class PersonTest {
    public static void main(String[] args) {
        method(new Student());  //一、有名的类，匿名对象
        Work work = new Work();
        method1(work); //二、有名的类，有名的对象
        System.out.println("**********************");

        //三、创建一个匿名子类，有名对象：p
        Person p = new Person() {
            @Override
            public void show() {
                System.out.println("显示抽象类的匿名子类");
            }
        };
        method1(p);


        System.out.println("**********");

        //四、创建一个匿名子类的匿名对象
        method1(new Person() {

            @Override
            public void show() {
                System.out.println("创建一个匿名子类的匿名对象");

            }
        });
    }

    public static void method(Student s) {

    }

    public static void method1(Person p) {
        p.show();
    }

}

class Work extends Person {
    @Override
    public void show() {
        System.out.println("显示工人信息");
    }

}