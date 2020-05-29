package com.jqlmh.jdbc2.lmh3.dao;

import com.jqlmh.jdbc2.lmh2.bean.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;


public interface CustomersDAO {
	
	/**
	 * 
	 * @Description将cust对象添加到数据库中 
	 * @author LMH
	 * @date 2019年10月16日下午11:16:37
	 * @param cust
	 * @param cust
	 */
	void insert(Connection conn, Customers cust);
	
	/**
	 * 
	 * @Description针对指定的id,删除表中的一条记录 
	 * @author LMH
	 * @date 2019年10月16日下午11:17:44
	 * @param conn
	 * @param id
	 */
	int deleteById(Connection conn, int id);
	
	/**
	 * 
	 * @Description 针对指定的id,修改 数据表中指定的记录
	 * @author LMH
	 * @date 2019年10月16日下午11:18:30
	 * @param conn
	 * @param cust
	 */
	int updateById(Connection conn, Customers cust);
	
	/**
	 * 
	 * @Description 针对指定的id,查询得到对应的Customers对象 
	 * @author LMH
	 * @date 2019年10月16日下午11:21:15
	 * @param conn
	 * @param id
	 * @return
	 */
	Customers getCustomerById(Connection conn, int id);

	
	/**
	 * 
	 * @Description查询表中所有记录构成的集合 
	 * @author LMH
	 * @date 2019年10月16日下午11:23:30
	 * @param conn
	 * @return
	 */
	List<Customers> getAllCustomers(Connection conn);
	
	
	/**
	 * 
	 * @Description 返回数据表中数据的条目数 
	 * @author LMH
	 * @date 2019年10月16日下午11:24:35
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);
	
	/**
	 * 
	 * @Description 返回数据表中最大的生日 
	 * @author LMH
	 * @date 2019年10月16日下午11:25:55
	 * @param conn
	 * @return
	 */
	Date getMAxBirth(Connection conn);
} 
