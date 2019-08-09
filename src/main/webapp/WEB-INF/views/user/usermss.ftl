<html>
<#include  "common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
    <#include "common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>username</th>
                            <th>password</th>
                            <th>email</th>
                            <th>phone</th>
                            <th>question</th>
                            <th>answer</th>
                            <th>role</th>
                            <th>createtime</th>
                            <th>updatetime</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list userInfolist as user>
                        <tr>
                            <th>${user.id}</th>
                            <th>${user.username}</th>
                            <th>${user.password}</th>
                            <th>${user.email}</th>
                            <th>${user.phone}</th>
                            <th>${user.question}</th>
                            <th>${user.answer}</th>
                            <th>${user.role}</th>
                            <th>${user.createTime?string('yyyy-MM-dd HH:mm:ss')}</th>
                            <th>${user.updateTime?string('yyyy-MM-dd HH:mm:ss')}</th>
                            <td><a href="/user/add/${user.id}">修改</a>
                            <a href="/user/find/${user.id}">删除</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>