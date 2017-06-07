<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="frame/favicon.ico">
	<script src="frame/easyui/jquery.min.js"></script>
	<link href="frame/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="frame/bootstrap/js/bootstrap.min.js"></script>
	<link href="<%=basePath%>css/signin.css" rel="stylesheet">
	<script src="<%=basePath%>js/customer/orderConfirm.js"></script>
	<link href="<%=basePath%>frame/bootstrap/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css" />
	<script src="<%=basePath%>frame/bootstrap/js/bootstrap-dialog.min.js"></script>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<script>
	var basePath = "<%=basePath%>";
	var dbprice = "${price.getDbprice()}";
	var newprice = "${price.getNewprice()}";
	var companyNo = "${companyInfoId}";
	var companyName = "${campanyName}";
	var countryId = "${countryId}";
</script>
<body>
<div class="container">
	<div class="form-signin">
		<label>搜索国家:${countrySel}</label> <BR><BR>
		<label>搜索公司名:${campanyName}</label><BR><BR>
<%-- 		<label>公司名:${companyInfo.getName()}. </label>--%>		
		<label>注册号：${registrationNumber} &nbsp 状态：${status}</label><BR>					
		<label>城市：${city}</label><BR>
		<label>街道：${street}   </label><BR>
		<form class="form-signin" action="<%=basePath%>nortoAddCart.do"
								method="post" onsubmit="return checkForm();">
			<div class="btn-group">
				<button type="button" name="chooseData" class="btn btn-default" onclick="changePrice(1);">数据库信息</button>
				<button type="button" name="chooseData" class="btn btn-default" onclick="changePrice(2);">最新信息</button>
				<input type="hidden" id="orderLevel" name="orderLevel" value="1">
			</div>
			<br><br>
			<label>价格:</label><label id="price"></label><br>
<!-- 			<button class="btn btn-sm btn-primary" onclick="addCart();">加入购物车</button>
 -->			
 			<input class="btn btn-sm btn-primary" type="submit" value="加入购物车">
			<input type="hidden" value="${companyInfoId}" name="companyNo">
			<input type="hidden" value="${companyRName}" name="companyName">
			<input type="hidden" value="${countryId}" name="countryId">
			
			<button class="btn btn-sm btn-primary" onclick="addOrder();">下单</button>
			</form>
		</div>

</div>
</body>
</html>