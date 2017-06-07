<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<script type="text/javascript">
    function selCountry(country) {
        $("#selCountry").val(country);
        $("#bsSuggest").val(country);
    }
</script>
<style type="text/css">
    ul.memberNav li {
        width: 105px;
        text-align: center;
    }
    ul.memberNav li a {
        padding: 5px;
    }




</style>
<%--头部--%>
<div class="navbar navbar-default navbar-fixed-top" style="height:32px;min-height: 32px;">
	<div class="container"  style="height: 32px;line-height: 32px;">
		<div class="navbar-header"  style="height: 32px;line-height: 32px;">
			<a href="<%=basePath%>" class="navbar-brand" style="font-size:12px;font-family:'Microsoft Yahei';padding:0;line-height: 32px;height: 32px;margin-left: 0px;">Global Eagle 全球鹰</a>
			<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse" id="navbar-main"  style="height: 32px;line-height: 32px;">

			<ul class="nav navbar-nav fixMuBan"  style="height: 32px;">

				<li id="indexLi"><a href="<%=basePath%>" style="background: none;font-size:12px;font-family:'Microsoft Yahei';padding:0;line-height: 32px;margin-left: 25px;height: 32px;">首页</a></li>
				<li><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="background: none;font-size: 12px;font-family:'Microsoft Yahei';padding:0;line-height: 32px;margin-left: 25px;height: 32px;">信用服务<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<%=basePath%>toIndexAddition1.do"  style="font-size:12px;font-family:'Microsoft Yahe';">实地认证服务</a></li>
						<li><a href="<%=basePath%>toIndexAddition2.do"  style="font-size:12px;font-family: 'Microsoft Yahei';">全球应收帐管理</a></li>
						<li><a href="<%=basePath%>toIndexAddition3.do"  style="font-size:12px;font-family: 'Microsoft Yahei';">当地司法服务</a></li>
						<li><a href="<%=basePath%>toIndexAddition4.do"  style="font-size:12px;font-family: 'Microsoft Yahei';">尽职调查服务</a></li>
						<li><a href="<%=basePath%>toIndexAddition5.do"  style="font-size:12px;font-family: 'Microsoft Yahei';">商业咨询服务</a></li>
						<li><a href="<%=basePath%>toIndexAddition6.do"  style="font-size:12px;font-family: 'Microsoft Yahei';">数据对接服务</a></li>

					</ul></li>
				<li id="fastAddLi"><a href="<%=basePath%>user/toFastAddOrder.do" style="background: none;font-size: 12px;font-family:'Microsoft Yahei';padding:0;line-height: 32px;margin-left: 25px;height: 32px;">快速订购</a></li>
				<li id="helpLi"><a href="<%=basePath%>help.do" style="background: none;font-size: 12px;font-family:'Microsoft Yahei';padding:0;line-height: 32px;margin-left: 25px;height: 32px;">帮助</a></li>
				<c:if test="${empty sessionScope.customerInfo}">
					<li id="loginLi"><a href="<%=basePath%>toLogin.do" style="background: none;font-size: 12px;font-family:'Microsoft Yahei';padding:0;line-height: 32px;margin-left: 25px;height: 32px;">注册/登陆</a></li>
					<%--<li class="active"><a data-toggle="modal" data-target="#loginModal" href="#">登陆/快速注册</a></li>--%>
				</c:if>
				<c:if test="${not empty sessionScope.customerInfo}">
					<li id="userLi" class="ative"><a href="#" style="background: none;font-size: 12px;font-family:'Microsoft Yahei';padding:0;line-height: 32px;margin-left: 25px;height: 32px;"
													 class="dropdown-toggle" data-toggle="dropdown">用户：${sessionScope.customerInfo.getEmail()}</a>
						<ul class="dropdown-menu">
								<%--<li><a href="<%=basePath%>user/toCartList.do">我的购物车</a></li>--%>
							<li><a href="<%=basePath%>customer/toOrderList.do">我的订单</a></li>
							<li><a href="<%=basePath%>customer/toOrderDetailList.do">我的报告</a></li>
							<li><a href="<%=basePath%>customer/toStatement.do">我的对账单</a></li>
							<li><a href="<%=basePath%>customer/tochangedInformation.do">个人信用信息
								<c:if test="${sessionScope.customerInfo.checkStatus=='是'}">
									<i class="fa fa-check-square" style="color: green"></i>
								</c:if>
							</a></li>
							<li><a href="<%=basePath%>toApproveCompany.do">企业信用名片</a></li>
							<li><a href="<%=basePath%>logout.do">注销</a></li>
						</ul></li>
				</c:if>
				<%-- <li><a href="<%=basePath%>toRegister.do">注册</a></li> --%>
			</ul>
		</div>
	</div>
	<%--<marquee style="color:yellow">本网站将于2016年12月21日14：00进行数据更新，届时服务全部停止，给您带来的不便敬请谅解！</marquee>--%>
</div>







<div class="container" style="padding-top: 30px;">
    <div class="row">
        <p>&nbsp;</p>
        <div class="col-lg-8" style="width: 1170px;">
			<div class="page-logo-nav-left" style="width: 170px;height: 40px;float: left;margin-top: 10px;">
				<a href="#" target="_blank" style="width: 170px;height: 40px;overflow: hidden">
					<img src="${pageContext.request.contextPath}/images/img/page-logo.png" alt="加载失败" title="全球鹰" style="width: 170px;height: 40px;" />
				</a>
			</div>
            <p class="bs-component">
				<form id="form" action="<%=basePath%>toSearchCompanyList.do" method="post"  onkeydown="if (event.keyCode==13) {$('#form').submit();}" style="float: left;margin-left: 100px;">
					<table height="40" border="0" align="left" cellpadding="0" cellspacing="0" width="500px;">
						<tbody>
						<tr>
							<td style="padding-right: 10px; width: 140px;">
								<div class="input-group">
									<input type="text" name="countryName" value="${countryName}" class="form-control input-lg searchCountry"
										   id="bsSuggest" style=" width:130px;height: 40px;border: 1px solid grey;font-size: 14px;" placeholder="国家" autocomplete="off"
										   required>
									<div class="input-group-btn">
										<button type="button" class="btn btn-default dropdown-toggle"
												data-toggle="dropdown">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
										</ul>
									</div>
								</div>
							</td>
							<td style="padding-right: 10px;">
								<!-- /btn-group -->
								<input class="form-control input-lg" id="companyNameDetail" name="companyName" type="text"
									   value="${companyName}" style="width:270px;height: 38px;border: 1px solid grey;font-size: 14px;" placeholder="输入目标公司名称/目标公司注册码" required>
							</td>
							<td>
								<a class="btn btn-lg btn-info" type="button" onclick="$('#form').submit();" style="height: 38px;font-size: 14px;padding-top: 10px;">搜索</a>
							</td>
						</tr>
						</tbody>
					</table>
				</form>
            </p>
			<div class="page-logo-nav-right" style="width: 250px;height: 40px;float: left;margin-left: 80px;">
				<a href="<%=basePath%>customer/toOrderDetailList.do" style="font-family: 'Microsoft Yahei';color:rgb(52, 152, 219);border: 1px solid rgb(52, 152, 219);font-size: 14px;height: 38px;line-height: 38px;width: 48%;float: left;text-align: center;text-decoration: none;">报告管理</a>
				<a href="<%=basePath%>customer/toOrderList.do"  style="font-family: 'Microsoft Yahei';color:rgb(52, 152, 219);border: 1px solid rgb(52, 152, 219);font-size: 14px;height: 38px;line-height: 38px;width: 48%;float: left;text-align: center;margin-left: 7px;text-decoration: none;">订单管理</a>
			</div>
            <label style="padding-top: 50px;padding-bottom: 10px;font-family: 'Microsoft Yahei';font-size:14px;color:#333;float: left;overflow: hidden;clear: both;zoom: 1;"> 关键词：${companyName}

                <span style="padding-left: 20px">搜索结果：
			<label id="companySize">0</label>
			条</span>
                <span
                        style="padding-left: 20px">国家或区域：${countryName}</span></label>

        </div>
        </form>

        <%--<c:if test="${not empty sessionScope.customerInfo}">--%>
        <%--<div class="col-lg-4">--%>
            <%--<div class="panel panel-info">--%>
                <%--<div class="panel-heading">--%>
                    <%--<h3 class="panel-title">订单管理</h3>--%>
                <%--</div>--%>
                <%--<div class="panel-body">--%>
                    <%--<div class="bs-component">--%>
                        <%--<ul class="nav nav-pills">--%>
                                <%--<li id="orderLi"><a href="<%=basePath%>customer/toOrderList.do">订单管理&nbsp;&nbsp;&nbsp;&nbsp;</a></li>--%>
                                <%--<li id="orderDetailLi"><a href="<%=basePath%>customer/toOrderDetailList.do">报告管理&nbsp;&nbsp;&nbsp;&nbsp;</a></li>--%>
                                <%--<li id="statementLi"><a href="<%=basePath%>customer/toStatement.do">对账单管理&nbsp;&nbsp;&nbsp;&nbsp;</a></li>--%>

                        <%--</ul>--%>
                    <%--</div>--%>
                <%--</div>--%>

            <%--</div>--%>
        <%--</div>--%>
        <%--</c:if>--%>

    </div>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/searchSuggest.js"></script>

