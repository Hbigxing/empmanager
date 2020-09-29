<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/21
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/js/jquery-1.12.4.js"></script>
    <script>
        $(function () {
            $("#deptno").blur(function () {
                $.ajax({
                    url:"<%=application.getContextPath()%>/DeptServlet?op=ajax",
                    type:"post",
                    data:{
                        "deptno":$("#deptno").val()
                    },
                    success:function (data) {
                        console.log(data);
                        if(data=="1"){
                            $("#showDeptno").text("对不起，该名称重复").css("color","red");
                        }else{
                            $("#showDeptno").text("可用名称").css("color","green");
                        }
                    },
                    erroro:function (e) {
                        alert(e);
                    }
                });
            });
            $("#dname").blur(function () {
                $.ajax({
                    url:"<%=application.getContextPath()%>/DeptServlet?op=ajax",
                    type:"post",
                    data:{
                        "dname":$("#dname").val()
                    },
                    success:function (data) {
                        console.log(data);
                        if(data=="1"){
                            $("#showDname").text("对不起，该部门重复").css("color","red");
                        }else{
                            $("#showDname").text("可用部门").css("color","green");
                        }
                    },
                    erroro:function (e) {
                        alert(e);
                    }
                });
            });
        })
    </script>
</head>
<body>
<%@include file="header.jsp"%>
<form action="<%=application.getContextPath()%>/DeptServlet?op=addDept" method="post">
    <input type="text" name="deptno" id="deptno" placeholder="部门号" /><span id="showDeptno"></span> <br />
    <input type="text" name="dname" id="dname" placeholder="部门名" /><span id="showDname"></span> <br />
    <input type="text" name="loc" placeholder="部门地点" /><br />
    <input type="submit" value="注册" />
</form>
</body>
</html>
