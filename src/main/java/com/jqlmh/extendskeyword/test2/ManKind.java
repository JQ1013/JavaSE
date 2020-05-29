package com.jqlmh.extendskeyword.test2;

public class ManKind {
	private int sex;
	private int salary;
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public ManKind() {
		super();
	}
	public ManKind(int sex, int salary) {
		super();
		this.sex = sex;
		this.salary = salary;
	}
	public void manOrWoman() {
		if (sex==1) {
			System.out.println("man");
		} 
		if (sex==0) {
			System.out.println("woman");
		}
	}
	public void employeed() {
		if (salary==0) {
			System.out.println("no job");
		}
		if (salary!=0) {
			System.out.println("job");
		}
	}
}
