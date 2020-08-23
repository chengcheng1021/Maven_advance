package com.cc.test;

import java.sql.*;

public class TestJdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/DB01?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123";

        //1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、连接数据库，代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //3、向数据库发送SQL的对象Statement
        Statement statement = connection.createStatement();

        //4、编写mysql
        String sql = "select * from dept";

        //5、执行查询sql，返回一个ResultSet
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("id="+resultSet.getObject("deptno"));
            System.out.println("dname="+resultSet.getObject("dname"));
        }

        //6、关闭连接，先创建后关闭
        resultSet.close();
        statement.close();
        connection.close();
    }
}
