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
    <title>全球鹰-商业资讯服务</title>
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
        <p class="lead">商业咨询服务</p>

         <p style="line-height:28px">全球鹰的商业咨询服务，可以帮助企业<br>
             在瞬息万变的商业环境中，鉴别优质交易对象；<br>
             通过科学量化的评估手段，直观判断交易风险度；<br>
             运用先进管理方法，实现应收账款的有效监控与管理。<br>
             全球鹰的优势：<br>
             ● 经验丰富的国际化专业顾问团队<br>
             ● 应客所需的个性化解决方案<br>
             ● 充分可实践性的商业策略<br>
             全球鹰全方位的商业咨询服务，帮助您做出信心十足的商业决策！</p> </div>

    
    
     <div class="row">
             <div class="col-lg-12">

            <div class="well bs-component">
                <form class="form-horizontal">
                    <fieldset>
                        <legend>提问表</legend>
                        
                   
                                           
                                             <div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label">问题及备注</label>

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