<%--
  Created by IntelliJ IDEA.
  User: chengcheng
  Date: 2020/8/21
  Time: 10:32 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%-- jsp表达式
    作用：用来程序的输出，输出到客户端
    <%= 变量表达式 %>
   --%>
  <%= new java.util.Date() %>

  <hr>

  <%
    int sum = 0;
    for (int i = 0; i < 100; i++) {
      sum += i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
  %>

  <%!
    static {
      System.out.println("Loading Servlet");
    }

    private int globalVar = 0;

    public void kuang() {
      System.out.println("进入了kuang");
    }
  %>

  </body>
</html>
