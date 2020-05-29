package com.jqlmh.jdbc1.lmh3.preparedstatement;

import com.jqlmh.jdbc1.lmh3.util.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;


/*
 * 使用PreparedStatement来替换Statement,实现对数据表的增删改操作
 *
 * 增删改、查
 *
 */

public class PrepardStatementTest {

    // 通用的增删改操作
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
            System.out.println("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // 3.测试通用的增删改操作
    @Test
    public void TestMethod() throws Exception {
        // 1.增加一条记录
//		String sql = "insert into customers(name,email,birth) values(?,?,?)";
//		String name = "小卢";
//		String email = "520@qq.com";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date date = sdf.parse("1995-08-26");
//		Date birth = new java.sql.Date(date.getTime());
//		insertDeleteUpdate(sql, name, email, birth);

        // 2.修改一条记录
        //String sql1 = "update order set order_name=? where order_id=?"; //报错,order是sql关键字,会引起歧义,所以加着重号.
//		String sql1 = "update `order` set order_name=? where order_id=?";
//		insertDeleteUpdate(sql1, "DD",2);

        //3.删除一条记录
        String sql2 = "delete from customers where id=?";
        insertDeleteUpdate(sql2, 20);
    }

    // 2.修改customers表的一条记录
    @Test
    public void testUpdate() throws Exception {
        // 1.获取数据库连接
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句,返回PreparedStatement实例
            String sql = "update customers set name=? where id=?";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            ps.setString(1, "姜总");
            ps.setInt(2, 19);
            // 4.执行
            ps.execute();
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // 1.向customers表中添加一条记录
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
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
            conn = DriverManager.getConnection(url, user, password);
            // 4.预编译sql语句,返回PreparedSratement实例
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            // 5.填充占位符
            ps.setString(1, "小姜");
            ps.setString(2, "1314@126.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1996-10-13");
            ps.setDate(3, new Date(date.getTime()));
            // 6.执行
            ps.execute();
            System.out.println("添加成功");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
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
    }
}
