var s = 20, t;
var progressArr = new Array();
var g_isChinaOrder;
$(function() {
    $("#orderDetailListLi").addClass("nav-active");
    if(productType == 1)
        $("#orderDetailListLi1").addClass("active");
    else if(productType == 2)
        $("#orderDetailListLi2").addClass("active");
    else
        $("#orderDetailListLi3").addClass("active");
    $("#orderDetailGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath + "/core/orderDetailList.do",
        formatters: {
                "operate": function(column, row)
            {
                var but="";
                but += "<button class=\"btn btn-sm btn-primary\" onclick=\"reget("+row.id+");\">重新获取</button>&nbsp;&nbsp;";
                // if(orderLevel==1){
                but += "<button class=\"btn btn-sm btn-primary\" onclick=\"upload("+row.id+");\">上传报告</button>&nbsp;&nbsp;";
                // }
                but += " <button class=\"btn btn-sm btn-primary\" onclick=\"del("+row.id+");\">删除</button>&nbsp;&nbsp;";
                // if(isCustomOrder!=1){
                // but += "<button class=\"btn btn-sm btn-primary\" onclick=\"download("+row.id+",'"+row.companyNo+"','"+row.orderId+"');\">数据库报告</button>";
                // }
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
            // "status": function(column, row)
            // {
            //     var str;
            //     if (row.status == 0) {
            //         str = "取消";
            //     } else if(row.status == 1){
            //         str = "待确认";
            //     }else if(row.status == 2){
            //         str = "反馈中";
            //     }else if(row.status == 3){
            //         str = "制作中";
            //     }else if(row.status == 4){
            //         str = "完成";
            //     }
            //     return str;
            // },
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
});
function download(id,companyNo,orderId){
    window.open( basePath+'/core/viewReportV1.do?companyId='+companyNo+'&orderDetailId='+id+'&orderId='+orderId);

}
function reget(id){
    BootstrapDialog.show({
        title:'提示框',
        message:'是否确认获取',
        buttons: [{
            label: '确定',
            action: function(dialog) {
                dialog.close();
                $.ajax({
                    method: "POST",
                    url:basePath+"/core/reGetOrderDatail.do",
                    cache:false,
                    dataType : 'json',
                    data:{
                        'id':id
                    },
                    success : function(data) {
                        BootstrapDialog.alert("获取成功");
                        $('#orderDetailGrid').bootgrid("reload");
                    }
                });
            }
        }, {
            label: '取消',
            action: function(dialog) {
                dialog.close();
            }
        }]
    });
}
function queryOrderDetail(){
    $("#orderDetailGrid").bootgrid("reload");
}
function getParams(){
    return {
        companyName: $("#companyName").val(),
        status:$("#status").val(),
        customerEmail:$("#customerEmail").val(),
        // productType:$("#productType").val()
        productType:productType
    }
}

function upload(id){
    $("#id").val(id);
    $('#myModal').modal('show');
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
                    url:basePath+"/core/delOrderDetail.do",
                    cache:false,
                    dataType : 'json',
                    data:{
                        'id':id
                    },
                    success : function(data) {
                            BootstrapDialog.alert(data.msg);
                            $('#orderDetailGrid').bootgrid("reload");
                    }
                });
            }
        }, {
            label: '取消',
            action: function(dialog) {
                dialog.close();
            }
        }]
    });

}

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}
function ajaxFileUpload(){
    //开始上传文件时显示一个图片,文件上传完成将图片隐藏
    //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});
    //执行上传文件操作的函数，使用encodeURI方法，防止传输中文字符的时候出现乱码
    var uploadUrl = encodeURI(encodeURI(basePath + "/core/updateUpload.do?id="+$('#id').val()));
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
            if(dataset.code == true){
                // $('#result').html(dataset.msg);
                BootstrapDialog.alert(dataset.msg);
                $('#myModal').modal('hide');
                $("#orderDetailGrid").bootgrid("reload");
            }else if ( dataset.code == false){
                // $('#result').html(dataset.msg);
                BootstrapDialog.alert(dataset.msg);
                $('#myModal').modal('hide');
            }
        },
        error:function(data, status, e){ //服务器响应失败时的处理函数
            console.log(e);
            console.log(data);
            BootstrapDialog.alert("文件上传失败，请重试！！");
        }
    });
    // $('#myModal').modal('hide');
}