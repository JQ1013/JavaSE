package com.jqlmh.jdbc2.lmh2.dao;

import com.jqlmh.jdbc2.lmh2.bean.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CustomersDAOImpl extends BaseDAO implements CustomersDAO {

	// 插入customers表中一条记录
	@Override
	public void insert(Connection conn, Customers cust) {
		String sql = "insert into customers(name,email,birth) values(?,?,?)";
		insertDeleteUpdate(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth());
	}

	// 删除customers表中一条记录
	@Override
	public int deleteById(Connection conn, int id) {
		String sql = "delete from customers where id=?";
		int deleteCount = insertDeleteUpdate(conn, sql, id);
		return deleteCount;
	}

	// 修改customers表中一条记录
	@Override
	public int updateById(Connection conn, Customers cust) {
		String sql = "update customers set name=?,email=?,birth=? where id=?";
		int updateCount = insertDeleteUpdate(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth(), cust.getId());
		return updateCount;
	}

	// 获取customers表中一条记录,返回一个Customers对象
	@Override
	public Customers getCustomerById(Connection conn, int id) {
		String sql = "select id,name,email,birth from customers where id=?";
		Customers customers = getInstance(conn, Customers.class, sql, id);
		return customers;
	}

	// 获取customers表中所有记录,返回所有对象构成的集合
	@Override
	public List<Customers> getAllCustomers(Connection conn) {
		String sql = "select id,name,email,birth from customers";
		List<Customers> list = getForList(conn, Customers.class, sql);
		return list;
	}

	// 获取customers表中的条目数
	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from customers";
		return getValue(conn, sql);
	}

	// 获取customers表中最大生日
	@Override
	public Date getMAxBirth(Connection conn) {
		String sql = "select max(birth) from customers";
		return getValue(conn, sql);
	}

}
