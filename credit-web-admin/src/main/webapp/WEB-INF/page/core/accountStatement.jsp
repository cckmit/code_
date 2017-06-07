<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gavin
  Date: 16-10-31
  Time: 上午10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="对账单列表"/>
    </jsp:include>
    <link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/frame/js/bootstrap-daterangepicker/daterangepicker.css" />
</head>
<body class="mainFrame">
<div class="wrapper">
<section class="panel">
    <header class="panel-heading">
        查询条件
        <button class="btn btn-sm btn-primary" onclick="query();">查询</button>
        <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
    </header>
    <div class="panel-body">
        <form class="form-horizontal" role="form">
            <div class="row">
                <div class="form-group">
                    <label class="col-lg-1 col-sm-2 control-label">订购日期</label>
                    <div id="rangeDate" class="col-md-5 input-group">
                        <input type="text" id="rangeDateValue" class="form-control" readonly>
                        <span style="cursor: pointer" onclick="emptyRangeDate();" class="input-group-addon">清空</span>
                    </div>
                    <input type="hidden" id="queryDateStart">
                    <input type="hidden" id="queryDateEnd">
                </div>
            </div>
        </form>
    </div>
</section>

        <div class="row">
            <div class="col-sm-12">
                <section class="panel">
                    <header class="panel-heading">
                        查询结果
                    </header>
                    <div class="panel-body">
                        <table id="orderDetailGrid" class="table table-hover general-table">
                            <thead>
                            <tr>
                                <th data-column-id="orderId" data-type="numeric" data-order="asc" data-visible="false">订单ID</th>
                                <th data-column-id="companyName" data-width="10%">公司名称</th>
                                <th data-column-id="customerEmail" data-type="string"  data-width="3%">客户email</th>
                                <th data-column-id="productId" data-formatter="productId"  data-width="3%">产品id</th>
                                <th data-column-id="price" data-formatter="price"  data-width="3%">应付金额</th>
                                <th data-column-id="priceActual" data-formatter="priceActual"  data-width="3%">实付金额</th>
                                <th data-column-id="createTime" data-formatter="createTime"  data-width="5%">订购日期</th>
                                <th data-column-id="countryName" data-type="string"  data-width="3%">国家名称</th>
                                <th data-column-id="chargeUserId" data-formatter="chargeUserId"  data-width="3%">负责人</th>
                                <th data-column-id="supplierExpectHour" data-formatter="supplierExpectHour"  data-width="4%">制作期限</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </section>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/script.jsp" flush="false"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/bootstrap-daterangepicker/daterangepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/bootstrap-daterangepicker/daterangepicker-zh_cn.js"></script>
<script src="${pageContext.request.contextPath}/js/core/accountStatement.js"></script>
</body>
</html>
