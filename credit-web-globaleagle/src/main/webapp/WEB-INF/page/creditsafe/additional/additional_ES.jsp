<%--
  Created by IntelliJ IDEA.
  User: Mike
  Date: 2016/10/20
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<div class="panel-group" role="tablist" aria-multiselectable="true">

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional1"
                   aria-expanded="true"
                   aria-controls="collapse01">
                    Defendant </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="heading01">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Period</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.defendant.period}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Bankruptcy Proceedings Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.defendant.bankruptcyProceedingsNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Bankruptcy Proceedings Value</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.defendant.bankruptcyProceedingsValue}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Legal Proceedings Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.defendant.legalProceedingsNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Legal Proceedings Value</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.defendant.legalProceedingsValue}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Claims Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.defendant.claimsNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Claims Value</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.defendant.defendant.claimsValue}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Total Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.defendant.totalNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Total Value</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.defendant.totalValue}</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div></div></div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional2"
                   aria-expanded="true"
                   aria-controls="collapse01">
                    Affected As Plaintiff </a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="heading01">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Period</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.affectedAsPlaintiff.period}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Bankruptcy Proceedings Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.affectedAsPlaintiff.bankruptcyProceedingsNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Bankruptcy Proceedings Value</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.affectedAsPlaintiff.bankruptcyProceedingsValue}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Legal Proceedings Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.affectedAsPlaintiff.legalProceedingsNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Legal Proceedings Value</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.affectedAsPlaintiff.legalProceedingsValue}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Claims Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.affectedAsPlaintiff.claimsNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Claims Value</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.affectedAsPlaintiff.claimsValue}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Total Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.affectedAsPlaintiff.totalNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Total Value</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.incidents.affectedAsPlaintiff.totalValue}</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div></div></div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional3"
                   aria-expanded="false" aria-controls="collapseFour">
                    Insolvency/Bankruptcy（<c:if test="${empty searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event}">0</c:if>${searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Status Date</th>
                        <th width="72%">Status Description</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event}">
                        <c:forEach var="event"
                                   items="${searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event}"
                                   varStatus="status">
                            <tr>
                                <td>${event.statusDate}</td>
                                <td>${event.statusDescription}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional4"
                   aria-expanded="false" aria-controls="collapseTwo">
                    Misc
                </a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingTwo">
            <div class="panel-body">
                <table width="100%"
                       class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="25%"><span class="formleft"><strong>Company Size</strong></span></th>
                        <th width="25%"><span class="formleft"><strong>Fax Number</strong></span></th>
                        <th width="25%"><span class="formleft"><strong>Trade Name</strong></span></th>
                        <th width="25%"><span class="formleft"><strong>Status Confirmed</strong></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${searchDetail.additionalInformation.misc.companySize}</td>
                        <td>${searchDetail.additionalInformation.misc.faxNumber}</td>
                        <td>${searchDetail.additionalInformation.misc.tradeName}</td>
                        <td>${searchDetail.additionalInformation.misc.statusConfirmed}</td>

                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional5"
                   aria-expanded="true"
                   aria-controls="collapse01">
                    Additional Financials </a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="heading01">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="25%"
                            style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                            <table class="table table-striped table-responsive" style="height: 100%">
                                <tbody>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Year End Date</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Cash Coefficient</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Economic Return Percantage</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Financial Return Percantage</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>EBITDA Or Sales Percantage</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Working Capital Rotation</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Assets Rotation</strong></td>
                                </tr>
                                </tbody>

                            </table>
                        </td>
                        <c:forEach var="financialItems"
                                   items="${searchDetail.additionalInformation.additionalFinancials.financialItems}"
                                   varStatus="status">
                            <td width="25%">
                                <table class="table table-striped table-responsive"
                                       style="height: 100%">
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.yearEndDate}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.cashCoefficient}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.economicReturnPercantage}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.financialReturnPercantage}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.ebitdaOrSalesPercantage}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.workingCapitalRotation}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.assetsRotation}&nbsp;
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </c:forEach>
                    </tr>
                </table>
            </div></div></div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional6"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Gazette Filling Of Accounts（<c:if test="${empty searchDetail.additionalInformation.gazetteFillingOfAccounts.gazetteFillingOfAccount}">0</c:if>${searchDetail.additionalInformation.gazetteFillingOfAccounts.gazetteFillingOfAccount.size()}）</a>
            </h4>
        </div>
        <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="25%">Date Published</th>
                        <th width="25%">Type </th>
                        <th width="25%">Financial Year </th>
                        <th width="25%">Date Filed </th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.gazetteFillingOfAccounts.gazetteFillingOfAccount}">
                        <c:forEach var="gazetteFillingOfAccount"
                                   items="${searchDetail.additionalInformation.gazetteFillingOfAccounts.gazetteFillingOfAccount}"
                                   varStatus="status">
                            <tr>
                                <td>${gazetteFillingOfAccount.datePublished}</td>
                                <td>${gazetteFillingOfAccount.type}</td>
                                <td>${gazetteFillingOfAccount.financialYear}</td>
                                <td>${gazetteFillingOfAccount.dateFiled}</td>

                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.gazetteFillingOfAccounts.gazetteFillingOfAccount}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>

                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional7"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Gazette Registered Deeds（<c:if test="${empty searchDetail.additionalInformation.gazetteRegisteredDeeds.gazetteRegisteredDeed}">0</c:if>${searchDetail.additionalInformation.gazetteRegisteredDeeds.gazetteRegisteredDeed.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional7" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="33%">DatePublished </th>
                        <th width="33%">Description </th>
                        <th width="33%">NumberOfDeeds </th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.gazetteRegisteredDeeds.gazetteRegisteredDeed}">
                        <c:forEach var="gazetteRegisteredDeed"
                                   items="${searchDetail.additionalInformation.gazetteRegisteredDeeds.gazetteRegisteredDeed}"
                                   varStatus="status">
                            <tr>
                                <td>${gazetteRegisteredDeed.datePublished}</td>
                                <td>${gazetteRegisteredDeed.descriptions.description}</td>
                                <td>${gazetteRegisteredDeed.numberOfDeeds}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.gazetteRegisteredDeeds.gazetteRegisteredDeed}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional8"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Main Suppliers (Sole traders)</a>
            </h4>
        </div>
        <div id="addtional8" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Company Name </th>
                        <th width="72%">Province </th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.mainSuppliers.mainSupplier}">
                        <c:forEach var="mainSupplier"
                                   items="${searchDetail.additionalInformation.mainSuppliers.mainSupplier}"
                                   varStatus="status">
                            <tr>
                                <td>${mainSupplier.companyName}</td>
                                <td>${mainSupplier.province}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.gazetteRegisteredDeeds.gazetteRegisteredDeed}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional9"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Import And Export (Sole traders)</a>
            </h4>
        </div>
        <div id="addtional9" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Year </th>
                        <th width="33%">Exports </th>
                        <th width="39%">Imports </th>

                    </tr>
                    </thead>
                    <tbody>
                            <tr>
                                <td>${searchDetail.additionalInformation.importAndExport.year}</td>
                                <td>${searchDetail.additionalInformation.importAndExport.exports}</td>
                                <td> ${searchDetail.additionalInformation.importAndExport.imports}</td>
                            </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional10"
                   aria-expanded="true"
                   aria-controls="collapse01">
                    Facility Details (Sole traders) </a>
            </h4>
        </div>
        <div id="addtional10" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="heading01">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Description</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.description}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Situation</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.situation}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Street</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.address.street}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>House Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.address.houseNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>City</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.address.city}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Postal Code</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.address.postalCode}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Province</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.address.province}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Activity Incidents</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.activityIncidents}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Level of Activity</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.levelofActivity}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Level of Competition</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.levelofCompetition}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Known in the Area </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.knownintheArea}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Stock Level</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.facilityDetails.stockLevel}</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div></div></div>


</div>






