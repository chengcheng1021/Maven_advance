package com.cc.servlet;

import com.cc.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin")) {
            System.out.println("成功");
            //登录成功
            req.getSession().setAttribute(Constant.USER_SESSION, req.getSession().getId());
            resp.sendRedirect(req.getContextPath()+"/sys/success.jsp");
        } else {
            System.out.println("失败");
            //登录失败
            resp.sendRedirect(req.getContextPath()+"/sys/error.jsp");
        }
    }
}
