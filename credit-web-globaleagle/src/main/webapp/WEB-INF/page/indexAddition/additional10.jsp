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
    <title>全球鹰-帮助</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../include/include.jsp"/>
    <script type="text/javascript" src="<%=basePath%>js/base64.js"></script>

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
</script>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<div class="container">
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
     
  <div >
        <p class="lead">样本下载</p>
    </div>
     
  <div class="col-lg-8" style=" line-height:24px">
       

               <p ><strong>选择所在国家</strong><strong> </strong></p>
               <hr>
               <div class="content">
               <table width="90%">
               <tr>
               <td width="20%" height="60px" ><img src="<%=basePath%>images/countrycode/中国.png"> 中国 | CN</td>
               <td width="30%"  ><a  href="<%=basePath%>upload/demo/全球鹰样本报告.pdf" target="_blank">报告样式下载</a></td>
               <td width="20%"  ><img src="<%=basePath%>images/countrycode/美国.png"> 美国 | US</td>
               <td width="30%"  ><a  href="">报告样式下载</a></td>
               </tr>
               <tr>
               <td  height="60px"><img src="<%=basePath%>images/countrycode/日本.png"> 日本 | JP</td>
               <td ><a  href="">报告样式下载</a></td>
               <td ><img src="<%=basePath%>images/countrycode/德国.png"> 德国 | DE</td>
               <td ><a  href="">报告样式下载</a></td>
               </tr>
               <tr>
               <td  height="60px"><img src="<%=basePath%>images/countrycode/法国.png"> 法国 | FR</td>
               <td ><a  href="">报告样式下载</a></td>
               <td ><img src="<%=basePath%>images/countrycode/英国.png"> 英国 | GB</td>
               <td ><a  href="">报告样式下载</a></td>
               </tr>
               <tr>
               <td   height="60px"><img src="<%=basePath%>images/countrycode/巴西.png"> 巴西 | BR</td>
               <td ><a  href="">报告样式下载</a></td>
               <td ><img src="<%=basePath%>images/countrycode/印度.png"> 印度 | IN</td>
               <td ><a  href="">报告样式下载</a></td>
               </tr>
               <tr>
               <td  height="60px"><img src="<%=basePath%>images/countrycode/俄罗斯.png"> 俄罗斯 | RU</td>
               <td ><a  href="">报告样式下载</a></td>
               <td ><img src="<%=basePath%>images/countrycode/意大利.png"> 意大利 | IT</td>
               <td ><a  href="">报告样式下载</a></td>
               </tr>
               <tr>
               <td height="60px"><img src="<%=basePath%>images/countrycode/加拿大.png"> 加拿大 | CA</td>
               <td ><a  href="">报告样式下载</a></td>
               <td ><img src="<%=basePath%>images/countrycode/澳洲.png"> 澳洲 | AU</td>
               <td ><a  href="">报告样式下载</a></td>
               </tr>
               <tr>
               <td height="60px"><img src="<%=basePath%>images/countrycode/西班牙.png"> 西班牙 | ES</td>
               <td ><a  href="">报告样式下载</a></td>
               <td ><img src="<%=basePath%>images/countrycode/韩国.png"> 韩国 | KR</td>
               <td ><a  href="">报告样式下载</a></td>
               </tr>
               <tr>
               <td  height="60px"><img src="<%=basePath%>images/countrycode/墨西哥.png"> 墨西哥 | MX</td>
               <td ><a  href="">报告样式下载</a></td>
               <td ></td>
               <td ></td>
               </tr>
               </table>


		</div>
        <hr>
<p align="center"></p>
    <p>&nbsp;</p>

    <p>&nbsp;</p>
  </div>
  <div class="col-lg-4">
    <div class="bs-component">
      <ul class="nav nav-pills nav-stacked">
        <li><a href="toIndexAddition8.do">关于我们</a></li>
        <li><a href="toIndexAddition9.do">工作机会</a></li>
        <li class="active"><a href="toIndexAddition10.do">样本下载</a></li>
        <li><a href="toIndexAddition11.do">隐私及保密</a></li>
        <li><a href="toIndexAddition12.do">法律声明</a></li>
        <li ><a href="toIndexAddition7.do">用户协议</a></li>
      </ul>
    </div>
  </div>
</div>

<jsp:include page="${basePath}../include/bottomCommon.jsp"/>
</body>
</html>