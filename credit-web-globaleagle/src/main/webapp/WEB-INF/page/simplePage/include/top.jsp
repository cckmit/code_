<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
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
	}
</script>
<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a href="<%=basePath%>" class="navbar-brand">Global Eagle 全球鹰</a>
			<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse" id="navbar-main">

			<ul class="nav navbar-nav fixMuBan">

				<li id="indexLi"><a href="<%=basePath%>simple/index.do">首页</a></li>
				<c:if test="${empty sessionScope.customerInfo}">
					<li id="loginLi"><a href="<%=basePath%>simple/toLogin.do">注册/登陆</a></li>
				</c:if>
				<c:if test="${not empty sessionScope.customerInfo}">
					<li id="userLi" class="ative"><a href="#"
													 class="dropdown-toggle" data-toggle="dropdown">用户：${sessionScope.customerInfo.getEmail()}</a>
						<ul class="dropdown-menu">
							<li><a href="<%=basePath%>simple/user/toCartList.do">我的购物车</a></li>
							<li><a href="<%=basePath%>simple/customer/orderList.do">我的订单</a></li>
							<li><a href="<%=basePath%>simple/customer/orderDetailList.do">我的报告</a></li>
							<li><a href="<%=basePath%>simple/customer/tochangedInformation.do">个人信用信息
							<c:if test="${sessionScope.customerInfo.checkStatus=='是'}">
								<i class="fa fa-check-square" style="color: green"></i>
							</c:if>
							</a></li>
							<li><a href="<%=basePath%>simple/logout.do">注销</a></li>
						</ul></li>
				</c:if>

			</ul>

		</div>

	</div>

</div>

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
