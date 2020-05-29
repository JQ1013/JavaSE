package com.jqlmh.abstractkeyword.template;

public class TemplateTest {
    public static void main(String[] args) {
        Template t1 = new SubTemplate();
        t1.speedTime();
    }
}


abstract class Template {

    //计算某段代码需要花费的时间
    public void speedTime() {
        long start = System.currentTimeMillis();
        code();  //不确定、容易变化的部分
        long end = System.currentTimeMillis();
        System.out.println("执行程序花费的时间是" + (end - start));
    }

    public abstract void code();

}

class SubTemplate extends Template {

    @Override
    public void code() {
        for (int i = 2; i <= 10000; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }

}