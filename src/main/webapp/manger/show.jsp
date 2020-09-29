<%@ page import="com.tjetc.empmanager.dao.EmpDao" %>
<%@ page import="com.tjetc.empmanager.dao.impl.EmpDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tjetc.empmanager.domain.Emp" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/23
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        EmpDao dao=new EmpDaoImpl();
        List<Emp> emps=dao.selectAll();
        Map<String,Emp> map=new HashMap<>();
        for(Emp emp:emps){
            map.put(emp.getEname(),emp);
        }
        request.setAttribute("map",map);
    %>
</head>
<body>
<%--${requestScope.all}
${map.JONES}<br>
${map.SCOTT}--%>
${param.account}------
${param.password}-----
${paramValues.hobty[1]}
</body>
</html>
