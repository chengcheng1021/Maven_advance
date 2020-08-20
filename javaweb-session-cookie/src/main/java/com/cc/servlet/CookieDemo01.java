package com.cc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 保存用户上一次访问的时间
 */
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        //Cookie，服务器端从客户端调取
        Cookie[] cookies = req.getCookies();//数组，可能多个
        //判断cookie是否存在
        if (cookies != null) {
            out.write("您上一次访问的时间是：");

            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("lastLoginTime")) {
                    //获取cookie值
                    long lastLoginTime = Long.parseLong(cookies[i].getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toString());
                }
            }
        } else {
            out.write("这是您第一次访问本站");
        }

        //服务器给客户端发送cookie
        Cookie lastLoginTime = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        lastLoginTime.setMaxAge(24*60*60);
        resp.addCookie(lastLoginTime);
    }
}
