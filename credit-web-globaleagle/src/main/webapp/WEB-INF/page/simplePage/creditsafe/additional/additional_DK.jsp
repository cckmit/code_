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
                    Additional Financials</a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <c:forEach var="financialItems"
                       items="${searchDetail.additionalInformation.additionalFinancials.financialItems}"
                       varStatus="status">
                <tr>
                    <td width="23%" class="formleft"><strong>Financial Year</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.yearEndDate}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Cost Of Sales</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.costOfSales}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Gross Profit</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.grossProfit}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Change In Stock</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.changeInStock}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Other Operating Income</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.otherOperatingIncome}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Audit Fees</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.auditFees}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Other Operating Expenses</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.otherOperatingExpenses}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Extraordinary Net Result</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.extraordinaryNetResult}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Investment Property</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.investmentProperty}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Contract Work In Progress</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.contractWorkInProgress}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Revaluation Reserve</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.revaluationReserve}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Minority Interests</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${financialItems.minorityInterests}</div>
                    </td>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional2"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Summary</a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <tr>
                <td width="23%" class="formleft"><strong>Type of Info</strong></td>
                <td width="77%" class="formright">
                    <div align="left">${searchDetail.additionalInformation.negativeInformation.negativeInformationSummary.typeofInfo}</div>
                </td>
            </tr>
            <tr>
                <td width="23%" class="formleft"><strong>Date</strong></td>
                <td width="77%" class="formright">
                    <div align="left">${searchDetail.additionalInformation.negativeInformation.negativeInformationSummary.date}</div>
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
                    Official Remarks</a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <c:forEach var="event"
                       items="${searchDetail.additionalInformation.negativeInformation.officialRemarks.event}"
                       varStatus="status">
                <tr>
                    <td width="23%" class="formleft"><strong>Date</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${event.date}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Type of Info</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${event.typeofInfo}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Source</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${event.source}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Text</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${event.text}</div>
                    </td>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional4"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Other Trading Names</a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <tr>
                <td width="23%" class="formleft"><strong>Other Trading Name</strong></td>
                <td width="77%" class="formright">
                    <div align="left">${searchDetail.additionalInformation.otherTradingNames.otherTradingName}</div>
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
                    Events</a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <c:forEach var="event"
                       items="${searchDetail.additionalInformation.companyHistory.event}"
                       varStatus="status">
                <tr>
                    <td width="23%" class="formleft"><strong>Event Date</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${event.date}</div>
                    </td>
                </tr>
                <tr>
                    <td width="23%" class="formleft"><strong>Event Description</strong></td>
                    <td width="77%" class="formright">
                        <div align="left">${event.description}</div>
                    </td>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional6"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Real Estate</a>
            </h4>
        </div>
        <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <tr>
                <td width="23%" class="formleft"><strong>Value</strong></td>
                <td width="77%" class="formright">
                    <div align="left">${searchDetail.additionalInformation.realEstate.value}</div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</div>
</div>
