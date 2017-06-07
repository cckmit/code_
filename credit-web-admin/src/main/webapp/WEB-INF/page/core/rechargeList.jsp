<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="充值管理"/>
    </jsp:include>
</head>

<body class="mainFrame">
<section>
    <div class="wrapper">
        <section class="panel">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            充值记录
                        </header>
            <div class="panel-body">
                <table id="grid-data" class="table-hover general-table">
                <thead>
                <tr>
                    <th data-column-id="id" data-type="numeric" data-order="asc" data-visible="false">ID</th>
                    <th data-column-id="customerName" data-type="string">客户账号</th>
                    <th data-column-id="amount" data-type="float" data-formatter="amount">充值金额（元）</th>
                    <%--<th data-column-id="statusId" data-type="sring">充值状态</th>--%>
                    <th data-column-id="managerName" data-type="string">管理员账号</th>
                    <th data-column-id="payMethod" data-type="string" data-formatter="payMethod">充值方式</th>
                    <th data-column-id="appName" data-type="string" data-formatter="appName">充值渠道</th>
                    <th data-column-id="finishTime" data-formatter="finishTime" data-type="string">充值日期</th>
                    <%--<th data-column-id="operate" data-formatter="operate">操作</th>--%>
                </tr>
                </thead>
            </table>
        </div>
        </section>
    </div>
            </div>
</section>

<jsp:include page="../include/script.jsp" flush="false"/>

<script src="${pageContext.request.contextPath}/js/core/rechargeList.js"></script>
</body>
</html>
