package com.jqlmh.abstractkeyword.practice;

/**
 * 对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
 */
public class Manager extends Employee {

    /**
     * 奖金
     */
    private double bonus;


    public Manager(double bonus) {
        super();
        this.bonus = bonus;
    }


    Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }


    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("管理者管理员工");
    }
}
