package com.jqlmh.exception.exer;

//自定义异常类
public class EcDef extends Exception {
	static final long serialVersionUID = -3387516993124229948L;

	public EcDef() {

	}

	public EcDef(String msg) {
		super(msg);
	}
}
