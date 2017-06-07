<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../include/include.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.theme.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/frame/jquery-ui/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/searchCompanyList.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Full Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <style>
        .navbar-holder-dark {
            padding: 20px 20px 200px 20px;
            background: #073300;
        }
    </style>
    <script type="text/javascript">
        var companyName = "${companyName}";
        var type = "${type}";

    </script>
</head>
<body>
<jsp:include page="${basePath}../include/top.jsp"/>


<br>
<div class="container">
    <%--进度条--%>
    <div id="progress-bar" class="panel panel-primary" style="margin-top: 20px; display: none;">
        <div class="panel-heading">
            <h3 class="panel-title">Data Query...</h3>
        </div>
        <div class="panel-body">
            <div class="progress progress-striped active">
                <div class="progress-bar progress-bar-primary" role="progressbar" data-transitiongoal="100"
                     style="width: 100%;" aria-valuenow="100"></div>
            </div>
        </div>
    </div>

    <div class="bs-docs-section">
        <div class="row">
            <div class="col-lg-12">

                <ul class="breadcrumb">
                    <li>Home</li>
                    <li>Search</li>
                    <li>${type}: <a href="#">${companyName}</a> </li>
                    <%--| Total:<Strong id="companyListCount">50</Strong>/<strong>1000</strong>--%>
                </ul>
            </div>

        </div>

        <div class="row">
            <div class="col-lg-12">
            </div>
        </div>
        <div class="row">


            <div class="col-lg-9">
                <div class="bs-component" id="fxq-orderGrid">
                    <table id="orderGrid" >
                    <thead >
                     <tr style="display: none">
                        <th data-formatter="companyInfo" data-type="string"></th>
                    </tr>


                    </thead>
                    </table>





                    <%--<p>--%>
		<%--<span class="lead">--%>
			<%--<a href="javascript:void(0);" onclick=" " data-column-id="nameCN" data-type="string">Apple Computer Trading (Shanghai) Co., Ltd.</a>--%>
		<%--</span>--%>
                        <%--<span class="label label-success">Active</span>&nbsp;&nbsp;--%>
                        <%--<span class="label fxq-A-set label-success fxq-A">A--%>
			<%--<span class="fxq-A-full">Authentication</span>--%>
		<%--</span>&nbsp;--%>
                        <%--<span class="label  fxq-V-set label-default">V--%>
			<%--<span class="fxq-V-full">Verification</span>--%>
		<%--</span>--%>
                    <%--</p>--%>

                    <%--<p>--%>
                        <%--<strong>Reg ID:91310000607426876P </strong>&nbsp;--%>
                        <%--<strong>Local: </strong>Shanghai/Shanghai--%>
                    <%--</p>--%>
                </div>
            </div>
            <div style="width: 25%;float: left;">

                <!-- 三块内容的框 -->
                <c:if test="${type=='Companies'}">
                    <div class="col-lg-3" style="width:100%">
                        <div class="well bs-component" id="companyNameDiv">
                            <form class="form-horizontal">
                                <fieldset>
                                    <legend style="margin:10px 0;">Refine by</legend>
                                    <div>
                                        <label for="province" class="control-label"
                                               style="line-height: 34px;">Location</label>
                                        <br>
                                        <select name="province" id="province" class="form-control fxq-new-select">
                                            <option value="" selected="selected">Select Province</option>
                                            <option value="shanghai">Shanghai</option>
                                            <option value="beijing">Beijing</option>
                                            <option value="guangdong">Guangdong Province</option>
                                            <option value="jiangsu">Jiangsu Province</option>
                                            <option value="zhejiang">Zhejiang Province</option>
                                            <option value="shandong">Shandong Province</option>
                                            <option value="hunan">Hunan Province</option>
                                            <option value="chongqing">Chongqing</option>
                                            <option value="gansu">Gansu Province</option>
                                            <option value="qinghai">Qinghai Province</option>
                                            <option value="xinjiang">Xinjiang Uygur Autonomous Region</option>
                                            <option value="henan">Henan Province</option>
                                            <option value="yunnan">Yunnan Province</option>
                                            <option value="guizhou">Guizhou Province</option>
                                            <option value="sichuan">Sichuan Province</option>
                                            <option value="guangxi">Guangxi Zhuang Autonomous Region</option>
                                            <option value="hubei">Hubei Province</option>
                                            <option value="ningxia">Ningxia Hui Autonomous Region</option>
                                            <option value="tianjin">Tianjin</option>
                                            <option value="hebei">Hebei Province</option>
                                            <option value="shanxi">Shanxi Province</option>
                                            <option value="neimenggu">Inner Mongolia Autonomous Region</option>
                                            <option value="liaoning">Liaoning Province</option>
                                            <option value="jilin">Jilin Province</option>
                                            <option value="heilongjiang">Heilongjiang Province</option>
                                            <option value="anhui">Anhui Province</option>
                                            <option value="jiangxi">Jiangxi Province</option>
                                            <option value="fujian">Fujian Province</option>
                                            <option value="hainan">Hainan Province</option>
                                            <option value="xianggang">Xianggang Province</option>
                                            <option value="aomen">Aomen Province</option>
                                            <option value="xizang">Tibet Autonomous Region</option>
                                        </select>
                                    </div>

                                    <div>
                                        <label for="exIm" class="control-label" style="line-height: 34px;">Import &
                                            Export</label>
                                        <br>
                                        <select name="exIm" id="exIm" class="form-control fxq-new-select">
                                            <option value="" selected="selected">ALL</option>
                                            <option value="1">Yes</option>
                                            <option value="0">No</option>
                                        </select>
                                    </div>
                                    <div>
                                        <label for="status" class="control-label"
                                               style="line-height: 34px;">Status</label>
                                        <br>
                                        <select name="status" id="status" class="form-control fxq-new-select">
                                            <option value="" selected="selected">ALL</option>
                                            <option value="1">Active</option>
                                            <option value="2">Inactive</option>
                                            <option value="3">Dissolved</option>
                                            <option value="4">Business licence has been revoked</option>
                                            <option value="5">Bankruptcy</option>
                                            <option value="6">Receivership</option>
                                            <option value="7">Suspend</option>
                                            <option value="8">Closed</option>
                                            <option value="9">Unknown</option>
                                        </select>
                                    </div>
                                        <%--新增--%>
                                    <div>
                                        <label for="exIm" class="control-label" style="line-height: 34px;">Industry
                                            Options</label>
                                        <br>
                                        <select name="exIm" class="form-control fxq-new-select">
                                            <option value="" selected="selected">ALL</option>
                                        </select>
                                    </div>
                                    <div>
                                        <label for="exIm" class="control-label" style="line-height: 34px;">Sponsored
                                            Company</label>
                                        <br>
                                        <select name="exIm" class="form-control fxq-new-select">
                                            <option value="" selected="selected">No Select</option>
                                            <option value="1">Sponsored Companies Preferred</option>
                                        </select>
                                    </div>
                                    <div style="margin-top:20px">
                                        <button type="button" onclick="searchTM()" class="btn btn-primary">Search
                                        </button>
                                        &nbsp;&nbsp;
                                        <button type="reset" class="btn btn-default">Reset</button>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </c:if>


                <!-- 四块内容的框 -->
                <c:if test="${type=='Products'}">
                    <div class="col-lg-3" style="width: 100%;">
                        <div class="well bs-component" id="productDiv">
                            <form class="form-horizontal">
                                <fieldset>
                                    <legend>Refine by</legend>
                                    <div>
                                        <label for="provinceProduct" class="control-label">Location</label>
                                        <br>
                                        <select name="provinceProduct" id="provinceProduct"
                                                class="form-control fxq-new-select">
                                            <option value="" selected="selected">Select Privnce</option>
                                            <option value="shanghai">Shanghai</option>
                                            <option value="beijing">Beijing</option>
                                            <option value="guangdong">Guangdong Province</option>
                                            <option value="jiangsu">Jiangsu Province</option>
                                            <option value="zhejiang">Zhejiang Province</option>
                                            <option value="shandong">Shandong Province</option>
                                            <option value="hunan">Hunan Province</option>
                                            <option value="chongqing">Chongqing</option>
                                            <option value="gansu">Gansu Province</option>
                                            <option value="qinghai">Qinghai Province</option>
                                            <option value="xinjiang">Xinjiang Uygur Autonomous Region</option>
                                            <option value="henan">Henan Province</option>
                                            <option value="yunnan">Yunnan Province</option>
                                            <option value="guizhou">Guizhou Province</option>
                                            <option value="sichuan">Sichuan Province</option>
                                            <option value="guangxi">Guangxi Zhuang Autonomous Region</option>
                                            <option value="hubei">Hubei Province</option>
                                            <option value="ningxia">Ningxia Hui Autonomous Region</option>
                                            <option value="tianjin">Tianjin</option>
                                            <option value="hebei">Hebei Province</option>
                                            <option value="shanxi">Shanxi Province</option>
                                            <option value="neimenggu">Inner Mongolia Autonomous Region</option>
                                            <option value="liaoning">Liaoning Province</option>
                                            <option value="jilin">Jilin Province</option>
                                            <option value="heilongjiang">Heilongjiang Province</option>
                                            <option value="anhui">Anhui Province</option>
                                            <option value="jiangxi">Jiangxi Province</option>
                                            <option value="fujian">Fujian Province</option>
                                            <option value="hainan">Hainan Province</option>
                                            <option value="xianggang">Xianggang Province</option>
                                            <option value="aomen">Aomen Province</option>
                                            <option value="xizang">Tibet Autonomous Region</option>
                                        </select>
                                    </div>
                                    <div>
                                        <label for="statusProduct" class="control-label">Status</label>
                                        <br>
                                        <select name="statusProduct" id="statusProduct"
                                                class="form-control fxq-new-select">
                                            <option value="" selected="selected">ALL</option>
                                            <option value="1">Active</option>
                                            <option value="2">Inactive</option>
                                            <option value="3">Dissolved</option>
                                            <option value="4">Business licence has been revoked</option>
                                            <option value="5">Bankruptcy</option>
                                            <option value="6">Receivership</option>
                                            <option value="7">Suspend</option>
                                            <option value="8">Closed</option>
                                            <option value="9">Unknown</option>
                                        </select>
                                    </div>
                                    <div>
                                        <label for="scale" class="control-label">Company size options</label>
                                        <br>
                                        <select name="scale" id="scale" class="form-control fxq-new-select">
                                            <option value="" selected="selected">ALL</option>
                                            <option value="1">Large</option>
                                            <option value="0">Small</option>
                                        </select>
                                    </div>
                                    <div>
                                        <label for="productAandV" class="control-label">Certification</label>
                                        <br>
                                        <select name="productAandV" id="productAandV"
                                                class="form-control fxq-new-select">
                                            <option value="" selected="selected">Select None</option>
                                            <option value="1">Company has been Authenticated</option>
                                            <option value="2">Company has been Verified</option>
                                            <option value="3">Company has been A and V</option>
                                        </select>
                                    </div>
                                    <!--新增-->
                                    <div>
                                        <label for="exIm" class="control-label" style="line-height: 34px;">Industry
                                            options</label>
                                        <br>
                                        <select name="exIm" class="form-control fxq-new-select">
                                            <option value="" selected="selected">ALL</option>
                                        </select>
                                    </div>
                                    <div>
                                        <label for="exIm" class="control-label" style="line-height: 34px;">Sponsored
                                            Company</label>
                                        <br>
                                        <select name="exIm" id="" class="form-control fxq-new-select">
                                            <option value="" selected="selected">No select</option>
                                            <option value="1">Sponsored Companies preferred</option>
                                        </select>
                                    </div>
                                    <div style="margin-top:20px">
                                        <button type="button" onclick="searchTM()" class="btn btn-primary">Search
                                        </button>
                                        &nbsp;&nbsp;
                                        <button type="reset" class="btn btn-default">Reset</button>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                    <!--------------------------->
                </c:if>


                <!-- Browsing History的框 -->
                <%--<div class="col-lg-3"  style="width: 100%;">--%>
                <%--<div class="bs-component" >--%>
                <%--<div class="list-group fxq-history">--%>
                <%--<div href="#" class="list-group-item active">--%>
                <%--Browsing History--%>
                <%--</div>--%>

                <%--<c:forEach end="4" begin="0" items="${queryCompanyList}" var="list">--%>
                <%--<div class="history-box">--%>
                <%--<a href="user/reportChoose.do?companyName=${list}">${list}</a>--%>
                <%--<div class="fxq-history-hover">${list}</div>--%>
                <%--</div>--%>
                <%--</c:forEach>--%>

                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
            </div>

        </div>


    </div>
</div>

<div class="fxq-back-top">TOP</div>
<jsp:include page="${basePath}../include/bottom.jsp"/>


</div>

</body>

</html>
