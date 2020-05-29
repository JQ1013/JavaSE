package com.jqlmh.jdbc2.lmh4.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 
 * @Description 使用DBCP数据库连接池技术
 * @author LMH
 * @version
 * @date 2019年10月17日下午5:29:27
 *
 */
public class DBCPTest {
	
	//方式一:硬编码,不推荐
	@Test
	public void testgetConnectionByDBCP1() throws Exception{
		//创建了DBCP数据库连接池
		BasicDataSource bds=new BasicDataSource();
		
		//设置连接所需信息
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true");
		bds.setUsername("root");
		bds.setPassword("1013");
		
		//设置数据库连接池管理的其他相关属性
		bds.setInitialSize(10);
		bds.setMaxTotal(10);
		
		Connection conn = bds.getConnection();
		System.out.println(conn);
	}
	
	// 方式二:使用配置文件,推荐***
	@Test
	public void testgetConnectionByDBCP2() throws Exception {

		Properties pro = new Properties();
		// 获取流的方式
		// 方式一:
		FileInputStream fis = new FileInputStream(new File("src/dbcp.properties")); // 识别的是当前工程下的文件
		// 方式二:
		// InputStream is =
		// ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
		pro.load(fis);

		DataSource ds = BasicDataSourceFactory.createDataSource(pro);
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}

}
