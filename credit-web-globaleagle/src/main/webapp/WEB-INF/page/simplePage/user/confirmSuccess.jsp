<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>全球鹰-订单状态</title>
	<jsp:include page="../include/include.jsp"/>
	<script type="text/javascript">
		function toPage(i){
			//1返回购物车
			if (i==1) {
				window.location.href="${pageContext.request.contextPath}/customer/toOrderDetailList.do";
			}else if(i==2){
				window.location.href="${pageContext.request.contextPath}/customer/toSearchList.do";
			}else if(i==3){
				window.location.href="${pageContext.request.contextPath}/customer/toOrderList.do";
			}else if(i==4){
				window.location.href="${pageContext.request.contextPath}/user/toCartList.do";
			}
		}
		var test=$("#downLoadData").html();
		function download() {
			export_raw('商安信订单收据.html', test);
		}
		function export_raw(name, data) {
			var urlObject = window.URL || window.webkitURL || window;

			var export_blob = new Blob([data],{type:"text/plain"});

			var save_link = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
			save_link.href = urlObject.createObjectURL(export_blob);
			save_link.download = name;
			fake_click(save_link);
		}
		function fake_click(obj) {
			var ev = document.createEvent("MouseEvents");
			ev.initMouseEvent(
					"click", true, false, window, 0, 0, 0, 0, 0
					, false, false, false, false, 0, null
			);
			obj.dispatchEvent(ev);
		}
		function preview() {
			var orderId = "${order.getId()}"
			window.open("${pageContext.request.contextPath}/customer/toReceiptDown.do?orderId="+orderId);
//			bdhtml = window.document.body.innerHTML;
//			sprnstr = "<!--startprint-->";
//			eprnstr = "<!--endprint-->";
//			prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17);
//			prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));
//			window.print();
		}
		function download(prnhtml) {
			export_raw('商安信订单收据.html', prnhtml);
		}

		function  showReport(companyNo,id,orderId) {
			window.open( basePath+'/customer/requestCompanyDetail.do?companyId='+companyNo+'&orderDetailId='+id+'&orderId='+orderId);
		}

		function  showReportChina(crefoNo,id,orderId) {
			window.open(basePath+'/customer/html/viewReportV1.do?crefoNo='+crefoNo+'&orderDetailId='+id+'&orderId='+orderId);
		}
	</script>
</head>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/><br>
<div id="banner">
	<div class="container">
		<div class="well bs-component">
			<legend>订购状态</legend>				<div class="row">

			<!--startprint-->
			<div class="col-lg-12" id="downLoadData">
				<h3 class="text-center">${msg}&nbsp;&nbsp;
					<c:if test="${msg=='支付成功'}">
						<a style=" width:80px;height: 30px" href="<%=basePath%>simple/customer/toReceiptDown.do?orderId=${orderId}">收据信息</a>
					</c:if>
				</h3>
				<br>

				<c:if test="${not empty order}">
					<p><h4>订单信息:</h4>
					订单编号:<strong>${order.orderNo}</strong>&nbsp;&nbsp;
					订单总额为
					<strong> ${order.getPrice()}</strong>
					&nbsp;&nbsp;订单数量为
					<strong>
							${order.getOrderDetailCount()}</strong>
					</p>
					<br/>
					<c:if test="${order.getOrderDetails().size()>=0}">
						<h4>订单明细:</h4>
						<table class="table table-hover general-table">
							<thead>
							<tr>
								<td>国家</td>
								<td>公司名</td>
								<td>总价格</td>
							</tr>
							</thead>
							<c:forEach var="orderDetails" items="${order.getOrderDetails()}" varStatus="status">
							<tbody>
							<tr>
								<td>
										${orderDetails.getCountryCnName()}
								</td>
								<td>
										${orderDetails.getCompanyName()}
								</td>
								<td>
										${orderDetails.getTotalPrice()}
								</td>
								<td>
									<%--<c:if test="${orderDetails.orderLevel!='2'}">--%>
									<%--<c:if test="${orderDetails.isChinaOrder=='否'}">--%>
										<%--<button class="btn btn-xs btn-primary" onclick="showReport('${orderDetails.companyNo}',${orderDetails.id},${orderDetails.orderId});">--%>
											<%--<c:if test="${orderDetails.orderLevel == '1'}">--%>
												<%--数据库报告--%>
											<%--</c:if>--%>
											<%--<c:if test="${orderDetails.orderLevel=='3'}">--%>
												<%--数据库完整报告--%>
											<%--</c:if>--%>
										<%--</button>--%>
									<%--</c:if>--%>
									<%--<c:if test="${orderDetails.isChinaOrder=='是'}">--%>
										<%--<button class="btn btn-xs btn-primary" onclick="showReportChina(${orderDetails.crefoNo},${orderDetails.id},${orderDetails.orderId});">--%>
											<%--<c:if test="${orderDetails.orderLevel == '1'}">--%>
												<%--数据库报告--%>
											<%--</c:if>--%>
											<%--<c:if test="${orderDetails.orderLevel=='3'}">--%>
												<%--数据库完整报告--%>
											<%--</c:if>--%>
										<%--</button>--%>
									<%--</c:if>--%>
									<%--</c:if>--%>
								</td>
								</c:forEach>
							</tr>
							</tbody>
						</table>
					</c:if>
				</c:if>
			</div>
			<!--endprint-->
		</div>
			<div class="row">
				<div class="col-lg-12" style="padding: 30px 0;">
					<table align="center">
						<tr>
							<c:if test="${not empty sessionScope.customerInfo}">
							<td style="padding-right: 10px;">
								<form action="<%=basePath%>simple/customer/orderList.do" method="post">
									<input type="submit" value="查看我的订单">
								</form>
							<td style="padding-right: 10px;">
							<td style="padding-right: 10px;">
								<form action="<%=basePath%>simple/customer/orderDetailList.do" method="post">
									<input type="submit" value="查看生成的报告" class="btn-success">
								</form>
							<td style="padding-right: 10px;">
							</c:if>
							<c:if test="${empty sessionScope.customerInfo}">
								<td style="padding-right: 10px;">
									<button class="btn btn-warming btn-success" style=" width:160px;height: 50px" onclick="toPage(4)">查看我的购物车</button></td>
							</c:if>
						</tr></table>
				</div>
			</div>

		</div>
	</div>
</div>
</div>
<jsp:include page="${basePath}../include/bottomCommon.jsp"/>
</body>
</html>