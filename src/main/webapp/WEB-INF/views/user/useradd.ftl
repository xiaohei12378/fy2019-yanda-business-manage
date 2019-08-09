
<html>
<#include  "common/header.ftl">
  <body>
  <div id="wrapper" class="toggled">

  <#--边栏sidebar-->
    <#include "common/nav.ftl">

 <form action="" method="post">

   <span>用户名:</span>
   <input type="text" name="username"/>
   <br/>
   <span>密码:</span>
   <input type="password" name="password"/>
   <br/>

   <span>邮箱:</span>
   <input type="text" name="email"/>
   <br/>
   <span>电话</span>
   <input type="text" name="phone"/>
   <br/>
     <span>密保问题:</span>
     <input type="text" name="question"/>
     <br/>
     <span>密保答案:</span>
     <input type="text" name="answer"/>
     <br/>
   <span>权限</span>
   <input type="text" name="role"/>
   <br/>

   <input type="submit" value="操作"/>

 </form>

  </body>
</html>
