layui.form.on('submit(search)', function(data){
    renderTable(data.field);
    return false;
});

var Data={
    dataTabData:[]
    ,detailTabData:[]
    ,uploadIndex:""
    ,dataid:""

}

renderTable=function(data){
    $.ajax({
        url: ctx+"data/detail",
        type : "post",
        data: data,
        success:function(result){
            Data.dataTabData=result.data;
            //展示已知数据
            layui.table.render({
                elem: '#dataTab'
                , cols: [[ //标题栏
                    {field: 'groupname', title: '小组名', width: '15%', sort: true}
                    , {field: 'dataname', title: '资料名', width: '15%',templet: '#datanameTpl'}
                    , {field: 'ip', title: 'IP', width: '15%',sort: true}
                    , {field: 'uploadmen', title: '上传人', width: '15%'}
                    , {field: 'createtime', title: '创建时间', width: '15%',sort: true}
                    , {field: 'times', title: '浏览数', width: '15%',sort: true}
                    ,{fixed: 'right', title:'操作', toolbar: '#deldatabar', width: '10%'}
                ]]
                , data: Data.dataTabData
                ,page: true
                ,text: {
                    none: '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
                }
            })
            layui.table.on('tool(dataTab)', function(obj){
                var data = obj.data;
                //console.log(obj)
                if(obj.event === 'del'){
                    layer.confirm('真的删除行么', function(index){
                        debugger
                        $.ajax({
                            url: ctx+"data/deldata",
                            type : "post",
                            data: {id:data.id},
                            success:function(result){
                                obj.del();
                                layer.close(index);
                            }
                        });
                    });
                }
            });
        },
        error : function (result) {
            layer.msg('失败！', {icon: 5});
        }
    });
}

openUpload=function(){
    Data.uploadIndex=layer.open({
        type: 2,
        title: '上传资料',
        shadeClose: true,
        shade: false,
        maxmin: true, //开启最大化最小化按钮
        area: ['1000px', '600px'],
        content: ctx+'home/upload/upload.html'
    });
}

openDetail=function(){
    Data.uploadIndex=layer.open({
        type: 2,
        title: '资料明细',
        shadeClose: true,
        shade: false,
        maxmin: true, //开启最大化最小化按钮
        area: ['1000px', '600px'],
        content: ctx+'home/detail/detail.html'
    });
}
$(function () {
    $("#uploadBtn").click(openUpload);
    renderTable();
    hideDesc()
})
lookdetail=function(a){
    var dataid=$(a).attr("dataid");
    $.each( Data.dataTabData, function( key, val ) {
        if((val.id+"")===dataid){
            $("#desc").val(val.memo);
            return
        }
    } );
    showDesc()
    renderDetailTable(dataid);
}
renderDetailTable=function(dataid){
    $.ajax({
        url: ctx+"data/getenclosure",
        type : "post",
        data: {dataid:dataid},
        success:function(result){
            if(result.status===200){
                Data.detailTabData=result.data
                layui.table.render({
                    elem: '#detailTab'
                    , cols: [[ //标题栏
                        {field: 'dataid', title: '资料id', width: '25%'}
                        , {field: 'filename', title: '文件名', width: '25%',templet: '#filenameTpl'}
                        , {field: 'filesize', title: '文件大小', width: '25%'}
                        , {field: 'uploadtime', title: '上传时间', width: '25%',sort: true}
                    ]]
                    , data: Data.detailTabData
                    ,page: true
                    ,text: {
                        none: '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
                    }
                })
                return
            }
            layer.msg('失败！', {icon: 5});
        },
        error : function (result) {
            layer.msg('失败！', {icon: 5});
        }
    });
}
hideDesc=function () {
    $(".detail").hide();
}
showDesc=function () {
    $(".detail").show();
}
