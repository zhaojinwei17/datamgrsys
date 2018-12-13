var Upload={
    user:""
}

var $ = layui.jquery
    ,upload = layui.upload;
//多文件列表示例
var demoListView = $('#demoList')
    ,uploadListIns = upload.render({
    elem: '#testList'
    ,url: ctx+'data/upload'
    ,accept: 'file'
    ,multiple: true
    ,auto: false
    ,bindAction: '#testListAction'
    ,choose: function(obj){
        var data=jqserialize("form");
        data.uploadmen=Upload.user.id;
        if (data.dataname==="") {
            layer.msg("清填写资料名！", {icon: 5});
            return false;
        }
        if (data.memo==="") {
            layer.msg("清填写资料简介！", {icon: 5});
            return false;
        }
        uploadListIns.config.data=data;
        debugger
        var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
        //读取本地文件
        obj.preview(function(index, file, result){
            debugger
            var tr = $(['<tr id="upload-'+ index +'">'
                ,'<td>'+ file.name +'</td>'
                ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                ,'<td>等待上传</td>'
                ,'<td>'
                ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                ,'</td>'
                ,'</tr>'].join(''));

            //单个重传
            tr.find('.demo-reload').on('click', function(){
                obj.upload(index, file);
            });

            //删除
            tr.find('.demo-delete').on('click', function(){
                delete files[index]; //删除对应的文件
                tr.remove();
                uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
            });
            demoListView.append(tr);
        });
    }
    ,done: function(res, index, upload){
        if(res.status == 200){ //上传成功
            var tr = demoListView.find('tr#upload-'+ index)
                ,tds = tr.children();
            tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
            tds.eq(3).html(''); //清空操作
            return delete this.files[index]; //删除文件队列已经上传成功的文件
        }
        this.error(index, upload);
    }
    ,error: function(index, upload){
        var tr = demoListView.find('tr#upload-'+ index)
            ,tds = tr.children();
        tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
        tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
    }
});

$(function () {
    getuser();
})

getuser=function () {
    $.ajax({
        url: ctx+"login/getuser",
        type : "post",
        success:function(result){
            if(result.status===200){
                Upload.user = result.data;
                $("#uploadmen").val(Upload.user.name);
                $("#groupname").val(Upload.user.groupname);
            }else {
                layer.msg(result.msg, {icon: 5});
            }
        },
        error : function (result) {
            layer.msg('失败！', {icon: 5});
        }
    });
}