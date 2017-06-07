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
    <title>全球鹰-关于我们</title>
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
        <p class="lead">关于我们</p>
    </div>
     
  <div class="col-lg-8" style=" line-height:24px">
       

               <p><strong>全球鹰</strong>企业信用信息平台是一个面向中国企业提供全球企业在线信用信息查询及相关风控服务的平台，服务涵盖180多个国家，可在线查询超过3亿家企业信用信息。商安信（上海）企业管理咨询股份有限公司（证券代码 832754）全权负责运营全球鹰企业信用信息平台。</p>
                  <p>&nbsp;</p>

<p align="center"><img src="<%=basePath%>images/aboutlogo.jpg" width="567" height="94" alt=""/></p>
                  <p>&nbsp;</p>

               <p><strong>商安信</strong>是中国信用和风险管理领域的权威机构。公司创立于2008年，总部位于中国经济、贸易和金融中心上海，业务涉及资信报告、信用评估、信用认证、应收账款管理等领域。公司成立之初便获得了欧洲最大的信用信息服务机构Creditreform（德国信用改革联合会）的授权，以Creditreform（中国）的名义在亚太区负责整个Creditreform集团的市场开发，业务拓展以及相关的客户服务。</p>
               <p><strong>Creditreform</strong> 1879年在德国诺依斯成立，至今已有135年历史，是世界著名的信用信息服务提供商，旗下拥有信息，评级，保理，商帐管理，数据营销等事业分支。在24个国家有独立的公司，全球168个非独立办事机构，员工总数超过 5,000，全球客户20万家，年销售收入6亿欧元，仅商业信用报告一项每年全球销售就超过1,800万份。</p>
               <p>凭借在国际商业信息数据采集和分析，及应收账综合管理领域的核心竞争力，商安信结合中国市场的需求，为客户提供全方位的商业信用及风险管理的支持和优化服务，帮助客户防范信用风险，释放信用价值。</p>
               <p></p>
                  <p>&nbsp;</p>
                  <p>&nbsp;</p>
                  <p>&nbsp;</p>
                  <p>&nbsp;</p>

    <p>&nbsp;</p>
    </div>
  <div class="col-lg-4">
    <div class="bs-component">
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="toIndexAddition8.do">关于我们</a></li>
        <li><a href="toIndexAddition9.do">工作机会</a></li>
        <li><a href="toIndexAddition10.do">样本下载</a></li>
        <li ><a href="toIndexAddition11.do">隐私及保密</a></li>
        <li><a href="toIndexAddition12.do">法律声明</a></li>
        <li  ><a href="toIndexAddition7.do">用户协议</a></li>
      </ul>
    </div>
  </div>
</div>

<jsp:include page="${basePath}../include/bottomCommon.jsp"/>
</body>
</html>