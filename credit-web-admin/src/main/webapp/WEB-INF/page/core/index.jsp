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
</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    $(document).ready(function(){
        $("#pCenterLi").addClass("nav-active");
        $("#indexLi").addClass("active");
    });
</script>
<body class="sticky-header">

<section>
    <jsp:include page="${basePath}../include/menu.jsp" flush="true"/>
    <div class="main-content">
        <jsp:include page="${basePath}../include/top.jsp" flush="true"/>
        <!-- page heading start-->
        <div class="page-heading">
            <ul class="breadcrumb">
                <li>个人中心</li>
                <li class="active">首页</li>
            </ul>
        </div>
        <!-- page heading end-->
        <!--body wrapper start   主体内容放在wrapper层内-->
        <div class="wrapper">

        </div>
    </div>
</section>

<jsp:include page="../include/script.jsp" flush="false"/>

</body>
</html>
