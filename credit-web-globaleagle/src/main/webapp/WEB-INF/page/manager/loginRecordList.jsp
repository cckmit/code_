<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="../include/include.jsp"/>
    <link href="<%=basePath%>css/dashboard.css" rel="stylesheet">
    <script src="<%=basePath%>js/customer/rechargeList.js"></script>
    <script type="text/javascript">
        var basePath = "<%=basePath%>";
        $(document).ready(function () {
            $("#pCenterLi").addClass("nav-active");
            $("#recordLi").addClass("active");
        });
    </script>
</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    function method(i){
        $('#methodId').val(i);
    }
</script>
<body>
<jsp:include page="${basePath}../include/topManager.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="${basePath}../include/customer/left.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">登录记录</h2>
            <div class="table-responsive">
                <table id="rechargeGrid" class="table table-condensed table-hover table-striped">
                    <thead>
                    <tr>
                        <th data-column-id="id" data-type="numeric" data-order="asc">ID</th>
                        <th data-column-id="code" data-type="sring">登录名</th>
                        <th data-column-id="loginCount" data-type="sring">登录次数</th>
                        <th data-column-id="lastTime" data-formatter="lastTime" data-type="sring">最后登录时间</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../include/customer/recharge.jsp"/>
</body>
</html>