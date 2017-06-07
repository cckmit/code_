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
    <title>Full Search - About us</title>
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
        <p class="lead">About Us</p>
    </div>
     
  <div class="col-lg-8" style=" line-height:24px">
       <p>
           <strong>CnBLZsearch</strong>
           is an online tool designed for our clients to make their jobs easier and more convenient.
           You can search companies, order credit reports, manage your client portfolio,
           place claims for collection, track your order's progress, see collection activities,
           and correspond with your service representatives. We provide below services.
       </p>
      <p>
          <strong>Company Search</strong>
          <br>Direct access to business information on over 45,000,000 active Chinese companies.
          <br>Verify company information.
          <br>Get fresh, relevant and exclusive information on your customers and prospects.
      </p>
      <p>
          <strong>Credit Reports</strong>
          <br>Reliability: Company registration record and current financial data are obtained ONLY from government sources, which are considered to be the most reliable info available.
          <br>Factual Info: Report only contents factual information regarding the subject company, no unnecessary system template texts or other irrelevant (even misleading) personal opinions.
          <br>Int’l Standard: Report quality meets international standards.
      </p>
      <p>
          <strong>Verification & Monitoring</strong>
          <br>Effective customer information update.
          <br>Online maintenance of customer data.
          <br>Easily updatable customer base for monitoring.
          <br>Customized monitoring solution.
          <br>Red flag warning service.
      </p>
      <p>
          <strong>Value Added Customer Service</strong>
          <br>Track orders online via cnBizsearch tool.
          <br>Service by personal representatives.
          <br>Obtain free basic information on Chinese companies.
          <br>Members receive discounts on 3ACredit’s various supporting services.
      </p>



  </div>
  <div class="col-lg-4">
    <div class="bs-component">
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="toIndexAddition8.do">About Us</a></li>
        <li><a href="toIndexAddition9.do">Business Verification</a></li>
        <li><a href="toIndexAddition10.do">Monitoring</a></li>
        <li ><a href="toIndexAddition11.do">O2C Solutions</a></li>
      </ul>
    </div>
  </div>
</div>

<jsp:include page="${basePath}../include/bottom.jsp"/>
</body>
</html>