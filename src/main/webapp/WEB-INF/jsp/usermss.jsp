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
        <a href="/user/add">添加用户</a>

        <thead>
            <th>id</th>
            <th>username</th>a
            <th>password</th>
            <th>email</th>
            <th>phone</th>
            <th>question</th>
            <th>answer</th>
            <th>role</th>
            <th>createtime</th>
            <th>updatetime</th>
        </thead>
        <c:forEach items="${userInfolist}" var="user">

            <tr>
                <th>${user.id}</th>
                <th>${user.username}</th>
                <th>${user.password}</th>
                <th>${user.email}</th>
                <th>${user.phone}</th>
                <th>${user.question}</th>
                <th>${user.answer}</th>
                <th>${user.role}</th>
                <th>${user.createTime}</th>
                <th>${user.updateTime}</th>
                <th>
                    <a href="/user/update/${user.id}">修改</a>
                    <a href="/user/find/${user.id}">删除</a>
                </th>
            </tr>
        </c:forEach>


    </table>




</head>
<body>

</body>
</html>
