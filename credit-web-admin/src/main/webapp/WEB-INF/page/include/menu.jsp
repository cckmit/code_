<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<%--
  Created by IntelliJ IDEA.
  User: gavin
  Date: 16-11-2
  Time: 上午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- left side start-->
<div class="left-side sticky-left-side">

    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="${pageContext.request.contextPath}/index.do"><img src="${pageContext.request.contextPath}/frame/images/logo.png" alt=""></a>
    </div>

    <div class="logo-icon text-center">
        <a href="${pageContext.request.contextPath}/index.do"><img src="${pageContext.request.contextPath}/frame/images/logo_icon.png" alt=""></a>
    </div>
    <!--logo and iconic logo end-->

    <div class="left-side-inner">
        <ul class="nav nav-pills nav-stacked custom-nav">
            <%--<li id="pCenterLi" class="menu-list"><a href=""><i class="fa fa-home"></i> <span>个人中心</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="indexLi"><a href="javascript:void(0);" onclick="toPage('liIndex','pCenterLi','basic/home.do','我的主页')">我的主页</a></li>--%>
                    <%--<li id="recordLi"><a href="javascript:void(0);" onclick="toPage('recordLi','pCenterLi','core/toLoginRecordList.do','登陆记录')">登陆记录</a></li>--%>
                    <%--<li id="backlogLi"><a href="javascript:void(0);" onclick="toPage('backlogLi','pCenterLi','core/toBacklogList.do','待办事项')">待办事项</a></li>--%>

                <%--</ul>--%>
            <%--</li>--%>
            <%--<li id="orderLi" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>订单管理</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--&lt;%&ndash;<li id="orderListLi1"><a href="<%=basePath%>manager/toOrderListAll.do?orderLevel=2"> 未处理订单</a></li>&ndash;%&gt;--%>
                    <%--<li id="orderListLi2"><a href="javascript:void(0);" onclick="toPage('orderListLi2','orderLi','core/toOrderListAll.do','所有订单')">所有订单</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="quickOrderLi" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>快速订购</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--&lt;%&ndash;<li id="orderListLi1"><a href="<%=basePath%>manager/toOrderListAll.do?orderLevel=2"> 未处理订单</a></li>&ndash;%&gt;--%>
                    <%--<li id="quickOrderLiLi2"><a href="javascript:void(0);" onclick="toPage('quickOrderLiLi2','quickOrderLi','core/toQuickOrder.do','快速订购')">快速订购</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>


            <%--&lt;%&ndash;<li id="quickOrderLi" class="menu-list"><a href="javascript:void(0);" onclick="toPage('quickOrderLi','','core/toQuickOrder.do','快速订购')"><i class="fa fa-files-o"></i> <span>快速订购</span></a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>

            <%--<li id="orderDetailListLi" class="menu-list"><a href=""><i class="fa fa-file"></i> <span>报告管理</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--&lt;%&ndash;<li id="orderDetailListLi1"><a href="<%=basePath%>manager/toOrderDetailListAll.do?orderLevel=2&orderStatusId=1"> 未处理报告</a></li>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<li id="orderDetailListLi2"><a href="<%=basePath%>manager/toOrderDetailListAll.do"> 所有报告</a></li>&ndash;%&gt;--%>
                        <%--<li id="orderDetailListLi1"><a href="javascript:void(0);" onclick="toPage('orderDetailListLi1','orderDetailListLi','core/toOrderDetailListAll.do?productType=1','中国报告')">中国报告</a></li>--%>
                        <%--<li id="orderDetailListLi2"><a href="javascript:void(0);" onclick="toPage('orderDetailListLi2','orderDetailListLi','core/toOrderDetailListAll.do?productType=2','外国报告')">外国报告</a></li>--%>
                        <%--<li id="orderDetailListLi3"><a href="javascript:void(0);" onclick="toPage('orderDetailListLi3','orderDetailListLi','core/toOrderDetailListAll.do?productType=3','自定义报告')">自定义报告</a></li>--%>

                <%--</ul>--%>
            <%--</li>--%>


            <%--<li id="accountStatement" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>对账单管理</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="accountStatement1"><a href="javascript:void(0);" onclick="toPage('accountStatement1','accountStatement','core/toAccountStatementrListAll.do','所有对账单')"> 所有对账单</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>


            <%--<li id="reCharge" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>充值管理</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="reChargeList"><a href="javascript:void(0);" onclick="toPage('reChargeList','reCharge','core/toRechargeList.do','充值记录')">充值记录</a></li>--%>
                    <%--<li id="reChargeCustomerGE"><a href="javascript:void(0);" onclick="toPage('reChargeCustomerGE','reCharge','core/toReChargeCustomerGE.do','全球鹰充值')">全球鹰充值</a></li>--%>
                    <%--<li id="reChargeCustomerGS"><a href="javascript:void(0);" onclick="toPage('reChargeCustomerGS','reCharge','core/toReChargeCustomerGS.do','全搜充值')">全搜充值</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="userManagement" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>用户管理</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="usersManagementLi"><a href="javascript:void(0);" onclick="toPage('usersManagementLi','userManagement','core/toManagerList.do','用户列表')">用户列表</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>


            <%--<li id="productManagement" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>商品管理</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="productManagementLi"><a href="javascript:void(0);" onclick="toPage('productManagementLi','productManagement','core/toProductList.do','商品列表')">商品列表</a></li>--%>
                    <%--<li id="moduleManagementLi"><a href="javascript:void(0);" onclick="toPage('moduleManagementLi','productManagement','core/toModuleList.do','模块列表')">模块列表</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="customerManagement" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>客户管理</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="customerManagementLiGE"><a href="javascript:void(0);" onclick="toPage('customerManagementLiGE','customerManagement','core/toCustomerListGE.do','全球鹰客户')">全球鹰客户</a></li>--%>
                    <%--<li id="customerManagementLiGS"><a href="javascript:void(0);" onclick="toPage('customerManagementLiGS','customerManagement','core/toCustomerListGS.do','全搜客户')">全搜客户</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="basicLi" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>基础设置</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="regionAndCountryLi"><a href="javascript:void(0);" onclick="toPage('regionAndCountryLi','basicLi','basic/toRegionAndCountry.do','区域和国家')">区域和国家</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>


            <%--<li id="system" class="menu-list"><a href=""><i class="fa fa-cogs"></i> <span>系统设置</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="system1"><a href="javascript:void(0);" onclick="toPage('system1','system','core/toEmailListAll.do','邮箱设置')">邮箱设置</a></li>--%>
                    <%--<li id="system2"><a href="javascript:void(0);" onclick="toPage('system2','system','core/toLogListAll.do','系统日志')">系统日志</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="docLi" class="menu-list"><a href=""><i class="fa fa-ambulance"></i> <span>运营中心</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="activitirs"><a href="javascript:void(0);" onclick="toPage('activitirs','docLi','core/toActivitiesListAll.do','优惠活动')">优惠活动</a></li>--%>
                    <%--<li id="helpLi"><a href="javascript:void(0);" onclick="toPage('helpLi','docLi','basic/toHelpLiListAll.do','帮助文档')">帮助文档</a></li>--%>
                    <%--<li id="customerLi"><a href="javascript:void(0);" onclick="toPage('customerLi','docLi','basic/toCustomerLiListAll.do','用户认证')">用户认证</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li id="resourceLi" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>资源设置</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="resourceManageLi"><a href="javascript:void(0);"--%>
                                                 <%--onclick="toPage('resourceManageLi','resourceLi','core/toResourceManager.do','资源管理')">资源管理</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li id="organizationLi" class="menu-list"><a href=""><i class="fa fa-files-o"></i> <span>组织机构</span></a>--%>
                <%--<ul class="sub-menu-list">--%>
                    <%--<li id="corpLi"><a href="javascript:void(0);"--%>
                                       <%--onclick="toPage('corpLi','organizationLi','core/toCorpManager.do','机构管理')">机构管理</a>--%>
                    <%--</li>--%>
                    <%--<li id="userManagementLi"><a href="javascript:void(0);"--%>
                                                 <%--onclick="toPage('userManagementLi','organizationLi','core/toUserManager.do','用户管理')">用户管理</a>--%>
                    <%--</li>--%>
                    <%--<li id="groupManagementLi"><a href="javascript:void(0);"--%>
                                                  <%--onclick="toPage('groupManagementLi','organizationLi','core/toGroupManager.do','组管理')">组管理</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <c:set var="index" value="0"/>
            <c:forEach items="${menus}" var="menu">
                <c:set var="index" value="${index+1}"/>
                <li id='Li${index}' class='menu-list'><a href=''><i class='fa fa-files-o'></i>
                    <span> ${menu.key}</span></a>
                    <ul class='sub-menu-list'>
                        <c:forEach items="${menu.value}" var="value">
                            <li id="icon${value.id}">
                                <a href="javascript:void(0);"
                                   onclick="toPage('icon${value.id}','Li${index}','${value.url}','${value.name}')">${value.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>

            <li><a href="${pageContext.request.contextPath}/logout.do" class="logoutA"><i class="fa fa-sign-out"></i>
                <span>退出</span></a></li>

        </ul>

    </div>
</div>
<!-- left side end-->