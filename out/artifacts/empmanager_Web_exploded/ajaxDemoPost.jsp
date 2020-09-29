<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/9/25
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax的post请求</title>
    <script>
        var xhr;
        window.onload=function (ev) {
            document.getElementById("btn").onclick=function (ev1) {
                var info=document.getElementById("info").value;
                if(window.XMLHttpRequest){
                   xhr=new XMLHttpRequest();
                }else{
                    xhr=new ActiveXObject("Mirosoft.XMLHTTP");
                }
                xhr.onreadystatechange=callback;
                xhr.open("post","<%=application.getContextPath()%>/ajax",true);
                xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                xhr.send("name=lisi&password=123321&info="+info);
            }
        }
        function callback() {
            if (xhr.readyState==4){
                if (xhr.status==200){
                    var s=xhr.responseText;
                    document.getElementById("myDiv").innerText=s;
                }
            }

        }
    </script>
</head>
<body>
       <input type="text" name="info" id="info" />
       <button id="btn">这是一个按钮</button>

       <div id="myDiv">这是一个div</div>
       <form action="" method="" enctype="application/x-www-form-urlencoded"></form>
</body>
</html>
