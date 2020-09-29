<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/25
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有部门信息</title>
    <script src="<%=application.getContextPath()%>/js/jquery-1.12.4.js"></script>
    <style>
        table{
            width: 400px;
            boder-collapse:collapse;
            text-align: center;
        }
        table,td,th{
            boder:1px solid black;
        }
        #name{margin-left: 30px}
    </style>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"<%=application.getContextPath()%>/DeptServlet?op=like",
                    type:"post",
                    data:{
                        "name":$("#name").val()
                    },
                    success:function (data) {
                        var arr=JSON.parse(data);

                        var tr=$("#myTb").find("tr").first();

                        $("#myTb").empty();
                        $("#myTb").append(tr);
                        $.each(arr,function (index,obj) {
                            $("#myTb").append("<tr>"+
                            "<td>"+obj.deptno+"</td>"+
                            "<td>"+obj.dname+"</td>"+
                            "<td>"+obj.loc+"</td>"+
                            "<td><button>编辑</button><button>删除</button></td>"+
                            "</tr>");
                        })
                    },
                    error:function () {
                        alert("数据获取失败！")
                    }
                });
            });
        })
    </script>
</head>
<body>
<input type="text" id="name" placeholder="输入关键字">
<button id="btn">显示</button>
<table id="myTb">
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
</table>
</body>
</html>
