<%@ page import="java.util.List" %>
<%@ page import="com.tjetc.empmanager.domain.Dept" %>
<%@ page import="com.tjetc.empmanager.domain.Emp" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/22
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工界面</title>
    <%
        List<Dept> deptAll=(List<Dept>)request.getAttribute("deptAll");
        List<Emp> managerAll=(List<Emp>)request.getAttribute("managerAll");
        Emp emp=(Emp)request.getAttribute("emp");
    %>
</head>
<body>
<%@include file="header.jsp"%>
<form action="<%=application.getContextPath()%>/emp?op=updateEmp" method="post">
    <input type="hidden" name="empno" placeholder="编号" value="<%=emp.getEmpno()%>"><br />
    <input type="text" name="ename" placeholder="姓名" value="<%=emp.getEname()%>"/><br />
    职位：
    <select name="job">
        <option value="MANAGER">MANAGER</option>
        <option value="PRESIDENT">PRESIDENT</option>
        <option value="VNALYST">VNALYST</option>
        <option value="CLERK">CLERK</option>
        <option value="SALESMAN">SALESMAN</option>
    </select>
    <br>
    直系领导
    <select name="mgr">
        <%
            for(Emp e:managerAll){
        %>
        <option value="<%=e.getEmpno()%>"
                <%
                    if(e.getEmpno()==emp.getMgr()){
                %>
        selected
                <%
                    }
                %>><%=e.getEname()%></option>
        <%
            }
        %>
    </select>
    <br>
    请选择部门
    <select name="deptno">
        <%
            for(Dept d:deptAll){
        %>
        <option value="<%=d.getDeptno()%>"
                <%
                    if (emp.getDept().getDeptno()==d.getDeptno()){
                %>  selected  <%
        }
                %>
        ><%=d.getDname()%></option>
        <%
            }
        %>
    </select>
    <br>
    <input type="submit" value="添加员工">
</form>
</body>
</html>
