package com.jqlmh.extendskeyword.test_5;

//不同包的子类


import com.jqlmh.extendskeyword.test5.Order;

public class SubOrder extends Order {
    public void method() {
        orderProtected = 1;
        orderPublic = 2;

        methodProtect();
        methodPublic();


        //在不同包的子类不可以调用用缺省和private修饰的方法的和属性
//		orderDefault();
//		orderPrivate();
    }
}
