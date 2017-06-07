<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%;min-height: 100%;">
<head>
	<title>Full Search - 500 - there is an error</title>
	<jsp:include page="include/include.jsp"/>
</head>
<style>
	.navbar-default .navbar-nav > li > a{
		color: #fff;
	}
	.navbar-default .navbar-nav > li > a:hover, .navbar-default .navbar-nav > li > a:focus{
		color: #18bc9c;
	}
</style>
<body style="min-height: 100%;height:auto;position: relative;background: #fff;">
<jsp:include page="${basePath}include/topIndex.jsp"/>
<section style="width: 100%;background: #fff;text-align: center;overflow: hidden;" >
	<div class="container" style="position:relative;width: 1140px;height: 400px;overflow: hidden;">
		<img src="<%=basePath%>/images/site/5001.png" alt="" style="width: 1000px;height: auto;margin-top:-70px;">
		<%--<p class="nrml-txt">Why not try refreshing you page? Or you can <a href="#">contact our support</a> if the problem persists.</p>--%>
		<a href="#" onclick="javascript:window.history.back();"  style="dispaly:block;width: 150px;height: 40px;text-align: center;line-height: 40px;color: #fff;position: absolute;left: 50%;margin-left: -75px;bottom: 0px;background: #1ABC9C;font-size: 18px;font-weight: bold;box-shadow: 0 5px 5px #8DD9CA">BACK</a>
		<%--<a class="back-btn fxq-back-btn" href="#" onclick="javascript:window.history.back();" > 返回</a>--%>
	</div>
</section>

<jsp:include page="${basePath}include/bottom.jsp"/>

</body>
</html>
