<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--内置对象--%>
<%
    pageContext.setAttribute("name1", "橙子1号");//保存的值在在一个页面中有效
    request.setAttribute("name2", "橙子2号");//保存的值在一次请求中有效
    session.setAttribute("name3", "橙子3号");//保存的值在一次会话中有效
    application.setAttribute("name4", "橙子4号");//保存的值在服务器中有效
%>

<%
    //通过pageContext取值，我们通过寻找的方式
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5");
%>

<%--使用el表达式输出--%>
<h1>取出的值：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
<h3><%= name5 %></h3>

</body>
</html>
