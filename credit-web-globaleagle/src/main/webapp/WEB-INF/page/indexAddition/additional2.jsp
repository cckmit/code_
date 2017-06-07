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
    <title>全球鹰-全球应收帐管理</title>
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
        <p class="lead">全球应收帐管理</p>

         <p style="line-height:28px">根据客户实际需求，全球鹰提供个性化的应收账款管理解决方案。
             应收账管理分为应收账审计、企业商账催收、金融机构账务催收等专业服务。<br>
             ● 应收账审计：
             全球鹰的应收账审计服务，帮助企业全面分析诊断逾期应收款的整体质量、逾期原因，策略地评估债务的质量和回收可行性，提出专业的解决方案建议，并为企业提供规范、便捷、优质的应收账款监控和风险预警服务。<br>
             ● 企业商账催收（B2B）：
             全球鹰整合全球各大洲的专业应收帐管理机构，旨在对企业已经被拖欠的应收账款，通过专业团队的第三方非诉讼催索介入，以追求最短时间、最大限度的挽回已知损失。我们遵循“不得到不收费”的服务原则，不但确保债权人的成本控制，也确保风险的及时管控。<br>
             ● 金融机构账务催收（B2C）：
             全球鹰为金融机构、商业企业、事业单位，对其提供授信消费的顾客，进行固定时间段内的大批量缴费提醒服务。在充分保障顾客隐私、安全等权益的前提下，全球鹰规范管理账款催收活动，善意提醒违约欠费的顾客及时缴清所欠款项，在固定时间段内最大限度地提高账款回收。</p>
    </div>

    
    
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
                                    <option selected="selected">选择帐龄</option>
                                    <option>3个月内</option>
                                    <option>3-6个月</option>
                                    <option>6-12个月</option>
                                    <option>12-24个月</option>
                                    <option>24个月以上</option>

                                </select>
                                </div>                                </div>
                            <div class="col-lg-3">

                                <div class="radio">
                                     <select class="form-control" >
                                    <option selected="selected">是否开据发票</option>
                                    <option>是</option>
                                    <option>否</option>
                                    <option>对方拒收</option>
                                </select>
                                </div>
                            </div>
                               <div class="col-lg-4">

                                <div class="radio">
                                 <input class="form-control"  placeholder="最后一次催款日期（2011-10-31）" type="text">

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
                        
                        
                        <div class="form-group">
                            <label class="col-lg-2 control-label">目标公司信息</label>

                                <div class="col-lg-3">

                                <div class="radio">
                                 <input class="form-control"  placeholder="联系电话" type="text">

                                </div>
                            </div>                              
                           <div class="col-lg-3">

                                <div class="radio">
                                 <input class="form-control"  placeholder="网址" type="text">

                                </div>
                            </div>
                               <div class="col-lg-4">

                                <div class="radio">
                                 <input class="form-control"  placeholder="邮箱" type="text">

                                </div>
                            </div>                                </div>

                                             <div class="form-group">
                            <label  class="col-lg-2 control-label">地址及其他信息</label>

                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" ></textarea>
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
                            <label class="col-lg-2 control-label">备注其他信息</label>

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