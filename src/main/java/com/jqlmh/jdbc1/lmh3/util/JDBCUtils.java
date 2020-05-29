package com.jqlmh.jdbc1.lmh3.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 操作数据库的工具类
 *
 * @author LMH
 * @Description
 * @date 2019年10月14日下午11:13:06
 */

public class JDBCUtils {
    /**
     * 获取数据库的连接
     *
     * @return
     * @throws Exception
     * @Description
     * @author LMH
     * @date 2019年10月14日下午11:17:36
     */
    public static Connection getConnection() throws Exception {
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
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 关闭数据库连接和Statement操作
     *
     * @param conn
     * @param ps
     * @Description
     * @author LMH
     * @date 2019年10月14日下午11:19:51
     */
    public static void closeResource(Connection conn, Statement ps) {
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

    /**
     * 查询时,关闭数据库连接和Statement操作
     *
     * @param conn
     * @param ps
     * @Description
     * @author LMH
     * @date 2019年10月14日下午11:19:51
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        // 7.资源的关闭
        if (ps != null) {

            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {

            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
