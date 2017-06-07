<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<c:if test="${orderDetail.getProductId()=='9'}">

    <div class="tab-pane fade in" id="Registration">

        <table class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <%--<tr>--%>
                <%--<td align="right">&nbsp;</td>--%>
                <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
            <%--</tr>--%>

            <tr>
                <td width="20%" height="35" align="right"><strong>Register Name</strong>
                </td>
                <td colspan="3" style="padding-left:20px">${registrationInfos.registrationEN}</td>
            </tr>
            <tr>
                <td height="35" align="right"><strong>Company Type</strong></td>
                <td colspan="3">
                    <span style="padding-left:20px">${registrationInfos.companyTypeEN}</span>
                </td>
            </tr>
            <tr>
                <td height="35" align="right"><strong>Registration Nr</strong></td>
                <td>
                    <span style="padding-left:20px">${registrationInfos.reg}</span>
                </td>
                <td height="35" align="left" width="15%"><strong>Paid Up Capital</strong>
                </td>
                <td>
                    <span style="padding-left:20px">${registrationInfos.paidCurrencyEN}
                     <c:if test="${registrationInfos.paidCapital !=''}">
                         <fmt:formatNumber value="${registrationInfos.paidCapital}" pattern="#,#00"/>
                     </c:if>
                    </span>
                </td>
            </tr>
            <tr>
                <td height="35" align="right"><strong>Registered Capital</strong></td>
                <td width="30%">
                    <span style="padding-left:20px">${registrationInfos.regCapitalEN}</span>
                </td>
                <td height="35" align="left"  width="15%"><strong>Expiration Date</strong>
                </td>
                <td>
                    <span style="padding-left:20px">${registrationInfos.deadlineEN}</span>
                </td>

            </tr>
            <tr>
                <td height="35" align="right"><strong>Incorporation Date</strong></td>
                <td width="30%">
                    <span style="padding-left:20px">${registrationInfos.establishDate}</span>
                </td>
                <td height="35" align="left" width="15%"><strong>Legal
                    Representative</strong>

                </td>
                <td>
                    <span style="padding-left:20px">${registrationInfos.legalNameEN}</span>
                </td>
            </tr>
            <tr>
                <td height="35" align="right" valign="top"><strong>Registry</strong>
                </td>
                <td colspan="3" valign="top" style="padding-left:20px">${registrationInfos.registrationEN}
                </td>
            </tr>
            <tr>
                <td height="35" align="right" valign="top"><strong>Registered
                    Address</strong>
                </td>
                <td  colspan="3" valign="top" style="padding-left:20px">${registrationInfos.countryEN}${registrationInfos.provinceEN}
                        ${registrationInfos.cityEN}${registrationInfos.districtEN}${registrationInfos.streetEN}
                </td>
            </tr>
            <tr>
                <td height="35" align="right" valign="top"><strong>Business
                    Scope</strong></td>
                <td height="35" colspan="3"
                    style="padding-left:20px">${registrationInfos.businessScopeEN}
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td colspan="4" align="center">&nbsp;</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>

                <%--<td colspan="4" align="center">--%>

                <%--</td>--%>

            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>&nbsp;</td>--%>
                <%--<td>&nbsp;</td>--%>
                <%--<td>&nbsp;</td>--%>
                <%--<td>&nbsp;</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>&nbsp;</td>--%>
                <%--<td>&nbsp;</td>--%>
                <%--<td>&nbsp;</td>--%>
                <%--<td>&nbsp;</td>--%>
            <%--</tr>--%>
            </tbody>
        </table>
            <%--新添加可折叠块--%>
        <div class="panel-group" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="registra88">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#registraOne88"
                           aria-expanded="true"
                           aria-controls="collapseOne">
                            Shareholder（${shareholderInfosList.size()}） </a>
                    </h4>
                </div>
                <div id="registraOne88" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="registra88">
                    <div class="panel-body">
                        <table width="80%"
                               class="table table-hover table-striped table-responsive">
                            <thead>
                            <tr>
                                <th width="9%">Shares</th>
                                <th width="47%">Shareholder Names</th>
                                <th width="22%">Shareholder Capital</th>
                                    <%--<th width="22%">Order</th>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${not empty shareholderInfosList}">
                                <c:forEach items="${shareholderInfosList}" var="list">
                                    <tr>
                                        <td>${list.shares}</td>
                                        <td>${list.nameEN}</td>
                                        <td>${list.capitalContributionEN}
                                            <c:if test="${list.subconam !=''}">
                                                <fmt:formatNumber value="${list.subconam}" pattern="#,#00"/>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="regis8">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#regisOne8"
                           aria-expanded="true"
                           aria-controls="collapseOne">
                            Managerments（${managementsList.size()}） </a>
                    </h4>
                </div>
                <div id="regisOne8" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="regis8">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive">
                            <tbody>
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Position</th>
                                <th>Gender</th>
                                <th>Date of Birth</th>
                            </tr>
                            </thead>
                            <c:if test="${not empty managementsList}">
                                <c:forEach items="${managementsList}" var="list">
                                    <tr>
                                        <td width="25%"><p><strong>${list.nameEN}</strong></p>
                                        </td>
                                        <td width="25%">${list.positionEN}</td>
                                        <td width="25%">
                                            <c:if test="${list.gender==0}">male</c:if>
                                            <c:if test="${list.gender==1}">female</c:if>
                                        </td>
                                        <td width="25%">${list.birthDate}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="tab-pane fade in" id="History">
        <table width="80%" class="table table-hover table-striped table-responsive">
            <thead>
            <tr>
                <th width="10%">Date</th>
                <th width="20%">Changes</th>
                <th width="35%">Before Changes</th>
                <th width="35%">After Changes
                </th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty changeInfosList}">
                <c:forEach items="${changeInfosList}" var="list">
                    <tr>
                        <td>${list.changeDate}</td>
                        <td>${list.changeTypeEN}</td>
                        <td>${list.beforeEN}</td>
                        <td>${list.afterEN}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>

    <div class="tab-pane fade in" id="Related">
        <div class="row">
            <div class="panel-group" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="heading111">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapse111"
                               aria-expanded="true"
                               aria-controls="collapseOne">
                                Foreign investment of
                                enterprises（${entinvinfosList.size()}） </a>
                        </h4>
                    </div>
                    <div id="collapse111" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="heading111">
                        <div class="panel-body">
                            <table class="table table-hover table-striped table-responsive">
                                <thead>
                                <tr>
                                    <th width="28%">Company Name</th>
                                    <th width="8%">Contribution Ratio</th>
                                    <th width="15%">Registered Capital</th>
                                    <th width="12%">Date</th>
                                    <th width="17%">Company Type</th>
                                    <th width="10%">Company Status</th>
                                    <th width="10%">Search</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty entinvinfosList}">
                                    <c:forEach items="${entinvinfosList}" var="list"
                                               varStatus="status">
                                        <tr>
                                            <td><span
                                                    class="formleft"><strong>${list.enterpriseNameEN}</strong></span>
                                            </td>
                                            <td>${list.fundedRatio}</td>
                                            <td>${list.regCapCurEN}
                                                <c:if test="${list.regCap !=''}">
                                                    <fmt:formatNumber value="${list.regCap}" pattern="#,#00"/>
                                                </c:if>
                                            </td>
                                            <td>${list.esDate}</td>
                                            <td>${list.enterpriseTypeEN}</td>
                                            <td>${list.enterpriseStatusEN}</td>
                                            <td><c:if test="${list.enterpriseNameEN.length()>5}">
                                                <button type="button"
                                                        class="btn btn-xs btn-primary"
                                                        onclick="searchCompany('${list.enterpriseNameEN}')">
                                                    Search the Company
                                                </button>
                                            </c:if></td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${ empty entinvinfosList}">
                                    <tr>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="heading144">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                               href="#collapse144"
                               aria-expanded="false" aria-controls="collapseFour">
                                Enterprise branch（${relatedCompaniesList.size()}）
                            </a>
                        </h4>
                    </div>
                    <div id="collapse144" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="heading144">
                        <div class="panel-body">
                            <table class="table table-hover table-striped table-responsive">
                                <thead>
                                <tr>
                                    <th width="28%">Company Name</th>
                                    <th width="8%">Registration Number</th>
                                    <th width="15%">Tel</th>
                                    <th width="12%">Date</th>
                                    <th width="17%">Nature of Company</th>
                                    <th width="10%">Company Status</th>
                                    <th width="10%">Search</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty relatedCompaniesList}">
                                    <c:forEach items="${relatedCompaniesList}" var="list"
                                               varStatus="status">
                                        <tr>
                                            <td><span
                                                    class="formleft"><strong>${list.nameEN}</strong></span>
                                            </td>
                                            <td>${list.reg}</td>
                                            <td>${list.tel}</td>
                                            <td>${list.establishDate}</td>
                                            <td>${list.entNatureEN}</td>
                                            <td>${list.entStatusEN}</td>
                                            <td><c:if test="${list.nameEN.length()>5}">
                                                <button type="button"
                                                        class="btn btn-xs btn-primary"
                                                        onclick="searchCompany('${list.nameEN}')">
                                                    Search the Company
                                                </button>
                                            </c:if></td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${ empty relatedCompaniesList}">
                                    <tr>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="heading333">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                               href="#collapse333"
                               aria-expanded="false" aria-controls="collapseTwo">
                                Corporate foreign investment（${frinvinfosList.size()}）
                            </a>
                        </h4>
                    </div>
                    <div id="collapse333" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="heading333">
                        <div class="panel-body">
                            <table class="table table-hover table-striped table-responsive">
                                <thead>

                                <tr>
                                    <th width="28%">Company Name</th>
                                    <th width="8%">Contribution Ratio</th>
                                    <th width="15%">Registered Capital</th>
                                    <th width="12%">Date</th>
                                    <th width="17%">Company Type</th>
                                    <th width="10%">Company Status</th>
                                    <th width="10%">Search</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty frinvinfosList}">
                                    <c:forEach items="${frinvinfosList}" var="list"
                                               varStatus="status">
                                        <tr>
                                            <td><span
                                                    class="formleft"><strong>${list.enterpriseNameEN}</strong></span>
                                            </td>
                                            <td>${list.fundedRatio}</td>
                                            <td>${list.regCapitalCurrencyEN}
                                                <c:if test="${list.regCapital !=''}">
                                                    <fmt:formatNumber value="${list.regCapital}" pattern="#,#00"/>
                                                </c:if>
                                            </td>
                                            <td>${list.esDate}</td>
                                            <td>${list.enterpriseTypeEN}</td>
                                            <td>${list.enterpriseStatusEN}
                                            </td>
                                            <td><c:if test="${list.enterpriseNameEN.length()>5}">
                                                <button type="button"
                                                        class="btn btn-xs btn-primary"
                                                        onclick="searchCompany('${list.enterpriseNameEN}')">
                                                    Search the Company
                                                </button>
                                            </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${ empty frinvinfosList}">
                                    <tr>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="heading334">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                               href="#collapse334"
                               aria-expanded="false" aria-controls="collapseThree">
                                Legal person outside the Office（${frpositioninfosList.size()}）
                            </a>
                        </h4>
                    </div>
                    <div id="collapse334" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="heading334">
                        <div class="panel-body">
                            <table class="table table-hover table-striped table-responsive">
                                <thead>
                                <tr>
                                    <th width="28%">Company Name</th>
                                    <th width="8%">Contribution Ratio</th>
                                    <th width="15%">Registered Capital</th>
                                    <th width="12%">Date</th>
                                    <th width="17%">Company Type</th>
                                    <th width="10%">Company Status</th>
                                    <th width="10%">Search</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty frpositioninfosList}">
                                    <c:forEach items="${frpositioninfosList}" var="list"
                                               varStatus="status">
                                        <tr>
                                            <td><span
                                                    class="formleft"><strong>${list.enterpriseNameEN}</strong></span>
                                            </td>
                                            <td>${list.fundedRatioEN}</td>
                                            <td>${list.regCapitalCurrencyEN}
                                                <c:if test="${list.regCapital !=''}">
                                                    <fmt:formatNumber value="${list.regCapital}" pattern="#,#00"/>
                                                </c:if>
                                            </td>
                                            <td>${list.esDate}</td>
                                            <td>${list.enterpriseTypeEN}</td>
                                            <td> ${list.enterpriseStatusEN}</td>
                                            <td><c:if test="${list.enterpriseNameEN.length()>5}">
                                                <button type="button"
                                                        class="btn btn-xs btn-primary"
                                                        onclick="searchCompany('${list.enterpriseNameEN}')">
                                                    Search the Company
                                                </button>
                                            </c:if></td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${ empty frpositioninfosList}">
                                    <tr>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="tab-pane fade in" id="Performance">
        <table width="100%" border="0" cellspacing="0" cellpadding="0"
               class="table table-striped table-responsive">
            <tbody>
            <tr>
                <td valign="top" width="23%" class="formleft"><strong>Year</strong></td>
                <c:if test="${not empty financialStatementList}">
                    <c:forEach items="${financialStatementList}" var="list">
                        <td valign="top" class="formright">
                            <div align="right">${list.year}</div>
                        </td>
                    </c:forEach>
                </c:if>
                <c:if test="${empty financialStatementList}">
                    <c:forEach items="${financialStatementList}" var="list">
                        <td width="20%" valign="top" class="formright">
                            <div align="right">-</div>
                        </td>
                    </c:forEach>
                </c:if>
            </tr>
            <tr>
                <td valign="top" class="formleft"><strong>Turnover</strong></td>
                <c:if test="${not empty financialStatementList}">
                    <c:forEach items="${financialStatementList}" var="list">
                        <td valign="top" class="formright">
                            <c:if test="${list.turnover !=''}">
                                <div align="right"><fmt:formatNumber value="${list.turnover}" pattern="#,#00"/></div>
                            </c:if>
                        </td>
                    </c:forEach>
                </c:if>
                <c:if test="${empty financialStatementList}">
                    <c:forEach items="${financialStatementList}" var="list">
                        <td valign="top" class="formright">
                            <div align="right">-</div>
                        </td>
                    </c:forEach>
                </c:if>
            </tr>

            <tr>
                <td valign="top" class="formleft"><strong>Profit Before Tax</strong></td>
                <c:if test="${not empty financialStatementList}">
                    <c:forEach items="${financialStatementList}" var="list">
                        <td valign="top" class="formright">
                            <c:if test="${list.profitBeforeTax !=''}">
                                <div align="right"><fmt:formatNumber value="${list.profitBeforeTax}" pattern="#,#00"/></div>
                            </c:if>
                        </td>
                    </c:forEach>
                </c:if>
                <c:if test="${empty financialStatementList}">
                    <c:forEach items="${financialStatementList}" var="list">
                        <td valign="top" class="formright">
                            <div align="right">-</div>
                        </td>
                    </c:forEach>
                </c:if>
            </tr>


            <tr>
                <td valign="top" class="formleft"><strong>Total Assets</strong></td>
                <c:if test="${not empty financialStatementList}">
                    <c:forEach items="${financialStatementList}" var="list">
                        <td valign="top" class="formright">
                            <c:if test="${list.totalAssets!=''}">
                                <div align="right"><fmt:formatNumber value="${list.totalAssets}" pattern="#,#00"/></div>
                            </c:if>
                        </td>
                    </c:forEach>
                </c:if>
                <c:if test="${empty financialStatementList}">
                    <c:forEach items="${financialStatementList}" var="list">
                        <td valign="top" class="formright">
                            <div align="right">-</div>
                        </td>
                    </c:forEach>
                </c:if>
            </tr>

            <tr>
                <td valign="top" class="formleft"><strong>Paid-up Capital</strong></td>
                <c:if test="${not empty financialStatementList}">
                    <c:forEach items="${financialStatementList}" var="list">
                        <td valign="top" class="formright">
                            <c:if test="${list.paidUpCapital !=''}">
                                <div align="right"><fmt:formatNumber value="${list.paidUpCapital}" pattern="#,#00"/></div>
                            </c:if>
                        </td>
                    </c:forEach>
                </c:if>
                <c:if test="${empty financialStatementList}">
                    <c:forEach items="${financialStatementList}" var="list">
                        <td valign="top" class="formright">
                            <div align="right">-</div>
                        </td>
                    </c:forEach>
                </c:if>
            </tr>



            </tbody>
        </table>


        <p>Note: unit (thousand yuan), currency (RMB)</p>

        <c:if test="${level != '1'}">
        <div  style="background: #0C8BDE;color: #fff;padding:10px 25px 10px 15px;margin-bottom: 10px;overflow: hidden;">
            <div style="float: left;;width: 20%;">Fianncial Ratio</div>
            <table style="float: right;;width: 72%;vertical-align: middle;">
                <tr>
                    <c:if test="${not empty financialRatiosList}">
                        <c:forEach items="${financialRatiosList}" var="list">
                            <td valign="top"  width="30%">
                                <div align="right">${list.year}</div>
                            </td>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty financialRatiosList}">
                        <td valign="top"  width="30%">
                            <div align="right">-</div>
                        </td>
                    </c:if>
                </tr>
            </table>
        </div>
        <div class="panel-group" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading01">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapse01"
                           aria-expanded="true"
                           aria-controls="collapse01">
                            Profitability Ratios
                        </a>
                    </h4>
                </div>
                <div id="collapse01" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="heading01">
                    <div class="panel-body">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0"
                               class="table table-striped table-responsive" style="margin-bottom: 0;">
                            <tbody>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Return on Equity (%) </strong>
                                    <div class="fxq-basic fxq-ratio">
                                        Profit before tax / Equity x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.returnOnEquity}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Return on Assets (%) </strong>
                                    <div class="fxq-basic fxq-ratio">Profit before tax / Total assets  x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>
                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.returnOnAssets}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Profit Margin (%)  </strong>
                                    <div class="fxq-basic fxq-ratio">Profit before tax / Turnover  x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.profitMargin}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Gross Margin (%)</strong>
                                    <div class="fxq-basic fxq-ratio">Gross Margin / Turnover  x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.grossMargin}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading02">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapse02"
                           aria-expanded="true"
                           aria-controls="collapse02">
                            Operating Ratios
                        </a>
                    </h4>
                </div>
                <div id="collapse02" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="heading01">
                    <div class="panel-body">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0"
                               class="table table-striped table-responsive" style="margin-bottom: 0;">
                            <tbody>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Assets Turnover (x)</strong>
                                    <div class="fxq-basic fxq-ratio">Turnover / Total Assets
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.assetsTurnover}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Stock Turnover (x)</strong>
                                    <div class="fxq-basic fxq-ratio">Turnover / Stock
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.stockTurnover}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Sales Period (days)</strong>
                                    <div class="fxq-basic fxq-ratio">Inventory/COGS*365
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.collectionPeriod}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Collection Period (days)</strong>
                                    <div class="fxq-basic fxq-ratio">Account Receivable/Sales*365
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                </td>
                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.creditPeriod}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Credit Period (days) </strong>
                                    <div class="fxq-basic fxq-ratio">Account Payable/Sales*365
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.salesPeriod}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading03">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapse03"
                           aria-expanded="true"
                           aria-controls="collapse03">
                            Structure Ratios
                        </a>
                    </h4>
                </div>
                <div id="collapse03" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="heading01">
                    <div class="panel-body">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0"
                               class="table table-striped table-responsive" style="margin-bottom: 0;">
                            <tbody>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Current Ratio (x) </strong>
                                    <div class="fxq-basic fxq-ratio">Current Asset / Current Liabilities
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.currentRato}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Quick Ratio (x)</strong>
                                    <div class="fxq-basic fxq-ratio">
                                        (Current Assets - Stocks) / Current Liabilities
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.quickRatio}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Shareholders Liquidity Ratio(x)</strong>
                                    <div class="fxq-basic fxq-ratio">Shareholders Funds / Long-term Liabilities
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.shareholdersLiquidityRato}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Solvency Ratio (%)</strong>
                                    <div class="fxq-basic fxq-ratio">Shareholders Funds / Total Assets  x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.solvencyRatio}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Debt Ratio (%) </strong>
                                    <div class="fxq-basic fxq-ratio">Debts / Equity  x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.debtRatio}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading04">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapse04"
                           aria-expanded="true"
                           aria-controls="collapse04">
                            Productivity Ratios
                        </a>
                    </h4>
                </div>
                <div id="collapse04" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="heading01">
                    <div class="panel-body">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0"
                               class="table table-striped table-responsive" style="margin-bottom: 0;">
                            <tbody>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Profit Per Employee (th)</strong>
                                    <div class="fxq-basic fxq-ratio">Profit / Employees 
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                </td>
                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.profitPerEmployee}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Operating Revenue Per Employee(th)</strong>
                                    <div class="fxq-basic fxq-ratio">Operating Revenue /Employees
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.operatingRevenuePerEmployee}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Shareholders Funds Per Employee(th)</strong>
                                    <div class="fxq-basic fxq-ratio">Equity /Employees
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.shareholderFundsPerEmployess}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Total Assets Per Employee(th)</strong>
                                    <div class="fxq-basic fxq-ratio">Total Assets /Employees
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div></div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.totalAssetsPerEmployee}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading05">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapse05"
                           aria-expanded="true"
                           aria-controls="collapse05">
                            Growth Ratios
                        </a>
                    </h4>
                </div>
                <div id="collapse05" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="heading01">
                    <div class="panel-body">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0"
                               class="table table-striped table-responsive" style="margin-bottom: 0;">
                            <tbody>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Sales Growth Rate (%)</strong>
                                    <div class="fxq-basic fxq-ratio">(Yr1 Sales - Yr2 Sales) /Yr2 Sales x 100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.salesGrowthRate}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Net Profit Growth Rate (%)</strong>
                                    <div class="fxq-basic fxq-ratio">(Yr1 Net profit - Yr2 Net profit) /Yr2 Net profit x 100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                </td>
                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.netprofitGrowthRate}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Total Assets Growth Rate (%)</strong>
                                    <div class="fxq-basic fxq-ratio">(Yr1 Total Assets - Yr2 Total Assets) /Yr2 Total Assets x 100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

                                </td>
                                <c:if test="${not empty financialRatiosList}">
                                    <c:forEach items="${financialRatiosList}" var="list">
                                        <td valign="top" class="formright">
                                            <div align="right">${list.totalAssetsGrowthRate}</div>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financialRatiosList}">
                                    <td valign="top" class="formright">
                                        <div align="right">-</div>
                                    </td>
                                </c:if>
                            </tr>
                            <tr>
                                <td colspan="4" style="color: #878787;font-size: 12px;">
                                    Note: Please see enclosed for detail ratio formula.
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
        </c:if>
    </div>

    <div class="tab-pane fade in" id="Public_record">
        <table class="table table-hover table-striped table-responsive ">
            <thead>
            <tr>
                <th width="25%">Year</th>
                <th>2017</th>
                <th>2016</th>
                <th>2015</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td width="25%">Credit Record</td>
                <td><strong><span
                        class="formleft">0 records</span></strong>
                </td>
                <td><strong>0 records</strong></td>
                <td><strong>0 records</strong></td>
            </tr>
            <tr>
                <td width="25%">Taxes Owed</td>
                <td><strong><span
                        class="formleft">0 records</span></strong>
                </td>
                <td><strong>0 records</strong></td>
                <td><strong>0 records</strong></td>
            </tr>
            <tr>
                <td width="25%">Bankruptcy</td>
                <td><strong><span
                        class="formleft">0 records</span></strong>
                </td>
                <td><strong>0 records</strong></td>
                <td><strong>0 records</strong></td>
            </tr>
            <tr>
                <td width="25%">Open Litigation</td>
                <td><strong><span
                        class="formleft">${Ktgg2017==null?0:Ktgg2017} records</span></strong>
                </td>
                <td><strong>${Ktgg2016==null?0:Ktgg2016} records</strong></td>
                <td><strong>${Ktgg2015==null?0:Ktgg2015} records</strong></td>
            </tr>
            <tr>
                <td width="25%">Judgments</td>
                <td><strong><span
                        class="formleft">${Cpws2017==null?0:Cpws2017} records</span></strong>
                </td>
                <td><strong>${Cpws2016==null?0:Cpws2016} records</strong></td>
                <td><strong>${Cpws2015==null?0:Cpws2015} records</strong></td>
            </tr>
            <tr>
                <td width="25%">Enforcement Records</td>
                <td><strong><span
                        class="formleft">${Zxgg2017==null?0:Zxgg2017} records</span></strong>
                </td>
                <td><strong>${Zxgg2016==null?0:Zxgg2016} records</strong></td>
                <td><strong>${Zxgg2015==null?0:Zxgg2015} records</strong></td>
            </tr>
            <tr>
                <td width="25%">The faithless persons
                    subjected to execution
                </td>
                <td><strong><span
                        class="formleft">${Sxgg2017==null?0:Sxgg2017} records</span></strong>
                </td>
                <td><strong>${Sxgg2016==null?0:Sxgg2016} records</strong></td>
                <td><strong>${Sxgg2015==null?0:Sxgg2015} records</strong></td>
            </tr>
            </tbody>
        </table>
        <p>Note: record does not represent all records
        </p>

        <c:forEach items="${ktggList}" var="list" begin="0" end="2">
            <tr name="开庭公告">
                <td>${list.sortTime}</td>
                <td>
                    <table class="table table-hover table-striped table-responsive">
                        <tr>
                            <td width="6%" bgcolor="#eef1f3">Type</td>
                            <td width="12%">Open Litigation</td>
                            <td width="6%" bgcolor="#eef1f3">Court</td>
                            <td width="19%">${list.courthouseEN}</td>
                            <td width="6%" bgcolor="#eef1f3">Reference Number</td>
                            <td width="26%">${list.docketNoEN}</td>
                            <td width="6%" bgcolor="#eef1f3">Date</td>
                            <td width="19%">${list.sortTime}</td>
                        </tr>
                        <tr>
                            <td bgcolor="#eef1f3">About&nbsp;</td>
                            <td colspan="5">-</td>
                        </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
        </c:forEach>
        <c:forEach items="${rulingdocumentsList}" var="list" begin="0" end="2">
            <tr name="裁判文书">
                <td>${list.sortTime}</td>
                <td>
                    <table class="table table-hover table-striped table-responsive">
                        <tr>
                            <td width="6%" bgcolor="#eef1f3">Type</td>
                            <td width="12%">Judgments</td>
                            <td width="6%" bgcolor="#eef1f3">Court</td>
                            <td width="19%">${list.courtNameEN}</td>
                            <td width="6%" bgcolor="#eef1f3">Reference Number</td>
                            <td width="26%">${list.docketNoEN}</td>
                            <td width="6%" bgcolor="#eef1f3">Date</td>
                            <td width="19%">${list.sortTime}</td>
                        </tr>
                        <tr>
                            <td bgcolor="#eef1f3">About&nbsp;</td>
                            <td colspan="5">-</td>
                        </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
        </c:forEach>
        <c:forEach items="${executiveList}" var="list" begin="0" end="2">
            <tr name="执行公告">
                <td>${list.sortTime}</td>
                <td>
                    <table class="table table-hover table-striped table-responsive">
                        <tr>
                            <td width="6%" bgcolor="#eef1f3">Type</td>
                            <td width="12%">Enforcement Records</td>
                            <td width="6%" bgcolor="#eef1f3">Court</td>
                            <td width="19%">${list.enterpriseCourtNameEN}
                            </td>
                            <td width="6%" bgcolor="#eef1f3">Reference Number</td>
                            <td width="26%">${list.docketNoEN}</td>
                            <td width="6%" bgcolor="#eef1f3">Date</td>
                            <td width="19%">${list.sortTime}
                            </td>
                        </tr>
                        <tr>
                            <td bgcolor="#eef1f3">About&nbsp;</td>
                            <td colspan="5">-</td>
                        </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
        </c:forEach>
        <c:forEach items="${sxggList}" var="list" begin="0" end="2">
            <tr name="失信公告">
                <td>
                    <table class="table table-hover table-striped table-responsive">
                        <tr>
                            <td width="6%" bgcolor="#eef1f3">Type</td>
                            <td width="12%">The faithless persons
                                subjected to execution
                            </td>
                            <td width="6%" bgcolor="#eef1f3">Court</td>
                            <td width="19%">${list.entCourtNameEN}</td>
                            <td width="6%" bgcolor="#eef1f3">Reference Number</td>
                            <td width="26%">${list.docketNoEN}</td>
                            <td width="6%" bgcolor="#eef1f3">Date</td>
                            <td width="19%">${list.sortTime}</td>
                        </tr>
                        <tr>
                            <td bgcolor="#eef1f3">About&nbsp;</td>
                            <td colspan="5">-</td>
                        </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
        </c:forEach>

    </div>

    <div class="tab-pane fade in" id="Credit_rating">
        <div class="slimScrollBar">
            <div class="scrollable">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table table-hover table-striped table-responsive">
                    <tbody>
                    <tr>
                        <td colspan="6" align="center" style="padding: 15px 0;background: #fff;"><img
                                src="${pageContext.request.contextPath}/images/creditRatingEN/0.jpg"
                                width="100%"
                                alt=""/>
                        </td>
                    </tr>
                    <tr >
                        <td><strong>Solvency Index</strong></td>
                        <td>-</td>
                    </tr>
                    <tr>
                        <td ><strong>Risk Assessment</strong></td>
                        <td >-</td>
                    </tr>
                    <tr>
                        <td><strong>Recommended Line</strong></td>
                        <td>-</td>
                    </tr>

                    <tr>
                        <td colspan="6" style="color: #878787;font-size: 12px;font-style: italic">
                            Note:
                            <p style="width: 93%;float:right;padding-right: 20px;">
                                In accordance with “Measures of the Customs of the People's Republic of China for the
                                Classified Management of Enterprises” published on April 1st,2008, the followings are the
                                Company Category Definition by General Customs:
                                <br>AA: Excellent
                                <br>A: Good
                                <br>B: Average
                                <br>C: Fairly Poor
                                <br>D: Very Poor
                            </p>
                        </td>
                    </tr>

                    </tbody>
                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table table-hover table-striped table-responsive">
                    <tbody>

                    <tr>
                        <td style="color: #878787;font-size: 12px;font-style: italic;padding-top:10px">
                            Note:
                            <p style="width: 93%;float:right;padding-right: 20px;margin-bottom:0">
                                This is just a credit opinion formed based on the information collected in this report.
                                The actual credit decision would vary and determined by the user based on company’s credit policy,
                                risk management strategy, actual situation, and many other circumstances.
                                This report is just for your reference.
                            </p>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="tab-pane fade in" id="Industry">
        <div class="row">
            <div class="panel-group" role="tablist" aria-multiselectable="true">
                    <%--Current Operation--%>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="fxqOne9">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#current9"
                               aria-expanded="true"
                               aria-controls="currentOne">
                                Current Operations </a>
                        </h4>
                    </div>
                    <div id="current9" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqOne9">
                        <div class="panel-body">
                            <table class="table table-hover table-striped table-responsive fxq-report-table">
                                <tbody>
                                <tr>
                                    <td width="15%" rowspan="6"    >Business:</td>
                                    <td width="20%">Operational Status:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Main Business: </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Main Products:  </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Production:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Main Activity: </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Info from Internet:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td  width="15%" rowspan="6"    >Territories: </td>
                                    <td width="20%">Purchase:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Domestic:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">International:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Sales:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Domestic:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">International:</td>
                                    <td>-</td>
                                </tr>
                                <td  width="15%"    >Import: </td>
                                <td width="20%">Purchase:</td>
                                <td>-</td>
                                </tr>
                                <tr>
                                    <td  width="15%"    >Export: </td>
                                    <td width="20%">Purchase:</td>
                                    <td>-</td>
                                </tr>

                                <tr>
                                    <td  width="15%" rowspan="5"    >Terms:  </td>
                                    <td width="20%">Purchase:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Domestic:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Sales:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Domestic:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Foreign:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Certification:</td>
                                    <td colspan="2">-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Employees:</td>
                                    <td colspan="2">-</td>
                                </tr>

                                <tr>
                                    <td  width="15%" rowspan="4"    >Facility:  </td>
                                    <td width="20%">Premise:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Location:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Size:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%">Ownership:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Location:</td>
                                    <td colspan="2">-</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                    <%--Import&Export--%>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="fxqtwo9">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#import9"
                               aria-expanded="true"
                               aria-controls="currentOne">
                                Import & Export </a>
                        </h4>
                    </div>
                    <div id="import9" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqtwo9">
                        <div class="panel-body">
                            <table class="table table-hover table-striped table-responsive fxq-report-table">
                                <tbody>
                                <tr>
                                    <td width="15%"    >Customer Nr:</td>
                                    <td>--</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Clearance Type: </td>
                                    <td>--</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Co Category: </td>
                                    <td>--</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Reg. Expiration:</td>
                                    <td>--</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Comments: </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="color: #878787;font-size: 12px;font-style: italic">
                                        Note:
                                        <p style="width: 93%;float:right;padding-right: 20px;">
                                            In accordance with “Measures of the Customs of the People's Republic of China for the
                                            Classified Management of Enterprises” published on April 1st,2008, the followings are the
                                            Company Category Definition by General Customs:
                                            <br>AA: Excellent
                                            <br>A: Good
                                            <br>B: Average
                                            <br>C: Fairly Poor
                                            <br>D: Very Poor
                                        </p>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                    <%--Industry--%>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="fxqthr9">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#industryblock9"
                               aria-expanded="true"
                               aria-controls="currentOne">
                                Industry </a>
                        </h4>
                    </div>
                    <div id="industryblock9" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqthr9">
                        <div class="panel-body">
                            <table class="table table-hover table-striped table-responsive fxq-report-table">
                                <tbody>
                                <tr>
                                    <td width="20%"    >Chinese (CSIC): </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%"    >American (ISIC): </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%"    >European (NACE): </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%"    >Industry Description: </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="20%"    >Industry Overview:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="color: #878787;font-size: 12px;font-style: italic">
                                        Note:
                                        <p style="width: 93%;float:right;padding-right: 20px;">
                                            In accordance with “Measures of the Customs of the People's Republic of China for the
                                            Classified Management of Enterprises” published on April 1st,2008, the followings are the
                                            Company Category Definition by General Customs:
                                        </p>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                    <%--Bank Reference--%>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="fxqfour9">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#bank9"
                               aria-expanded="true"
                               aria-controls="currentOne">
                                Bank Reference </a>
                        </h4>
                    </div>
                    <div id="bank9" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqfour9">
                        <div class="panel-body">
                            <table class="table table-hover table-striped table-responsive fxq-report-table">
                                <tbody>
                                <tr>
                                    <td width="15%"    >Bank Name:  </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Bank Address:  </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Account Nr:  </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Phone:</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Banker </td>
                                    <td>--</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                    <%--Payment History--%>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="fxqfive9">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#payment9"
                               aria-expanded="true"
                               aria-controls="currentOne">
                                Payment History </a>
                        </h4>
                    </div>
                    <div id="payment9" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqfive9">
                        <div class="panel-body">
                            <table class="table table-hover table-striped table-responsive fxq-report-table">
                                <tbody>
                                <tr>
                                    <td width="15%"    >Company Name:   </td>
                                    <td>-</td>
                                    <td width="15%"    >Crefo Nr.:   </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Interview:  </td>
                                    <td>-</td>
                                    <td width="15%"    >Phone:  </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Main Activities:   </td>
                                    <td colspan="3">-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Payment Mode:</td>
                                    <td colspan="3">-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Delinquent:</td>
                                    <td colspan="3">-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Debt Collection: </td>
                                    <td colspan="3">--</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                    <%--Trade Reference--%>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="fxqsix9">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#trade9"
                               aria-expanded="true"
                               aria-controls="currentOne">
                                Trade Reference </a>
                        </h4>
                    </div>
                    <div id="trade9" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqsix9">
                        <div class="panel-body">
                            <table class="table table-hover table-striped table-responsive fxq-report-table">
                                <tbody>
                                <tr>
                                    <td width="15%"    >Company Name:   </td>
                                    <td>-</td>
                                    <td width="15%"    >Crefo Nr.:   </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Phone:   </td>
                                    <td>-</td>
                                    <td width="15%"    >Relationship:   </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Comments:    </td>
                                    <td colspan="3">-</td>
                                </tr>
                                <tr>
                                    <td colspan="4" style="background: #fff"></td>
                                </tr>

                                <tr>
                                    <td width="15%"    >Company Name:   </td>
                                    <td>-</td>
                                    <td width="15%"    >Crefo Nr.:   </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Phone:   </td>
                                    <td>-</td>
                                    <td width="15%"    >Relationship:   </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Comments:    </td>
                                    <td colspan="3">-</td>
                                </tr>
                                <tr>
                                    <td colspan="4" style="background: #fff"></td>
                                </tr>

                                <tr>
                                    <td width="15%"    >Company Name:   </td>
                                    <td>-</td>
                                    <td width="15%"    >Crefo Nr.:   </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Phone:   </td>
                                    <td>-</td>
                                    <td width="15%"    >Relationship:   </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Comments:    </td>
                                    <td colspan="3">-</td>
                                </tr>
                                <tr>
                                    <td colspan="4" style="background: #fff"></td>
                                </tr>

                                <tr>
                                    <td width="15%"    >Company Name:   </td>
                                    <td>-</td>
                                    <td width="15%"    >Crefo Nr.:   </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Phone:   </td>
                                    <td>-</td>
                                    <td width="15%"    >Relationship:   </td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td width="15%"    >Comments:    </td>
                                    <td colspan="3">-</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</c:if>

<script>
    $(function(){
        var num=1;
        $("#money").click(function(){

            if(num==1){
                $(this).text("$");
                num=2;
            }else if(num==2){
                $(this).text("€");
                num=3;
            }else{
                $(this).text("￥");
                num=1;
            }
        })
    })
</script>