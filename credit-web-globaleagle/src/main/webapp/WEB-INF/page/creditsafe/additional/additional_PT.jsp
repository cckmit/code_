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
                    County Court Judgements(registered)exact </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Date</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.date}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Court</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.court}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Amount</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.amount}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Case Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.caseNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Status</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.status}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Defendant Name</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.defendantName}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Defendant Address</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.countyCourtJudgements.defendantAddress}</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

