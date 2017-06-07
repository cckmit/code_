<%@ page import="com.mika.credit.common.entity.order.OrderStatusEnum" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <jsp:param name="title" value="订单列表"/>
    </jsp:include>
</head>
<body class="mainFrame">
<section>
    <div class="wrapper">
        <section class="panel">
            <header class="panel-heading">
                查询条件
                <button class="btn btn-sm btn-primary" onclick="query();">查询</button>
                <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
            </header>
            <div class="panel-body" style="display: block;">
                <form class="form-horizontal" role="form">
                    <div class="row">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">订单号</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="no" name="no" class="form-control" placeholder="订单号">
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">客户email</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="customerEmail" name="customerEmail" class="form-control" placeholder="客户email">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">是否支付</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="hasPay" name="hasPay" class="input-large form-control">
                                    <option value="">全部</option>
                                    <option value="false">未支付</option>
                                    <option value="true">已支付</option>
                                </select>
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">订单状态</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="status" name="status" class="input-large form-control">
                                    <%=
                                    OrderStatusEnum.getOptionNameCN()
                                    %>
                                    <%--<option value="">全部</option>--%>
                                    <%--<option value="0">取消</option>--%>
                                    <%--<option value="1">待确认</option>--%>
                                    <%--<option value="2">反馈中</option>--%>
                                    <%--<option value="3">制作中</option>--%>
                                    <%--<option value="4">完成</option>--%>
                                </select>
                            </div>
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
                        <input id="id" type="hidden" name="id"/>
                        <table id="grid-data" class="table table-hover general-table">
                            <thead>
                            <tr>
                                <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                                <th data-column-id="no" data-type="string" data-width="15%">订单号</th>
                                <th data-column-id="customerEmail" data-type="string" data-width="10%">客户email</th>
                                <th data-column-id="detailCount" data-type="string" data-width="10%">明细数量</th>
                                <th data-column-id="source" data-formatter="source" data-type="string" data-width="10%">订单来源</th>
                                <th data-column-id="statusNameCN" data-type="string" data-width="8%">状态</th>
                                <th data-column-id="hasPay" data-formatter="hasPay"  data-type="string" data-width="10%">是否支付</th>
                                <th data-column-id="createTime" data-formatter="createTime" data-type="string" data-width="15%">创建日期</th>
                                <th data-column-id="operate" data-formatter="operate" data-type="string" data-width="15%">操作</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </section>
            </div>
        </div>
    </div>

</section>

<div id="detailModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" >
        <div class="modal-content" style="width: 900px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">订单详情</h4>
            </div>
            <div class="modal-body">
                <table id="detailGrid" class="table table-condensed table-hover table-striped">
                    <thead>
                    <tr>
                        <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                        <th data-column-id="companyName" data-type="string" data-width="8%">公司名称</th>
                        <th data-column-id="customerName" data-formatter="customerName" data-type="string" data-width="5%">客户email</th>
                        <th data-column-id="expectTime" data-formatter="expectTime" data-type="string" data-width="6%">交付日期</th>
                        <th data-column-id="price" data-type="float" data-width="3%">应付金额</th>
                        <th data-column-id="priceActual" data-type="float" data-width="3%">实付金额</th>
                        <th data-column-id="isExpress" data-formatter="isExpress" data-width="3%">是否加急</th>
                        <th data-column-id="statusNameCN" data-type="string" data-width="3%">明细状态</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div class="modal-footer">
            </div>

        </div>
    </div>
</div>

<jsp:include page="../include/script.jsp" flush="false"/>

<script src="${pageContext.request.contextPath}/js/core/orderList.js"></script>
</body>
</html>
