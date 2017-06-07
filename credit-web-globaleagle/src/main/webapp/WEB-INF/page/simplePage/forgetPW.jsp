<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>全球鹰-忘记密码</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="include/include.jsp"/>
<%--<script type="text/javascript">--%>
	<%--function forgetPW() {--%>
		<%--if ($("#email").val()==""||$("#email").val()==null){--%>
			<%--BootstrapDialog.alert("用户名/Email地址不能为空!");--%>
			<%--return;--%>
		<%--}--%>
		<%--var data = {--%>
			<%--'email': $("#email").val(),--%>
		<%--}--%>
		<%--$.ajax({--%>
			<%--type: "POST",--%>
			<%--url: basePath + "forgetPW.do",--%>
			<%--dataType: "json",--%>
			<%--contentType: "application/json",--%>
			<%--data: JSON.stringify(data),--%>
			<%--success: function (data) {--%>
				<%--BootstrapDialog.alert(data.resultDes);--%>
			<%--}--%>
		<%--});--%>
	<%--}--%>
<%--</script>--%>
</head>



<body>
<jsp:include page="${basePath}include/topCommon.jsp"/>
<div class="container">
	<div id="banner" style="padding-top: 20px;">
		<div class="row">
			<form action="<%=basePath%>simple/forgetPW.do">
				<div class="col-lg-4 col-lg-offset-1">
					<h2 class="form-signin-heading">忘记密码</h2>
					<div class="form-group">
						<label class="tite_txt">用户名/Email地址</label></div>
					<div class="form-group">
						<input type="text" class="form-control" name="email" /></div>
					<div class="form-group">
						<%--<button class="btn btn-primary">发送邮件确认</button>--%>
						<input type="submit" class="btn btn-primary" value="发送邮件确认"/>
					</div>
					<p style="font-size: 20px; color:green">${result}</p>
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="${basePath}./include/bottomCommon.jsp"/>

</body>
</html>
