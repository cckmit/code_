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
    <title>Full Search - Online Disclaimer</title>
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
        <p class="lead">Online Disclaimer</p>
    </div>
     
  <div class="col-lg-8" style=" line-height:24px">
       <p>
           <strong> Online Disclaimer Regarding Information</strong>
           <br>The information from or through this site is provided “as-is,”
           “as available,” and all warranties, expressed or implied, are disclaimed (
           including but not limited to the disclaimer of any implied warranties of
           merchantability and fitness for a particular purpose). The information may contain errors,
           problems or other limitations. Our sole and entire maximum liability for any inaccurate information,
           for any reason, and user’s sole and exclusive remedy for any cause whatsoever,
           shall be limited to the amount paid by the customer for the information received (if any).
           We are not liable for any indirect, special, incidental, or consequential damages (including damages for loss of business,
           loss of profits, litigation, or the like). Whether based on breach of contract, breach of warranty,
           tort (including negligence), product liability or otherwise, even if advised of the possibility of such damage.
           The limitations of damages set forth above are fundamental elements of the basis of this agreement between you and
           3ACredit Business Management Co. Ltd.. We would not provide this site and information without such limitations.
           No representations, warranties or guarantees whatsoever are made as to the accuracy, adequacy, reliability, timeliness,
           completeness, suitability or applicability of the information to a particular situation.
       </p>

      <p>
          All responsibility and liability for any damages caused by viruses contained within the electronic files of this site are disclaimed.
      </p>

      <p>
          All terms and conditions with respect to this site are governed by a Terms of the Service Agreement.
      </p>

      <p>
          <strong>Online Disclaimer Regarding Hyperlinks</strong>
          <br>This site contains links to other Internet sites. These links are provided solely as a convenience
          to you and are not endorsements of any products or services in such sites, and no information in
          such site has been endorsed or approved by us. These third party sites may also contain opinions
          and viewpoints of third parties that do not necessarily coincide with our opinions and viewpoints.
          Those sites may also have privacy policies different than our policy.
      </p>



  </div>
  <div class="col-lg-4">
    <div class="bs-component">
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="<%=basePath%>toBottom1.do">Online Disclaimer</a></li>
        <li><a href="<%=basePath%>toBottom2.do">Copyright Policy</a></li>
        <li><a href="<%=basePath%>toBottom3.do">Privacy Policy</a></li>
        <li ><a href="<%=basePath%>toBottom4.do">Terms of Use Agreement</a></li>
      </ul>
    </div>
  </div>
</div>

<jsp:include page="${basePath}../include/bottom.jsp"/>
</body>
</html>