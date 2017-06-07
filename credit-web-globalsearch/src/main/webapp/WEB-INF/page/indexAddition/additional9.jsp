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
    <title>Full Search- Business Verification</title>
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
        <p class="lead">Business Verification</p>
  </div>
     
  <div class="col-lg-8" style=" line-height:24px">
       <p>
           Your business credit is very important when you doing business around the world. Your business credit is often one of most important factors when your trader partners make business decision.
           <br>Establish your Business Credit at no cost
           <br>Improve your Business Credit
           <br>Market your Business online by building your Credibility with your trade partners
       </p>

      <p>
          Your business credit is very important when you doing business around the world. Your business credit is often one of most important factors when your trader partners make business decision.
          <br>Establish your Business Credit at no cost
          <br>Improve your Business Credit
          <br>Market your Business online by building your Credibility with your trade partners
      </p>

      <p>
          Your business credit is very important when you doing business around the world. Your business credit is often one of most important factors when your trader partners make business decision.
          <br>Establish your Business Credit at no cost
          <br>Improve your Business Credit
          <br>Market your Business online by building your Credibility with your trade partners
      </p>




    </div>
  <div class="col-lg-4">
    <div class="bs-component">
        <ul class="nav nav-pills nav-stacked">
            <li><a href="toIndexAddition8.do">About Us</a></li>
            <li class="active"><a href="toIndexAddition9.do">Business Verification</a></li>
            <li><a href="toIndexAddition10.do">Monitoring</a></li>
            <li ><a href="toIndexAddition11.do">O2C Solutions</a></li>
        </ul>
    </div>
  </div>
</div>

<jsp:include page="${basePath}../include/bottom.jsp"/>
</body>
</html>