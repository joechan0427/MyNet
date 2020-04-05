<%--
  User: Joe
  Date: 2020/3/25
  Time: 17:11
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>注册</title>
    <!--表单的样式-->
    <link href="${APP_PATH}/css/register.css" rel="stylesheet">


<%--    背景--%>
    <link rel="stylesheet" media="screen" href="${APP_PATH}/css/background.css">

<%--    sweetalert--%>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/sweetalert.css">
    <script src="${APP_PATH}/js/sweetalert.min.js"></script>

</head>
<body>


<div id="particles-js">

    <%@include file="/common/navbar.jsp"%>
    <div class="resgister">
        <form class="form-signin" id="addUser" method="post">
                <h2 class="form-signin-heading">Sign in</h2>
<%--                <label for="inputEmail" class="sr-only">Email address</label>--%>
                <div class="form-group">
                    <input type="text" id="Nickname" name="userNickname" class="form-control" placeholder="UserName: 4到16位" required>
                </div>
                <div class="form-group">
                    <input type="email" id="Email" name="userEmail" class="form-control" placeholder="Email：有效Email" required autofocus>
                </div>
<%--                <label for="inputPassword" class="sr-only">Password</label>--%>
                <div class="form-group">
                    <input type="password" id="Password" name="userPassword" class="form-control" placeholder="Password：6~12位字母或数字" required>
                </div>
<%--                <div class="form-group">--%>
<%--                    <div class="checkbox">--%>
<%--                        <label>--%>
<%--                            <input type="checkbox" value="remember-me"> Remember me--%>
<%--                        </label>--%>
<%--                    </div>--%>
<%--                </div>--%>

            <button class="btn btn-lg btn-primary btn-block form-signin " id="registerBtn">commit</button>
        </form>


    </div>

</div>

</body>
<script src="${APP_PATH}/webjars/jquery/3.4.1/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${APP_PATH}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/js/particles.js"></script>
<script src="${APP_PATH}/js/app.js"></script>
<script src="${APP_PATH}/js/register.js"></script>
</html>
