<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//此句避免jsp:param中文乱码
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/head.jsp" flush="true">
        <jsp:param name="title" value="我的主页"/>
    </jsp:include>
</head>

<body class="mainFrame">
<section>
    <div class="wrapper">

    </div>
</section>

<jsp:include page="../include/script.jsp" flush="false"/>
</body>
</html>
