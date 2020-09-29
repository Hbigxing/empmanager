<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/27
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/js/jquery-1.12.4.js"></script>
    <script>
        $(function () {
            $("#btn1").click(function () {
                $.get("<%=application.getContextPath()%>/jquery",function (data) {
                    alert(data);
                });
            });
            $("#btn2").click(function () {
                $.post("<%=application.getContextPath()%>/jquery",{"account":"admin","password":"123456"},function (data) {
                    alert(data);
                });
            });
            $("#btn3").click(function () {
                $.getJSON("<%=application.getContextPath()%>/jquery",{"account":"admin","password":"123456"},function (data) {
                    $("#myDiv").empty();
                    $.each(data,function (index,obj) {
                        $("#mDiv").append("<p>"+obj.ename+"----"+obj.sal+"</p>");
                    })
                });
            });
            $("#myForm").submit(function () {
                var data=$("#myForm").serializeArray();
                var s=JSON.stringify(data);
                $("#myDiv").empty().text(s);
                $.each(data,function (index,obj) {
                    $("#myDiv").append("<p>"+obj.name+"----"+obj.value+"</p>");
                })
                return false;
            });
        })
    </script>
</head>
<body>
<button id="btn1">按钮1</button>
<button id="btn2">按钮2</button>
<button id="btn3">按钮3</button>
<div id="myDiv"></div>
<form action="#" method="post" id="myForm">
    <input type="text" name="account" placeholder="请输入用户名"><br>
    <input type="password" name="passwprd" placeholder="请输入用密码"><br>
    <input type="datetime-local" name="time" ><br>
    <input type="number" name="num" placeholder="请输入用年龄"><br>
    <input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女">女<br>
    <input type="checkbox" name="honny" value="旅游">旅游
    <input type="checkbox" name="honny" value="旅行">旅行
    <input type="checkbox" name="honny" value="旅途">旅途
    <input type="checkbox" name="honny" value="旅长">旅长<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
