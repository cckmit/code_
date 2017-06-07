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
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/drag.js"></script>--%>

    <%--<script type="text/javascript">--%>
        <%--$(function () {--%>
            <%--$('#drag').drag();--%>
        <%--});--%>

        <%--function submitRegister() {--%>
            <%--if ($("#registerEmail").val() == null || $("#email").val() == "") {--%>
                <%--BootstrapDialog.alert("邮箱地址不为空");--%>
                <%--return false;--%>
            <%--}--%>
            <%--if ($("#registerPasswd").val() == null || $("#password").val() == "") {--%>
                <%--BootstrapDialog.alert("密码不为空");--%>
                <%--return false;--%>
            <%--}--%>
            <%--if ($("#registerPasswd").val() != $("#registerPasswdAgain").val()){--%>
                <%--BootstrapDialog.alert("两次输入密码不一致");--%>
                <%--return false;--%>
            <%--}--%>
            <%--if (!isEmail($("#registerEmail").val())) {--%>
                <%--return false;--%>
            <%--}--%>

            <%--return true;--%>
        <%--}--%>

        <%--function submitLogin() {--%>
            <%--if ($("#loginEmail").val() == null || $("#loginEmail").val() == "") {--%>
                <%--BootstrapDialog.alert("邮箱地址不为空");--%>
                <%--return false;--%>
            <%--}--%>
            <%--if ($("#loginPasswd").val() == null || $("#loginPasswd").val() == "") {--%>
                <%--BootstrapDialog.alert("密码不为空");--%>
                <%--return false;--%>
            <%--}--%>
<%--//            if ($("#verificationCode").val() == null || $("#verificationCode").val() == "") {--%>
<%--//                BootstrapDialog.alert("验证码不为空");--%>
<%--//                return false;--%>
<%--//            }--%>
            <%--if (!isEmail($("#loginEmail").val())) {--%>
                <%--BootstrapDialog.alert("输入正确的邮箱地址");--%>
                <%--return false;--%>
            <%--}--%>
            <%--if ($("#check").attr("checked") == undefined) {--%>
                <%--$.cookie("email",null);--%>
                <%--$.cookie("time",null);--%>
            <%--}else{--%>
                <%--setCookie($("#loginEmail").val());--%>
            <%--}--%>
            <%--return true;--%>
        <%--}--%>

        <%--function isEmail(strEmail) {--%>
            <%--if (strEmail--%>
                            <%--.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1) {--%>
                <%--return true;--%>
            <%--} else {--%>
                <%--BootstrapDialog.alert("请输入正确email格式");--%>
                <%--return false;--%>
            <%--}--%>
        <%--}--%>

        <%--function setCookie(email){ //设置cookie--%>
                <%--var now=new Date();--%>
                <%--$.cookie("email",email);//调用jquery.cookie.js中的方法设置cookie中的用户名--%>
                <%--$.cookie("time",now);--%>
        <%--}--%>

        <%--function getCookie(){ //获取cookie--%>
            <%--var email = $.cookie("email"); //获取cookie中的用户名--%>
            <%--var time = $.cookie("time"); //获取cookie中的用户名--%>
            <%--if (compareDate(time)==null){--%>
                <%--$.cookie("email",null);--%>
                <%--$.cookie("time",null);--%>
                <%--return;--%>
            <%--}else{--%>
                <%--if(email==null||email==="undifined"||email=="null"){--%>
                    <%--$("#loginEmail").val("");--%>
                <%--}else{--%>
                    <%--$("#loginEmail").val(email);--%>
                <%--}--%>
            <%--}--%>
        <%--}--%>

        <%--function compareDate(time) {--%>
            <%--var now=new Date();--%>
            <%--if (now>time+7) {--%>
                <%--return null;--%>
            <%--}else{--%>
                <%--return now;--%>
            <%--}--%>
        <%--}--%>
        <%--function changeImg(){--%>
            <%--var imgSrc = $("#imgObj");--%>
    <%--var src = imgSrc.attr("src");--%>
    <%--imgSrc.attr("src",chgUrl(src));--%>
        <%--}--%>
        <%--function chgUrl(url){--%>
            <%--var timestamp = (new Date()).valueOf();--%>
            <%--var urlurl = url.substring(0,18);--%>
            <%--if((url.indexOf("&")>=0)){--%>
                <%--urlurl = url + "&tamp=" + timestamp;--%>
            <%--}else{--%>
                <%--urlurl = url + "?timestamp=" + timestamp;--%>
            <%--}--%>
            <%--return urlurl;--%>
        <%--}--%>

    <%--</script>--%>
</head>

<body onLoad="getCookie()">
<jsp:include page="${basePath}include/topCommon.jsp"/>
<div class="container">
    <div id="banner" style="padding-top: 20px;">
    <div class="row">
        <div class="col-lg-6">
            <div class="well bs-component">
                <form class="form-horizontal" action="<%=basePath%>simple/register.do" method="post"
                      onsubmit="return submitRegister();">
                    <fieldset>
                        <legend>快速注册</legend>
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
                                <input class="form-control" type="password" id="registerPasswd"
                                       name="passwd" placeholder="密码" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="registerPasswdAgain" class="col-lg-3 control-label">确认密码</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="password" id="registerPasswdAgain" name="password2"
                                       placeholder="确认密码" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <input type="submit" value="现在注册"/>
                                <%--<button type="submit" class="btn btn-danger">现在注册</button>--%>
                                <br/><br/>
                                <p class="text-danger">注册成会员并<strong>认证公司</strong>，获取更优惠价格及更好的服务</p>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="col-lg-5 col-lg-offset-1">
            <form class="bs-component form-horizontal" action = '<%=basePath%>simple/login.do' id="myForm" method="post">
                <fieldset>
                    <legend>会员登录</legend>
                    <label style="color: #ff0000;">${message}</label>
                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="loginEmail">邮箱</label>
                        <div class="col-lg-8">
                            <input
                                    class="form-control" id="loginEmail" name="email"
                                    type="text" placeholder="邮箱" required autofocus>
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


                        <!--<label class="col-lg-3 control-label">验证码</label>
                        <%--<div class="col-lg-9">
                            <input
                                    class="form-control" placeholder="验证码" name="verificationCode" id="verificationCode" required
                                    type="text">
                            <img id="imgObj" class="verifyCode"  alt="" src="<%=basePath%>xuan/verifyCode.do" onclick="changeImg()"/>
                            <a href="javascript:void(0);" onclick="changeImg()">换一张</a>
                        </div>--%>
                        <div class="col-lg-9">
                            <div id="drag"></div>
                        </div>-->

                    <div class="form-group">
                        <label class="col-lg-3 control-label" for="loginEmail"> </label>
                        <div class="col-lg-8">
                            <table width="100%">
                                <tr>
                                    <td style="height:50px; width:30px"><input id="check" checked="checked" style="width: 20px; height: 20px;" type="checkbox"></td>
                                    <td>&nbsp;记住账号</td>
                                </tr>
                            </table>
                            <table width="100%">
                                <tr>
                                    <td><input class="btn btn-primary" style="width: 100px;"  class="btn btn-primary" style="width: 100px;" value="会员登入" type="submit"></td>
                                    <td align="right"><a href="<%=basePath%>simple/toForgetPW.do">忘记密码</a></td>
                                </tr>

                            </table>

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
