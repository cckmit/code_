<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String patd = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + patd + "/";
%>
<div class="col-sm-3 col-md-2 sidebar">
  <ul class="nav nav-sidebar">
    <li class="active"><a href="#">客户首页 <span class="sr-only">(current)</span></a></li>
    <li><a href="<%=basePath%>customer/toCartList.do">我的购物车</a></li>
    <%--<li><a href="<%=basePath%>customer/historyList.jsp">我的浏览历史</a></li>--%>
    <li><a href="<%=basePath%>customer/toOrderList.do">我的订单</a></li>
    <li><a href="<%=basePath%>customer/toOrderDetailList.do">我的报告</a></li>
    <li><a href="<%=basePath%>customer/tochangedInformation.do">我的信息</a></li>
    <li><a href="<%=basePath%>customer/toRechargeList.do">充值记录</a></li>
  </ul>
</div>