layui.form.on('submit(register)', function(data){
    var json=data.field;
    if(json.name===""){
        layer.msg("用户名为空！", {icon: 5});
        return false;
    }
    if(json.password===""){
        layer.msg("密码为空！", {icon: 5});
        return false;
    }
    if(json.classes===""){
        layer.msg("班级为空！", {icon: 5});
        return false;
    }
    if(json.phone===""){
        layer.msg("手机号为空！", {icon: 5});
        return false;
    }
    if(json.groupname===""){
        layer.msg("小组名为空！", {icon: 5});
        return false;
    }

    if(json.re_password!=json.password){
        layer.msg("密码不一致！", {icon: 5});
        return false;
    }
    $.ajax({
        url: ctx+"login/register",
        type : "post",
        data: json,
        success:function(result){
            if(result.status===200){
                layer.msg('成功！', {icon: 6});
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