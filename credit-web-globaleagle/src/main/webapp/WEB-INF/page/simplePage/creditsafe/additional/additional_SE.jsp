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
                   aria-controls="collapseOne">Debt Balance </a>
            </h4>
        </div>

        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">

                <table class="table table-hover table-bordered table-responsive">
                    <tbody>
                    <tr>
                        <td width="25%" ><strong>Currency</strong></td>
                        <td width="75%" >
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.debtBalance.currency}</div>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Number of Private Claims</strong></td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.debtBalance.numberOfPrivateClaims}</div>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Balance of Private Claims</strong></td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.debtBalance.balanceOfPrivateClaims}</div>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Number of Public Claims</strong></td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.debtBalance.numberOfPublicClaims}</div>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Balance of Public Claims</strong></td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.debtBalance.balanceOfPublicClaims}</div>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Total Balance</strong></td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.debtBalance.totalBalance}</div>
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
                   href="#addtional2"
                   aria-expanded="false" aria-controls="collapseFour">
                    Record of Non Payment
                </a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <tbody>
                    <tr>
                        <td width="30%" ><strong>Number of Distraint or Repossessions</strong></td>
                        <td width="70%" >
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.recordOfNonPayment.numberOfDistraintOrRepossessions}</div>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Number of Public Claims</strong></td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.recordOfNonPayment.numberOfPublicClaims}</div>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Number of Private Claims</strong></td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.recordOfNonPayment.numberOfPrivateClaims}</div>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Number of Applications</strong></td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.recordOfNonPayment.numberOfApplications}</div>
                        </td>
                    </tr>
                    <tr>
                        <td><strong>Number of Revoked Applications</strong></td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.recordOfNonPayment.numberOfRevokedApplications}</div>
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
                    Latest Public Claims
                </a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
               <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <td width="20%" ><strong>Type</strong></td>
                        <td width="20%" ><strong>Date</strong></td>
                        <td width="30%" ><strong>Amount</strong></td>
                        <td width="30%" ><strong>Currency</strong></td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.latestPublicClaim.type}</div>
                        </td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.latestPublicClaim.date}</div>
                        </td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.latestPublicClaim.amount}</div>
                        </td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.latestPublicClaim.currency}</div>
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
                   href="#addtional4"
                   aria-expanded="false" aria-controls="collapseFour">
                    Latest Private Claims
                </a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
               <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <td width="20%" ><strong>Date</strong></td>
                        <td width="20%" ><strong>Amount</strong></td>
                        <td width="20%" ><strong>Currency</strong></td>
                        <td width="20%" ><strong>Creditor</strong></td>
                        <td width="20%" ><strong>Comments</strong></td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td >
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.latestPrivateClaim.date}</div>
                        </td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.latestPrivateClaim.amount}</div>
                        </td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.latestPrivateClaim.currency}</div>
                        </td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.latestPrivateClaim.creditor}</div>
                        </td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.negativeInformation.latestPrivateClaim.comments}</div>
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
                   href="#addtional5"
                   aria-expanded="false" aria-controls="collapseFour">
                    Misc
                </a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
               <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <td width="30%" ><strong>Registered for F.Tax</strong></td>
                        <td width="30%" ><strong>Registered for VAT</strong></td>
                        <td width="40%" ><strong>Registered For Employee Tax</strong></td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>                        
                        <td>
                            <div align="left">${searchDetail.additionalInformation.misc.registeredForFTax}</div>
                        </td>                      
                        <td>
                            <div align="left">${searchDetail.additionalInformation.misc.registeredForVat}</div>
                        </td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.misc.registeredForEmployeeTax}</div>
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
                   href="#addtional6"
                   aria-expanded="false" aria-controls="collapseFour">
                    Events
                </a>
            </h4>
        </div>
        <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
               <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <td width="30%" ><strong>Event Date</strong></td>
                        <td width="70%" ><strong>Event Description</strong></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.companyHistory.event}"
                               varStatus="status">
                    <tr>
                        <td>
                            <div align="left">${event.date}</div>
                        </td>
                        <td>
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
        <div class="panel-heading" role="tab">
            <h4 class="panel-title">
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional7"
                   aria-expanded="false" aria-controls="collapseFour">
                    Company Certificates
                </a>
            </h4>
        </div>
        <div id="addtional7" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
               <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <td width="20%" ><strong>Type</strong></td>
                        <td width="40%" ><strong>Category</strong></td>
                        <td width="40%" ><strong>Issuer</strong></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="companyCertificate"
                               items="${searchDetail.additionalInformation.companyCertificates.companyCertificate}"
                               varStatus="status">
                    <tr>
                        <td>
                            <div align="left">${companyCertificate.type}</div>
                        </td>
                        <td>
                            <div align="left">${companyCertificate.category}</div>
                        </td>
                        <td>
                            <div align="left">${companyCertificate.issuer}</div>
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional8"
                   aria-expanded="false" aria-controls="collapseFour">
                    Industry Comparison
                </a>
            </h4>
        </div>
        <div id="addtional8" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
               <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <td width="25%" ><strong>Activity Code</strong></td>
                        <td width="25%" ><strong>Activity Description</strong></td>
                        <td width="25%" ><strong>Industry Average Credit Rating</strong></td>
                        <td width="25%" ><strong>Industry Average Credit Limit</strong></td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.industryComparison.activityCode}</div>
                        </td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.industryComparison.activityDescription}</div>
                        </td>
                        <td>
                            <div align="left">${searchDetail.additionalInformation.industryComparison.industryAverageCreditRating}</div>
                        </td>
                        <td>
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
                   href="#addtional9"
                   aria-expanded="false" aria-controls="collapseFour">
                    Extended Group Structure
                </a>
            </h4>
        </div>
        <div id="addtional9" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
               <table class="table table-hover table-bordered table-responsive">
                    <thead>

                    <tr>
                        <td width="10%" ><strong>Date</strong></td>
                        <td width="8%" ><strong>Country</strong></td>
                        <td width="12%" ><strong>Safe number</strong></td>
                        <td width="14%" ><strong>Company Name </strong></td>
                        <td width="18%" ><strong>Registered Number</strong></td>
                        <td width="23%" ><strong>Latest Accounts Date</strong></td>
                        <td width="15%" ><strong>Level</strong></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="companyInGroup"
                               items="${searchDetail.additionalInformation.extendedGroupStructure.groupStructure.companyInGroup}"
                               varStatus="status">
                    <tr>
                        <td>
                            <div align="left">${companyInGroup.id}</div>
                        </td>
                        <td>
                            <div align="left">${companyInGroup.country}</div>
                        </td>
                        <td>
                            <div align="left">${companyInGroup.safeNumber}</div>
                        </td>
                        <td>
                            <div align="left">${companyInGroup.companyName}</div>
                        </td>
                        <td>
                            <div align="left">${companyInGroup.registeredNumber}</div>
                        </td>
                        <td>
                            <div align="left">${companyInGroup.latestAnnualAccounts}</div>
                        </td>
                        <td>
                            <div align="left">${companyInGroup.level}</div>
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional10"
                   aria-expanded="false" aria-controls="collapseFour">
                    Status History
                </a>
            </h4>
        </div>
        <div id="addtional10" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
               <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <td width="6%" ><strong>Date</strong></td>
                        <td width="15%" ><strong>Event Description</strong></td>
                        <td width="10%" ><strong>Applicant</strong></td>
                        <td width="15%" ><strong>Bankruptcy Trustee</strong></td>
                        <td width="10%" ><strong>Company Name</strong></td>
                        <td width="10%" ><strong>Address</strong></td>
                        <td width="10%" ><strong>Court Name</strong></td>
                        <td width="14%" ><strong>Additional Text</strong></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.statusHistory.event}"
                               varStatus="status">
                    <tr>
                        <td >
                            <div align="left">${event.date}</div>
                        </td>
                        <td >
                            <div align="left">${event.description}</div>
                        </td>
                        <td >
                            <div align="left">${event.applicant}</div>
                        </td>
                        <td >
                            <div align="left">${event.bankruptcyTrustee}</div>
                        </td>
                        <td >
                            <div align="left">${event.companyName}</div>
                        </td>
                        <td >
                            <div align="left">${event.simpleValue}</div>
                        </td>
                        <td >
                            <div align="left">${event.courtName}</div>
                        </td>
                        <td >
                            <div align="left">${event.additionalText}</div>
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
                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                   href="#addtional11"
                   aria-expanded="false" aria-controls="collapseFour">
                    Financial Statement
                </a>
            </h4>
        </div>
        <div id="addtional11" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingFour">
            <div class="panel-body">
               <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <td width="19%" ><strong>Year End Date</strong></td>
                        <td width="31%" ><strong>Audited Accounts</strong></td>
                        <td width="50%" ><strong>Auditor Comments</strong></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="financialStatement"
                               items="${searchDetail.additionalInformation.additionalFinancials.financialStatement}"
                               varStatus="status">
                    <tr>
                        <td >
                            <div align="left">${financialStatement.yearEndDate}</div>
                        </td>
                        <td >
                            <div align="left">${financialStatement.auditedAccounts}</div>
                        </td>
                        <td >
                            <div align="left">${financialStatement.auditorComments}</div>
                        </td>
                    </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>

