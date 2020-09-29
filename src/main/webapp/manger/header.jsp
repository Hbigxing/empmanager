<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object admin=session.getAttribute("admin");
    if(admin==null){
        request.setAttribute("message","请先登录");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
%>
<div style="margin: auto;text-align: center">
    <a href="<%=application.getContextPath()%>/manger/addDept.jsp">添加部门</a>
    <a href="#">查询部门</a>
    <a href="<%=application.getContextPath()%>/DeptServlet?op=findAll">显示全部部门</a>
    <a href="<%=application.getContextPath()%>/EmpServlet?op=addFind">添加员工信息</a>
    <a href="<%=application.getContextPath()%>/EmpServlet?op=findAll">显示所有员工信息</a>
    <a href="<%=application.getContextPath()%>/EMPLOYEEServlet?op=findById">雇员信息查询</a>
    <c:if test="${empty sessionScope.admin}">
        <a href="<%=application.getContextPath()%>/login.jsp"><button>登录</button></a>
    </c:if>
    <c:if test="${!empty sessionScope.admin}">
        ${admin.name}
    </c:if>
    当前访问人数:${applicationScope.num}
</div>
