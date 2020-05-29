package com.jqlmh.abstractkeyword.abstrcttest;

/*
 * abstract关键字的使用
 * 1.abstract：抽象的
 * 2.abstract可以用来修饰的结构：类、方法
 *
 * 3.abstract修饰类：抽象类
 * 			》不能被实例化
 * 			》抽象类一定有构造器，便于子类实例化时调用（子类对象实例化的全过程）
 * 			>开发中，都会提供抽象类的子类，让子类对象实例化，完成相关操作
 *
 * 4.abstract修饰方法：抽象方法
 * 			》抽象方法只有方法声明，没有方法体public abstract void show();
 * 			》包含抽象方法的类，一定是一个抽象类。反之，抽象类是可以没有抽象方法的
 * 			》若子类重写了父类（包括直接父类和间接父类）的所有抽象方法，子类方可实例化
 * 				》若子类没有重写了父类的所有抽象方法，则此子类为抽象类
 * abstract使用注意点：1.abstract不能修饰属性、构造器
 * 					2.abstract不能用来修饰私有方法（private）、静态方法（static）、final修饰的
 *
 */
public class AbstractTest {
    public static void main(String[] args) {
//		Person p1=new Person(); 一旦Person类抽象化，就不能被实例化
//		p1.eat();
    }

}

abstract class Person {
    String name;
    int age;

    public Person() {
        super();
    }

    public abstract void show();

    public void eat() {
        System.out.println("人吃饭");
    }

    public void walk() {
        System.out.println("人走路");
    }

}

class Student extends Person {

    public Student() {
        super();
    }

    public Student(String name, int age) {
        super();
    }

    @Override
    public void show() {
        System.out.println("显示信息");

    }
}


