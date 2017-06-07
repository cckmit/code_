<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//cdn.bootcss.com/html2canvas/0.5.0-beta4/html2canvas.js"></script>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%--<link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/bootstrap.css" media="screen">--%>
<%--<link rel="stylesheet" href="<%=basePath%>css/eden.css" media="screen">--%>
<%--<link href="<%=basePath%>css/animate.css" rel="stylesheet">--%>
<%--<link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/bootstrap-dialog.min.css" />--%>
<%--<script src="<%=basePath%>frame/bootstrap/js/bootstrap.min.js"></script>--%>
<%--<script src="<%=basePath%>frame/bootstrap/js/bootstrap-dialog.min.js"></script>--%>
<%--<script src="<%=basePath%>frame/jquery-1.10.2.min.js"></script>--%>

<link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/bootstrap-dialog.min.css"/>
<link href="<%=basePath%>frame/bootstrap/css/jquery.bootgrid.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="<%=basePath%>css/misc.css">

<link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/bootstrap-progressbar-3.3.4.css">
<link rel="stylesheet" href="<%=basePath%>frame/bootstrap/css/bootstrap-progressbar-3.3.4.css">

<!-- 新增css -->

<link href="<%=basePath%>css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>css/eden.css" media="screen">
<link rel="stylesheet" href="<%=basePath%>css/myBootstrap.css">
<link rel="stylesheet" href="<%=basePath%>css/nojs.css">
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
//        addCartOption.do?crefoNo=9364590846&companyName=商安信(上海)企业管理咨询股份有限公司&countryName=中国&province=&city=
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

                <li id="indexLi"><a href="<%=basePath%>simple/index.do">首页</a></li>
                <c:if test="${empty sessionScope.customerInfo}">
                    <li id="loginLi"><a href="<%=basePath%>simple/toLogin.do">注册/登陆</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.customerInfo}">
                    <li id="userLi" class="ative"><a href="#"
                                                     class="dropdown-toggle" data-toggle="dropdown">用户：${sessionScope.customerInfo.getEmail()}</a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=basePath%>simple/user/toCartList.do">我的购物车</a></li>
                            <li><a href="<%=basePath%>simple/customer/orderList.do">我的订单</a></li>
                            <li><a href="<%=basePath%>simple/customer/orderDetailList.do">我的报告</a></li>
                            <li><a href="<%=basePath%>simple/customer/tochangedInformation.do">个人信用信息
                                <c:if test="${sessionScope.customerInfo.checkStatus=='是'}">
                                    <i class="fa fa-check-square" style="color: green"></i>
                                </c:if>
                            </a></li>
                            <li><a href="<%=basePath%>simple/logout.do">注销</a></li>
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
        <div class="col-lg-12">
            <h3>${companyName}</h3>
        </div>
    </div>


    <div class="row">
        <div class="col-lg-6">
            <div class="bs-component">
                <blockquote>
                    <p>订购日期:&nbsp;${createDate} &nbsp;<!-- Date of Delivery: 2016-07-06 -->
                        代码: ${crefoNo}</p>
                    <small>${enName} / ${cnName}</small>
                </blockquote>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="bs-component">
                <blockquote class="pull-right">
                    <p>数据日期:&nbsp;${createDate}
                        <button class="btn btn-success btn-sm" role="button" onClick="updateChina()">更新</button>
                    </p>
                    <p>
                        <c:if test="${level eq '1'}">
                            数据库报告
                        </c:if>
                        <c:if test="${level eq '3'}">
                            数据库完整报告
                        </c:if>
                        <c:if test="${level eq '2'}">
                            数据库完整报告
                        </c:if>
                        <c:if test="${empty level}">
                            数据库报告
                        </c:if>
                        <button class="btn btn-success btn-sm" role="button" onClick="updateChina()">升级</button>
                    </p>
                </blockquote>
            </div>
        </div>
    </div>

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
                        <li><a <c:if test="${cnName=='中国'}">
                            <c:if test="${level eq '1'}">
                                onclick="downloadChinatwo()"
                            </c:if>
                            <c:if test="${level eq '3'}">
                                onclick="downloadChinathree()"
                            </c:if>
                        </c:if>
                                <c:if test="${cnName!='中国'}">onclick="download1('${countryCode}','${crefoNo}','${orderDetail.id}')"</c:if>
                        >PDF下载</a></li>
                        <li><a
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

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" role="button"
                             id="onLineQA"  aria-expanded="false">在线问答 </a>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <button type="button" class="btn btn-success btn-sm" onclick="credit()">实地认证</button>
                            <button type="button" class="btn btn-success btn-sm">应收帐催收</button>
                            <button type="button" class="btn btn-success btn-sm">司法协助</button>
                            <button type="button" class="btn btn-success btn-sm">尽职调查</button>                            </div>

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