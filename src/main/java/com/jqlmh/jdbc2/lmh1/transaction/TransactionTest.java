package com.jqlmh.jdbc2.lmh1.transaction;

import com.jqlmh.jdbc1.lmh3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;


/**
 * 
 * @Description 考虑事务后的增删改通用操作
 * @author LMH
 * @version
 * @date 2019年10月16日下午2:33:57
 *
 */

/*
 * 
 * 1.什么叫数据库事务?
 * 	事务:一组逻辑操作单元,使数据从一种状态变换到另一种状态。
 * 		>一组逻辑操作单元:一个或者多个DML语句;
 * 2.事务处理的原则
 * 		当在一个事务中执行多个操作时，要么所有的事务都**被提交(commit)**，那么这些修改就永久地保存下来；要么数据库管理系统将放弃所作的所有修改，整个事务**回滚(rollback)**到最初状态。
 * 3.数据一旦提交提交,就不可回滚
 * 4.哪些操作会导致数据的自动提交
 * 	>DDL操作一旦执行,都会自动提交
 * 		>set autocommit=false,对DDL无效
 * 	>DML默认情况下,一旦执行,就会自动提交
 * 		>我们可以设置set autocommit=false的方式取消DML操作的自动提交
 * 	>默认在关闭连接的时候,自动提交数据
 * 
 * 
 * 
 */

public class TransactionTest {

	/*
	 * 测试1.0版本的通用增删改操作
	 * 针对数据表user_table来说:
	 * 	AA用户给BB用户转账100
	 * 
	 * update user_table set balance=balance-100 where user='AA';
	 * update user_table set balance=balance+100 where user='BB';
	 */
	
	
	//**************************未考虑数据库事务情况系下的转账操作*************************************************
	@Test
	public void TestMethod(){
		//AA转账
		String sql1="update user_table set balance=balance-100 where user=?";
		insertDeleteUpdate(sql1, "AA");
		
		//模拟网络异常
		System.out.println(100/0);
		
		//BB收款
		String sql2="update user_table set balance=balance+100 where user=?";
		insertDeleteUpdate(sql2, "BB");
		
		System.out.println("转账成功");
		
	}
	
	
	//通用的增删改操作---version1.0
	public void insertDeleteUpdate(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// 1.获取数据库连接
			conn = JDBCUtils.getConnection();
			// 2.预编译sql语句,返回PreparedStatement实例
			ps = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]); // 小心参数声明错误
			}
			// 4.执行
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps);
		}
	}
	
	
	
	//**************************考虑数据库事务后的转账操作*************************************************
	@Test
	public void TestinsertDeleteUpdateWithTx() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();

			System.out.println(conn.getAutoCommit()); // true
			// 1.取消数据的自动提交
			conn.setAutoCommit(false);

			// AA转账
			String sql1 = "update user_table set balance=balance-100 where user=?";
			insertDeleteUpdate(conn, sql1, "AA");

			// 模拟网络异常
			System.out.println(100 / 0);

			// BB收款
			String sql2 = "update user_table set balance=balance+100 where user=?";
			insertDeleteUpdate(conn, sql2, "BB");

			System.out.println("转账成功");
			// 2.提交数据
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			// 3.出现异常回滚数据
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				// 修改为自动提交数据
				// 主要针对数据库连接池的使用
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtils.closeResource(conn, null);
		}
	}

	// 通用的增删改操作---version2.0 (考虑数据库事务)
	public void insertDeleteUpdate(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;

		try {
			// 1.预编译sql语句,返回PreparedStatement实例
			ps = conn.prepareStatement(sql);
			// 2.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]); // 小心参数声明错误
			}
			// 3.执行
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.资源关闭
			JDBCUtils.closeResource(null, ps);
		}
	}
		
		
		
		
		
		//**************************设置数据库的隔离级别*************************************************
		@Test
		public void testTransactionSelect() throws Exception{
			
			Connection conn = JDBCUtils.getConnection();
			//获取当前连接的隔离级别
			System.out.println(conn.getTransactionIsolation());
			//设置数据库的隔离级别
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			//取消自动提交
			conn.setAutoCommit(false);
			String sql="SELECT user,password,balance FROM user_table WHERE USER=?;";
			User user = getInstance(conn, User.class, sql, "CC");
			System.out.println(user);
		}
		
		@Test
		public void testTransactionUpdate() throws Exception{
			Connection conn = JDBCUtils.getConnection();
			
			//取消自动提交
			conn.setAutoCommit(false);
			
			String sql="update user_table set balance=? WHERE USER=?;";
			insertDeleteUpdate(conn, sql, 5000,"CC");
			
			Thread.sleep(15000);
			System.out.println("修改结束");
		}
		
	
		/**
		 * 
		 * @Description 实现针对不同表的通用的查询操作,返回一条记录(version2.0:考虑事务)  外部传入连接
		 * @author LMH
		 * @date 2019年10月16日下午4:13:08
		 * @param clazz
		 * @param sql
		 * @param args
		 * @return
		 */
	public <T> T getInstance(Connection conn, Class<T> clazz, String sql, Object... args) {
		PreparedStatement ps = null;
		;
		ResultSet rs = null;
		;
		try {
			// 1.预编译sql语句,获取PreparedStatement实例
			ps = conn.prepareStatement(sql);

			// 2.填充占位符,根据参数的长度来填充
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			// 3.执行查询,返回结果集
			rs = ps.executeQuery();

			// 4.获取结果集元数据
			ResultSetMetaData rsmd = rs.getMetaData();

			// 5.获取结果集的列数
			int columnCount = rsmd.getColumnCount();

			// 6.查询下一行是否有数据,如果有数据就创建一个t对象用于保存数据(多行就用while)
			if (rs.next()) {

				T t = clazz.newInstance();

				// 循环条件为列数
				for (int i = 0; i < columnCount; i++) {
					// 7.通过ResultSetMetaData
					// 获取每列的列名:getColumnName()
					// 获取列的别名:getColumnLabel()
					// String columnName = rsmd.getColumnName(i+1);
					String columnLabel = rsmd.getColumnLabel(i + 1);

					// 获取每列的列值:通过ResultSet
					Object columnValue = rs.getObject(i + 1);

					// 8.将数据封装在t对象中,使用反射:将对象名为columnLabel的属性赋值为指定的值columnValue
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps, rs);
		}
		return null;
	}

}
