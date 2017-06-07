<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>全球鹰-登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="./include/include.jsp"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frame/bootstrap/css/drag.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/drag.js"></script>

    <script type="text/javascript">
        $(function () {
            $('#drag').drag();
            //        切换效果
            $(".form-horizontal legend").on("click","label",function(){
                if($(this).text() == "手机"){
                    $('#page-form-one').hide();
                    $('#page-form-two').show();
                }else{
                    $('#page-form-two').hide();
                    $('#page-form-one').show();
                }
            });
        });

        function submitRegister() {
            if ($("#registerEmail").val() == null || $("#email").val() == "") {
                BootstrapDialog.alert("邮箱地址不为空");
                return false;
            }
            if ($("#registerPasswd").val() == null || $("#password").val() == "") {
                BootstrapDialog.alert("密码不为空");
                return false;
            }
            if($("#registerPasswd").val().length<6){
                BootstrapDialog.alert("密码至少六位");
                return false;
            }

            if ($("#registerPasswd").val() != $("#registerPasswdAgain").val()){
                BootstrapDialog.alert("两次输入密码不一致");
                return false;
            }
            if (!isEmail($("#registerEmail").val())) {
                return false;
            }
            return true;
        }
        function submitRegisterPhone() {
            if ($("#registerIphone").val() == null || $("#registerIphone").val() == "") {
                BootstrapDialog.alert("手机号不能为空");
                return false;
            }
            if ($("#registerPasswdPhone").val() == null || $("#registerPasswdPhone").val() == "") {
                BootstrapDialog.alert("密码不为空");
                return false;
            }

            if ($("#registerPasswdPhone").val() != $("#registerPasswdAgainPhone").val()){
                BootstrapDialog.alert("两次输入密码不一致");
                return false;
            }
            var phone=$("#registerIphone").val();
            if (!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(phone))){
                BootstrapDialog.alert("您输入的手机号不正确");
                return false;
            }
            return true;
        }

        function submitLogin() {
            if ($("#loginEmail").val() == null || $("#loginEmail").val() == "") {
                BootstrapDialog.alert("邮箱或手机号不为空");
                return false;
            }
            if ($("#loginPasswd").val() == null || $("#loginPasswd").val() == "") {
                BootstrapDialog.alert("密码不为空");
                return false;
            }
            var phone=$("#loginEmail").val();
            if (!isEmail($("#loginEmail").val())&&!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(phone))) {
                BootstrapDialog.alert("您输入的手机号或邮箱不正确");
                return false;
            }
            if ($("#check").attr("checked") == undefined) {
                $.cookie("email",null);
                $.cookie("time",null);
            }else{
                setCookie($("#loginEmail").val());
            }
            return true;
        }
        function sendCode() {
            var phone=$("#registerIphone").val();
            if (!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(phone))){
                BootstrapDialog.alert("您输入的手机号不正确");
                return false;
            }else {
//                var senddata = {
//                    "mobile":$("#registerIphone").val()
//                };
                $.ajax({
                    async:false,
                    type: "POST",
                    url: basePath + "/sendVerificationCode.do",
                    dataType: "json",
//                    contentType: "application/json",
                    data: {'mobile':$("#registerIphone").val()},
                    success: function (data) {
                        BootstrapDialog.alert("发送成功,请接收!");
                    },error:function(){
                        BootstrapDialog.alert("账号已存在!");
                    }
                });
            }
        }

        function isEmail(strEmail) {
            if (strEmail
                            .search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1) {
                return true;
            } else {
//                BootstrapDialog.alert("请输入正确email格式");
                return false;
            }
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

<body onLoad="getCookie()">
<jsp:include page="${basePath}include/topCommon.jsp"/>
<div class="container">
    <div id="banner" style="padding-top: 20px;">
    <div class="row">
        <div class="col-lg-6">
            <div class="well bs-component">
                <form class="form-horizontal" id="page-form-one" action="<%=basePath%>emailRegister.do" method="post"
                      onsubmit="return submitRegister();">
                    <legend style="display: block;width: 50%;padding: 0;margin-bottom: 20px;font-size: 18px;line-height:inherit;color: #333;border: 0;border-bottom: 1px solid #e5e5e5;float: left;font-family: 'Microsoft Sans Serif';"><label class="page-nim-btn">快速注册</label></legend>
                    <legend style="display: block;width: 50%;padding: 0;margin-bottom: 20px;font-size: 16px;margin-top: 3px;line-height: inherit;color: #e74c3c;border: 0;border-bottom: 1px solid #e5e5e5;float: right;float: right;color: #c9302c;text-align: right;">
                        <label class="page-nim-btn" style="cursor: pointer;color: #e74c3c;">邮箱</label>/<label class="page-iphone-btn" style="cursor: pointer;color: #e74c3c;">手机</label></legend>
                    <fieldset style="overflow: hidden;clear: both;zoom: 1;">
                        <label style="color: #ff0000;">${messageRegister}</label>
                        <div class="form-group">
                            <label for="registerEmail" class="col-lg-3 control-label">邮箱</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="text" name="email" id="registerEmail"
                                       placeholder="注册邮箱" required autofocus>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="registerPasswd" class="col-lg-3 control-label">密码</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="password" id="registerPasswd" name="passwd" placeholder="密码" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="registerPasswdAgain" class="col-lg-3 control-label">确认密码</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="password" id="registerPasswdAgain" placeholder="确认密码" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="submit" class="btn btn-danger">现在注册</button>
                                <br/><br/>
                                <p class="text-danger">注册成会员并<strong>认证公司</strong>，获取更优惠价格及更好的服务</p>
                            </div>
                        </div>
                    </fieldset>
                </form>

                <!--切换注册-->
                <form class="form-horizontal" id="page-form-two" style="display: none;position: relative;top: 0px;left: 0px;" action="<%=basePath%>mobileRegister.do" method="post"
                      onsubmit="return submitRegisterPhone();">
                    <legend style="display: block;width: 50%;padding: 0;margin-bottom: 20px;font-size: 18px;line-height: inherit;color: #333;border: 0;border-bottom: 1px solid #e5e5e5;float: left;font-family: 'Microsoft Sans Serif';"><label class="page-nim-btn">快速注册</label></legend>
                    <legend style="display: block;width: 50%;padding: 0;margin-bottom: 20px;font-size: 16px;margin-top: 3px;line-height: inherit;color: #333;border: 0;border-bottom: 1px solid #e5e5e5;float: right;float: right;color: #c9302c;text-align: right;">
                        <label class="page-nim-btn" style="cursor: pointer;color: #e74c3c;">邮箱</label>/<label class="page-iphone-btn" style="cursor: pointer;color: #e74c3c;">手机</label></legend>
                    <fieldset class="page-iphone" style="overflow: hidden;clear: both;zoom: 1;">
                        <label style="color: #ff0000;" id="messageRegister">${messageRegister}</label>
                        <div class="form-group">
                            <label for="registerIphone" class="col-lg-3 control-label">手机号码</label>
                            <div class="col-lg-9 iphone-input">
                                <input class="form-control" type="text" name="mobile" id="registerIphone"
                                       placeholder="请输入您的手机号码" required autofocus>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="registerPasswdPhone" class="col-lg-3 control-label">密码</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="password" id="registerPasswdPhone"
                                       name="passwd" placeholder="密码" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="registerPasswdAgainPhone" class="col-lg-3 control-label">确认密码</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="password" id="registerPasswdAgainPhone"
                                       placeholder="确认密码" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="MessageAuthentication" class="col-lg-3 control-label">短信验证码</label>
                            <div class="col-lg-9 page-iphone-pass">
                                <input class="form-control input-one" style="float: left;width: 60.5%;height: 34px; " type="text" name="theme" id="MessageAuthentication"
                                       placeholder="短信验证码" required>
                                <input class="input-two" style="float: left; height: 33px;width: 39.5%;border-radius: 4px;background-color: #e74c3c;
                                color: #ffffff;font-size: 14px; background-image: none;border: 1px solid #ccc;" type="button" value="获取短信验证码" onclick="sendCode()"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="submit" class="btn btn-danger">现在注册</button>
                                <br/><br/>
                                <p class="text-danger">注册成会员并<strong>认证公司</strong>，获取更优惠价格及更好的服务</p>
                            </div>
                        </div>
                    </fieldset>
                </form>


            </div>
        </div>
        <div class="col-lg-5 col-lg-offset-1">
            <form class="bs-component form-horizontal" action = '<%=basePath%>login.do' id="myForm" method="post"
                  onsubmit="return submitLogin();">
                <fieldset>
                    <legend>会员登录</legend>
                    <label style="color: #ff0000;">${message}</label>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="loginEmail">邮箱/手机</label>
                        <div class="col-lg-8">
                            <input
                                    class="form-control" id="loginEmail" name="code"
                                    type="text" placeholder="邮箱/手机" required autofocus>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="loginPasswd">密码</label>
                        <div class="col-lg-8">
                            <input
                                    class="form-control" id="loginPasswd" name="passwd" placeholder="密码" required
                                    type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">验证码</label>
                        <%--<div class="col-lg-9">
                            <input
                                    class="form-control" placeholder="验证码" name="verificationCode" id="verificationCode" required
                                    type="text">
                            <img id="imgObj" class="verifyCode"  alt="" src="<%=basePath%>xuan/verifyCode.do" onclick="changeImg()"/>
                            <a href="javascript:void(0);" onclick="changeImg()">换一张</a>
                        </div>--%>
                        <div class="col-lg-9">
                            <div id="drag"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-9 col-lg-offset-3">
                            <input type="checkbox" id="check" >&nbsp;记住账号
                            &nbsp;&nbsp;&nbsp;&nbsp;<a href="toForgetPW.do">忘记密码</a>
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                    <%--<div class="col-lg-9 col-lg-offset-3">--%>
                    <%--<button type="submit" class="btn btn-primary">会员登入</button>&nbsp;&nbsp;--%>
                    <%--<a href="toForgetPW.do">忘记密码</a>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                </fieldset>
            </form>

        </div>
    </div>
</div>
</div>
<jsp:include page="${basePath}./include/bottomCommon.jsp"/>

</body>
</html>
