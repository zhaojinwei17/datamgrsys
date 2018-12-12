$(function () {
    $("#logout").click(logout);
    getuser();
})

setIframe=function () {
    $("#contentPage").attr("src","../data/data.html")
}

logout=function () {
    $.ajax({
        url:"/mgr/login/logout",
        type : "post",
        success:function(result){
            if(result.status===200){
                layer.msg('成功！', {icon: 6});
                window.location.href="../login.html";
            }else {
                layer.msg(result.msg, {icon: 5});
            }
        },
        error : function (result) {
            layer.msg('失败！', {icon: 5});
        }
    });
}
getuser=function () {
    $.ajax({
        url:"/mgr/login/getuser",
        type : "post",
        success:function(result){
            if(result.status===200){
                debugger
                $("#user").html("<img src=\"../../login/images/user.jpg\" class=\"layui-nav-img\">"+result.data.name)
            }else {
                layer.msg(result.msg, {icon: 5});
            }
        },
        error : function (result) {
            layer.msg('失败！', {icon: 5});
        }
    });
}