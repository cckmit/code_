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
                    Bankruptcy</a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.bankruptcy.hasBankruptcy}">
                        <tr>
                            <td width="23%" class="formleft"><strong>Has Bankruptcy</strong></td>
                            <td width="77%" class="formright">
                                <div align="left">${searchDetail.additionalInformation.negativeInformation.bankruptcy.hasBankruptcy}</div>
                            </td>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional2"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Insolvency Information</a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%"><span class="formleft"><strong>Reference Number of the Court</strong></span>
                        </th>
                        <th width="10%"><span class="formleft"><strong>Record Created On</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Insolvency Representative </strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Date of Insolvency</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Trustee Name </strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Trustee Code</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Trustee City</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Trustee Surname</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Trustee Forename</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Trustee Title</strong></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event}"
                               varStatus="status">
                        <tr>
                            <td>${event.referenceNumberoftheCourt}</td>
                            <td>${event.recordCreatedOn}</td>
                            <td>${event.insolvencyRepresentatives.insolvencyRepresentative}</td>
                            <td>${event.dateofInsolvency}</td>
                            <td>${event.trusteeData.name}</td>
                            <td>${event.trusteeData.code}</td>
                            <td>${event.trusteeData.city}</td>
                            <td>${event.trusteeData.surname}</td>
                            <td>${event.trusteeData.forename}</td>
                            <td>${event.trusteeData.title}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional3"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Natural Person Events</a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%"><span class="formleft"><strong>Entity Name </strong></span></th>
                        <th width="10%"><strong>Entity Name (attribute: Type)</strong></th>
                        <th width="10%"><span class="formleft"><strong>Entity Date </strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Entity Description</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Entity Description Code</strong></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.negativeInformation.directorEvents.event}"
                               varStatus="status">
                        <tr>
                            <td>${event.entityName}</td>
                            <td>${event.entityName.type}</td>
                            <td>${event.date}</td>
                            <td>${event.description}</td>
                            <td>${event.description.code}</td>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>

    </div>
    <div class="panel panel-default">
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional4"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Misc</a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Turnover Range </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.turnoverRange}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Commerical Register City </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.commercialRegisterCity}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Commerical Register Zip </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.commercialRegisterZip}</div>
                        </td>
                    </tr>

                    <tr>
                        <td width="23%" class="formleft"><strong>Financials Quality </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.financialsQuality}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>DE Current Rating </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.deCurrentRating}</div>
                        </td>
                    </tr>

                    <tr>
                        <td width="23%" class="formleft"><strong>DE Previous Rating </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.dePreviousRating}</div>
                        </td>
                    </tr>

                    <tr>
                        <td width="23%" class="formleft"><strong>Premise Type (NonReg) </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.premiseType}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>SOHO (NonReg) </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.soho}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Fax Number (NonReg) </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.faxNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Company Type (NonReg) </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.companyType}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Negative Rating </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.negativeRating}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Complementary Company </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.complementaryCompany}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Business Purpose </strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.businessPurpose}</div>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional5"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Image Accounts</a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%"><span class="formleft"><strong>Serial Number</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Start date</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>End date</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Published date</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Document Type</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Financials Type</strong></span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="imageAccount"
                               items="${searchDetail.additionalInformation.imageAccounts.imageAccount}"
                               varStatus="status">
                        <tr>
                            <td>${imageAccount.imageId}</td>
                            <td>${imageAccount.startDate}</td>
                            <td>${imageAccount.endDate}</td>
                            <td>${imageAccount.publishedDate}</td>
                            <td>${imageAccount.documentType} </td>
                            <td>${imageAccount.financialsType}</td>
                        </tr>
                    </c:forEach>

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
                    Commentary</a>
            </h4>
        </div>
        <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>


                    <tr>
                        <td class="formleft"><strong>Positive or Negative </strong></td>
                        <td class="formright"><strong>Commentary Text</strong></td>

                    </tr>
                    <c:forEach var="commentary"
                               items="${searchDetail.additionalInformation.commentaries.commentary}"
                               varStatus="status">
                        <tr>
                            <td class="formleft">
                                <div>${commentary.positiveOrNegative}</div>
                            </td>
                            <td class="formright">
                                <div>${commentary.commentaryText}</div>
                            </td>
                        </tr>
                    </c:forEach>

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
                    Company History</a>
            </h4>
        </div>
        <div id="addtional7" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">

                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>


                    <tr>
                        <td class="formleft"><strong>Date </strong></td>
                        <td class="formright"><strong>Description</strong></td>

                    </tr>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.companyHistory.event}"
                               varStatus="status">
                        <tr>
                            <td class="formleft">
                                <div>${event.date}</div>
                            </td>
                            <td class="formright">
                                <div>${event.description}</div>
                            </td>
                        </tr>
                    </c:forEach>

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
                    Beneficial Ownerships</a>
            </h4>
        </div>
        <div id="addtional8" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%"><span class="formleft"><strong>Name</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>City</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Postal code</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Country</strong></span></th>
                        <th width="10%"><span class="formleft"><strong>Share Percent</strong></span></th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="owner"
                               items="${searchDetail.additionalInformation.beneficialOwnerships.owner}"
                               varStatus="status">
                        <tr>
                            <td>${owner.name}</td>
                            <td>${owner.address.city}</td>
                            <td>${owner.address.postalCode}</td>
                            <td>${owner.country}</td>
                            <td>${owner.sharePercent}%</td>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>


            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional9"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Turnover Ranges</a>
            </h4>
        </div>
        <div id="addtional9" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">

                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>

                    <tr>
                        <td class="formleft"><strong>Year</strong></td>
                        <td class="formright"><strong>Range</strong></td>

                    </tr>
                    <c:forEach var="turnoverRange"
                               items="${searchDetail.additionalInformation.turnoverRanges.turnoverRange}"
                               varStatus="status">
                        <tr>
                            <td class="formleft">
                                <div>${turnoverRange.year}</div>
                            </td>
                            <td class="formright">
                                <div>${turnoverRange.range}</div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>