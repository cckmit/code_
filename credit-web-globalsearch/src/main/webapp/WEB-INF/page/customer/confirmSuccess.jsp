<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../include/include.jsp"/>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>Full Search</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<style>
		.navbar-holder-dark {
			padding: 20px 20px 200px 20px;
			background: #333333;
		}
	</style>
	<script type="text/javascript">
        function toPage(i){
            //1返回购物车
            if (i==1) {
                window.location.href="${pageContext.request.contextPath}/customer/toOrderDetailList.do";
            }else if(i==3){
                window.location.href="${pageContext.request.contextPath}/customer/toOrderList.do";
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
        function  showReportChina(id,orderId) {
            window.open(basePath+'/customer/openReport.do?orderDetailId='+id+'&orderId='+orderId);
        }
	</script>


</head>
<body>
<jsp:include page="../include/top.jsp"/>

<br><br>

<div id="banner">
	<div class="container" style="min-height:518px;padding-top:0px">
		<div class="well bs-component">
			<legend>Completion</legend>				<div class="row">

			<!--startprint-->
			<div class="col-lg-12" id="downLoadData">
				<%--<h3 class="text-center">${msg}&nbsp;&nbsp;--%>
					<%--<c:if test="${msg=='支付成功'}"><button class="btn btn-warming btn-primary" style=" width:80px;height: 30px" onclick="preview()">收据信息</button></c:if>--%>
					<h3 class="text-center">Thank you, your order has been placed</h3><br>
					<p>An email confirmation has been sent to you. You can also login to your account for delivery updates.</p>
					<br>
					<c:if test="${not empty order}">
					<%--<p><h4>Order information:</h4>--%>
					<p>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Order Number:
						<strong>${order.getNo()}</strong>&nbsp;&nbsp;<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Current Total:
						<strong> ${order.getAmount()}</strong><br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Delivery Time:
						<strong> -</strong>
					</p>
					<br/>
					<c:if test="${order.getOrderDetails().size()>=0}">
						<h4>Order Details:</h4>
						<table class="table table-hover table-striped table-responsive">
							<thead>
							<tr>
								<%--<td>Country</td>--%>
								<td>Company Name</td>
								<td>Amount</td>
								<td>Check</td>
							</tr>
							</thead>
							<c:forEach var="orderDetails" items="${order.getOrderDetails()}" varStatus="status">
							<tbody>
							<tr>
								<%--<td>--%>
										<%--China--%>
								<%--</td>--%>
								<td>
										${orderDetails.getCompanyName()}
								</td>
								<td>
										${order.getAmountActual()}
								</td>
								<td>
									<button class="btn btn-xs btn-primary" onclick="showReportChina(${orderDetails.id},${orderDetails.orderId});">
										View Report
									</button>
								</td>
								</c:forEach>
							</tr>
							</tbody>
						</table>
					</c:if>
				</c:if>
					<p>&nbsp;>&nbsp;&nbsp;Your order details can be found on the My Orders.</p>
					<p>&nbsp;>&nbsp;&nbsp;If updates are avaliable, you will be notified by email.</p>
			</div>
			<!--endprint-->
		</div>
			<div class="row">
				<div class="col-lg-12" style="padding: 30px 0;text-align: center">
					<table align="center" style="width:100%">
						<tr>
							<c:if test="${not empty sessionScope.customerInfo}">
								<td style="padding-right: 10px;">
									<button class="btn btn-warming btn-primary" style=" width:160px;height: 50px;float:right" onclick="toPage(3)">Check My Orders</button>
								</td>
								<td style="padding-right: 10px;width: 15%;">
									<button class="btn btn-warming btn-success" style=" width:160px;height: 50px;float:left" onclick="toPage(1)">View this report</button>
								</td>
								<td style="padding-right: 10px;">
									<a href="${pageContext.request.contextPath}/index.do"><button class="btn btn-warming btn-success" style=" width:160px;height: 50px;float:left">Continue Search</button></a>
								</td>
							</c:if>
						</tr></table>
				</div>
			</div>

		</div>
	</div>
</div>
<br><br>

<jsp:include page="../include/bottom.jsp"/>


<script>
    $(document).ready( function() {

        $('.navbar .dropdown, .dropdown-submenu').hover(function() {
            //$(this).find('.dropdown-menu').first().stop(true, true).delay(250).slideDown();
            //$(this).find('.dropdown-menu').show().removeClass('flipOutY').addClass('animated flipInY');
            //$(this).find('.dropdown-menu').show().removeClass('bounceOut').addClass('animated bounceIn');
            //$(this).find('.dropdown-menu').first().show();


        }, function() {
            //$(this).find('.dropdown-menu').first().stop(true, true).delay(100).slideUp();
            //$(this).find('.dropdown-menu').removeClass('flipInY').addClass('animated flipOutY').fadeOut();
            //$(this).find('.dropdown-menu').removeClass('bounceIn').addClass('animated bounceOut').fadeOut();
            //$(this).find('.dropdown-menu').first().hide();

        });

        $('#featureCarousel').carousel({
            interval:   4000
        });

        var clickEvent = false;
        $('#featureCarousel').on('click', '.nav a', function() {
            clickEvent = true;
            $('.nav li').removeClass('active');
            $(this).parent().addClass('active');
        }).on('slid.bs.carousel', function(e) {
            if(!clickEvent) {
                var count = $('#featureCarousel .nav').children().length -1;
                var current = $('#featureCarousel .nav li.active');
                current.removeClass('active').next().addClass('active');
                var id = parseInt(current.data('slide-to'));

                if(count == id) {
                    $('#featureCarousel .nav li').first().addClass('active');
                }
            }
            clickEvent = false;
        });
    });
</script>

</body>
</html>