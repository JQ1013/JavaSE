package com.jqlmh.jiekou.jiekou;
/*
 * 接口的使用
 * 1.接口的使用也满足多态性
 * 2.接口实际上就是定义了一种规范
 * 3.开发中，体会面向接口编程
 */

public class USBTest {
	public static void main(String[] args) {
		Computer c1=new Computer();
		//1.实现了接口的非匿名实现类的非匿名对象
		Flash flash = new Flash();
		c1.transferData(flash);   //传入USB类型的变量，但是接口不可以造对象，只能造实现类的对象，体现多态性；
		
		//2.实现了接口的非匿名实现类的匿名对象
		c1.transferData(new Printer());
		
		//3.实现了接口的匿名实现类的非匿名对象 
		USB phone=new USB() {
			
			@Override
			public void stop() {
				System.out.println("手机停止工作");
			}
			
			@Override
			public void start() {
				System.out.println("手机开始工作");
			}
		}; 
		c1.transferData(phone);
		
		//4.实现了接口的匿名实现类的匿名对象
		c1.transferData(new USB() {
			
			@Override
			public void stop() {
				System.out.println("键盘停止工作");
			}
			
			@Override
			public void start() {
				System.out.println("键盘开始工作");
			}
		});
		
	}
}

interface USB{
	//常量：定义了长、款、最大最小传输速度等常量
	void start();
	
	void stop();
}


class Computer{
	public void transferData(USB usb) {  //USB usb=new Flash();
		usb.start();
		System.out.println("具体工作细节");
		usb.stop();
	}
}
class Flash implements USB{

	@Override
	public void start() {
		System.out.println("磁盘开始工作");
	}

	@Override
	public void stop() {
		System.out.println("磁盘停止工作");
	}
	
}

class Printer implements USB{

	@Override
	public void start() {
		System.out.println("打印机开始工作");
	}

	@Override
	public void stop() {
		System.out.println("打印机停止工作");
	}
	
}