package com.jqlmh.jdbc2.lmh5.dbutils;

import com.jqlmh.jdbc2.lmh2.bean.Customers;
import com.jqlmh.jdbc2.lmh4.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * @Description Apache-DBUtils实现CRUD操作
 * @author LMH
 * @version
 * @date 2019年10月17日下午6:48:30
 *
 */
public class QueryRunnerTest {

	// 测试增删改操作
	@Test
	public void testQueryRunner() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnectionByDruid();

			QueryRunner runner = new QueryRunner();
			String sql = "insert into customers(name,email,birth) values(?,?,?)";
			int rows = runner.update(conn, sql, "蔡徐坤", "caixukun.163.com", "1996-11-23"); // 返回值是修改的行数
			System.out.println("插入记录成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	// 测试查询操作
	/*
	 * BeanHandler:是ResultSetHandler接口的实现类,用于封装表中的记录
	 */
	@Test
	public void testQueryRunner1() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnectionByDruid();

			QueryRunner runner = new QueryRunner();
			String sql = "select id,name,email,birth from customers where id=?";
			BeanHandler<Customers> handler = new BeanHandler<>(Customers.class);
			Customers customers = runner.query(conn, sql, handler, 19);
			System.out.println(customers);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	// 测试查询操作
	/*
	 * BeanListHandler:是ResultSetHandler接口的实现类,用于封装表中的多条记录构成的集合
	 */
	@Test
	public void testQueryRunner2() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnectionByDruid();

			QueryRunner runner = new QueryRunner();
			String sql = "select id,name,email,birth from customers where id<?";
			BeanListHandler<Customers> listHandler = new BeanListHandler<>(Customers.class);
			List<Customers> list = runner.query(conn, sql, listHandler, 10);
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	// 测试查询操作
	/*
	 * MapHandler:是ResultSetHandler接口的实现类,对应表中的一条记录 将字段和相应字段的值作为map中的key和value值
	 */
	@Test
	public void testQueryRunner3() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnectionByDruid();

			QueryRunner runner = new QueryRunner();
			String sql = "select id,name,email,birth from customers where id=?";
			MapHandler mapHandler = new MapHandler();
			Map<String, Object> map = runner.query(conn, sql, mapHandler, 10);
			System.out.println(map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	// 测试查询操作
	/*
	 * MapListHandler:是ResultSetHandler接口的实现类,对应表中的多条记录
	 * 将字段和相应字段的值作为map中的key和value值 返回多个map构成的集合
	 */
	@Test
	public void testQueryRunner4() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnectionByDruid();

			QueryRunner runner = new QueryRunner();
			String sql = "select id,name,email,birth from customers where id<?";
			MapListHandler mapListHandler = new MapListHandler();
			List<Map<String, Object>> list = runner.query(conn, sql, mapListHandler, 10);
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	// 测试查询操作
	/*
	 * ScalarHandler:是ResultSetHandler接口的实现类,查询表中的特殊值
	 */
	// 查询条目数
	@Test
	public void testQueryRunner5() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnectionByDruid();

			QueryRunner runner = new QueryRunner();
			String sql = "select count(*) from customers";
			ScalarHandler scalarHandler = new ScalarHandler();
			long count = (long) runner.query(conn, sql, scalarHandler);
			System.out.println(count);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	// 查询最大生日
	@Test
	public void testQueryRunner6() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnectionByDruid();

			QueryRunner runner = new QueryRunner();
			String sql = "select max(birth) from customers";
			ScalarHandler scalarHandler = new ScalarHandler();
			Date birth = (Date) runner.query(conn, sql, scalarHandler);
			System.out.println(birth);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

}
