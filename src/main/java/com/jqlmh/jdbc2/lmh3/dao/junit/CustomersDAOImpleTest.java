package com.jqlmh.jdbc2.lmh3.dao.junit;

import com.jqlmh.jdbc2.lmh2.bean.Customers;
import com.jqlmh.jdbc2.lmh3.dao.CustomersDAOImpl;
import com.jqlmh.jdbc2.lmh4.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;


public class CustomersDAOImpleTest {

	private CustomersDAOImpl dao = new CustomersDAOImpl();

	@Test
	public void testInsert() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			dao.insert(conn, new Customers(1, "孙杨", "sunyang@163.com", new Date(4631311156l)));
			System.out.println("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testDeleteById() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			int deletecount = dao.deleteById(conn, 24);
			if (deletecount == 0) {
				System.out.println("已删除,请勿重复删除");
			} else {
				System.out.println("删除成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testUpdateById() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			Customers cust = new Customers(19, "姜覃", "jiangqin.163.com", new Date(1344131313134l));
			dao.updateById(conn, cust);
			System.out.println("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testGetCustomerById() {
		Connection conn = null;
		try {
			//conn = JDBCUtils.getConnectionByC3P0(); //使用C3P0数据库连接池技术获取连接
			conn= JDBCUtils.getConnectionByDruid();   //使用Druid数据库连接池技术获取连接
			Customers customers = dao.getCustomerById(conn, 12);
			System.out.println(customers);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testGetAllCustomers() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnectionByDBCP(); //使用DBCP数据库连接池技术获取连接
			List<Customers> list = dao.getAllCustomers(conn);
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testGetCount() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			Long count = dao.getCount(conn);
			System.out.println("customers表中共有:"+count+"条数据");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testGetMAxBirth() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			Date maxBirth = dao.getMAxBirth(conn);
			System.out.println("最大的生日为:"+maxBirth);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
	}

}
