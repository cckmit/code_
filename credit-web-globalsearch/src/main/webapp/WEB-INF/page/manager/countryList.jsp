<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
    String  orderStatusId = "";
    if(request.getParameter("orderStatusId")!=null){
        orderStatusId = request.getParameter("orderStatusId");
    }
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
    <script src="<%=basePath%>js/manager/customerList.js"></script>
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
            <h2 class="sub-header">城市管理</h2>
            <div class="table-responsive">
                <table id="grid-data" class="table table-condensed table-hover table-striped">
                    <thead>
                    <tr>
                        <th data-column-id="id" data-type="numeric" data-order="asc">ID</th>
                        <th data-column-id="cnName" data-type="sring">中文名</th>
                        <th data-column-id="enName" data-type="sring">英文名</th>
                        <th data-column-id="onlineOrderPrice" data-type="sring">数据库信息价格</th>
                        <th data-column-id="offlineOrderPrice" data-type="sring">最新报告价格</th>
                        <th data-column-id="operate" data-formatter="operate" data-sortable="false">操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div><div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">用户信息管理</h4>
            </div>
            <div class="modal-body">
                <div class="form-signin" >
                    <div class="row">
                        <input type="hidden" id="id" name="id" value="" >
                        <label class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-4">
                            <input type="text" id="code" name="code" class="form-control" value="" disabled>
                        </div>
                    </div>
                    <div class="row">
                        <label for="name" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-4">
                            <input type="text" id="name" name="name" class="form-control col-sm-2" value="">
                        </div>
                    </div>
                    <div class="row">
                        <label for="idcard" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-4">
                            <input type="text" id="idcard" name="name" class="form-control col-sm-2" value="">
                        </div>
                    </div>
                    <div class="row">
                        <label for="phone" class="col-sm-2 control-label">手机号</label>
                        <div class="col-sm-4">
                            <input type="text" id="phone" name="name" class="form-control col-sm-2" value="">
                        </div>
                    </div>
                    <div class="row">
                        <label for="addr" class="col-sm-2 control-label">地址</label>
                        <div class="col-sm-4">
                            <input type="text" id="addr" name="name" class="form-control col-sm-2" value="">
                        </div>
                    </div>
                    <div class="row">
                        <label for="email" class="col-sm-2 control-label">e-mail</label>
                        <div class="col-sm-4">
                            <input type="text" id="email" name="name" class="form-control col-sm-2" value="">
                        </div>
                    </div>
                    <div class="row">
                        <label for="sex" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-4">
                            <input type="text" id="sex" name="name" class="form-control col-sm-2" value="">
                        </div>
                    </div>
                    <div class="row">
                        <label for="mobile" class="col-sm-2 control-label">手机</label>
                        <div class="col-sm-4">
                            <input type="text" id="mobile" name="birthday" class="form-control" value="">
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-4" style="text-align: center">
                            <button class="btn btn-primary btn-mid" onclick="modify();">提交</button>
                        </div></div>
                </div>
            </div>
            <div class="modal-footer">
            </div>

        </div>
    </div>
</div>
</body>
</html>
