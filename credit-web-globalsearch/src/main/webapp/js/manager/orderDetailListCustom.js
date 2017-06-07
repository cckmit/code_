$(function() {
    $('#orderLevel').val(orderLevel);
    $('#orderStatusId').val(orderStatusId);
    $("#file").fileinput({
        language : "zh",
        uploadUrl : encodeURI(encodeURI(basePath + "manager/upload.do")),
        uploadExtraData : function(){
            return {
                id: document.getElementById('uploadOrderDetailId').value
            }
        },
        //上传成功后执行自定义方法
        success_extra : function(data, textStatus) {
            if(textStatus == 'success' && data.status == 'OK'){
                BootstrapDialog.alert("上传成功");
                $('#myModal').modal('hide');
                $("#grid-orderDetail").bootgrid("reload");
            }
        }
    });

    $("#grid-orderDetail").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath+"manager/orderDetailList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but = "<button class=\"btn btn-sm btn-primary\" onclick=\"upload("+row.id+");\">上传报告</button>";

                return but;
            },
            "createDate": function(column, row)
            {
                var str=moment(row.createDate).format('YYYY-MM-DD HH:mm:ss');
                return str;
            }
            ,
            "orderLevel": function(column, row)
            {
                var str="";
                if(row.orderLevel=="1"){
                    str="数据库报告";
                }
                else{
                    str="完整报告";
                }
                return str;
            }
            ,
            "orderStatusId": function(column, row)
            {
                var str="";
                if(row.orderStatusId==1){
                    str="制作中";
                }
                else{
                    str="已完成";
                }
                return str;
            }
        }
    });
    $("#grid-orderDetail").bootgrid()
        .on("loaded.rs.jquery.bootgrid", function (e)
        {
            var data = $("#grid-orderDetail").bootgrid("getCurrentRows");
            var i = 1;
            var countries = Array();
            countries[0] = "<option></option>";
            $.each(data,function(){
                var country = "";
                var flag = 0;
                for(var j=0;j<countries.length;j++){
                    if($("#countryId").val()==this.countryId){
                        country = "<option value='"+this.countryId+"' selected='true'>"+this.countryCnName+"</option>";
                    }
                    else{
                        country = "<option value='"+this.countryId+"'>"+this.countryCnName+"</option>";
                    }
                    if(countries[j]==country){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    countries[i] = country;
                    i++;
                }
            });
            $("#countryId").empty();
            $.each(countries,function(){
                $("#countryId").append(this);
            });
        });
});

function getParams(){
    return {
        companyName: $("#companyName").val(),
        countryId:$("#countryId").val(),
        orderLevel:$("#orderLevel").val(),
        orderStatusId:$("#orderStatusId").val(),
        isCustomOrder:$("#isCustomOrder").val()
    }
}

function query(){
    $("#grid-orderDetail").bootgrid("reload");
}
function upload(id){
    $("#uploadOrderDetailId").val(id);
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
                $("#grid-orderDetail").bootgrid("reload");
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