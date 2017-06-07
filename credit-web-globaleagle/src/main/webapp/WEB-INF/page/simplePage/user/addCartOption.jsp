<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>全球鹰-订购选择</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../include/include.jsp"/>
    <%--<script type="text/javascript">--%>
        <%--function chooseMethod(id) {--%>
            <%--if (id == 1) {--%>
                <%--$('#onchoosePrice').html("${countryInfo.getOnlineOrderCnyPrice()}");--%>
                <%--$('#onchoosePriceHidden').val("${countryInfo.getOnlineOrderCnyPrice()}");--%>
                <%--$('#onFullchoosePrice').html("${countryInfo.getOnlineFullOrderCnyPrice()}");--%>
                <%--$('#onFullchoosePriceHidden').val("${countryInfo.getOnlineFullOrderCnyPrice()}");--%>
                <%--$('#offchoosePrice').html("${countryInfo.getOfflineOrderCnyPrice()}");--%>
                <%--$('#offchoosePriceHidden').val("${countryInfo.getOfflineOrderCnyPrice()}");--%>
                <%--$('#exchoosePrice').html("${countryInfo.getOfflineExpressDeliveryCnyPrice()}");--%>
                <%--$('#exchoosePriceHidden').val("${countryInfo.getOfflineExpressDeliveryCnyPrice()}");--%>
                <%--$('#currency').val("cny");--%>

            <%--}--%>
            <%--else if (id == 2) {--%>
                <%--$('#onchoosePrice').html("${countryInfo.getOnlineOrderUsdPrice()}");--%>
                <%--$('#onchoosePriceHidden').val("${countryInfo.getOnlineOrderUsdPrice()}");--%>
                <%--$('#onFullchoosePrice').html("${countryInfo.getOnlineFullOrderCnyPrice()}");--%>
                <%--$('#onFullchoosePriceHidden').val("${countryInfo.getOnlineFullOrderCnyPrice()}");--%>
                <%--$('#offchoosePrice').html("${countryInfo.getOfflineOrderUsdPrice()}");--%>
                <%--$('#offchoosePriceHidden').val("${countryInfo.getOfflineOrderUsdPrice()}");--%>
                <%--$('#exchoosePrice').html("${countryInfo.getOfflineExpressDeliveryUsdPrice()}");--%>
                <%--$('#exchoosePriceHidden').val("${countryInfo.getOfflineExpressDeliveryUsdPrice()}");--%>
                <%--$('#currency').val("usd");--%>

            <%--}--%>
            <%--else if (id == 3) {--%>
                <%--$('#onchoosePrice').html("${countryInfo.getOnlineOrderEurPrice()}");--%>
                <%--$('#onchoosePriceHidden').val("${countryInfo.getOnlineOrderEurPrice()}");--%>
                <%--$('#onFullchoosePrice').html("${countryInfo.getOnlineFullOrderCnyPrice()}");--%>
                <%--$('#onFullchoosePriceHidden').val("${countryInfo.getOnlineFullOrderCnyPrice()}");--%>
                <%--$('#offchoosePrice').html("${countryInfo.getOfflineOrderEurPrice()}");--%>
                <%--$('#offchoosePriceHidden').val("${countryInfo.getOfflineOrderEurPrice()}");--%>
                <%--$('#exchoosePrice').html("${countryInfo.getOfflineExpressDeliveryEurPrice()}");--%>
                <%--$('#exchoosePriceHidden').val("${countryInfo.getOfflineExpressDeliveryEurPrice()}");--%>
                <%--$('#currency').val("eur");--%>

            <%--}--%>

        <%--}--%>

        <%--function checkForm() {--%>
            <%--if ($("#onCheckBox").attr("checked") == undefined && $("#onFullCheckBox").attr("checked") == undefined && $("#offCheckBox").attr("checked") == undefined && $("#exCheckBox").attr("checked") == undefined) {--%>
                <%--BootstrapDialog.alert("请选择价格");--%>
                <%--return false;--%>
            <%--}--%>
            <%--if ($("#clause").attr("checked") == undefined) {--%>
                <%--BootstrapDialog.alert("请接受法律条款");--%>
                <%--return false;--%>
            <%--}--%>
            <%--if("${countrySel}"=="中国"){--%>
            <%--if (!checkCompany()){--%>
                <%--if ("${sessionScope.customerInfo}"==null||"${sessionScope.customerInfo}"==""){--%>
                    <%--BootstrapDialog.alert("个人用户/游客无法订购完全报告");--%>
                    <%--return false;--%>
                <%--}else{--%>
                    <%--BootstrapDialog.show({--%>
                        <%--title: '您需要认证',--%>
                        <%--message: "订购完整报告需要公司认证，请补全公司相关信息",--%>
                        <%--buttons: [{--%>
                            <%--label: '确定',--%>
                            <%--action: function() {--%>
                                <%--window.location.href="<%=basePath%>customer/tochangedInformation.do";--%>
                            <%--}--%>
                        <%--}, {--%>
                            <%--label: '取消',--%>
                            <%--action: function(dialog) {--%>
                                <%--dialog.close();--%>
                            <%--}--%>
                        <%--}]--%>
                    <%--});--%>
                    <%--return false;--%>
                <%--}--%>
            <%--}--%>
            <%--return true;--%>
        <%--}}--%>

        <%--function payFo() {--%>
            <%--if ($("#onCheckBox").attr("checked") == undefined && $("#onFullCheckBox").attr("checked") == undefined && $("#offCheckBox").attr("checked") == undefined && $("#exCheckBox").attr("checked") == undefined) {--%>
                <%--BootstrapDialog.alert("请选择价格");--%>
                <%--return;--%>
            <%--}--%>
            <%--if ($("#clause").attr("checked") == undefined) {--%>
                <%--BootstrapDialog.alert("请接受法律条款");--%>
                <%--return;--%>
            <%--}--%>
            <%--if("${countrySel}"=="中国"){--%>
                <%--if (!checkCompany()){--%>
                <%--if ("${sessionScope.customerInfo}"==null||"${sessionScope.customerInfo}"==""){--%>
                    <%--BootstrapDialog.alert("个人用户/游客无法订购完全报告");--%>
                <%--}else{--%>

                    <%--BootstrapDialog.show({--%>
                        <%--title: '您需要认证',--%>
                        <%--message: "订购完整报告需要公司认证，请补全公司相关信息",--%>
                        <%--buttons: [{--%>
                            <%--label: '确定',--%>
                            <%--action: function() {--%>
                                <%--window.location.href="<%=basePath%>customer/tochangedInformation.do";--%>
                            <%--}--%>
                        <%--}, {--%>
                            <%--label: '取消',--%>
                            <%--action: function(dialog) {--%>
                                <%--dialog.close();--%>
                            <%--}--%>
                        <%--}]--%>
                    <%--});--%>
                <%--}--%>
                <%--return;--%>
            <%--}}--%>
            <%--if ("${sessionScope.customerInfo.levelId}"==3){--%>
                <%--BootstrapDialog.show({--%>
                    <%--title: '订单确认',--%>
                    <%--message: "确认是否订购此报告",--%>
                    <%--buttons: [{--%>
                        <%--label: '确定',--%>
                        <%--action: function() {--%>
                            <%--document.forms.formAction.action = "<%=basePath%>user/addOrderFromCartOption.do";--%>
                            <%--document.forms.formAction.submit();--%>
                        <%--}--%>
                    <%--}, {--%>
                        <%--label: '取消',--%>
                        <%--action: function(dialog) {--%>
                            <%--dialog.close();--%>
                            <%--return;--%>
                        <%--}--%>
                    <%--}]--%>
                <%--});--%>
            <%--}else {--%>
                <%--document.forms.formAction.action = "<%=basePath%>user/addOrderFromCartOption.do";--%>
                <%--document.forms.formAction.submit();--%>
            <%--}--%>


        <%--}--%>
        <%--function checkCompany() {--%>
            <%--if ($("#onFullCheckBox").attr("checked") != undefined || $("#offCheckBox").attr("checked") != undefined || $("#exCheckBox").attr("checked") != undefined) {--%>
                <%--if ("${sessionScope.customerInfo}"==null||"${sessionScope.customerInfo}"==""||"${sessionScope.customerInfo.checkStatus}"=="否"||"${sessionScope.customerInfo.checkStatus}"==""){--%>
                <%--return false;--%>
                <%--}--%>
            <%--}--%>
            <%--return true;--%>
        <%--}--%>

        <%--function statement() {--%>
            <%--BootstrapDialog.show({--%>
                <%--title: '免责声明:  ',--%>
                <%--message: "&nbsp;&nbsp;"+'用户应对从本网站获取的所有内容自行加以判断，结合自身实际并依据谨慎原则作出相应决策，并承担因使用内容而引起的所有风险，全球鹰不对决策结果承担责任。全球鹰提供产品所含内容仅供使用者参考使用，并不意味着为客户的商业风险提供担保，在任何情况下，对于客户的商业决策所造成的损失，本网站不承担用户的任何商业风险，也不承担由于非控因素和疏忽而引起的相应的损失和损害。'--%>
            <%--});--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>

<div class="container">
    <div id="banner">
        <div class="row">
            <div class="well bs-component">
                <fieldset>
                    <legend>信用报告产品描述信息</legend>
                    <div class="form-group">
                        <div class="col-lg-12">
                            <p>
                                &nbsp;&nbsp;&nbsp;&nbsp;企业信用报告是通过全方位多渠道地采集被调查企业的信用信息，经综合评估后形成的客观反映被调查企业信用状况的专业报告。<br>
                                &nbsp;&nbsp;&nbsp;&nbsp;企业信用报告涵盖企业基本信息、法律注册信息、股权结构、工商变更信息、历史背景、企业关联信息、经营现状、财务信息、司法信息等内容。信用报告收集被调查企业信息，做出相应的财务分析、盈利能力和偿付能力判断，并对被调查企业进行信用风险评级，全面、直观、即时地反映被调查企业的信用状况，为客户判断被调查企业的信用状况提供参考，帮助客户迅速识别优质商业伙伴，规避潜在商业风险。</p>
                        </div>
                    </div>
                </fieldset>
            </div>
            </div>
        <div class="row">
            <div class="well bs-component">
                <!-- 				<fieldset>
                    <legend>币种</legend>
                            <div class="form-group">
                                    <div class="btn-group">
                                        <button class="btn btn-info" onclick="chooseMethod(1);">人民币</button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-info" onclick="chooseMethod(2);">美元</button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-info" onclick="chooseMethod(3);">欧元</button>
                                    </div>
                            </div>
                </fieldset> -->

                <form class="form-horizontal" id="formAction"
                      action="<%=basePath%>simple/user/addOrderFromCartOption.do" method="post"
                      onsubmit="return checkForm();">
                    <input class="btn btn-primary" id="currency" type="hidden" name="currency" value="cny">
                    <input type="hidden" name="countryId"
                           value="${countryInfo.getId()}">

                    <fieldset>
                        <legend>订购信息</legend>
                        <c:if
                                test="${not empty companyRName or not empty registrationNumber}">
                            <input type="hidden" name="isCustomOrder" value="否">
                            <input type="hidden" name="crefoNo" value="${crefoNo}">


                            <div class="form-group">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" style="width: 165px">目标公司名称：</label>

                                        <div class="col-lg-10" style="width: 400px; padding-top: 7px">
                                            <strong> ${companyRName}&nbsp; <c:if
                                                    test="${status=='Active'}">
                                                <span class="label label-success">Active</span>
                                            </c:if> <c:if test="${status=='NonActive'}">
                                                <span class="label label-danger">NonActive</span>
                                            </c:if>
                                            </strong>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" style="width: 165px">目标公司注册码：</label>
                                        <div class="col-lg-10" style="width: 400px; padding-top: 7px">
                                            <strong> ${registrationNumber} </strong>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" style="width: 165px">目标公司地址：</label>

                                        <div class="col-lg-10" style="width: 400px; padding-top: 7px">
                                            <strong> ${street} </strong>
                                        </div>
                                    </div>
                                </div>


                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" style="width: 165px">报告更新至：</label>

                                        <div class="col-lg-10" style="width: 400px; padding-top: 7px">
                                            <strong> 2016&nbsp;年 </strong>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <div class="form-group">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" style="width: 165px">所属国家及区域：</label>
                                        <div class="col-lg-10" style="width: 400px; padding-top: 7px">
                                            <strong> ${countrySel} &nbsp; ${province} &nbsp; ${city} </strong>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label" style="width: 165px">报告评估更新至：</label>
                                        <div class="col-lg-10" style="width: 400px; padding-top: 7px">
                                            <strong>
                                            <c:if test="${not empty newfinanyear}">
                                            ${newfinanyear}
                                            </c:if>
                                            <c:if test="${empty newfinanyear}">
                                             -&nbsp;&nbsp;&nbsp;
                                            </c:if>
                                                &nbsp;年 </strong>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </c:if>

                        <legend>&nbsp;</legend>
                        <table class="table table-striped table-responsive">
                            <thead>
                            <tr>
                                <th width="8%">选择</th>
                                <th width="12%">价格</th>
                                <th width="15%">报告类型</th>
                                <th width="10%">制作时间</th>
                                <th width="7%">国家</th>
                                <th width="7%">样本报告</th>
                                <th width="21%">送达内容</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${countryInfo.getOnlineOrderCnyPrice() > 0}">
                            <tr>
                                <td bgcolor="#FFFFFF"><input style="width: 16px; height: 16px;" name="choose" type="radio"
                                                             value="online" id="onCheckBox" checked="checked"></td>
                                <td bgcolor="#FFFFFF"><strong>CNY <span
                                        id="onchoosePrice">${countryInfo.getOnlineOrderCnyPrice()}

                                </span>
                                    <c:if test="${onlineOrderCnyPrice!=countryInfo.getOnlineOrderCnyPrice()}">
                                        (${onlineOrderCnyPrice})
                                    </c:if>
                                </strong></td>
                                <input id="onchoosePriceHidden" type="hidden"
                                       name="onlinePrice"
                                       value="${countryInfo.getOnlineOrderCnyPrice()}">
                                <td bgcolor="#FFFFFF">数据库报告</td>
                                <td bgcolor="#FFFFFF">即时下载</td>
                                <input name="onlineNormailDeliveryDays"
                                       value="${countryInfo.getOnlineNormailDeliveryDays()}"
                                       type="hidden">
                                <td bgcolor="#FFFFFF">${countryInfo.cnName}</td>

                                <td bgcolor="#FFFFFF"><a target="_blank" href="<%=basePath%>upload/demo/全球鹰样本报告.pdf">查看</a></td>
                                <td bgcolor="#FFFFFF">一个Html数据库报告</td>
                            </tr>
                            </c:if>
                            <c:if test="${countryInfo.getOnlineFullOrderCnyPrice() > 0}">
                                <tr>
                                    <td bgcolor="#FFFFFF"><input  style="width: 16px; height: 16px;" name="choose" type="radio"
                                                                 value="onlineFull" id="onFullCheckBox"></td>
                                    <td bgcolor="#FFFFFF"><strong>CNY <span
                                            id="onFullchoosePrice">${countryInfo.getOnlineFullOrderCnyPrice()}

                                    </span>
                                        <c:if test="${onlineFullOrderCnyPrice!=countryInfo.getOnlineFullOrderCnyPrice()}">
                                            (${onlineFullOrderCnyPrice})
                                        </c:if>
                                    </strong></td>
                                    <input id="onFullchoosePriceHidden" type="hidden"
                                           name="onlineFullPrice"
                                           value="${countryInfo.getOnlineFullOrderCnyPrice()}">
                                    <td bgcolor="#FFFFFF">数据库完整报告</td>
                                    <td bgcolor="#FFFFFF">即时下载</td>
                                    <input name="onlineFullNormailDeliveryDays"
                                           value="${countryInfo.getOnlineFullNormailDeliveryDays()}"
                                           type="hidden">
                                    <td bgcolor="#FFFFFF">${countryInfo.cnName}</td>

                                    <td bgcolor="#FFFFFF"><a target="_blank" href="<%=basePath%>upload/demo/全球鹰样本报告.pdf">查看</a></td>
                                    <td bgcolor="#FFFFFF">一个Html数据库完整报告</td>
                                </tr>
                            </c:if>
                            <c:if test="${countryInfo.getOfflineOrderCnyPrice() > 0}">
                            <tr>
                                <td bgcolor="#FFFFFF"><input  style="width: 16px; height: 16px;" name="choose" type="radio"
                                                             value="offline" id="offCheckBox"></td>
                                <td bgcolor="#FFFFFF"><strong>CNY <span
                                        id="offchoosePrice">${countryInfo.getOfflineOrderCnyPrice()}</span>
                                    <c:if test="${offlineExpressDeliveryCnyPrice!=countryInfo.getOfflineOrderCnyPrice()}">
                                        (${offlineExpressDeliveryCnyPrice})
                                    </c:if>
                                </strong>
                                </td>
                                <input id="offchoosePriceHidden" type="hidden"
                                       name="offlinePrice"
                                       value="${countryInfo.getOfflineOrderCnyPrice()}">
                                <td bgcolor="#FFFFFF">完整版报告</td>
                                <td bgcolor="#FFFFFF">${countryInfo.getOfflineNormailDeliveryDays()}个工作日</td>
                                <input name="offlineNormailDeliveryDays" type="hidden"
                                       value="${countryInfo.getOfflineNormailDeliveryDays()}">
                                <td bgcolor="#FFFFFF">${countryInfo.cnName}</td>
                                <td bgcolor="#FFFFFF"><a target="_blank" href="<%=basePath%>upload/demo/全球鹰样本报告.pdf">查看</a></td>
                                <td bgcolor="#FFFFFF">一个PDF完整版报告+一个Html数据库报</td>
                            </tr>
                            </c:if>
                            <c:if test="${countryInfo.getOfflineExpressDeliveryCnyPrice() > 0}">
                            <tr>
                                <td bgcolor="#FFFFFF"><input  style="width: 16px; height: 16px;" name="choose" type="radio"
                                                             value="ex" id="exCheckBox"></td>
                                <td bgcolor="#FFFFFF"><strong>CNY <span
                                        id="exchoosePrice">${countryInfo.getOfflineExpressDeliveryCnyPrice()}</span>
                                    <c:if test="${expressDeliveryCnyPrice!=countryInfo.getOfflineExpressDeliveryCnyPrice()}">
                                        (${expressDeliveryCnyPrice})
                                    </c:if>
                                </strong>
                                </td>
                                <input id="exchoosePriceHidden" type="hidden"
                                       name="offlineExpressPrice"
                                       value="${countryInfo.getOfflineExpressDeliveryCnyPrice()}">
                                <td bgcolor="#FFFFFF">完整版报告-加急</td>
                                <td bgcolor="#FFFFFF">${countryInfo.getOfflineExpressDeliveryDays()}个工作日</td>
                                <input name="offlineExpressDeliveryDays" type="hidden"
                                       value="${countryInfo.getOfflineExpressDeliveryDays()}">
                                <td bgcolor="#FFFFFF">${countryInfo.cnName}</td>
                                <td bgcolor="#FFFFFF"><a target="_blank" href="<%=basePath%>upload/demo/全球鹰样本报告.pdf">查看</a></td>
                                <td bgcolor="#FFFFFF">一个PDF完整版报告+一个Html数据库报</td>
                            </tr>
                            </c:if>
                            <c:if test="${countryInfo.getOfflineExpressDeliveryCnyPrice() <= 0}">
                                <h4>近期已订购过该公司完整版报告，请勿重复订购</h4>
                            </c:if>
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
                            </tbody>
                        </table>

                        <c:if test="${not empty listOrderDetail}">
                        <h4>该公司订购历史</h4>
                        <table class="table table-striped table-responsive">
                            <thead>
                            <tr>
                                <th>时间</th>
                                <th>类型</th>
                                <th>价格</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="listOrderDetail" items="${listOrderDetail}" varStatus="status">
                                <tr>
                                    <th>
                                        <fmt:formatDate value="${listOrderDetail.createDate}" type="date"/>

                                    </th>
                                    <th>
                                        <c:if test="${listOrderDetail.orderLevel==1}">数据库报告</c:if>
                                        <c:if test="${listOrderDetail.orderLevel==2}">完整版报告</c:if>
                                        <c:if test="${listOrderDetail.orderLevel==3}">数据库完整报告</c:if>
                                    </th>
                                    <th>${listOrderDetail.totalPrice}</th>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        </c:if>


                        <div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label title">信息备注：</label>

                            <div class="col-lg-7">
                                <textarea class="form-control" rows="3" id="textArea"></textarea>
                            </div>
                        </div>
                        <!-- 							<div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label">信息备注：</label>

                            <div class="col-lg-10">
                                <textarea class="form-control" rows="3" id="textArea"></textarea>
                            </div>
                        </div> -->
                        <div class="form-group">
                            <label class="col-lg-2 control-label">法律及条款：</label><label
                                style="padding-top: 7px; padding-left: 15px; padding-right: 10px">
                            <table><tr><td width="30px" height="40px"><input  style="width: 16px; height: 16px;" type="checkbox" name="agreeSta" checked="checked" id="clause"></td><td><a title="&nbsp;&nbsp;&nbsp;用户应对从本网站获取的所有内容自行加以判断，结合自身实际并依据谨慎原则作出相应决策，并承担因使用内容而引起的所有风险，全球鹰不对决策结果承担责任。全球鹰提供产品所含内容仅供使用者参考使用，并不意味着为客户的商业风险提供担保，在任何情况下，对于客户的商业决策所造成的损失，本网站不承担用户的任何商业风险，也不承担由于非控因素和疏忽而引起的相应的损失和损害。">解释商安信所有条款及所有法律义务</a>${agreeSta}</td></tr></table>
                            </label>

                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                    <%--<input style="width: 100px;" type="submit" class="btn btn-danger" value="加入购物车"
                                    <c:if test="${sessionScope.customerInfo.levelId ==3}">
                                           disabled
                                    </c:if>
                                    >--%>
                                        <table width="100%"><tr><td align="center" width="30px" height="40px"><input type="radio" checked="checked" name="chooseOne" value="addCast" style="width: 16px;height: 16px;"></td><td  width="150px">加入购物车</td>
                                            <td align="center" width="30px" height="40px"><input type="radio" name="chooseOne" value="payAtOnce" style="width: 16px;height: 16px;"></td><td >马上支付</td>

                                            <tr><td align="center" height="40px" colspan="4"><input type="submit" class="btn btn-primary" value="提交" style="width: 120px;"></td></tr></table>
                            </div>
        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="col-lg-4 col-lg-offset-1"></div>
    </div>

</div>
<jsp:include page="${basePath}../include/bottomCommon.jsp"/>

</body>
</html>