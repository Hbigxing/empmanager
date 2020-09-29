<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加商品</title>
    <style>
        table{
            margin: auto;
            text-align: center;
            border-collapse: collapse;
        }
        table,th,td{
            border:1px solid black;
        }
    </style>
</head>
<body>
   <table>
       <tr>
           <th>编号</th>
           <th>名称</th>
           <th>图片</th>
           <th>价格</th>
       </tr>
       <c:forEach items="${all}" var="g">
           <tr>
               <td>${g.id}</td>
               <td>${g.name}</td>
               <td><img srrc="<%=application.getContextPath()%>/${g.image}" width="200"></td>
               <td>${g.price}</td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>
