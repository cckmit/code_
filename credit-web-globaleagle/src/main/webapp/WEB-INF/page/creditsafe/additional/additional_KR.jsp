
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
                    CAdditional Financial Items </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
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
                            <td valign="top" class="formleft"><strong>Cost of Sales</strong></td>
                            </tr>
                            <tr>
                            <td valign="top" class="formleft"><strong>Gross Profit</strong></td>
                            </tr>
                            <tr>
                            <td valign="top" class="formleft"><strong>Bad Debts</strong></td>
                            </tr>
                            <tr>
                            <td valign="top" class="formleft"><strong>Total Bonds</strong></td>
                            </tr>
                            <tr>
                            <td valign="top" class="formleft"><strong>Net Cash Flow From Operations</strong></td>
                            </tr>
                            <tr>
                            <td valign="top" class="formleft"><strong>Net Increase In Long Term Borrowings</strong></td>
                            </tr>
                            <tr>
                            <td valign="top" class="formleft"><strong>Net Increase In Short Term Borrowings</strong></td>
                            </tr>
                            <tr>
                            <td valign="top" class="formleft"><strong>Net Increase In Bonds</strong></td>
                            </tr>
                            <tr>
                            <td valign="top" class="formleft"><strong>Net Cash From Financing</strong></td>
                            </tr>
                            <tr>
                            <td valign="top" class="formleft"><strong>Net Increase In Cash & Cash Equivalents</strong></td>
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
                                <div align="left">${financialItems.yearEndDate}&nbsp;</div>
                            </td>
                            </tr>                            
                            <tr>
                            <td valign="top" align="right">
                                <div align="left">${financialItems.costOfSales}&nbsp;</div>
                            </td>
                            </tr>                            
                            <tr>
                            <td valign="top" align="right">
                                <div align="left">${financialItems.grossProfit}&nbsp;</div>
                            </td>
                            </tr>                            
                            <tr>
                            <td valign="top" align="right">
                                <div align="left">${financialItems.badDebts}&nbsp;</div>
                            </td>
                            </tr>                            
                            <tr>
                            <td valign="top" align="right">
                                <div align="left">${financialItems.totalBonds} &nbsp;</div>
                            </td>
                            </tr>                            
                            <tr>
                            <td valign="top" align="right">
                                <div align="left">${financialItems.netCashFlowFromOperations}&nbsp;</div>
                            </td>
                            </tr>                            
                            <tr>
                            <td valign="top" align="right">
                                <div align="left">${financialItems.netIncreaseInLongTermBorrowings}&nbsp;</div>
                            </td>
                            </tr>                            
                            <tr>
                            <td valign="top" align="right">
                                <div align="left">${financialItems.netIncreaseInShortTermBorrowings}&nbsp;</div>
                            </td>
                            </tr>                            
                            <tr>
                            <td valign="top" align="right">
                                <div align="left">${financialItems.netIncreaseInBonds}&nbsp;</div>
                            </td>
                            </tr>                            
                            <tr>
                            <td valign="top" align="right">
                                <div align="left">${financialItems.netCashFromFinancing}&nbsp;</div>
                            </td>
                            </tr>                            
                            <tr>
                            <td valign="top" align="right">
                                <div align="left">${financialItems.netIncreaseInCashAndCashEquivalents}&nbsp;</div>
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
                   href="#addtional2"
                   aria-expanded="false" aria-controls="collapseFour">
                    Overdue Payments Summary
                </a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <tbody>
                    <tr>
                        <td width="40%" class="formleft"><strong>10+ Days Overdue Payments (Count)</strong></td>
                        <td width="60%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.overduePaymentsSummary.tenPlusDaysOverduePaymentsCounts}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>10+ Days Overdue Payments Amount</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.overduePaymentsSummary.tenPlusDaysOverduePaymentsAmounts}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Negative Credit Records Financial Institutions Counts</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.overduePaymentsSummary.negativeCreditRecordsFinancialInstitutionsCounts}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Negative Credit Records Financial Institutions Amounts</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.overduePaymentsSummary.negativeCreditRecordsFinancialInstitutionsAmounts}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Negative Credit Records Non-Financial Institutions Counts</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.overduePaymentsSummary.negativeCreditRecordsNonFinancialInstitutionsCounts}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Negative Credit Records Non-Financial Institutions Amounts</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.overduePaymentsSummary.negativeCreditRecordsNonFinancialInstitutionsAmounts}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Item Date</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.overduePaymentsSummary.details.itemDate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Type</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.overduePaymentsSummary.details.type}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Default Amount</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.overduePaymentsSummary.details.defaultAmount}</div>
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional3"
                   aria-expanded="false" aria-controls="collapseFour">
                    Litigation Details (Defendant)
                </a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <tbody>
                    <tr>
                        <td width="30%" class="formleft"><strong>Currency (attribute)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.currency}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Multiplier (attribute)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.multiplier}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Ongoing Cases (Number of records)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.ongoingCasesNumberOfRecords}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Litigation Amount Ongoing Cases</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.litigationAmountOngoingCases}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases Lost (Number of records)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.closedCasesLostNumberOfRecords}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases (Lost) Amount</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.closedCasesLostAmount}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases Partially Lost (Number of records)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.closedCasesPartiallyLostNumberOfRecords}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases (Partially Lost) Amount</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.closedCasesPartiallyLostAmount}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases Won (Number of records)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.closedCasesWonNumberOfRecords}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases (Won) Amount</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.closedCasesWonAmount}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases Others (Number of records)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.closedCasesOthersNumberOfRecords}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases (Others) Amount</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsDefendant.closedCasesOthersAmount}</div>
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional4"
                   aria-expanded="false" aria-controls="collapseFour">
                    Litigation Details (Plaintiff)
                </a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <tbody>
                    <tr>
                        <td width="30%" class="formleft"><strong>Currency (attribute)</strong></td>
                        <td width="70%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.currency}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Multiplier (attribute) </strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.multiplier}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Ongoing Cases (Number of records)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.ongoingCasesNumberOfRecords}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Litigation Amount Ongoing Cases</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.litigationAmountOngoingCases}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases Lost (Number of records) </strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.closedCasesLostNumberOfRecords}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases (Lost) Amount</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.closedCasesLostAmount}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases Partially Lost (Number of records)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.closedCasesPartiallyLostNumberOfRecords}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases (Partially Lost) Amount</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.closedCasesPartiallyLostAmount}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases Won (Number of records)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.closedCasesWonNumberOfRecords}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases (Won) Amount</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.closedCasesWonAmount}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases Others (Number of records)</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.closedCasesOthersNumberOfRecords}</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="formleft"><strong>Closed Cases (Others) Amount</strong></td>
                        <td class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.litigationDetailsPlaintiff.closedCasesOthersAmount}</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
</div>

