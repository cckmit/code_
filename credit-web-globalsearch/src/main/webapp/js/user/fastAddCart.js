$(function() {
    $("#fastAddLi").addClass("active");
    $("#file").fileinput({
        language : "zh",
        uploadUrl : encodeURI(encodeURI(basePath + "uploadPic.do")),
        //上传成功后执行自定义方法
        success_extra : function(data, textStatus) {
            if(textStatus == 'success' && !$.isEmptyObject(data)){
                $('#uploadPicPath').val(data.filePath);
                BootstrapDialog.alert("Upload success");
            }else {
                BootstrapDialog.alert("Upload failed");
            }
        }
    });
    //设置图片状态
    cbUploadPicClick();
});

function cbUploadPicClick(){
    if($("#cbUploadPic").is(':checked')){
        $("#uploadPic").show();
        $("#file").fileinput("enable");
        $("#company_address").attr("disabled",true);
        $("#company_phone").attr("disabled",true);
        $("#company_website").attr("disabled",true);
        $("#txtOther").attr("disabled",true);
    }
    else{
        $("#uploadPic").hide();
        $("#file").fileinput("disable");
        $("#company_address").attr("disabled",false);
        $("#company_phone").attr("disabled",false);
        $("#company_website").attr("disabled",false);
        $("#txtOther").attr("disabled",false);
    }


}

function checkForm (){
    if($("#cbUploadPic").is(':checked')){
    	if ($('#uploadPicPath').val()==null||$('#uploadPicPath').val()=="") {
            BootstrapDialog.alert("Upload file cannot be empty");
            return false;
		}
    }else{
        if ($("#company_name").val()==null||$("#company_name").val()=="") {
            BootstrapDialog.alert("Company name is not empty");
            return false;
        }
    if ($("#company_address").val()==null||$("#company_address").val()=="") {
        BootstrapDialog.alert("Company address is not empty");
        return false;
    }
    if ($("#company_phone").val()==null||$("#company_phone").val()=="") {
        BootstrapDialog.alert("Company phone is not empty");
        return false;
    }
    }
    return true;
}


function ajaxFileUpload(){
    //开始上传文件时显示一个图片,文件上传完成将图片隐藏
    //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});
    //执行上传文件操作的函数，使用encodeURI方法，防止传输中文字符的时候出现乱码
    var uploadUrl = encodeURI(encodeURI(basePath + "uploadPic.do"));
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
                 $('#uploadPicPath').val(dataset.filePath);
                $('#result').html("Upload success");
                BootstrapDialog.alert("Upload success");
            }else if ( dataset.status == "EMPTY"){
                $('#result').html("No file selected");
                BootstrapDialog.alert("No file selected");
            }else {
                $('#result').html('File upload failed, please try again!!');
                BootstrapDialog.alert("File upload failed, please try again!!");
            }
        },
        error:function(data, status, e){ //服务器响应失败时的处理函数
            console.log(e);
            console.log(data);
            BootstrapDialog.alert("File upload failed, please try again!!");
        }
    });
}

function statement() {
    BootstrapDialog.show({
        title: 'Disclaimer:  ',
        message: "&nbsp;&nbsp;"+'All the user gets from the site to deal with the judgment, combined with their own actual and on the basis of the principle of prudence and make corresponding decision, and assume all risks arising from the use of the content, not the Global Hawk decision result responsibility.'
        +'The Global Hawk provide product content just for the user reference, does not mean to provide security for the customer'+'s business risk, in any case, caused by the customer business decision loss, this website does not assume any commercial risk of the user, will not bear the loss and damage caused by the corresponding non controlling factors and negligence the.'
    });
}


