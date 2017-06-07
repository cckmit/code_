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
    <script src="<%=basePath%>js/customer/historyList.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="<%=basePath%>css/dashboard.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frame/jquery-ui/jquery-ui.min.css">
    <script type="text/javascript" src="<%=basePath%>frame/jquery-ui/jquery-ui.min.js"></script>
    <!--  PAGINATION plugin -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frame/bootstrap/css/jquery.bs_pagination.min.css">
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/jquery.bs_pagination.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/localization/bs_pagination/en.min.js"></script>
    <!--  FILTERS plugin -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frame/bootstrap/css/jquery.jui_filter_rules.bs.min.css">
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/jquery.jui_filter_rules.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/localization/jui_filter_rules/en.min.js"></script>
    <!--  required from filters plugin -->
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/moment.js"></script>
    <!--  DATAGRID plugin -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frame/bootstrap/css/jquery.bs_grid.min.css">
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/jquery.bs_grid.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/localization/bs_grid/en.min.js"></script>
</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
</script>
<body>
<jsp:include page="${basePath}../include/top.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="${basePath}../include/customer/left.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">我的浏览历史</h2>
            <div class="table-responsive">
                <div id="demo_grid1"></div>
            </div>
        </div>
    </div>
</div>
<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">下载</h4>
            </div>
            <div class="modal-body">
                <div id="result"></div>
                <a id="download" href="">下载</a>   <br>     <br>
                <label id="msg"></label>
                 <a id="downloadmsg" name="downloadmsg" href="" target="_blank"></a>

                <input id="id" type="hidden" name="id" value=""/>
            </div>
            <div class="modal-footer">
            </div>

        </div>
    </div>
</div>
</body>
</html>