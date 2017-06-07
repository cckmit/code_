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
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional1"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Negative Information </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%"><span class="formleft"><strong>Effective Date</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Type of Judgement</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Type of Judgement - code</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Court</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Details</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Liquidators</strong></span></th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="Judgement"
                               items="${searchDetail.additionalInformation.negativeInformation.judgements.judgement}"
                               varStatus="status">
                        <tr>
                            <td>${Judgement.effectiveDate}</td>
                            <td${Judgement.typeofJudgement}></td>
                            <td>${Judgement.typeofJudgement.code}</td>
                            <td>${Judgement.court}</td>
                            <td>${Judgement.details}</td>
                            <td>${Judgement.liquidators.liquidator}</td>

                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.judgements.judgement}">
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
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Monitoring Status</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.preferentialRights.monitoringStatus}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Date Monitored</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.preferentialRights.dateMonitored}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number of Active Preferential Rights</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.preferentialRights.noOfActivePreferentialRights}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Total Active Amount</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.preferentialRights.totalActiveAmount}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Total Active Amount Due </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.preferentialRights.totalActiveAmountDue}</div>
                        </td>
                    </tr>


                    <table width="100%" class="table table-hover table-bordered table-responsive">
                        <thead>
                        <tr>
                            <%--to do--%>
                            <%--<th width="8%"><span class="formleft"><strong>Preferential Status</strong></span></th>--%>
                            <%--<th width="8%"><span class="formleft"><strong>Type of Preferential Right</strong></span></th>--%>
                            <th width="8%"><span class="formleft"><strong>Effective Date </strong></span></th>
                            <%--<th width="8%"><span class="formleft"><strong>Preferential Type Code</strong></span></th>--%>
                            <%--<th width="10%"><span class="formleft"><strong>Preferential Type Text</strong></span></th>--%>
                            <th width="10%"><span class="formleft"><strong>Registration Number</strong></span></th>
                            <th width="10%"><span class="formleft"><strong>Registration Date</strong></span></th>
                            <th width="8%"><span class="formleft"><strong>Expiry Date</strong></span></th>
                            <th width="8%"><span class="formleft"><strong>Creditors</strong></span></th>
                            <th width="8%"><span class="formleft"><strong>Amount</strong></span></th>
                            <th width="8%"><span class="formleft"><strong>Amount Covered</strong></span></th>
                            <th width="8%"><span class="formleft"><strong>Court</strong></span></th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="preferentialRight"
                                   items="${searchDetail.additionalInformation.negativeInformation.preferentialRights.preferentialRight}"
                                   varStatus="status">
                            <tr>
                                    <%--<td>${preferentialRight.preferentialStatus}</td>--%>
                                    <%--<td>${preferentialRight.typeOfPreferentialRight}</td>--%>
                                <td>${preferentialRight.effectiveDate}</td>
                                    <%--<td>${preferentialRight.preferentialTypeCode}</td>--%>
                                    <%--<td>${preferentialRight.preferentialTypeText}</td>--%>
                                <td>${preferentialRight.registrationNumber}</td>
                                <td>${preferentialRight.registrationDate}</td>
                                <td>${preferentialRight.expiryDate}</td>
                                <td>${preferentialRight.creditor}</td>
                                <td>${preferentialRight.amount}</td>
                                <td>${preferentialRight.amountCovered}</td>
                                <td>${preferentialRight.court}</td>

                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>


                    </tbody>
                </table>

            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional2"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Misc </a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">

                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Fax Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.faxNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Size of Urban Area</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.sizeOfUrbanArea}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Reason for Formation</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.reasonForFormation}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Reason for Closure</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.reasonForClosure}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Closure Date </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.closureDate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Reactivation Date</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.reactivationDate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Financial Accounts Type </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.financialAccountsType}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Status Code</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.statusCode}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Office Type</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.officeType}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number of Branches </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.numberOfBranches}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Acronym</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.acronym}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number Of Employees At Address</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.numberOfEmployeesAtAddress}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>PreviousSiret</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.previousSiret}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number of Employees At Company</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.numberOfEmployeesAtCompany}</div>
                        </td>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional3"
                   aria-expanded="false" aria-controls="collapseFour">
                    Status History（<c:if test="${empty searchDetail.additionalInformation.statusHistory.event}">0</c:if>${searchDetail.additionalInformation.statusHistory.event.size()}
                    ）
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
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional4"
                   aria-expanded="false" aria-controls="collapseFour">
                    Company History（${searchDetail.additionalInformation.companyHistory.event.size()}）
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
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional5"
                   aria-expanded="false" aria-controls="collapseFour">
                    Establishment History（${searchDetail.additionalInformation.establishmentHistory.event.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
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
                    <c:if test="${not empty searchDetail.additionalInformation.establishmentHistory.event}">
                        <c:forEach var="event"
                                   items="${searchDetail.additionalInformation.establishmentHistory.event}"
                                   varStatus="status">
                            <tr>
                                <td>${event.date}</td>
                                <td>${event.description}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${ empty searchDetail.additionalInformation.establishmentHistory.event}">
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
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional6"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Extended Group Structure（
                    <c:if test="${empty searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup}">0</c:if>
                    ${searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup.size()}） </a>
            </h4>
        </div>
        <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
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

    <div class="panel panel-default">
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional7"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Other CorporateRecords（
                    <c:if test="${empty searchDetail.additionalInformation.otherCorporateRecords.corporateRecord}">0</c:if>
                    ${searchDetail.additionalInformation.otherCorporateRecords.corporateRecord.size()}） </a>
            </h4>
        </div>
        <div id="addtional7" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="8%"><span class="formleft"><strong>Date</strong></span></th>
                        <th width="13%"><span class="formleft"><strong>Local Rating</strong></span></th>
                        <th width="19%"><span class="formleft"><strong>Common Rating Value</strong></span></th>
                        <th width="24%"><span class="formleft"><strong>Common Rating Description</strong></span></th>
                        <th width="12%"><span class="formleft"><strong>Description 1</strong></span></th>
                        <th width="12%"><span class="formleft"><strong>Description 2</strong></span></th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="otherCorporateRecord"
                               items="${searchDetail.additionalInformation.otherCorporateRecords.corporateRecord}"
                               varStatus="status">
                        <tr>
                            <td>${otherCorporateRecord.date}</td>
                            <td>${otherCorporateRecord.localRating}</td>
                            <td>${otherCorporateRecord.commonRating.commonValue}</td>
                            <td>${otherCorporateRecord.commonRating.commonDescription}</td>
                            <td>${otherCorporateRecord.description1}</td>
                            <td>${otherCorporateRecord.description2}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.otherCorporateRecords.corporateRecord}">
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
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional8"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Payment Data
                </a>
            </h4>
        </div>
        <div id="addtional8" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Dbt</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.dbt}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Industry Dbt</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.industryDbt}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Payment Trend</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.paymentTrend}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Average Monthly Balance</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.averageMonthlyBalance}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Balance</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balance}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Balance P1</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balanceP1}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Balance P2</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balanceP2}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Balance P3</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balanceP3}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Balance P4 </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balanceP4}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Balance Within Terms</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.balanceWithinTerms}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Invoices Between 3 And 12 Monts Paid P1</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.paidP1}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Paid P2</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.paidP2}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Paid P3</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.paidP3}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Paid P4</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.paidP4}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Paid In Terms </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.paidInTerms}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Total Paid</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesBetween3And12Monts.totalPaid}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Invoices Last 3 Monts Paid P1 </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidP1}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Invoices Last 3 Monts Paid P1 </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidP1}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Paid P2 </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidP2}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Paid P3</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidP3}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Paid P4</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidP4}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Paid In Terms</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.paidInTerms}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Total Paid </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.invoicesLast3Monts.totalPaid}</div>
                        </td>
                    </tr>

                    </tbody>
                </table>

                <table width="100%" class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="33%"><span class="formleft"><strong>Annual Dbt With Trend Month</strong></span>
                        </th>
                        <th width="33%"><span
                                class="formleft"><strong>Annual Dbt With Trend DBT Value</strong></span></th>
                        <th width="33%"><span
                                class="formleft"><strong>Annual Dbt With Trend DBT Trend</strong></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="entry"
                               items="${searchDetail.additionalInformation.paymentData.annualDbtWithTrend.entry}"
                               varStatus="status">
                        <tr>
                            <td>${entry.month}</td>
                            <td>${entry.dbtValue}</td>
                            <td>${entry.dbtTrend}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <table width="100%" class="table table-hover table-bordered table-responsive">
                    <tbody>
                    <tr>
                        <td width="50%" class="formleft"><strong>Last Six Months Balance Month</strong></td>
                        <td width="50%" class="formright"><strong>Last Six Months Balance</strong></td>

                    </tr>
                    <c:forEach var="entry"
                               items="${searchDetail.additionalInformation.paymentData.lastSixMonthsBalance.entry}"
                               varStatus="status">
                        <tr>

                            <td >
                                <div>${entry.month}</div>
                            </td>
                            <td>
                                <div>${entry.balance}</div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</div>
