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
    <title>Full Search - Reset Password</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="include/include.jsp"/>
    <script type="text/javascript">
        function resetPW() {
            if ($("#password").val()==""||$("#password").val()==null){
                BootstrapDialog.alert("Password cant be empty!");
                return false;
            };
            if ($("#password").val().length<6){
                BootstrapDialog.alert("Enter the password at least six bits!");
                return false;
            };
            var data = {
                'password': $("#password").val(),
                'email': '${email}'
            };
            BootstrapDialog.show({
                title: 'Reset Password',
                message: "Please confirm whether to commit",
                buttons: [{
                    label: 'submit',
                    action: function (dialog) {
                        $.ajax({
                            type: "POST",
                            url: basePath + "resetPW.do",
                            dataType: "json",
                            contentType: "application/json",
                            data: JSON.stringify(data),
                            success: function (data) {
                                BootstrapDialog.alert("Reset the success");
                                dialog.close();
                                window.location.href="/toLogin.do";
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
<jsp:include page="include/top.jsp"/>

<div class="container" style="height:610px">
    <div id="banner"  style="padding: 30px;height:400px;margin-top:80px;border:1px solid #e5e5e5;background:#EFF1F1;text-align:center">
        <div class="row">
            <div class="col-lg-12 col-lg-offset-1"  style="margin-left:0">
                <h2 class="form-signin-heading"  style="margin:0 0 70px">Change Password</h2>
                <div class="form-group"   style="margin-bottom:25px;">
                    <label class="tite_txt" style="width:120px">Email Address</label>
                    <input type="text" class="form-control" value="${email}" disabled  style="width: 300px;display:inline-block"/>
                </div>

                <div class="form-group"  style="margin-bottom:25px;">
                    <label for="password" class="tite_txt" style="width:120px">Reset Password</label>
                    <input class="form-control" id="password" type="password" placeholder="Reset Password"  style="width: 300px;display:inline-block"/>
                </div>

                <div class="form-group">
                    <button onclick="resetPW()" class="btn btn-primary">Confirm</button>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${basePath}include/bottom.jsp"/>

</body>
</html>