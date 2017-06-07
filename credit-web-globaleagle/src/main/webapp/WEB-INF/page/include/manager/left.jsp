<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<div class="left-side sticky-left-side">

    <div class="logo">
        <a href="<%=basePath%>manager/index.do"><img src="<%=basePath%>images/index/logo.png" alt=""></a>
    </div>

    <div class="logo logo-icon">
        <a href="<%=basePath%>manager/index.do"><img src="<%=basePath%>images/index/logo.min.png" alt=""></a>
    </div>
    <div class="left-side-inner">
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li id="pCenterLi" class="menu-list"><a href=""><i class="fa fa-home"></i> <span>个人中心</span></a>
                <ul class="sub-menu-list">
                    <li id="indexLi"><a href="<%=basePath%>manager/index.do"> 我的主页</a></li>
                    <li id="recordLi"><a href="<%=basePath%>manager/toLoginRecordList.do">登陆记录</a></li>
                    <li><a href="index.html">待办事项</a></li>

                </ul>
            </li>
            <li id="orderLi" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>订单管理</span></a>
                <ul class="sub-menu-list">
                    <%--<li id="orderListLi1"><a href="<%=basePath%>manager/toOrderListAll.do?orderLevel=2"> 未处理订单</a></li>--%>
                    <li id="orderListLi2"><a href="<%=basePath%>manager/toOrderListAll.do"> 所有订单</a></li>
                </ul>
            </li>

            <li id="orderDetailLi" class="menu-list"><a href=""><i class="fa fa-file"></i> <span>报告管理</span></a>
                <ul class="sub-menu-list">
                    <%--<li id="orderDetailListLi1"><a href="<%=basePath%>manager/toOrderDetailListAll.do?orderLevel=2&orderStatusId=1"> 未处理报告</a></li>--%>
                    <%--<li id="orderDetailListLi2"><a href="<%=basePath%>manager/toOrderDetailListAll.do"> 所有报告</a></li>--%>
                        <li><a href="index.html">中国报告</a></li>
                        <li><a href="index.html">外国报告</a></li>
                        <li><a href="index.html">自定义报告</a></li>

                </ul>
            </li>
            <%--<li id="orderDetailLiChina" class="menu-list"><a href=""><i class="fa fa-file-o"></i> <span>中国报告管理</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="orderDetailListLiChina1"><a href="<%=basePath%>manager/toOrderDetailListAllChina.do?orderLevel=2&orderStatusId=1"> 未处理报告</a></li>--%>
                    <%--<li id="orderDetailListLiChina2"><a href="<%=basePath%>manager/toOrderDetailListAllChina.do"> 所有报告</a></li>--%>

                <%--</ul>--%>
            <%--</li>--%>
            <%--<li id="orderDetailLiCustom" class="menu-list"><a href=""><i class="fa fa-file-text"></i> <span>快速订购报告管理</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="orderDetailListLiCustom1"><a href="<%=basePath%>manager/toOrderDetailListAllCustom.do?orderLevel=2&orderStatusId=1"> 未处理报告</a></li>--%>
                    <%--<li id="orderDetailListLiCustom2"><a href="<%=basePath%>manager/toOrderDetailListAllCustom.do"> 所有报告</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>


            <li id="accountStatement" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>对账单管理</span></a>
                <ul class="sub-menu-list">
                    <li id="accountStatement1"><a href="<%=basePath%>manager/toAccountStatement.do"> 所有对账单</a></li>
                </ul>
            </li>


            <li id="reCharge" class="menu-list"><a href=""><i class="fa fa-money"></i> <span>充值管理</span></a>
                <ul class="sub-menu-list">
                    <li id="reChargeList"><a href="<%=basePath%>manager/toRechargeList.do">充值记录</a></li>
                    <li id="reChargeCustomer"><a href="<%=basePath%>manager/toReChargeCustomer.do">用户充值</a></li>
                </ul>
            </li>

            <li id="userManagement" class="menu-list"><a href=""><i class="fa fa-money"></i> <span>用户管理</span></a>
                <ul class="sub-menu-list">
                    <li id="userManagementLi"><a href="<%=basePath%>manager/toManagerList.do">用户列表</a></li>
                </ul>
            </li>

            <li id="productManagement" class="menu-list"><a href=""><i class="fa fa-money"></i> <span>商品管理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="index.html">商品列表</a></li>
                </ul>
            </li>

            <li id="customerManagement" class="menu-list"><a href=""><i class="fa fa-money"></i> <span>客户管理</span></a>
                <ul class="sub-menu-list">
                    <li id="customerManagementLi"><a href="<%=basePath%>manager/toCustomerList.do">客户列表</a></li>
                </ul>
            </li>

            <li id="basicLi" class="menu-list"><a href=""><i class="fa fa-cog"></i> <span>基础设置</span></a>
                <ul class="sub-menu-list">
                    <li id="regionAndCountryLi"><a href="<%=basePath%>manager/toRegionAndCountry.do"> 区域和国家</a></li>
                </ul>
            </li>


            <li class="menu-list"><a href=""><i class="fa fa-cogs"></i> <span>系统设置</span></a>
                <ul class="sub-menu-list">
                    <li><a href="grids.html">邮箱设置</a></li>
                    <li><a href="calendar.html">系统日志</a></li>
                </ul>
            </li>

            <li id="docLi" class="menu-list"><a href=""><i class="fa fa-ambulance"></i> <span>运营中心</span></a>
                <ul class="sub-menu-list">
                    <li><a href="calendar.html">优惠活动</a></li>
                    <li id="helpLi"><a href="<%=basePath%>manager/toHelpList.do">帮助文档</a></li>
                    <li id="customerLi"><a href="<%=basePath%>manager/toCustomerList.do">用户认证</a></li>
                </ul>
            </li>
            </li>

            <li><a href="#" class="logoutA"><i class="fa fa-sign-out"></i> <span>退出</span></a></li>

        </ul>

    </div>
</div>
