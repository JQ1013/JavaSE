package com.jqlmh.jdbc1.lmh1.connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author LMH
 * @date 2020/5/29
 */
public class ConnectionTest {

    /**
     * 方式一
     * // url:http://localhost:8080/gmall/key.jpg
     * // jdbc:协议
     * // mysql:子协议
     * // localhost:ip地址
     * // 3306:端口号
     * // test1:连接数据库名
     */
    @Test
    public void testConnection() throws SQLException {
        // 获取Driver的实现类对象
        Driver driver = new com.mysql.jdbc.Driver();
        getCollection(driver);

    }

    /**
     * @param driver 获取的数据库驱动实例
     * @throws SQLException SQL异常
     */
    private void getCollection(Driver driver) throws SQLException {
        // 2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=utf8";

        // 3.提供用户名和密码,封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "1013");
        // 4.获取数据库连接
        Connection con = driver.connect(url, info);
        System.out.println(con);
    }

    /**
     * 方式二:方式一的改进:在如下的程序中不出现第三方的api,使得程序具有更好的可移植性;
     */
    @Test
    public void testConnection1() throws Exception {
        // 1.获取Driver的实现类对象,使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        getCollection(driver);
    }

    /**
     * 方式三:使用DriverManager替换Driver
     */
    @Test
    public void testConnection2() throws Exception {

        // 1.提供连接需要的三个信息,
        String url = "jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "1013";

        // 2.获取Driver的实现类对象,使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    /**
     * 方式四:在方式三基础上优化,只需要加载驱动,不用显式地注册驱动了
     */
    @Test
    public void testConnection3() throws Exception {

        // 1.提供连接需要的三个信息,
        String url = "jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "1013";

        // 2.获取Driver的实现类对象,使用反射
        Class.forName("com.mysql.jdbc.Driver");
        // Driver driver = (Driver) clazz.newInstance();
        // 注册驱动
        // DriverManager.registerDriver(driver);

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    /**
     * 方式五(最终版):将数据库连接需要的四个基本信息声明在配置文件中,通过读取配置文件的方式,获取连接.
     * 好处:
     * 1.实现了数据与代码的分离,实现了解耦;
     * 2.如果需要修改配置文件信息,可以避免程序重新打包;
     * ----->最终封装为JDBCUtil
     */
    @Test
    public void testConnection4() throws Exception {
        // 1.读取配置文件中个四个信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
        System.out.println(conn);
    }

}
