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
	<title>Full Search - Forgot Password</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="include/include.jsp"/>
<script type="text/javascript">
	function forgetPW() {
		if ($("#email").val()==""||$("#email").val()==null){
			BootstrapDialog.alert("email address not is null");
			return;
		}
		var data = {
			'email': $("#email").val(),
		};
        BootstrapDialog.show({
            title: 'Email confirmation',
            message: "Please confirm whether to commit",
            buttons: [{
                label: 'submit',
                action: function (dialog) {
                    $.ajax({
                        type: "POST",
                        url: basePath + "forgetPW.do",
                        dataType: "json",
                        contentType: "application/json",
                        data: JSON.stringify(data),
                        success: function (data) {
                            BootstrapDialog.alert("Send successful");
                            dialog.close();
                        }
                    });
                }
            }, {
                label: 'cancel',
                action: function (dialog) {
                    dialog.close();
                }
            }]
        });
	}
</script>
</head>



<body>
<jsp:include page="${basePath}include/top.jsp"/>
<div class="container" style="height:610px">
	<div id="banner" style="padding: 30px;height:400px;margin-top:80px;border:1px solid #e5e5e5;background:#EFF1F1;text-align:center">
		<div class="row">
			<div class="col-lg-12 col-lg-offset-1" style="margin-left:0">
				<h2 class="form-signin-heading" style="margin:0 0 70px">Forget Password</h2>
				<div class="form-group" style="margin-bottom:25px">
					<label class="tite_txt">Email Address</label></div>
				<div class="form-group" style="margin-bottom:25px">
					<input type="text" class="form-control" id="email" style="display:inline-block;width: 300px;"/></div>
				<div class="form-group">
					<button onclick="forgetPW()" class="btn btn-primary">Email Confirmation</button>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="${basePath}include/bottom.jsp"/>

</body>
</html>
