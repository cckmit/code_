<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%
	String patd = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ patd + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="../include/include.jsp"/>
    <link href="<%=basePath%>css/dashboard.css" rel="stylesheet">
    <script src="<%=basePath%>js/customer/cartList.js"></script>

    <style type="text/css">
        .filter-con {
            max-width: 200px;
        }
    </style>
</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
</script>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-md-12  main">
            <h2 class="sub-header">我的购物车</h2>
            <div class="table-responsive">
                <table id="grid-data" class="table table-condensed table-hover table-striped">
                    <thead>
                    <tr>
                        <th data-column-id="id" data-type="numeric" data-identifier="true">ID</th>
                        <th data-column-id="countryName" data-type="sring">城市名称</th>
                        <th data-column-id="companyName" data-type="sring">公司名称</th>
                        <th data-column-id="price" data-type="numeric">订单价格</th>
                        <th data-column-id="createDate" data-formatter="createDate" data-type="sring">创建日期</th>
                        <th data-column-id="operate" data-formatter="operate" data-sortable="false">操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../include/customer/recharge.jsp"/>
</body>
</html>