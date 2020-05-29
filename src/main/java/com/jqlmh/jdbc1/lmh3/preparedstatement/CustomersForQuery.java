package com.jqlmh.jdbc1.lmh3.preparedstatement;

import com.jqlmh.jdbc1.lmh3.bean.Customers;
import com.jqlmh.jdbc1.lmh3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;


/**
 * 针对于customer表的查询操作
 *
 * @author LMH
 * @Description
 * @date 2019年10月15日下午12:02:18
 */
public class CustomersForQuery {

    //测试查询customers表的通用操作
    @Test
    public void testQueryForCustomers() {
        String sql = "select id,`name`,email,birth from customers where id=?";
        Customers customers = queryForCustomers(sql, 6);
        System.out.println(customers);

    }


    /**
     * 查询customers表的通用操作
     *
     * @param sql
     * @param args
     * @return
     * @Description
     * @author LMH
     * @date 2019年10月15日下午1:51:22
     */
    public Customers queryForCustomers(String sql, Object... args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获取结果集的列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                Customers cust = new Customers();
                // 处理结果集每一行数据中个每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列名
                    String columnName = rsmd.getColumnName(i + 1);
                    // 获取列值
                    Object columnValue = rs.getObject(i + 1);

                    // 给cust对象指定的columnName属性,赋值为columnValue:通过反射
                    Field field = cust.getClass().getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(cust, columnValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }


    /**
     * 查询customers表的一条记录
     *
     * @Description
     * @author LMH
     * @date 2019年10月15日下午12:27:41
     */
    @Test
    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth from customers where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            // 4.执行,返回结果集
            rs = ps.executeQuery();

            // 处理结果集
            // next():判断结果集的下一条是否有数据,如果有返回true,并指针下移.如果返回false,指针不下移
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                Date birth = rs.getDate(4);
                // 方式一:
                // System.out.println("id="+id+",name="+name+",email="+email+",birth=");

                // 方式二:
                // Object[] objects=new Object[]{id,name,email,birth};

                // 方式三:将数据封装为一个对象(推荐)
                Customers customers = new Customers(id, name, email, birth);
                System.out.println(customers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
    }
}
