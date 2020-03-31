<%--
  User: Joe
  Date: 2020/3/28
  Time: 17:48
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>navbar</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
</head>
<body>

<div class="modal fade  bs-example-modal-sm"  id="userLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 500px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h2 class="modal-title" id="myModalLabel">Login</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">

                    <div class="form-group">
                        <label for="Useremail" name="email" class="col-sm-2 control-label">Email:</label>
                        <div class="col-sm-7">
                            <input type="email" class="form-control" id="Useremail" placeholder="Input your Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" name="password" class="col-sm-2 control-label">Password:</label>
                        <div class="col-sm-7">
                            <input type="email" class="form-control" id="password" placeholder="Input your password">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Login</button>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <%--            <h1>222222222222222222222222222</h1>--%>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>


        <div class="collapse navbar-collapse" id="menu">
            <ul class="nav navbar-nav navbar-right">
                <li><a class="input-lg" id="login">登陆</a></li>
                <li><a class="input-lg" href="${APP_PATH}/register" >注册</a></li>
            </ul>
        </div>
    </div>
</nav>
<script src="${APP_PATH}/webjars/jquery/3.3.1-2/jquery.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${APP_PATH}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/js/login.js"></script>
</body>
</html>
