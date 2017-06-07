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
	<title>全球鹰-支付选择</title>
	<jsp:include page="../include/include.jsp"/>
	    <script src="<%=basePath%>js/user/orderPayfo.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frame/bootstrap/css/drag.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/drag.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/frame/jquery.qrcode.min.js"></script>
	<script type="text/javascript">
            $(function () {
                $('#drag').drag();
            });
			function toRigister() {
				window.location.href="<%=basePath%>toLogin.do";
			}
			function setCookie(email){ //设置cookie
				var now=new Date();
				$.cookie("email",email);//调用jquery.cookie.js中的方法设置cookie中的用户名
				$.cookie("time",now);
			}

			function getCookie(){ //获取cookie
				var email = $.cookie("email"); //获取cookie中的用户名
				var time = $.cookie("time"); //获取cookie中的用户名
				if (compareDate(time)==null){
					$.cookie("email",null);
					$.cookie("time",null);
					return;
				}else{
					if(email==null||email==="undifined"||email=="null"){
						$("#loginEmail").val("");
					}else{
						$("#loginEmail").val(email);
					}
				}
			}

			function compareDate(time) {
				var now=new Date();
				if (now>time+7) {
					return null;
				}else{
					return now;
				}
			}
			function changeImg(){
				var imgSrc = $("#imgObj");
				var src = imgSrc.attr("src");
				imgSrc.attr("src",chgUrl(src));
			}
			function chgUrl(url){
				var timestamp = (new Date()).valueOf();
				var urlurl = url.substring(0,18);
				if((url.indexOf("&")>=0)){
					urlurl = url + "&tamp=" + timestamp;
				}else{
					urlurl = url + "?timestamp=" + timestamp;
				}
				return urlurl;
			}
		</script>
</head>


<body>
	<jsp:include page="${basePath}../include/topCommon.jsp" /><br>

	<div id="banner">
	<div class="container">
			<div class="bs-docs-section">
				<div class="row">
					<div class="col-lg-6">
						<div class="bs-component">
							<blockquote>
								<p>
									感谢您的订购<br> 您的订单总额为<strong> ¥ ${price}</strong>，订单数量为<strong>
										${count}</strong>
								</p>
								<input type="hidden" id="orderPirce" value="${price}">
								<!--  <p><small>订单号：PX3820384729</small> </p> -->
							</blockquote>
						</div>
					</div>
				</div>

		<div class="row">
			<div class="col-lg-6">
				<div class="well bs-component">
					 <form class="form-horizontal">
						<fieldset>
							<legend>非会员支付</legend>
							<div class="form-group">
								<label class="col-lg-2 control-label" style="width:100px;">电子邮箱</label>
								<div class="col-lg-9">
									<input class="form-control" id="inputEmail" placeholder="电子邮箱"
										type="text" name="email">
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label" style="width:100px;">确认邮箱</label>
								<div class="col-lg-9">
									<input class="form-control" id="inputEmailAgain"
										placeholder="再输一次邮箱" type="text">
									<span class="help-block">我们会将生成的报告发送至该邮箱</span>
								</div>
							</div>
							<div class="form-group">
								<label for="textArea" class="col-lg-2 control-label" style="width:100px;">开票信息</label>
								<div class="col-lg-9">
									<textarea class="form-control" rows="3" id="textArea"></textarea>
									<div class="checkbox">
										<label> <input type="checkbox">需要开具发票
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label" style="width:100px;">付款方式</label>
								<div class="col-lg-9">
									<div class="radio">
										<label> <input name="optionsRadios"
											id="optionsRadios1" value="option1" checked="checked"
											type="radio"> 支付宝
										</label>
									</div>
									<div class="radio">
										<label> <input name="optionsRadios"
											id="optionsRadios2" value="option2" type="radio">
											微信支付
										</label>
									</div>
								</div>
							</div>
							<div class="form-group"></div>
							<div class="form-group">
								<div class="col-lg-10 col-lg-offset-2">
									<button type="button" class="btn btn-primary" onclick="visitorAddOrder();">现在支付</button>
								</div>
							</div>
						</fieldset>
					 </form> 
				</div>
			</div>
			<div class="col-lg-4 col-lg-offset-1">

				<form class="bs-component" action="<%=basePath%>login.do" id="myForm" method="post">

					<legend>会员支付</legend>

					<div class="form-group">


						<label class="control-label" for="email">用户名</label> <input
							class="form-control" name="email" id="email" placeholder="用户名"
							type="text">
					</div>

					<div class="form-group">


						<label class="control-label" for="password">密码</label> <input
							class="form-control" name="passwd" id="password" placeholder="密码"
							type="password">
					</div>
					<div class="form-group">
						<label class="control-label">验证码</label>
						<div id="drag"></div>

						<%--<input
							class="form-control" name="verificationCode" id="verificationCode" placeholder="验证码" required
							type="text">
						<img id="imgObj" class="verifyCode"  alt="" src="<%=basePath%>xuan/verifyCode.do" onclick="changeImg()"/>
						<a href="javascript:void(0);" onclick="changeImg()">换一张</a>--%>

						<%--<div class="col-lg-9">--%>
							<%--<input--%>
									<%--class="form-control" placeholder="验证码" name="verificationCode" id="verificationCode" required--%>
									<%--type="text">--%>
							<%--<img id="imgObj" class="verifyCode"  alt="" src="<%=basePath%>xuan/verifyCode.do" onclick="changeImg()"/>--%>
							<%--<a href="javascript:void(0);" onclick="changeImg()">换一张</a>--%>
						<%--</div>--%>
					</div>

					<%--<div class="form-group">--%>

						<%--<button type="submit" class="btn btn-primary">会员登入</button>--%>
<%--<!-- 						<a href="＃">忘记用户名或密码</a>--%>
 <%---->					</div>--%>
					<div class="form-group" align="center" style="padding-top: 10px">
						<%--<button type="button" class="btn btn-danger btn-lg"--%>
							<%--data-toggle="modal" data-target="#myModal">--%>
							<%--注册成会员，获取更优惠价格及更好的服务</button>--%>
						<button type="button" class="btn btn-danger btn-lg" onclick="toRigister();">
							注册成会员，获取更优惠价格及更好的服务</button>

						<!-- Modal -->
						<%--<div class="modal fade" id="myModal" tabindex="-1" role="dialog"--%>
							<%--aria-labelledby="myModalLabel" aria-hidden="true">--%>
							<%--<div class="modal-dialog">--%>
								<%--<div class="modal-content">--%>
									<%--<div class="modal-header">--%>
										<%--<button type="button" class="close" data-dismiss="modal"--%>
											<%--aria-label="Close">--%>
											<%--<span aria-hidden="true">&times;</span>--%>
										<%--</button>--%>
										<%--<h4 class="modal-title" id="myModalLabel">Modal Title</h4>--%>
									<%--</div>--%>
									<%--<div class="modal-body">Overflowing text to show scroll--%>
										<%--behavior Cras mattis consectetur purus sit amet fermentum.--%>
										<%--Cras justo odio, dapibus ac facilisis in, egestas eget quam.--%>
										<%--Morbi leo risus, porta ac consectetur ac, vestibulum at eros.--%>

										<%--Praesent commodo cursus magna, vel scelerisque nisl--%>
										<%--consectetur et. Vivamus sagittis lacus vel augue laoreet--%>
										<%--rutrum faucibus dolor auctor. Aenean lacinia bibendum nulla--%>
										<%--sed consectetur. Praesent commodo cursus magna, vel--%>
										<%--scelerisque nisl consectetur et. Donec sed odio dui. Donec--%>
										<%--ullamcorper nulla non metus auctor fringilla.</div>--%>
									<%--<div class="modal-footer">--%>
										<%--<button type="button" class="btn btn-default"--%>
											<%--data-dismiss="modal">Close</button>--%>
										<%--<button type="button" class="btn btn-primary">Save--%>
											<%--changes</button>--%>
									<%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>
					</div>


				</form>


			</div>
		</div>

			</div>
	</div>
	</div>
	<jsp:include page="${basePath}../include/bottomCommon.jsp" />

	<div id="weixinPayModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="weixinPayModalLabel">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="continentModalLabel">微信支付</h4>
				</div>
				<div class="modal-body text-center" style="background-color: grey">
					<div class="row" style="margin: 0 auto; width: 300px; height: 420px; background-color: white; padding-top: 15px;">
						<div class="col-md-12 col-sm-12 col-xs-12 text-center">
							<p style="color: red;">请在24小时内完成支付!</p>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12 text-center">
							<div id="qrcode"></div><p></p>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12 text-center">
							<img width="256" src="<%=basePath%>images/payfor/ps_weixin_tell.png" alt="请使用微信扫描二维码进行支付"/>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>