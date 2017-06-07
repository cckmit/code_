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
    <title>全球鹰-当地司法服务</title>
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
        <p class="lead">当地司法服务</p>   

         <p style="line-height:28px">如果您的贸易在全球范围，对于当地法律，合同细节，执行情况不了解，全球鹰分布在全球60多个国家的专业律师团队，将为您提供可靠的商业法律顾问服务。<br>
             ● 规律性合同审查<br>
             ● 代理诉讼和仲裁<br>
             ● 投资行为前期调查和分析<br>
             ● 重大商务行为合同拟制和完善</p> </div>

    
    
     <div class="row">
             <div class="col-lg-12">

            <div class="well bs-component">
                <form class="form-horizontal">
                    <fieldset>
                        <legend>委托表</legend>
                        
                        <div class="form-group">
                            <label class="col-lg-2 control-label">简要描述</label>

                                                            <div class="col-lg-3">
<div class="radio">
                                     <select class="form-control" >
                                    <option selected="selected">选择类型</option>
                                    <option>公司</option>
                                    <option>个人</option>
                            

                                </select>
                                </div>                                </div>
                            <div class="col-lg-3">

                                <div class="radio">
                                     <select class="form-control" >
                                    <option selected="selected">是否开据发票</option>
                                    <option>合同纠纷</option>
                                    <option>贸易纠纷</option>
                                    <option>其他</option>
                                </select>
                                </div>
                            </div>
                               <div class="col-lg-4">

                                <div class="radio">
                                 <input class="form-control"  placeholder="简要说明" type="text">

                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-lg-2 control-label">选择国家地区</label>

                                                            <div class="col-lg-3">
<div class="radio">
                                     <select class="form-control" >
                                    <option selected="selected">选择洲/区域</option>
                                    <option>中国</option>
                                    <option>美国</option>
                                    <option></option>
                                    <option>5</option>
                                </select>
                                </div>                                </div>
                            <div class="col-lg-3">

                                <div class="radio">
                                     <select class="form-control" >
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
                                 <input class="form-control"  placeholder="输入所在城市" type="text">

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-lg-2 control-label">目标公司名称</label>

                            <div class="col-lg-10">
                                <input class="form-control"  placeholder="公司名称" type="text">
                            </div>
                        </div>
                        
                        
                        

                                                      <legend></legend>

                        <div class="form-group">
                            <label class="col-lg-2 control-label">您的信息</label>

                                <div class="col-lg-3">

                                <div class="radio">
                                 <input class="form-control"  placeholder="姓名" type="text">

                                </div>
                            </div>                              
                           <div class="col-lg-3">

                                <div class="radio">
                                 <input class="form-control"  placeholder="电话/手机" type="text">

                                </div>
                            </div>
                               <div class="col-lg-4">

                                <div class="radio">
                                 <input class="form-control"  placeholder="邮箱" type="text">

                                </div>
                            </div>                                </div>
                                <div class="form-group">
                            <label  class="col-lg-2 control-label">备注其他信息</label>

                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" ></textarea>
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