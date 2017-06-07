<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="待办事项"/>
    </jsp:include>
</head>
<input id="prodactId" type="hidden" name="prodactId"/>
<body class="mainFrame">
<section>
    <div class="wrapper">
        <input type="hidden" id="orderLevel" value="${param.orderLevel}"/>
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
                                <input type="text" id="orderNo" name="orderNo" class="form-control" placeholder="订单号">
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">客户信息</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="customerName" name="customerName" class="form-control" placeholder="客户信息">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">是否支付</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="isPay" name="isPay" class="input-large form-control">
                                    <option></option>
                                    <option value="否">未支付</option>
                                    <option value="是">已支付</option>
                                </select>
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">订单状态</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="orderStatus" class="input-large form-control">
                                    <option></option>
                                    <option value="0">取消</option>
                                    <option value="1">待确认</option>
                                    <option value="2">反馈中</option>
                                    <option value="3">制作中</option>
                                    <option value="4">完成</option>
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
                        <input type="hidden" name="orderId" id="orderId"/>
                        <table id="grid-data" class="table table-hover general-table">
                            <thead>
                            <tr>
                                <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                                <th data-column-id="orderNo" data-type="string" data-width="20%">订单号</th>
                                <th data-column-id="createDate" data-formatter="createDate" data-type="string" data-width="20%">创建日期</th>
                                <th data-column-id="customerName" data-type="string" data-width="20%">客户</th>
                                <th data-column-id="isPay"  data-type="string" data-width="10%">是否支付</th>
                                <th data-column-id="orderDetailCount" data-type="string" data-width="10%">明细数量</th>
                                <th data-column-id="orderStatus" data-formatter="orderStatus" data-type="string" data-width="100">状态</th>
                                <th data-column-id="operate" data-formatter="operate" data-type="string" data-width="100">操作</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </section>
            </div>
        </div>
    </div>

</section>

<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">pdf上传</h4>
            </div>
            <div class="modal-body">
                <div id="result"></div>
                <input class="btn btn-sm" type="file" id="file" name="file" />
                <input class="btn btn-primary btn-sm" type="button" value="上传" onclick="ajaxFileUpload();"/>
                <input id="id" type="hidden" name="id" value=""/>
            </div>
            <div class="modal-footer">
            </div>

        </div>
    </div>
</div>
<div id="detailModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" style="width: 900px">
        <div class="modal-content">
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
                        <th data-column-id="customerName" data-formatter="customerName" data-type="string" data-width="5%">客户名称</th>
                        <th data-column-id="orderDate" data-formatter="createDate" data-type="string" data-width="6%">订购日期</th>
                        <th data-column-id="orderStatusId" data-formatter="orderStatusId" data-type="string" data-width="3%">订单状态</th>
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

<script src="${pageContext.request.contextPath}/js/core/backlogList.js"></script>
</body>
</html>
