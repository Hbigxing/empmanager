<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/21
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示信息</title>
</head>
<body>
<%@include file="header.jsp"%>
<%--获取info信息--%>
<%=request.getAttribute("info")%>
</body>
</html>
