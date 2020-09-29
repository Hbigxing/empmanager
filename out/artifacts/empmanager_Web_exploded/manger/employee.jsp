<%@ page import="com.tjetc.empmanager.domain.EMPLOYEE" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/23
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
    <script src="js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <style>
        h1{
            text-align: center;
            background: #CB9998;
            color: white;
        }

    </style>
    <%
        List<EMPLOYEE> employeeAll=(List<EMPLOYEE>)request.getAttribute("employeeAll");
        EMPLOYEE employee=(EMPLOYEE)request.getAttribute("employee");
    %>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <%@include file="header.jsp"%>
            <h1>雇员查询系统</h1>
            <form action="<%=application.getContextPath()%>/EMPLOYEEServlet?" method="post">
                雇员姓名：<input type="text" name="EMP_NAME" placeholder="请输入员工姓名"><br>
                公司职位：
                <select>
                    <option value="行政部">行政部</option>
                    <option value="业务部">业务部</option>
                    <option value="集团">集团</option>
                </select>
                <br>
                <input type="submit" value="雇员明细查询">
            </form>
        </div>
    </div>
</div>
</body>
</html>
