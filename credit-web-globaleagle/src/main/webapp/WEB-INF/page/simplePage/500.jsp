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
	<title>500 - 出错了</title>
	<jsp:include page="${basePath}include/manager/include.jsp" flush="true"/>
</head>
<body class="error-page">
<section>
	<div class="container ">
		<section class="error-wrapper text-center">
			<h1><img alt="" src="<%=basePath%>images/site/500-error.png"></h1>
			<h2>啊哦!!!</h2>
			<h3>看起来出错了.</h3>
			<%--<p class="nrml-txt">Why not try refreshing you page? Or you can <a href="#">contact our support</a> if the problem persists.</p>--%>
			<a class="back-btn" href="#" onclick="javascript:window.history.back();"> 返回</a>
		</section>

	</div>
</section>
</body>
</html>
