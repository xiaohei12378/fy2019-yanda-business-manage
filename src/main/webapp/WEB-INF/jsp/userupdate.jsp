<%--
  Created by IntelliJ IDEA.
  User: Neuedu
  Date: 2019/7/26
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>修改用户信息</title>
  </head>
  <h1>修改类别</h1>
  <form action="" method="post">

    <input type="hidden" name="id" value="${userinfo.id}"></br>
    用户名称<input type="text" name="username" value="${userinfo.username}"></br>
    用户密码<input type="text" name="password" value="${userinfo.password}"></br>
    邮箱<input type="text" name="email" value="${userinfo.email}"></br>
    电话<input type="text" name="phone" value="${userinfo.phone}"></br>
    问题<input type="text" name="question" value="${userinfo.question}"></br>
    答案<input type="text" name="answer" value="${userinfo.answer}"></br>
    权限<input type="text" name="role" value="${userinfo.role}"></br>
    <input type="submit" value="修改"></br>
  </form>






  </body>
</html>


