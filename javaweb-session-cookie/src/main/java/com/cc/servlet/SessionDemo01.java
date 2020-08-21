package com.cc.servlet;

import com.cc.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到session
        HttpSession session = req.getSession();
        session.setAttribute("name",new Person("程成",20));

        //获取session的ID
        String id = session.getId();

        //判断是否是新的session
        if (session.isNew()) {
            resp.getWriter().write("session创建成功,ID"+id);
        } else {
            resp.getWriter().write("session已经在服务器中存在了,ID"+id);
        }
    }
}
