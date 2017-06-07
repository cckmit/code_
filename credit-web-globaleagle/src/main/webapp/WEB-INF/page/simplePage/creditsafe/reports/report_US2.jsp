<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>${companyName}</title>
    <script src="${pageContext.request.contextPath}/js/htmlSaveAs.js"></script>

    <style>
        .btn-update {
            margin-top: -5px;
        }
    </style>
</head>
<body>
<%-- 	<jsp:include page="${basePath}../include/top.jsp"/>
 --%>
<%--<c:forEach var="searchDetail" items="${searchDetail}" varStatus="status">--%>

<div class="container">
    <jsp:include page="${basePath}../../include/report/top.jsp"/>


    <c:if test="${message!='false'}">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">COMPANY SUMMARY <span class="pull-right"> <a href="javascript:void(0);"
                                                                                 onclick="update()"
                                                                                 class="btn btn-xs btn-default btn-update">更新</a> </span>
            </h3>
        </div>
        <div class="panel-body">

            <div class="panel panel-default">
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td class="formleft"><strong>Business Name</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companySummary.businessName}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Registration ID </strong></td>
                            <td class="formright">
                                <div align="left"> ${searchDetail.companyIdentification.basicInformation.companyRegistrationNumber} </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Status</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companySummary.companyStatus.value}</div>
                            </td>
                        </tr>
                        <tr>
                            <td width="23%" class="formleft"><strong>Country</strong></td>
                            <td width="77%"
                                class="formright">${searchDetail.companyIdentification.basicInformation.country}</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Business Activity</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.companySummary.mainActivity.activityDescription}</div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Latest Turnover</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.companySummary.latestTurnoverFigure.value}</div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Latest Equity</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.companySummary.latestShareholdersEquityFigure.value}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Credit Rating</strong></td>
                            <td class="formright">
                                <div align="left"> <span>
                                        ${searchDetail.companySummary.creditRating.commonValue.value()}
                                </span></div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Credit Rating Description</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companySummary.creditRating.providerDescription}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Recommended Line</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.companySummary.creditRating.creditLimit.value}</div>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">BASIC INFOMATION
                <span class="pull-right">
                    <a href="javascript:void(0);" onclick="update()" class="btn btn-xs btn-default btn-update">更新</a>
                </span></h3>
        </div>
        <div class="panel-body">

            <div class="panel panel-default">
                <div class="panel-heading">Contect Info</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td class="formleft"><strong>Bussiness Name</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companySummary.businessName}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Registered Name</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companyIdentification.basicInformation.registeredCompanyName}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Registered Address </strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companyIdentification.basicInformation.contactAddress.simpleValue}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Phone</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.contactInformation.mainAddress.telephone}</div>
                            </td>
                        </tr>
                        <tr>
                            <td width="23%" class="formleft"><strong>Main Address</strong></td>
                            <td width="77%"
                                class="formright">${searchDetail.contactInformation.mainAddress.address.simpleValue}</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Status</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companySummary.companyStatus.value}</div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Location Status</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Main Activity Code</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.companySummary.mainActivity.activityCode}</div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Main Activity Description</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.companySummary.mainActivity.activityDescription}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Telephone</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.contactInformation.mainAddress.telephone}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Email</strong></td>
                            <td class="formright">
                                <c:forEach var="emailAddresses"
                                           items="${searchDetail.contactInformation.emailAddresses.emailAddress}"
                                           varStatus="status">
                                    <div align="left">${emailAddresses}</div>
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Website</strong></td>
                            <td valign="top" class="formright"><c:forEach var="website"
                                                                          items="${searchDetail.contactInformation.websites.website}"
                                                                          varStatus="status">
                                <div align="left">${website}</div>
                            </c:forEach></td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>More Phone</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.contactInformation.mainAddress.telephone}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Principal Activity Code</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companyIdentification.basicInformation.principalActivity.activityCode}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Principal Activity Description</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companyIdentification.basicInformation.principalActivity.activityDescription}</div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">Main Address</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td width="23%" class="formleft"><strong>Main Address</strong></td>
                            <td width="77%"
                                class="formright">${searchDetail.contactInformation.mainAddress.address.simpleValue}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">Other Address</div>
                <div class="panel-body">


                    <table width="100%"
                           class="table table-hover table-bordered table-responsive">
                        <thead>
                        <tr>
                            <th width="40%"><span class="formleft"><strong>Other Address</strong></span></th>
                            <th width="30%"><span class="formleft"><strong>Country</strong></span></th>
                            <th width="30%"><span class="formleft"><strong>Telephone</strong></span></th>

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

            <div class="panel panel-default">
                <div class="panel-heading">Activities</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td class="formleft"><strong>Activity Code</strong></td>
                            <td valign="top" class="formright">

                                <div align="left">Activity Description</div>
                            </td>
                        </tr>
                        <c:forEach var="activity"
                                   items="${searchDetail.companyIdentification.activities.activity}"
                                   varStatus="status">
                            <tr>
                                <td class="formleft"><strong>${activity.activityCode}</strong></td>
                                <td valign="top" class="formright">

                                    <div align="left">${activity.activityDescription}</div>
                                </td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>

<div class="container">
    <c:if test="${not empty searchDetail.companySummary.creditRating}">
        <%--进度条 颜色--%>
    <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'A'}">
    <div class="panel panel-success">
        </c:if>
        <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'B'}">
        <div class="panel panel-success">
            </c:if>
            <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'C'}">
            <div class="panel panel-warning">
                </c:if>
                <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'D'}">
                <div class="panel panel-warning">
                    </c:if>
                    <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'E'}">
                    <div class="panel panel-danger">
                        </c:if>
                        <c:if test="${empty searchDetail.companySummary.creditRating.commonValue.value()}">
                        <div class="panel panel-success">
                            </c:if>


                            <div class="panel-heading">
                                <h3 class="panel-title">CREDIT SCORE 信用评估 <span class="pull-right">                     <a
                                        href="javascript:void(0);" onclick="update()"
                                        class="btn btn-xs btn-default btn-update">更新</a>                 </span>
                                </h3>
                            </div>
                            <div class="panel-body">

                                <div class="panel panel-default">
                                    <div class="panel-heading">Credit Rating</div>
                                    <div class="panel-body">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tbody>
                                                <%--<tr>--%>
                                                <%--<td height="40px" align="center" valign="middle">--%>
                                                <%--<div align="center"--%>
                                                <%--class="label label-lg progress-bar-colora disabled">Very Low--%>
                                                <%--Risk--%>
                                                <%--低风险--%>
                                                <%--</div>--%>
                                                <%--</td>--%>
                                                <%--<td valign="middle" align="center">--%>
                                                <%--<div align="center"--%>
                                                <%--class="label label-lg progress-bar-colorb disabled"> Low Risk--%>
                                                <%--平均低风险--%>
                                                <%--</div>--%>
                                                <%--</td>--%>
                                                <%--<td valign="middle" align="center">--%>
                                                <%--<div align="center"--%>
                                                <%--class="label label-lg progress-bar-colorc disabled"> Moderate--%>
                                                <%--Risk--%>
                                                <%--平均风险--%>
                                                <%--</div>--%>
                                                <%--</td>--%>
                                                <%--<td valign="middle" align="center">--%>
                                                <%--<div align="center"--%>
                                                <%--class="label label-lg progress-bar-colord disabled"> High Risk--%>
                                                <%--平均高风险--%>
                                                <%--</div>--%>
                                                <%--</td>--%>
                                                <%--<td valign="middle" align="center">--%>
                                                <%--<div align="center"--%>
                                                <%--class="label label-lg progress-bar-colore disabled"> Very High--%>
                                                <%--Risk--%>
                                                <%--高风险--%>
                                                <%--</div>--%>
                                                <%--</td>--%>
                                                <%--</tr>--%>
                                                <%--<tr>--%>
                                                <%--<td colspan="5">--%>
                                                <%--<div class="progress">--%>
                                                <%--&lt;%&ndash;进度条 颜色&ndash;%&gt;--%>
                                                <%--<c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'A'}">--%>
                                                <%--<div class="progress-bar progress-bar-success"--%>
                                                <%--style="width: 10%"></div>--%>
                                                <%--</c:if>--%>
                                                <%--<c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'B'}">--%>
                                                <%--<div class="progress-bar progress-bar-success"--%>
                                                <%--style="width: 30%"></div>--%>
                                                <%--</c:if>--%>
                                                <%--<c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'C'}">--%>
                                                <%--<div class="progress-bar progress-bar-success"--%>
                                                <%--style="width: 50%"></div>--%>
                                                <%--</c:if>--%>
                                                <%--<c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'D'}">--%>
                                                <%--<div class="progress-bar progress-bar-success"--%>
                                                <%--style="width: 70%"></div>--%>
                                                <%--</c:if>--%>
                                                <%--<c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'E'}">--%>
                                                <%--<div class="progress-bar progress-bar-success"--%>
                                                <%--style="width: 90%"></div>--%>
                                                <%--</c:if>--%>

                                                <%--</div>--%>
                                                <%--</td>--%>
                                                <%--</tr>--%>
                                                <%--<tr>--%>
                                                <%--<td width="20%" valign="top">--%>
                                                <%--<div align="center"></div>--%>
                                                <%--</td>--%>
                                                <%--<td width="20%" valign="top" class="formright">--%>
                                                <%--<div align="center"></div>--%>
                                                <%--</td>--%>
                                                <%--<td width="20%" valign="top" class="formright">&nbsp;</td>--%>
                                                <%--<td width="20%" valign="top" class="formright">--%>
                                                <%--<div align="center"></div>--%>
                                                <%--</td>--%>
                                                <%--<td width="20%" valign="top" class="formright">--%>
                                                <%--<div align="center"></div>--%>
                                                <%--</td>--%>
                                                <%--</tr>--%>
                                            <tr>
                                                <c:if test="${not empty searchDetail.companySummary.creditRating.providerValue}">
                                                    <c:if test="${not empty searchDetail.companySummary.creditRating.providerValue.value}">
                                                        <img src="${pageContext.request.contextPath}/images/creditRatingEN/${searchDetail.companySummary.creditRating.providerValue.value}.jpg"/>
                                                    </c:if>
                                                    <c:if test="${empty searchDetail.companySummary.creditRating.providerValue.value}">
                                                        <img src="${pageContext.request.contextPath}/images/creditRating/0.jpg"/>
                                                    </c:if>
                                                </c:if>
                                            </tr>
                                            <tr>
                                                <td colspan="5" valign="top">


                                                    <div class="col-lg-4">
                                                        <div class="bs-component">
                                                            <div class="alert alert-dismissible progress-bar-colorb">
                                                                <div align="center"><span><strong>Rating</strong>:
                                            <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'A'}">
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
                                            </c:if>
                                            </span></div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="col-lg-4">
                                                        <div class="bs-component">
                                                            <div class="alert alert-dismissible progress-bar-colorb">

                                                                <div align="center">
                                                                    <strong>Score</strong>: ${searchDetail.companySummary.creditRating.commonValue.value()}
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="col-lg-4">
                                                        <div class="bs-component">
                                                            <div class="alert alert-dismissible progress-bar-colorb">

                                                                <div align="center"><strong>Recommended
                                                                    Credit</strong>: ${searchDetail.companySummary.creditRating.creditLimit.value}
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div class="panel panel-default">
                                    <div class="panel-heading">Final Opinion</div>
                                    <div class="panel-body">
                                        <p>${searchDetail.companySummary.creditRating.commonDescription}</p>
                                    </div>
                                </div>

                            </div>
                        </div>
                        </c:if>

                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">LEGAL FORM<span class="pull-right">                     <a
                                        href="javascript:void(0);" onclick="update()"
                                        class="btn btn-xs btn-default btn-update">更新</a>                 </span>
                                </h3>
                            </div>
                            <div class="panel-body">

                                <div class="panel panel-default">
                                    <div class="panel-heading">Company Registration</div>
                                    <div class="panel-body">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tbody>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Legal Name</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.companyIdentification.basicInformation.registeredCompanyName}</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" class="formleft"><strong>Legal Form</strong></td>
                                                <td valign="top" class="formright">
                                                    <div align="left"> ${searchDetail.companyIdentification.basicInformation.legalForm.value} </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" class="formleft"><strong>Legal Form (Global)</strong>
                                                </td>
                                                <td valign="top" class="formright">
                                                    <div align="left"> ${searchDetail.companyIdentification.basicInformation.legalForm.value} </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" class="formleft"><strong>Legal Form (Local)</strong>
                                                </td>
                                                <td valign="top" class="formright">
                                                    <div align="left"> ${searchDetail.companyIdentification.basicInformation.legalForm.value} </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" class="formleft"><strong>Company Type</strong></td>
                                                <td valign="top" class="formright">
                                                    <div align="left">${searchDetail.companyIdentification.basicInformation.typeofOwnership}</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" class="formleft"><strong>Registration ID</strong></td>
                                                <td valign="top" class="formright">
                                                    <div align="left">
                                                            ${searchDetail.companyIdentification.basicInformation.companyRegistrationNumber} </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" class="formleft"><strong>Incorporation Date</strong>
                                                </td>
                                                <td valign="top" class="formright">
                                                    <div align="left">
                                                        <c:if test="${not empty searchDetail.companyIdentification.basicInformation.dateofCompanyRegistration}">
                                                            ${searchDetail.companyIdentification.basicInformation.dateofCompanyRegistration}
                                                        </c:if>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" class="formleft"><strong>VAT Registration
                                                    Number</strong></td>
                                                <td valign="top" class="formright">
                                                    <div align="left">${searchDetail.companyIdentification.basicInformation.vatRegistrationNumber}</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="formleft"><strong>VAT Registration Date</strong></td>
                                                <td class="formright">
                                                    <div align="left">
                                                            ${searchDetail.companyIdentification.basicInformation.vatRegistrationDate}
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="formleft"><strong>Date of Company Registration</strong></td>
                                                <td class="formright">
                                                    <div align="left">
                                                            ${searchDetail.companyIdentification.basicInformation.dateofCompanyRegistration}
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="formleft"><strong>Date of Starting Operations</strong></td>
                                                <td class="formright">
                                                    <div align="left">

                                                            ${searchDetail.companyIdentification.basicInformation.dateofStartingOperations}
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" class="formleft"><strong>Registry</strong></td>
                                                <td valign="top" class="formright">
                                                    <div align="left">${searchDetail.companyIdentification.basicInformation.commercialCourt}</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="formleft"><strong>Status</strong></td>
                                                <td class="formright">
                                                    <div align="left">${searchDetail.companySummary.companyStatus.code} </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" class="formleft"><strong>Country </strong></td>
                                                <td valign="top" class="formright">
                                                    <div align="left">${searchDetail.companyIdentification.basicInformation.country}</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" class="formleft"><strong>Listed at the Stock
                                                    Exchange</strong></td>
                                                <td valign="top" class="formright">
                                                    <div align="left">
                                                            ${searchDetail.companyIdentification.basicInformation.legalForm.commonCode}
                                                    </div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>


                                <div class="panel panel-default">
                                    <div class="panel-heading">Share Capital Structure</div>
                                    <div class="panel-body">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tbody>
                                            <tr>
                                                <td class="formleft"><strong>Nominal Share Capital </strong></td>
                                                <td width="77%"
                                                    class="formright">${searchDetail.shareCapitalStructure.nominalShareCapital.value}</td>
                                            </tr>
                                            <tr>
                                                <td class="formleft"><strong>Issued Share capital</strong></td>
                                                <td
                                                        class="formright">${searchDetail.shareCapitalStructure.issuedShareCapital.value}</td>
                                            </tr>


                                            <table width="100%"
                                                   class="table table-hover table-bordered table-responsive">
                                                <thead>
                                                <tr>
                                                    <th width="40%"><span class="formleft"><strong>Name</strong></span>
                                                    </th>
                                                    <th width="15%"><span
                                                            class="formleft"><strong>Share Percent</strong></span></th>
                                                    <th width="40%"><span
                                                            class="formleft"><strong>Address</strong></span></th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                <c:forEach var="shareHolder"
                                                           items="${searchDetail.shareCapitalStructure.shareHolders.shareHolder}"
                                                           varStatus="status">
                                                    <tr>
                                                        <td>${shareHolder.name}</td>
                                                        <td>
                                                            <c:if test="${not empty shareHolder.sharePercent}">
                                                                ${shareHolder.sharePercent}%
                                                            </c:if>
                                                        </td>
                                                        <td>${shareHolder.address.simpleValue}</td>
                                                    </tr>
                                                </c:forEach>

                                                </tbody>
                                            </table>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>
                        </div>


                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">COMPANY STRUCTURE & RELATED COPANIES <span
                                        class="pull-right">                     <a
                                        href="javascript:void(0);" onclick="update()"
                                        class="btn btn-xs btn-default btn-update">更新</a>                 </span>
                                </h3>
                            </div>
                            <div class="panel-body">

                                <div class="panel panel-default">
                                    <div class="panel-heading">Ultimate Parent Companies – Holding Company</div>
                                    <div class="panel-body">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tbody>
                                            <c:if test="${not empty searchDetail.groupStructure.ultimateParent}">
                                                <tr>
                                                    <td width="23%" class="formleft">
                                                        <strong>${searchDetail.groupStructure.ultimateParent.name}</strong>
                                                    </td>
                                                    <td width="77%" class="formright">
                                                        <div align="left">
                                                            Country：${searchDetail.groupStructure.ultimateParent.country}
                                                            <br>
                                                            Registration
                                                            No.： ${searchDetail.groupStructure.ultimateParent.registrationNumber}
                                                            <br>
                                                            Type:${searchDetail.groupStructure.ultimateParent.type.value}
                                                            <br>
                                                            Status：${searchDetail.groupStructure.ultimateParent.status}
                                                            <br>
                                                            Address：${searchDetail.groupStructure.ultimateParent.address.simpleValue}
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div class="panel panel-default">
                                    <div class="panel-heading">Parent Companies – Immediate Company</div>
                                    <div class="panel-body">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tbody>
                                            <c:if test="${not empty searchDetail.groupStructure.immediateParent}">
                                                <tr>
                                                    <td width="23%" class="formleft">
                                                        <strong>${searchDetail.groupStructure.immediateParent.name} </strong>
                                                    </td>
                                                    <td width="77%" class="formright">
                                                        <div align="left">
                                                            Country：${searchDetail.groupStructure.immediateParent.country}
                                                            <br>
                                                            Registration
                                                            No.：${searchDetail.groupStructure.immediateParent.registrationNumber}
                                                            <br>
                                                            Type:${searchDetail.groupStructure.immediateParent.type.value}
                                                            <br>
                                                            Status：${searchDetail.groupStructure.immediateParent.status}
                                                            <br>
                                                            Address：${searchDetail.groupStructure.immediateParent.address.simpleValue}
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <c:if
                                        test="${not empty searchDetail.groupStructure.subsidiaryCompanies}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Subsidiary Companies</div>
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
                                </c:if>

                                <c:if
                                        test="${not empty searchDetail.groupStructure.affiliatedCompanies}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Affiliated Companies</div>
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
                                </c:if>


                            </div>
                        </div>


                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">MANAGEMENT <span class="pull-right">                     <a
                                        href="javascript:void(0);" onclick="update()"
                                        class="btn btn-xs btn-default btn-update">更新</a>                 </span>
                                </h3>
                            </div>
                            <div class="panel-body">


                                <div class="panel panel-default">
                                    <div class="panel-heading">Current Directors / Managers</div>
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


                                <div class="panel panel-default">
                                    <div class="panel-heading">Previous Directors / Managers</div>
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


                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">HISTORY <span class="pull-right">                     <a
                                        href="javascript:void(0);" onclick="update()"
                                        class="btn btn-xs btn-default btn-update">更新</a>                 </span>
                                </h3>
                            </div>
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

                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">LINE OF BUSINESS<span class="pull-right">                     <a
                                        href="javascript:void(0);" onclick="update()"
                                        class="btn btn-xs btn-default btn-update">更新</a> </span></h3>
                            </div>
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
                                                <%--<tr>--%>
                                                <%--<td width="23%" class="formleft"><strong>Business Overview</strong></td>--%>
                                                <%--<td--%>
                                                <%--class="formright">---%>
                                                <%--</td>--%>
                                                <%--</tr>--%>
                                                <%--<tr>--%>
                                                <%--<td class="formleft"><strong>Brands</strong></td>--%>
                                                <%--<td--%>
                                                <%--class="formright">---%>
                                                <%--</td>--%>
                                                <%--</tr>--%>
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
                                                <%--<tr>--%>
                                                <%--<td width="23%" class="formleft"><strong>Company export to</strong></td>--%>
                                                <%--<td--%>
                                                <%--class="formright">---%>
                                                <%--</td>--%>
                                                <%--</tr>--%>
                                                <%--<tr>--%>
                                                <%--<td width="23%" class="formleft"><strong>Competitors</strong></td>--%>
                                                <%--<td--%>
                                                <%--class="formright">&nbsp;</td>--%>
                                                <%--</tr>--%>
                                                <%--<tr>--%>
                                                <%--<td class="formleft"><strong>Person Interviewed</strong></td>--%>
                                                <%--<td--%>
                                                <%--class="formright">&nbsp;</td>--%>
                                                <%--</tr>--%>
                                                <%--<tr>--%>
                                                <%--<td width="23%" class="formleft"><strong>Position</strong></td>--%>
                                                <%--<td--%>
                                                <%--class="formright">&nbsp;</td>--%>
                                                <%--</tr>--%>
                                                <%--<tr>--%>
                                                <%--<td class="formleft"><strong>Comments</strong></td>--%>
                                                <%--<td--%>
                                                <%--class="formright">---%>
                                                <%--</td>--%>
                                                <%--</tr>--%>
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
                        </div>


                        <c:if test="${not empty searchDetail.financialStatements.financialStatement||not empty searchDetail.otherInformation.advisors}">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h3 class="panel-title">FINANCIAL <span class="pull-right">                     <a
                                            href="javascript:void(0);" onclick="update()"
                                            class="btn btn-xs btn-default btn-update">更新</a>                 </span>
                                    </h3>
                                </div>

                                <c:if test="${not empty searchDetail.financialStatements.financialStatement}">
                                    <div class="panel-body">
                                        <div class="panel panel-default">
                                            <div class="panel-heading"> Balance Sheet</div>
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
                                    </div>
                                </c:if>

                                <c:if test="${not empty searchDetail.financialStatements.financialStatement}">
                                    <div class="panel-body">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">Profit & Loss Account</div>
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
                                    </div>
                                </c:if>

                                <c:if test="${not empty searchDetail.financialStatements.financialStatement}">
                                    <div class="panel-body">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">Other Financials</div>
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
                                    </div>
                                </c:if>

                                <c:if test="${not empty searchDetail.financialStatements.financialStatement}">
                                    <div class="panel-body">
                                        <div class="panel panel-default">
                                            <div class="panel-heading"> Ratios</div>
                                            <div class="panel-body">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td width="25%"
                                                            style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                                                            <table class="table table-striped table-responsive"
                                                                   style="height: 100%">
                                                                <tbody>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Pre-Tax
                                                                        Profit Margin</strong>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Return
                                                                        on Capital
                                                                        Employed</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Return
                                                                        on Total Assets
                                                                        Employed</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Return
                                                                        on Net Assets
                                                                        Employed</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Sales/Net
                                                                        Working Capital</strong>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Stock
                                                                        Turnover Ratio</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Debtor
                                                                        Days</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Creditor
                                                                        Days</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Current
                                                                        Ratio</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Liquidity
                                                                        Ratio/Acid Test</strong>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Current
                                                                        Debt Ratio</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft">
                                                                        <strong>Gearing</strong>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Equity
                                                                        in Percentage</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Total
                                                                        Debt Ratio</strong></td>
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
                                                                            align="right">${ltdFinancialStatement.ratios.preTaxProfitMargin}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.returnOnCapitalEmployed}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.returnOnTotalAssetsEmployed}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.returnOnNetAssetsEmployed}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.salesOrNetWorkingCapital}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.stockTurnoverRatio}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.debtorDays}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.creditorDays}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.currentRatio}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.liquidityRatioOrAcidTest}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.currentDebtRatio}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.gearing}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.equityInPercentage}&nbsp;</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top"
                                                                            align="right">${ltdFinancialStatement.ratios.totalDebtRatio}&nbsp;</td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                        </c:forEach>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>

                                <c:if test="${not empty searchDetail.otherInformation.advisors}">
                                    <div class="panel-body">

                                        <div class="panel panel-default">
                                            <div class="panel-heading">Advisors</div>
                                            <div class="panel-body">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tbody>

                                                    <c:forEach var="advisor"
                                                               items="${searchDetail.otherInformation.advisors.advisor}"
                                                               varStatus="status">

                                                        <tr>
                                                            <td class="formleft"><strong>Auditor Name</strong></td>
                                                            <td class="formright"> ${advisor.auditorName}</td>
                                                        </tr>
                                                        <tr>
                                                            <td width="23%" class="formleft"><strong>Solicitor
                                                                Name</strong>
                                                            </td>
                                                            <td width="77%" class="formright">
                                                                <div align="left">
                                                                        ${advisor.solicitorName}
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>

                            </div>
                        </c:if>


                            <%--<jsp:include page="${basePath}../../creditsafe/additional/additional_US.jsp"/>--%>
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">NEGATIVE INFO <span class="pull-right">                     <a
                                        href="javascript:void(0);" onclick="update()"
                                        class="btn btn-xs btn-default btn-update">更新</a> </span>
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tbody>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Bankruptcy</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.negativeInformation.legalFilingSummary.bankruptcy }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Tax Lien Filings</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.negativeInformation.legalFilingSummary.taxLienFilings }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Judgment Filings</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.negativeInformation.legalFilingSummary.judgmentFilings }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Sum </strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.negativeInformation.legalFilingSummary.sum}</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>UCC Filings</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.negativeInformation.legalFilingSummary.uccFilings}</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Cautionary UCC
                                                    Filings </strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.negativeInformation.legalFilingSummary.cautionaryUCCFilings}</div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.uccDetails}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">UCC Details</div>
                                        <div class="panel-body">


                                            <table width="100%"
                                                   class="table table-hover table-bordered table-responsive">
                                                <thead>
                                                <tr>
                                                    <th width="14%"><span
                                                            class="formleft"><strong>Filed Date</strong></span></th>
                                                    <th width="14%"><span
                                                            class="formleft"><strong>Filing Number </strong></span></th>
                                                    <th width="14%"><span
                                                            class="formleft"><strong>Jurisdiction </strong></span></th>
                                                    <th width="17%"><span
                                                            class="formleft"><strong>Secured Party Name </strong></span>
                                                    </th>
                                                    <th width="18%"><span class="formleft"><strong>Collateral </strong></span>
                                                    </th>
                                                    <th width="22%"><span class="formleft"><strong>Secured Party Address City</strong></span>
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="uccDetail"
                                                           items="${searchDetail.additionalInformation.negativeInformation.uccDetails.uccDetail}"
                                                           varStatus="status">
                                                    <tr>
                                                        <td>${uccDetail.filedDate }</td>
                                                        <td>${uccDetail.filingNumber }</td>
                                                        <td>${uccDetail.jurisdiction  }</td>
                                                        <td>${uccDetail.securedPartyName }</td>
                                                        <td>${uccDetail.collateral  }</td>
                                                        <td>${uccDetail.securedPartyAddress.city }</td>
                                                    </tr>
                                                </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.taxLienDetails}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Tax Lien Details</div>
                                        <div class="panel-body">

                                            <table width="100%"
                                                   class="table table-hover table-bordered table-responsive">
                                                <thead>
                                                <tr>
                                                    <th width="14%"><span class="formleft"><strong>Filed Date </strong></span>
                                                    </th>
                                                    <th width="16%"><span class="formleft"><strong>Filing Type </strong></span>
                                                    </th>
                                                    <th width="18%"><span
                                                            class="formleft"><strong>Filed By </strong></span></th>
                                                    <th width="10%"><span
                                                            class="formleft"><strong>Status </strong></span></th>
                                                    <th width="12%"><span
                                                            class="formleft"><strong>Amount </strong></span></th>
                                                    <th width="12%"><span
                                                            class="formleft"><strong>Filing Number </strong></span></th>
                                                    <th width="17%"><span class="formleft"><strong>Jurisdiction</strong></span>
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="taxLienDetail"
                                                           items="${searchDetail.additionalInformation.negativeInformation.taxLienDetails.taxLienDetail}"
                                                           varStatus="status">
                                                    <tr>
                                                        <td>${taxLienDetail.filedDate }</td>
                                                        <td>${taxLienDetail.filingType }</td>
                                                        <td>${taxLienDetail.filedBy }</td>
                                                        <td>${taxLienDetail.status}</td>
                                                        <td>${taxLienDetail.amount  }</td>
                                                        <td>${taxLienDetail.filingNumber  }</td>
                                                        <td>${taxLienDetail.jurisdiction }</td>
                                                    </tr>
                                                </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.judgmentDetails}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Judgment Details</div>
                                        <div class="panel-body">

                                            <table width="100%"
                                                   class="table table-hover table-bordered table-responsive">
                                                <thead>
                                                <tr>
                                                    <th width="14%"><span class="formleft"><strong>Filed Date </strong></span>
                                                    </th>
                                                    <th width="16%"><span
                                                            class="formleft"><strong>Plaintiff </strong></span></th>
                                                    <th width="16%"><span
                                                            class="formleft"><strong>Status </strong></span></th>
                                                    <th width="12%"><span
                                                            class="formleft"><strong>Amount </strong></span></th>
                                                    <th width="12%"><span
                                                            class="formleft"><strong>Filing Number </strong></span></th>
                                                    <th width="30%"><span class="formleft"><strong>Jurisdiction</strong></span>
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="judgmentDetail"
                                                           items="${searchDetail.additionalInformation.negativeInformation.judgmentDetails.judgmentDetail}"
                                                           varStatus="status">
                                                    <tr>
                                                        <td>${judgmentDetail.filedDate }</td>
                                                        <td>${judgmentDetail.plaintiff }</td>
                                                        <td>${judgmentDetail.status}</td>
                                                        <td>${judgmentDetail.amount  }</td>
                                                        <td>${judgmentDetail.filingNumber  }</td>
                                                        <td>${judgmentDetail.jurisdiction }</td>
                                                    </tr>
                                                </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.bankruptcyDetails}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Bankruptcy Details</div>
                                        <div class="panel-body">
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                <tbody>
                                                <c:forEach var="bankruptcyDetail"
                                                           items="${searchDetail.additionalInformation.negativeInformation.bankruptcyDetails.bankruptcyDetail}"
                                                           varStatus="status">
                                                    <tr>
                                                        <td width="23%" class="formleft"><strong>Filed Date </strong>
                                                        </td>
                                                        <td width="77%" class="formright">
                                                            <div align="left">${bankruptcyDetail.filedDate }</div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td width="23%" class="formleft"><strong>Filing Type </strong>
                                                        </td>
                                                        <td width="77%" class="formright">
                                                            <div align="left">${bankruptcyDetail.filingType }</div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td width="23%" class="formleft"><strong>Status </strong></td>
                                                        <td width="77%" class="formright">
                                                            <div align="left">${bankruptcyDetail.status}</div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td width="23%" class="formleft"><strong>Case </strong></td>
                                                        <td width="77%" class="formright">
                                                            <div align="left">${bankruptcyDetail.caseZZ}</div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td width="23%" class="formleft"><strong>Court </strong></td>
                                                        <td width="77%" class="formright">
                                                            <div align="left">${bankruptcyDetail.court}</div>
                                                        </td>
                                                    </tr>

                                                </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:if></div>
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">MISCELLANEOUS<span class="pull-right">                     <a
                                        href="javascript:void(0);" onclick="update()"
                                        class="btn btn-xs btn-default btn-update">更新</a> </span>
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="panel panel-default">
                                    <div class="panel-heading">Other Info</div>
                                    <div class="panel-body">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tbody>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>First Reported Date</strong>
                                                </td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.misc.firstReportedDate }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Primary NAICS Code</strong>
                                                </td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.misc.primaryNAICSCode }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Primary NAICS Code
                                                    Description</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.misc.primaryNAICSCodeDescription }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Years In Business </strong>
                                                </td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.misc.yearsInBusiness}</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Address Type </strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.misc.addressType }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Location Type </strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.misc.locationType }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Sales Range </strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.misc.salesRange}</div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">PAYMENT <span class="pull-right">                     <a
                                        href="javascript:void(0);" onclick="update()"
                                        class="btn btn-xs btn-default btn-update">更新</a> </span>
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="panel panel-default">
                                    <div class="panel-heading">Payment Data</div>
                                    <div class="panel-body">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tbody>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Total Trades Number</strong>
                                                </td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradePaymentSummary.totalTradesNumber }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Continuous Trades
                                                    Number </strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradePaymentSummary.continuousTradesNumber  }</div>
                                                </td>
                                            </tr>


                                            <tr>
                                                <td width="23%" class="formleft"><strong>Continuous </strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradeLinesInformation.continuous.number  }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Combined</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradeLinesInformation.combined.number }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Total</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradeLinesInformation.total.number }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Number</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradeLinesInformation.continuous.number  }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Balance</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradeLinesInformation.continuous.balance }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Current</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradeLinesInformation.continuous.current }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Range 1 to 30</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradeLinesInformation.continuous.range1to30  }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Range 31 to 60</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradeLinesInformation.continuous.range31to60  }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Range 61 to 90</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradeLinesInformation.continuous.range61to90 }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Range 91 plus</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.paymentData.tradeLinesInformation.continuous.range91plus  }</div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>


                                <div class="panel panel-default">
                                    <div class="panel-heading">Primary Corporate Record</div>
                                    <div class="panel-body">


                                        <table width="100%" class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Business Legal Name</strong></span>
                                                </th>
                                                <th width="10%"><strong>SOS Charter No.</strong></th>
                                                <th width="10%"><span class="formleft"><strong>Status </strong></span>
                                                </th>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Incorporated State</strong></span></th>
                                                <th width="10%"><span class="formleft"><strong>Principal State</strong></span>
                                                </th>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Foreign or Domestic</strong></span>
                                                </th>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Profit or Non Profit</strong></span>
                                                </th>
                                                <th width="10%"><strong>Agent Name</strong></th>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Primary Address city</strong></span>
                                                </th>
                                                <th width="10%"><span
                                                        class="formleft"><strong>Agent Address city</strong></span></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>${searchDetail.additionalInformation.primaryCorporateRecord.businessLegalName }</td>
                                                <td>${searchDetail.additionalInformation.primaryCorporateRecord.sosCharterNumber}</td>
                                                <td>${searchDetail.additionalInformation.primaryCorporateRecord.status  }</td>
                                                <td>${searchDetail.additionalInformation.primaryCorporateRecord.incorporatedState }</td>
                                                <td>${searchDetail.additionalInformation.primaryCorporateRecord.principalState }</td>
                                                <td>${searchDetail.additionalInformation.primaryCorporateRecord.foreignOrDomestic  }</td>
                                                <td>${searchDetail.additionalInformation.primaryCorporateRecord.profitOrNonProfit }</td>
                                                <td>${searchDetail.additionalInformation.primaryCorporateRecord.agentName }</td>
                                                <c:if test="${not empty searchDetail.additionalInformation.primaryCorporateRecord.primaryAddress.simpleValue}">
                                                    <td>${searchDetail.additionalInformation.primaryCorporateRecord.primaryAddress.simpleValue}</td>
                                                </c:if>
                                                <c:if test="${empty searchDetail.additionalInformation.primaryCorporateRecord.primaryAddress.simpleValue}">
                                                    <td>
                                                            ${searchDetail.additionalInformation.primaryCorporateRecord.primaryAddress.houseNumber}
                                                            ${searchDetail.additionalInformation.primaryCorporateRecord.primaryAddress.street}
                                                            ${searchDetail.additionalInformation.primaryCorporateRecord.primaryAddress.province}
                                                            ${searchDetail.additionalInformation.primaryCorporateRecord.primaryAddress.city}
                                                    </td>
                                                </c:if>

                                                <c:if test="${not empty searchDetail.additionalInformation.primaryCorporateRecord.agentAddress.simpleValue}">
                                                    <td>${searchDetail.additionalInformation.primaryCorporateRecord.agentAddress.simpleValue  }</td>
                                                </c:if>
                                                <c:if test="${empty searchDetail.additionalInformation.primaryCorporateRecord.agentAddress.simpleValue}">
                                                    <td>
                                                            ${searchDetail.additionalInformation.primaryCorporateRecord.agentAddress.houseNumber}
                                                            ${searchDetail.additionalInformation.primaryCorporateRecord.agentAddress.street}
                                                            ${searchDetail.additionalInformation.primaryCorporateRecord.agentAddress.province}
                                                            ${searchDetail.additionalInformation.primaryCorporateRecord.agentAddress.city}
                                                    </td>
                                                </c:if>


                                            </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>


                                <c:if test="${not empty searchDetail.additionalInformation.otherCorporateRecords}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Other Corporate Records</div>
                                        <div class="panel-body">

                                            <table width="100%"
                                                   class="table table-hover table-bordered table-responsive">
                                                <thead>
                                                <tr>
                                                    <th width="10%"><span
                                                            class="formleft"><strong>Business Legal Name</strong></span>
                                                    </th>
                                                    <th width="10%"><strong>SOS Charter No.</strong></th>
                                                    <th width="10%"><span
                                                            class="formleft"><strong>Status </strong></span></th>
                                                    <th width="10%"><span
                                                            class="formleft"><strong>Incorporated State</strong></span>
                                                    </th>
                                                    <th width="10%"><span
                                                            class="formleft"><strong>Principal State</strong></span>
                                                    </th>
                                                    <th width="10%"><span
                                                            class="formleft"><strong>Foreign or Domestic</strong></span>
                                                    </th>
                                                    <th width="10%"><span
                                                            class="formleft"><strong>Profit or Non Profit</strong></span>
                                                    </th>
                                                    <th width="10%"><strong>Agent Name</strong></th>
                                                    <th width="10%"><span
                                                            class="formleft"><strong>Primary Address city</strong></span>
                                                    </th>
                                                    <th width="10%"><span
                                                            class="formleft"><strong>Agent Address city</strong></span>
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="otherCorporateRecord"
                                                           items="${searchDetail.additionalInformation.otherCorporateRecords.corporateRecord}"
                                                           varStatus="status">
                                                    <tr>
                                                        <td>${otherCorporateRecord.businessLegalName }</td>
                                                        <td>${otherCorporateRecord.sosCharterNumber  }</td>
                                                        <td>${otherCorporateRecord.status  }</td>
                                                        <td>${otherCorporateRecord.incorporatedState }</td>
                                                        <td> <%--<div align="left">${otherCorporateRecord.principalState }</div>--%>
                                                        </td>
                                                        <td>${otherCorporateRecord.foreignOrDomestic  }</td>
                                                        <td>${otherCorporateRecord.profitOrNonProfit }</td>
                                                        <td>${otherCorporateRecord.agentName }</td>

                                                        <td>${otherCorporateRecord.primaryAddress.city  }</td>
                                                        <td>${otherCorporateRecord.agentAddress.city  }</td>
                                                    </tr>
                                                </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>


                                <div class="panel panel-default">
                                    <div class="panel-heading">DBT</div>
                                    <div class="panel-body">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tbody>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Company DBT</strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.dbt.companyDBT }</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="23%" class="formleft"><strong>Industry DBT </strong></td>
                                                <td width="77%" class="formright">
                                                    <div align="left">${searchDetail.additionalInformation.dbt.industryDBT  }</div>
                                                </td>
                                            </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">FINANCIAL STATEMENT <span class="pull-right">                     <a
                                        href="javascript:void(0);" onclick="update()"
                                        class="btn btn-xs btn-default btn-update">更新</a> </span>
                                </h3>
                            </div>
                            <div class="panel-body">
                                <c:if test="${not empty searchDetail.additionalInformation.additionalFinancials}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Financial Statement</div>

                                        <div class="panel-body">

                                            <c:if test="${not empty searchDetail.additionalInformation.additionalFinancials.financialStatement}">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td width="25%"
                                                            style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                                                            <table class="table table-striped table-responsive"
                                                                   style="height: 100%">
                                                                <tbody>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Financial
                                                                        Year</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Accounts
                                                                        Type</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft">
                                                                        <strong>Ebit</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft">
                                                                        <strong>Ebitda</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Operating
                                                                        Margin</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Return On
                                                                        Equity Capital</strong>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>net Profit
                                                                        Margin</strong></td>
                                                                </tr>
                                                                <tr>
                                                                    <td valign="top" class="formleft"><strong>Debt To
                                                                        Capital</strong></td>
                                                                </tr>

                                                                </tbody>

                                                            </table>
                                                        </td>
                                                        <c:forEach var="financialStatement"
                                                                   items="${searchDetail.additionalInformation.additionalFinancials.financialStatement}"
                                                                   varStatus="status">
                                                            <td width="25%">
                                                                <table class="table table-striped table-responsive"
                                                                       style="height: 100%">
                                                                    <tr>
                                                                        <td valign="top" align="right">
                                                                                ${financialStatement.financialYear}&nbsp;
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top" align="right">
                                                                                ${financialStatement.accountsType}&nbsp;
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top" align="right">
                                                                                ${financialStatement.ebit}&nbsp;
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top" align="right">
                                                                                ${financialStatement.ebitda}&nbsp;
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top" align="right">
                                                                                ${financialStatement.operatingMargin}&nbsp;
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top" align="right">
                                                                                ${financialStatement.returnOnEquityCapital}&nbsp;
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top" align="right">
                                                                                ${financialStatement.netProfitMargin}&nbsp;
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td valign="top" align="right">
                                                                                ${financialStatement.debtToCapital}&nbsp;
                                                                        </td>
                                                                    </tr>

                                                                </table>
                                                            </td>
                                                        </c:forEach>
                                                    </tr>
                                                </table>
                                            </c:if>

                                        </div>

                                    </div>
                                </c:if>


                            </div>
                        </div>


                        <p>REPORT END</p>

                        <div class="col-lg-3">
                            <div class="bs-component">
                                <div class="alert alert-dismissible alert-success">

                                    <div align="center"><span><strong>实地认证目标公司</strong></span></div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3">
                            <div class="bs-component">
                                <div class="alert alert-dismissible alert-success">

                                    <div align="center"><strong>帐款催收目标公司</strong></div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3">
                            <div class="bs-component">
                                <div class="alert alert-dismissible alert-success">

                                    <div align="center"><strong>当地司法服务</strong></div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3">
                            <div class="bs-component">
                                <div class="alert alert-dismissible alert-success">

                                    <div align="center"><strong>其他商业服务</strong></div>
                                </div>
                            </div>
                        </div>

                    </div>
                    </c:if>


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