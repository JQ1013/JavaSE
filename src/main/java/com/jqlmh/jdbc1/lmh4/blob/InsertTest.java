package com.jqlmh.jdbc1.lmh4.blob;

import com.jqlmh.jdbc1.lmh3.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author LMH
 * @Description使用PreparedStatement实现批量数据的操作
 * @date 2019年10月15日下午11:53:57
 */

/*
 * update、delete本生就具有批量操作的效果
 * 此时的批量操作主要是指的批量插入,使用PreparedStatement如何实现更高效的批量插入?
 * 
 * 题目:向goods表插入20000条数据
 *  CREATE TABLE goods(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(25)
   );
   
 *方式一:使用Statement
 *Connection conn=JDBCUtils.getConnection();
 *Statement st=conn.createStatement();
 *for(i=0;i<=20000,i++){
 *	String sql="insert into goods(name) values('name_"+i+"')";
 *	st.execute(sql);
 *}
   
 */
public class InsertTest {

    //批量插入方式二:使用PreparedStatement
    @Test
    public void testInsert1() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();

            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 20000; i++) {
                ps.setObject(1, "name_" + i);
                ps.execute();
            }

            long end = System.currentTimeMillis();
            System.out.println("花费的时间为:" + (end - start));
            //20000:PreparedStatement-batch花费的时间为:18448-420

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }


    /*批量插入方式三:
     * 修改1:使用addbatch(),execteBatch(),clearBatch()
     * 修改2：mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
     * 			?rewriteBatchedStatements=true 写在配置文件的url后面
     * 修改3：使用更新的mysql 驱动：mysql-connector-java-5.1.37-bin.jar
     */

    @Test
    public void testInsert2() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();

            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 10000000; i++) {
                ps.setObject(1, "name_" + i);

                // 1.攒sql
                ps.addBatch();
                if (i % 500 == 0) {
                    // 2.执行batch
                    ps.executeBatch();
                    // 3.清空batch
                    ps.clearBatch();
                }
            }

            long end = System.currentTimeMillis();
            System.out.println("花费的时间为:" + (end - start)); // 20000:batch花费的时间为:420
            // //10000000:花费的时间为:88746

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }


    /*
     *
     *插入方式四(最终版):
     */
    @Test
    public void testInsert3() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();

            // 设置不允许自动提交数据
            conn.setAutoCommit(false);
            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 10000000; i++) {
                ps.setObject(1, "name_" + i);

                // 1.攒sql
                ps.addBatch();
                if (i % 500 == 0) {
                    // 2.执行batch
                    ps.executeBatch();
                    // 3.清空batch
                    ps.clearBatch();
                }
            }
            // 提交数据
            conn.commit();

            long end = System.currentTimeMillis();
            System.out.println("花费的时间为:" + (end - start)); // 10000000:设置不自动提交花费的时间为:70746

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }


}
