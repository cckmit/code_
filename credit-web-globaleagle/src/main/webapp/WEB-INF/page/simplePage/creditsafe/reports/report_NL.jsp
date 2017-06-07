<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String type = request.getParameter("type");
    if(type==null||type.equals("")){
        type = "1";
    }

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>${companyName}</title>
    <script src="<%=basePath%>frame/jquery-1.10.2.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/htmlSaveAs.js"></script>

    <style>
        .btn-update {
            margin-top: -5px;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            test = document.getElementsByTagName('html')[0].outerHTML;
            email = "${email}";
            crefoNo = "${crefoNo}";
            customerId = "${customerId}";
        });
        function searchCompany(companyName) {
            window.open(basePath + "toSearchCompanyList.do?countryName=中国&companyName=" + companyName);
//            window.location.href = basePath+"toSearchCompanyList.do?countryName=中国&companyName="+companyName;
        }

        function credit() {
            window.open(basePath + "toIndexAddition1.do?country=" + '${cnName}' + "&companyName=" + '${companyName}' + "&companyPhone=" + '${basic.tel}' + "&companyWebsite=" + '${basic.website}' + "&companyEmail=" + '${basic.email}' + "&companyAdd=" + '${basic.addressCN}');
        }

    </script>
</head>
<body>
<%-- 	<jsp:include page="${basePath}../include/top.jsp"/>
 --%>
<%--<c:forEach var="searchDetail" items="${searchDetail}" varStatus="status">--%>

<jsp:include page="../../include/report/top2.jsp"/>

<div class="container">
    <div class="row">
        <div class="bs-component">
            <ul class="nav nav-tabs">
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/requestCompanyDetail.do?type=1&companyId=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#home" data-toggle="tab">公司概况</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/requestCompanyDetail.do?type=2&companyId=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab02" data-toggle="tab">基本信息</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/requestCompanyDetail.do?type=3&companyId=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab03" data-toggle="tab">管理人员</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/requestCompanyDetail.do?type=4&companyId=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab04" data-toggle="tab">关联公司</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/requestCompanyDetail.do?type=5&companyId=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab05" data-toggle="tab">财务数据</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/requestCompanyDetail.do?type=6&companyId=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab06" data-toggle="tab">历史记录</a></li>
                <%--<li class=""><a aria-expanded="true" href="#tab07" data-toggle="tab">负面信息</a></li>--%>
                <%--<li class=""><a aria-expanded="true" href="#tab10" data-toggle="tab">支付信息</a></li>--%>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/requestCompanyDetail.do?type=8&companyId=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab08" data-toggle="tab">运营信息</a></li>
                <li class=""><a aria-expanded="false" href="<%=basePath%>simple/customer/requestCompanyDetail.do?type=9&companyId=${crefoNo}&orderDetailId=${orderDetailId}&orderId=${orderId}#tab09" data-toggle="tab">其他信息</a></li>

            </ul>
            <div id="myTabContent" class="tab-content">
                <%
                    if (type.equals("1")){
                %>

                <div class="tab-pane fade active in" id="home">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td width="20%" class="formleft"><strong>Business Name</strong></td>
                            <td colspan="3" class="formright">
                                <div align="left">${searchDetail.companySummary.businessName}</div>
                                <div align="left"></div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Registered Name</strong></td>
                            <td colspan="3" class="formright">
                                <div align="left">${searchDetail.companyIdentification.basicInformation.registeredCompanyName}</div>
                                <div align="left"></div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft">&nbsp;</td>
                            <td width="30%" valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                            <td width="10%" class="formleft">&nbsp;</td>
                            <td width="30%" valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="formleft">&nbsp;</td>
                            <td class="formright">&nbsp;</td>
                            <td class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Main Address</strong></td>
                            <td class="formright">${searchDetail.contactInformation.mainAddress.address.simpleValue}</td>
                            <td class="formleft"><strong>Post</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${basic.zip}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>States/City</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                            <td class="formleft"><strong>Phone</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.contactInformation.mainAddress.telephone}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Website</strong></td>
                            <td valign="top" class="formright">
                                <div align="left"><c:forEach var="website"
                                                             items="${searchDetail.contactInformation.websites.website}"
                                                             varStatus="status">
                                    <div align="left"><a href="http://${website}" target="_parent">${website}</a></div>
                                </c:forEach></div>
                            </td>
                            <td class="formleft"><strong>Email</strong></td>
                            <td valign="top" class="formright">
                                <div align="left"><c:forEach var="emailAddresses"
                                                             items="${searchDetail.contactInformation.emailAddresses.emailAddress}"
                                                             varStatus="status">
                                    <div align="left">${emailAddresses}</div>
                                </c:forEach></div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft">&nbsp;</td>
                            <td class="formright">&nbsp;</td>
                            <td class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">&nbsp;</td>
                        </tr>
                        </tbody>
                    </table>
                    <img style="display:block;width:100%;"
                         src="${pageContext.request.contextPath}/images/creditRatingEN/<c:if test="${empty searchDetail.companySummary.creditRating.providerValue.value}">0</c:if>${searchDetail.companySummary.creditRating.providerValue.value}.jpg"/>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td width="20%" class="formleft">&nbsp;</td>
                            <td width="30%" class="formright">&nbsp;</td>
                            <td width="20%" class="formleft">&nbsp;</td>
                            <td width="30%" valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Status</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companySummary.companyStatus.value}</div>
                            </td>
                            <td class="formleft"><strong>Score</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companySummary.creditRating.commonValue.value()}</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Registration ID </strong></td>
                            <td valign="top" class="formright">
                                <div align="left"> ${searchDetail.companyIdentification.basicInformation.companyRegistrationNumber} </div>
                            </td>
                            <td class="formleft"><strong>Rating</strong></td>
                            <td valign="top" class="formright"><c:if
                                    test="${searchDetail.companySummary.creditRating.commonValue.value() == 'A'}">
                                Very Low Risk
                            </c:if>
                                <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'B'}">
                                    Low Risk
                                </c:if>
                                <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'C'}">
                                    Moderate Risk
                                </c:if>
                                <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'D'}">
                                    High Risk
                                </c:if>
                                <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'E'}">
                                    Very High Risk
                                </c:if></td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Main Activity Description</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.companySummary.mainActivity.activityDescription}</div>
                            </td>
                            <td valign="top" class="formleft"><strong>Recommended
                                Credit</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companySummary.creditRating.creditLimit.value} </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <%
                    }
                %>
                <%
                    if (type.equals("2")){
                %>

                <div class="tab-pane fade active in" id="tab02">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td width="20%" class="formleft"><strong>Legal Name</strong></td>
                            <td width="30%"
                                class="formright">${searchDetail.companyIdentification.basicInformation.registeredCompanyName}&nbsp;</td>
                            <td width="20%" class="formleft"><strong>Status</strong></td>
                            <td width="30%" valign="top" class="formright">
                                <div align="left">${searchDetail.companySummary.companyStatus.code}&nbsp; </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Registered Address </strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companyIdentification.basicInformation.contactAddress.simpleValue}&nbsp;</td>
                            <td class="formleft"><strong>Main Address</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.contactInformation.mainAddress.address.simpleValue}&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Phone</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.contactInformation.mainAddress.telephone}&nbsp;</div>
                            </td>
                            <td class="formleft"><strong>Telephone</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.contactInformation.mainAddress.telephone}&nbsp;</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Legal Form</strong></td>
                            <td valign="top" class="formright">
                                <div align="left"> ${searchDetail.companyIdentification.basicInformation.legalForm.value}&nbsp; </div>
                            </td>
                            <td class="formleft"><strong>Legal Form (Global)</strong></td>
                            <td valign="top" class="formright">
                                <div align="left"> ${searchDetail.companyIdentification.basicInformation.legalForm.value}&nbsp; </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Registration ID</strong></td>
                            <td class="formright">
                                <div align="left"> ${searchDetail.companyIdentification.basicInformation.companyRegistrationNumber}&nbsp; </div>
                            </td>
                            <td class="formleft"><strong>Company Type</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companyIdentification.basicInformation.typeofOwnership}&nbsp;</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Incorporation Date</strong></td>
                            <td valign="top" class="formright"><c:if
                                    test="${not empty searchDetail.companyIdentification.basicInformation.dateofCompanyRegistration}"> ${searchDetail.companyIdentification.basicInformation.dateofCompanyRegistration} </c:if></td>
                            <td valign="top" class="formleft"><strong>Date of Registration</strong></td>
                            <td valign="top"
                                class="formright"> ${searchDetail.companyIdentification.basicInformation.dateofCompanyRegistration}&nbsp; </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Registry</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companyIdentification.basicInformation.commercialCourt}&nbsp;</td>
                            <td valign="top" class="formleft"><strong>Date of Starting</strong></td>
                            <td valign="top"
                                class="formright"> ${searchDetail.companyIdentification.basicInformation.dateofStartingOperations}
                                &nbsp;</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>VAT Registration
                                Number</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companyIdentification.basicInformation.vatRegistrationNumber}&nbsp;</td>
                            <td valign="top" class="formleft"><strong>VAT Registration Date</strong></td>
                            <td valign="top"
                                class="formright"> ${searchDetail.companyIdentification.basicInformation.vatRegistrationDate}
                                &nbsp;</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Nominal Share Capital </strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.shareCapitalStructure.nominalShareCapital.value}&nbsp;</td>
                            <td valign="top" class="formleft"><strong>Issued Share capital</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.shareCapitalStructure.issuedShareCapital.value}&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">
                                <legend></legend>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Main Activity Code</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companySummary.mainActivity.activityCode}</td>
                            <td valign="top" class="formleft"><strong>Principal Activity Code</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companyIdentification.basicInformation.principalActivity.activityCode}&nbsp;</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Main Activity Description</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.companySummary.mainActivity.activityDescription}</div>
                            </td>
                            <td valign="top" class="formleft"><strong>Principal Activity Description</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companyIdentification.basicInformation.principalActivity.activityDescription}&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        </tbody>
                    </table>


                </div>
                <%
                    }
                %>
                <%
                    if (type.equals("3")){
                %>

                <div class="tab-pane fade active in" id="tab03">


                    <div class="panel-group" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading21">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse21"
                                       aria-expanded="true"
                                       aria-controls="collapse21">
                                        Current Directors / Managers（
                                        <c:if test="${empty searchDetail.directors.currentDirectors.director}">0</c:if>
                                        ${searchDetail.directors.currentDirectors.director.size()}
                                        ） </a>
                                </h4>
                            </div>
                            <div id="collapse21" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading21">
                                <div class="panel-body">
                                    <table width="100%" class="table table-hover table-bordered table-responsive">
                                        <thead>
                                        <tr>
                                            <th width="16%"><strong>Name</strong></th>
                                            <th width="22%"><span class="formleft"><strong>Position </strong></span>
                                            </th>
                                            <th width="10%"><span class="formleft"><strong>Address </strong></span>
                                            </th>
                                            <th width="10%"><span class="formleft"><strong>City </strong></span>
                                            </th>
                                            <th width="14%"><span
                                                    class="formleft"><strong>Street </strong></span></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="director"
                                                   items="${searchDetail.directors.currentDirectors.director}"
                                                   varStatus="status">
                                            <tr>
                                                <td><strong>${director.name}</strong></td>
                                                <td><c:if
                                                        test="${not empty director.position}">
                                                    <c:forEach var="corporatePosition"
                                                               items="${director.position}"
                                                               varStatus="status" begin="0" end="1">
                                                        ${corporatePosition.value}
                                                    </c:forEach></c:if>
                                                </td>
                                                <td>${director.address.simpleValue}</td>
                                                <td>${director.address.city}</td>
                                                <td>${director.address.street}</td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading22">
                                <h4 class="panel-title">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapse22"
                                       aria-expanded="false" aria-controls="collapse22">
                                        Previous Directors / Managers（
                                        <c:if test="${empty searchDetail.directors.previousDirectors.director}">0</c:if>
                                        ${searchDetail.directors.previousDirectors.director.size()}）
                                    </a>
                                </h4>
                            </div>
                            <div id="collapse22" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="headingFour">
                                <div class="panel-body">
                                    <table width="100%" class="table table-hover table-bordered table-responsive">
                                        <thead>
                                        <tr>
                                            <th width="18%"><strong>Name</strong></th>
                                            <th width="18%"><span class="formleft"><strong>Position </strong></span>
                                            </th>
                                            <th width="27%"><span class="formleft"><strong>Address </strong></span>
                                            </th>
                                            <th width="13%"><span class="formleft"><strong>City </strong></span>
                                            </th>
                                            <th width="24%"><span
                                                    class="formleft"><strong>Street </strong></span></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="director"
                                                   items="${searchDetail.directors.previousDirectors.director}"
                                                   varStatus="status">
                                            <tr>
                                                <td><strong>${director.name}</strong></td>
                                                <td><c:if
                                                        test="${not empty director.position}">
                                                    <c:forEach var="corporatePosition"
                                                               items="${director.position}"
                                                               varStatus="status" begin="0" end="1">
                                                        ${corporatePosition.value}
                                                    </c:forEach></c:if>
                                                </td>
                                                <td>${director.address.simpleValue}</td>
                                                <td>${director.address.city}</td>
                                                <td>${director.address.street}</td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
                <%
                    }
                %>
                <%
                    if (type.equals("4")){
                %>

                <div class="tab-pane fade active in" id="tab04">
                    <div class="row">
                        <div class="panel-group" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingOne">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                           aria-expanded="true"
                                           aria-controls="collapseOne">
                                            Ultimate Parent Companies – Holding Company（
                                            <c:if test="${empty entinvList}">0</c:if>
                                            ${entinvList.size()}） </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse" role="tabpanel"
                                     aria-labelledby="headingOne">
                                    <div class="panel-body">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="28%">公司名称</th>
                                                <th width="8%">出资比列</th>
                                                <th width="15%">注册资本</th>
                                                <th width="12%">成立日期</th>
                                                <th width="17%">公司类型</th>
                                                <th width="10%">公司状态</th>
                                                <th width="10%">查询</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:if test="${not empty entinvList}">
                                                <c:forEach items="${entinvList}" end="1" var="list" varStatus="status">
                                                    <tr>
                                                        <td><span
                                                                class="formleft"><strong>${list.entNameCn}</strong></span>
                                                        </td>
                                                        <td>${list.fundedRatio}</td>
                                                        <td>${list.regCapCur} ${list.regCap}</td>
                                                        <td>${list.esDate}</td>
                                                        <td>${list.entType}</td>
                                                        <td>${list.entStatus}</td>
                                                        <td><c:if test="${list.entNameCn.length()>5}">
                                                            <button type="button" class="btn btn-xs btn-primary"
                                                                    onclick="searchCompany('${list.entNameCn}')">查询该公司
                                                            </button>
                                                        </c:if></td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${ empty changeList}">
                                                <tr>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingFour">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseFour"
                                           aria-expanded="false" aria-controls="collapseFour">
                                            Parent Companies – Immediate Company（
                                            <c:if test="${empty frinvList}">0</c:if>
                                            ${frinvList.size()}）
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseFour" class="panel-collapse collapse" role="tabpanel"
                                     aria-labelledby="headingFour">
                                    <div class="panel-body">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="28%">公司名称</th>
                                                <th width="8%">出资比列</th>
                                                <th width="15%">注册资本</th>
                                                <th width="12%">成立日期</th>
                                                <th width="17%">公司类型</th>
                                                <th width="10%">公司状态</th>
                                                <th width="10%">查询</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:if test="${not empty frinvList}">
                                                <c:forEach items="${frinvList}" var="list" varStatus="status">
                                                    <tr>
                                                        <td><span
                                                                class="formleft"><strong>${list.entNameCn}</strong></span>
                                                        </td>
                                                        <td>${list.fundedRatio}</td>
                                                        <td>${list.regCapCur} ${list.regCap}</td>
                                                        <td>${list.esDate}</td>
                                                        <td>${list.entType}</td>
                                                        <td>${list.entStatus}</td>
                                                        <td><c:if test="${list.entNameCn.length()>5}">
                                                            <button type="button" class="btn btn-xs btn-primary"
                                                                    onclick="searchCompany('${list.entNameCn}')">查询该公司
                                                            </button>
                                                        </c:if></td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${ empty changeList}">
                                                <tr>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>-</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>


                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingTwo">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseTwo"
                                           aria-expanded="false" aria-controls="collapseTwo">
                                            Subsidiary Companies（
                                            <c:if test="${empty searchDetail.groupStructure.subsidiaryCompanies.subsidiary}">0</c:if>
                                            ${searchDetail.groupStructure.subsidiaryCompanies.subsidiary.size()}）
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
                                     aria-labelledby="headingTwo">
                                    <div class="panel-body">
                                        <table width="100%"
                                               class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="35%"><span class="formleft"><strong>Name</strong></span>
                                                </th>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Country</strong></span></th>
                                                <%--<th width="15%"><span--%>
                                                <%--class="formleft"><strong>Registration No.</strong></span>--%>
                                                <%--</th>--%>
                                                <th width="15%"><span
                                                        class="formleft"><strong>ID</strong></span>
                                                </th>
                                                <th width="10%"><span class="formleft"><strong>Type </strong></span>
                                                </th>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Status</strong></span></th>
                                                <th width="15%"><span
                                                        class="formleft"><strong>Address</strong></span></th>

                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="companyData"
                                                       items="${searchDetail.groupStructure.subsidiaryCompanies.subsidiary}"
                                                       varStatus="status">
                                                <tr>
                                                    <td><strong>${companyData.name}</strong></td>
                                                    <td>${companyData.country}</td>
                                                    <td>${companyData.id}</td>
                                                    <td>${companyData.type.value}</td>
                                                    <td>${companyData.status}</td>
                                                    <td>${companyData.address.simpleValue}</td>

                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingThree">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseThree"
                                           aria-expanded="false" aria-controls="collapseThree">
                                            Affiliated Companies（
                                            <c:if test="${empty searchDetail.groupStructure.affiliatedCompanies.affiliatedCompany}">0</c:if>
                                            ${searchDetail.groupStructure.affiliatedCompanies.affiliatedCompany.size()}）
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                                     aria-labelledby="headingThree">
                                    <div class="panel-body">
                                        <table width="100%"
                                               class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="40%"><span class="formleft"><strong>Name</strong></span>
                                                </th>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Country</strong></span></th>
                                                <th width="15%"><span
                                                        class="formleft"><strong>Registration No.</strong></span>
                                                </th>
                                                <th width="10%"><span class="formleft"><strong>Type </strong></span>
                                                </th>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Status</strong></span></th>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Address</strong></span></th>

                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="companyData2"
                                                       items="${searchDetail.groupStructure.affiliatedCompanies.affiliatedCompany}"
                                                       varStatus="status">
                                                <tr>
                                                    <td>${companyData2.name}</td>
                                                    <td>${companyData2.country}</td>
                                                    <td>${companyData2.registrationNumber}</td>
                                                    <td>${companyData2.type.value}</td>
                                                    <td>${companyData2.status}</td>
                                                    <td>${companyData2.address.simpleValue}</td>

                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
                <%
                    }
                %>
                <%
                    if (type.equals("5")){
                %>

                <div class="tab-pane fade active in" id="tab05">
                    <div class="row">
                        <div class="panel-group" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="heading01">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse01"
                                           aria-expanded="true"
                                           aria-controls="collapse01">
                                            Balance Sheet </a>
                                    </h4>
                                </div>
                                <c:if test="${level != '1'}">
                                    <div id="collapse01" class="panel-collapse collapse" role="tabpanel"
                                         aria-labelledby="heading01">
                                        <div class="panel-body">
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                <tr>
                                                    <td width="25%"
                                                        style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                                                        <table class="table table-striped table-responsive"
                                                               style="height: 100%">
                                                            <tbody>
                                                            <tr>
                                                                <td width="23%" class="formleft"><strong>Date Of
                                                                    Accounts</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft">
                                                                    <strong>Weeks</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft">
                                                                    <strong>Currency</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Consolidated
                                                                    A/cs</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Current
                                                                    Assets</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Raw
                                                                    Materials
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Work in
                                                                    Progress
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Finished
                                                                    Goods
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Other
                                                                    Inventories
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Total
                                                                    Inventories</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Trade
                                                                    Receivables
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Group
                                                                    Receivables
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Receivables
                                                                    Due after 1 year
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Miscellaneous
                                                                    Receivables
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Total
                                                                    Receivables</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft">
                                                                    <strong>Cash</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Other
                                                                    Current Assets</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>TOTAL
                                                                    CURRENT ASSETS</strong></td>
                                                            </tr>


                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Non-Current
                                                                    Assets</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Land &
                                                                    Buildings
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Plant &
                                                                    Machinery
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Other
                                                                    Tangible Assets
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Total
                                                                    Tangible Assets</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Intangible
                                                                    Assets</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Investments
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Loans to
                                                                    Group
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Other Loans
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Total
                                                                    Other Fixed Assets</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>TOTAL
                                                                    NON-CURRENT ASSETS</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>TOTAL
                                                                    ASSETS</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Current
                                                                    Liabilities</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Trade
                                                                    Payables
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Bank
                                                                    Liabilities
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Other
                                                                    Loans/Finance
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Group
                                                                    Payables
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Miscellaneous
                                                                    Liabilities
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>TOTAL
                                                                    CURRENT LIABILITIES</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Non-Current
                                                                    Liabilities</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Trade
                                                                    Payables due after 1
                                                                    year</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Bank
                                                                    Liabilities due after 1
                                                                    year</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Other
                                                                    Loans/Finance due after 1
                                                                    year</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Group
                                                                    Payables due after 1
                                                                    year</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>
                                                                    Miscellaneous Liabilities due
                                                                    after 1 year</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>TOTAL
                                                                    LONG TERM
                                                                    LIABILITIES</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>TOTAL
                                                                    LIABILITIES</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Shareholders’
                                                                    Equity</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Called Up
                                                                    Share Capital
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Share
                                                                    Premium
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Revenue
                                                                    Reserves
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"> Other
                                                                    Reserves
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>TOTAL
                                                                    SHAREHOLDERS EQUITY</strong>
                                                                </td>
                                                            </tr>
                                                            </tbody>

                                                        </table>
                                                    </td>
                                                    <c:forEach var="ltdFinancialStatement"
                                                               items="${searchDetail.financialStatements.financialStatement}"
                                                               varStatus="status">
                                                        <%--begin="0" end="2"--%>
                                                        <td width="25%">
                                                            <table class="table table-striped table-responsive"
                                                                   style="height: 100%">
                                                                <tr>
                                                                    <td valign="top" align="right">
                                                                            ${ltdFinancialStatement.yearEndDate}&nbsp;
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" align="right">
                                                                            ${ltdFinancialStatement.numberOfWeeks}&nbsp;
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.currency}&nbsp; </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.isConsolidatedAccounts()}
                                                                        &nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" align="right">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.rawMaterials.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.workInProgress.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.finishedGoods.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.otherInventories.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalInventories.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.tradeReceivables.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.groupReceivables.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.receivablesDueAfter1Year.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.miscellaneousReceivables.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalReceivables.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.cash.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.otherCurrentAssets.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalCurrentAssets.value}&nbsp;</td>
                                                                </tr>

                                                                <tr>
                                                                    <td valign="top" align="right">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.landAndBuildings.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.plantAndMachinery.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.otherTangibleAssets.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalTangibleAssets.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalIntangibleAssets.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.investments.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.loansToGroup.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.otherLoans.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalOtherFixedAssets.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalFixedAssets.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalAssets.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" align="right">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.tradePayables.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.bankLiabilities.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.otherLoansOrFinance.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.groupPayables.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.miscellaneousLiabilities.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalCurrentLiabilities.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" align="right">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.tradePayablesDueAfter1Year.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.bankLiabilitiesDueAfter1Year.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.otherLoansOrFinanceDueAfter1Year.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.groupPayablesDueAfter1Year.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.miscellaneousLiabilitiesDueAfter1Year.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalLongTermLiabilities.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalLiabilities.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" align="right">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.calledUpShareCapital.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.sharePremium.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.revenueReserves.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.otherReserves.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.balanceSheet.totalShareholdersEquity.value}&nbsp;</td>
                                                                </tr>

                                                            </table>
                                                        </td>
                                                    </c:forEach>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>
                            </div>


                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="heading02">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse02"
                                           aria-expanded="false" aria-controls="collapse02">
                                            Profit & Loss Account
                                        </a>
                                    </h4>
                                </div>
                                <c:if test="${level != '1'}">
                                    <div id="collapse02" class="panel-collapse collapse" role="tabpanel"
                                         aria-labelledby="heading02">
                                        <div class="panel-body">
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                <tr>
                                                    <td width="25%"
                                                        style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                                                        <table class="table table-striped table-responsive"
                                                               style="height: 100%">
                                                            <tbody>
                                                            <tr>
                                                                <td width="23%" class="formleft"><strong>Date Of
                                                                    Accounts</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft">
                                                                    <strong>Weeks</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft">
                                                                    <strong>Currency</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Consolidated
                                                                    A/cs</strong></td>
                                                            </tr>


                                                            <tr>
                                                                <td valign="top" class="formleft">
                                                                    <strong>Revenue</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Less:
                                                                    Operating Costs</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Operating
                                                                    Profit</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Less:
                                                                    Wages & Salaries</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Less:
                                                                    Pension Costs</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Less:
                                                                    Depreciation</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Less:
                                                                    Amortisation</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Add:
                                                                    Financial Income</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Less:
                                                                    Financial Expenses</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Add:
                                                                    Extraordinary
                                                                    Income</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Less:
                                                                    Extraordinary
                                                                    Costs</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Profit
                                                                    Before Tax</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong> Less:
                                                                    Tax</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Profit
                                                                    After Tax</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft">
                                                                    <strong>Dividends</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Minority
                                                                    Interests</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Other
                                                                    Appropriations</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Retained
                                                                    Profit</strong></td>
                                                            </tr>
                                                            </tbody>

                                                        </table>
                                                    </td>
                                                    <c:forEach var="ltdFinancialStatement"
                                                               items="${searchDetail.financialStatements.financialStatement}"
                                                               varStatus="status">
                                                        <%--begin="0" end="2"--%>
                                                        <td width="25%">
                                                            <table class="table table-striped table-responsive"
                                                                   style="height: 100%">
                                                                <tr>
                                                                    <td valign="top" align="right">
                                                                            ${ltdFinancialStatement.yearEndDate}&nbsp;
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" align="right">
                                                                            ${ltdFinancialStatement.numberOfWeeks}&nbsp;
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.currency}&nbsp; </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.isConsolidatedAccounts()}
                                                                        &nbsp;</td>
                                                                </tr>


                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.revenue.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.operatingCosts.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.operatingProfit.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.wagesAndSalaries.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.pensionCosts.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.depreciation.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.amortisation.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.financialIncome.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.financialExpenses.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.extraordinaryIncome.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.extraordinaryCosts.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.profitBeforeTax.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.tax.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" align="right">
                                                                            ${ltdFinancialStatement.profitAndLoss.profitAfterTax.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.dividends.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.minorityInterests.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.otherAppropriations.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.profitAndLoss.retainedProfit.value}&nbsp;</td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </c:forEach>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="heading03">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse03"
                                           aria-expanded="false" aria-controls="collapse03">
                                            Other Financials </a>
                                    </h4>
                                </div>
                                <c:if test="${level != '1'}">
                                    <div id="collapse03" class="panel-collapse collapse" role="tabpanel"
                                         aria-labelledby="heading03">
                                        <div class="panel-body">
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                <tr>
                                                    <td width="25%"
                                                        style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                                                        <table class="table table-striped table-responsive"
                                                               style="height: 100%">
                                                            <tbody>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Contingent
                                                                    Liabilities</strong>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Working
                                                                    Capital</strong></td>
                                                            </tr>
                                                            <tr>
                                                                <td valign="top" class="formleft"><strong>Net
                                                                    Worth</strong></td>
                                                            </tr>
                                                            </tbody>

                                                        </table>
                                                    </td>
                                                    <c:forEach var="ltdFinancialStatement"
                                                               items="${searchDetail.financialStatements.financialStatement}"
                                                               varStatus="status">
                                                        <%--begin="0" end="2"--%>
                                                        <td width="25%">
                                                            <table class="table table-striped table-responsive"
                                                                   style="height: 100%">
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.otherFinancials.contingentLiabilities}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.otherFinancials.workingCapital.value}&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top"
                                                                        align="right">${ltdFinancialStatement.otherFinancials.netWorth.value}&nbsp;</td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </c:forEach>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </div>


                    </div>
                </div>
                <%
                    }
                %>
                <%
                    if (type.equals("6")){
                %>

                <div class="tab-pane fade active in" id="tab06">
                    <div class="row">

                        <div class="panel-body">

                            <div class="panel panel-default">
                                <div class="panel-heading">Previous Names</div>
                                <div class="panel-body">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tbody>
                                        <c:if
                                                test="${not empty searchDetail.companyIdentification.previousNames}">
                                        <c:forEach var="previousName"
                                                   items="${searchDetail.companyIdentification.previousNames.previousName}"
                                                   varStatus="status">
                                        <tr>
                                            <td width="23%" class="formleft"><strong>
                                                    ${previousName.dateChanged}
                                            </strong>
                                            </td>

                                            <td width="77%" class="formright">
                                                <div align="left">${previousName.name}</div>
                                            </td>
                                            </c:forEach>
                                            </c:if>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading">Previous Legal Forms</div>
                                <div class="panel-body">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tbody>
                                        <c:if
                                                test="${not empty searchDetail.companyIdentification.previousLegalForms}">
                                            <c:forEach var="previousLegalForm"
                                                       items="${searchDetail.companyIdentification.previousLegalForms.previousLegalForm}"
                                                       varStatus="status">
                                                <tr>
                                                    <td width="23%" class="formleft">
                                                        <strong>${previousLegalForm.dateChanged} </strong>
                                                    </td>

                                                    <td width="77%" class="formright">
                                                        <div align="left">
                                                                ${previousLegalForm.legalForm.value}
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading">Previous Addresses</div>
                                <div class="panel-body">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tbody>
                                        <c:if
                                                test="${not empty searchDetail.contactInformation.previousAddresses.previousAddress}">
                                            <c:forEach var="streetAddress"
                                                       items="${searchDetail.contactInformation.previousAddresses.previousAddress}"
                                                       varStatus="status">
                                                <tr>
                                                    <td width="23%" class="formleft">
                                                        <strong>${streetAddress.country}</strong>
                                                    </td>
                                                    <td width="77%" class="formright">
                                                        <div align="left">
                                                                ${streetAddress.address.simpleValue}
                                                        </div>
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
                </div>
                <%
                    }
                %>
                <%
                    if (type.equals("8")){
                %>

                <div class="tab-pane fade active in" id="tab08">

                    <div class="panel-body">

                        <div class="panel panel-default">
                            <div class="panel-heading">Business</div>
                            <div class="panel-body">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <tr>
                                        <td width="23%" class="formleft"><strong>Main Business</strong></td>
                                        <td width="77%"
                                            class="formright">${searchDetail.companySummary.mainActivity.activityDescription}</td>
                                    </tr>
                                    <tr>
                                        <td class="formleft"><strong>Activity Code</strong></td>
                                        <td
                                                class="formright">${searchDetail.companySummary.mainActivity.activityCode}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>


                        <div class="panel panel-default">
                            <div class="panel-heading"> Employee Information</div>
                            <div class="panel-body">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <tr>
                                        <c:if
                                                test="${not empty searchDetail.otherInformation.employeesInformation.employeeInformation}">
                                        <c:forEach var="employeeInformation"
                                                   items="${searchDetail.otherInformation.employeesInformation.employeeInformation}"
                                                   varStatus="status">
                                    <tr>

                                        <td width="23%" class="formleft">
                                            <c:if
                                                    test="${not empty employeeInformation.year}">
                                                <strong> ${employeeInformation.year} </strong>
                                            </c:if>
                                        </td>
                                        <td width="77%" class="formright">
                                                ${employeeInformation.numberOfEmployees}
                                        </td>
                                    </tr>

                                    </c:forEach>
                                    </c:if>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>


                        <div class="panel panel-default">
                            <div class="panel-heading">Business Info</div>
                            <div class="panel-body">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <tr>
                                        <td width="23%" class="formleft"><strong>Operations Area</strong></td>
                                        <td width="77%"
                                            class="formright">${searchDetail.companySummary.mainActivity.activityDescription}</td>
                                    </tr>
                                    <tr>
                                        <td class="formleft"><strong>Company imports from</strong></td>
                                        <td
                                                class="formright">${searchDetail.companySummary.mainActivity.activityCode}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>


                        <div class="panel panel-default">
                            <div class="panel-heading"> Bankers</div>
                            <div class="panel-body">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <c:if
                                            test="${not empty searchDetail.otherInformation.bankers.banker}">
                                        <c:forEach var="banker"
                                                   items="${searchDetail.otherInformation.bankers.banker}"
                                                   varStatus="status">

                                            <tr>
                                                <td width="23%" class="formleft">
                                                    <strong>Banker Name</strong>
                                                </td>
                                                <td width="77%" class="formright">
                                                    <div align="left">
                                                            ${banker.name}
                                                    </div>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="23%" class="formleft">
                                                    <strong>Banker Address</strong>
                                                </td>
                                                <td width="77%" class="formright">
                                                    <div align="left">
                                                            ${banker.address.simpleValue}
                                                    </div>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="23%" class="formleft">
                                                    <strong>Banker Number</strong>
                                                </td>
                                                <td width="77%" class="formright">
                                                    <div align="left">
                                                            ${banker.bankCode}
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="panel-group" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading61">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse61"
                                       aria-expanded="true"
                                       aria-controls="collapse61">
                                        <span class="formleft"><strong>Other Address</strong></span> （
                                        <c:if test="${empty searchDetail.contactInformation.otherAddresses.otherAddress}">0</c:if>
                                        ${searchDetail.contactInformation.otherAddresses.otherAddress.size()}
                                        ） </a>
                                </h4>
                            </div>
                            <div id="collapse61" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading61">
                                <div class="panel-body">
                                    <table width="100%"
                                           class="table table-hover table-bordered table-responsive">
                                        <thead>
                                        <tr>
                                            <th width="40%"><span class="formleft"><strong>Other Address</strong></span>
                                            </th>
                                            <th width="30%"><span class="formleft"><strong>Country</strong></span></th>
                                            <th width="30%"><span class="formleft"><strong>Telephone</strong></span>
                                            </th>

                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="otherAddress"
                                                   items="${searchDetail.contactInformation.otherAddresses.otherAddress}"
                                                   varStatus="status">
                                            <tr>
                                                <td><strong>${otherAddress.address.simpleValue}</strong></td>
                                                <td><strong>${otherAddress.country}</strong></td>
                                                <td><strong>${otherAddress.telephone}</strong></td>

                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                    </div>

                </div>
                <%
                    }
                %>
                <%
                    if (type.equals("9")){
                %>

                <div class="tab-pane fade active in" id="tab09">
                    <div class="row">
                        <jsp:include page="${basePath}../../creditsafe/additional/additional_NL.jsp"/>
                    </div>
                </div>
                <%
                    }
                %>

            </div>

        </div>


        <c:if test="${message=='false'}">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title" style="font-family:苹方">
                        提示
                    </h3>
                </div>
                <div class="panel-body text-center">
                    <h4>数据正在传输中，请稍候再试！</h4>
                </div>
            </div>
        </c:if>
    </div>
    <p>&nbsp; </p>
</div>

<footer>
    <div class="row" style=" background-color:#f2f2f2; padding-top:50px">
        <div class="container">

            <div>


                <div class="col-lg-3">
                    <div class="bs-component">
                        <h5>支持及解决方案</h5>


                        <p style="font-size:11px">报告问题：report@global-eagle.cn
                            <br>
                            热线支持：4008 388 2938 9:00am-18:00pm<br>
                            帐户及充值问题<br>
                            优惠及折扣方案<br>
                            常见问题汇总<br>
                            联系方式<br>
                        </p>

                    </div>

                </div>


                <div class="col-lg-3">
                    <div class="bs-component">
                        <h5>更多服务</h5>


                        <p style="font-size:11px">报告问题：report@global-eagle.cn
                            <br>
                            热线支持：4008 388 2938 9:00am-18:00pm<br>
                            帐户及充值问题<br>
                            优惠及折扣方案<br>
                            常见问题汇总<br>
                            联系方式<br>
                        </p>

                    </div>

                </div>
                <div class="col-lg-6">
                    <div class="bs-component">
                        <h5>法律声明</h5>
                        <p style="font-size:11px">未经全搜书面同意，本报告不得以任何形式或部分提供给第三人。
                            <br>
                            本报告仅供签约客户作为信用、保险、营销及其他商业决策时的参考因素之一，不能用于其它用途。
                            本报告某些信息来源于非全搜所能控制的渠道，除非特别注明，此类信息均未经复核，全搜不能保证所提供信息的准确性、完整性和时效性。全搜提供本报告并不意味着为客户的商业风险提供担保,在任何情况下，对于客户的商业决策所造成的损失，无论该商业决策的做出是否参考了本报告所载信息，全搜不承担使用者的任何商业风险，也不承担由于非控因素和疏忽而引起的相应的损失和损害。
                        </p>


                    </div>

                </div>

            </div>

            <hr style="color:#000">
            <p>Global Eagle 全球鹰 </p>

        </div>
    </div>

</footer>
<%--</c:forEach>--%>
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
            $(this).parent.addClass('active');
        }).on('slid.bs.carousel', function (e) {
            if (!clickEvent) {
                var count = $('#featureCarousel .nav').children.length - 1;
                var current = $('#featureCarousel .nav li.active');
                current.removeClass('active').next.addClass('active');
                var id = parseInt(current.data('slide-to'));

                if (count == id) {
                    $('#featureCarousel .nav li').first.addClass('active');
                }
            }
            clickEvent = false;
        });
    });
</script>
<script type="application/javascript">
    var test = document.getElementsByTagName('html')[0].outerHTML;
    var email = "${email}";
</script>
</body>
</html>