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
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="include/head.jsp" flush="true">
  <jsp:param name="title" value="首页"/>
</jsp:include>

</head>
<body class="sticky-header" style="overflow: hidden">
<section>
  <jsp:include page="include/menu.jsp" flush="true"/>

  <!-- main content start-->
  <div class="main-content" >
<jsp:include page="include/top.jsp" flush="true"/>
    <!--body wrapper start-->
        <iframe id="myIframe" name="mainFrame" onload="changeIframeHeight()" scrolling="auto" frameborder="0" width="100%"></iframe>
    <!--body wrapper end-->

    <jsp:include page="include/bottom.jsp" flush="true"/>
  </div>
  <!-- main content end-->
</section>
<jsp:include page="include/script.jsp" flush="true"/>
<script src="${pageContext.request.contextPath}/frame/js/scripts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sys/changePass.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        toPage('','','to.do?page=home');
        $("#liIndex").addClass("active");
    });

    function toPage(id, cid, url){
        $("#liIndex").removeClass("active");
        $("li[name='cateLi']").removeClass("nav-active");
        $("li[name='menuLi']").removeClass("active");
        $("#cate" + cid).addClass("nav-active");
        $("#menu" + id).addClass("active");
        top.mainFrame.location.href = basePath +"/"+url;
    }

    function changeIframeHeight() {
        var ifm= document.getElementById("myIframe");
        ifm.height=document.documentElement.clientHeight - document.getElementById("indexHeader").scrollHeight - document.getElementById("indexFooter").scrollHeight ;
    }
    window.onresize=function(){
        changeIframeHeight();
    }
</script>
</body>
</html>
