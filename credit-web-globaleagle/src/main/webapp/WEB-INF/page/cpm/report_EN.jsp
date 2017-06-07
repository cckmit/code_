<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>${companyName}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <script src="<%=basePath%>frame/jquery-1.10.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/htmlSaveAs.js"></script>

    <script type="text/javascript">
        var sendUrl = '';
        $(document).ready(function () {
            test = document.getElementsByTagName('html')[0].outerHTML;
            email = "${email}";
            crefoNo = "${crefoNo}";
            customerId = "${customerId}";
            orderDetailId = "${orderDetailId}";
            sendUrl = "<%=basePath%>customer/html/viewReportV1.do";
        });
        function searchCompany(companyName) {
            window.open(basePath + "toSearchCompanyList.do?countryName=中国&companyName=" + companyName, "_blank");
        }

        function credit() {
            window.open(basePath + "toIndexAddition1.do?country=" + '${cnName}' + "&companyName=" + '${companyName}' + "&companyPhone=" + '${basic.tel}' + "&companyWebsite=" + '${basic.website}' + "&companyEmail=" + '${basic.email}' + "&companyAdd=" + '${basic.addressCN}', "_blank");
        }

    </script>

</head>
<body>
<jsp:include page="../include/report/top2.jsp"/>
<jsp:include page="../user/collectionInfoList.jsp"/>

<div class="container">


    <div class="row">

        <div class="bs-component">
            <ul class="nav nav-tabs">
                <li class="active"><a aria-expanded="false" href="#home" data-toggle="tab">公司概况</a></li>
                <li class=""><a aria-expanded="true" href="#tab02" data-toggle="tab">基本信息</a></li>
                <li class=""><a aria-expanded="true" href="#tab03" data-toggle="tab">管理人员</a></li>
                <li class=""><a aria-expanded="true" href="#tab04" data-toggle="tab">关联公司</a></li>
                <li class=""><a aria-expanded="true" href="#tab05" data-toggle="tab">财务数据</a></li>
                <li class=""><a aria-expanded="true" href="#tab07" data-toggle="tab">负面信息</a></li>
                <li class=""><a aria-expanded="true" href="#tab08" data-toggle="tab">运营信息</a></li>
                <li class=""><a aria-expanded="true" href="#tab10" data-toggle="tab">支付信息</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="home">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td width="20%" class="formleft"><strong>Business Name</strong></td>
                            <td colspan="3" class="formright">
                                <div align="left">${basicInfos.get(0).businessComName}</div>
                                <div align="left"></div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Registered Name</strong></td>
                            <td colspan="3" class="formright">
                                <div align="left">${basicInfos.get(0).regComName}</div>
                                <div align="left"></div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft">&nbsp;</td>
                            <td width="30%" valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                            <td width="10%" class="formleft">&nbsp;</td>
                            <td width="30%" valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="formleft">&nbsp;</td>
                            <td class="formright">&nbsp;</td>
                            <td class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Main Address</strong></td>
                            <td class="formright">${basicInfos.get(0).contactAddress}</td>
                            <td class="formleft"><strong>Post</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${basicInfos.get(0).contatctPostalCode}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>States/City</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${basicInfos.get(0).contatctProvince}/${basicInfos.get(0).contactCity}</div>
                            </td>
                            <td class="formleft"><strong>Phone</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${basicInfos.get(0).contactTel}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Website</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">
                                    <div align="left"><a href="http://${basicInfos.get(0).website}"
                                                         target="_parent">${basicInfos.get(0).website}</a></div>
                                </div>
                            </td>
                            <td class="formleft"><strong>Email</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">
                                    <div align="left">${basicInfos.get(0).email}</div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft">&nbsp;</td>
                            <td class="formright">&nbsp;</td>
                            <td class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">&nbsp;</td>
                        </tr>
                        </tbody>
                    </table>
                    <img style="display:block;width:100%;"
                         src="${pageContext.request.contextPath}/images/creditRatingEN/<c:if test="${empty financialStatement.get(0).currProviderValue}">0</c:if>${financialStatement.get(0).currProviderValue}.jpg"/>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td width="20%" class="formleft">&nbsp;</td>
                            <td width="30%" class="formright">&nbsp;</td>
                            <td width="20%" class="formleft">&nbsp;</td>
                            <td width="30%" valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>Status</strong></td>
                            <td class="formright">
                                <div align="left">${searchDetail.companySummary.companyStatus.value}</div>
                            </td>
                            <td class="formleft"><strong>Score</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companySummary.creditRating.commonValue.value()}</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Registration ID </strong></td>
                            <td valign="top" class="formright">
                                <div align="left"> ${searchDetail.companyIdentification.basicInformation.companyRegistrationNumber} </div>
                            </td>
                            <td class="formleft"><strong>Rating</strong></td>
                            <td valign="top" class="formright"><c:if
                                    test="${searchDetail.companySummary.creditRating.commonValue.value() == 'A'}">
                                Very Low Risk
                            </c:if>
                                <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'B'}">
                                    Low Risk
                                </c:if>
                                <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'C'}">
                                    Moderate Risk
                                </c:if>
                                <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'D'}">
                                    High Risk
                                </c:if>
                                <c:if test="${searchDetail.companySummary.creditRating.commonValue.value() == 'E'}">
                                    Very High Risk
                                </c:if></td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>Main Activity Description</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${searchDetail.companySummary.mainActivity.activityDescription}</div>
                            </td>
                            <td valign="top" class="formleft"><strong>Recommended
                                Credit</strong></td>
                            <td valign="top"
                                class="formright">${searchDetail.companySummary.creditRating.creditLimit.value} </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <div class="tab-pane fade " id="tab02">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td width="12%" class="formleft"><strong>法定代表人</strong></td>
                            <td width="38%" class="formright">${registrationInfos.get(0).legalNameEN}</td>
                            <td width="12%" class="formleft"><strong>企业现状</strong></td>
                            <td width="38%" valign="top" class="formright">
                                <div align="left">${registrationInfos.get(0).csid}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>企业性质</strong></td>
                            <td valign="top" class="formright">${registrationInfos.get(0).cpid}</td>
                            <td class="formleft"><strong>企业类型</strong></td>
                            <td valign="top" class="formright">${registrationInfos.get(0).ctid}</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>注册资本</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${registrationInfos.get(0).paidCapital}</div>
                            </td>
                            <td class="formleft"><strong>统一征信码</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>注册日期</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${basicInfos.get(0).regDate}</div>
                            </td>
                            <td class="formleft"><strong>经营期限</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">${basicInfos.get(0).deadline}</div>
                            </td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>注册地址</strong></td>
                            <td class="formright">
                                <div align="left">
                                    ${basicInfos.get(0).regAddress}
                                </div>
                            </td>
                            <td class="formleft"><strong>注册登记机关</strong></td>
                            <td valign="top" class="formright">-</td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>经营范围</strong></td>
                            <td colspan="3" valign="top" class="formright">
                                <div align="left">${registrationInfos.get(0).businessScopeEN}</div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">
                                <div align="left"></div>
                            </td>
                            <td valign="top" class="formleft">&nbsp;</td>
                            <td valign="top" class="formright">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">
                                <table class="table table-hover table-bordered table-responsive">
                                    <thead>
                                    <tr>
                                        <th width="12%">变更日期</th>
                                        <th width="18%">变更类型</th>
                                        <th width="35%">变更前</th>
                                        <%--<th width="35%">变更后</th>--%>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${not empty changeInfosList}">
                                        <c:forEach items="${changeInfosList}" var="list">
                                            <tr>
                                                <td>${list.changeDate}</td>
                                                <td>${list.changeType}</td>
                                                <td>
                                                    <c:if test="${list.changeType=='1'}">
                                                        ${list.previousName}
                                                    </c:if>
                                                    <c:if test="${list.changeType=='2'}">
                                                        ${list.previousCommonCode}
                                                    </c:if>
                                                    <c:if test="${list.changeType=='3'}">
                                                        ${list.previousAddress}
                                                    </c:if>
                                                </td>
                                                    <%--<td>${list.afterCN}</td>--%>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${ empty changeInfosList}">
                                        <tr>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                                <%--<td>-</td>--%>
                                        </tr>
                                    </c:if>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="4" valign="top">&nbsp;</td>
                        </tr>
                        </tbody>
                    </table>


                </div>

                <div class="tab-pane fade" id="tab03">
                    <div class="panel-group" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading21">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse21"
                                       aria-expanded="true"
                                       aria-controls="collapse21">
                                        Directors / Managers（
                                        <c:if test="${empty managementsList.size()}">0</c:if>
                                        ${managementsList.size()}
                                        ） </a>
                                </h4>
                            </div>
                            <div id="collapse21" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading21">
                                <div class="panel-body">
                                    <table width="100%" class="table table-hover table-bordered table-responsive">
                                        <thead>
                                        <tr>
                                            <th width="16%"><strong>Name</strong></th>
                                            <th width="10%"><span class="formleft"><strong>Position </strong></span>
                                            </th>
                                            <th width="22%"><span class="formleft"><strong>Address </strong></span>
                                            </th>
                                            <th width="10%"><span class="formleft"><strong>City </strong></span>
                                            </th>
                                            <th width="14%"><span
                                                    class="formleft"><strong>Street </strong></span></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="director" items="${managementsList}" varStatus="status">
                                            <tr>
                                                <td><strong>${director.name}</strong></td>
                                                <td>${director.position}</td>
                                                <td>${director.address}</td>
                                                <td>${director.city}</td>
                                                <td>${director.street}</td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="tab-pane fade" id="tab04">
                    <div class="panel-group" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                       aria-expanded="true"
                                       aria-controls="collapseOne">
                                        Related Companies（
                                        <c:if test="${empty relatedCompanies}">0</c:if>
                                        ${relatedCompanies.size()}） </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="headingOne">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <thead>
                                        <tr>
                                            <th width="28%">公司名称</th>
                                            <th width="8%">公司类型</th>
                                            <th width="15%">状态</th>
                                            <th width="12%">注册号码</th>
                                            <th width="17%">税号</th>
                                            <th width="10%">地址</th>
                                            <th width="10%">查询</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:if test="${not empty relatedCompanies}">
                                            <c:forEach items="${relatedCompanies}" var="list" varStatus="status">
                                                <tr>
                                                    <td><span class="formleft"><strong>${list.name}</strong></span>
                                                    </td>
                                                    <td>${list.type}</td>
                                                    <td>${list.status}</td>
                                                    <td>${list.regCode}</td>
                                                    <td>${list.vatCode}</td>
                                                    <td>${list.address}</td>
                                                    <td><c:if test="${list.name.length()>7}">
                                                        <button type="button" class="btn btn-xs btn-primary"
                                                                onclick="searchCompany('${list.name}')">查询该公司
                                                        </button>
                                                    </c:if></td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${empty relatedCompanies}">
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

                <div class="tab-pane fade" id="tab05">

                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="heading01">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse01"
                                   aria-expanded="true"
                                   aria-controls="collapse01">
                                    Balance Sheet </a>
                            </h4>
                        </div>
                        <div id="collapse01" class="panel-collapse collapse" role="tabpanel"
                             aria-labelledby="heading01">
                            <div class="panel-body">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="25%"
                                            style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                                            <table class="table table-striped table-responsive"
                                                   style="height: 100%">
                                                <tbody>
                                                <tr>
                                                    <td width="23%" class="formleft"><strong>Date Of
                                                        Accounts</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft">
                                                        <strong>Weeks</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft">
                                                        <strong>Currency</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Consolidated
                                                        A/cs</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Current
                                                        Assets</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Raw
                                                        Materials
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Work in
                                                        Progress
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Finished
                                                        Goods
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Other
                                                        Inventories
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Total
                                                        Inventories</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Trade
                                                        Receivables
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Group
                                                        Receivables
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Receivables
                                                        Due after 1 year
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Miscellaneous
                                                        Receivables
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Total
                                                        Receivables</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft">
                                                        <strong>Cash</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Other
                                                        Current Assets</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>TOTAL
                                                        CURRENT ASSETS</strong></td>
                                                </tr>


                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Non-Current
                                                        Assets</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Land &
                                                        Buildings
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Plant &
                                                        Machinery
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Other
                                                        Tangible Assets
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Total
                                                        Tangible Assets</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Intangible
                                                        Assets</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Investments
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Loans to
                                                        Group
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Other Loans
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Total
                                                        Other Fixed Assets</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>TOTAL
                                                        NON-CURRENT ASSETS</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>TOTAL
                                                        ASSETS</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Current
                                                        Liabilities</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Trade
                                                        Payables
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Bank
                                                        Liabilities
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Other
                                                        Loans/Finance
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Group
                                                        Payables
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Miscellaneous
                                                        Liabilities
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>TOTAL
                                                        CURRENT LIABILITIES</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Non-Current
                                                        Liabilities</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Trade
                                                        Payables due after 1
                                                        year</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Bank
                                                        Liabilities due after 1
                                                        year</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Other
                                                        Loans/Finance due after 1
                                                        year</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Group
                                                        Payables due after 1
                                                        year</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>
                                                        Miscellaneous Liabilities due
                                                        after 1 year</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>TOTAL
                                                        LONG TERM
                                                        LIABILITIES</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>TOTAL
                                                        LIABILITIES</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Shareholders’
                                                        Equity</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Called Up
                                                        Share Capital
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Share
                                                        Premium
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Revenue
                                                        Reserves
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"> Other
                                                        Reserves
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>TOTAL
                                                        SHAREHOLDERS EQUITY</strong>
                                                    </td>
                                                </tr>
                                                </tbody>

                                            </table>
                                        </td>
                                        <c:forEach var="ltdFinancialStatement"
                                                   items="${searchDetail.financialStatements.financialStatement}"
                                                   varStatus="status">
                                            <%--begin="0" end="2"--%>
                                            <td width="25%">
                                                <table class="table table-striped table-responsive"
                                                       style="height: 100%">
                                                    <tr>
                                                        <td valign="top" align="right">
                                                                ${ltdFinancialStatement.yearEndDate}&nbsp;
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" align="right">
                                                                ${ltdFinancialStatement.numberOfWeeks}&nbsp;
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.currency}&nbsp; </td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.isConsolidatedAccounts()}
                                                            &nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" align="right">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.rawMaterials.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.workInProgress.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.finishedGoods.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.otherInventories.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalInventories.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.tradeReceivables.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.groupReceivables.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.receivablesDueAfter1Year.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.miscellaneousReceivables.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalReceivables.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.cash.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.otherCurrentAssets.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalCurrentAssets.value}&nbsp;</td>
                                                    </tr>

                                                    <tr>
                                                        <td valign="top" align="right">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.landAndBuildings.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.plantAndMachinery.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.otherTangibleAssets.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalTangibleAssets.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalIntangibleAssets.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.investments.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.loansToGroup.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.otherLoans.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalOtherFixedAssets.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalFixedAssets.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalAssets.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" align="right">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.tradePayables.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.bankLiabilities.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.otherLoansOrFinance.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.groupPayables.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.miscellaneousLiabilities.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalCurrentLiabilities.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" align="right">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.tradePayablesDueAfter1Year.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.bankLiabilitiesDueAfter1Year.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.otherLoansOrFinanceDueAfter1Year.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.groupPayablesDueAfter1Year.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.miscellaneousLiabilitiesDueAfter1Year.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalLongTermLiabilities.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalLiabilities.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" align="right">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.calledUpShareCapital.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.sharePremium.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.revenueReserves.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.otherReserves.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.balanceSheet.totalShareholdersEquity.value}&nbsp;</td>
                                                    </tr>

                                                </table>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>


                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="heading02">
                            <h4 class="panel-title">
                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                   href="#collapse02"
                                   aria-expanded="false" aria-controls="collapse02">
                                    Profit & Loss Account
                                </a>
                            </h4>
                        </div>
                        <div id="collapse02" class="panel-collapse collapse" role="tabpanel"
                             aria-labelledby="heading02">
                            <div class="panel-body">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="25%"
                                            style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                                            <table class="table table-striped table-responsive"
                                                   style="height: 100%">
                                                <tbody>
                                                <tr>
                                                    <td width="23%" class="formleft"><strong>Date Of
                                                        Accounts</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft">
                                                        <strong>Weeks</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft">
                                                        <strong>Currency</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Consolidated
                                                        A/cs</strong></td>
                                                </tr>


                                                <tr>
                                                    <td valign="top" class="formleft">
                                                        <strong>Revenue</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Less:
                                                        Operating Costs</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Operating
                                                        Profit</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Less:
                                                        Wages & Salaries</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Less:
                                                        Pension Costs</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Less:
                                                        Depreciation</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Less:
                                                        Amortisation</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Add:
                                                        Financial Income</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Less:
                                                        Financial Expenses</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Add:
                                                        Extraordinary
                                                        Income</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Less:
                                                        Extraordinary
                                                        Costs</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Profit
                                                        Before Tax</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong> Less:
                                                        Tax</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Profit
                                                        After Tax</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft">
                                                        <strong>Dividends</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Minority
                                                        Interests</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Other
                                                        Appropriations</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Retained
                                                        Profit</strong></td>
                                                </tr>
                                                </tbody>

                                            </table>
                                        </td>
                                        <c:forEach var="ltdFinancialStatement"
                                                   items="${searchDetail.financialStatements.financialStatement}"
                                                   varStatus="status">
                                            <%--begin="0" end="2"--%>
                                            <td width="25%">
                                                <table class="table table-striped table-responsive"
                                                       style="height: 100%">
                                                    <tr>
                                                        <td valign="top" align="right">
                                                                ${ltdFinancialStatement.yearEndDate}&nbsp;
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" align="right">
                                                                ${ltdFinancialStatement.numberOfWeeks}&nbsp;
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.currency}&nbsp; </td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.isConsolidatedAccounts()}
                                                            &nbsp;</td>
                                                    </tr>


                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.revenue.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.operatingCosts.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.operatingProfit.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.wagesAndSalaries.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.pensionCosts.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.depreciation.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.amortisation.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.financialIncome.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.financialExpenses.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.extraordinaryIncome.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.extraordinaryCosts.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.profitBeforeTax.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.tax.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" align="right">
                                                                ${ltdFinancialStatement.profitAndLoss.profitAfterTax.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.dividends.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.minorityInterests.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.otherAppropriations.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.profitAndLoss.retainedProfit.value}&nbsp;</td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="heading03">
                            <h4 class="panel-title">
                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                   href="#collapse03"
                                   aria-expanded="false" aria-controls="collapse03">
                                    Other Financials </a>
                            </h4>
                        </div>
                        <div id="collapse03" class="panel-collapse collapse" role="tabpanel"
                             aria-labelledby="heading03">
                            <div class="panel-body">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="25%"
                                            style=" white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
                                            <table class="table table-striped table-responsive"
                                                   style="height: 100%">
                                                <tbody>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Contingent
                                                        Liabilities</strong>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Working
                                                        Capital</strong></td>
                                                </tr>
                                                <tr>
                                                    <td valign="top" class="formleft"><strong>Net
                                                        Worth</strong></td>
                                                </tr>
                                                </tbody>

                                            </table>
                                        </td>
                                        <c:forEach var="ltdFinancialStatement"
                                                   items="${searchDetail.financialStatements.financialStatement}"
                                                   varStatus="status">
                                            <%--begin="0" end="2"--%>
                                            <td width="25%">
                                                <table class="table table-striped table-responsive"
                                                       style="height: 100%">
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.otherFinancials.contingentLiabilities}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.otherFinancials.workingCapital.value}&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top"
                                                            align="right">${ltdFinancialStatement.otherFinancials.netWorth.value}&nbsp;</td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="tab-pane fade" id="tab07">
                    <p>&nbsp;</p>
                    <div class="panel-group" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading41">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse41"
                                       aria-expanded="true"
                                       aria-controls="collapse41">
                                        UCC Details（
                                        <c:if test="${empty uCCsList}">0</c:if>
                                        ${uCCsList.size()}
                                        ） </a>
                                </h4>
                            </div>
                            <div id="collapse41" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading41">
                                <div class="panel-body">
                                    <table width="100%"
                                           class="table table-hover table-bordered table-responsive">
                                        <thead>
                                        <tr>
                                            <th width="14%"><span
                                                    class="formleft"><strong>Filed Date</strong></span></th>
                                            <th width="14%"><span
                                                    class="formleft"><strong>Filing Number </strong></span></th>
                                            <th width="14%"><span
                                                    class="formleft"><strong>Secured Party </strong></span></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="uccDetail" items="${uCCsList}" varStatus="status">
                                            <tr>
                                                <td>${uccDetail.filedDate }</td>
                                                <td>${uccDetail.filingNumber }</td>
                                                <td>${uccDetail.securedParty  }</td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading44">
                                <h4 class="panel-title">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapse44"
                                       aria-expanded="false" aria-controls="collapse44">
                                        Legal Infos（
                                        <c:if test="${empty legalInfos}">0</c:if>
                                        ${legalInfos.size()}
                                        ）
                                    </a>
                                </h4>
                            </div>
                            <div id="collapse44" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading44">
                                <div class="panel-body">
                                    <table width="100%"
                                           class="table table-hover table-bordered table-responsive">
                                        <thead>
                                        <tr>
                                            <th width="14%"><strong>Bankruptcy </strong></th>
                                            <th width="16%"><strong>Tax Lien Filings </strong></th>
                                            <th width="16%"><strong>Judgment Filings </strong></th>
                                            <th width="12%"><strong>Sum </strong></th>
                                            <th width="12%"><strong>UCC Filings </strong></th>
                                            <th width="12%"><strong>Cautionary UCC Filings </strong></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="legalInfos" items="${legalInfos}" varStatus="status">
                                            <tr>
                                                <td>${legalInfos.bankruptcy }</td>
                                                <td>${legalInfos.taxLienFilings }</td>
                                                <td>${legalInfos.judgmentFilings }</td>
                                                <td>${legalInfos.sum}</td>
                                                <td>${legalInfos.uCCFilings}</td>
                                                <td>${legalInfos.cautionaryUCCFilings}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                    </div>


                </div>

                <div class="tab-pane fade" id="tab08">

                    <div class="panel-body">
                        <c:if test="${not empty operatingsList}">
                            <div class="panel panel-default">
                                <div class="panel-heading">Business</div>
                                <div class="panel-body">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tbody>

                                        <tr>
                                            <td width="23%" class="formleft"><strong>Main Business</strong></td>
                                            <td width="77%"
                                                class="formright">${operatingsList.get(0).activityDescription}</td>
                                        </tr>
                                        <tr>
                                            <td class="formleft"><strong>Activity Code</strong></td>
                                            <td
                                                    class="formright">${operatingsList.get(0).activityCode}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading"> Employee Information</div>
                                <div class="panel-body">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tbody>
                                        <tr>
                                            <td width="23%" class="formleft">
                                                <strong> ${operatingsList.get(0).year} </strong>
                                            </td>
                                            <td width="77%" class="formright">
                                                    ${operatingsList.get(0).employeeNum}
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading">Business Info</div>
                                <div class="panel-body">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tbody>
                                        <tr>
                                            <td width="23%" class="formleft"><strong>Operations Area</strong></td>
                                            <td width="77%"
                                                class="formright">${operatingsList.get(0).operationsArea}</td>
                                        </tr>
                                        <tr>
                                            <td class="formleft"><strong>Company imports from</strong></td>
                                            <td
                                                    class="formright">${operatingsList.get(0).importArea}</td>
                                        </tr>
                                        <tr>
                                            <td width="23%" class="formleft"><strong>Company export to</strong></td>
                                            <td
                                                    class="formright">${operatingsList.get(0).exportArea}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="23%" class="formleft"><strong>Competitors</strong></td>
                                            <td
                                                    class="formright">${operatingsList.get(0).competitors}</td>
                                        </tr>
                                        <tr>
                                            <td class="formleft"><strong>Sales Are</strong></td>
                                            <td
                                                    class="formright">${operatingsList.get(0).salesAre}</td>
                                        </tr>
                                        <tr>
                                            <td width="23%" class="formleft"><strong>Trade References</strong></td>
                                            <td
                                                    class="formright">${operatingsList.get(0).tradeReferences}</td>
                                        </tr>
                                        <tr>
                                            <td class="formleft"><strong>Terms Payment</strong></td>
                                            <td
                                                    class="formright">${operatingsList.get(0).termsPayment}
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </c:if>


                    </div>

                </div>

                <div class="tab-pane fade" id="tab10">
                    <p>&nbsp;</p>
                    <div class="panel-group" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading51">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse51"
                                       aria-expanded="true"
                                       aria-controls="collapse51">
                                        Payment Histories </a>
                                </h4>
                            </div>
                            <div id="collapse51" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading51">
                                <div class="panel-body">
                                    <table width="100%" class="table table-hover table-bordered table-responsive">
                                        <thead>
                                        <tr>

                                            <th width="10%"><strong>Term</strong></th>
                                            <th width="10%"><strong>Pay History</strong></th>
                                            <th width="10%"><strong>Pay Info</strong></th>

                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:if test="${not empty paymentHistoriesList}">
                                            <c:forEach var="paymentHistoriesList" items="${paymentHistoriesList}" varStatus="status">
                                            <tr>
                                                <td>${paymentHistoriesList.term}</td>
                                                <td>${paymentHistoriesList.payHistory}</td>
                                                <td>${paymentHistoriesList.payInfo}</td>

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
            </div>
        </div>


    </div>


    <c:if test="${message=='false'}">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title" style="font-family:苹方">
                    提示
                </h3>
            </div>
            <div class="panel-body text-center">
                <h4>数据正在传输中，请稍候再试！</h4>
            </div>
        </div>
    </c:if>

</div>
</div></div>


<p>&nbsp;</p>
<p>&nbsp;</p>

<footer>
    <div class="row" style=" background-color:#f2f2f2; padding-top:50px">
        <div class="container">

            <div class="row">

                <div class="col-lg-6">
                    <div class="bs-component">
                        <h5>法律声明</h5>
                        <p style="font-size:11px">未经全球鹰书面同意，本报告不得以任何形式或部分提供给第三人。
                            <br>
                            本报告仅供签约客户作为信用、保险、营销及其他商业决策时的参考因素之一，不能用于其它用途。
                            本报告某些信息来源于非全球鹰所能控制的渠道，除非特别注明，此类信息均未经复核，全球鹰不能保证所提供信息的准确性、完整性和时效性。全球鹰提供本报告并不意味着为客户的商业风险提供担保,在任何情况下，对于客户的商业决策所造成的损失，无论该商业决策的做出是否参考了本报告所载信息，全球鹰不承担使用者的任何商业风险，也不承担由于非控因素和疏忽而引起的相应的损失和损害。
                        </p>


                    </div>

                </div>
                <div class="col-lg-3">
                    <div class="bs-component">
                        <h5>支持及服务</h5>


                        <p style="font-size:11px">
                            帐户及充值问题<br>
                            优惠及折扣方案<br>
                            常见问题汇总<br>
                            在线帮助<br>
                        </p>

                    </div>

                </div>


                <div class="col-lg-3">
                    <div class="bs-component">
                        <h5>联系方式</h5>


                        <p style="font-size:11px">
                            热线：400-7729-029(AM9:00-PM18:00) <br>
                            电话：021-3638-6226 <br>
                            邮箱：report@global-eagle.cn <br>
                            地址：上海市静安区愚园路168好环球世界大厦26层 <br>
                        </p>

                    </div>

                </div>


            </div>

            <hr style="color:#000">
            <p>Global Eagle 全球鹰 </p>

        </div>
    </div>

</footer>


<script>
    $(document).ready(function () {

        $('.navbar .dropdown, .dropdown-submenu').hover(function () {
        }, function () {
        });
        var clickEvent = false;
        $('#featureCarousel').on('click', '.nav a', function () {
            clickEvent = true;
            $('.nav li').removeClass('active');
            $(this).parent().addClass('active');
        }).on('slid.bs.carousel', function (e) {
            if (!clickEvent) {
                var count = $('#featureCarousel .nav').children().length - 1;
                var current = $('#featureCarousel .nav li.active');
                current.removeClass('active').next().addClass('active');
                var id = parseInt(current.data('slide-to'));

                if (count == id) {
                    $('#featureCarousel .nav li').first().addClass('active');
                }
            }
            clickEvent = false;
        });
    });

</script>
<script type="text/javascript" language="javascript"
        src="${pageContext.request.contextPath}/frame/DataTables-1.10.12/media/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/data-tables/DT_bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/data-tables/DT_bootstrap.css"/>
<link href="${pageContext.request.contextPath}/frame/DataTables-1.10.12/media/css/jquery.dataTables.min.css"
      rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dataTables.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/cpm/report.js"></script>

</body>
</html>