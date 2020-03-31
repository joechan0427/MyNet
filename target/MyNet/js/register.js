function send(){
    var user = $("#addUser").serialize();

    $.ajax({
        url: "doRegister",
        cache: false,
        type: "post",
        async: false,
        dataType: "text",
        data: user,
        success: function (responseText) {
            if (responseText === "success") {
                swal("哎呦成功了", "邮箱注册","success");
            }else {
                swal("哎呦出错了", "请重新注册","error");
            }
        },
        error: function (responseText) {
            swal("哎呦出错了", "请重新注册","error");
        }
    })
}



$("#registerBtn").click(function check(){

    // alert("ok")

    var $email = $("#userEmail").val();
    var $password = $("#userPassword").val();
    var $userName = $("#userNickname").val();

    var regEmail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    var regPassword = /^[A-Za-z0-9]{6,12}$/;
    var regUserName = /^[a-zA-Z0-9_-]{4,16}$/;
    // if (!regUserName.test($userName)) {
    //     swal("哎呦出错了", "用户名输入有误","error");
    //     return false;
    // }
    if (!regEmail.test($email)) {
        swal("哎呦出错了", "邮箱输入有误","error");
        return false;
    }
    if (!regPassword.test($password)) {
        swal("哎呦出错了", "密码输入有误","error");
        return false;
    }
    // alert($email);
    $.ajax({
        url: "validateEmail",
        cache: false,
        type: "post",
        async: false,
        dataType: "text",
        data: {
            "userEmail": $email
        },
        success: function (responseText) {
            // alert(responseText+"success");
            // return false;
            if (responseText === "noEmail") {
                // alert("");
                send();
                return false;
                // validator.defaultSubmit();
            } else {
                swal("哎呦出错了", "您的邮箱已注册过了","error");

                // alert("");
                return true;
            }
        },
        error: function (responseText) {
            // alert(responseText);
            sweetAlert("哎呦出错了", "系统出错!","error");
            return false;
        }
    });
    // return false;
});