package com.jqlmh.jdbc1.lmh3.preparedstatement;

import com.jqlmh.jdbc1.lmh3.bean.Customers;
import com.jqlmh.jdbc1.lmh3.bean.Order;
import com.jqlmh.jdbc1.lmh3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;


public class PreparedStatementQuery {

    // 测试通用查询方法,返回一条记录
    @Test
    public void testpreparedStatementQuery() {
        String sql = "select id,name,email,birth from customers where id=?"; // 关键字
        Customers customers = preparedStatementQuery(Customers.class, sql, 1);
        System.out.println(customers);

        String sql1 = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id=?"; // order是关键字,注意加着重号
        Order order = preparedStatementQuery(Order.class, sql1, 1);
        System.out.println(order);
    }

    // 测试通用查询方法,返回多条记录
    @Test
    public void testpreparedStatementQueryLis() {
        String sql = "select id,name,email,birth from customers where id<?";
        List<Customers> list = preparedStatementQueryList(Customers.class, sql, 12);
        list.forEach(System.out::println);

        String sql1 = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id<?"; // 关键字
        List<Order> list2 = preparedStatementQueryList(Order.class, sql1, 4);
        list2.forEach(System.out::println);
    }

    // 用PreparedStatement实现针对不同表的通用的查询操作,返回多条记录
    public <T> List<T> preparedStatementQueryList(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ;
        ResultSet rs = null;
        ;
        try {
            // 1.获取连接
            conn = JDBCUtils.getConnection();
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
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    // 使用PreparedStatement实现针对不同表的通用的查询操作,返回一条记录
    public <T> T preparedStatementQuery(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ;
        ResultSet rs = null;
        ;
        try {
            // 1.获取连接
            conn = JDBCUtils.getConnection();
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

            // 7.查询下一行是否有数据,如果有数据就创建一个t对象用于保存数据(多行就用while)
            if (rs.next()) {

                T t = clazz.newInstance();

                // 循环条件为列数
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
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

}
