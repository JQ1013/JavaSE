package com.jqlmh.abstractkeyword.practice2;

public class MyDate {
    private int year;
    private int month;
    private int day;


    public MyDate() {
        super();
    }


    public int getMonth() {
        return month;
    }


    public void setMonth(int month) {
        this.month = month;
    }


    public MyDate(int year, int month, int day) {
        super();
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public String toDateString() {
        return year + "年" + month + "月" + day + "日";
    }
}
