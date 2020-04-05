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
    <link rel="stylesheet" href="${APP_PATH}/css/navbar.css">

    <link href="${APP_PATH}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

    <style>

        #vcode-img{
            margin-top: -6px;
            margin-left: -20px;
        }
        @media screen and (max-width: 760px){
            #vcode-img{
                margin-top: 17px;
                margin-left: auto;
            }
        }

    </style>
    <%--sweetalert--%>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/sweetalert.css">
    <script src="${APP_PATH}/js/sweetalert.min.js"></script>
</head>
<body>
<div class="modal fade"  id="userLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog " role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h2 class="modal-title" id="myModalLabel">Login</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="${APP_PATH}/login" id="userForm">

                    <div class="form-group">
                        <label for="userEmail" class="col-md-2 control-label" >Email:</label>
                        <div class="col-sm-7">
                            <input type="email" class="form-control" id="userEmail" name="userEmail" placeholder="Input your Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="userPassword"  class="col-sm-2 control-label">Password:</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Input your password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="captcha" class="col-sm-2 control-label">Captcha:</label>
                        <div class="col-sm-4">
                            <input id="captcha" class="form-control" type="text" name="captcha" placeholder="Input the captcha">
                        </div>
                        <div class="col-sm-4">
                            <img id="vcode-img" src="${APP_PATH}/getGifCode"/>
                        </div>
                    </div>
                    <input type="hidden" id="rememberMe" name="rememberMe" value="true">
<%--                    <button type="submit">submit</button>--%>
<%--                    <div class="checkbox">--%>
<%--                        <label>--%>
<%--                            <input type="checkbox" value="remember-me"> Remember me--%>
<%--                        </label>--%>
<%--                        <iframe id="tmp_downloadhelper_iframe" style="display: none;"></iframe>--%>
<%--                    </div>--%>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" id="btn-login">Login</button>
            </div>
        </div>
    </div>
</div>

<div class="nav-wrapper">
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${APP_PATH}/index.jsp">Brand</a>
            </div>


            <div class="collapse navbar-collapse" id="menu">
                <ul class="nav navbar-nav navbar-right">
                    <li><a class="input-lg" id="login">登陆</a></li>
                    <li><a class="input-lg" href="${APP_PATH}/register" >注册</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>

</body>

<script src="${APP_PATH}/webjars/jquery/3.4.1/dist/jquery.min.js"></script>
<script src="${APP_PATH}/js/navbar.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${APP_PATH}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/js/login.js"></script>
<script>
    $("#vcode-img").click(function () {
        $(this).attr("src", "${APP_PATH}/getGifCode?time="+ new Date().getTime());
    });
</script>
<script>
    $("#btn-login").click(function () {
        var email = $("#userEmail").val();
        var password = $("#userPassword").val();
        var regEmail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        var regPassword = /^[A-Za-z0-9]{6,12}$/;

        if (!regEmail.test(email)) {
            swal("哎呦出错了", "不是合法邮箱","error");
            return false;
        }
        if (!regPassword.test(password)) {
            swal("哎呦出错了", "密码出错","error");
            return false;
        }
        var user = $("#userForm").serialize();
        // alert(user)
        $.ajax({
            url: "${APP_PATH}/login",
            cache: false,
            type: "POST",
            async: false,
            data: user,
            // dataType: "text",
            success: function (response) {
                if (response.message === "登陆成功") {
                    swal("哎呦成功了", "登陆成功","success");
                }else {
                    swal("哎呦出错了", response.message,"error");
                }
            },
            error: function (responseText) {
                swal("哎呦出错了", "系统错误","error");
            }

        });
        return false;
    })
</script>
</html>
