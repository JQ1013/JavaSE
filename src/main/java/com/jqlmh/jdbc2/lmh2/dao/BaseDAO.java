package com.jqlmh.jdbc2.lmh2.dao;

import com.jqlmh.jdbc2.lmh1.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;


/*
 * 封装了针对于数据表的通用操作
 */
public abstract class BaseDAO {

	// 通用的增删改操作---version2.0 (考虑数据库事务)
	public int insertDeleteUpdate(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;

		try {
			// 1.预编译sql语句,返回PreparedStatement实例
			ps = conn.prepareStatement(sql);
			// 2.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]); // 小心参数声明错误
			}
			// 3.执行
			return ps.executeUpdate(); // 此方法返回修改的记录数
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.资源关闭
			JDBCUtils.closeResource(null, ps);
		}
		return 0;
	}

	// 通用的查询操作,返回一条记录(version2.0:考虑事务)
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

	// 通用的查询操作,返回多条记录构成的集合(version2.0:考虑事务)
	public <T> List<T> getForList(Connection conn, Class<T> clazz, String sql, Object... args) {
		PreparedStatement ps = null;
		;
		ResultSet rs = null;
		;
		try {
			// 2.预编译sql语句,获取PreparedStatement实例
			ps = conn.prepareStatement(sql);

			// 3.填充占位符,根据参数的长度来填充
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			// 4.执行查询,返回结果集
			rs = ps.executeQuery();

			// 5.获取结果集元数据
			ResultSetMetaData rsmd = rs.getMetaData();

			// 6.获取结果集的列数
			int columnCount = rsmd.getColumnCount();

			// 创建集合对象
			ArrayList<T> list = new ArrayList<T>();
			// 7.查询下一行是否有数据,如果有数据就创建一个t对象用于保存数据(多行就用while)
			while (rs.next()) {

				T t = clazz.newInstance();

				// 处理结果集每一行数据中的每一个列:给t对象的指定属性赋值;
				for (int i = 0; i < columnCount; i++) {
					// 8.通过ResultSetMetaData
					// 获取每列的列名:getColumnName()
					// 获取列的别名:getColumnLabel()
					// String columnName = rsmd.getColumnName(i+1);
					String columnLabel = rsmd.getColumnLabel(i + 1);

					// 获取每列的列值:通过ResultSet
					Object columnValue = rs.getObject(i + 1);

					// 9.将数据封装在t对象中,使用反射:将对象名为columnLabel的属性赋值为指定的值columnValue
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				list.add(t);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps, rs);
		}
		return null;
	}

	// 查询特殊值的通用放法:比如数据表的行数,最大值等
	public <T> T getValue(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;

		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				return (T) rs.getObject(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps, rs);
		}

		return null;
	}
}
