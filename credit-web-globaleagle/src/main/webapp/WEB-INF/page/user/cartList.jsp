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
    <title>全球鹰-购物车</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="../include/include.jsp"/>
    <script src="<%=basePath%>js/user/cartList.js"></script>

</head>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    var email = "${customerInfo.email}";
    $(document).ready(function () {
        $("#cartLi").addClass("active");
        $("#userLi").addClass("active");
    });
</script>
<body>
<jsp:include page="${basePath}../include/topCommon.jsp"/>
<div class="container">
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
    <div id="banner">
        <p class="lead">购物车</p>
        <table id="cartListGrid" class="table table-hover table-bordered table-responsive bootgrid-table">
            <thead>
            <tr>
                <th data-column-id="id" data-type="numeric" data-identifier="true" data-visible="false">ID</th>
                <th data-column-id="countryName" data-type="string" data-width="30%">国家名称</th>
                <th data-column-id="companyName" data-type="string" data-width="28%">公司名称</th>
                <th data-column-id="orderLevel" data-formatter="orderLevel" data-type="string" data-width="12%">报告类型</th>
                <th data-column-id="totalPrice" data-formatter="totalPrice" data-type="numeric" data-width="10%">订单价格</th>
                <th data-column-id="createDate" data-formatter="createDate" data-type="sring" data-width="10%">创建日期</th>
                <th data-column-id="operate" data-formatter="operate" data-sortable="false" data-width="10%">操作</th>
            </tr>
            </thead>
        </table>
        <div class="row">
            <div class="col-lg-12"></div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="bs-component">

                </div>
            </div>
            <div class="col-lg-6">
                <div class="bs-component">
                    <blockquote class="pull-right">
                        <p>您的订单总额为
                            CNY <strong id="totalPrice">0.00</strong>，
                            订单数量为
                            <strong id="totalCount">0</strong>个，
                        </p>
                        <!-- 								<small>该订单原价12800.00, 折扣为1200.00</small>
                         -->
                        <p style="padding-top: 20px">
                            <button type="button" class="btn btn-primary btn-lg"
                                    data-toggle="modal" data-target="#myModal" onclick="deleteSelectedCart();">删除所选信息
                            </button>
                            <button type="button" class="btn btn-danger btn-lg"
                                    data-toggle="modal" data-target="#myModal" onclick='addOrder();'>点击支付
                            </button>
                        </p>
                    </blockquote>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${basePath}../include/bottomCommon.jsp"/>

<jsp:include page="../include/customer/recharge.jsp"/>
<script>
    $(document).ready(function () {

        $('.navbar .dropdown, .dropdown-submenu').hover(function () {
        }, function () {
        });

        $('#featureCarousel').carousel({
            interval: 4000
        });

        var clickEvent = false;
        $('#featureCarousel').on('click', '.nav a', function () {
            clickEvent = true;
            $('.nav li').removeClass('active');
            $(this).parent().addClass('active');
        }).on('slid.bs.carousel', function (e) {
            if (!clickEvent) {
                var count = $('#featureCarousel .nav').children().length - 1;
                var current = $('#featureCarousel .nav li.active');
                current.removeClass('active').next().addClass('active');
                var id = parseInt(current.data('slide-to'));

                if (count == id) {
                    $('#featureCarousel .nav li').first().addClass('active');
                }
            }
            clickEvent = false;
        });
    });
</script>
</body>
</html>