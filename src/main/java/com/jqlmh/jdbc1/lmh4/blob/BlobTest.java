package com.jqlmh.jdbc1.lmh4.blob;

import com.jqlmh.jdbc1.lmh3.bean.Customers;
import com.jqlmh.jdbc1.lmh3.util.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;


/**
 * @author LMH
 * @Description测试使用PreparedStatement操作Blob类型的数据
 * @date 2019年10月15日下午7:01:16
 */
public class BlobTest {

    //查询数据表customers中Blob类型的字段
    @Test
    public void testSelect() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "select id,name,email,birth,photo from customers where id=?";
            ps = conn.prepareStatement(sql);

            ps.setObject(1, 21);

            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");
                Customers customers = new Customers(id, name, email, birth);
                System.out.println(customers);

                //将Blob类型的字段下载下来,以文件的方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream(new File("2.jpg"));
                byte[] buff = new byte[1024];
                int len;
                while ((len = is.read(buff)) != -1) {
                    fos.write(buff, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            JDBCUtils.closeResource(conn, ps, rs);
        }
    }


    // 向数据类customers中插入Blob类型的字段
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream fis = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = " insert into customers(name,email,birth,photo) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);

            fis = new FileInputStream(new File("3.jpg"));
            ps.setObject(1, "smlz");
            ps.setObject(2, "smlz@126.com");
            ps.setObject(3, "1996-10-23");
            ps.setBlob(4, fis);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis == null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            JDBCUtils.closeResource(conn, ps);
        }
    }


}
