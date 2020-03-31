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
<%--    bootstrap--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>登陆</title>
    <!--表单的样式-->
    <link href="${APP_PATH}/css/register.css" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="${APP_PATH}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<%--    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>--%>
    <script src="${APP_PATH}/webjars/jquery/3.3.1-2/jquery.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<%--    背景--%>
    <link rel="stylesheet" media="screen" href="${APP_PATH}/css/background.css">
<%--    导航--%>
<%--    <link rel="stylesheet" href="${APP_PATH}/css/toolbar.css">--%>
<%--    SWEETALERT--%>

    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/sweetalert.css">
    <script src="${APP_PATH}/js/sweetalert.min.js"></script>

</head>
<body>


<div id="particles-js">
<%--        <jsp:include page="${APP_PATH}/common/navbar.jsp"/>--%>
    <div class="resgister">
        <form class="form-signin" id="addUser" action="${APP_PATH}/doRegister" method="post">
                <h2 class="form-signin-heading">Sign in</h2>
<%--                <label for="inputEmail" class="sr-only">Email address</label>--%>
                <div class="form-group">
                    <input type="email" id="userEmail" name="userEmail" class="form-control" placeholder="Email " required autofocus>
                </div>
<%--                <label for="inputPassword" class="sr-only">Password</label>--%>
                <div class="form-group">
                    <input type="password" id="userPassword" name="userPassword" class="form-control" placeholder="Password：6~12位字母或数字" required>
                </div>
<%--                <div class="form-group">--%>
<%--                    <div class="checkbox">--%>
<%--                        <label>--%>
<%--                            <input type="checkbox" value="remember-me"> Remember me--%>
<%--                        </label>--%>
<%--                    </div>--%>
<%--                </div>--%>

        </form>

        <button class="btn btn-lg btn-primary btn-block form-signin" id="registerBtn" style="width: 300px">commit</button>

    </div>
<%--        </div>--%>
    </div>
<%@include file="/common/navbar.jsp"%>
</body>

<script src="${APP_PATH}/js/particles.js"></script>
<script src="${APP_PATH}/js/app.js"></script>

<script src="${APP_PATH}/js/register.js"></script>

</html>