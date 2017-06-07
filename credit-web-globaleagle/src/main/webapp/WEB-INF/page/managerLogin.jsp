<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="${basePath}include/manager/include.jsp" flush="true"/>
</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
</script>
<body class="login-body">

<div class="container">

    <form class="form-signin" action="<%=basePath%>gEML2016.do" method="post">
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">登陆</h1>
            <img src="${basePath}images/index/logo.png" alt=""/>
        </div>
        <div class="login-wrap">
            <input type="text" name="code" class="form-control" placeholder="用户名" autofocus>
            <input type="password" name="passwd" class="form-control" placeholder="密码">

            <button class="btn btn-lg btn-login btn-block" type="submit">
                <i class="fa fa-check"></i>
            </button>
            <label style="color: #ff0000;">${message}</label>

        </div>

    </form>

</div>



<!-- Placed js at the end of the document so the pages load faster -->

<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>

</body>
</html>
