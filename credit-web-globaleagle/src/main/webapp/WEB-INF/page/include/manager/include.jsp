<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="<%=basePath%>frame/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/bootstrap/css/bootstrap-dialog.min.css" />

<script type="text/javascript" src="<%=basePath%>frame/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>frame/jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>frame/jquery.nicescroll.js"></script>
<script type="text/javascript" src="<%=basePath%>frame/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>frame/modernizr.min.js"></script>
<script type="text/javascript" src="<%=basePath%>frame/bootbox.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/manager/manager.js"></script>
<script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/moment.js"></script>
<script src="${pageContext.request.contextPath}/frame/bootstrap/js/bootstrap-dialog.min.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script type="text/javascript" src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script type="text/javascript" src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<link href="<%=basePath%>css/manager/manager.css" rel="stylesheet">

