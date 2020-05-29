package com.jqlmh.jdbc2.lmh4.connection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 
 * @Description 使用Druid(德鲁伊)数据库连接池技术
 * @author LMH
 * @version
 * @date 2019年10月17日下午5:29:45
 *
 */
public class DruidTest {
	
	@Test
	public void testGetConnectionByDruid() throws Exception{
		Properties pro = new Properties();
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
		URL url = ClassLoader.getSystemClassLoader().getResource("druid.properties");
		System.out.println(url);
		pro.load(is);
		
		DataSource druidDS = DruidDataSourceFactory.createDataSource(pro);
		Connection conn = druidDS.getConnection();
		System.out.println(conn);
	}

}
