<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<!-- css -->
<link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/frame/bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/frame/skins/eden.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/frame/Font-Awesome-master/css/font-awesome.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/frame/bootstrap/css/bootstrap-dialog.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
<!-- JavaScripts -->
<script src="${pageContext.request.contextPath}/frame/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/frame/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/frame/bootstrap/js/bootstrap-dialog.min.js"></script>
<script src="${pageContext.request.contextPath}/frame/bootstrap/js/jquery.bootgrid.js"></script>
<script src="${pageContext.request.contextPath}/frame/bootstrap/js/jquery.bootgrid.custom.js"></script>
<script src="${pageContext.request.contextPath}/frame/bootstrap/js/moment.js" type="text/javascript" ></script>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script type="text/javascript">
	var basePath = "<%=basePath%>";
</script>
