package com.jqlmh.extendskeyword.test1;
/**
 * 
 * @Description
 * @author LMH
 * @version
 * @date 2019年6月11日下午9:45:48
 *
 */
public class Creature {
	private String name;
	private int eyes;
	private int legs;
	private int month;
	private int nose;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getEyes() {
		return eyes;
	}


	public void setEyes(int eyes) {
		this.eyes = eyes;
	}


	public void breath() {
		System.out.println("生物可以呼吸");
	}
	

}
