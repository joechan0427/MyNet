<%--
  User: Joe
  Date: 2020/4/1
  Time: 15:28
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
    <!--表单的样式-->
    <link href="${APP_PATH}/css/register.css" rel="stylesheet">
    <title>忘记密码</title>
    <!-- Bootstrap -->
    <link href="${APP_PATH}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <%--    背景--%>
    <link rel="stylesheet" media="screen" href="${APP_PATH}/css/background.css">
<%--sweetalert--%>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/sweetalert.css">
    <script src="${APP_PATH}/js/sweetalert.min.js"></script>
</head>
<body>
    <%@include file="/common/navbar.jsp"%>
    <div id="particles-js">
        <div class="resgister">
            <form class="form-signin" id="updateUser" method="post">
                <h2 class="form-signin-heading">Forget Password</h2>
                <%--                <label for="inputEmail" class="sr-only">Email address</label>--%>
<%--                <div class="form-group">--%>
<%--                    <input type="text" id="Nickname" name="userNickname" class="form-control" placeholder="UserName: 4到16位" required>--%>
<%--                </div>--%>
                <div class="form-group">
                    <input type="email" id="Email" name="userEmail" class="form-control" placeholder="Email" required autofocus>
                </div>
                <%--                <label for="inputPassword" class="sr-only">Password</label>--%>
                <div class="form-group">
                    <input type="password" id="Password" name="userPassword" class="form-control" placeholder="New Password：6~12位字母或数字" required>
                </div>

                <button class="btn btn-lg btn-primary btn-block form-signin " id="forgetBtn">commit</button>
            </form>


        </div>
    </div>



</body>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${APP_PATH}/webjars/jquery/3.4.1/dist/jquery.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${APP_PATH}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/js/particles.js"></script>
<script src="${APP_PATH}/js/app.js"></script>
<%--<script src="${APP_PATH}/js/login.js"></script>--%>
<script>
    function send(){
        var user = $("#updateUser").serialize();

        $.ajax({
            url: "${APP_PATH}/forgetPassword",
            cache: false,
            type: "post",
            async: false,
            dataType: "text",
            data: user,
            success: function (responseText) {
                if (responseText === "success") {
                    swal(
                        {title:"哎呦成功了", text:"请到邮箱完成重置",type:"success"},
                        function () {
                            self.location.href="${APP_PATH}/index.jsp"
                        }
                    );
                } else {
                    swal("哎呦出错了", responseText,"error");
                }
            },
            error: function (responseText) {
                // alert(responseText);
                sweetAlert("哎呦出错了", "系统出错!","error");

            }
        });

    }


    $("#forgetBtn").click(function check(){

        var $email = $("#Email").val();
        var $password = $("#Password").val();

        var regEmail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        var regPassword = /^[A-Za-z0-9]{6,12}$/;

        if (!regEmail.test($email)) {
            swal("哎呦出错了", "邮箱输入有误","error");
            return false;
        }
        if (!regPassword.test($password)) {
            swal("哎呦出错了", "密码输入有误","error");
            return false;
        }

        $.ajax({
            url: "${APP_PATH}/validateEmail",
            cache: false,
            type: "post",
            async: false,
            dataType: "text",
            data: {
                "userEmail": $email
            },
            success: function (responseText) {
                if (responseText === "noEmail") {
                    swal("哎呦出错了", "未注册!","error");
                } else {
                    send();
                }
            },
            error: function (responseText) {
                // alert(responseText);
                sweetAlert("哎呦出错了", "系统出错!","error");

            }
        });
        // alert($email);

        return false;
    });
</script>
</html>
