<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<script>
	var basePath = '<%=basePath%>';
	function cartOpen(){
		$('#cartModal').modal('show');
		<%--BootstrapDialog.show({--%>
			<%--message: function(dialog) {--%>
				<%--var $message = $('<div></div>');--%>
				<%--var pageToLoad = dialog.getData('pageToLoad');--%>
				<%--$message.load(pageToLoad);--%>

				<%--return $message;--%>
			<%--},--%>
			<%--data: {--%>
				<%--'pageToLoad': '<%=basePath%>customer/toFastCartList.do'--%>
			<%--}--%>
		<%--});--%>
	}
</script>
<header class="site-header clearfix" style="height:48px">
	<div class="container">

		<div class="row">

			<div class="col-md-12">

				<div class="pull-left logo">
					<a href="#"> <img src="<%=basePath%>images/index/logo.png"
						alt="Medigo by templatemo">
					</a>
				</div>
				<!-- /.logo -->

				<div class="main-navigation pull-right">
					<nav class="main-nav visible-md visible-lg">
					<ul class="nav navbar-nav">
						<li><a href="<%=basePath%>">首页</a></li>
						<li><a href="<%=basePath%>customer/toFastAddOrder.do">快速订购</a></li>
						<li><a href="#" class="dropdown-toggle" data-toggle="dropdown">语言</a>
							<ul class="dropdown-menu">
								<li><a href="#">简体中文</a></li>
								<li><a href="#">繁体中文</a></li>
								<li><a href="#">英&nbsp;语</a></li>
							</ul>
						</li>
						<c:if test="${not empty sessionScope.customerInfo}">
						<li><a href="#" class="dropdown-toggle" data-toggle="dropdown">用户名:${sessionScope.customerInfo.getCode()}</a>
							<ul class="dropdown-menu">	
								<li><a href="<%=basePath%>customer/toCartList.do">我的购物车</a></li>
								<li><a href="<%=basePath%>customer/toOrderList.do">我的订单</a></li>
								<li><a href="<%=basePath%>customer/toOrderDetailList.do">我的报告</a></li>
								<li><a href="<%=basePath%>customer/tochangedInformation.do">我的信息</a></li>
								<li><a href="<%=basePath%>logout.do">注销</a></li>
							</ul></li> 
						</c:if>
						<c:if test="${empty sessionScope.customerInfo}">
								<li><a data-toggle="modal" data-target="#loginModal" href="#">登陆/快速注册</a></li>
						</c:if>
<%--						<li><a href="<%=basePath%>toRegister.do">注册</a></li>						
 --%>					
 							<li><a href="#">帮助</a></li>
 						</ul>
					<!-- /.sf-menu --> </nav>
					
					<!-- /.main-nav -->

					<!-- This one in here is responsive menu for tablet and mobiles -->
					<div class="responsive-navigation visible-sm visible-xs">
						<a href="#nogo" class="menu-toggle-btn"> <i class="fa fa-bars"></i>
						</a>
					</div>
					<!-- /responsive_navigation -->

				</div>
				<!-- /.main-navigation -->

			</div>
			<!-- /.col-md-12 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container --> </header>
		<!-- /.site-header -->

	