<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="${basePath}../include/include.jsp"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Full Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <style>
        .navbar-holder-dark {
            padding: 20px 20px 200px 20px;
            background: #333333;
        }
    </style>
    <script type="text/javascript">
        function addOrder() {
            var productId = $("input[name='optionsRadios']:checked").val();
            if (productId == undefined || "" == productId || null == productId) {
                BootstrapDialog.alert("You have already purchased this product");
            } else {
                $("#addOrderSubmit").submit();
            }
        }
        function tishi() {
            BootstrapDialog.alert("This function is about to open");
        }
        ;
        function searchCompany(companyName) {
            window.open(basePath + "toSearchCompanyList.do?type=Suppliers&companyName=" + encodeURIComponent(companyName));
        }
        ;
        $(function () {

            var str = $('#statusID').text();
            if (str == 0) {
                $('#statusID').text("Cancel");
            } else if (str == 1) {
                $('#statusID').text("No Payment");
            } else if (str == 2) {
                $('#statusID').text("Under Investigation");
            } else if (str == 3) {
                $('#statusID').text("To Be Assigned");
            } else if (str == 4) {
                $('#statusID').text("InDevelopment");
            } else if (str == 5) {
                $('#statusID').text("Check Pending");
            } else if (str == 6) {
                $('#statusID').text("In Review");
            } else if (str == 7) {
                $('#statusID').text("To Be Released");
            } else if (str == 8) {
                $('#statusID').text("Achieve");
            }
            var cid = $("#cid").val();
            var cname = $("#cname").val();
            var collectionCompany = $("#collectionCompany").val();
            if (cid == undefined || cid == null || cid == "") {
                $("#fa-star").hide();
            } else {
                $("#fa-star").show();
                if (collectionCompany == cname) {
                    $("#fa-star i").addClass("fxq-star");
                }
            }
        });

        function download1(pathDateFile) {
            if (pathDateFile == null || pathDateFile == undefined || pathDateFile == '') {
                BootstrapDialog.alert("PDF is being generated, please wait a moment");
            } else {
                window.open("http://192.168.1.40:8888/" + pathDateFile);
            }
        }
        function fastar() {
            var senddata = {
                "customerId": $("#cid").val(),
                "collectionCompany": $("#cname").val()
            };
            BootstrapDialog.show({
                title: 'Collection',
                message: "Are you sure?",
                buttons: [{
                    label: 'submit',
                    action: function (dialog) {
                        if ($("#fa-star i").hasClass("fxq-star")) {
                            $.ajax({
                                type: "POST",
                                url: basePath + "customer/delCollection.do",
                                dataType: "json",
                                contentType: "application/json",
                                data: JSON.stringify(senddata),
                                success: function (data) {
                                    BootstrapDialog.alert("Cancel the collection success");
                                    dialog.close();
                                    $("#fa-star i").removeClass("fxq-star");
                                }
                            });
                        } else {
                            $.ajax({
                                type: "POST",
                                url: basePath + "customer/collectionSave.do",
                                dataType: "json",
                                contentType: "application/json",
                                data: JSON.stringify(senddata),
                                success: function (data) {
                                    BootstrapDialog.alert("Collection of success");
                                    dialog.close();
                                    $("#fa-star i").addClass("fxq-star");
                                }
                            });
                        }
                    }
                }, {
                    label: 'cancel',
                    action: function (dialog) {
                        dialog.close();
                    }
                }]
            });
        }
        $(function () {
            $(".fxq-pack-up").click(function () {
                $(".fxq-pack-con").slideUp();
                $(".fxq-drop-down").css("display", "block");
            })
            $(".fxq-drop-down").click(function () {
                $(".fxq-drop-down").css("display", "none");
                $(".fxq-pack-con").slideDown();
            })



        });

        var companyName="${companyName}";
        var province="${province.getProvinceEN()}";
        var city="${city.getCityEN()}";
        function creditAdditional2() {
            window.open(basePath + "customer/toIndexAddition2.do?companyName="+companyName+"&province="+province+"&city="+city);
        }
        function creditAdditional3() {
            window.open(basePath + "customer/toIndexAddition3.do?companyName="+companyName);
        }
        function creditAdditional4() {
            window.open(basePath + "customer/toIndexAddition4.do?companyName="+companyName);
        }
        function creditAdditional5() {
            window.open(basePath + "customer/toIndexAddition5.do?companyName="+companyName+"&province="+province+"&city="+city);
        }
        function creditAdditional6() {
            window.open(basePath + "customer/toIndexAddition6.do?companyName="+companyName);
        }
    </script>


</head>
<body>
<jsp:include page="../include/top.jsp"/>
<p>${errorInfo}</p>
<div class="container">
    <div class="bs-docs-section">
        <div class="row">
            <div class="col-lg-12" style="overflow: hidden;margin: 15px 0;">
                <h3 class="col-lg-9" style="float: left;margin: 0;line-height: 30px;">${orderDetail.getCompanyName()}</h3>
                <div  class="col-lg-3" style="float: right;line-height: 30px;font-weight: bold;text-align: right;">
                    <c:if test="${orderDetail.getStatus()==4}">
                        Update will be avaliable soon.
                    </c:if>
                    <c:if test="${orderDetail.getStatus()==8}">
                    Your report has been completed.
                    </c:if>
                </div>
            </div>
        </div>

        <form id="addOrderSubmit" action="<%=basePath%>customer/addOrder.do" method="post">
            <input id="cname" name="companyName" value="${orderDetail.getCompanyName()}" type="hidden">
            <input name="companyNo" value="${companyNo}" type="hidden">
            <input name="companyNameCN" value="${orderDetail.getCompanyNameCN()}" type="hidden">
            <input id="cid" name="customerId" value="${customerId}" type="hidden">
            <input name="crefoNo" value="${crefoNo}" type="hidden">
            <input id="collectionCompany" name="collectionCompany" value="${collectionCompany}" type="hidden">

            <div class="row fxq-change">
                <div class="col-lg-12">
                    <div class="bs-component fxq-pack-con">
                        <div class="well" style="position:relative;min-height:90px">

                            <table width="70%" border="0" cellspacing="0" cellpadding="0" style="float: left;">
                                <tbody>
                                <!--产品选择-->
                                <c:if test="${products.getResult()}">
                                    <c:forEach var="product" items="${products.getRows()}" varStatus="status">
                                        <tr>
                                            <td align="center">
                                                <input name="optionsRadios" id="productId" value="${product.getId()}"
                                                       type="radio" style="margin-right:15px"
                                                       <c:if test="${product.getHasOrder()!='false'}">disabled</c:if>
                                                       <c:if test="${product.getHasOrder()=='false'}">checked</c:if>
                                                >
                                            </td>
                                            <td width="20%" align="left">
                                                <strong> ${product.getCurrency()}&nbsp;${product.getPrice()}&nbsp;&nbsp;
                                                </strong>
                                            </td>
                                            <td width="25%" align="left">
                                                <strong>
                                                    <span class="hidden-xs label-lg">${product.getName()}</span>
                                                </strong>
                                            </td>
                                            <td width="35%" align="left">
                                                <strong>
                                                    <span class="hidden-xs label-lg">${product.getDesc()}</span>
                                                </strong>
                                            </td>
                                            <td width="20%" align="left">
                                                <c:if test="${product.getExpectHour()=='0'}">Instant</c:if>
                                                <c:if test="${product.getExpectHour()!='0'}">${product.getExpectHour()}&nbsp;Hours</c:if>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </c:if>
                                </tbody>
                            </table>
                            <%--订单日期--%>
                            <div style="width: 15%;float:left">
                                <div style="width: 135px;height: 23px;">
                                    <c:if test="${orderDetail.getProductId()=='8'}">
                                        <div class="fxq-order-date">
                                            Order Date:<fmt:formatDate value="${order.getCreateTime()}"/>
                                        </div>
                                    </c:if>
                                </div>
                                <div style="width: 135px;height: 23px;">
                                    <c:if test="${orderDetail.getProductId()=='9'}">
                                        <div class="fxq-order-date">
                                            Order Date:<fmt:formatDate value="${order.getCreateTime()}"/>
                                        </div>
                                    </c:if>

                                    <c:if test="${orderDetail.getProductId()=='8'}">
                                        <div class="fxq-order-date">
                                            Never Order
                                        </div>
                                    </c:if>
                                </div>
                                <div style="width: 135px;height: 23px;">
                                    <c:if test="${orderDetail.getProductId()=='10'}">
                                        <div class="fxq-order-date">
                                            Order Date:<fmt:formatDate value="${order.getCreateTime()}"/>
                                        </div>
                                    </c:if>
                                    <c:if test="${orderDetail.getProductId()!='10'}">
                                        <div class="fxq-order-date">
                                            Never Order
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <div style="width: 15%;float:right">
                                <button type="button" class="btn btn-success" onclick="addOrder()">
                                    Order This Company
                                </button>
                                <%--<div style="float:right;margin-right:15px">--%>
                                <button type="button" class="fxq-pack-up">
                                    Hide This Bar<span style="font-size: 15px;text-decoration: none">↑</span>
                                </button>
                                <%--</div>--%>
                            </div>
                            <div style="clear:both"></div>
                        </div>
                    </div>
                    <div class="fxq-drop-down">How to get this information?
                        <span style="font-size: 16px;text-decoration: none">↓</span>
                    </div>
                </div>


            </div>
        </form>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid" style="padding: 0;">
                <div class="navbar-header">
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2" style="padding: 0;">
                    <%--新增功能键--%>
                    <form class="navbar-form navbar-right" role="search" style="float:left!important;">
                        <div class="form-group">
                            <button type="button" class="fxq-new-but" onclick="creditAdditional2()" style="font-size: 12px">Field Verification</button>
                            <button type="button" class="fxq-new-but" onclick="creditAdditional3()" style="font-size: 12px"> Legal Services</button>
                            <button type="button" class="fxq-new-but" onclick="creditAdditional4()" style="font-size: 12px"> Due Diligence</button>
                            <button type="button" class="fxq-new-but" onclick="creditAdditional5()" style="font-size: 12px"> Debt Collection</button>
                            <button type="button" class="fxq-new-but" onclick="creditAdditional6()" style="font-size: 12px"> Industry Analysis</button>
                        </div>
                    </form>

                    <ul class="nav navbar-nav" style="float: right;">
                        <%--<li style="height: 100%;">--%>
                            <%--<button id="money" style="background: #fff;color: #008dd9;font-weight: bold;width: 20px;height: 20px;margin:15px 15px 0 0;-webkit-border-radius:50% ;-moz-border-radius: 50%;border-radius: 50%;">￥</button>--%>
                        <%--</li>--%>
                        <li>
                            <a href="#" class="fxq-nav-hover" onclick="download1('${orderDetail.pathDataFile}')">
                                <i class="fa fa-arrow-down"></i>
                                <div class="fxq-s-t">
                                    Download
                                    <div class="fxq-s-sjx"></div>
                                </div>
                                <%--<span>PDF&nbsp;download</span>--%>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="fxq-nav-hover"  onclick="tishi();" >
                                <i class="fa fa-share"></i>
                                <div class="fxq-s-t">
                                    Share
                                    <div class="fxq-s-sjx"></div>
                                </div>
                                <%--<span>Share</span>--%>
                            </a>
                        </li>
                        <li>
                            <a href="#"  class="fxq-nav-hover" onclick="tishi();">
                                <i class="fa fa-question-circle"></i>
                                <div class="fxq-s-t">
                                    Suggestion
                                    <div class="fxq-s-sjx"></div>
                                </div>
                                <%--<span>Suggest</span>--%>
                            </a>
                        </li>
                        <li>
                            <a href="#" id="fa-star" class="fxq-nav-hover" onclick="fastar()">
                                <i class="fa fa-star"></i>
                                <div class="fxq-s-t">
                                    Favorite
                                    <div class="fxq-s-sjx"></div>
                                </div>
                                <%--<span>Favorite</span>--%>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <c:if test="${message=='false'}">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title" style="font-family:苹方">
                        Prompt
                    </h3>
                </div>
                <div class="panel-body text-center">
                    <h4>Data is transmitted, please try again later!</h4>
                </div>
            </div>
        </c:if>
        <div class="row" style="min-height:370px">
            <div class="col-lg-12">

                <div class="smart-body">

                    <ul class="nav nav-tabs default bordered">
                        <li class="active">
                            <a href="#Background" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-home"></i></span>
                                <span class="hidden-xs">Background</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Location" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-man"></i></span>
                                <span class="hidden-xs">Location</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Registration" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-man"></i></span>
                                <span class="hidden-xs">Registration
                                  <span class="badge"
                                        style="background-color: dodgerblue"
                                  >1</span>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#History" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-man"></i></span>
                                <span class="hidden-xs">History&nbsp;
                                    <span class="badge"
                                          style="background-color: dodgerblue"
                                    >1</span>
                                </span>
                            </a>
                        </li>

                        <li>
                            <a href="#Related" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-man"></i></span>
                                <span class="hidden-xs">Related</span> <span class="badge"
                                                                             style="background-color: dodgerblue"
                            >1</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Public_record" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-email"></i></span>
                                <span class="hidden-xs">Public Record</span> <span class="badge"
                                    <c:if test="${orderDetail.getProductId()!='8'}">
                                        style="background-color: dodgerblue"
                                    </c:if>
                            >2</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Performance" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-email"></i></span>
                                <span class="hidden-xs">Performance</span> <span class="badge"
                                    <c:if test="${orderDetail.getProductId()!='8'}">
                                        style="background-color: dodgerblue"
                                    </c:if>
                            >2</span>
                            </a>
                        </li>
                        <li>
                            <a href="#Industry" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-settings2"></i></span>
                                <span class="hidden-xs">Business</span> <span class="badge"
                                    <c:if test="${orderDetail.getProductId()=='10'}">
                                        style="background-color: dodgerblue"
                                    </c:if>
                            >3</span>
                            </a>
                        </li>

                        <li>
                            <a href="#Credit_rating" data-toggle="tab">
                                <span class="visible-xs"><i class="icon-settings2"></i></span>
                                <span class="hidden-xs">Credit Rating</span> <span class="badge"
                                    <c:if test="${orderDetail.getProductId()=='10'}">
                                        style="background-color: dodgerblue"
                                    </c:if>
                            >3</span>
                            </a>
                        </li>

                    </ul>


                    <div class="tab-content">

                        <div class="tab-pane fade active in" id="Background">

                            <div class="slimScrollBar">
                                <div class="scrollable">

                                    <table class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tbody>
                                        <%--<tr>--%>
                                            <%--<td align="right">&nbsp;</td>--%>
                                            <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                                        <%--</tr>--%>
                                        <tr>
                                            <td width="15%" height="35" align="right"><strong>Company Name</strong></td>
                                            <td width="39%" style="padding-left:20px">${companyName}
                                            </td>
                                            <td width="15%" height="35" align="right"><strong>Reg ID</strong></td>
                                            <td width="35%"><span
                                                    style="padding-left:20px">${companyBasicInfo.registrationId}</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td height="35" align="right"><strong>Chinese Name</strong></td>
                                            <td style="padding-left:20px">${companyBasicInfo.companyName}</td>
                                            <td height="35" align="right"><strong>Local</strong></td>
                                            <td><span style="padding-left:20px">${companyBasicInfo.localEn}</span></td>
                                        </tr>
                                        <tr>
                                            <td height="35" align="right"><strong>Trade Name</strong></td>
                                            <td><span style="padding-left:20px">-</span>
                                            </td>
                                            <td height="35" align="right" valign="top"><strong>Website</strong></td>
                                            <td valign="top"><a href="${companyBasicInfo.url}" target="_blank"><span
                                                    style="padding-left:20px">${companyBasicInfo.url}</span></a></td>
                                        </tr>
                                        <%--<tr>--%>
                                            <%--<td height="35" colspan="4" align="right">&nbsp;</td>--%>
                                        <%--</tr>--%>
                                        <tr>
                                            <td height="35" colspan="4" align="left">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">Products &amp; Services</div>
                                                    <div class="panel-body">
                                                        <table class="" width="100%" border="0" cellspacing="0" cellpadding="0">
                                                            <tbody>
                                                            <%--<tr>--%>
                                                                <%--<td width="15%" align="right">&nbsp;</td>--%>
                                                                <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                                                            <%--</tr>--%>
                                                            <tr>
                                                                <td height="35" width="10%" align="right" valign="top"><strong>Main Product</strong></td>
                                                                <td  valign="top" style="padding-left:20px"> ${companyBasicInfo.productIntroductionEn}
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td width="10%" height="35" align="right" valign="top">
                                                                    <strong>Link</strong></td>
                                                                <td  valign="top"
                                                                    style="padding-left:20px"><a
                                                                        href="https://ydwatch.en.alibaba.com"
                                                                        target="_blank">-</a>
                                                                </td>
                                                            </tr>
                                                            <%--<tr>--%>
                                                                <%--<td height="35" align="right" valign="top"><strong>Services--%>
                                                                    <%--introduction </strong></td>--%>
                                                                <%--<td width="39%" valign="top"--%>
                                                                    <%--style="padding-left:20px"> ${companyBasicInfo.servicesIntroductionEn}--%>
                                                                <%--</td>--%>
                                                                <%--<td width="15%" height="35" align="right" valign="top">--%>
                                                                    <%--<strong>Link</strong></td>--%>
                                                                <%--<td width="39%" valign="top"--%>
                                                                    <%--style="padding-left:20px">---%>
                                                                <%--</td>--%>
                                                            <%--</tr>--%>
                                                            <%--<tr>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                            <%--</tr>--%>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="4" style="border: 0;background: #fff">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">Contact Info</div>
                                                    <div class="panel-body">
                                                        <table class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
                                                            <tbody>
                                                            <%--<tr>--%>
                                                                <%--<td width="15%" align="right">&nbsp;</td>--%>
                                                                <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                                                            <%--</tr>--%>
                                                            <tr>
                                                                <td height="35" align="right" valign="top"  width="11%"><strong>Headquater Address</strong></td>
                                                                <td width="39%" valign="top"
                                                                    style="padding-left:20px">${basicInfos.streetEN} ${basicInfos.districtEN} ${basicInfos.cityEN} ${basicInfos.provinceEN} ${basicInfos.countryEN}
                                                                </td>
                                                                <td width="15%" align="right" valign="top">
                                                                    <strong>Region</strong></td>
                                                                <td width="39%" valign="top" style="padding-left:20px">
                                                                    <c:if test="${city.getCityEN()!=null&&province.getProvinceEN()==null}">
                                                                        ${city.getMetropolitanAreaEN()}
                                                                    </c:if>
                                                                    <c:if test="${city.getCityEN()==null&&province.getProvinceEN()!=null}">
                                                                        ${province.getMetropolitanAreaEN()}
                                                                    </c:if>
                                                                    <c:if test="${city.getCityEN()!=null&&province.getProvinceEN()!=null}">
                                                                        ${city.getMetropolitanAreaEN()}
                                                                    </c:if>
                                                                    <c:if test="${city.getCityEN()==null&&province.getProvinceEN()!=null}">

                                                                    </c:if>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td height="35" align="right" valign="top">
                                                                    <strong>Email</strong></td>
                                                                <td width="39%" valign="top"
                                                                    style="padding-left:20px">${basicInfos.email}
                                                                </td>
                                                                <td align="right" valign="top"><strong>Tel</strong></td>
                                                                <td width="39%" valign="top"
                                                                    style="padding-left:20px">
                                                                    <c:if test="${basicInfos.areaCode!=null && basicInfos.tel!=null}">${basicInfos.areaCode}-${basicInfos.tel}</c:if>
                                                                    <c:if test="${basicInfos.areaCode==null && basicInfos.tel==null}">-</c:if>
                                                                </td>
                                                            </tr>
                                                            <%--<tr>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                                <%--<td align="right" valign="top">&nbsp;</td>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                            <%--</tr>--%>

                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="4" style="border: 0;background: #fff">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">Company Info</div>
                                                    <div class="panel-body">
                                                        <table class="" width="100%" border="0" cellspacing="0" cellpadding="0">
                                                            <tbody>
                                                            <%--<tr>--%>
                                                                <%--<td width="15%" align="right">&nbsp;</td>--%>
                                                                <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                                                            <%--</tr>--%>
                                                            <tr>
                                                                <td height="35" align="right" valign="top"><strong>Company Size</strong></td>
                                                                <td height="35" colspan="3" valign="top"
                                                                    style="padding-left:20px">
                                                                    <p>${companyBasicInfo.aboutUsEn}</p></td>
                                                            </tr>
                                                            <%--<tr>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                                <%--<td width="39%">&nbsp;</td>--%>
                                                                <%--<td width="15%">&nbsp;</td>--%>
                                                                <%--<td width="39%">&nbsp;</td>--%>
                                                            <%--</tr>--%>
                                                            <%--<tr>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                                <%--<td>&nbsp;</td>--%>
                                                            <%--</tr>--%>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="4" style="border: 0;background: #fff">
                                                <div class="panel panel-default" style="position: relative;margin-bottom: 0;">
                                                    <div class="panel-heading">Company Pictures</div>
                                                    <div class="panel-body">
                                                        <img src="<%=basePath%>../images/site/ban4.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                                                        <img src="<%=basePath%>../images/site/ban3.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                                                        <img src="<%=basePath%>../images/site/ban2.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                                                        <img src="<%=basePath%>../images/site/ban1.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                                                    </div>

                                                    <div class="fxq-photo-mask">
                                                        <div class="photo-pre"> < </div>
                                                        <div class="photo-next"> > </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>

                        <div class="tab-pane fade in" id="Location">
                            <table class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tbody>
                                <%--<tr>--%>
                                    <%--<td align="right">&nbsp;</td>--%>
                                    <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                                <%--</tr>--%>
                                <c:if test="${city.getCityEN()!=null&&province.getProvinceEN()==null}">
                                    <tr>
                                        <td width="14%" height="35" align="right"><strong>City / Province</strong></td>
                                        <td width="27%"
                                            style="padding-left:20px"> ${city.getCityEN()}/
                                        </td>
                                        <td width="24%" height="35" align="right"><strong>Metropolitan Area</strong>
                                        </td>
                                        <td width="35%"><span
                                                style="padding-left:20px">${city.getMetropolitanAreaEN()}</span></td>
                                    </tr>
                                    <tr>
                                        <td height="35" align="right"><strong>Area</strong></td>
                                            <td style="padding-left:20px">
                                                <c:if test="${city.getArea()!=null&&city.getArea()!=''}">${city.getArea()} million sq km</c:if>
                                            </td>
                                        <td height="35" align="right"><strong>Population</strong></td>
                                        <td>
                                            <c:if test="${city.getPopulation()!=null&&city.getPopulation()!=''}">
                                                <span style="padding-left:20px">
                                                <c:if test="${city.getPopulation() !=''}">
                                                    <fmt:formatNumber value="${city.getPopulation()}0000" pattern="#,#00"/>
                                                </c:if>
                                                </span>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="35" align="right" valign="top"><strong>Nominal Gdp Total</strong>
                                        </td>
                                        <td valign="top" style="padding-left:20px">
                                            <c:if test="${city.getNominalGdpTotal()!=null&&city.getNominalGdpTotal()!=''}">
                                                <span>CNY ${city.getNominalGdpTotal()} billion</span>
                                            </c:if>
                                        </td>
                                        <td height="35" align="right"><strong>Nominal Gdp Per Capita</strong></td>
                                        <td>
                                            <c:if test="${city.getNominalGdpPerCapita()!=null&&city.getNominalGdpPerCapita()!=''}">
                                                <span style="padding-left:20px">CNY
                                                    <c:if test="${city.getNominalGdpPerCapita() !=''}">
                                                        <fmt:formatNumber value="${city.getNominalGdpPerCapita()}0000" pattern="#,#00"/>
                                                    </c:if>
                                                </span>

                                            </c:if>
                                        </td>

                                    </tr>
                                </c:if>
                                <c:if test="${province.getProvinceEN()!=null&&city.getCityEN()==null}">
                                    <tr>
                                        <td width="14%" height="35" align="right"><strong>City / Province</strong></td>
                                        <td width="27%"
                                            style="padding-left:20px"> /${province.getProvinceEN()}
                                        </td>
                                        <td width="24%" height="35" align="right"><strong>Metropolitan Area</strong>
                                        </td>
                                        <td width="35%"><span
                                                style="padding-left:20px">${province.getMetropolitanAreaEN()}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="35" align="right"><strong>Area</strong></td>
                                        <td style="padding-left:20px">
                                            <c:if test="${province.getArea()!=null&&province.getArea()!=''}">${province.getArea()} million sq km</c:if>
                                        </td>
                                        <td height="35" align="right"><strong>Population</strong></td>
                                        <td><c:if
                                                test="${province.getPopulation()!=null&&province.getPopulation()!=''}">
                                            <span style="padding-left:20px">
                                            <c:if test="${province.getPopulation()!=''}">
                                                <fmt:formatNumber value="${province.getPopulation()}0000" pattern="#,#00"/>
                                            </c:if>
                                            </span>
                                        </c:if></td>
                                    </tr>
                                    <tr>
                                        <td height="35" align="right" valign="top"><strong>Nominal Gdp Total</strong>
                                        </td>
                                        <td valign="top" style="padding-left:20px">
                                            <c:if test="${province.getNominalGdpTotal()!=null&&province.getNominalGdpTotal()!=''}">
                                                <span>CNY ${province.getNominalGdpTotal()} billion</span>
                                            </c:if>
                                        </td>
                                        <td height="35" align="right"><strong>Nominal Gdp Per Capita</strong></td>
                                        <td>
                                            <c:if test="${province.getNominalGdpPerCapita()!=null&&province.getNominalGdpPerCapita()!=''}">
                                                <span style="padding-left:20px">CNY
                                                <c:if test="${province.getNominalGdpPerCapita() !=''}">
                                                    <fmt:formatNumber value="${province.getNominalGdpPerCapita()}0000" pattern="#,#00"/>
                                                </c:if>
                                                </span>
                                            </c:if>
                                        </td>

                                    </tr>
                                </c:if>
                                <c:if test="${province.getProvinceEN()!=null&&city.getCityEN()!=null}">
                                    <tr>
                                        <td width="14%" height="35" align="right"><strong>City / Province</strong></td>
                                        <td width="27%"
                                            style="padding-left:20px"> ${city.getCityEN()}/${province.getProvinceEN()}
                                        </td>
                                        <td width="24%" height="35" align="right"><strong>Metropolitan Area</strong>
                                        </td>
                                        <td width="35%"><span
                                                style="padding-left:20px">${city.getMetropolitanAreaEN()}</span></td>
                                    </tr>
                                    <tr>
                                        <td height="35" align="right"><strong>Area</strong></td>
                                        <td style="padding-left:20px">
                                            <c:if test="${city.getArea()!=null&&city.getArea()!=''}">${city.getArea()} million sq km</c:if>
                                        </td>
                                        <td height="35" align="right"><strong>Population</strong></td>
                                        <td>
                                            <c:if test="${city.getPopulation()!=null&&city.getPopulation()!=''}">
                                                <span style="padding-left:20px">
                                                <c:if test="${city.getPopulation() !=''}">
                                                    <fmt:formatNumber value="${city.getPopulation()}0000" pattern="#,#00"/>
                                                </c:if>
                                                </span>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="35" align="right" valign="top"><strong>Nominal Gdp Total</strong>
                                        </td>
                                        <td valign="top" style="padding-left:20px">
                                            <c:if test="${city.getNominalGdpTotal()!=null&&city.getNominalGdpTotal()!=''}">
                                                <span>CNY ${city.getNominalGdpTotal()} billion</span>
                                            </c:if>
                                        </td>
                                        <td height="35" align="right"><strong>Nominal Gdp Per Capita</strong></td>
                                        <td>
                                            <c:if test="${city.getNominalGdpPerCapita()!=null&&city.getNominalGdpPerCapita()!=''}">
                                                <span style="padding-left:20px">CNY
                                                    <c:if test="${city.getNominalGdpPerCapita() !=''}">
                                                        <fmt:formatNumber value="${city.getNominalGdpPerCapita()}0000" pattern="#,#00"/>
                                                    </c:if>
                                                </span>
                                            </c:if>
                                        </td>

                                    </tr>
                                </c:if>
                                <c:if test="${province.getProvinceEN()==null&&city.getCityEN()==null}">
                                    <tr>
                                        <td width="14%" height="35" align="right"><strong>City / Province</strong></td>
                                        <td width="27%"
                                            style="padding-left:20px"> /
                                        </td>
                                        <td width="24%" height="35" align="right"><strong>Metropolitan Area</strong>
                                        </td>
                                        <td width="35%"><span style="padding-left:20px"></span></td>
                                    </tr>
                                    <tr>
                                        <td height="35" align="right"><strong>Area</strong></td>
                                        <td style="padding-left:20px"></td>
                                        <td height="35" align="right"><strong>Population</strong></td>
                                        <td><span style="padding-left:20px"></span></td>
                                    </tr>
                                    <tr>
                                        <td height="35" align="right" valign="top"><strong>Nominal Gdp Total</strong>
                                        </td>
                                        <td valign="top" style="padding-left:20px">
                                            <span></span>
                                        </td>
                                        <td height="35" align="right"><strong>Nominal Gdp Per Capita</strong></td>
                                        <td>
                                            <span style="padding-left:20px"></span>
                                        </td>

                                    </tr>
                                </c:if>
                                <%--<tr>--%>
                                    <%--<td height="35" colspan="4" align="right">&nbsp;</td>--%>
                                <%--</tr>--%>
                                <tr>
                                    <td height="35" colspan="4" align="left">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">Map</div>
                                            <div class="panel-body">
                                                <table class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tbody>
                                                    <tr>
                                                        <td>
                                                            <iframe src="http://j.map.baidu.com/7PcTj" width="98%"
                                                                    height="350px" frameborder="0" scrolling="no"
                                                                    marginwidth="0" marginheight="0"></iframe>
                                                        </td>
                                                        <td>
                                                            <iframe src="http://j.map.baidu.com/7PcTj" width="98%"
                                                                    height="350px" frameborder="0" scrolling="no"
                                                                    marginwidth="0" marginheight="0"></iframe>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                        <%--样式--%>
                        <jsp:include page="report/orderDetail8.jsp"/>
                        <jsp:include page="report/orderDetail9.jsp"/>
                        <jsp:include page="report/orderDetail10.jsp"/>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<br>

<jsp:include page="${basePath}../include/bottom.jsp"/>


</div>


<script>
    var message = "${message}";

    $(document).ready(function () {

        if(message=='false'){
            var t=setTimeout(function(){
                reloadDate();
            },5000);
        }

        $('.navbar .dropdown, .dropdown-submenu').hover(function () {
            //$(this).find('.dropdown-menu').first().stop(true, true).delay(250).slideDown();
            //$(this).find('.dropdown-menu').show().removeClass('flipOutY').addClass('animated flipInY');
            //$(this).find('.dropdown-menu').show().removeClass('bounceOut').addClass('animated bounceIn');
            //$(this).find('.dropdown-menu').first().show();


        }, function () {
            //$(this).find('.dropdown-menu').first().stop(true, true).delay(100).slideUp();
            //$(this).find('.dropdown-menu').removeClass('flipInY').addClass('animated flipOutY').fadeOut();
            //$(this).find('.dropdown-menu').removeClass('bounceIn').addClass('animated bounceOut').fadeOut();
            //$(this).find('.dropdown-menu').first().hide();

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
//点击图片放大
//       $(function(){
//        var photos;
//        var num;
//        $(".fxq-photo").click(function(e){
//            var indexnum=$(this).index();
//            e.stopPropagation();
//            $(".fxq-photo-mask").css("display","block");
//            photos=$(this).parent().children().clone().css({"float":"left","width":"100%","height":"100%","margin":"0 0 15px 0"});
//            num=photos.length;
//            var photo=photos.eq(indexnum);
//            photo.appendTo($(".fxq-photo-mask"));
//            photo.after(photo.siblings().not(".photo-next").not(".photo-pre"))
//        })
//
//
//        $(".photo-next").click(function(e){
//            e.stopPropagation();
//
//            num--;
//            if(num==1){
//                num=photos.length;
//            }
//            $(".fxq-photo-mask").children().eq(num).css("display","block").siblings().not(".photo-next").not(".photo-pre").css("display","none");
//        });
//
//        $(".photo-pre").click(function(e){
//            e.stopPropagation();
//            num--;
//            if(num==1){
//                num=photos.length;
//            }
//            $(".fxq-photo-mask").children().eq(num).css("display","block").siblings().not(".photo-next").not(".photo-pre").css("display","none");
//        });
//        $(document).click(function(e){
//            e.stopPropagation();
//            $(".fxq-photo-mask").css("display","none").children().not(".photo-next").not(".photo-pre").empty();
//
//        });
//    })

    function reloadDate() {
        window.location.reload();
    }
</script>

</body>
</html>