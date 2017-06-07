<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="${pageContext.request.contextPath}/frame/favicon.ico">
<!-- Stylesheets -->
<link href="${pageContext.request.contextPath}/frame/Font-Awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/bootstrap/css/bootstrap-dialog.min.css" />
<link href="${pageContext.request.contextPath}/frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/misc.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/bootstrap/css/bootstrap-progressbar-3.3.4.css">
	<!-- 新增css -->

    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/eden.css" media="screen">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myBootstrap.css">

<!-- JavaScripts -->
<script src="${pageContext.request.contextPath}/frame/jquery-1.10.2.min.js"></script>

<script src="${pageContext.request.contextPath}/frame/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/frame/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/frame/bootstrap/js/bootstrap-dialog.min.js"></script>
<script src="${pageContext.request.contextPath}/frame/bootstrap/js/jquery.bootgrid.js"></script>
<script src="${pageContext.request.contextPath}/frame/bootstrap/js/bootstrap-progressbar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/bootstrap/js/moment.js"></script>
<script src="${pageContext.request.contextPath}/frame/jquery.cookie.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/frame/bootstrap/js/bootstrap-suggest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/searchSuggest.js"></script>
<!-- Google Fonts -->
<%--<link href="http://fonts.useso.com/css?family=PT+Serif:400,700,400italic,700itali" rel="stylesheet">--%>
<%--<link href="http://fonts.useso.com/css?family=Raleway:400,900,800,700,500,200,100,600" rel="stylesheet">--%>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<form id="toHelpForm" action="${pageContext.request.contextPath}/help.do" method="post">
	<input type="hidden" id="helpCateId" name="cateId"/>
</form>
<script type="text/javascript">
	var basePath = "<%=basePath%>";
	function toHelp(cateId){
		$("#helpCateId").val(cateId);
		$("#toHelpForm").submit();
	}
</script>
