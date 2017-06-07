<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String status = "";
    if (request.getParameter("status") != null) {
        status = request.getParameter("status");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="../include/include.jsp"/>
    <title>Full Search</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.theme.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/customer/collectionList.js"></script>

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    var status = "<%=status%>";
    var orderNo = "${orderNo}";
    $(document).ready(function () {
        $("#orderLi").addClass("active");
        $("#userLi").addClass("active");
    });
</script>
<body>
<jsp:include page="../include/top.jsp"/>
<br>

<%--<jsp:include page="${basePath}../include/topCommon.jsp"/>--%>
<div class="container" style="height:100%">

    <div id="banner" >
        <p class="lead">My Favorite</p>
        <div class="table-responsive" style="min-height:400px">
            <table id="collectionrGrid" class="table table-hover table-bordered table-responsive">
                <thead >
                <tr>
                    <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                    <th data-column-id="collectionCompany" data-type="string" data-width="50%">Company Name</th>
                    <th data-column-id="collectionTime" data-formatter="collectionTime" data-type="string" data-width="10%">Added Time</th>
                    <th data-column-id="operate" data-formatter="operate" data-sortable="false" data-width="15%">Operation</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>

<jsp:include page="${basePath}../include/bottom.jsp"/>

</body>
</html>