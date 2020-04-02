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


<%--    背景--%>
    <link rel="stylesheet" media="screen" href="${APP_PATH}/css/background.css">

</head>
<body>

    <div id="particles-js">
        <%@include file="/common/navbar.jsp"%>
    </div>



</body>

<script src="${APP_PATH}/js/particles.js"></script>
<script src="${APP_PATH}/js/app.js"></script>

</html>
