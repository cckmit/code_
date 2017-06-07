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
                   aria-expanded="false" aria-controls="collapseTwo">
                    Misc
                </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingTwo">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Tax Code</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.taxCode}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Company Type Code</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.companyTypeCode}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Chamber Of Commerce</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.chamberOfCommerce}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Register Status</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.registerStatus}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Fax Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.faxNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Business Status</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.businessStatus}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Incorporation Date</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.incorporationDate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Closure Date</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.closureDate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Other Information</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.otherInformation}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Social Description</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.socialDescription}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Company Powers</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.companyPowers}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Power Category</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.powerCategory}</div>
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
                   href="#addtional2"
                   aria-expanded="false" aria-controls="collapseFour">
                    Commentaries（<c:if test="${empty searchDetail.additionalInformation.commentaries.commentary}">0</c:if>${searchDetail.additionalInformation.commentaries.commentary.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="50%">Commentary Text</th>
                        <th width="50%">Positive Or Negative</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.commentaries.commentary}">
                        <c:forEach var="commentary"
                                   items="${searchDetail.additionalInformation.commentaries.commentary}"
                                   varStatus="status">
                            <tr>
                                <td>${commentary.commentaryText}</td>
                                <td>${commentary.positiveOrNegative}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional3"
                   aria-expanded="false" aria-controls="collapseFour">
                    Transfers（<c:if test="${empty searchDetail.additionalInformation.commentaries.commentary}">0</c:if>${searchDetail.additionalInformation.commentaries.commentary.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="15%">Proceedings Date</th>
                        <th width="15%">Chamber of Commerce Registered</th>
                        <th width="15%">Transfer Number</th>
                        <th width="15%">Filed Date</th>
                        <th width="15%">Protocol Date</th>
                        <th width="15%">Transfer Subject</th>
                        <th width="15%">Company Involved</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="transfer"
                                   items="${searchDetail.additionalInformation.transfers.transfer}"
                                   varStatus="status">
                            <tr>
                                <td>${transfer.proceedingsDate}</td>
                                <td>${transfer.chamberofCommerceRegistered}</td>
                                <td>${transfer.transferNumber}</td>
                                <td>${transfer.filedDate}</td>
                                <td>${transfer.protocolDate}</td>
                                <td>${transfer.transferSubject}</td>
                                <td>
                            <c:forEach var="companyInvolved"
                                       items="${transfer.companiesInvolved.companyInvolved}"
                                       varStatus="status">
                                <tr>
                                    <td width="23%" class="formleft"><strong>Transferee Or Transferor</strong></td>
                                    <td width="77%" class="formright">
                                        <div align="left">${companyInvolved.transfereeOrTransferor}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="23%" class="formleft"><strong>Tax Code</strong></td>
                                    <td width="77%" class="formright">
                                        <div align="left">${companyInvolved.taxCode}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="23%" class="formleft"><strong>Name</strong></td>
                                    <td width="77%" class="formright">
                                        <div align="left">${companyInvolved.name}</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="23%" class="formleft"><strong>Document Name</strong></td>
                                    <td width="77%" class="formright">
                                        <div align="left">${companyInvolved.documentName}</div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </td>

                            </tr>
                        </c:forEach>
                    <c:if test="${empty searchDetail.additionalInformation.transfers.transfer}">
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
                   href="#addtional4"
                   aria-expanded="false" aria-controls="collapseFour">
                    Mergers（<c:if test="${empty searchDetail.additionalInformation.mergers.merger}">0</c:if>${searchDetail.additionalInformation.mergers.merger.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="15%">Merger Or Demerger</th>
                        <th width="15%">Event Type</th>
                        <th width="15%">RegisteredDate</th>
                        <th width="15%">Amended Date</th>
                        <th width="15%">Proceedings Date</th>
                        <th width="15%">EnforcementDate</th>
                        <th width="15%">Company Involved</th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="merger"
                               items="${searchDetail.additionalInformation.mergers.merger}"
                               varStatus="status">
                        <tr>
                        <td>${merger.mergerOrDemerger}</td>
                        <td>${merger.eventType}</td>
                        <td>${merger.registeredDate}</td>
                        <td>${merger.amendedDate}</td>
                        <td>${merger.proceedingsDate}</td>
                        <td>${merger.enforcementDate}</td>
                        <td>
                        <c:forEach var="companyInvolved"
                                   items="${merger.companiesInvolved.companyInvolved}"
                                   varStatus="status">
                            <tr>
                                <td width="23%" class="formleft"><strong>Name</strong></td>
                                <td width="77%" class="formright">
                                    <div align="left">${companyInvolved.name}</div>
                                </td>
                            </tr>
                            <tr>
                                <td width="23%" class="formleft"><strong>Tax Code</strong></td>
                                <td width="77%" class="formright">
                                    <div align="left">${companyInvolved.taxCode}</div>
                                </td>
                            </tr>
                            <tr>
                                <td width="23%" class="formleft"><strong>CCIAA and NREA</strong></td>
                                <td width="77%" class="formright">
                                    <div align="left">${companyInvolved.registeredDate}</div>
                                </td>
                            </tr>
                            <tr>
                                <td width="23%" class="formleft"><strong>Address</strong></td>
                                <td width="77%" class="formright">
                                    <div align="left">${companyInvolved.address.simpleValue}</div>
                                </td>
                            </tr>
                        </c:forEach>
                        </td>

                        </tr>
                    </c:forEach>
                    <c:if test="${empty searchDetail.additionalInformation.transfers.transfer}">
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
                   href="#addtional5"
                   aria-expanded="false" aria-controls="collapseFour">
                    Local Branches（<c:if test="${empty searchDetail.additionalInformation.localBranches.localBranch}">0</c:if>${searchDetail.additionalInformation.localBranches.localBranch.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="15%">CCIAA and NREA</th>
                        <th width="15%">Opening Date</th>
                        <th width="15%">Telephone Number</th>
                        <th width="15%">BranchStatus</th>
                        <th width="15%">Branch Number</th>
                        <th width="15%">Address</th>
                        <th width="15%">BranchType</th>
                        <th width="15%">Company Activity Description</th>
                        <th width="15%">Activity</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="localBranch"
                               items="${searchDetail.additionalInformation.localBranches.localBranch}"
                               varStatus="status">
                        <tr>
                        <td>${localBranch.CCIAAandNREA}</td>
                        <td>${localBranch.openingDate}</td>
                        <td>${localBranch.telephoneNumber}</td>
                        <td>${localBranch.branchStatus}</td>
                        <td>${localBranch.branchNumber}</td>
                        <td>${localBranch.address.simpleValue}</td>
                        <td>${localBranch.branchType}</td>
                        <td>${localBranch.companyActivityDescription}</td>
                        <td>
                        <c:forEach var="activity"
                                   items="${localBranch.activities.activity}"
                                   varStatus="status">
                            <tr>
                                <td width="23%" class="formleft"><strong>Code Type</strong></td>
                                <td width="77%" class="formright">
                                    <div align="left">${activity.codeType}</div>
                                </td>
                            </tr>
                            <tr>
                                <td width="23%" class="formleft"><strong>Code</strong></td>
                                <td width="77%" class="formright">
                                    <div align="left">${activity.code}</div>
                                </td>
                            </tr>
                            <tr>
                                <td width="23%" class="formleft"><strong>Type</strong></td>
                                <td width="77%" class="formright">
                                    <div align="left">${activity.type}</div>
                                </td>
                            </tr>
                            <tr>
                                <td width="23%" class="formleft"><strong>StartDate</strong></td>
                                <td width="77%" class="formright">
                                    <div align="left">${activity.startDate}</div>
                                </td>
                            </tr>
                            <tr>
                                <td width="23%" class="formleft"><strong>Description</strong></td>
                                <td width="77%" class="formright">
                                    <div align="left">${activity.description}</div>
                                </td>
                            </tr>
                        </c:forEach>
                        </td>

                        </tr>
                    </c:forEach>
                    <c:if test="${empty searchDetail.additionalInformation.localBranches.localBranch}">
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
                   href="#addtional6"
                   aria-expanded="false" aria-controls="collapseTwo">
                    Workforce Information
                </a>
            </h4>
        </div>
        <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingTwo">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number of Partners</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.workforceInformation.numberofPartners}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number of Directors</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.workforceInformation.numberofDirectors}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Accounts Controller</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.workforceInformation.accountsController}</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="33%">Administration Type</th>
                        <th width="33%">Minimum Number of Directors</th>
                        <th width="33%">Maximum Number of Directors</th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="companyAdministrationForm"
                               items="${searchDetail.additionalInformation.workforceInformation.companyAdministrationForms.companyAdministrationForm}"
                               varStatus="status">
                        <tr>
                        <td>${companyAdministrationForm.administrationType}</td>
                        <td>${companyAdministrationForm.minimumNumberofDirectors}</td>
                        <td>${companyAdministrationForm.maximumNumberofDirectors}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty searchDetail.additionalInformation.workforceInformation.companyAdministrationForms.companyAdministrationForm}">
                        <tr>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="20%">Latest Employee Information Date</th>
                        <th width="20%">Employee InformationYear</th>
                        <th width="20%">Average Number SE workers</th>
                        <th width="20%">Average Number Employed Workers</th>
                        <th width="20%">Average Total Number of Workers</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="companyEmployees"
                               items="${searchDetail.additionalInformation.workforceInformation.companyEmployees.companyEmployees}"
                               varStatus="status">
                        <tr>
                            <td>${companyEmployees.latestEmployeeInformationDate}</td>
                            <td>${companyEmployees.employeeInformationYear}</td>
                            <td>${companyEmployees.averageNumberSEworkers}</td>
                            <td>${companyEmployees.averageNumberEmployedWorkers}</td>
                            <td>${companyEmployees.averageTotalNumberofWorkers}</td>

                        </tr>
                    </c:forEach>
                    <c:if test="${empty searchDetail.additionalInformation.workforceInformation.companyEmployees.companyEmployees}">
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
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%">Q1 Number SE workers</th>
                        <th width="10%">Q1 Number Employed Workers</th>
                        <th width="10%">Q1 Total Number of Workers</th>
                        <th width="10%">Q2 Number SE workers</th>
                        <th width="10%">Q2 Number Employed Workers</th>
                        <th width="10%">Q2 Total Number of Workers</th>
                        <th width="10%">Q3 Number SE workers</th>
                        <th width="10%">Q3 Number Employed Workers</th>
                        <th width="10%">Q3 Total Number of Workers</th>
                        <th width="10%">Q4 Number SE workers</th>
                        <th width="10%">Q4 Number Employed Workers</th>
                        <th width="10%">Q4 Total Number of Workers</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="companyEmployees"
                               items="${searchDetail.additionalInformation.workforceInformation.companyEmployees.companyEmployees}"
                               varStatus="status">
                        <tr>
                            <td>${companyEmployees.q1NumberSEworkers}</td>
                            <td>${companyEmployees.q1NumberEmployedWorkers}</td>
                            <td>${companyEmployees.q1TotalNumberofWorkers}</td>
                            <td>${companyEmployees.q2NumberSEworkers}</td>
                            <td>${companyEmployees.q2NumberEmployedWorkers}</td>
                            <td>${companyEmployees.q2TotalNumberofWorkers}</td>
                            <td>${companyEmployees.q3NumberSEworkers}</td>
                            <td>${companyEmployees.q3NumberEmployedWorkers}</td>
                            <td>${companyEmployees.q3TotalNumberofWorkers}</td>
                            <td>${companyEmployees.q4NumberSEworkers}</td>
                            <td>${companyEmployees.q4NumberEmployedWorkers}</td>
                            <td>${companyEmployees.q4TotalNumberofWorkers}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty searchDetail.additionalInformation.workforceInformation.companyEmployees.companyEmployees}">
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
                   href="#addtional7"
                   aria-expanded="false" aria-controls="collapseFour">
                    Auditors
                </a>
            </h4>
        </div>
        <div id="addtional7" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Auditors Board Validity Start Date</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.auditors.auditorsBoardValidityStartDate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>AuditorsBoardValidityEndDate</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.auditors.auditorsBoardValidityEndDate}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number of Periods Board Remains in Office</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.auditors.numberofPeriodsBoardRemainsinOffice}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Auditors Board Term</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.auditors.auditorsBoardTerm}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number of Statutory Auditors</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.auditors.numberofStatutoryAuditors}</div>
                        </td>
                    </tr>
                    <c:forEach var="auditor"
                               items="${searchDetail.additionalInformation.auditors.auditor}"
                               varStatus="status">
                        <tr>
                            <td width="23%" class="formleft"><strong>Number of Assistant Auditors</strong></td>
                            <td width="77%" class="formright">
                                <div align="left">${searchDetail.additionalInformation.auditors.auditor.numberofAssistantAuditors}</div>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td width="23%" class="formleft"><strong>Min Number of Members In Board</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.auditors.minNumberofMembersInBoard}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Max Number of Members In Board</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.auditors.maxNumberofMembersInBoard}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number of Members InThe Board in Office</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.auditors.numberofMembersInTheBoardinOffice}</div>
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
                   href="#addtional8"
                   aria-expanded="false" aria-controls="collapseFour">
                    Capital Figures
                </a>
            </h4>
        </div>
        <div id="addtional8" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>CapitalCurrency</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.capitalFigures.capitalCurrency}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>DeliberatedShareCapital</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.capitalFigures.deliberatedShareCapital}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>SubscribedShareCapital</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.capitalFigures.subscribedShareCapital}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>PaidIn Share Capital</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.capitalFigures.paidInShareCapital}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Number of Shares in the Share Capital</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.capitalFigures.numberofSharesintheShareCapital}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Share Unit Value</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.capitalFigures.shareUnitValue}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Share Unit Currency</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.capitalFigures.shareUnitCurrency}</div>
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
                   href="#addtional9"
                   aria-expanded="false" aria-controls="collapseFour">
                    Registered Roles（<c:if test="${empty searchDetail.additionalInformation.registeredRoles.registeredRole}">0</c:if>${searchDetail.additionalInformation.registeredRoles.registeredRole.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional9" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="25%">Role Description</th>
                        <th width="25%">Role Number</th>
                        <th width="25%">Role Registration Request Date</th>
                        <th width="25%">Province</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.registeredRoles.registeredRole}">
                        <c:forEach var="registeredRole"
                                   items="${searchDetail.additionalInformation.registeredRoles.registeredRole}"
                                   varStatus="status">
                            <tr>
                                <td>${registeredRole.roleDescription}</td>
                                <td>${registeredRole.roleNumber}</td>
                                <td>${registeredRole.roleRegistrationRequestDate}</td>
                                <td>${registeredRole.province}</td>

                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty searchDetail.additionalInformation.registeredRoles.registeredRole}">
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
                   href="#addtional10"
                   aria-expanded="false" aria-controls="collapseFour">
                    Activities（<c:if test="${empty searchDetail.additionalInformation.activities.activity}">0</c:if>${searchDetail.additionalInformation.activities.activity.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional10" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="20%">Company Activity Description</th>
                        <th width="20%">Code</th>
                        <th width="20%">Type</th>
                        <th width="20%">Start Date</th>
                        <th width="20%">Description</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.activities.activity}">
                        <c:forEach var="activity"
                                   items="${searchDetail.additionalInformation.activities.activity}"
                                   varStatus="status">
                            <tr>
                                <td>${activity.codeType}</td>
                                <td>${activity.code}</td>
                                <td>${activity.type}</td>
                                <td>${activity.startDate}</td>
                                <td>${activity.description}</td>

                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty searchDetail.additionalInformation.activities.activity}">
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional11"
                   aria-expanded="false" aria-controls="collapseFour">
                    Protested Bills（<c:if test="${empty searchDetail.additionalInformation.negativeInformation.protestedBills.protestedBill}">0</c:if>${searchDetail.additionalInformation.negativeInformation.protestedBills.protestedBill.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional11" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%">Case Number</th>
                        <th width="10%">Tax Code</th>
                        <th width="10%">Name</th>
                        <th width="10%">Address</th>
                        <th width="10%">Amount Of Protesti</th>
                        <th width="10%">Currency</th>
                        <th width="10%">Notification Date</th>
                        <th width="10%">Registration Date</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.protestedBills.protestedBill}">
                        <c:forEach var="protestedBill"
                                   items="${searchDetail.additionalInformation.negativeInformation.protestedBills.protestedBill}"
                                   varStatus="status">
                            <tr>
                                <td>${protestedBill.caseNumber}</td>
                                <td>${protestedBill.taxCode}</td>
                                <td>${protestedBill.name}</td>
                                <td>${protestedBill.address.simpleValue}</td>
                                <td>${protestedBill.amountOfProtesti}</td>
                                <td>${protestedBill.currency}</td>
                                <td>${protestedBill.notificationDate}</td>
                                <td>${protestedBill.registrationDate}</td>

                            </tr>
                        </c:forEach>
                    </c:if>
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
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional12"
                   aria-expanded="false" aria-controls="collapseFour">
                    Insolvency Events（<c:if test="${empty searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event}">0</c:if>${searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional12" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="28%">Registration Date</th>
                        <th width="72%">Legal Event Type</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event}">
                        <c:forEach var="event"
                                   items="${searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event}"
                                   varStatus="status">
                            <tr>
                                <td>${event.registrationDate}</td>
                                <td>${event.legalEventType}</td>

                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty searchDetail.additionalInformation.negativeInformation.insolvencyInformation.insolvencyEvents.event}">
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
                   href="#addtional13"
                   aria-expanded="false" aria-controls="collapseFour">
                    Extended Group Structure（<c:if test="${empty searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup}">0</c:if>${searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup.size()}）
                </a>
            </h4>
        </div>
        <div id="addtional13" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%">Id</th>
                        <th width="10%">Country</th>
                        <th width="10%">Safe number</th>
                        <th width="10%">Company Name</th>
                        <th width="10%">Registered Number</th>
                        <th width="10%">Latest Accounts Date</th>
                        <th width="10%">Level</th>
                        <th width="10%">Status</th>
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


</div>




