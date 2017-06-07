<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<!-- left side start-->
<div class="left-side sticky-left-side">

    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="<%=basePath%>manager/index.do"><img src="<%=basePath%>images/index/logo.png" alt=""></a>
    </div>

    <div class="logo logo-icon">
        <a href="<%=basePath%>manager/index.do"><img src="<%=basePath%>images/index/logo.min.png" alt=""></a>
    </div>
    <!--logo and iconic logo end-->

    <div class="left-side-inner">
        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li id="pCenterLi" class="menu-list"><a href=""><i class="fa fa-home"></i> <span>个人中心</span></a>
                <ul class="sub-menu-list">
                    <li id="indexLi"><a href="<%=basePath%>manager/index.do"> 我的主页</a></li>
                    <li><a href="index.html"> 登陆记录</a></li>
                </ul>
            </li>
            <li id="orderLi" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>订单管理</span></a>
                <ul class="sub-menu-list">
                    <li id="orderListLi1"><a href="<%=basePath%>manager/toOrderListAll.do?orderLevel=2"> 未处理订单</a></li>
                    <li id="orderListLi2"><a href="<%=basePath%>manager/toOrderListAll.do"> 所有订单</a></li>
                </ul>
            </li>
            <li id="orderDetailLi" class="menu-list"><a href=""><i class="fa fa-file"></i> <span>国际报告管理</span></a>
                <ul class="sub-menu-list">
                    <li id="orderDetailListLi1"><a href="<%=basePath%>manager/toOrderDetailListAll.do?orderLevel=2&orderStatusId=1"> 未处理报告</a></li>
                    <li id="orderDetailListLi2"><a href="<%=basePath%>manager/toOrderDetailListAll.do"> 所有报告</a></li>

                </ul>
            </li>
            <li id="orderDetailLiChina" class="menu-list"><a href=""><i class="fa fa-file-o"></i> <span>中国报告管理</span></a>
                <ul class="sub-menu-list">
                    <li id="orderDetailListLiChina1"><a href="<%=basePath%>manager/toOrderDetailListAllChina.do?orderLevel=2&orderStatusId=1"> 未处理报告</a></li>
                    <li id="orderDetailListLiChina2"><a href="<%=basePath%>manager/toOrderDetailListAllChina.do"> 所有报告</a></li>

                </ul>
            </li>
            <li id="orderDetailLiCustom" class="menu-list"><a href=""><i class="fa fa-file-text"></i> <span>快速订购报告管理</span></a>
                <ul class="sub-menu-list">
                    <li id="orderDetailListLiCustom1"><a href="<%=basePath%>manager/toOrderDetailListAllCustom.do?orderLevel=2&orderStatusId=1"> 未处理报告</a></li>
                    <li id="orderDetailListLiCustom2"><a href="<%=basePath%>manager/toOrderDetailListAllCustom.do"> 所有报告</a></li>
                </ul>
            </li>
            <li><a href=""><i class="fa fa-money"></i> <span>充值管理</span></a></li>
            <li class="menu-list"><a href=""><i class="fa fa-cogs"></i> <span>系统设置</span></a>
                <ul class="sub-menu-list">
                    <li><a href="grids.html"> 帐号管理</a></li>
                    <li><a href="grids.html"> 邮箱设置</a></li>
                    <li><a href="gallery.html"> 网站统计</a></li>
                    <li><a href="calendar.html"> 系统日志</a></li>

                </ul>
            </li>

            <li id="basicLi" class="menu-list"><a href=""><i class="fa fa-cog"></i> <span>基础设置</span></a>
                <ul class="sub-menu-list">
                    <li id="regionAndCountryLi"><a href="<%=basePath%>manager/toRegionAndCountry.do"> 区域和国家</a></li>
                </ul>
            </li>
            <li id="docLi" class="menu-list"><a href=""><i class="fa fa-ambulance"></i> <span>服务中心</span></a>
                <ul class="sub-menu-list">
                    <li id="helpLi"><a href="<%=basePath%>manager/toHelpList.do"> 帮助文档</a></li>
                    <li id="customerLi"><a href="<%=basePath%>manager/toCustomerList.do"> 用户认证</a></li>
                </ul>
            </li>
            </li>

            <li><a href="#" class="logoutA"><i class="fa fa-sign-out"></i> <span>退出</span></a></li>

        </ul>
        <!--sidebar nav end-->

    </div>
</div>
<!-- left side end-->
