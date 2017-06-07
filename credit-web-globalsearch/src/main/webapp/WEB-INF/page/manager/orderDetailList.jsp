<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Full Search - OrderDetailList</title>
    <jsp:include page="${basePath}../include/manager/include.jsp" flush="true"/>
    <link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>frame/bootstrap/js/jquery.bootgrid.js"></script>
    <script src="<%=basePath%>js/manager/orderDetailList.js"></script>
    <link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/fileinput.css">
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/fileinput.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/localization/fileinput/zh.js"></script>
    <script src="<%=basePath%>js/ajaxfileupload.js"></script>
</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    var orderLevel = "${orderLevel}";
    var orderStatusId = "${orderStatusId}";
    $(document).ready(function () {
        $("#orderDetailLi").addClass("nav-active");
        if(orderLevel == 2 && orderStatusId == 1)
            $("#orderDetailListLi1").addClass("active");
        else
            $("#orderDetailListLi2").addClass("active");
    });
</script>
<body class="sticky-header">
<section>
    <jsp:include page="${basePath}../include/manager/left.jsp" flush="true"/>
    <div class="main-content">
        <jsp:include page="${basePath}../include/manager/top.jsp" flush="true"/>
        <!-- page heading start-->
        <div class="page-heading">
            <ul class="breadcrumb">
                <li>订单管理</li>
                <li class="active">未处理订单</li>
            </ul>
        </div>
        <!-- page heading end-->
        <!--body wrapper start   主体内容放在wrapper层内-->
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
                            <label class="col-lg-1 col-sm-2 control-label">公司名称</label>
                            <div class="col-lg-5 col-sm-4">
                                <input type="text" id="companyName" name="companyName" class="form-control" placeholder="公司名称">
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">城市</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="countryId" class="input-large form-control">
                                </select>
                            </div>
                        </div>
                        </div>
                        <div class="row">
                        <div class="form-group">
                            <label class="col-lg-1 col-sm-2 control-label">订单类型</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="orderLevel" class="input-large form-control">
                                    <option></option>
                                    <option value="1">数据库报告</option>
                                    <option value="2">完整报告</option>
                                </select>
                            </div>
                            <label class="col-lg-1 col-sm-2 control-label">订单状态</label>
                            <div class="col-lg-5 col-sm-4">
                                <select id="orderStatusId" class="input-large form-control">
                                    <option></option>
                                    <option value="1">制作中</option>
                                    <option value="2">已完成</option>
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
                            <table id="grid-orderDetail" class="table table-hover general-table">
                                <thead>
                                <tr>
                                    <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                                    <th data-column-id="countryId" data-type="numeric"  data-visible="false">国家ID</th>
                                    <th data-column-id="companyName" data-type="string" data-width="30%">公司名称</th>
                                    <th data-column-id="countryCnName"  data-type="string" data-width="10%">国家名称</th>
                                    <th data-column-id="orderLevel" data-formatter="orderLevel" data-type="string" data-width="10%">订单类型</th>
                                    <th data-column-id="customerName"  data-type="string" data-width="20%">客户信息</th>
                                    <th data-column-id="createDate" data-formatter="createDate" data-type="string" data-width="10%">下单时间</th>
                                    <th data-column-id="orderStatusId" data-formatter="orderStatusId" data-type="string" data-width="100">报告状态</th>
                                    <th data-column-id="operate" data-formatter="operate" data-type="string" data-width="80">操作</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        <jsp:include page="${basePath}../include/manager/bottom.jsp" flush="true"/>
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
                <input id="uploadOrderDetailId" type="hidden" name="id" value=""/>
                <%--<div id="result"></div>--%>
                <%--<input class="btn btn-sm" type="file" id="file" name="file" />--%>
                <%--<input class="btn btn-primary btn-sm" type="button" value="上传" onclick="ajaxFileUpload();"/>--%>
                    <input id="file" type="file" name="file" class="file" data-allowed-file-extensions='["pdf","doc","docx"]'>
            </div>
            <div class="modal-footer">
            </div>

        </div>
    </div>
</div>

</body>
</html>
