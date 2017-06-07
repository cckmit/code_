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
	<title>404 - page not found</title>
	<jsp:include page="${basePath}include/manager/include.jsp" flush="true"/>
</head>
<body style="min-height: 100%;height:auto;position: relative;background: #fff;">
<jsp:include page="../page/include/topIndex.jsp"/>
<section style="width: 100%;background: #fff;position:relative;text-align: center;overflow: hidden;">
	<div class="container">
			<img src="<%=basePath%>/images/site/4041.png" alt="" style="width: 1000px;height: auto">
			<%--<p class="nrml-txt">Why not try refreshing you page? Or you can <a href="#">contact our support</a> if the problem persists.</p>--%>
		<a href="#" onclick="javascript:window.history.back();"  style="dispaly:block;width: 150px;height: 40px;text-align: center;line-height: 40px;color: #fff;position: absolute;left: 50%;margin-left: -75px;bottom: 120px;background: #1ABC9C;font-size: 18px;font-weight: bold;box-shadow: 0 5px 5px #8DD9CA">BACK</a>
			<%--<a class="back-btn fxq-back-btn" href="#" onclick="javascript:window.history.back();" > 返回</a>--%>
	</div>
</section>

<footer style="background-color:#ecf0f1;min-width:1200px;position: absolute;bottom: 0;left: 0;" class="col-xs-12">

	<br>
	<div class="container">
		<div class="col-lg-3">
			<div class="bs-component">
				<h5>Head Office</h5>
				<p><strong>Address</strong>:12th Floor, Watts Gallop<br> Tower B, 2816 Yixian Road <br>
					Shanghai 200441, China <br>
					<strong>Phone</strong>: +86.21.3638.6226 <br>
					<strong>Email</strong>: info@cnBIZsearch.com </p>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="bs-component">
				<h5>Europe Office</h5>

				<p><strong>Address</strong>: Route de Gland 32b<br>
					1267 Vich<br>
					Switzerland <br>
					<strong>Phone</strong>: +41.(0)21.824.3777 <br>
					<strong>Email</strong>: europe@cnBIZsearch.com </p>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="bs-component">
				<h5>America Office</h5>

				<p><strong>Address</strong>: P.O. Box 271761 Flower Mound<br>
					TX 75027-1761
					U.S.A<br>
					<strong>Phone</strong>: +1.972.896.8548<br>
					<strong>Email</strong>: usa@3ACredit.com </p>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="bs-component">
				<h5>Website Map</h5>

				<p>About Us<br>
					Credit Info<br>
					Varification<br>
					Business Services<br> Help<br>
				</p>
			</div>
		</div>
		<div style="clear: both"></div>
		<legend></legend>
		<p style="margin-bottom: 20px">Full Search (China)</p>
	</div>
</footer>
</body>
</html>
