<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="//cdn.bootcss.com/html2canvas/0.5.0-beta4/html2canvas.js"></script>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/bootstrap.css">

<link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/bootstrap-dialog.min.css"/>
<link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="<%=basePath%>css/misc.css">

<link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/bootstrap-progressbar-3.3.4.css">

<!-- 新增css -->

<link href="<%=basePath%>css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>/css/eden.css" media="screen">
<link rel="stylesheet" href="<%=basePath%>css/myBootstrap.css">
<!-- JavaScripts -->
<script src="<%=basePath%>frame/jquery-1.10.2.min.js"></script>
<script src="<%=basePath%>frame/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=basePath%>frame/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath%>frame/bootstrap/js/bootstrap-dialog.min.js"></script>
<script src="<%=basePath%>frame/bootstrap/js/jquery.bootgrid.js"></script>
<script src="<%=basePath%>frame/bootstrap/js/bootstrap-progressbar.js"></script>
<script type="text/javascript" src="<%=basePath%>frame/bootstrap/js/moment.js"></script>
<script type="text/javascript" src="<%=basePath%>js/base64.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/onLineQA/publishOpt.js"></script>
<script>
    //该事件显示在线问答
    var basePath = '<%=basePath%>';
    var contextPath = '${basePath}';
    function helpcontent(title, content) {
        $("#helpTitle").html(title);
        $("#helpContent").html(base64Decode(content));
        $('#myModal').modal('show')
    }

    function creditAdditional2() {
        window.open(basePath + "toIndexAddition2.do");
    }
    function creditAdditional3() {
        window.open(basePath + "toIndexAddition3.do");
    }
    function creditAdditional4() {
        window.open(basePath + "toIndexAddition4.do");
    }

    function reminder() {
        BootstrapDialog.alert("请订购该报告。");
    }

    function addOrderSubmit() {
        if ('${products.getRows().size()}'=='0'){
            BootstrapDialog.alert("请选择订购产品。");
            return;
        }else{
            if ('${sessionScope.customer}'==null){

            }
            if ($('#optionsRadios')){

            }
            var productId = $("input[name='optionsRadios']:checked").val();
            if (productId == undefined || "" == productId || null == productId) {
                BootstrapDialog.alert("您已订购过该报告，无需重复订购！");
            } else {
                $("#addOrderSubmit").submit();
            }
        }
    }

    $(function(){
        $(".page-hide").click(function(){
            $(".page-tableshow").slideUp();
            $(".page-show").css("display","block");
        })
        $(".page-show").click(function(){
            $(".page-show").css("display","none");
            $(".page-tableshow").slideDown();
        })
    })


</script>
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="<%=basePath%>" class="navbar-brand">Global Eagle 全球鹰</a>
            <button class="navbar-toggle" type="button" data-toggle="collapse"
                    data-target="#navbar-main">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">

            <ul class="nav navbar-nav fixMuBan">

                <li id="indexLi"><a href="<%=basePath%>">首页</a></li>
                <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">信用服务<span
                        class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<%=basePath%>toIndexAddition1.do">实地认证服务</a></li>
                        <li><a href="<%=basePath%>toIndexAddition2.do">全球应收帐管理</a></li>
                        <li><a href="<%=basePath%>toIndexAddition3.do">当地司法服务</a></li>
                        <li><a href="<%=basePath%>toIndexAddition4.do">净值调查服务</a></li>
                        <li><a href="<%=basePath%>toIndexAddition5.do">商业咨询服务</a></li>
                        <li><a href="<%=basePath%>toIndexAddition6.do">数据对接服务</a></li>

                    </ul>
                </li>
                <li id="fastAddLi"><a href="<%=basePath%>user/toFastAddOrder.do">快速订购</a></li>
                <li id="helpLi"><a href="<%=basePath%>help.do">帮助</a></li>
                <c:if test="${empty sessionScope.customerInfo}">
                    <li id="loginLi"><a href="<%=basePath%>toLogin.do">注册/登陆</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.customerInfo}">
                    <li id="userLi" class="ative"><a href="#"
                                                     class="dropdown-toggle"
                                                     data-toggle="dropdown">用户：${sessionScope.customerInfo.getEmail()}</a>
                        <ul class="dropdown-menu">
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
                        </ul>
                    </li>
                </c:if>
            </ul>

        </div>
    </div>
</div>


<div class="container">


    <p><br>
    </p>
    <div class="row">
        <div class="col-lg-12 page-row-coladdh">
            <h3>${companyName}</h3>
        </div>
    </div>

    <form id="addOrderSubmit" action="<%=basePath%>customer/addOrder.do" method="post">
        <input name="companyName" value="${companyName}" type="hidden">
        <input name="companyNo" value="${companyNo}" type="hidden">
        <input name="countryName" value="${countryName}" type="hidden">
        <div class="row page-row-add">
            <%--<div class="col-lg-4">--%>
                <%--<div class="bs-component">--%>
                    <%--<p>订购记录</p>--%>
                        <%--<table width="100%" border="0" cellspacing="0" cellpadding="0">--%>
                            <%--<tbody>--%>
                            <%--<c:if test="${history.getResult()}">--%>
                            <%--<tr>--%>
                                <%--<td width="30%" align="left">--%>
                                    <%--<strong>订购时间</strong>--%>
                                <%--</td>--%>
                                <%--<td width="30%" align="left">--%>
                                    <%--<strong>报告类型</strong>--%>
                                <%--</td>--%>
                                <%--<td width="30%" align="left">--%>
                                    <%--<strong> 订单号&nbsp;&nbsp;--%>
                                    <%--</strong>--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                            <%--<c:forEach var="history" items="${history.getRows()}" varStatus="status" begin="0" end="4">--%>
                                <%--<tr>--%>
                                    <%--<td width="30%" align="left">--%>
                                        <%--<strong>--%>
                                            <%--<fmt:formatDate value="${history.getCreateTime()}" />  &nbsp;&nbsp;--%>
                                        <%--</strong>--%>
                                    <%--</td>--%>
                                    <%--<td width="30%" align="left">--%>
                                        <%--<strong>--%>
                                        <%--${history.getProductType()}&nbsp;&nbsp;--%>
                                        <%--</strong>--%>
                                    <%--</td>--%>
                                    <%--<td width="30%" align="left">--%>
                                        <%--<strong> ${history.getOrderNo()}&nbsp;&nbsp;--%>
                                        <%--</strong>--%>
                                    <%--</td>--%>
                                <%--</tr>--%>
                            <%--</c:forEach>--%>
                        <%--</c:if>--%>
                            <%--</tbody></table>--%>
                <%--</div>--%>
            <%--</div>--%>
            <div class="col-lg-12">
                <div class="bs-component page-tableshow">
                    <div class="well page-well-add ">
                        <table border="0" cellspacing="0" cellpadding="0" style="float: left;width: 75%;">
                            <tbody>
                            <!--产品选择-->
                            <c:if test="${products.getResult()}">
                                <c:forEach var="product" items="${products.getRows()}" varStatus="status">
                                    <tr>
                                        <td width="3%" align="center">
                                            <input id="optionsRadios" name="optionsRadios" value="${product.getId()}" type="radio"
                                                   <c:if test="${product.getHasOrder()!='false'}">disabled</c:if>
                                                   <c:if test="${product.getHasOrder()=='false'}">checked</c:if>
                                            >
                                        </td>
                                        <td width="15%" align="left">
                                            <strong> ${product.getCurrency()}${product.getPrice()}&nbsp;&nbsp;
                                            </strong>
                                        </td>
                                        <td width="15%" align="left">
                                            <strong>
                                                <span class="hidden-xs label-lg">${product.getName()}</span>
                                            </strong>
                                        </td>
                                        <td width="40%" align="left">
                                            <strong>
                                                <span class="hidden-xs label-lg">${product.getDesc()}</span>
                                            </strong>
                                        </td>
                                        <td width="10%">
                                        <c:if test="${product.getExpectHour()=='0'}">Instant</c:if>
                                            <c:if test="${product.getExpectHour()!='0'}">${product.getExpectHour()}&nbsp;Hours</c:if>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>


                            </tbody>
                        </table>
                        <%--<div style="width: 15%;float: left;padding-left: 2%;"><div style="display:inline-block;padding:1px 10px;background:#2C3E50;color:#fff; border-radius: 4px;--%>
  <%---webkit-border-radius: 4px;-moz-border-radius: 4px;-ms-border-radius: 4px;font-size:12px;font-weight:bold;">2017-05-03</div></div>--%>
                        <div style="float: right;width: 10%;">
                            <button class="btn btn-success page-tab-btn" type="button" onclick="addOrderSubmit()" style="width: 100%;font-size: 14px;">订购</button>
                            <p class="page-hide" style="margin: 25px 0px 0px 0px;width:100%;letter-spacing:4px;cursor:pointer;color: #0C8BDE;font-size: 12px;">隐藏订购菜单↑</p>
                        </div>
                        <div style="overflow: hidden;clear: both;zoom:1;"></div>
                    </div>
                </div>
            </div>
            <p class="page-show" style="margin: 30px 45px 0px 0px;text-align: right;display: none;letter-spacing:4px;font-size:12px;cursor:pointer;color: #0C8BDE;margin-bottom: 15px;">显示订购菜单↓</p>
        </div>


    </form>
    <div class="bs-component" style="width: 1170px;margin-left: -15px;">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"></a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a onclick="reminder()">PDF下载</a></li>
                        <li><a onclick="reminder()">发送至邮箱</a></li>
                        <%--<li class="dropdown">--%>
                            <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"--%>
                               <%--aria-expanded="false">帮助 <span class="caret"></span></a>--%>
                            <%--<ul class="dropdown-menu" role="menu">--%>
                                <%--<c:forEach items="${helpListReport}" var="help">--%>
                                    <%--<li><a onclick="helpcontent('${help.title}','${help.content}')">${help.title}</a>--%>
                                    <%--</li>--%>
                                <%--</c:forEach>--%>
                            <%--</ul>--%>
                        <%--</li>--%>

                    </ul>
                    <form class="navbar-form navbar-right" role="search" style="margin-top: 10px;">
                        <div class="form-group">
                            <button type="button" class="btn btn-success btn-sm" onclick="credit()" style="font-size: 12px">实地认证</button>
                            <button type="button" class="btn btn-success btn-sm" onclick="creditAdditional2()" style="font-size: 12px">应收帐催收
                            </button>
                            <button type="button" class="btn btn-success btn-sm" onclick="creditAdditional3()" style="font-size: 12px">司法协助
                            </button>
                            <button type="button" class="btn btn-success btn-sm" onclick="creditAdditional4()" style="font-size: 12px">净值调查
                            </button>
                        </div>

                    </form>

                </div>
            </div>
        </nav>
    </div>

</div>
<jsp:include page="${basePath}/WEB-INF/page/onLineFeedBack/isNotReadMes.jsp"/>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="helpTitle"></h4>
            </div>
            <div class="modal-body" id="helpContent"></div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>