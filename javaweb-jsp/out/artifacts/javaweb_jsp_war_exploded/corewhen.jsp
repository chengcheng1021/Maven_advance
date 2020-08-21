<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="score" value="85"/>

<c:choose>
    <c:when test="${score > 90}">
        你的成绩优秀
    </c:when>
    <c:when test="${score > 80}">
        你的成绩良好
    </c:when>
    <c:when test="${score > 70}">
        你的成绩一般
    </c:when>
    <c:when test="${score <= 60}">
        你的成绩不合格
    </c:when>
</c:choose>

</body>
</html>
