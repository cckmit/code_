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
	<title>全球鹰-注册</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
    <jsp:include page="include/include.jsp"/>
     <script src="${pageContext.request.contextPath}/pageFrame/bootstrapValidator.min.js"></script>
	<link href="${pageContext.request.contextPath}/pageFrame/bootstrapValidator.min.css" rel="stylesheet" />

<script type="text/javascript">
$(function () {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	code: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 18,
                        message: '用户名长度必须在6到18位之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '用户名只能包含大写、小写、数字和下划线'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    emailAddress: {
                        message: '邮箱地址格式有误'
                    }
                }
            }
        }
    });
});
</script>
</head>

<body>
	<jsp:include page="${basePath}include/top.jsp"/>
<div class="container">
<br><br>
	<form class="form-signin" action="<%=basePath%>register.do" method="post">
	<h2 class="form-signin-heading">注册</h2>
	<label style="color: #ff0000;">${message}</label>
	<label class="tite_txt">设置用户名</label>
	<input type="text" name="code" class="form-control"/>
	<label class="tite_txt">设置密码</label>
	<input type="password" name="passwd" class="form-control"/>
	<label class="tite_txt">设置昵称</label>
	<input type="text" name="name" class="form-control"/>
	<label class="tite_txt">设置身份证</label>
	<input type="text" name="idcard" class="form-control"/>
	<label class="tite_txt">设置手机号</label>
	<input type="text" name="phone" class="form-control"/>
	<label class="tite_txt">设置地址</label>
	<input type="text" name="addr" class="form-control"/>
	<label class="tite_txt">设置e-mail</label>
	<input type="text" name="email" class="form-control"/>
	<label class="tite_txt">设置性别</label>
	<input type="text" name="sex" class="form-control"/>
<!-- 	<label class="tite_txt">设置生日</label>
	<input type="text" name="birthday"/><br> -->
	<label class="tite_txt">设置联系方式</label>
	<input type="text" name="mobile" class="form-control"/><br>
	<input type="submit" value="register" class="btn btn-lg btn-primary btn-block">
</form>
</div> <!-- /container -->
<!-- 	登录信息		-->	
	<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">登陆</h4>
				</div>
				<div class="modal-body">
					<form class="form-signin" action="<%=basePath%>login.do" method="post">
						<label for="code" class="sr-only">用户名</label>
						<input type="text" id="code" name="code" class="form-control" placeholder="用户名" required autofocus>
						<label for="passwd" class="sr-only">密码</label>
						<input type="password" id="passwd" name="passwd" class="form-control" placeholder="密码" required>

						<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
					</form>
				</div>
				<div class="modal-footer">
				</div>

			</div>
		</div>
</div>
</body>
</html>
