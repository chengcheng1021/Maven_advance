package com.cc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class CookieDemo03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //手动删除cookie，设置成0
        Cookie cookie = new Cookie("sex", "nan");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        //中文编码
        Cookie cookie2 = new Cookie("name", URLEncoder.encode("程成","UTF-8"));
        resp.addCookie(cookie2);
    }
}
