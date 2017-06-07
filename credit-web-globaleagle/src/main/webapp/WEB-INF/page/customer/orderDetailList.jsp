<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.mika.credit.common.entity.order.OrderDetailStatusEnum" %>
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
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.min.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.theme.min.css">--%>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.min.js"></script>--%>
    <script type="text/javascript" src="<%=basePath%>/js/customer/orderDetailList.js"></script>

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

    <div id="banner">
        <div class="container">
        <p class="lead">报告管理</p>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">筛选</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input class="form-control" placeholder="公司名" type="text" id="companyNameQuery">
                                <%--<input class="form-control" placeholder="开始日期" type="text" id="createDateFrom">--%>
                                <%--<input class="form-control" placeholder="结束日期" type="text" id="createDateTo">--%>
                                <select id="productId" class="form-control">
                                    <option value="" selected="selected">报告类型</option>
                                    <option value="1">数据库报告</option>
                                    <option value="2">数据库完整报告</option>
                                    <option value="3">完整版报告</option>
                                    <option value="4">完整版报告-加急</option>
                                </select>
                                <select id="status" class="form-control">
                                    <%=
                                    OrderDetailStatusEnum.getOptionNameCN()
                                    %>
                                    <%--<option value="" selected="selected">订单状态</option>--%>
                                    <%--<option value="1">制作中</option>--%>
                                    <%--<option value="2">已完成</option>--%>
                                </select>
                                <button type="button" class="btn btn-primary" onclick="query();">搜索</button>
                            </div>
                        </form>
                    </div>
                </div>
            </nav>

        <table id="orderDetailGrid" class="table table-hover table-bordered table-responsive">
            <thead>
            <tr>
                <th data-column-id="id" data-type="numeric" data-order="asc" width="40%" data-visible="false">ID</th>
                <th data-column-id="companyName" data-type="string" data-width="32%">公司名称</th>
                <th data-column-id="countryName" data-type="string" data-width="8%">国家</th>
                <th data-column-id="productId" data-formatter="productId"  data-type="string" data-width="12%">报告类型</th>
                <th data-column-id="createTime" data-formatter="createTime" data-type="string" data-width="18%">下单日期</th>
                <th data-column-id="statusNameCN" data-type="string" data-width="8%">状态</th>
                <th data-column-id="operate" data-formatter="operate" data-sortable="false" data-width="23%">下载</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="${basePath}../include/bottomCommon.jsp"/>

</body>
</html>