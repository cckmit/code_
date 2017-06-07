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
                   aria-controls="collapseOne">
                    Misc </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>FaxNumber</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.faxNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number of Employees</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.numberOfEmployees}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Signatures</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.signatures}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Sektor Kode</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.sektorKode}</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional2"
                   aria-expanded="true"
                   aria-controls="collapse01">
                    Additional Financials </a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="heading01">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="25%"
                            style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                            <table class="table table-striped table-responsive" style="height: 100%">
                                <tbody>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Financial Year</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Other Operating Income</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Exports</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Extraordinary Result</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Change in Working Progress</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Cost of Stocks</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Change in Stocks</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Tax On Ordinary Result</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Net Profit Before Minority</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Transfer and Allocations</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Capital Employed</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Auditor Renumeration</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>General Manager Salary</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Research and Development</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Concessions</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Long Term Pension Commitments</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Own Shares</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Minority Interests</strong></td>
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
                                                ${financialItems.otherOperatingIncome}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.exports}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.extraordinaryResults}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.changeInWorkingProgress}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.cashOfStocks}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.changeInStocks}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.taxOnOrdinaryResult}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.netProfitBeforeMinority}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.transferAndAllocations}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.capitalEmployed}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.auditorRenumeration}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.generalManagerSalary}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.researchAndDevelopment}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.concessions}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.longTermPensionCommitments}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.ownShares}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.minorityInterests}&nbsp;
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional3"
                   aria-expanded="false" aria-controls="collapseFour">
                    Events
                </a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
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
                   href="#addtional4"
                   aria-expanded="false" aria-controls="collapseFour">
                    Rating History
                </a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Date</th>
                        <th width="72%">Rating</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.companyHistory.event}">
                        <c:forEach var="event"
                                   items="${searchDetail.additionalInformation.companyHistory.event}"
                                   varStatus="status">
                            <tr>
                                <td>${event.date}</td>
                                <td>${event.rating}</td>
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
                   href="#addtional5"
                   aria-expanded="false" aria-controls="collapseFour">
                    Auditor Comments
                </a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Date of Accounts</th>
                        <th width="72%">Comments</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="auditorComment"
                               items="${searchDetail.additionalInformation.auditorComments.auditorComment}"
                               varStatus="status">
                            <tr>
                                <td>${auditorComment.dateofAccounts}</td>
                                <td>${auditorComment.comments}</td>
                            </tr>
                        </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.auditorComments.auditorComment}">
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
                   href="#addtional6"
                   aria-expanded="false" aria-controls="collapseFour">
                    Announcements
                </a>
            </h4>
        </div>
        <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Date</th>
                        <th width="72%">Name</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="auditorComment"
                               items="${searchDetail.additionalInformation.announcements.event}" varStatus="status">
                        <tr>
                            <td>${event.date}</td>
                            <td>${event.type}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.announcements.event}">
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional7"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Voluntary Pledge </a>
            </h4>
        </div>
        <div id="addtional7" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="50%" class="formleft"><strong>Date</strong></td>
                        <td width="50%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.voluntaryPledge.date}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Type</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.voluntaryPledge.type}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Source</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.voluntaryPledge.source}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>RefNr</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.voluntaryPledge.refNr}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Amount</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.voluntaryPledge.amount}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Name of Creditor</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.voluntaryPledge.nameOfCreditor}</div>
                        </td>
                    </tr>
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
                    Other Company Officials </a>
            </h4>
        </div>
        <div id="addtional8" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Name</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.otherCompanyOfficials.name}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Position</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.otherCompanyOfficials.position}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Address</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.otherCompanyOfficials.address.city}</div>
                        </td>
                    </tr>
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
                    Negative Events </a>
            </h4>
        </div>
        <div id="addtional9" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%">Date</th>
                        <th width="15%">Type</th>
                        <th width="5%">Source</th>
                        <th width="10%">Status</th>
                        <th width="10%">Reference Number</th>
                        <th width="10%">Amount</th>
                        <th width="10%">Settlement Date</th>
                        <th width="10%">Name of Creditor</th>
                        <th width="10%">Type of Payment Remark</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="paymentRemark"
                               items="${searchDetail.additionalInformation.negativeInformation.paymentRemarks.paymentRemark}"
                               varStatus="status">
                            <tr>
                                <td>${paymentRemark.date}</td>
                                <td>${paymentRemark.type}</td>
                                <td>${paymentRemark.source}</td>
                                <td>${paymentRemark.status}</td>
                                <td>${paymentRemark.refNr}</td>
                                <td>${paymentRemark.amount}</td>
                                <td>${paymentRemark.settlementDate}</td>
                                <td>${paymentRemark.nameofCreditor}</td>
                                <td>${paymentRemark.typeofPaymentRemark}</td>
                            </tr>
                        </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.paymentRemarks.paymentRemark}">
                        <tr>
                            <td>-</td>
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

    <div class="panel panel-default">
    <div class="panel-heading" role="tab" >
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#addtional10"
               aria-expanded="true"
               aria-controls="collapseOne">
                Extended Group Structure </a>
        </h4>
    </div>
    <div id="addtional10" class="panel-collapse collapse" role="tabpanel"
         aria-labelledby="headingOne">
        <div class="panel-body">
            <table class="table table-hover table-bordered table-responsive">
                <thead>
                <tr>
                    <th width="10%">Id</th>
                    <th width="15%">Country</th>
                    <th width="10%">Safe number</th>
                    <th width="15%">Company Name</th>
                    <th width="10%">Registered Number</th>
                    <th width="15%">Latest Accounts Date</th>
                    <th width="10%">Level</th>
                    <th width="15%">Status</th>
                </tr>
                </thead>
                <tbody>
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

