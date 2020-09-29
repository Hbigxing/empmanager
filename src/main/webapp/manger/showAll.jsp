<%@ page import="com.tjetc.empmanager.domain.Dept" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/21
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示全部部门</title>
    <%
        List<Dept> all=(List<Dept>)request.getAttribute("all");
    %>
    <style>
        table{
            margin: auto;
            text-align: center;
            border-collapse: collapse;
        }
        table,tr,td{
            border: 1px solid #000000;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>地址</th>
        <th>操作</th>
    </tr>

    <%
        for (Dept dept : all) {
    %>
    <tr>
        <td><%=dept.getDeptno()%></td>
        <td><%=dept.getDname()%></td>
        <td><%=dept.getLoc()%></td>
        <td>
            <a href="#"><button>删除</button></a>
            <a href="#"><button>修改</button></a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
