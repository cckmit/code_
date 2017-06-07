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
<link rel="stylesheet" href="<%=basePath%>css/eden.css" media="screen">
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
<script type="text/javascript" src="<%=basePath%>js/onLineQA/publishOpt.js"></script>
<script>
    //该事件显示在线问答
    var basePath = '<%=basePath%>';
    function updateChina() {
        window.location.href = basePath + "user/addCartOption.do?crefoNo=${crefoNo}&companyName=${companyName}&countryName=${cnName}";
    }
    function update() {
        window.location.href = basePath + "user/addCartOption.do?companyNo=${crefoNo}&companyName=${companyName}&countrySel=${cnName}&countryId=${countryId}";
    }
    var contextPath = '${basePath}';
    function helpcontent(title,content){
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

    function addOrderSubmit() {
        if ('${products.getRows().size()}'=='0'){
            BootstrapDialog.alert("请选择订购产品。");
            return;
        }else{
            var productId = $("input[name='optionsRadios']:checked").val();
            if (productId == undefined || "" == productId || null == productId) {
                BootstrapDialog.alert("您已订购过该报告，无需重复订购！");
            } else {
                $("#addOrderSubmit").submit();
            }
        }
    }
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

                    </ul></li>
                <li id="fastAddLi"><a href="<%=basePath%>user/toFastAddOrder.do">快速订购</a></li>
                <li id="helpLi"><a href="<%=basePath%>help.do">帮助</a></li>
                <c:if test="${empty sessionScope.customerInfo}">
                    <li id="loginLi"><a href="<%=basePath%>toLogin.do">注册/登陆</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.customerInfo}">
                    <li id="userLi" class="ative"><a href="#"
                                                     class="dropdown-toggle" data-toggle="dropdown">用户：${sessionScope.customerInfo.getEmail()}</a>
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
                        </ul></li>
                </c:if>
            </ul>

        </div>
    </div>
</div>
<div class="container">


    <p><br>
        <br>
    </p>

    <div class="row">
        <div class="col-lg-12" style="overflow: hidden;margin: 15px 0;">
            <h3 style="float: left;margin: 0;line-height: 30px;">${orderDetail.getCompanyName()}</h3>
            <div style="float: right;line-height: 30px;font-weight: bold;">
                <c:if test="${orderDetail.getStatus()==4}">
                    您的报告正在制作中
                </c:if>
                <c:if test="${orderDetail.getStatus()==8}">
                    您的报告已完成
                </c:if>
            </div>
        </div>
    </div>

    <form id="addOrderSubmit" action="<%=basePath%>customer/addOrder.do" method="post">
        <input name="companyName" value="${orderDetail.getCompanyName()}" type="hidden">
        <input name="companyNo" value="${companyNo}" type="hidden">
        <input name="countryName" value="${orderDetail.getCountryName()}" type="hidden">
        <div class="row">
        <div class="col-lg-4">
            <div class="bs-component">
                <blockquote>
                    <p>订购日期:&nbsp;
                        <fmt:formatDate value="${order.getCreateTime()}" />  &nbsp;&nbsp;
                        &nbsp;</p>
                    <small>${orderDetail.getCountryName()}</small>
                </blockquote>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="bs-component">
                <div class="well">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <!--产品选择-->
                        <c:if test="${products.getResult()}">
                            <c:forEach var="product" items="${products.getRows()}" varStatus="status">
                                <tr>
                                    <td width="3%" align="center">
                                        <input name="optionsRadios" value="${product.getId()}" type="radio"
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
                </div>
            </div>
        </div>
    </div>
        <div style="width: 100%;height: 60px;">
            <button class="btn btn-success page-tab-btn" type="button" onclick="addOrderSubmit()">订购</button>
        </div>
    </form>
    <div class="bs-component">
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
                        <li><a
                                <c:if test="${orderDetail.getCountryName()!='中国'}">
                                onclick="downloadChinatwo()"
                                </c:if>
                                <c:if test="${orderDetail.getCountryName()=='中国'}">onclick="download1('${orderDetail.pathDataFile}')"</c:if>
                                href="#">PDF下载</a></li>


                        <li><a href="#"
                                <c:if test="${cnName=='中国'}">
                            <c:if test="${level eq '1'}">
                                onclick="sendChinaEmail('${cnName}','${crefoNo}','${orderDetail.id}',1)"
                            </c:if>
                            <c:if test="${level eq '3'}">
                                onclick="sendChinaEmail('${cnName}','${crefoNo}','${orderDetail.id}',3)"
                            </c:if>
                        </c:if>
                                <c:if test="${cnName!='中国'}">onclick="sendEmail('${countryCode}','${crefoNo}','${orderDetail.id}')"</c:if>
                        >发送至邮箱</a></li>
                        <%--<li><a href="#">意见及问题</a></li>--%>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false">帮助 <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <c:forEach items="${helpListReport}" var="help">
                                    <li><a onclick="helpcontent('${help.title}','${help.content}')">${help.title}</a></li>
                                </c:forEach>
                            </ul>
                        </li>

                        <%--<li class="dropdown">--%>
                            <%--<a class="dropdown-toggle" data-toggle="dropdown" role="button"--%>
                             <%--id="onLineQA"  aria-expanded="false">在线问答 </a>--%>
                        <%--</li>--%>
                    </ul>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <button type="button" class="btn btn-success btn-sm" onclick="credit()">实地认证</button>
                            <button type="button" class="btn btn-success btn-sm" onclick="creditAdditional2()">应收帐催收</button>
                            <button type="button" class="btn btn-success btn-sm" onclick="creditAdditional3()">司法协助</button>
                            <button type="button" class="btn btn-success btn-sm" onclick="creditAdditional4()">净值调查</button>                            </div>

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