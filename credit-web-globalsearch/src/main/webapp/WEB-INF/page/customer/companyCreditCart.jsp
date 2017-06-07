<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Full search - Corporate credit card</title>
    <jsp:include page="../include/include.jsp"/>
    <link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/fileinput.css">
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/fileinput.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/localization/fileinput/zh.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/ajaxfileupload.js"></script>
</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    $(document).ready(function () {
        $("#userLi").addClass("active");
    });
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
                    // alert($('#uploadPicPath').val());
                    $('#result').html("upload successful");
                    BootstrapDialog.alert("upload successful");
                }else if ( dataset.status == "EMPTY"){
                    $('#result').html("No selection of files!");
                    BootstrapDialog.alert("No selection of files!");
                }else {
                    $('#result').html('File upload failure, please try again!');
                    BootstrapDialog.alert("File upload failure, please try again!");
                }
            },
            error:function(data, status, e){ //服务器响应失败时的处理函数
                console.log(e);
                console.log(data);
                BootstrapDialog.alert("File upload failure, please try again!");
            }
        });
    }

    function clickButton() {
        BootstrapDialog.alert("The company information is submitted successfully, later our staff will certify the relevant information!");
    }


</script>
<body>
<jsp:include page="../include/top.jsp"/>
<div id="banner">
<div class="container">
    <div class="row">
        <div class="well bs-component">
            <form class="form-horizontal">
            <fieldset>
                <legend>Corporate credit card</legend>
                <div class="form-group" style="border-bottom:1px solid #e5e5e5;">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Management status</label>
                            <div class="col-lg-10" style="padding-left: 10px;">
                                <textarea id="manage" class="form-control" style="width: 97%;height: 95px;">
Management status (main business, capacity, scale, etc.)：
Import and export information:
Industry certification, honor:
Population size、site scale：
                                </textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group" style="width: 50%;float: left;">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Bank information:</label>
                            <div class="col-lg-8" >
                                <textarea id="bank" class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group" style="width: 50%;float: left;margin-left: 15px;">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Trade object (customer, supplier):</label>
                            <div class="col-lg-8" >
                                <textarea id="client" class="form-control" rows="3" ></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group" style="width: 50%;float: left;margin-bottom: 30px;">
                    <div class="col-md-12" style="width: 35%;">
                        <div class="form-group">
                            <label class="col-lg-12 control-label" style="width: 200px;line-height: 24px;">Upload the company's recent financial statements:</label>
                        </div>
                    </div>
                    <div id="uploadPic" class="col-md-offset-1 col-md-4" style="width: 61%;margin-left: 5px;padding-top: 10px;">
                        <div class="form-group">
                            <input id="uploadPicPath" name="uploadPicPath" class="form-control" type="hidden">
                            <input id="file" type="file" name="file" class="file"
                                   data-allowed-file-extensions='["gif","jpg","png"]'>

                        </div>
                    </div>
                </div>

                <div class="form-group" style="width: 50%;float: left;margin: 0 0 30px 15px;">
                    <div class="col-md-4" >
                        <div class="form-group">
                            <label class="col-lg-12 control-label" style="width: 200px;line-height: 24px;">Upload recent photos of company:</label>
                        </div>
                    </div>
                    <div id="uploadPic2" class=" col-md-8" style="width: 61%;margin-left: 15px;padding-top: 10px;">
                        <div class="form-group">
                            <input id="uploadPicPath2" name="uploadPicPath" class="form-control" type="hidden">
                            <input id="file2" type="file" name="file" class="file"
                                   data-allowed-file-extensions='["gif","jpg","png"]'>

                        </div>
                    </div>
                </div>

                <div class="form-group" style="border-bottom:1px solid #e5e5e5;">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="line-height: 24px;">Brief description of the company (less than 200 words):</label>
                            <div class="col-lg-10" style="padding-left: 10px;">
                                <textarea id="txtOther" class="form-control" style="width: 97%;height: 95px;"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group" style="margin-top: 5px;">
                    <div class="col-lg-12 text-center" >
                        <button type="button" class="btn btn-primary"  onclick="clickButton()">Submit the company's credit card</button>
                    </div>
                </div>

            </fieldset>
            </form>
        </div>

    </div>
</div>
</div>
<jsp:include page="../include/bottom.jsp"/>

</body>
</html>

