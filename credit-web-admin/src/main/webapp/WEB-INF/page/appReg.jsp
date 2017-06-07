<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<html lang="en">
<head>
    <jsp:include page="include/head.jsp" flush="true">
        <jsp:param name="title" value="应用申请"/>
    </jsp:include>
</head>
<body class="login-body">

<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/reg.do" method="post">
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">应用申请</h1>
            <img src="${pageContext.request.contextPath}/frame/images/login-logo.png" alt=""/>
        </div>

        <div class="login-wrap">
            <input type="text" name="appName" autofocus="" placeholder="应用名称" class="form-control">
            <p>请输入管理员信息</p>
            <input type="text" name="name" autofocus="" placeholder="姓名" class="form-control">
            <input type="text" name="code" autofocus="" placeholder="登录帐号" class="form-control">
            <input type="password" name="password" autofocus="" placeholder="密码" class="form-control">
            <input type="password" autofocus="" placeholder="确认密码" class="form-control">
            <input type="text" name="mobile" autofocus="" placeholder="联系电话" class="form-control">
            <div class="radios">
                <label for="radio-01" class="label_radio col-lg-6 col-sm-6">
                    <input type="radio" checked="" value="男" id="radio-01" name="gender"> 男
                </label>
                <label for="radio-02" class="label_radio col-lg-6 col-sm-6">
                    <input type="radio" value="女" id="radio-02" name="gender"> 女
                </label>
            </div>

            <label class="checkbox">
                <input type="checkbox" value="agree this condition"> 我同意应用使用相关条款
            </label>
            <button type="submit" class="btn btn-lg btn-login btn-block">
                <i class="fa fa-check"></i>
            </button>

            <div class="registration">
                已经申请
                <a href="#" onclick="todo('login')" class="">
                    登录
                </a>
            </div>

        </div>

    </form>

</div>

<jsp:include page="include/script.jsp" flush="true"/>

</body>
</html>
