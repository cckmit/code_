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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<%=basePath%>frame/favicon.ico">
    <script src="<%=basePath%>frame/easyui/jquery.min.js"></script>
    <link href="<%=basePath%>frame/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=basePath%>frame/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/manager/rechargeList.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="<%=basePath%>css/dashboard.css" rel="stylesheet">

    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/moment.js"></script>

    <link href="<%=basePath%>frame/bootstrap/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>frame/bootstrap/js/bootstrap-dialog.min.js"></script>
    <link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>frame/bootstrap/js/jquery.bootgrid.js"></script>
</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
</script>
<body>
<jsp:include page="${basePath}../include/top.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="${basePath}../include/manager/left.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">充值记录</h2>
            <div class="table-responsive">
                <div class="table-responsive">
                    <table id="grid-data" class="table table-condensed table-hover table-striped">
                        <thead>
                        <tr>
                            <th data-column-id="id" data-type="numeric" data-order="asc">ID</th>
                            <th data-column-id="methodId" data-type="sring">充值方式</th>
                            <th data-column-id="amount" data-type="sring">充值金额</th>
                            <th data-column-id="statusId" data-type="sring">充值状态</th>
                            <th data-column-id="customerId" data-type="sring">客户账号</th>
                            <th data-column-id="createDate" data-formatter="createDate" data-type="sring">充值日期</th>
                            <th data-column-id="operate" data-formatter="operate">操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>