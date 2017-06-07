  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Material for Publish</title>
<script type="text/javascript" src="inc/js/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="inc/js/tip.js" ></script>
<script type="text/javascript">
</script>
</head>
<body>
<div>
 	<ul>
          	 <c:forEach var="mainSearch" items="${mainSearch}" varStatus="status">
          	 <li class="hot_box_con_line">          	
                <div class="hot_box_con_line_right">
                    <p>${mainSearch.getId()}. </p>
                  	<p>${mainSearch.getName()}. </p>
                	<input class="text"  type="button" id="auditSuccess" onclick="addorder()" value="审核通过"  />
                	<input class="text"  type="button" id="auditFailure" onclick="addorder()" value="审核不通过"  />
                	
                </div>            
             </li>
             </c:forEach>
    </ul>
</div>
</body>
</html>