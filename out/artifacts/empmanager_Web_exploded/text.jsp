<%@ page import="com.tjetc.empmanager.dao.EmpDao" %>
<%@ page import="com.tjetc.empmanager.dao.impl.EmpDaoImpl" %>
<%@ page import="com.tjetc.empmanager.domain.Emp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        EmpDao dao=new EmpDaoImpl();
        Emp emp=dao.selectById(7788);
        request.setAttribute("emp",emp);
    %>
</head>
<body>
<c:set var="account" value="tivon" scope="request" />
${requestScope.account}
<br>
修改之前：${emp}<br>
<c:set target="${emp}" property="ename" value="大兴" />
修改之后：${emp}<br>
<p><c:out escapeXml="false" value="</p>
<p>${"<a href='http://www.baidu.com'>百度</a>"}</p>
<p><c:out value="<a href='http://www.baidu.com'>百度</a>"></c:out></p>
</body>
</html>
