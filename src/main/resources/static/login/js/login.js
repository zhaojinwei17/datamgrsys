layui.form.on('submit(login)', function(data){
    var json=data.field;
    if(json.name===""){
        layer.msg("用户名为空！", {icon: 5});
        return false;
    }
    if(json.password===""){
        layer.msg("密码为空！", {icon: 5});
        return false;
    }
    $.ajax({
        url: ctx+"login/login",
        type : "post",
        data: json,
        success:function(result){
            if(result.status===200){
                layer.msg('成功！', {icon: 6});
                window.location.href=ctx+"home/page/home.html";
            }else {
                layer.msg(result.msg, {icon: 5});
            }
        },
        error : function (result) {
            layer.msg('失败！', {icon: 5});
        }
    });
    return false;
});