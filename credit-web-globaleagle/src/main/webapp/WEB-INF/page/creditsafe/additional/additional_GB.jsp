<%--
  Created by IntelliJ IDEA.
  User: Mike
  Date: 2016/10/13
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
                   aria-controls="collapseOne">
                    County Court Judgements(registered)exact </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%">Date</th>
                        <th width="15%">FilingNumber</th>
                        <th width="5%">Jurisdiction</th>
                        <th width="10%">SecuredPartyName</th>
                        <th width="10%">Collateral</th>
                        <th width="20%">SecuredPartyAddress City</th>
                        <th width="30%">IncomingRecord Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.registered}">
                        <c:forEach var="registered"
                                   items="${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.registered}"
                                   varStatus="status">
                            <tr>
                                <td>${registered.exact.countyCourtJudgement.date}</td>
                                <td>${registered.exact.countyCourtJudgement.court}</td>
                                <td>${registered.exact.countyCourtJudgement.amount}</td>
                                <td>${registered.exact.countyCourtJudgement.caseNumber}</td>
                                <td>${registered.exact.countyCourtJudgement.status}</td>
                                <td>${registered.exact.countyCourtJudgement.datePaid}</td>
                                <td>${registered.exact.countyCourtJudgement.incomingRecordDetails}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.registered}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional2"
                   aria-expanded="false" aria-controls="collapseFour">
                    County Court Judgements(registered)possible
                </a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>

                        <th width="10%">Date</th>
                        <th width="15%">FilingNumber</th>
                        <th width="5%">Jurisdiction</th>
                        <th width="10%">SecuredPartyName</th>
                        <th width="10%">Collateral</th>
                        <th width="20%">SecuredPartyAddress City</th>
                        <th width="30%">IncomingRecord Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.registered}">
                        <c:forEach var="registered"
                                   items="${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.registered}"
                                   varStatus="status">
                            <tr>
                                <td>${registered.possible.countyCourtJudgement.date}</td>
                                <td>${registered.possible.countyCourtJudgement.court}</td>
                                <td>${registered.possible.countyCourtJudgement.amount}</td>
                                <td>${registered.possible.countyCourtJudgement.caseNumber}</td>
                                <td>${registered.possible.countyCourtJudgement.status}</td>
                                <td>${registered.possible.countyCourtJudgement.datePaid}</td>
                                <td>${registered.possible.countyCourtJudgement.incomingRecordDetails}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.registered}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional3"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    County Court Judgements(registered)exact </a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%">Date</th>
                        <th width="15%">FilingNumber</th>
                        <th width="5%">Jurisdiction</th>
                        <th width="10%">SecuredPartyName</th>
                        <th width="10%">Collateral</th>
                        <th width="20%">SecuredPartyAddress City</th>
                        <th width="30%">IncomingRecord Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.unregistered}">
                        <c:forEach var="unregistered"
                                   items="${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.unregistered}"
                                   varStatus="status">
                            <tr>
                                <td>${unregistered.exact.countyCourtJudgement.date}</td>
                                <td>${unregistered.exact.countyCourtJudgement.court}</td>
                                <td>${unregistered.exact.countyCourtJudgement.amount}</td>
                                <td>${unregistered.exact.countyCourtJudgement.caseNumber}</td>
                                <td>${unregistered.exact.countyCourtJudgement.status}</td>
                                <td>${unregistered.exact.countyCourtJudgement.datePaid}</td>
                                <td>${unregistered.exact.countyCourtJudgement.incomingRecordDetails}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.unregistered}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional4"
                   aria-expanded="false" aria-controls="collapseFour">
                    County Court Judgements(registered)possible
                </a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%">Date</th>
                        <th width="15%">FilingNumber</th>
                        <th width="5%">Jurisdiction</th>
                        <th width="10%">SecuredPartyName</th>
                        <th width="10%">Collateral</th>
                        <th width="20%">SecuredPartyAddress City</th>
                        <th width="30%">IncomingRecord Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.unregistered}">
                        <c:forEach var="unregistered"
                                   items="${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.unregistered}"
                                   varStatus="status">
                            <tr>
                                <td>${unregistered.possible.countyCourtJudgement.date}</td>
                                <td>${unregistered.possible.countyCourtJudgement.court}</td>
                                <td>${unregistered.possible.countyCourtJudgement.amount}</td>
                                <td>${unregistered.possible.countyCourtJudgement.caseNumber}</td>
                                <td>${unregistered.possible.countyCourtJudgement.status}</td>
                                <td>${unregistered.possible.countyCourtJudgement.datePaid}</td>
                                <td>${unregistered.possible.countyCourtJudgement.incomingRecordDetails}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.unregistered}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional5"
                   aria-expanded="false" aria-controls="collapseTwo">
                    Bankruptcy (NonLtd)
                </a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingTwo">
            <div class="panel-body">
                <table width="100%"
                       class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="33%"><span class="formleft"><strong>Exact Name & Address</strong></span></th>
                        <th width="33%"><span class="formleft"><strong>Exact Address Match</strong></span></th>
                        <th width="33%"><span class="formleft"><strong>Exact Name Match</strong></span></th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${searchDetail.additionalInformation.negativeInformation.bankruptcyData.bankruptcy.hasBankruptcyExactNameAndAddressMatch}</td>
                            <td>${searchDetail.additionalInformation.negativeInformation.bankruptcyData.bankruptcy.hasBankruptcyExactAddressMatch}</td>
                            <td>${searchDetail.additionalInformation.negativeInformation.bankruptcyData.bankruptcy.hasBankruptcyExactNameMatch}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional6"
                   aria-expanded="false" aria-controls="collapseTwo">
                    Misc
                </a>
            </h4>
        </div>
        <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingTwo">
            <div class="panel-body">
                <table width="100%"
                       class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="33%"><span class="formleft"><strong>Negative Rating</strong></span></th>
                        <th width="33%"><span class="formleft"><strong>Fax Number (NonLtd)</strong></span></th>
                        <th width="33%"><span class="formleft"><strong>Premise Type (NonLtd)</strong></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${searchDetail.additionalInformation.misc.negativeRating}</td>
                        <td>${searchDetail.additionalInformation.misc.faxNumber}</td>
                        <td>${searchDetail.additionalInformation.misc.premiseType}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional7"
                   aria-expanded="false" aria-controls="collapseFour">
                    Status History（<c:if test="${empty searchDetail.additionalInformation.statusHistory.event}">0</c:if>${searchDetail.additionalInformation.statusHistory.event.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional7" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Date</th>
                        <th width="72%">Description</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.statusHistory.event}">
                        <c:forEach var="event"
                                   items="${searchDetail.additionalInformation.statusHistory.event}"
                                   varStatus="status">
                            <tr>
                                <td>${event.date}</td>
                                <td>${event.description}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.statusHistory.event}">
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
                   href="#addtional8"
                   aria-expanded="false" aria-controls="collapseFour">
                    Company History（${searchDetail.additionalInformation.companyHistory.event.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional8" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Date</th>
                        <th width="72%">Description</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.companyHistory.event}">
                        <c:forEach var="event"
                                   items="${searchDetail.additionalInformation.companyHistory.event}"
                                   varStatus="status">
                            <tr>
                                <td>${event.date}</td>
                                <td>${event.description}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.companyHistory.event}">
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
                   href="#addtional9"
                   aria-expanded="false" aria-controls="collapseTwo">
                    Mortgage Information
                </a>
            </h4>
        </div>
        <div id="addtional9" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingTwo">
            <div class="panel-body">
                <table width="100%"
                       class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%"><span class="formleft"><strong>Outstanding</strong></span></th>
                        <th width="72%"><span class="formleft"><strong>Satisfied</strong></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${searchDetail.additionalInformation.mortgageInformation.mortgageSummary.outstanding}</td>
                        <td>${searchDetail.additionalInformation.mortgageInformation.mortgageSummary.satisfied}</td>
                    </tr>
                    </tbody>
                </table>
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%"><strong>Mortgage Type</strong></th>
                        <th width="10%"><strong>Date Charge Created </strong></th>
                        <th width="10%"><strong>Date Charge Registered </strong></th>
                        <th width="10%"><strong>Date Charge Satisfied </strong></th>
                        <th width="10%"><strong>Status </strong></th>
                        <th width="12.5%"><strong>Persons Entitled</strong></th>
                        <th width="18.75%"><strong>Amount Secured</strong></th>
                        <th width="18.75%"><strong>Details</strong></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.groupStructure.affiliatedCompanies.affiliatedCompany}">
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
                    </c:if>
                    <c:if test="${empty searchDetail.groupStructure.affiliatedCompanies.affiliatedCompany}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional10"
                   aria-expanded="true"
                   aria-controls="collapse01">
                    AdditionalFinancials </a>
            </h4>
        </div>
        <div id="addtional10" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="heading01">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="25%"
                            style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                            <table class="table table-striped table-responsive" style="height: 100%">
                                <tbody>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Year End Date</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Export</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Cost of Sales</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Directors
                                        Emoluments</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Revaluation
                                        Reserve</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Gross Profit</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Short Term HP Finance
                                        Lease Liabilities</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Long Term HP Finance Lease
                                        Liabilities</strong></td>
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
                                                ${financialItems.export}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.costOfSales}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.directorsEmoluments}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.revaluationReserve}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.grossProfit}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.shortTermHPFinanceLeaseLiabilities}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.longTermHPFinanceLeaseLiabilities}&nbsp;
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional11"
                   aria-expanded="true"
                   aria-controls="collapse01">
                    Payment Data </a>
            </h4>
        </div>
        <div id="addtional11" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="heading01">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="40%" class="formleft"><strong>Total Number of Invoices Available</strong></td>
                        <td width="70%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.totalNoofInvoicesAvailable}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Total Number of Invoices Paid Before 30 Days
                            Due</strong></td>
                        <td width="70%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.totalNoofInvoicesAvailable}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Total Number of Invoices Paid After 30 Days
                            Due</strong></td>
                        <td width="70%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.totalNoofInvoicesPaidBefore30DaysDue}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Total number of Invoices currently outstanding where
                            the due date has not yetbeen reached</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.totalNoofInvoicesOwingBefore30DaysDue}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Total number of Invoices currently outstanding beyond
                            the due date</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.totalNoofInvoicesOwingAfter30DaysDue}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Dbt</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.dbt}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Industry Dbt</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.industryDbt}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Payment Trend</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.paymentTrend}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Average Monthly Balance</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.averageMonthlyBalance}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Balance </strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balance}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Balance P1</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balanceP1}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Balance P2</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balanceP2}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Balance P3</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balanceP3}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Balance P4</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balanceP4}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Balance Within Terms</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balanceWithinTerms}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Invoices Between 3 And 12 Monts Paid P1</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.paidP1}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Paid P2</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.paidP2}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Paid P3</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.paidP3}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Paid P4</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.paidP4}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Paid In Terms</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.paidInTerms}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Total Paid</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.totalPaid}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Invoices Last 3 Monts Paid P1</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidP1}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Paid P2</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidP2}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Paid P3</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidP3}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Paid P4</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidP4}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Paid In Terms</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidInTerms}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Total Paid </strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.totalPaid}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Recent High Balance</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.recentHighBalance}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Total Trade Lines</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.totalTradeLines}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Total Trade Lines Outstanding </strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.totalTradeLinesOutstanding}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Annual Dbt With Trend Month </strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.annualDbtWithTrend.entry.month}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Annual Dbt With Trend DBT Value</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.annualDbtWithTrend.entry.DBTValue}</div>
                        </td>
                    </tr>
                    <%--  <tr>
                         <td width="23%" class="formleft"><strong>Annual Dbt With Trend DBT Trend </strong></td>
                         <td width="60%" class="formright">
                             <div align="left">${searchDetail.additionalInformation.paymentData.totalNoofInvoicesAvailable}</div>
                         </td>
                     </tr> --%>
                    <tr>
                        <td width="40%" class="formleft"><strong>Last Six Months Balance Month</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.lastSixMonthsBalance.entry.month}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="40%" class="formleft"><strong>Last Six Months Balance </strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.lastSixMonthsBalance.entry.balance}</div>
                        </td>
                    </tr>

                    </tbody>
                </table>
            </div></div></div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional12"
                   aria-expanded="false" aria-controls="collapseTwo">
                    Commentary
                </a>
            </h4>
        </div>
        <div id="addtional12" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingTwo">
            <div class="panel-body">
                <table width="100%"
                       class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="50%"><span class="formleft"><strong>Positive or Negative</strong></span></th>
                        <th width="50%"><span class="formleft"><strong>Commentary Text</strong></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="commentary"
                        items="${searchDetail.additionalInformation.commentaries.commentary}"
                            varStatus="status">
                    <tr>
                        <td>${commentary.positiveOrNegative}</td>
                        <td>${commentary.commentaryText}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional13"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Extended Group Structure（<c:if test="${empty searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup}">0</c:if>${searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup.size()}） </a>
            </h4>
        </div>
        <div id="addtional13" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="14%"><span class="formleft"><strong>Id</strong></span></th>
                        <th width="14%"><span class="formleft"><strong>Country </strong></span></th>
                        <th width="14%"><span class="formleft"><strong>Safe number </strong></span></th>
                        <th width="17%"><span class="formleft"><strong>Company Name </strong></span></th>
                        <th width="18%"><span class="formleft"><strong>Registered Number </strong></span></th>
                        <th width="22%"><span class="formleft"><strong>Latest Accounts Date</strong></span></th>
                        <th width="22%"><span class="formleft"><strong>Level</strong></span></th>
                        <th width="22%"><span class="formleft"><strong>Status</strong></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup}">
                        <c:forEach var="companyInGroup"
                                   items="${searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup}"
                                   varStatus="status">
                            <tr>
                                <td>${companyInGroup.id}</td>
                                <td>${companyInGroup.country}</td>
                                <td>${companyInGroup.safeNumber}</td>
                                <td>${companyInGroup.companyName}</td>
                                <td>${companyInGroup.registeredNumber}</td>
                                <td>${companyInGroup.latestAnnualAccounts}</td>
                                <td>${companyInGroup.level}</td>
                                <td>${companyInGroup.status}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
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
    
</div>






