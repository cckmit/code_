<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="登录记录"/>
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
                            登录记录
                        </header>
                        <div class="panel-body">
                            <table id="grid-data" class="table-hover general-table">
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
                    </section>
                </div>
            </div>
        </section>

        <jsp:include page="../include/script.jsp" flush="false"/>

        <script src="${pageContext.request.contextPath}/js/core/loginRecordList.js"></script>
</body>
</html>
