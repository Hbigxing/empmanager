<%@ page import="com.tjetc.empmanager.domain.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="com.tjetc.empmanager.util.DeptFormat" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/22
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有员工信息</title>
    <script src="<%=application.getContextPath()%>/js/jquery-1.12.4.js"></script>
    <%
        List<Emp> all=(List<Emp>)request.getAttribute("all");
    %>
    <style>
        table{
            margin: auto;
            text-align: center;
            border-collapse: collapse;
        }
        table,th,td{
            border: 1px solid black;
        }
    </style>
    <script>
        $(function () {
            $(".delClass").click(function (event) {
                event.preventDefault();
                if (confirm("是否确认删除？")){
                    window.location.href=$(this).attr("href");
                } else{
                    alert("取消删除！")
                }
            });
        });
    </script>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>职位</td>
        <td>领导编号</td>
        <td>入职日期</td>
        <td>薪资</td>
        <td>提出</td>
        <td>部门</td>
    </tr>
    <%
        for(Emp e:all){
            String t= DeptFormat.dateToString(e.getHiredate());
            String comm=e.getComm()!=null?e.getComm()+"":"无提成";

    %>
    <tr>
        <td><%=e.getEmpno()%></td>
        <td><%=e.getEname()%></td>
        <td><%=e.getJob()%></td>
        <td><%=e.getMgr()%></td>
        <td><%=t%></td>
        <td><%=e.getSal()%></td>
        <td><%=comm%></td>
        <td><%=e.getDept().getDeptno()%></td>
        <td>
            <a href="<%=application.getContextPath()%>/emp?op=findById&empno=<%=e.getEmpno()%>"><button>编辑</button></a>
            <a class="delClass" href="<%=application.getContextPath()%>/emp?op=remove&empno=<%=e.getEmpno()%>"><button>删除</button></a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
