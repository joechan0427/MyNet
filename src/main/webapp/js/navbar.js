window.onload = function() {
    //点击导航链接之后，把导航选项折叠起来
    $(".form-control,.input-lg,.btn").click(function () {
        $("#menu").collapse('hide');
    });


    $(window).scroll(function () {
        //小屏幕下的导航条折叠
        if ($(window).width() < 768) {
            //滚动屏幕时，把导航选项折叠起来
            $(window).scroll(function () {
                $("#menu").collapse('hide');
            });
        }
    });
};
