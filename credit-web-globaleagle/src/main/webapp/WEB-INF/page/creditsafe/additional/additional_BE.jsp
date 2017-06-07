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
                    NSSO Details（<c:if test="${empty searchDetail.additionalInformation.negativeInformation.nssoDetails.nssoDetail}">0</c:if>
${searchDetail.additionalInformation.negativeInformation.nssoDetails.nssoDetail.size()}
                    ） </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="20%">Business Number</th>
                        <th width="20%">Name of Defendant</th>
                        <th width="20%">Legal Form of Defendant</th>
                        <th width="20%">Date of Summons</th>
                        <th width="20%">Labour Court</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="nssoDetail"
                               items="${searchDetail.additionalInformation.negativeInformation.nssoDetails.nssoDetail}"
                               varStatus="status">
                        <tr>
                            <td>${nssoDetail.businessNumber}</td>
                            <td>${nssoDetail.nameOfDefendant}</td>
                            <td>${nssoDetail.legalFormOfDefendant}</td>
                            <td>${nssoDetail.dateOfSummons}</td>
                            <td>${nssoDetail.labourCourt}</td>

                        </tr>
                    </c:forEach>
                    <c:if test="${empty searchDetail.additionalInformation.negativeInformation.nssoDetails.nssoDetail}">
                        <tr>
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional2"
                   aria-expanded="false" aria-controls="collapseFour">
                    Protested Bills（
                    <c:if test="${empty searchDetail.additionalInformation.negativeInformation.protestedBills.protestedBill}">0</c:if>
                    ${searchDetail.additionalInformation.negativeInformation.protestedBills.protestedBill.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>

                        <th width="10%">Drawee Name</th>
                        <th width="10%">Drawee Address</th>
                        <th width="10%">Bill Amount</th>
                        <th width="10%">Bill Currency</th>
                        <th width="10%">Maturity of Bill (in Months)</th>
                        <th width="10%">Payment Date</th>
                        <th width="10%">Name of Drawer</th>
                        <th width="10%">City of Drawer</th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="protestedBill"
                               items="${searchDetail.additionalInformation.negativeInformation.protestedBills.protestedBill}"
                               varStatus="status">
                        <tr>
                            <td>${protestedBill.draweeName}</td>
                            <td>${protestedBill.draweeAddress}</td>
                            <td>${protestedBill.billAmount}</td>
                            <td>${protestedBill.billCurrency}</td>
                            <td>${protestedBill.maturityOfBillInMonths}</td>
                            <td>${protestedBill.paymentDate}</td>
                            <td>${protestedBill.nameOfDrawer}</td>
                            <td>${protestedBill.cityOfDrawer}</td>

                        </tr>
                    </c:forEach>
                    <c:if test="${empty searchDetail.additionalInformation.negativeInformation.protestedBills.protestedBill}">
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional03"
                   aria-expanded="true"
                   aria-controls="collapse01">
                    Legal Events（
                    <c:if test="${empty searchDetail.additionalInformation.negativeInformation.companyLegalEvents.companyLegalEvent}">0</c:if>
                ${searchDetail.additionalInformation.negativeInformation.companyLegalEvents.companyLegalEvent.size()}）</a>
            </h4>
        </div>
        <div id="addtional03" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="heading01">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="11%">Legal Event Type</th>
                        <th width="11%">Level Event Sub Type</th>
                        <th width="11%">Event Date</th>
                        <th width="11%">Secondary Event Date</th>
                        <th width="11%">Court Type</th>
                        <th width="11%">Court Name</th>
                        <th width="11%">3rd Party Name</th>
                        <th width="11%">3rD Party Address</th>
                        <th width="11%">3rd Party Type</th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="companyLegalEvent"
                               items="${searchDetail.additionalInformation.negativeInformation.companyLegalEvents.companyLegalEvent}"
                               varStatus="status">
                        <tr>
                            <td>${companyLegalEvent.legalEventType}</td>
                            <td>${companyLegalEvent.legalEventSubType}</td>
                            <td>${companyLegalEvent.eventDate}</td>
                            <td>${companyLegalEvent.secondaryEventDate}</td>
                            <td>${companyLegalEvent.courtType}</td>
                            <td>${companyLegalEvent.courtName}</td>
                            <td>${companyLegalEvent.thirdPartyName}</td>
                            <td>${companyLegalEvent.thirdPartyAddress}</td>
                            <td>${companyLegalEvent.thirdPartyType}</td>

                        </tr>
                    </c:forEach>
                    <c:if test="${empty searchDetail.additionalInformation.negativeInformation.companyLegalEvents.companyLegalEvent}">
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
        <div class="panel-heading" role="tab">
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
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional5"
                   aria-expanded="false" aria-controls="collapseFour">
                    Payment Expectations Summary
                </a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Payment Expectation Days</th>
                        <th width="72%">Day Sales Outstanding</th>

                    </tr>
                    </thead>
                    <tbody>

                    <tr>
                        <td>${searchDetail.additionalInformation.paymentExpectationsSummary.paymentExpectationDays}</td>
                        <td>${searchDetail.additionalInformation.paymentExpectationsSummary.daySalesOutstanding}</td>
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
                   href="#addtional6"
                   aria-expanded="false" aria-controls="collapseTwo">
                    Industry Quartile Analysis
                </a>
            </h4>
        </div>
        <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingTwo">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Payment Expectations Lower</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryQuartileAnalysis.paymentExpectationDays.paymentExpectationsLower}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Payment Expectations Median</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryQuartileAnalysis.paymentExpectationDays.paymentExpectationsMedian}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Payment Expectations Upper</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryQuartileAnalysis.paymentExpectationDays.paymentExpectationsUpper}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Day Sales Outstanding - Lower</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryQuartileAnalysis.daySalesOutstanding.daySalesOutstandingLower}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Day Sales Outstanding - Median</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryQuartileAnalysis.daySalesOutstanding.daySalesOutstandingMedian}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Day Sales Outstanding - Upper</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryQuartileAnalysis.daySalesOutstanding.daySalesOutstandingUpper}</div>
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
                   href="#addtional7"
                   aria-expanded="false" aria-controls="collapseTwo">
                    Industry Quartile Analysis
                </a>
            </h4>
        </div>
        <div id="addtional7" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingTwo">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Activity Code</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryComparison.activityCode}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Activity Description</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryComparison.activityDescription}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Industry Average Day Sales Outstanding</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryComparison.industryAverageDaySalesOutstanding}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Industry Average Payment ExpectationDays</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryComparison.industryAveragePaymentExpectationDays}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Industry Average Credit Rating</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryComparison.industryAverageCreditRating}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Industry Average Credit Limit</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryComparison.industryAverageCreditLimit}</div>
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
                   href="#addtional8"
                   aria-expanded="false" aria-controls="collapseFour">
                    Contractor Details（
                    <c:if test="${empty searchDetail.additionalInformation.registeredContractors.registeredContractor}">0</c:if>
                ${searchDetail.additionalInformation.registeredContractors.registeredContractor.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional8" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="33%">Registration Number</th>
                        <th width="33%">Contractor Description</th>
                        <th width="33%">Striking Off Date</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="registeredContractor"
                               items="${searchDetail.additionalInformation.registeredContractors.registeredContractor}"
                               varStatus="status">
                        <tr>
                            <td>${registeredContractor.registrationNumber}</td>
                            <td>${registeredContractor.contractorDescription}</td>
                            <td>${registeredContractor.strikingOffDate}</td>

                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.registeredContractors.registeredContractor}">
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
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional9"
                   aria-expanded="false" aria-controls="collapseFour">
                    Joint Industrial Committee
                </a>
            </h4>
        </div>
        <div id="addtional9" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Jic Code</th>
                        <th width="72%">Description</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${searchDetail.additionalInformation.jointIndustrialCommittee.entry.jicCode}</td>
                        <td>${searchDetail.additionalInformation.jointIndustrialCommittee.entry.description}</td>

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
                   href="#addtional10"
                   aria-expanded="false" aria-controls="collapseFour">
                    Significant Events（
                    <c:if test="${empty additionalInformation.companySignificantEvents.companySignificantEvent}">0</c:if>
                ${additionalInformation.companySignificantEvents.companySignificantEvent.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional10" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="33%">Event Date</th>
                        <th width="33%">Event Description</th>
                        <th width="33%">Event Details</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="companySignificantEvent"
                               items="${additionalInformation.companySignificantEvents.companySignificantEvent}"
                               varStatus="status">
                        <tr>
                            <td>${companySignificantEvent.eventDate}</td>
                            <td>${companySignificantEvent.eventDescription}</td>
                            <td>${companySignificantEvent.eventDetails}</td>

                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.registeredContractors.registeredContractor}">
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
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional11"
                   aria-expanded="false" aria-controls="collapseTwo">
                    Payment Data
                </a>
            </h4>
        </div>
        <div id="addtional11" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingTwo">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>PaymentsOnFile</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.paymentsOnFile}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>PaymentsOnTime</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.paymentsOnTime }</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>PaymentsPaidLate</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.paymentsPaidLate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>TotalInvoiceValues</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.totalInvoiceValues}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>AverageInvoiceValues</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.averageInvoiceValues}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>PaymentsStillOwing</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.paymentsStillOwing}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>TotalBalanceStillOwing </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.totalBalanceStillOwing}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>HighestInvoiceValueOutstanding</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.highestInvoiceValueOutstanding}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>NumberofPaymentsStillOwingLate</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.numberofPaymentsStillOwingLate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>TotalBalanceStillOwingLate</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.totalBalanceStillOwingLate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>HighestInvoiceValueOutstandingLate</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.highestInvoiceValueOutstandingLate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>NumberofPaymentsSentLegal</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.numberofPaymentsSentLegal}</div>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional12"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Extended Group Structure（
                    <c:if test="${empty searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup}">0</c:if>
                ${searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup.size()} ）</a>
            </h4>
        </div>
        <div id="addtional12" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="17.5%">Id</th>
                        <th width="5%">Country</th>
                        <th width="12.5%">Safe number</th>
                        <th width="22.5%">Company Name</th>
                        <th width="18%">Registered Number</th>
                        <th width="15%">Latest Accounts Date</th>
                        <th width="5%">Level</th>
                        <th width="5%">Status</th>

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
                    <c:if test="${empty searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup}">
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional13"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Commentary（
                    <c:if test="${empty searchDetail.additionalInformation.commentaries.commentary}">0</c:if>
                ${searchDetail.additionalInformation.commentaries.commentary.size()}
                    ）</a>
            </h4>
        </div>
        <div id="addtional13" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Commentary Text</th>
                        <th width="72">Positive or Negative</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="Commentary"
                               items="${searchDetail.additionalInformation.commentaries.commentary}"
                               varStatus="status">
                        <tr>
                            <td>${commentary.commentaryText}</td>
                            <td>${commentary.positiveOrNegative}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty searchDetail.additionalInformation.commentaries.commentary}">
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


</div>



