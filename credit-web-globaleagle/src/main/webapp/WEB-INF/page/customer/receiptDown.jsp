<%--
  Created by Mike.
  User: Mike
  Date: 2016/9/8
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>全球鹰-收据信息</title>
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript">
        window.onload=function() {
                          var tbl = document.getElementById("table"); // 先获取table
                         var rows = tbl.getElementsByTagName("tr"); // 获取里面的行tr
                        for(i=0;i<rows.length;i++) {  // 遍历里面的行
                                    if(i%2==0){ // 再通过取模来设置每隔3行显示不同的两种颜色
                                        rows[i].style.backgroundColor="#eeefef";
                                       }else{
                                         rows[i].style.backgroundColor="#fff";
                                         }
                               }
                   };
        function receiptDown() {
            window.print();
        }
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /><br />
    <style type="text/css">
        p {font-family:Arial; font-size:11pt; padding:0 0 0 10px;}
        #p1 {font-family:Arial; font-size:10pt; padding:0 0 0 10px; color:#666}
        #user {font-family:Arial; font-size:11pt; padding:0 0 0 10px; line-height:200%;color:#023e86;font-weight:bold;}
        #user1 {font-size:9pt; padding:0 0 0 10px; line-height:200%;}

    </style>
    <title>无标题文档</title>

</head>
<body>
<!----head---------->
<div style="width:800px; margin:0 auto; padding:50px 0 0 0;">
    <div style="margin:0 auto; height:90px; background:url(${pageContext.request.contextPath}/images/receipt/Global-eagle.png) no-repeat; border:0px solid blue;border-bottom:5px solid #898989;">
        <div style="padding:25px 20px 0 0; float:right;"><img onclick="receiptDown()" src="${pageContext.request.contextPath}/images/receipt/print.png"></div>
    </div>
</div>

<!--user-->

<div style="width:800px; margin:20px auto; height:150px; text-align:left;">
    <div style="width:470px; height:150px; float:left;">
        <p id="user">账号: ${customer.email}</p>
        <p id="user1">感谢您的订购，我们正在处理您的订购信息<br>
            本次订购会显示在您的账户中, 您可以登陆全球鹰进行管理账号: </p>
    </div>
<c:if test="${not empty order}">
<div style="width:320px; height:150px; float:right;border:2px solid #dddddd;">
        <div style="width:320px; height:30px; float:right; background-color:#CCC;">
            <div>订单信息</div></div>
        <p id="user">
            订单日期:<fmt:formatDate value="${order.getCreateTime()}" type="date"/><br>
            订单编号: ${order.getNo()}<br>
            订单总额：${order.getAmount()}<br>
            订单数量： ${order.getDetailCount()}</p>
    </div>
    </c:if>
</div>

</div>
<!---info----->
<div style="width:800px; height:30px; margin:10px auto; background-color:#bed2d2;">
    <div style="font-size :11pt; padding:5px 0 0 10px;  float:left">订单明细</div>
</div>

<div style="width:800px; margin:0px auto;">
<c:if test="${order.getOrderDetails().size()>=0}">
<table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#CCCCCC" id="table">
        <tr>
            <td width="160"><p id="p1">国家</p></td>
            <td><p id="p1">公司名</p></td>
            <td width="180"><p id="p1">类型</p></td>
        </tr>
        <c:forEach var="orderDetails" items="${order.getOrderDetails()}" varStatus="status">
            <tr bgcolor="#eeefef">
                <td><p>${orderDetails.getCountryName()}</p></td>
                <td><p> ${orderDetails.getCompanyName()}</p></td>
                <td><p>
                    <c:if test="${orderDetails.getProductId()=='1'}">
                        数据库报告
                    </c:if>
                    <c:if test="${orderDetails.getProductId()=='2'}">
                        数据库完整报告
                    </c:if>
                    <c:if test="${orderDetails.getProductId()=='3'}">
                        完整版报告
                    </c:if>
                    <c:if test="${orderDetails.getProductId()=='4'}">
                        完整版报告-加急
                    </c:if>
                </p></td>
            </tr>
        </c:forEach>

    </table>
    </c:if>
</div>
<!---bottom--------->
<div style="height:80px;"></div>
<div style="width:800px; height:20px; margin:0 auto; font-size :9pt;border-top:5px solid #898989; text-align:center ">版权所有 © 2016­-2020 全球鹰  保留所有权利</div>
</body>
</html>


