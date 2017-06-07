$(function() {
    $('#orderLevel').val(orderLevel);
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        rowCount:5,
        ajax: true,
        post: getParams,
        url: basePath+"manager/orderList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but="";
                but += "<button class=\"btn btn-sm btn-primary\" onclick=\"showDetail("+row.id+");\">详情</button>";
                but += " <button class=\"btn btn-sm btn-primary\" onclick=\"del("+row.id+");\">删除</button>";

                return but;
            },

            "createDate": function(column, row)
            {
                var str=moment(row.createDate).format('YYYY-MM-DD HH:mm:ss');
                return str;
            },
            "orderStatusId": function(column, row)
            {
                var str;
                if (row.orderStatusId == 1) {
                    str = "支付中";
                } else if(row.orderStatusId == 2){
                    str = "制作中";
                } else if(row.orderStatusId == 3){
                    str = "已送达";
                } else if(row.orderStatusId == 4){
                    str = "已完成";
                }

                return str;
            }
        }
    });
    $("#detailGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getOrderDetailParams,
        url: basePath+"manager/orderDetailList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but;
                if (row.crefoNo==null||row.crefoNo=="") {
                    but = "<table class='operateTable'><tr><td><button class=\"btn btn-sm btn-primary btn-block\" onclick=\"download("+row.id+",'"+row.companyNo+"');\">下载</button></td></tr></table>";
                }else{
                    but = "<table class='operateTable'><tr><td><button class=\"btn btn-sm btn-primary btn-block\" onclick=\"downloadChina("+row.id+",'"+row.crefoNo+"','"+row.createDate+"','"+row.countryId+"');\">下载</button></td></tr></table>";
                }
                //alert();
                return but;
            },
            "createDate": function(column, row)
            {
                var str=moment(row.createDate).format('YYYY-MM-DD HH:mm:ss');
                return str;
            },
            "orderStatusId": function(column, row)
            {
                var str;
                if (row.orderStatusId == 1) {
                    str = "<span class=\"label label-info\">制作中</span>";
                } else if(row.orderStatusId == 2){
                    str = "<span class=\"label label-success\">已完成</span>";
                }

                return str;
            }
            ,
            "orderLevel": function(column, row)
            {

                var str;
                if (row.orderLevel == 1) {
                    str = "数据库报告";
                } else if(row.orderLevel == 2){
                    str = "完整性报告";
                }

                return str;
            }
        }
    });
});
function showDetail(id){
    $("#orderId").val(id);
    $("#detailGrid").bootgrid("reload");
    $('#detailModal').modal('show');
}

function del(id){
    var senddata = {
        id:id
    };
    $.ajax({
        type:"POST",
        url:basePath+"manager/delorder.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            BootstrapDialog.alert(data.msg);
            $('#grid-data').bootgrid("reload");
        }
    });
};

function getParams(){
    return {
        orderNo: $("#orderNo").val(),
        customerName:$("#customerName").val(),
        isPay:$("#isPay").val(),
        orderStatusId:$("#orderStatusId").val()
    }
}

function getOrderDetailParams(){
    return {
        orderId: $("#orderId").val()
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