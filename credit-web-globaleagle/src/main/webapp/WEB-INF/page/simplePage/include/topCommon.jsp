<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

//    List<Country> countries = ((CountryMapper) SpringContextUtils.getBean("countryMapper")).selectEabled();
//    pageContext.setAttribute("countries", countries);
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
<jsp:include page="./top.jsp"/>
<div class="container" style="padding-top: 60px;">
    <div class="row">
        <p>&nbsp;</p>
        <div class="col-lg-8">
            <p class="bs-component">
            <form id="form" action="<%=basePath%>simple/cpmSearchCompanyList.do" method="post">
                <table height="59" border="0" align="left" cellpadding="0" cellspacing="0" width="100%">
                    <tbody>
                    <tr>
                        <td style="padding-right: 10px; width: 140px;">
                            <div class="input-group" style="height:46px; width: 140px;">
                                <select name="countryName" class="form-control input-lg searchCountry">
                                    <option value="中国" selected>中国</option>
                                    <option value="英国">英国</option>
                                    <option value="美国">美国</option>
                                    <option value="德国">德国</option>
                                    <option value="法国">法国</option>
                                    <option value="比利时">比利时</option>
                                    <option value="丹麦">丹麦</option>
                                    <option value="西班牙">西班牙</option>
                                    <option value="意大利">意大利</option>
                                    <option value="韩国">韩国</option>
                                    <option value="卢森堡">卢森堡</option>
                                    <option value="墨西哥">墨西哥</option>
                                    <option value="荷兰">荷兰</option>
                                    <option value="挪威">挪威</option>
                                    <option value="葡牙萄">葡萄牙</option>
                                    <option value="瑞典">瑞典</option>
                                </select>
                            </div>
                        </td>
                        <td style="padding-right: 10px;">
                            <!-- /btn-group -->
                            <input class="form-control input-lg" id="companyNameDetail" name="companyName" type="text"
                                   value="${companyName}" placeholder="输入目标公司名称/目标公司注册码" onfocus="this.value = '';"
                                   onblur="if (this.value == '') {this.value = '输入目标公司名称/目标公司注册码';}" required>
                        </td>
                        <td>
                            <input type="submit" value="搜索">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>

            </p>
            <label style="padding-top: 10px"> 关键词：${companyName}

                <span style="padding-left: 20px">搜索结果：
            <c:if test="${count > 0}">
			    <label id="companySize">${count}</label>
            </c:if>
            <c:if test="${count <= 0}">
                <label id="companySize">0</label>
            </c:if>
			条</span>
                <span
                        style="padding-left: 20px">国家或区域：${countryName}</span></label>

        </div>
        </form>


        <div class="col-lg-4">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">账户管理</h3>
                </div>
                <div class="panel-body">
                    <div class="bs-component">
                        <ul class="nav nav-pills">

                            <li id="cartLi"><a href="<%=basePath%>simple/user/cartList.do">购物车&nbsp;&nbsp;&nbsp;&nbsp;
                                <%--购物车 订单 数量 --%>
                            <%--<span--%>
                                    <%--class="badge">--%>
                                    <%--<c:if test="${not empty sessionScope.cartCount}">--%>
                                        <%--${sessionScope.cartCount}--%>
                                    <%--</c:if>--%>
                                    <%--<c:if test="${empty sessionScope.cartCount}">--%>
                                        <%--0--%>
                                    <%--</c:if>--%>
                                <%--</span>--%>
                            </a></li>
                            <c:if test="${not empty sessionScope.customerInfo}">

                                <li id="orderLi"><a href="<%=basePath%>simple/customer/orderList.do">订单管理&nbsp;&nbsp;&nbsp;&nbsp;
                                    <%--<span--%>
                                            <%--class="badge">--%>
                                                                                <%--购物车 订单 数量 --%>

                                    <%--<c:if test="${not empty sessionScope.orderCount}">--%>
                                        <%--${sessionScope.orderCount}--%>
                                    <%--</c:if>--%>
                                    <%--<c:if test="${empty sessionScope.orderCount}">--%>
                                        <%--0--%>
                                    <%--</c:if>--%>
                                <%--</span>--%>
                                </a></li>
                                <%--<li id="orderDetailLi"><a href="<%=basePath%>simple/customer/toOrderDetailList.do">报告管理&nbsp;&nbsp;&nbsp;&nbsp;--%>
                                <li id="orderDetailLi"><a href="<%=basePath%>simple/customer/orderDetailList.do">报告管理&nbsp;&nbsp;&nbsp;&nbsp;

                                <%--<span--%>
                                            <%--class="badge">--%>
                                        <%--购物车 订单 数量 --%>
                                    <%--<c:if test="${not empty sessionScope.orderDetailCount}">--%>
                                        <%--${sessionScope.orderDetailCount}--%>
                                    <%--</c:if>--%>
                                    <%--<c:if test="${empty sessionScope.orderDetailCount}">--%>
                                        <%--0--%>
                                    <%--</c:if>--%>
                                <%--</span>--%>
                                </a></li>
                            </c:if>

                        </ul>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>
</div>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/searchSuggest.js"></script>--%>


<%-- <div class="first-widget parallax" id="blog">
	<div class="parallax-overlay">
		<div class="container pageTitle">
			<div class="row">
				<div class="col-md-8 col-sm-8">
					<p>
					<form id="form" action="<%=basePath%>toSearchCompanyList.do" method="post">
						<input type="text" value="${countryName}" name="countryName"  required  style="width:160px">
						<input type="text" value="${companyName}" name="companyName" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = ' Company Name';}" required  style="width:360px">
						<button class="mainBtn" id="submit" onclick="$('#form').submit();">Search <i class="icon-button fa fa-search"></i></button>
					</form>
					</p>
					<c:set var="companyInfo" value="${CompaniesInfo}"/>
					Keyword: adidas Total: ${fn:length(companyInfo)}
				</div> <!-- /.col-md-6 --><!-- /.col-md-6 -->
			</div> <!-- /.row -->
		</div> <!-- /.container -->
	</div> <!-- /.parallax-overlay -->
</div> <!-- /.pageTitle --> --%>
