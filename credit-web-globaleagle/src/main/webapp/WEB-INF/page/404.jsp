<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>404 - 找不到页面</title>
	<jsp:include page="${basePath}include/manager/include.jsp" flush="true"/>
</head>
<body class="error-page">
<section>
	<div class="container ">
		<section class="error-wrapper text-center">
			<h1><img alt="" src="<%=basePath%>images/site/404-error.png"></h1>
			<h2>出错了</h2>
			<h3>找不到要访问的页面</h3>
			<a class="back-btn" href="#" onclick="javascript:window.history.back();"> 返回</a>
		</section>

	</div>
</section>
</body>
</html>
