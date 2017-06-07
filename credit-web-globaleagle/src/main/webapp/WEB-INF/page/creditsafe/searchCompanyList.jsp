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

<script type="text/javascript">
	var countryName = '${requestScope.countryName}';
	var companyName = '${requestScope.companyName}';
	var customerInfo = "${sessionScope.customerInfo}";
	var customerLevel = "${sessionScope.customerInfo.levelId}";

</script>
	<script src="${pageContext.request.contextPath}/js/creditsafe/searchCompanyList.js"></script>
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
        
		<div id="progress-bar" class="panel panel-primary" style="margin-top: 20px">
			<div class="panel-heading">
				<h3 class="panel-title">数据查询中...</h3>
			</div>
			<div class="panel-body">
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-primary" role="progressbar" data-transitiongoal="100"></div>
				</div>
			</div>
		</div>
				<table id="searchCompanyListGrid"  class="table table-striped table-responsive">
				<thead>
				<c:if test="${countryName=='中国'}">
					<tr>
						<th width="15%">当地注册号</th>
						<th width="30%">公司注册名称</th>
						<th width="10%">状态</th>
						<th width="10%">区域</th>
						<th width="15%">其他</th>
						<th width="10%">查询</th>
					</tr>
				</c:if>
				<c:if test="${countryName!='中国'}">
					<tr>
						<th width="10%">当地注册号</th>
						<th width="10%">VAT号</th>
						<th width="28%">公司名</th>
						<th width="7%">状态</th>
						<th width="10%">报告时间</th>
						<th width="16%">国家及城市</th>
						<th width="10%">地址</th>
						<th width="10%">查询</th>
					</tr>
				</c:if>

				</thead>
				<tbody id="result">
				</tbody>
			</table>
		<!-- 精确搜索 暂时不要
		<div id="searchCompanyDetail" class="panel panel-primary" style="margin-top: 20px">
			<div class="panel-heading">
				<h3 class="panel-title">精确搜索</h3>
			</div>
			<div class="panel-body">
				<h5>没有搜索到结果，您还可以在下方进行精确搜索：</h5>
				<form id="formDetail" action="<%=basePath%>toSearchCompanyList.do" method="post">
					<div class="input-group">
						<input class="form-control input-lg" placeholder="请输入公司全称"
							   id="companyName" name="companyName" type="text" />
						<span class="input-group-btn">
                      <button class="btn btn-lg btn-info" type="button" onclick="$('#formDetail').submit();">搜索</button>
				</span>
					</div>
				</form>
			</div>
		</div> -->
	</div> <!-- /.container -->
</div>
<jsp:include page="${basePath}../include/bottomCommon.jsp"/>
<%-- 		<jsp:include page="${basePath}../include/bottomCommon.jsp"/>
 --%>	<!-- Scripts -->
	<script src="<%=basePath%>pageFrame/js/min/plugins.min.js"></script>
	<script src="<%=basePath%>pageFrame/js/min/medigo-custom.min.js"></script>


</body>
</html>