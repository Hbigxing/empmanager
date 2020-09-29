<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/25
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/js/jquery-1.12.4.js"></script>
    <script>
        var user={"id":"1","username":"张三","password":"000"};
        var arr=["中国","美国","俄罗斯"];
        var users=[
            {"id":"1001","username":"张三","password":"aaa"},
            {"id":"1002","username":"李四","password":"123"},
            {"id":"1003","username":"王五","password":"abc"}
        ];
        $(function () {
            $("#id").text(user.id);
            $("#username").text(user.username);
            $("#password").text(user.password);
            $.each(arr,function (index,obj) {
                $("#myul").append("<li>"+obj+"</li>");
                $("#myselect").append("<option value='"+obj+"'>"+obj+"</option>");

            });
            $.each(users,function (index,obj) {
                $("#myTb").append("<tr>"+
                "<td>"+obj.id+"</td>"+
                "<td>"+obj.username+"</td>"+
                "<td>"+obj.password+"</td>"+
                "</tr>");
            })
        })
    </script>
    <style>
        table{
            width: 300px;
            boder-collapse:collapse;
            text-align: center;
        }
        table,td,th{
            boder:1px solid black;
        }
    </style>
</head>
<body>
    一、json对象输出<br>
    ID:<span id="id"></span><br>
    用户名：<span id="username"></span><br>
    密码：<span id="password"></span><br>
    二、json对象输出
    <select id="myselect"></select><br>
    <br>
    <ul id="myul">

    </ul>
    三、输出json对象的user数组对象<br>
    <table id="myTb">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
        </tr>
    </table>

</body>
</html>
