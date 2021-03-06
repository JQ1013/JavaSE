package com.jqlmh.extendskeyword.test6;
/*
 * 子类对象实例化的全过程
 * 
 * 1.从结果上来看：（继承性）
 *		子类继承父类以后，就获取了父类中声明的属性和方法
 *		创建子类的对象，在堆空间中，就会加载所有父类所有的属性
 *
 * 2.从过程来看：
 * 		当我们通过子类的构造器创建子类对象时，一定会之间或间接地调用父类的构造器，进而调用父类的构造器，
 * 		直到调用了java.lang.Obiect类中空参的构造器为止。正因为加载过所有的父类结构，所以才可以看到
 * 		内存中有父类的 结构，子类对象才可以用考虑进行调用。
 *	明确：虽然创建子类对象时调用了父类的构造器，但是自始至终就创建过一个对象，即为new的子类对象
 */
public class InstanceTest {

}
