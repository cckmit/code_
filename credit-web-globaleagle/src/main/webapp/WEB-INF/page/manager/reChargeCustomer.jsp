<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="${basePath}../include/manager/include.jsp" flush="true"/>
    <title>客户管理</title>
    <script type="text/javascript">
        var basePath = "<%=basePath%>";
        $(document).ready(function () {
            $("#reCharge").addClass("nav-active");
            $("#reChargeCustomer").addClass("active");
        });
    </script>
    <link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/jquery.bootgrid.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/bootstrapValidator.min.js"></script>
    <link type="text/css" src="<%=basePath%>frame/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet" />
    <script type="text/javascript" src="<%=basePath%>js/manager/reChargeCustomer.js"></script>
    <style type="text/css">
        .selRegion button {
            margin-left: 20px;
        }
        #countryForm input {
            width: 150px;
        }
    </style>
</head>

<body class="sticky-header">

<section>
    <jsp:include page="${basePath}../include/manager/left.jsp" flush="true"/>
    <div class="main-content">
        <jsp:include page="${basePath}../include/manager/top.jsp" flush="true"/>
        <!-- page heading start-->
        <div class="page-heading">
            <ul class="breadcrumb">
                <li>充值管理</li>
                <li class="active">用户充值</li>
            </ul>
        </div>
        <!-- page heading end-->
        <!--body wrapper start   主体内容放在wrapper层内-->
        <div class="wrapper">

            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            客户管理
                        </header>
                        <div class="panel-body">
                            <table id="grid-data" class="table-hover general-table">
                                <thead>
                                <tr>
                                    <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                                    <th data-column-id="email" data-width="20%" data-type="string">登陆名</th>
                                    <th data-column-id="name" data-width="20%" data-type="string">姓名</th>
                                    <th data-column-id="createTime" data-width="20%" data-formatter="formatCreateTime">账号建立日期</th>
                                    <th data-column-id="levelId" data-width="10%" data-type="string" data-formatter="level">客户等级</th>
                                    <th data-column-id="balance" data-width="10%" data-type="float">余额</th>
                                    <th data-column-id="operate" data-width="20%" data-formatter="operate" data-sortable="false">操作</th>
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




<div id="customerModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content"  style="width:920px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="countryModalLabel">充值页面</h4>
            </div>
            <div class="modal-body">
                <form id="countryForm1" class="form-horizontal" role="form">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="email" name="email" disabled>
                        </div>
                        <label for="balance" class="col-sm-2 control-label">充值金额</label>
                        <div class="col-sm-4">
                            <input type="number" class="form-control" id="balance" name="balance" placeholder="金额" min="1" max="8">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-center">
                            <button class="btn btn-sm btn-primary" id="isEnable" type="button" disabled></button>
                            <button class="btn btn-sm btn-primary" id="hasNoCheck" type="button" onclick="reChargeCustomer();">确定充值</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

</body>
</html>
