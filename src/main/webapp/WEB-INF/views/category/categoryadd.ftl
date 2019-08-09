
<html>
<#include  "common/header.ftl">
  <body>
  <div id="wrapper" class="toggled">

  <#--边栏sidebar-->
    <#include "common/nav.ftl">

 <form action="" method="post">

    <#-- <span>ID</span>
     <input type="hidden" name="id"/>
     <br/>-->
     <span>父类ID</span>
     <input type="text" name="parentId"/>
     <br/>
     <span>类别名称</span>
     <input type="text" name="name"/>
     <br/>
     <span>类别状态</span>
     <input type="text" name="status"/>
     <br/>
     <input type="submit" value="操作"/>


 </form>

  </body>
</html>
