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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>全球鹰-数据对接服务</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript" src="<%=basePath%>js/base64.js"></script>

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    function buttonClick() {
        BootstrapDialog.alert("该功能即将开放!");
    }
</script>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<div class="container">
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
    <div >
        <p class="lead">数据对接服务</p>   

         <p>全球鹰商业信用数据可根据您的要求，提供各类型数据接口服务。<br>
             如果您的公司拥有自己的系统或数据格式，每次大量订单提交，报告下载程序繁琐。<br>
             全球鹰提供的数据对接服务，数据一键调用，可以根据要求自动下订单，亦可推送您需要的格式。</p> </div>

    
     <div class="row">
             <div class="col-lg-12">

            <div class="well bs-component">
                <form class="form-horizontal">
                    <fieldset>
                        <legend>数据要求</legend>
                        
                         <div class="form-group">
                            <label class="col-lg-2 control-label">选择数据类型</label>

                                                            <div class="col-lg-2">
<div class="radio">
                                    <label>
                                        <input name="optionsRadios" id="optionsRadios1" value="option1"
                                               checked="checked" type="radio">
                                        中国数据
                                    </label>
                                </div>                                </div>
                            <div class="col-lg-2">

                                <div class="radio">
                                    <label>
                                        <input name="optionsRadios" id="optionsRadios2" value="option2" type="radio">
                                       国际数据
                                    </label>
                                </div>
                            </div>
                               <div class="col-lg-3">

                                <div class="radio">
                                    <label>
                                        <input name="optionsRadios" id="optionsRadios2" value="option2" type="radio">
                                       其他要求
                                    </label>
                                </div>
                            </div>
                        </div>
                        
                       
                                             <div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label">备注说明</label>

                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" id="textArea"></textarea>
<div class="checkbox">
                                   
                                </div>                            </div>
                        </div>
                                               <legend></legend>

                        <div class="form-group">
                            <label class="col-lg-2 control-label">您的信息</label>

                                <div class="col-lg-3">

                                <div class="radio">
                                 <input class="form-control" id="inputEmail" placeholder="姓名" type="text">

                                </div>
                            </div>                              
                           <div class="col-lg-3">

                                <div class="radio">
                                 <input class="form-control" id="inputEmail" placeholder="电话/手机" type="text">

                                </div>
                            </div>
                               <div class="col-lg-4">

                                <div class="radio">
                                 <input class="form-control" id="inputEmail" placeholder="邮箱" type="text">

                                </div>
                            </div>                                </div>
                                <div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label">备注其他信息</label>

                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" id="textArea"></textarea>
<div class="checkbox">
                                   
                                </div>                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <button type="reset" class="btn btn-default">重置表单</button>
                                <button type="button" onclick="buttonClick()" class="btn btn-primary">提交表单</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>        </div>

</div>

<jsp:include page="${basePath}../include/bottomCommon.jsp"/>
</body>
</html>