package com.jqlmh.baozhuanglei.baozhuang;


import org.junit.Test;

/*
 * 包装类的使用
 * 1.Java提供了8种基本数据类型的包装类，使得基本数据类型的变量具有类的特征
 *
 * 2.掌握：基本数据类型、包装类、String的转换
 * 		JDK5.0 新特性：自动装箱与拆箱
 */
public class WrapperTest {
    /*
     * JDK5.0 新特性：自动装箱与拆箱
     */


    //String类型--->基本数据类型、包装类:调用包装类的parseXxx(String s)
    @Test
    public void test5() {
        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i);

        //String类型转换为boolean
        String str2 = "true";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1 == false);
    }


    //基本数据类型、包装类--->String类:调用String重载的valueOf（Xxx xxx）方法
    @Test
    public void test4() {
        int num = 10;
        //方式一：连接运算
        String str1 = num + "20";
        System.out.println(str1);

        //方式二：调用String的ValueOf（Xxx xxx）
        float f = 1.2f;
        String str2 = String.valueOf(f); //"1.2"

        Double d1 = new Double(1.6);
        String str3 = String.valueOf(d1);  //包装类调用String的ValueOf（Xxx xxx）方法

        System.out.println(str2); //"1.2"
        System.out.println(str3); //"1.6"


    }

    @Test
    public void test3() {

//		int num=10;
//		Integer in1=new Integer(num);
//		method(num);

        //自动装箱与拆箱

        int num2 = 10;
        Integer in2 = num2; //自动装箱

        boolean b1 = true;
        Boolean b2 = b1; //自动装箱

        //自动拆箱
        int num3 = in2;
        boolean b3 = b2;


    }

    public void method(Object obj) {

    }


    //基本数据类型----->包装类：调用包装类的构造器
    @Test
    public void test1() {
        int num = 10;
        Integer i = new Integer(num);
        System.out.println(i.toString());

        Integer i2 = new Integer("122");
        System.out.println(i2.toString());

        //报异常
//		Integer i2=new Integer("122abc");
//		System.out.println(i2.toString());

        Float f1 = new Float(1.0);
        Float f2 = new Float("12.3");
        System.out.println(f1);
        System.out.println(f2);

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("true123");
        Boolean b4 = new Boolean("tRuE");

        System.out.println(b1); //true
        System.out.println(b2);//true
        System.out.println(b3); //false,只要不匹配true就false
        System.out.println(b4);//true 忽略大小写

        Order o1 = new Order();
        System.out.println(o1.b1); //false:基本数据类型，默认初始化值为false
        System.out.println(o1.b2); //null：o2是引用数据类型，默认初始化值是null
    }

    //包装类--->基本数据类：调用包装类的xxxValue（）方法
    @Test
    public void test2() {
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(i1 + 10);

        Float f1 = new Float(12.3);
        float f2 = f1.floatValue();
        System.out.println(f2 + 15);
    }


}

class Order {
    boolean b1;
    Boolean b2;
}
