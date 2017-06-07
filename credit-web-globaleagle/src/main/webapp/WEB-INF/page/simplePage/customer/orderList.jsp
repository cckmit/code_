<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String orderStatusId = "";
    if (request.getParameter("orderStatusId") != null) {
        orderStatusId = request.getParameter("orderStatusId");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="../include/include.jsp"/>
    <title>全球鹰-订单列表</title>
    <%--与progressbar.js冲突--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.min.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.theme.min.css">--%>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.min.js"></script>--%>
    <%--<script type="text/javascript" src="<%=basePath%>js/customer/orderList.js"></script>--%>

</head>
<%--<script type="text/javascript">--%>
    <%--var basePath = "<%=basePath%>";--%>
    <%--var orderStatusId = "<%=orderStatusId%>";--%>
    <%--var orderNo = "${orderNo}";--%>
    <%--$(document).ready(function () {--%>
        <%--$("#orderLi").addClass("active");--%>
        <%--$("#userLi").addClass("active");--%>
    <%--});--%>
<%--</script>--%>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<div class="container">
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
    <div id="banner">
        <p class="lead">订单管理</p>
        <%--<nav class="navbar navbar-default">--%>
            <%--<div class="container-fluid">--%>
                <%--<div class="navbar-header">--%>
                    <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"--%>
                            <%--data-target="#bs-example-navbar-collapse-1">--%>
                        <%--<span class="sr-only">Toggle navigation</span>--%>
                        <%--<span class="icon-bar"></span>--%>
                        <%--<span class="icon-bar"></span>--%>
                        <%--<span class="icon-bar"></span>--%>
                    <%--</button>--%>
                    <%--<a class="navbar-brand" href="#">筛选</a>--%>
                <%--</div>--%>

                <%--<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
                    <%--<form class="navbar-form navbar-left" role="search">--%>
                        <%--<div class="form-group">--%>
                            <%--<input class="form-control" placeholder="订单号" type="text" id="orderNo">--%>
                            <%--<input class="form-control" placeholder="开始日期" type="text" id="createDateFrom">--%>
                            <%--<input class="form-control" placeholder="结束日期" type="text" id="createDateTo">--%>
                            <%--<select id="orderStatusId" class="form-control">--%>
                                <%--<option></option>--%>
                                <%--<option value="1">支付中</option>--%>
                                <%--<option value="2">制作中</option>--%>
                                <%--<option value="3">已送达</option>--%>
                                <%--<option value="4">已完成</option>--%>
                                <%--<option value="0">已取消</option>--%>
                            <%--</select>--%>
                            <%--<button type="button" class="btn btn-primary" onclick="query();">搜索</button>--%>
                        <%--</div>--%>
                    <%--</form>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</nav>--%>
        <div class="table-responsive">
            <div class="row">
                <input type="hidden" name="orderId" id="orderId"/>
            </div>
            <table id="orderGrid" class="table table-hover table-bordered table-responsive">
                <thead>
                <tr>
                    <%--<th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>--%>
                    <th data-column-id="orderNo" data-type="string"data-width="10%">订单号</th>
                    <th data-column-id="createDate" data-formatter="createDate" data-type="string" data-width="12%">订购日期</th>
                    <th data-column-id="price" data-formatter="price" data-type="string" data-width="8%">订单价格</th>
                    <th data-column-id="isPay" data-formatter="isPay" data-type="string" data-width="15%">是否支付</th>
                    <th data-column-id="orderDetailCount" data-formatter="orderDetailCount" data-type="string" data-width="12%">报告数量</th>
                    <th data-column-id="orderStatusId" data-formatter="orderStatusId" data-type="string" data-width="8%">状态</th>
                    <!--
                            <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                                        <th data-column-id="isSend" data-formatter="isSend" data-type="string" data-width="10%">是否发送</th>
                                        <th data-column-id="isPay" data-formatter="isPay" data-type="string" data-width="10%">是否支付</th>
                                        <th data-column-id="isFinished" data-formatter="isFinished" data-type="string" data-width="10%">是否完成</th>
                                        <th data-column-id="sendEmail" data-type="string" data-width="30%">发送邮箱</th>
                                        <th data-column-id="createDate" data-formatter="createDate" data-type="string" data-width="10%">下单日期</th>
                                        <th data-column-id="price" data-type="string" data-width="10%">订单价格</th> -->
                    <th data-column-id="operate" data-formatter="operate" data-sortable="false" data-width="10%">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty impDatas}">
                    <c:forEach items="${impDatas.rows}"  var="list" varStatus="status">
                        <tr>
                            <td>${list.orderNo}</td>
                            <td>${creatTime}</td>
                            <td>CNY&nbsp;${list.price}</td>
                            <c:if test="${list.isPay=='否'}">
                                <td><a href="<%=basePath%>simple/customer/payOrderFromOrder.do?ids=${list.id}">未支付，是否立即支付？</a></td>
                            </c:if>
                            <c:if test="${list.isPay=='是'}">
                                <td><button class='btn btn-xs btn-primary'>已支付</button></td>
                            </c:if>
                            <td>${list.orderDetailCount}</td>
                            <c:if test="${list.orderStatusId==1}">
                                <td><button class='btn btn-xs btn-primary'>支付中</button></td>
                            </c:if>
                            <c:if test="${list.orderStatusId==2}">
                                <td><button class='btn btn-xs btn-primary'>制作中</button></td>
                            </c:if>
                            <c:if test="${list.orderStatusId==3}">
                                <td><button class='btn btn-xs btn-primary'>已送达</button></td>
                            </c:if>
                            <c:if test="${list.orderStatusId==4}">
                                <td><button class='btn btn-xs btn-primary'>已完成</button></td>
                            </c:if>
                            <c:if test="${list.orderStatusId==0}">
                                <td><button class='btn btn-xs btn-primary'>已取消</button></td>
                            </c:if>
                            <c:if test="${list.isPay=='是' && list.orderStatusId!=0 && list.isRead!='是'}">
                                <td><a href="<%=basePath%>simple/customer/deleteOrder.do?id=${list.id}">取消</a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>


    </div>
</div>
<div id="detailModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" style="width: 1000px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">订单详情</h4>
            </div>
            <div class="modal-body">
                <table id="detailGrid" class="table table-condensed table-hover table-striped">
                    <thead>
                    <tr>
                        <th data-column-id="id" data-type="numeric" data-order="asc" width="40%" data-visible="false">ID</th>
                        <th data-column-id="companyName" data-type="string" data-width="32%">公司名称</th>
                        <th data-column-id="countryCnName" data-type="string" data-width="8%">国家</th>
                        <th data-column-id="totalPrice" data-formatter="totalPrice" data-type="numeric" data-width="10%">订单价格</th>
                        <th data-column-id="orderLevel" data-formatter="orderLevel" data-type="string" data-width="12%">报告类型</th>
                        <th data-column-id="createDate" data-formatter="createDate" data-type="string" data-width="18%">下单日期</th>
                        <th data-column-id="orderStatusId" data-formatter="orderStatusId" data-type="string" data-width="8%">状态</th>
                        <th data-column-id="uploadFilePath" data-visible="false">报告url</th>
                        <th data-column-id="crefoNo" data-visible="false">crefoNo</th>
                        <th data-column-id="operate" data-formatter="operate" data-sortable="false" data-width="23%">下载</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div class="modal-footer">
            </div>

        </div>
    </div>
</div>

<jsp:include page="${basePath}../include/bottomCommon.jsp"/>

</body>
</html>