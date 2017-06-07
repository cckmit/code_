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

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    $(function () {
        $("#creditService").bootgrid({
            ajaxSettings: {
                method: "POST",
                cache: false
            },
            ajax: true,
            url: basePath + "customer/creditServiceList.do",
            formatters: {
                "amount": function (column, row) {
                    var str;
                    if (row.hasPay) {
                        str = row.amount + ".00";
                    } else {
                        str = row.amount + ".00";
                    }
                    return str;
                }
            }
        });
    });

</script>
<body>
<jsp:include page="../include/top.jsp"/>
<br>

<div class="container" style="height:100%">

    <div id="banner" >
        <p class="lead">My Service</p>

        <div class="table-responsive" style="min-height:400px">
            <table id="creditService" class="table table-hover table-bordered table-responsive">
                <thead >
                <tr>
                    <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                    <th data-column-id="keyword" data-type="string" data-width="10%">Keywords</th>
                    <th data-column-id="demand" data-type="string" data-width="10%">Demand</th>
                    <th data-column-id="companyName" data-type="string" data-width="30%">Company Name</th>
                    <th data-column-id="amount" data-type="number"  data-width="5%">Amount</th>
                    <th data-column-id="industryName" data-type="string" data-width="15%">Industry Name</th>
                    <th data-column-id="region" data-type="string" data-width="15%">Region</th>
                    <th data-column-id="type" data-type="string" data-width="15%">Type</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>

<jsp:include page="../include/bottom.jsp"/>

</body>
</html>