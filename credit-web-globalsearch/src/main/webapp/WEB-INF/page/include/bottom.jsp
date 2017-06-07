<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<div style="width: 100%;height: 270px;"></div>
<footer style="background-color:#ecf0f1;min-width:1200px;" class="col-xs-12">
	<br>
	<div class="container" style="position: relative;">
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
				<h5>US Office </h5>

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
				<p class="fxq-footer-a">
					<a href="<%=basePath%>toIndexAddition8.do">About Us</a>
					<a href="<%=basePath%>toIndexAddition9.do">Business Verification</a>
					<a href="<%=basePath%>toIndexAddition10.do">Monitoring</a>
					<a href="<%=basePath%>toIndexAddition11.do">O2C Solutions</a>
					<a href="<%=basePath%>help.do">Help</a>
				</p>

			</div>
		</div>
		<div style="clear: both"></div>
		<%--<legend></legend>--%>
		<div style="padding: 11px 0;overflow: hidden;border-top: 1px solid #DEDEDE;height: 60px;font-size: 13px;margin-bottom: 10px;">
			<div style="float: left;">
				<%--Developed by 3Acredit<br>--%>
				Copyright 2017 cnBIZsearch.com All Rights Reserved
			</div>
			<div style="float: right;line-height: 38px;">
				<a href="<%=basePath%>toBottom1.do" style="text-decoration: none;font-size: 13px;">Online Disclaimer</a>&nbsp;|&nbsp;
				<a href="<%=basePath%>toBottom2.do" style="text-decoration: none;font-size: 13px;">Copyright Policy</a>&nbsp;|&nbsp;
				<a href="<%=basePath%>toBottom3.do" style="text-decoration: none;font-size: 13px;">Privacy Policy</a>&nbsp;|&nbsp;
				<a href="<%=basePath%>toBottom4.do" style="text-decoration: none;font-size: 13px;">Terms of Use Agreement</a>
			</div>
		</div>
	</div>
</footer>




