<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="include/head.jsp" flush="true">
        <jsp:param name="title" value="500"/>
    </jsp:include>
</head>

<body class="error-page">

<section>
    <div class="container ">

        <section class="error-wrapper text-center">
            <h1><img alt="" src="${pageContext.request.contextPath}/frame/images/500-error.png"></h1>
            <h2>啊哦!!!</h2>
            <h3>看起来出错了.</h3>
            <a class="back-btn" href="#" onclick="javascript:window.history.back();"> 返回</a>
        </section>

    </div>
</section>

<jsp:include page="include/script.jsp" flush="true"/>
</body>
</html>
