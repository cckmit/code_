<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
    String orderStatusId = "";
    if (request.getParameter("orderStatusId") != null) {
        orderStatusId = request.getParameter("orderStatusId");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="../include/include.jsp"/>
    <title>全球鹰-报告列表</title>

    <script type="text/javascript" src="<%=basePath%>js/customer/orderDetailList.js"></script>
</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    var orderStatusId = "<%=orderStatusId%>";
    $(document).ready(function () {
        $("#orderDetailLi").addClass("active");
        $("#userLi").addClass("active");
    });
</script>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
    <div id="banner">
        <div class="container">
        <p class="lead">报告管理</p>
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
                                <%--<input class="form-control" placeholder="公司名" type="text" id="companyNameQuery">--%>
                                <%--<input class="form-control" placeholder="开始日期" type="text" id="createDateFrom">--%>
                                <%--<input class="form-control" placeholder="结束日期" type="text" id="createDateTo">--%>
                                <%--<select id="orderLevel" class="form-control">--%>
                                    <%--<option value="" selected="selected">报告类型</option>--%>
                                    <%--<option value="1">数据库报告</option>--%>
                                    <%--<option value="2">完整性报告</option>--%>
                                <%--</select>--%>
                                <%--<select id="orderStatusId" class="form-control">--%>
                                    <%--<option value="" selected="selected">订单状态</option>--%>
                                    <%--<option value="1">制作中</option>--%>
                                    <%--<option value="2">已完成</option>--%>
                                <%--</select>--%>
                                <%--<button type="button" class="btn btn-primary" onclick="query();">搜索</button>--%>
                            <%--</div>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</nav>--%>

        <table id="orderDetailGrid" class="table table-hover table-bordered table-responsive">
            <thead>
            <tr>
                <%--<th data-column-id="id" data-type="numeric" data-order="asc" width="40%" data-visible="false">ID</th>--%>
                <th data-column-id="companyName" data-type="string" data-width="30%">公司名称</th>
                <th data-column-id="countryCnName" data-type="string" data-width="8%">国家</th>
                <th data-column-id="totalPrice" data-formatter="totalPrice" data-type="numeric" data-width="10%">订单价格</th>
                <th data-column-id="orderLevel" data-formatter="orderLevel" data-type="string" data-width="10%">报告类型</th>
                <th data-column-id="orderNo" data-formatter="orderNo" data-type="string" data-width="13%">订单号</th>
                <th data-column-id="orderStatusId" data-formatter="orderStatusId" data-type="string" data-width="10%">订单状态</th>
                <th data-column-id="createDate" data-formatter="createDate" data-type="string" data-width="15%">创建时间</th>
                <%--<th data-column-id="uploadFilePath" data-visible="false">报告url</th>--%>
                <%--<th data-column-id="crefoNo" data-visible="false">crefoNo</th>--%>
                <th data-column-id="operate" data-formatter="operate" data-sortable="false" data-width="20%">下载</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty impDatas}">
                <c:forEach items="${impDatas.rows}"  var="list" varStatus="status">
                    <tr>
                        <td>${list.companyName}</td>
                        <td>${list.countryCnName}</td>
                        <td>CNY&nbsp;${list.totalPrice}</td>
                        <c:if test="${list.orderLevel==1}">
                            <td>数据库报告</td>
                        </c:if>
                        <c:if test="${list.orderLevel==2}">
                            <td>完整性报告</td>
                        </c:if>
                        <c:if test="${list.orderLevel==3}">
                            <td>数据库完整报告</td>
                        </c:if>

                        <td>${list.orderNo}</td>

                        <c:if test="${list.orderStatusId==1}">
                            <td>制作中</td>
                        </c:if>
                        <c:if test="${list.orderStatusId==2}">
                            <td>已完成</td>
                        </c:if>
                        <c:if test="${list.orderStatusId==0}">
                            <td>已取消</td>
                        </c:if>
                        <td>${creatTime}</td>
                        <td>
                            <c:if test="${list.isChinaOrder=='否'}">
                                <a href="${basePath}/simple/customer/requestCompanyDetail.do?companyId=${list.companyNo}&orderDetailId=${list.id}&orderId=${list.orderId}">数据库报告</a>
                            </c:if>
                            <c:if test="${list.isChinaOrder=='是'}">
                                <a href="${basePath}/simple/customer/html/viewReportV1.do?crefoNo=${list.crefoNo}&orderDetailId=${list.id}&orderId=${list.orderId}">数据库报告</a>
                            </c:if>
                            <c:if test="${list.uploadFilePath!=null && list.uploadFilePath!=''}">
                                <a href="${basePath}${list.uploadFilePath}">完整报告</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="${basePath}../include/bottomCommon.jsp"/>

</body>
</html>