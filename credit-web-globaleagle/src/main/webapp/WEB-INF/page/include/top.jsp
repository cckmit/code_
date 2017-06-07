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
	function cartOpen() {
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
<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a href="<%=basePath%>" class="navbar-brand" style="font-size:18px;font-family:'Microsoft Yahei';">Global Eagle 全球鹰</a>
			<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse" id="navbar-main">

			<ul class="nav navbar-nav fixMuBan">

				<li id="indexLi"><a href="<%=basePath%>" style="background-color: none;">首页</a></li>
				<li><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="background: none;font-size: 14px;font-family:'Microsoft Yahei';">信用服务<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<%=basePath%>toIndexAddition1.do"  style="font-size:14px;font-family:'Microsoft Yahe';">实地认证服务</a></li>
						<li><a href="<%=basePath%>toIndexAddition2.do"  style="font-size:14px;font-family: 'Microsoft Yahei';">全球应收帐管理</a></li>
						<li><a href="<%=basePath%>toIndexAddition3.do"  style="font-size:14px;font-family: 'Microsoft Yahei';">当地司法服务</a></li>
						<li><a href="<%=basePath%>toIndexAddition4.do"  style="font-size:14px;font-family: 'Microsoft Yahei';">尽职调查服务</a></li>
						<li><a href="<%=basePath%>toIndexAddition5.do"  style="font-size:14px;font-family: 'Microsoft Yahei';">商业咨询服务</a></li>
						<li><a href="<%=basePath%>toIndexAddition6.do"  style="font-size:14px;font-family: 'Microsoft Yahei';">数据对接服务</a></li>

					</ul></li>
				<li id="fastAddLi"><a href="<%=basePath%>user/toFastAddOrder.do" style="background: none;font-size: 14px;font-family:'Microsoft Yahei';">快速订购</a></li>
				<li id="helpLi"><a href="<%=basePath%>help.do" style="background: none;font-size: 14px;font-family:'Microsoft Yahei';">帮助</a></li>
				<c:if test="${empty sessionScope.customerInfo}">
					<li id="loginLi"><a href="<%=basePath%>toLogin.do" style="background: none;font-size: 14px;font-family:'Microsoft Yahei';">注册/登陆</a></li>
					<%--<li class="active"><a data-toggle="modal" data-target="#loginModal" href="#">登陆/快速注册</a></li>--%>
				</c:if>
				<c:if test="${not empty sessionScope.customerInfo}">
					<li id="userLi" class="ative"><a href="#"
													 class="dropdown-toggle" data-toggle="dropdown">用户：${sessionScope.customerInfo.getCode()}</a>
						<ul class="dropdown-menu">
							<%--<li><a href="<%=basePath%>user/toCartList.do">我的购物车</a></li>--%>
							<li><a href="<%=basePath%>customer/toOrderList.do">我的订单</a></li>
							<li><a href="<%=basePath%>customer/toOrderDetailList.do">我的报告</a></li>
							<li><a href="<%=basePath%>customer/toStatement.do">我的对账单</a></li>
							<li><a href="<%=basePath%>customer/tochangedInformation.do">个人信用信息
							<c:if test="${sessionScope.customerInfo.checkStatus=='是'}">
								<i class="fa fa-check-square" style="color: green"></i>
							</c:if>
							</a></li>
							<li><a href="<%=basePath%>toApproveCompany.do">企业信用名片</a></li>
							<li><a href="<%=basePath%>logout.do">注销</a></li>
						</ul></li>
				</c:if>
				<%-- <li><a href="<%=basePath%>toRegister.do">注册</a></li> --%>




			</ul>

		</div>

	</div>
	<%--<marquee style="color:yellow">本网站将于2016年12月21日14：00进行数据更新，届时服务全部停止，给您带来的不便敬请谅解！</marquee>--%>

</div>

<%-- <header class="site-header clearfix" style="height:48px">
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
						<li><a href="<%=basePath%>toFastAddCart.do">快速订购</a></li>
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
						<li><a href="<%=basePath%>toRegister.do">注册</a></li>

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
<c:if test="${not empty sessionScope.customerInfo}">
<div  class="shoppingIcon">
	<a href="#" onclick="cartOpen();"><img src="<%=basePath%>images/shopping_cart.png" alt="">
		<c:if test="${sessionScope.cartCount>0}">
			<span id="cartCount" class="badge badge-success" style="background-color: #00a8d6">
				${sessionScope.cartCount}
			</span>
		</c:if>
	</a>
</div>
</c:if> --%>

<div id="loginModal" class="modal fade" tabindex="-1" role="dialog"
	 aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header row">
				<div class="col-md-12">
					<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel2">登陆注册</h4>
				</div>
			</div>

			<div class="modal-body row">
				<div class="col-md-6">
					<div class="well bs-component">
						<form class="form-horizontal" action="<%=basePath%>register.do">
							<fieldset>
								<legend>非会员快速注册</legend>

								<div class="form-group">
									<div class="col-lg-12">
										<input class="form-control" type="text" name="code"
											   placeholder="用户名" required autofocus>
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-12">
										<input class="form-control" placeholder="密码" type="password"
											   name="passwd" placeholder="密码" required>
									</div>
								</div>
								<div class="form-group"></div>
								<div class="form-group">
									<div class="col-lg-10 col-lg-offset-2">
										<button type="submit" class="btn btn-danger">现在注册</button>
										<br />
										<br />
										<p class="text-danger">注册成会员，获取更优惠价格及更好的服务</p>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
				<div class="col-md-5">
					<div class=" bs-component">
						<form class="bs-component" action="<%=basePath%>/login.do"
							  method="post">
							<fieldset>
								<legend>会员登录</legend>
								<label style="color: #ff0000;">${message}</label>
								<div class="form-group">
									<input class="form-control" id="code" name="code" type="text"
										   placeholder="用户名" required autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" id="passwd" name="passwd"
										   placeholder="密码" required type="text">
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary">会员登入</button>
								</div>
							</fieldset>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

<div id="cartModal" class="modal fade" tabindex="-1" role="dialog"
	 aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header row">
				<div class="col-md-12"></div>
			</div>
			<div class="modal-body row">
				<div class="col-sm-12 col-md-12  main">
					<h4 class="sub-header">我的购物车</h4>
					<button class='btn btn-sm btn-primary' onclick='addOrder();'>下单</button>
					<div class="table-responsive">
						<table id="grid-data"
							   class="table table-condensed table-hover table-striped">
							<thead>
							<tr>
								<th data-column-id="id" data-type="numeric"
									data-identifier="true">ID</th>
								<th data-column-id="countryName" data-type="sring">城市名称</th>
								<th data-column-id="companyName" data-type="sring">公司名称</th>
								<th data-column-id="price" data-type="numeric">订单价格</th>
								<th data-column-id="createDate" data-formatter="createDate"
									data-type="sring">创建日期</th>
								<th data-column-id="operate" data-formatter="operate"
									data-sortable="false">操作</th>
							</tr>
							</thead>
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
