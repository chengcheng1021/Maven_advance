package com.cc.test;

import java.sql.*;

public class TestJdbc02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/DB01?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123";

        //1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、连接数据库，代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //3、编写mysql
        String sql = "insert into dept(deptno,dname,db_source) values (?,?,?)";

        //4、预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,20);
        preparedStatement.setString(2,"cccccc");
        preparedStatement.setString(3,"db05");

        //5、执行查询sql，返回一个ResultSet
        int i = preparedStatement.executeUpdate();

        if (i > 0) {
            System.out.println("插入成功");
        }

        //6、关闭连接，先创建后关闭
        preparedStatement.close();
        connection.close();
    }
}
