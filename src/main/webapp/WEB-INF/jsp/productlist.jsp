<%--
  Created by IntelliJ IDEA.
  User: hei
  Date: 2019/8/6
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>
<head>
    <title>Title</title>
    <table>
        <a href="/user/product/add">添加商品</a>

        <thead>
            <th>id</th>
            <th>categoryId</th>
            <th>name</th>a
            <th>subtitle</th>
            <th>detail</th>
            <th>price</th>
            <th>stock</th>
            <th>status</th>
            <th>createtime</th>
            <th>updatetime</th>
        </thead>
        <c:forEach items="${productlist}" var="product">

            <tr>
                <th>${product.id}</th>
                <th>${product.categoryId}</th>
                <th>${product.name}</th>
                <th>${product.subtitle}</th>
                <th>${product.detail}</th>
                <th>${product.price}</th>
                <th>${product.stock}</th>
                <th>${product.status}</th>
                <th>${product.createTime}</th>
                <th>${product.updateTime}</th>
                <th>
                    <a href="/user/product/update/${product.id}">修改</a>
                    <a href="/user/product/find/${product.id}">删除</a>
                </th>
            </tr>
        </c:forEach>


    </table>




</head>
<body>

</body>
</html>
