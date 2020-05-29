package com.jqlmh.extendskeyword.test5;

public class Order {
	private int orderPrivate;
	int orderDefault;
	protected int orderProtected;
	public int orderPublic;
	
	private void methodPrivate() {
		
		orderPrivate=1;
		orderDefault=1;
		orderProtected=1;
		orderPublic=1;
	}
	
	void methodDefault(){
		
	}
	
	protected void methodProtect() {
		
	}
	
	public void methodPublic() {
		
	}

}
