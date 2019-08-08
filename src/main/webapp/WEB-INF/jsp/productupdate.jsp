<%--
  Created by IntelliJ IDEA.
  User: hei
  Date: 2019/8/6
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<h1>修改类别</h1>
<form action="" method="post">

    <input type="hidden" name="id" value="${product.id}"></br>


    ID<input type="text" name="id"/><br>
    categoryId<input type="text" name="categoryId"/><br>
    name<input type="text" name="name"/><br>
    subtitle<input type="text" name="subtitle"/><br>
    detail<input type="text" name="detail"/><br>
    price<input type="text" name="price"/><br>
    stock<input type="text" name="stock"/><br>
    status<input type="text" name="status"/><br>
    <input type="submit" value="修改"></br>

</form>






</body>
</html>
