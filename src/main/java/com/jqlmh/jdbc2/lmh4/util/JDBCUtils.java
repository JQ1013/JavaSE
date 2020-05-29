package com.jqlmh.jdbc2.lmh4.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
	
	
	/**
	 * 获取数据库的连接
	 * 
	 * @Description
	 * @author LMH
	 * @date 2019年10月14日下午11:17:36
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		// 1.读取配置文件中个四个信息
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("src/main/jdbc.properties");
		Properties pro = new Properties();
		pro.load(is);

		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		String url = pro.getProperty("url");
		String driverClass = pro.getProperty("driverClass");

		// 2.加载驱动
		Class.forName(driverClass);

		// 3.获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	
	/**
	 * 
	 * @Description 使用c3p0数据库连接池技术获取连接
	 * @author LMH
	 * @date 2019年10月17日下午4:23:37
	 * @return
	 * @throws Exception 
	 */
	//数据库连接池只需提供一个即可
	private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
	public static Connection getConnectionByC3P0() throws Exception {
		Connection conn = cpds.getConnection();
		return conn;
	}
	
	/**
	 * 
	 * @Description 使用DBCP数据库连接池技术获取连接
	 * @author LMH
	 * @date 2019年10月17日下午5:20:45
	 * @return
	 * @throws Exception
	 */
	
	//创建一个DBCP数据库连接池
	private static DataSource ds;
	static{
		try {
			Properties pro = new Properties();
			//获取流
			FileInputStream fis = new FileInputStream(new File("src/dbcp.properties"));  //识别的是当前工程下的文件
			pro.load(fis);
			ds = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnectionByDBCP() throws Exception{
		Connection conn = ds.getConnection();
		return conn;
	}
	
	
	
	/**
	 * 
	 * @Description 使用Druid数据库连接池技术获取连接
	 * @author LMH
	 * @date 2019年10月17日下午6:33:13
	 * @return
	 * @throws SQLException
	 */
	
	//创建一个Druid数据库连接池
	private static DataSource druidDS;
	static{
		try {
			Properties pro = new Properties();
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
			pro.load(is);
			druidDS = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnectionByDruid() throws SQLException{
		
		Connection conn = druidDS.getConnection();
		return conn;
	}
	
	
	/**
	 * 关闭数据库连接和Statement操作
	 * 
	 * @Description
	 * @author LMH
	 * @date 2019年10月14日下午11:19:51
	 * @param conn
	 * @param ps
	 */
	public static void closeResource(Connection conn, Statement ps) {
		// 7.资源的关闭
		if (ps != null) {

			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询时,关闭数据库连接和Statement操作
	 * 
	 * @Description
	 * @author LMH
	 * @date 2019年10月14日下午11:19:51
	 * @param conn
	 * @param ps
	 */
	public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
		// 7.资源的关闭
		if (ps != null) {

			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {

			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @Description 使用dbUtils.jar中的工具类DbUtils,实现资源的关闭
	 * @author LMH
	 * @date 2019年10月17日下午9:53:55
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeResource1(Connection conn, Statement ps, ResultSet rs){
//		try {
//			DbUtils.close(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(ps);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(rs);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		DbUtils.closeQuietly(conn);
		DbUtils.closeQuietly(ps);
		DbUtils.closeQuietly(rs);
	}

}
