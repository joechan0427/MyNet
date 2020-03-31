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

    <title>首页</title>
    <!-- Bootstrap -->
    <link href="${APP_PATH}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<%--    背景--%>
    <link rel="stylesheet" media="screen" href="${APP_PATH}/css/background.css">

</head>
<body>

    <div id="particles-js"></div>

    <%@include file="/common/navbar.jsp"%>

</body>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${APP_PATH}/webjars/jquery/3.3.1-2/jquery.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${APP_PATH}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/js/particles.js"></script>
<script src="${APP_PATH}/js/app.js"></script>
<%--<script src="${APP_PATH}/js/login.js"></script>--%>
</html>
