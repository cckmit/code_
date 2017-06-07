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
    <title>全球鹰-尽职调查服务</title>
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
        <div class="col-lg-12" style="height: 50px;background-color: #7ea8e1; text-align: center">
            <p class="lead" style="color: white">本功能正在调试，即将开放！</p>
        </div>
    <div >
        <p class="lead">尽职调查服务</p>   

         <p style="line-height:28px">从买方角度来说，尽职调查就是风险管理。
             全球鹰的尽职调查服务，包括但不限于：<br>
             ● 企业的基本信息、股权、财务、等内容的证据调查与采集；<br>
             ● 原始尽调资料的集中整理和归档、统计、电子化、数据化；<br>
             ● 尽调信息多源交叉检验，如个人信用查询、企业信用查询、诉讼情况、行业信息等。<br>
             全球鹰的尽职调查服务，帮助买方全面了解意向购买股份或资产的全部情况，补救买卖双方在信息获知上的不平衡。</p> </div>

    
    
     <div class="row">
             <div class="col-lg-12">

            <div class="well bs-component">
                <form class="form-horizontal">
                    <fieldset>
                        <legend>委托表</legend>
                        
                   
                        
                        <div class="form-group">
                            <label class="col-lg-2 control-label">选择国家地区</label>

                                                            <div class="col-lg-3">
<div class="radio">
                                     <select class="form-control" id="select">
                                    <option selected="selected">选择洲/区域</option>
                                    <option>中国</option>
                                    <option>美国</option>
                                    <option></option>
                                    <option>5</option>
                                </select>
                                </div>                                </div>
                            <div class="col-lg-3">

                                <div class="radio">
                                     <select class="form-control" id="select">
                                    <option selected="selected">选择国家/地区</option>
                                    <option>中国</option>
                                    <option>美国</option>
                                    <option></option>
                                    <option>5</option>
                                </select>
                                </div>
                            </div>
                               <div class="col-lg-4">

                                <div class="radio">
                                 <input class="form-control" id="inputEmail" placeholder="输入所在城市" type="text">

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-2 control-label">目标公司名称</label>

                            <div class="col-lg-10">
                                <input class="form-control" id="inputEmail" placeholder="公司名称" type="text">
                            </div>
                        </div>
                        
                        
                        <div class="form-group">
                            <label class="col-lg-2 control-label">目标公司信息</label>

                                <div class="col-lg-3">

                                <div class="radio">
                                 <input class="form-control" id="inputEmail" placeholder="联系电话" type="text">

                                </div>
                            </div>                              
                           <div class="col-lg-3">

                                <div class="radio">
                                 <input class="form-control" id="inputEmail" placeholder="网址" type="text">

                                </div>
                            </div>
                               <div class="col-lg-4">

                                <div class="radio">
                                 <input class="form-control" id="inputEmail" placeholder="邮箱" type="text">

                                </div>
                            </div>                                </div>

                                             <div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label">地址及其他信息</label>

                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" id="textArea"></textarea>
<div class="checkbox">
                                    <label>
                                        <input type="checkbox"> 是否订制过目标企业商业资信报告
                                    </label>
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