package com.cc.test;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc03 {

    @Test
    public static void main(String[] args) throws Exception {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123";

        Connection connection = null;

        try {
            //1、加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、连接数据库，代表数据库
            connection = DriverManager.getConnection(url, username, password);

            //3、通知数据库开启事物
            connection.setAutoCommit(false);

            String sql = "update account set money = money - 100 where id = 1";
            connection.prepareStatement(sql).executeUpdate();

            //制造错误
            //int i = 1/0;

            String sql2 = "update account set money = money + 100 where id = 2";
            connection.prepareStatement(sql2).executeUpdate();

            connection.commit();

            System.out.println("执行成功");
        } catch (ClassNotFoundException e) {
            connection.rollback();
            System.out.println("执行失败");
        }





    }
}
