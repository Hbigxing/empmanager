<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/25
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/js/jquery-1.12.4.js"></script>
    <script>
        $(function () {
            $("#myForm").submit(function () {
                $.ajax({
                    url:$("#myForm").attr("action"),
                    type:"post",
                    data: {
                        "account": $("#account").val(),
                    },


                })
            })
        })
    </script>
</head>
<body>
<form id="myForm" action="<%=application.getContextPath()%>/username" method="post">
    <input type="text" name="account" id="account" placeholder="请输入账号" >
    <span id="span1"></span>
    <br>
    <input type="submit" value="验证">
</form>
</body>
</html>
