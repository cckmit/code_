<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Full Search - Copyright Policy</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript" src="<%=basePath%>js/base64.js"></script>

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
</script>
<body>
<jsp:include page="${basePath}../include/topIndex.jsp"/>
<div class="container">
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
     
  <div >
        <p class="lead">Copyright Policy</p>
    </div>
     
  <div class="col-lg-8" style=" line-height:24px">
       <p>
           Unless otherwise stated, the logo, copyright, database and similar rights in all published material on the 3ACredit website are owned by 3ACredit Business Management Co. Ltd.. You are only permitted to print or download from this material for only your personal use. None of this material may be used for any commercial or public use. 
           <br>No part of the 3ACredit website or any material appearing on the site may be reproduced, stored in or transmitted to any other Web site without written permission of 3ACredit Business Management Co. Ltd.. You may send your requests to republish any material to info@3Acredit.com.
       </p>


  </div>
  <div class="col-lg-4">
    <div class="bs-component">
        <ul class="nav nav-pills nav-stacked">
            <li><a href="<%=basePath%>toBottom1.do">Online Disclaimer</a></li>
            <li class="active"><a href="<%=basePath%>toBottom2.do">Copyright Policy</a></li>
            <li><a href="<%=basePath%>toBottom3.do">Privacy Policy</a></li>
            <li ><a href="<%=basePath%>toBottom4.do">Terms of Use Agreement</a></li>
        </ul>
    </div>
  </div>
</div>

<jsp:include page="${basePath}../include/bottom.jsp"/>
</body>
</html>