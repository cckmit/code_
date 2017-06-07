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
<html lang="en">
<head>
    <jsp:include page="include/include.jsp"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Full Search - Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <style>
        .navbar-holder-dark {
            padding: 20px 20px 200px 20px;
            background: #333333;
        }
    </style>
<script type="text/javascript">

        $(function () {
            var messageRegister= $("#messageRegister").text();
            if (messageRegister=='User name already exists'||messageRegister=='User name password cannot be empty'){
                $(".login-fxq-inputbox").css("display","none");
                $("#registration").addClass("input-first").siblings().removeClass("input-first");
            }
        })

        var companyName = '${requestScope.companyName}';
        var customerInfo = "${sessionScope.customerInfo}";

        function submitRegister() {
            if ($("#registerCode").val() == null || $("#registerCode").val() == "") {
                BootstrapDialog.alert("Email address is null");
                return false;
            }
            if ($("#registerCode").val() != $("#registerEmail").val()) {
                BootstrapDialog.alert("Email is not consistent");
                return false;
            }
            if ($("#registerPasswd").val() == null || $("#registerPasswd").val() == "") {
                BootstrapDialog.alert("Password cant be empty");
                return false;
            }
            if($("#registerPasswd").val().length<6){
                BootstrapDialog.alert("Enter the password at least six bits");
                return false;
            }
            if ($("#registerPasswd").val() != $("#registerPasswordAgagin").val()){
                BootstrapDialog.alert("Enter the password twice");
                return false;
            }
            if (!isEmail($("#registerEmail").val())) {
                return false;
            }

            return true;
        }

        function submitLogin() {
            if ($("#loginEmail").val() == null || $("#loginEmail").val() == "") {
                BootstrapDialog.alert("Email address is not nul");
                return false;
            }
            if ($("#loginPasswd").val() == null || $("#loginPasswd").val() == "") {
                BootstrapDialog.alert("Password cant be empty");
                return false;
            }
            if (!isEmail($("#loginEmail").val())) {
                return false;
            }
            return true;
        }

        function isEmail(strEmail) {
            if (strEmail
                    .search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1) {
                return true;
            } else {
                BootstrapDialog.alert("Please enter the correct email format");
                return false;
            }
        }

    </script>

</head>
<body>
<jsp:include page="include/top.jsp"/>
<br><br>

<div class="container">
    <div class="bs-docs-section">

        <div class="login-out">
            <legend style="font-size: 26px;">&nbsp;&nbsp;&nbsp;&nbsp;Login Your Account</legend>
    <div class="login-con">
        <!-- 登录或注册 -->
        <div class="login-left">
            <div class="login-btn" style="mrgin-bottom:10px">
                <div class="login-name input-first login-name-click">Login&nbsp;&nbsp;&nbsp;</div>
                <%--<div style="margin:0 6px" class="fxq-line">|</div>--%>
                <div id="registration" class="login-name login-name-click login-fxq-btn">Registration</div>
            </div>
            <div class="login-write" style="position: relative;">

                <!-- 登录开始 -->
                <form  action="<%=basePath%>login.do" method="post" onsubmit="return submitLogin();" class="fxq-form" style="z-index: 2">
                    <label style="color: #ff0000;">${message}</label>
                    <ul class="login-inputbox login-fxq-inputbox" style="line-height: 40px;">
                        <li>
                            <span class="login-name login-email" style="display:block">Username(Email)</span>
                            <input type="email" placeholder="Email" id="loginEmail" name="code">
                        </li>
                        <li>
                            <span class="login-name" style="display:block">Password</span>

                            <input type="password" placeholder="Password" id="loginPasswd" name="passwd">
                        </li>
                        <%--<li>--%>
                            <%--<span class="login-name" style="display:block">Code</span>--%>

                            <%--<input type="password" placeholder="Password"  name="passwd" style="width: 70%;">--%>
                            <%--<div style="display:inline-block;width: 62px;height: 20px;background: #000;vertical-align:middle"></div>--%>
                        <%--</li>--%>
                        <li style="margin-top: 15px;">
                            <input type="submit" class="login-sub btn-default" value="Login" style="text-indent: 0" style="width: 82%;">
                            <a href="<%=basePath%>toForgetPW.do" class="login-forget" style="display: block;">FORGET PASSWORD？</a>

                        </li>

                    </ul>
                </form>
                <!-- 登录结束 -->
                <!-- 注册开始 -->
                <form action="<%=basePath%>register.do" method="post" onsubmit="return submitRegister();" class="fxq-form">
                    <label style="color: #ff0000;" id="messageRegister">${messageRegister}</label>
                    <ul class="login-inputbox" style="line-height: 40px;">
                        <li>
                            <span class="login-name login-email" style="display:block">Email Address</span>
                            <input type="text" placeholder="Email" name="code" id="registerCode">
                        </li>
                        <li>
                        <span class="login-name  login-email" style="display:block">Confirm Email</span>
                        <input type="text" placeholder="Confirm Email" id="registerEmail" name="email" >
                        </li>
                        <li>
                            <span class="login-name" style="display:block">Password</span>
                            <input type="password" placeholder="Password"  name="passwd" id="registerPasswd">
                        </li>
                        <li>
                            <span class="login-name" style="display:block">Confirm Password</span>
                            <input type="password" placeholder="Confirm Password"  id="registerPasswordAgagin" name="passwdAgain">
                        </li>
                        <%--<li>--%>
                            <%--<span class="login-name" style="display:block">Code</span>--%>
                            <%--<input type="password" placeholder="Password"  name="passwd" style="width: 70%;">--%>
                            <%--<div style="display:inline-block;width: 62px;height: 20px;background: #000;vertical-align:middle"></div>--%>
                        <%--</li>--%>

                        <li style="margin-top: 15px;">
                            <input type="submit" class="login-sub btn-default" value="Submit"  style="text-indent: 0">
                        </li>
                    </ul>
                </form>
                <!-- 注册结束 -->

            </div>
        </div>
        <div class="login-mid">
            <div class="login-line"></div>
            <div class="login-or">OR</div>
        </div>
        <!-- 其他方式登录 -->
        <div class="login-right">
            <div style="font-size: 24px;line-height: 50px;margin-top: 90px">Sign in with</div>
            <div>
                <a href="##" class="login-facebook">FaceBook</a><a href="##" class="login-google">Google+</a>
            </div>
        </div>
    </div>
</div>

           
    </div>

</div>
<br>

<jsp:include page="${basePath}include/bottom.jsp"/>


</div>




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

    // 邮箱手机选项卡
//    var loginbtn=$(".login-name-click")
//    var loginbox=$(".fxq-form")
//    var nowloginbtn=$(".login-name-click:first")
//    var nowloginbox=$(".fxq-form:nth-child(1)")
//    var num=0;
//    loginbtn.click(function(){
//        $("#registration").removeClass("input-first");
//        nowloginbtn.removeClass("input-first");
//        $(this).addClass("input-first");
//        nowloginbtn=$(this);
//        var next=$(this).index();
//        loginbox.filter(nowloginbox).css("zIndex","2").end().eq(":not()").css("zIndex","1");
//        num=next;
//        nowloginbox=loginbox.eq(next)
//
//    })
    $(".login-name-click").click(function(){
        $(".login-name-click").eq($(this).index()).addClass("input-first").siblings().removeClass("input-first");
        $(".fxq-form").eq($(this).index()).css("zIndex","2").siblings().css("zIndex","1")
    })




// 验证邮箱
// function testEmail(str){
//   var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
//     if(reg.test(str)){
//         alert("true");
//     }else{
//         alert("false");
//     }
// }

// var loginemail=$(".login-email")
// loginemail.onblur(function(){
    
// })
// console.log(testEmail("22222"))


</script>

</body>
</html>