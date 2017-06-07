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
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">NEGATIVE INFO <span class="pull-right">                     <a
                href="javascript:void(0);" onclick="update()" class="btn btn-xs btn-default btn-update">更新</a> </span>
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
                        <td width="23%" class="formleft"><strong>Cautionary UCC Filings </strong></td>
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


                    <table width="100%" class="table table-hover table-bordered table-responsive">
                        <thead>
                        <tr>
                            <th width="14%"><span class="formleft"><strong>Filed Date</strong></span></th>
                            <th width="14%"><span class="formleft"><strong>Filing Number </strong></span></th>
                            <th width="14%"><span class="formleft"><strong>Jurisdiction </strong></span></th>
                            <th width="17%"><span class="formleft"><strong>Secured Party Name </strong></span></th>
                            <th width="18%"><span class="formleft"><strong>Collateral </strong></span></th>
                            <th width="22%"><span class="formleft"><strong>Secured Party Address City</strong></span></th>
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

                    <table width="100%" class="table table-hover table-bordered table-responsive">
                        <thead>
                        <tr>
                            <th width="14%"><span class="formleft"><strong>Filed Date </strong></span></th>
                            <th width="16%"><span class="formleft"><strong>Filing Type </strong></span></th>
                            <th width="18%"><span class="formleft"><strong>Filed By </strong></span></th>
                            <th width="10%"><span class="formleft"><strong>Status </strong></span></th>
                            <th width="12%"><span class="formleft"><strong>Amount </strong></span></th>
                            <th width="12%"><span class="formleft"><strong>Filing Number </strong></span></th>
                            <th width="17%"><span class="formleft"><strong>Jurisdiction</strong></span></th>
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

                    <table width="100%" class="table table-hover table-bordered table-responsive">
                        <thead>
                        <tr>
                            <th width="14%"><span class="formleft"><strong>Filed Date </strong></span></th>
                            <th width="16%"><span class="formleft"><strong>Plaintiff </strong></span></th>
                            <th width="16%"><span class="formleft"><strong>Status </strong></span></th>
                            <th width="12%"><span class="formleft"><strong>Amount </strong></span></th>
                            <th width="12%"><span class="formleft"><strong>Filing Number </strong></span></th>
                            <th width="30%"><span class="formleft"><strong>Jurisdiction</strong></span></th>
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
                                <td width="23%" class="formleft"><strong>Filed Date </strong></td>
                                <td width="77%" class="formright">
                                    <div align="left">${bankruptcyDetail.filedDate }</div>
                                </td>
                            </tr>
                            <tr>
                                <td width="23%" class="formleft"><strong>Filing Type </strong></td>
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
                href="javascript:void(0);" onclick="update()" class="btn btn-xs btn-default btn-update">更新</a> </span>
        </h3>
    </div>
    <div class="panel-body">
        <div class="panel panel-default">
            <div class="panel-heading">Other Info</div>
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>First Reported Date</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.firstReportedDate }</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Primary NAICS Code</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.primaryNAICSCode }</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Primary NAICS Code Description</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.primaryNAICSCodeDescription }</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Years In Business </strong></td>
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
                href="javascript:void(0);" onclick="update()" class="btn btn-xs btn-default btn-update">更新</a> </span>
        </h3>
    </div>
    <div class="panel-body">
        <div class="panel panel-default">
            <div class="panel-heading">Payment Data</div>
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Total Trades Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.paymentData.tradePaymentSummary.totalTradesNumber }</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Continuous Trades Number </strong></td>
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
                        <th width="10%"><span class="formleft"><strong>Business Legal Name</strong></span></th>
                        <th width="10%"><strong>SOS Charter No.</strong></th>
                        <th width="10%"><span class="formleft"><strong>Status </strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Incorporated State</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Principal State</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Foreign or Domestic</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Profit or Non Profit</strong></span></th>
                        <th width="10%"><strong>Agent Name</strong></th>
                        <th width="10%"><span class="formleft"><strong>Primary Address city</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Agent Address city</strong></span></th>
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
                            <td>${searchDetail.additionalInformation.primaryCorporateRecord.agentAddress.simpleValue  }</td>                        </c:if>
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

                    <table width="100%" class="table table-hover table-bordered table-responsive">
                        <thead>
                        <tr>
                            <th width="10%"><span class="formleft"><strong>Business Legal Name</strong></span></th>
                            <th width="10%"><strong>SOS Charter No.</strong></th>
                            <th width="10%"><span class="formleft"><strong>Status </strong></span></th>
                            <th width="10%"><span class="formleft"><strong>Incorporated State</strong></span></th>
                            <th width="10%"><span class="formleft"><strong>Principal State</strong></span></th>
                            <th width="10%"><span class="formleft"><strong>Foreign or Domestic</strong></span></th>
                            <th width="10%"><span class="formleft"><strong>Profit or Non Profit</strong></span></th>
                            <th width="10%"><strong>Agent Name</strong></th>
                            <th width="10%"><span class="formleft"><strong>Primary Address city</strong></span></th>
                            <th width="10%"><span class="formleft"><strong>Agent Address city</strong></span></th>
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
                href="javascript:void(0);" onclick="update()" class="btn btn-xs btn-default btn-update">更新</a> </span>
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
                                <td width="25%" style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                                    <table class="table table-striped table-responsive" style="height: 100%">
                                        <tbody>
                                        <tr>
                                            <td valign="top" class="formleft"><strong>Financial Year</strong></td>
                                        </tr>
                                        <tr>
                                            <td valign="top" class="formleft"><strong>Accounts Type</strong></td>
                                        </tr>
                                        <tr>
                                            <td valign="top" class="formleft"><strong>Ebit</strong></td>
                                        </tr>
                                        <tr>
                                            <td valign="top" class="formleft"><strong>Ebitda</strong></td>
                                        </tr>
                                        <tr>
                                            <td valign="top" class="formleft"><strong>Operating Margin</strong></td>
                                        </tr>
                                        <tr>
                                            <td valign="top" class="formleft"><strong>Return On Equity Capital</strong>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td valign="top" class="formleft"><strong>net Profit Margin</strong></td>
                                        </tr>
                                        <tr>
                                            <td valign="top" class="formleft"><strong>Debt To Capital</strong></td>
                                        </tr>

                                        </tbody>

                                    </table>
                                </td>
                                <c:forEach var="financialStatement"
                                           items="${searchDetail.additionalInformation.additionalFinancials.financialStatement}"
                                           varStatus="status">
                                    <td width="25%">
                                        <table class="table table-striped table-responsive" style="height: 100%">
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
