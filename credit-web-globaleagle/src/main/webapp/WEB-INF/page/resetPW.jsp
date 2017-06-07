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
    <title>全球鹰-重置密码</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="include/include.jsp"/>
    <script type="text/javascript">
        function resetPW() {
            if ($("#password").val()==""||$("#password").val()==null){
                BootstrapDialog.alert("密码不能为空!");
                return;
            }

            if ($("#password").val().length<6){
                BootstrapDialog.alert("密码至少六位");
                return false;
            };
            var data = {
                'password': $("#password").val(),
                'email': '${email}'
            }
            $.ajax({
                type: "POST",
                url: basePath + "resetPW.do",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (data) {
                    BootstrapDialog.alert(data.msg);
                    $("#password").val()=="";
                }
            });
        }
    </script>
</head>



<body>
<jsp:include page="${basePath}include/topCommon.jsp"/>
<div class="container">
    <div id="banner" style="padding-top: 20px;">
        <div class="row">
            <div class="col-lg-12 col-lg-offset-1">
                <h2 class="form-signin-heading">修改密码</h2>
                <div class="form-group">
                    <label class="tite_txt">用户名/Email地址</label>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" value="${email}" disabled/>
                </div>

                <div class="form-group">
                    <label for="password" class="tite_txt">重设密码</label>
                </div>
                <div class="form-group">
                    <input class="form-control" id="password" type="password" placeholder="重设密码"/>
                </div>
                <div class="form-group">
                    <button onclick="resetPW()" class="btn btn-primary">确认</button>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${basePath}./include/bottomCommon.jsp"/>

</body>
</html>