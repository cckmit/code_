<%@ page import="com.mika.credit.common.entity.order.OrderStatusEnum" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gavin
  Date: 16-10-31
  Time: 上午10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String  productType = "";
    if(request.getParameter("productType")!=null){
        productType = request.getParameter("productType");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="订单列表"/>
    </jsp:include>
    <script type="text/javascript">
        var basePath = "<%=basePath%>";
        var productType = "<%=productType%>";
//        $(document).ready(function () {
//
//        });
    </script>
</head>
<body class="mainFrame">
<section>
    <div class="wrapper">
        <input type="hidden" id="orderLevel" value="${param.orderLevel}"/>
        <%--<input type="hidden" id="productType" name="productType" value="${requestScope.productType}">--%>
        <section class="panel">
            <header class="panel-heading">
                查询条件
                <button class="btn btn-sm btn-primary" onclick="queryOrderDetail();">查询</button>
                <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                    </span>
            </header>
            <div class="panel-body" style="display: block;">
                <form class="form-horizontal" role="form">
                    <div class="row">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">公司名称</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="companyName" name="companyName" class="form-control" placeholder="公司名称">
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">客户email</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="customerEmail" name="customerEmail" class="form-control" placeholder="客户email">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">订单状态</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="status" name="status" class="input-large form-control">
                                    <%=
                                    OrderStatusEnum.getOptionNameCN()
                                    %>
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
                        <table id="orderDetailGrid" class="table table-hover general-table">
                            <thead>
                            <tr>
                                <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                                <th data-column-id="companyName" data-type="string" data-width="20%">公司名称</th>
                                <th data-column-id="customerEmail" data-type="string" data-width="10%">客户email</th>
                                <th data-column-id="statusNameCN" data-type="string" data-width="10%">状态</th>
                                <th data-column-id="priceActual" data-type="float" data-width="10%">实付金额</th>
                                <th data-column-id="isExpress" data-formatter="isExpress" data-width="10%">是否加急</th>
                                <th data-column-id="createTime" data-formatter="createTime" data-type="string" data-width="15%">订购日期</th>
                                <th data-column-id="operate" data-formatter="operate" data-type="string" data-width="20%">操作</th>
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
                <input class="btn btn-sm" type="file" id="file" name="multfile" />
                <input class="btn btn-primary btn-sm" type="button" value="上传" onclick="ajaxFileUpload();"/>
                <input id="id" type="hidden" name="id" value=""/>
            </div>
            <div class="modal-footer">
            </div>

        </div>
    </div>
</div>
<jsp:include page="../include/script.jsp" flush="false"/>

<script src="${pageContext.request.contextPath}/js/core/orderDetailList.js"></script>
<script src="<%=basePath%>/js/ajaxfileupload.js"></script>
</body>
</html>
