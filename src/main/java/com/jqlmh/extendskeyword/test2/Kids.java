package com.jqlmh.extendskeyword.test2;

public class Kids extends ManKind {
	private int yearsOld;
	
	public Kids() {
		super();
	}

	public Kids(int yearsOld) {
		super();
		this.yearsOld = yearsOld;
	}

	public int getYearsOld() {
		return yearsOld;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
	
	@Override
	public void employeed() {
		System.out.println("Kids should study and no jods！");
	}

	public void printAge() {
		System.out.println("i am "+yearsOld+" years old");
	}
}
