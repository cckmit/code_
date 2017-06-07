<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
$(function () {
	if ($('#title').html()=='Products'+'<span class="caret"></span>'){
        $('#title').html('Products'+'<span class="caret"></span>');
        $("#type").val('Products');
        $('#companyName').attr('placeholder','Enter Product and Service');

	}else {
        $('#title').html('Companies'+'<span class="caret"></span>');
        $("#type").val('Companies');
        $('#companyName').attr('placeholder','Enter Chinese company name or Reg ID');
	};
    $(".fxq-addbox-click").click(function(e){
        $(".fxq-login-addbox").toggleClass("fxq-addbox-active");
        e.stopPropagation();
    });
    $(document).click(function (e) {
        $(".fxq-login-addbox").addClass("fxq-addbox-active");
        e.stopPropagation();
    });
});

$(function () {
    if($('#codeId').html()) {
        var codeLength = $('#codeId').html().length;
        var codeHtml = $('#codeId').html();
        if (codeLength > 44) {
            $('#codeId').html(codeHtml.substring(0, 44) + "***");
        }
    }
});
    function fullSearchCompany(){
        if ($('#companyName').val()==null||$('#companyName').val()==""){
            BootstrapDialog.alert("Company name cannot be empty");
        }else{
            $('#form').submit();
        }
    }

    function disableEnter(event){
        var keyCode = event.keyCode?event.keyCode:event.which?event.which:event.charCode;
        if (keyCode ==13){
            fullSearchCompany();
        }
    }

    function changeTitle(title){
       $('#title').html(title+'<span class="caret"></span>');
       $('#type').val(title);
        if (title=='Companies'){
            $('#companyName').attr('placeholder','Enter Chinese company name or Reg ID');
        }else {
            $('#companyName').attr('placeholder','Enter Product and Service');
        }
    }


</script>
<div class="navbar navbar-default navbar-fixed-top" style="min-width:1200px;">
	<div class="container">
		<div class="navbar-header">
			<a href="${pageContext.request.contextPath}/index.do" class="navbar-brand" style="padding: 0;padding-top:5px">
				<img src="<%=basePath%>/images/site/elogo.png" alt="" style="width:auto;height:40px;">
			</a>
			<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse" id="navbar-main">
			<ul class="nav navbar-nav">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
					   aria-expanded="true" id="title">${type}<span class="caret"></span></a>
					<ul id="dropdown-menu-check" class="dropdown-menu" role="menu">
						<li ><a onclick="changeTitle('Companies')">Companies</a></li>
						<li><a onclick="changeTitle('Products')">Products</a></li>
					</ul>
				</li>
			</ul>
			<form id="form" class="navbar-form navbar-left" action="<%=basePath%>toSearchCompanyList.do" method="post">
				<div class="form-group">
					<input type="hidden" name="type" id="type" value="${type}">
					<input class="form-control" placeholder="Enter Chinese company name or Reg ID" type="text" name="companyName" id="companyName">
				</div>
				<button type="button" class="btn btn-default" onclick="fullSearchCompany()" onkeydown="return disableEnter(event)">Search</button>
			</form>
			<%--<ul class="nav navbar-nav navbar-right">--%>
				<%--<li><a href="#">Support</a></li>--%>
			<%--</ul>--%>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${not empty sessionScope.customerInfo}">
					<li>
						<ul class="fxq-topindex">
							<li><a href="${pageContext.request.contextPath}/customer/toOrderDetailList.do">My Reports</a></li>
							<li><a href="${pageContext.request.contextPath}/customer/toCollectionList.do">My Favorites</a></li>
						</ul>
					</li>
					<li id="helpLi"><a href="<%=basePath%>help.do" style="background-color: transparent;">Help</a></li>
					<li class="fxq-addbox-click" style="position: relative;">
						<a href="#" id="codeId"><i class="fa fa-user"></i>&nbsp;&nbsp;${sessionScope.customerInfo.code}</a>
						<ul class="fxq-login-addbox fxq-addbox-active">
							<li><a href="${pageContext.request.contextPath}/customer/toOrderList.do">My Orders</a></li>


							<li><a href="${pageContext.request.contextPath}/customer/toCreditService.do">My Services</a></li>
							<li><a href="<%=basePath%>customer/tochangedInformation.do">My Account
								<c:if test="${sessionScope.customerInfo.checkStatus=='是'}">
									<i class="fa fa-check-square" style="color: green"></i>
								</c:if>
							</a></li>
							<li><a href="${pageContext.request.contextPath}/logout.do">Logout</a></li>
							<li class="fxq-login-sjx"></li>
							<li class="fxq-login-sjx2"></li>
						</ul>
					</li>
				</c:if>
				<c:if test="${empty sessionScope.customerInfo}">
					<li><a href="${pageContext.request.contextPath}/toLogin.do" style="color: #fff;">Login&nbsp;/&nbsp;Register</a></li>
				</c:if>
				<%--<li id="fastAddLi"><a href="<%=basePath%>user/toFastAddOrder.do" style="background-color: none;">Quick order</a></li>--%>
				<%--<li id="helpLi"><a href="<%=basePath%>help.do" style="background-color: none;">Help</a></li>--%>
			</ul>

		</div>
	</div>
</div>

