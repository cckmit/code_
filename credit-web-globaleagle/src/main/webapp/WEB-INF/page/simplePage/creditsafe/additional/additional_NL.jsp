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
                    Court Data </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Court Action</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.courtData.facts.courtAction}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Date Of Bankruptcy</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.courtData.facts.dateOfBankruptcy}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Address</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.courtData.receiverDetails.address}</div>
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
                        <td width="23%" class="formleft"><strong>Date of Legal Form</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.dateofLegalForm}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Ceased Trading Date</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.ceasedTradingDate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Exporter</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.exporter}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Importer</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.importer}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>RSIN Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.rsinNumber}</div>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional3"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Industry Comparison </a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Industry Average Credit Rating</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryComparison.industryAverageCreditLimit}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Industry Average Credit Limit</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.industryComparison.industryAverageCreditRating}</div>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional4"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Payment Expectations Summary </a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Suspensions of Payments/Mora</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentExpectationsSummary.suspensionOfPaymentsMora}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Payment Expectation Days</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentExpectationsSummary.paymentExpectationDays}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Day Sales Outstanding</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentExpectationsSummary.daySalesOutstanding}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Industry Average Payment Expectation Days</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentExpectationsSummary.industryAveragePaymentExpectationDays}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Industry Average Day Sales Outstanding</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentExpectationsSummary.industryAverageDaySalesOutstanding}</div>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional5"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Industry Quartile Analysis </a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
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
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional6"
                   aria-expanded="true"
                   aria-controls="collapse01">
                    Letters of Liability Information (403 Statements) </a>
            </h4>
        </div>
        <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="heading01">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="25%"
                            style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                            <table class="table table-striped table-responsive" style="height: 100%">
                                <tbody>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Financial Year</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Company Name</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Company Number</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Date Submitted – Letter of Agreement</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 1 Start date</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 1 Submitted Date </strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 1 Removal Submitted</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 1 Removal Date</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 2 Start date</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 2 Submitted Date</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 2 Removal Submitted</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 2 Removal Date</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 1 Start date – Parent
                                        2</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 1 Submitted Date – Parent
                                        2</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 1 Removal Submitted – Parent
                                        2</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 1 Removal Date – Parent
                                        2</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 2 Start date – Parent
                                        2</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 2 Submitted Date – Parent
                                        2</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 2 Removal Submitted – Parent
                                        2</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Letter of Liability 2 Removal Date – Parent
                                        2</strong></td>
                                </tr>
                                </tbody>

                            </table>
                        </td>
                        <c:forEach var="letterOfLiablilityInformation403"
                                   items="${searchDetail.additionalInformation.lettersOfLiablilityInformation403.letterOfLiablilityInformation403}"
                                   varStatus="status">
                            <td width="25%">
                                <table class="table table-striped table-responsive"
                                       style="height: 100%">
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.financialYear}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.companyName}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.companyNumber}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.dateSubmited}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability1StartDate}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability1SubmittedDate}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability1RemovalSubmitted}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability1RemovalDate}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability2StartDate}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability2SubmittedDate}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability2RemovalSubmitted}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability2RemovalDate}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability1StartDate-Parent2}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability1SubmittedDate-Parent2}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability1RemovalSubmitted-Parent2}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability1RemovalDate-Parent2}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability2StartDate-Parent2}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability2SubmittedDate-Parent2}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability2RemovalSubmitted-Parent2}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${letterOfLiablilityInformation403.letterOfLiability2RemovalDate-Parent2}&nbsp;
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional7"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Extended Group Structure </a>
            </h4>
        </div>
        <div id="addtional7" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%">Id</th>
                        <th width="10%">Country</th>
                        <th width="5%">Safe number</th>
                        <th width="10%">Company Name</th>
                        <th width="10%">Registered Number</th>
                        <th width="10%">Latest Accounts Date</th>
                        <th width="5%">Level</th>
                        <th width="10%">Status</th>
                        <th width="10%">Common Rating Banding</th>
                        <th width="10%">Value</th>
                        <th width="10%">Description</th>
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
                            <td>${companyInGroup.companyRatingBanding}</td>
                            <td>${companyInGroup.companyRatingBanding.value}</td>
                            <td>${companyInGroup.companyRatingBanding.description}</td>
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
                   href="#addtional8"
                   aria-expanded="false" aria-controls="collapseFour">
                    Commentary
                </a>
            </h4>
        </div>
        <div id="addtional8" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Commentary Text</th>
                        <th width="72%">Positive or Negative</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="commentary"
                               items="${searchDetail.additionalInformation.commentaries.commentary}"
                               varStatus="status">
                        <tr>
                            <td>${commentary.commentaryText}</td>
                            <td>${commentary.positiveOrNegative}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.commentaries.commentary}">
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
                   aria-controls="collapse01">
                    Additional Financials </a>
            </h4>
        </div>
        <div id="addtional9" class="panel-collapse collapse" role="tabpanel"
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
                                    <td valign="top" class="formleft"><strong>Auditing</strong></td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Judgement</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top" class="formleft"><strong>Consolidated Subsidiaries</strong></td>
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
                                                ${financialItems.auditing}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.judgement}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">
                                                ${financialItems.commentary}&nbsp;
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
                   href="#addtional10"
                   aria-expanded="false" aria-controls="collapseFour">
                    Company History
                </a>
            </h4>
        </div>
        <div id="addtional10" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="23%">Date</th>
                        <th width="23%">Description</th>
                        <th width="23%">Previous Value</th>
                        <th width="23%">Current Value</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.companyHistory.event}"
                               varStatus="status">
                        <tr>
                            <td>${event.date}</td>
                            <td>${event.description}</td>
                            <td>${event.previousValue}</td>
                            <td>${event.currentValue}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.companyHistory.event}">
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional11"
                   aria-expanded="false" aria-controls="collapseFour">
                    KVK Filings
                </a>
            </h4>
        </div>
        <div id="addtional11" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="23%">Filing Date</th>
                        <th width="77%">Filed Event</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="kvkFiling"
                               items="${searchDetail.additionalInformation.kvkFilings.kvkFiling}"
                               varStatus="status">
                        <tr>
                            <td>${kvkFiling.filingDate}</td>
                            <td>${kvkFiling.filedEvent}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.kvkFilings.kvkFiling}">
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