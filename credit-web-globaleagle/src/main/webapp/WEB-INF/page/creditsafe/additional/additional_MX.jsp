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
                    Misc </a>
            </h4>
        </div>
        <div id="addtional1" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Revenue Range</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.revenueRange}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Fax Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.faxNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Contact Person</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.misc.contactPerson}</div>
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
                    Professional Profile (professional/person companies only) </a>
            </h4>
        </div>
        <div id="addtional2" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td width="23%" class="formleft"><strong>Full Name</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.professionalProfile.fullName}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Gender</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.professionalProfile.gender}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Professional Title</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.professionalProfile.professionalTitle}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Field</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.professionalProfile.field}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Year of Registration</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.professionalProfile.yearOfRegistration}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Professional Number</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.professionalProfile.professionalNumber}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>School</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.professionalProfile.school}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>State</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.professionalProfile.state}</div>
                        </td>
                    </tr>
                    <tr>
                        <td width="23%" class="formleft"><strong>Level</strong></td>
                        <td width="77%" class="formright">
                            <div align="left">${searchDetail.additionalInformation.professionalProfile.level}</div>
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
                    Key Personnel </a>
            </h4>
        </div>
        <div id="addtional3" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="33%">Forename</th>
                        <th width="33%">Family Name</th>
                        <th width="33%">Last Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="keyPersonnel"
                               items="${searchDetail.additionalInformation.keyPersonnels.keyPersonnel}"
                               varStatus="status">
                        <tr>
                            <td>${keyPersonnel.forename}</td>
                            <td>${keyPersonnel.familyName}</td>
                            <td>${keyPersonnel.lastName}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.keyPersonnels.keyPersonnel}">
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
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional4"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Commercial Vehicles </a>
            </h4>
        </div>
        <div id="addtional4" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="15%">ForenCertificationame</th>
                        <th width="15%">Class</th>
                        <th width="15%">Fuel</th>
                        <th width="10%">Make</th>
                        <th width="15%">Powered or Trailer</th>
                        <th width="10%">Short Class</th>
                        <th width="10%">Tag</th>
                        <th width="10%">Year</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="commercialVehicle"
                               items="${searchDetail.additionalInformation.commercialVehicles.commercialVehicle}"
                               varStatus="status">
                        <tr>
                            <td>${commercialVehicle.certification}</td>
                            <td>${commercialVehicle.class}</td>
                            <td>${commercialVehicle.fuel}</td>
                            <td>${commercialVehicle.make}</td>
                            <td>${commercialVehicle.poweredOrTrailer}</td>
                            <td>${commercialVehicle.shortClass}</td>
                            <td>${commercialVehicle.tag}</td>
                            <td>${commercialVehicle.year}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.commercialVehicles.commercialVehicle}">
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional5"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Commercial Vehicles </a>
            </h4>
        </div>
        <div id="addtional5" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%">Published Date</th>
                        <th width="15%">Court Details</th>
                        <th width="10%">Court Local Name</th>
                        <th width="15%">Docket</th>
                        <th width="10%">Adverse Party</th>
                        <th width="10%">Defendant Name</th>
                        <th width="10%">Nature</th>
                        <th width="10%">Defendant RFC</th>
                        <th width="10%">Location</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.negativeInformation.insolvencyEvents.event}"
                               varStatus="status">
                        <tr>
                            <td>${event.publishedDate}</td>
                            <td>${event.courtDetails}</td>
                            <td>${event.courtLocalName}</td>
                            <td>${event.docket}</td>
                            <td>${event.adverseParty}</td>
                            <td>${event.defendantName}</td>
                            <td>${event.nature}</td>
                            <td>${event.defendantRFC}</td>
                            <td>${event.location}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.insolvencyEvents.event}">
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
    <div class="panel-heading" role="tab" >
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#addtional6"
               aria-expanded="true"
               aria-controls="collapseOne">
                Concursos Events </a>
        </h4>
    </div>
    <div id="addtional6" class="panel-collapse collapse" role="tabpanel"
         aria-labelledby="headingOne">
        <div class="panel-body">
            <table class="table table-hover table-bordered table-responsive">
                <thead>
                <tr>
                    <th width="10%">Date</th>
                    <th width="15%">Status</th>
                    <th width="10%">Insolvent Party</th>
                    <th width="15%">Creditor</th>
                    <th width="10%">Registar</th>
                    <th width="10%">City</th>
                    <th width="10%">Court Name</th>
                    <th width="10%">Docket</th>
                    <th width="10%">Referee</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="event"
                           items="${searchDetail.additionalInformation.negativeInformation.concursosEvents.event}"
                           varStatus="status">
                    <tr>
                        <td>${event.date}</td>
                        <td>${event.status}</td>
                        <td>${event.insolventParty}</td>
                        <td>${event.creditor}</td>
                        <td>${event.registar}</td>
                        <td>${event.city}</td>
                        <td>${event.courtName}</td>
                        <td>${event.docket}</td>
                        <td>${event.referee}</td>
                    </tr>
                </c:forEach>
                <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.insolvencyEvents.event}">
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
        <div class="panel-heading" role="tab" >
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional7"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    Federal Litigation </a>
            </h4>
        </div>
        <div id="addtional7" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="20%">Published Date</th>
                        <th width="20%">Court Details</th>
                        <th width="20%">Local Court Name</th>
                        <th width="20%">Docket</th>
                        <th width="20%">Adverse Party</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.negativeInformation.federalLitigation.event}"
                               varStatus="status">
                        <tr>
                            <td>${event.publishedDate}</td>
                            <td>${event.courtDetails}</td>
                            <td>${event.courtLocalName}</td>
                            <td>${event.docket}</td>
                            <td>${event.adverseParty}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.federalLitigation.event}">
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
                <a data-toggle="collapse" data-parent="#accordion" href="#addtional8"
                   aria-expanded="true"
                   aria-controls="collapseOne">
                    State Litigation </a>
            </h4>
        </div>
        <div id="addtional8" class="panel-collapse collapse" role="tabpanel"
             aria-labelledby="headingOne">
            <div class="panel-body">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <tr>
                        <th width="10%">Location</th>
                        <th width="10%">Published Date</th>
                        <th width="10%">Court Details</th>
                        <th width="10%">Local Court Name</th>
                        <th width="10%">Docket</th>
                        <th width="10%">Caption</th>
                        <th width="10%">Nature</th>
                        <th width="10%">Subject</th>
                        <th width="10%">Plaintiff</th>
                        <th width="10%">Defendant</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="event"
                               items="${searchDetail.additionalInformation.negativeInformation.stateLitigation.event}"
                               varStatus="status">
                        <tr>
                            <td>${event.location}</td>
                            <td>${event.publishedDate}</td>
                            <td>${event.courtDetails}</td>
                            <td>${event.courtLocalName}</td>
                            <td>${event.docket}</td>
                            <td>${event.caption}</td>
                            <td>${event.nature}</td>
                            <td>${event.subject}</td>
                            <td>${event.plaintiff}</td>
                            <td>${event.defendant}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${ empty searchDetail.additionalInformation.negativeInformation.stateLitigation.event}">
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
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
