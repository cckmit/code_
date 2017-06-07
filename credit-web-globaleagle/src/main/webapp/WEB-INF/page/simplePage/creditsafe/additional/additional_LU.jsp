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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional1"
                   aria-expanded="false" aria-controls="collapseFour">
                    Company Failures
                </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="15%">RCSS Number</th>
                        <th width="10%">Judgement Date</th>
                        <th width="10%">Judgement Number</th>
                        <th width="15%">Failure Description</th>
                        <th width="15%">Company Name</th>
                        <th width="20%">Address</th>
                        <th width="15%">InsertDate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.negativeInformation.companyFailures.event}"
                               varStatus="status">
                        <tr>
                            <td>${event.rcssNumber}</td>
                            <td>${event.judgementData}</td>
                            <td>${event.judgementNumber}</td>
                            <td>${event.failureDescription}</td>
                            <td>${event.companyName}</td>
                            <td>${event.address}</td>
                            <td>${event.insertDate}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.companyFailures.event}">
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
                    Company History
                </a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="20%">Date</th>
                        <th width="20%">Description</th>
                        <th width="20%">HTML Url</th>
                        <th width="20%">PDF Url</th>
                        <th width="20%">Memorial ID</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.companyHistory.event}"
                               varStatus="status">
                        <tr>
                            <td>${event.date}</td>
                            <td>${event.description}</td>
                            <td>${event.htmlUrl}</td>
                            <td>${event.pdfUrl}</td>
                            <td>${event.memoriaL_ID}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.companyHistory.event}">
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
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional3"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Misc </a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Negative Rating</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.negativeRating}</div>
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
                   aria-controls="collapse01">
                    Additional Financial Items </a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
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
                                    <td valign="top" class="formleft"><strong>Other Operating Income</strong></td>
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
                                        <td valign="top" align="right">${event.yearEndDate}&nbsp;
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="right">${event.otherOperatingIncome}&nbsp;
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </c:forEach>
                    </tr>
                </table>
            </div></div></div>

</div>


