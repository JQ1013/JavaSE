package com.jqlmh.jdbc1.lmh2.statement;

import com.jqlmh.jdbc1.lmh3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;


/**
 * 除了解决Statement的拼串、sql注入问题外,PreparedStatement还有那些好处?
 * 1.PreparedStatement操作Blob类型的数据,而Statement做不到
 * 2.PreparedStatement可以实现更高效的批量操作;
 * 演示使用PreparedStatement替换Statement,解决sql注入问题
 *
 * @author LMH
 * @date 2019年10月15日下午4:52:53
 */
public class PreparedStatementTest {

    @Test
    public void testLogin() {
        Scanner scan = new Scanner(System.in);

        System.out.print("用户名：");
        String userName = scan.nextLine();
        System.out.print("密   码：");
        String password = scan.nextLine();

        // SELECT user,password FROM user_table WHERE USER = '1' or ' AND PASSWORD = '='1' or '1' = '1';
        String sql = "SELECT user,password FROM user_table WHERE USER=? and password=?";
        User user = preparedStatementQuery(User.class, sql, "AA", "123456");
        if (user != null) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 使用PreparedStatement实现针对不同表的通用的查询操作,返回一条记录
     *
     * @param clazz clazz
     * @param sql   sql
     * @param args  args
     * @param <T>   T
     * @return T
     */
    private <T> T preparedStatementQuery(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
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

            //7.查询下一行是否有数据,如果有数据就创建一个t对象用于保存数据(多行就用while)
            if (rs.next()) {

                T t = clazz.newInstance();

                //循环条件为列数
                for (int i = 0; i < columnCount; i++) {
                    //8.通过ResultSetMetaData
                    //获取每列的列名:getColumnName()
                    //获取列的别名:getColumnLabel()
                    //String columnName = rsmd.getColumnName(i+1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //获取每列的列值:通过ResultSet
                    Object columnValue = rs.getObject(i + 1);

                    //9.将数据封装在t对象中,使用反射:将对象名为columnLabel的属性赋值为指定的值columnValue
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
