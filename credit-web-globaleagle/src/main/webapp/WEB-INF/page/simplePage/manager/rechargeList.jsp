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
    <jsp:include page="${basePath}../include/manager/include.jsp" flush="true"/>
    <link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/jquery.bootgrid.js"></script>
    <script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/bootstrapValidator.min.js"></script>
    <link type="text/css" src="<%=basePath%>frame/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet" />
    <script type="text/javascript" src="<%=basePath%>js/base64.js"></script>
    <script src="<%=basePath%>/js/manager/rechargeList.js"></script>

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    $(document).ready(function(){
        $("#reCharge").addClass("nav-active");
        $("#reChargeList").addClass("active");
    });
</script>
<body class="sticky-header">

<section>
    <jsp:include page="${basePath}../include/manager/left.jsp" flush="true"/>
    <div class="main-content">
        <jsp:include page="${basePath}../include/manager/top.jsp" flush="true"/>
        <!-- page heading start-->
        <div class="page-heading">
            <ul class="breadcrumb">
                <li>充值管理</li>
                <li class="active">充值记录</li>
            </ul>
        </div>
        <!-- page heading end-->
        <!--body wrapper start   主体内容放在wrapper层内-->
        <div class="wrapper">
            <table id="grid-data" class="table table-condensed table-hover table-striped">
                <thead>
                <tr>
                    <th data-column-id="id" data-type="numeric" data-order="asc">ID</th>
                    <th data-column-id="methodId" data-type="sring" data-formatter="method">充值方式</th>
                    <th data-column-id="amount" data-type="sring">充值金额（元）</th>
                    <%--<th data-column-id="statusId" data-type="sring">充值状态</th>--%>
                    <th data-column-id="customerName" data-type="sring">客户账号</th>
                    <th data-column-id="managerName" data-type="sring">管理员账号</th>
                    <th data-column-id="createDate" data-formatter="createDate" data-type="sring">充值日期</th>
                    <%--<th data-column-id="operate" data-formatter="operate">操作</th>--%>
                </tr>
                </thead>
            </table>
        </div>
        <!--body wrapper end-->
        <jsp:include page="${basePath}../include/manager/bottom.jsp" flush="true"/>
    </div>
</section>
</body>
</html>
