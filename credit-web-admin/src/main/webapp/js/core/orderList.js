$(function() {
    $("#grid-data").bootgrid({
        post: getParams,
        url: basePath + "/core/orderList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but="";
                but += "<button class=\"btn btn-sm btn-primary\" onclick=\"showDetail("+row.id+");\">详情</button>";
                but += " <button class=\"btn btn-sm btn-primary\" onclick=\"del("+row.id+");\">删除</button>";
                return but;
            },
            "createTime": function(column, row)
            {
                var str="";
                if(row.createTime!=null) {
                    str = moment(row.createTime).format('YYYY-MM-DD hh:mm:ss');
                }
                return str;
            },
            "status": function(column, row)
            {
                var str;
                if (row.status == 0) {
                    str = "取消";
                } else if(row.status == 1){
                    str = "待确认";
                } else if(row.status == 2){
                    str = "反馈中";
                } else if(row.status == 3){
                    str = "制作中";
                }else if(row.status == 4){
                    str = "完成";
                }
                return str;
            },
            "source": function(column, row)
            {
                var str;
                if (row.source == 1) {
                    str = "全球鹰";
                } else if(row.source == 2){
                    str = "全搜";
                } else if(row.source == 3){
                    str = "估估";
                } else if(row.source == 4){
                    str = "CPM";
                }
                return str;
            },
            "hasPay": function(column, row)
            {
                var str;
                if (row.hasPay == false) {
                    str = "未支付";
                } else if(row.hasPay ==true) {
                    str = "已支付";
                }
                return str;
            },
        }
    });
});
function showDetail(id){
    //清除数据
    $("#detailGrid").bootgrid("destroy");
    $("#detailGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getOrderDetailParams(id),
        url: basePath + "/core/orderDetailList.do",
        formatters: {
            "expectTime": function(column, row)
            {
                var str="";
                if(row.expectTime!=null) {
                    var str = moment(row.expectTime).format('YYYY-MM-DD HH:mm:ss');
                }
                return str;
            },
            "isExpress": function(column, row)
            {
                var str;
                if (row.isExpress == false) {
                    str = "否";
                } else if(row.isExpress == true){
                    str = "是";
                }
                return str;
            }
        }
    });
    $('#detailModal').modal('show');
    $("#detailGrid").bootgrid("reload");
}

function del(id){
    BootstrapDialog.show({
        title:'删除框',
        message:'是否确认删除',
        buttons: [{
            label: '确定',
            action: function(dialog) {
                dialog.close();
                $.ajax({
                    method: "POST",
                    url:basePath+"/core/delOrder.do",
                    cache:false,
                    dataType : 'json',
                    data:{
                        'id':id
                    },
                    success : function(data) {
                            BootstrapDialog.alert(data.msg);
                            $('#grid-data').bootgrid("reload");
                    }
                });
            }
        }, {
            label: '取消',
            action: function(dialog) {
                dialog.close();
            }
        }]
    })
};

function getParams(){
    return {
        no: $("#no").val(),
        customerEmail:$("#customerEmail").val(),
        hasPay:$("#hasPay").val(),
        status:$("#status").val()
        // orderStatusId:$("#orderStatusId").val()
    }
}

function getOrderDetailParams(id){
    return {
        orderId:id
    }
}

function query(){
    $("#grid-data").bootgrid("reload");
}
function upload(id){
    $('#id').val(id);
    $('#myModal').modal('show');
}
function ajaxFileUpload(){
    //开始上传文件时显示一个图片,文件上传完成将图片隐藏
    //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});
    //执行上传文件操作的函数，使用encodeURI方法，防止传输中文字符的时候出现乱码
    var uploadUrl = encodeURI(encodeURI(basePath + "manager/upload.do?id="+$('#id').val()));
    $.ajaxFileUpload({
        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
        url:uploadUrl,
        secureuri:false,                       //是否启用安全提交,默认为false
        fileElementId:'file',           //文件选择框的id属性
        dataType:'text',                       //服务器返回的格式,可以是json或xml等
        success:function(data, status){       //服务器响应成功时的处理函数

            data = data.replace("<PRE>", '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre>text</pre>前后缀
            data = data.replace("</PRE>", '');
            data = data.replace("<pre>", '');
            data = data.replace("</pre>", ''); //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]
            //将String字符串转换成json
            var dataset = $.parseJSON(data);
            if(dataset.status == "OK"){
                $('#result').html("上传成功");
                BootstrapDialog.alert("上传成功");
                $('#myModal').modal('hide');
            }else if ( dataset.status == "EMPTY"){
                $('#result').html("没有选择文件！");
                BootstrapDialog.alert("没有选择文件！");
            }else {
                $('#result').html('文件上传失败，请重试！！');
                BootstrapDialog.alert("文件上传失败，请重试！！");
            }
        },
        error:function(data, status, e){ //服务器响应失败时的处理函数
            console.log(e);
            console.log(data);
            BootstrapDialog.alert("文件上传失败，请重试！！");
        }
    });
}