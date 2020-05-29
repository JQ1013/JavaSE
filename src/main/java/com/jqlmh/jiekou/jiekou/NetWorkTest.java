package com.jqlmh.jiekou.jiekou;
/*
 * 接口应用：代理模式
 * 
 */
public class NetWorkTest {
	public static void main(String[] args) {
		Server server = new Server();
		ProxyServer proxyServer = new ProxyServer(server);
		proxyServer.browse();
	}
}

interface NetWork{
	public void browse();
}


//被代理类
class Server implements  NetWork{

	@Override
	public void browse() {
		System.out.println("真实的服务器来访问网路");
	}
	
}


//代理类
class ProxyServer implements NetWork{
	
	private NetWork work;
	
	public ProxyServer(NetWork work) {
		super();
		this.work = work;
	}
	public void check() {
		System.out.println("联网之间的检测");
	}
	@Override
	public void browse() {
		check();
		work.browse();
	}
	
}

