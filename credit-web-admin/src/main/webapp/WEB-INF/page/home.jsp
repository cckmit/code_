<%--
  Created by IntelliJ IDEA.
  User: gavin
  Date: 16-10-31
  Time: 上午10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<html>
<jsp:include page="include/head.jsp" flush="true">
    <jsp:param name="title" value="首页"/>
</jsp:include>

<body class="mainFrame">
<section>
        <div class="page-heading">
            <ul class="breadcrumb">
                <li class="active">首页</li>
            </ul>
        </div>
        <div class="wrapper">

        </div>
</section>
<jsp:include page="include/script.jsp" flush="false"/>
</body>
</html>
