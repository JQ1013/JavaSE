package com.jqlmh.jdbc1.lmh3.preparedstatement;

import com.jqlmh.jdbc1.lmh3.bean.Order;
import com.jqlmh.jdbc1.lmh3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


/**
 * 针对order表的通用的查询操作
 *
 * @author LMH
 * @Description
 * @date 2019年10月15日下午2:44:54
 */
public class OrderForQuery {

    /*
     * 针对表的字段名和类的属性名不相同的情况:
     * 1.必须声明sql时,使用类的属性名作为字段的别名;
     * 2.使用ResultSetMetaData时,需要使用getColumnLabel()来替换getColumnName(),来获取列的别名;
     * 	说明:如果sql语句中没有给字段取别名,getColumnLabel()获取的就是列名;
     *
     */
    @Test
    public void testQueryForOrder() {
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id=?"; //关键字
        Order order = queryForOrder(sql, 1);
        System.out.println(order);

    }


    /**
     * @param sql
     * @param args
     * @return
     * @Description 针对order表的通用的查询操作
     * @author LMH
     * @date 2019年10月15日下午3:35:18
     */
    public Order queryForOrder(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ;
        ResultSet rs = null;
        ;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句,获取PreparedStatement实例
            ps = conn.prepareStatement(sql);

            //3.填充占位符,根据参数的长度来填充
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            //4.执行查询,返回结果集
            rs = ps.executeQuery();

            //5.获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();

            //6.获取结果集的列数
            int columnCount = rsmd.getColumnCount();

            //7.查询下一行是否有数据,如果有数据就创建一个Order对象用于保存数据(多行就用while)
            if (rs.next()) {

                Order order = new Order();

                //循环条件为列数
                for (int i = 0; i < columnCount; i++) {
                    //8.通过ResultSetMetaData
                    //获取每列的列名:getColumnName()
                    //获取列的别名:getColumnLabel()
                    //String columnName = rsmd.getColumnName(i+1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //获取每列的列值:通过ResultSet
                    Object columnValue = rs.getObject(i + 1);

                    //9.将数据封装在Order对象中,使用反射:将对象名为columnLabel的属性赋值为指定的值columnValue
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order, columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
}
