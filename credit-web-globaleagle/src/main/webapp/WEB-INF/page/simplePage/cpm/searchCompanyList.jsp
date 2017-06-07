<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>全球鹰-搜索</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
 	<jsp:include page="../include/include.jsp" flush="true"/>
<!-- <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
 <script src="${pageContext.request.contextPath}/frame/bootstrap/js/bootstrap.min.js"></script>-->

	<%--<script src="${pageContext.request.contextPath}/js/cpm/searchCompanyList.js"></script>--%>
<%--<script type="text/javascript">--%>
	<%--var countryName = '${requestScope.countryName}';--%>
	<%--var companyName = '${requestScope.companyName}';--%>
	<%--var isAccurate = '${requestScope.isAccurate}';--%>
	<%--var customerInfo = "${sessionScope.customerInfo}";--%>
	<%--var customerLevel = "${sessionScope.customerInfo.levelId}";--%>
<%--</script>--%>
	<style type="text/css">
		#searchCompanyListGrid th {
			color: #333;
		}
	</style>
</head>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<div id="banner">
	<div class="container">
        
		<div id="progress-bar" class="panel panel-primary" style="margin-top: 20px;">
			<div class="panel-heading">

			</div>
			<!----<div class="panel-body">
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-primary" role="progressbar" data-transitiongoal="100"></div>
				</div>
			</div>--->
		</div>

				<table id="searchCompanyListGrid"  class="table table-striped table-responsive">
					<thead>
						<tr>
							<th width="20%">当地注册号</th>
							<th width="30%">公司中文名</th>
							<!-- <th width="30%">公司英文名</th> -->
							<th width="20%">国家及省份</th>
							<th width="10%">备注</th>
							<th width="10%">查询</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${not empty impDatas}">
					<c:forEach items="${impDatas}"  var="list" varStatus="status">
						<form method="post" action="<%=basePath%>simple/user/addCartOption.do" >
						<tr>
							<td>${list.crefoNo}<input type="hidden" name="crefoNo" value="${list.crefoNo}"></td>
							<td>${list.nameCN}<input type="hidden" name="companyName" value="${list.nameCN}"></td>
							<td>${countryName}&nbsp;&nbsp;&nbsp;${list.provinceCN}<input type="hidden" name="countryName" value="${countryName}"><input type="hidden" name="province" value="${countlist.provinceCN}"></td>
							<td>${list.remark}</td>
							<td><input class="btn btn-primary" style="width: 100px;"  type="submit" value="详细内容"></td>
						</tr>
						</form>
					</c:forEach>
					</c:if>
					</tbody>
				</table>

		<h5><p align="center" style="color: #902b2b;font-size: large;">${msg}</p></h5>
		<!-- 精准搜索 -->
		<div id="searchCompanyDetail" class="panel panel-primary" style="margin-top: 20px;display:none;">
			<div class="panel-heading">
				<h3 class="panel-title">精准搜索</h3>
			</div>
			<div class="panel-body">
				<h5>没有搜索到结果，您还可以在下方进行精准搜索：</h5>
				<form id="formDetail" action="<%=basePath%>toSearchCompanyList.do" method="post">
					<div class="input-group">
						<input type="hidden" name="isAccurate" value="Y"/>
						<input type="hidden" name="countryName" value="中国"/>
						<input class="form-control input-lg" placeholder="请输入公司全称"  id="companyNameAccurate" name="companyName" type="text" value="${companyName}"/>
						<span class="input-group-btn">
                      <button class="btn btn-lg btn-info" type="button" onclick="$('#formDetail').submit();">精准搜索</button>
				</span>
					</div>
				</form>
			</div>
		</div>
	</div> <!-- /.container -->
</div>
<jsp:include page="${basePath}../include/bottomCommon.jsp"/>
<%-- 		<jsp:include page="${basePath}../include/bottomCommon.jsp"/>
 --%>	<!-- Scripts -->
	<%--<script src="<%=basePath%>pageFrame/js/min/plugins.min.js"></script>--%>
	<%--<script src="<%=basePath%>pageFrame/js/min/medigo-custom.min.js"></script>--%>


</body>
</html>