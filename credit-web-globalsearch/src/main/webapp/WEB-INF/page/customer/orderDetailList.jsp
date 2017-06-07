<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
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
    <script type="text/javascript" src="<%=basePath%>/js/customer/orderDetailList.js"></script>


</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    var status = "<%=status%>";
    $(document).ready(function () {
        $("#orderDetailLi").addClass("active");
        $("#userLi").addClass("active");

    });
</script>
<body>
<jsp:include page="../include/top.jsp"/>

<%--<jsp:include page="${basePath}../include/topCommon.jsp"/>--%>
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
<br>
    <div class="container"  style="height:100%">
        <div id="banner">
        <p class="lead">My Reports</p>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Filter</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <form class="navbar-form navbar-left" role="search">
                        <input class="form-control" placeholder="Company Name" type="text" id="companyNameQuery">
                        <div class="form-group">
                            <select id="status" class="form-control fxq-select">
                                <option value="">All Status</option>
                                <option value="0">Cancel</option>
                                <option value="1">Unpaid</option>
                                <option value="2">Under Investigation</option>
                                <option value="3">To Be Assigned</option>
                                <option value="4">Order in Process</option>
                                <option value="5">Check Pending</option>
                                <option value="6">In Review</option>
                                <option value="7">To Be Released</option>
                                <option value="8">Order Finished</option>
                            </select>
                            <select id="productType" class="form-control fxq-select">
                                <option value="">All Report</option>
                                <option value="1">e-Check Report</option>
                                <option value="2">e-Compat Report</option>
                                <option value="3">e-Report</option>
                            </select>
                            <button type="button" class="btn btn-success" onclick="query();">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
            <div class="table-responsive" style="min-height:400px">
                <div class="row">
                    <input type="hidden" name="orderId" id="orderId"/>
                </div>
                <table id="orderDetailGrid" class="table table-hover table-bordered table-responsive">
                    <thead >
                    <tr>
                        <th data-column-id="id" data-type="numeric" data-order="asc" width="40%" data-visible="false">ID</th>
                        <th data-column-id="companyName" data-type="string" data-width="30%">Company Name</th>
                        <th data-column-id="createTime" data-formatter="createTime" data-type="string" data-width="12%">Creata Date</th>
                        <th data-column-id="productType" data-formatter="productType" data-type="string" data-width="12%">Report Type</th>
                        <th data-column-id="status" data-formatter="status" data-type="string" data-width="11%">Status</th>
                        <%--<th data-column-id="crefoNo" data-type="string" data-width="13%">CrefoNo</th>--%>
                        <th data-column-id="operate" data-formatter="operate" data-sortable="false" data-width="10%">Operation</th>
                    </tr>
                    </thead>
                </table>
            </div>
    </div>
</div>

<jsp:include page="../include/bottom.jsp"/>

</body>
</html>