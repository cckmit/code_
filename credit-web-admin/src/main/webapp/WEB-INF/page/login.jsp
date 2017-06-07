<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="include/head.jsp" flush="true">
            <jsp:param name="title" value="登录"/>
        </jsp:include>
    </head>
<body class="login-body">

<div class="container">

    <form id="loginForm" class="form-signin validateForm" action="${pageContext.request.contextPath}/login.do" method="post">
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">登录</h1>
            <img src="${pageContext.request.contextPath}/frame/images/login-logo.png" alt=""/>
        </div>
        <div class="login-wrap">
            <label style="color: #ff0000;">${message}</label>
            <input name="username" type="text" class="form-control" placeholder="登录名" autofocus required>
            <input name="passwd" type="password" class="form-control" placeholder="密码" required>

            <button class="btn btn-lg btn-login btn-block" type="submit">
                <i class="fa fa-check"></i>
            </button>

            <label class="checkbox">
                <input type="checkbox" value="remember-me"> 记住登录状态
                <span class="pull-right">
                    <a data-toggle="modal" href="#myModal"> 忘记密码?</a>

                </span>
            </label>

        </div>

        <!-- Modal -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">忘记密码 ?</h4>
                    </div>
                    <%--<div class="modal-body">--%>
                        <%--<p>请输入你的电子邮箱地址</p>--%>
                        <%--<input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">--%>
                    <%--</div>--%>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                        <button class="btn btn-primary" type="button">提交</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- modal -->
    </form>

</div>



<jsp:include page="include/script.jsp" flush="true"/>
<script src="${pageContext.request.contextPath}/js/sys/login.js"></script>

</body>
</html>
