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
    <title>全球鹰-我的信息</title>
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
                    $('#result').html("上传成功");
                    BootstrapDialog.alert("上传成功");
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

    function clickButton() {
        BootstrapDialog.alert("公司信息提交成功，稍后我们工作人员会对相关信息进行认证！");
    }


</script>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<div id="banner">
<div class="container">
    <div class="row">
        <div class="well bs-component">
            <form class="form-horizontal">
            <fieldset>
                <legend>公司信用名片</legend>
                <div class="form-group" style="border-bottom:1px solid #e5e5e5;">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">经营现状</label>
                            <div class="col-lg-10" style="width: 400px">
                                <textarea id="manage" class="form-control" rows="4">
经营现状(主营业务、产能规模等）：
进出口信息：
行业认证、荣誉：
人数规模、场地规模：
                                </textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group" style="width: 50%;float: left;">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">银行信息</label>
                            <div class="col-lg-10" style="width: 400px;">
                                <textarea id="bank" class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group" style="width: 50%;float: left;">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">贸易对象（客户、供应商）</label>
                            <div class="col-lg-10" style="width: 400px">
                                <textarea id="client" class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group" style="width: 50%;float: left;margin-top: 15px;margin-bottom: 30px;">
                    <div class="col-md-12" style="width: 35%;">
                        <div class="form-group">
                            <label class="col-lg-12 control-label" style="width: 200px">上传公司近期财务报表:</label>
                        </div>
                    </div>
                    <div id="uploadPic" class="col-md-offset-1 col-md-4" style="width: 56%;margin-left: 4%;">
                        <div class="form-group">
                            <input id="uploadPicPath" name="uploadPicPath" class="form-control" type="hidden">
                            <input id="file" type="file" name="file" class="file"
                                   data-allowed-file-extensions='["gif","jpg","png"]'>

                        </div>
                    </div>
                </div>

                <div class="form-group" style="width: 50%;float: left;margin-top: 15px;margin-bottom: 30px;">
                    <div class="col-md-12" style="width: 35%;">
                        <div class="form-group">
                            <label class="col-lg-12 control-label" style="width: 200px">上传公司近期照片:</label>
                        </div>
                    </div>
                    <div id="uploadPic2" class="col-md-offset-1 col-md-4" style="width: 56%;margin-left: 4%;">
                        <div class="form-group">
                            <input id="uploadPicPath2" name="uploadPicPath" class="form-control" type="hidden">
                            <input id="file2" type="file" name="file" class="file"
                                   data-allowed-file-extensions='["gif","jpg","png"]'>

                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 150px">公司简单说明（200字以内）</label>
                            <div class="col-lg-10" style="width: 400px">
                                <textarea id="txtOther" class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group" style="margin-top: 5px;">
                    <div class="col-lg-12 text-center" style="margin-left: -9%;">
                        <button type="button" class="btn btn-primary"  onclick="clickButton()">提交公司信用名片</button>
                    </div>
                </div>

            </fieldset>
            </form>
        </div>

    </div>
</div>
</div>
<jsp:include page="${basePath}../include/bottomCommon.jsp"/>

</body>
</html>

