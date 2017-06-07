<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>${companyName}</title>
    <script src="${pageContext.request.contextPath}/js/htmlSaveAs.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <script src="<%=basePath%>frame/jquery-1.10.2.min.js"></script>

    <style>
        .btn-update {
            margin-top: -5px;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            test=document.getElementsByTagName('html')[0].outerHTML;
            email="${email}";
            crefoNo="${crefoNo}";
            customerId = "${customerId}";
        });
        function searchCompany(companyName){
            window.open(basePath+"toSearchCompanyList.do?countryName=中国&companyName="+companyName);
//            window.location.href = basePath+"toSearchCompanyList.do?countryName=中国&companyName="+companyName;
        }

        function credit(){
            window.open(basePath+"toIndexAddition1.do?country="+'${cnName}'+"&companyName="+'${companyName}'+"&companyPhone="+'${basic.tel}'+"&companyWebsite="+'${basic.website}'+"&companyEmail="+'${basic.email}'+"&companyAdd="+'${basic.addressCN}');
        }
    </script>

</head>
<body>


<div class="container">


    <jsp:include page="../include/report/top.jsp"/>
<c:if test="${message!='false'}">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title" >公司概况
                <span class="pull-right">
                    <a href="javascript:void(0);" onClick="updateChina()" class="btn btn-xs btn-default btn-update">更新</a>
                </span>
            </h3>
        </div>
        <div class="panel-body">
            <div class="panel panel-default">
                <div class="panel-heading" >公司名称
                </div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td width="23%" class="formleft"><strong>注册名称</strong></td>
                            <td width="77%"  class="formright"><div align="left">${companyName}</div></td>
                        </tr>
                        <tr>
                            <td width="23%" class="formleft"><strong>注册名称</strong></td>
                            <td width="77%"  class="formright"><div align="left">${basic.nameEN}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>贸易名称</strong></td>
                            <td valign="top"  class="formright"><div align="left">-</div></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">联系信息</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td width="23%" class="formleft"><strong>运营地址</strong></td>
                            <td width="77%"  class="formright">${basic.addressCN}<br>
                                ${basic.streetCN} <br>
                                ${basic.zip}</td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>电话</strong></td>
                            <td valign="top"  class="formright"><div align="left">${basic.tel}</div></td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>传真</strong></td>
                            <td valign="top"  class="formright"><div align="left">${basic.fax}</div></td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>邮箱</strong></td>
                            <td valign="top"  class="formright"><div align="left">${basic.email}</div></td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>网址</strong></td>
                            <td valign="top"  class="formright"><div align="left">${basic.website}</div></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">注册信息</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td width="23%" class="formleft"><strong>企业现状</strong></td>
                            <td width="77%"  class="formright"><div align="left">${reg.entstatus}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>统一征信码</strong></td>
                            <td valign="top"  class="formright"><div align="left">${reg.creditcode}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>行业代码</strong></td>
                            <td valign="top"  class="formright"><div align="left">${reg.chinaIndustrycode}</div></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>



        </div>
    </div>
</div>

<div class="container">

    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">信用评估
                <span class="pull-right">
                    <a href="javascript:void(0);" onClick="updateChina()" class="btn btn-xs btn-default btn-update">更新</a>
                </span></h3>
        </div>
        <div class="panel-body">
            <div class="panel panel-default">
                <div class="panel-heading">信用评级(当地信用评估)</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <%--<tr>--%>
                            <%--<td valign="top">--%>
                                <%--<div align="center">低风险</div>--%>
                            <%--</td>--%>
                            <%--<td valign="top" class="formright">--%>
                                <%--<div align="center">平均低风险</div>--%>
                            <%--</td>--%>
                            <%--<td valign="top" class="formright">--%>
                                <%--<div align="center">中等风险</div>--%>
                            <%--</td>--%>
                            <%--<td valign="top" class="formright">--%>
                                <%--<div align="center">平均高风险</div>--%>
                            <%--</td>--%>
                            <%--<td valign="top" class="formright">--%>
                                <%--<div align="center">高风险</div>--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td colspan="5">--%>
                                <%--<div class="progress">--%>
                                    <%--<div class="progress-bar    <c:if test="${credit.creditRating=='超低风险'}">alert-vrisk</c:if>--%>
                	<%--<c:if test="${credit.creditRating=='低风险'}">success</c:if>--%>
                	<%--<c:if test="${credit.creditRating=='中等风险'}">warning</c:if>--%>
                	<%--<c:if test="${credit.creditRating=='高风险'}">moderate</c:if>--%>
                	<%--<c:if test="${credit.creditRating=='超高风险'}">danger</c:if>--%>
                	<%--<c:if test="${credit.creditRating=='未评级'}">info</c:if>--%>
                <%--" style="width: ${credit.resultSolvency}%; padding:8px; font-size:14px">${credit.resultSolvency}</div>--%>
                                <%--</div>--%>
                            <%--</td>--%>
                        <%--</tr>--%>




                        <tr>
                            <img src="${pageContext.request.contextPath}/images/creditRatingCN/
                            <c:if test="${empty credit.resultSolvency}">
                            0
                            </c:if>
                            ${credit.resultSolvency}
                            .jpg"/>
                        </tr>


                        <tr>
                            <td colspan="5" valign="top">


                                <div class="col-lg-4">
                                    <div class="bs-component">

                                        <div class="alert alert-dismissible
                  <c:if test="${credit.creditRating=='超低风险'}">alert-vrisk</c:if>
                	<c:if test="${credit.creditRating=='低风险'}">alert-success</c:if>
                	<c:if test="${credit.creditRating=='中等风险'}">alert-warning</c:if>
                	<c:if test="${credit.creditRating=='高风险'}">alert-moderate</c:if>
                	<c:if test="${credit.creditRating=='超高风险'}">alert-danger</c:if>
                	<c:if test="${credit.creditRating=='未评级'}">alert-info</c:if>
                ">

                                            <div align="center">
                                                <span><strong>信用风险评级:</strong>${credit.creditRating}</span></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-4">
                                    <div class="bs-component">
                                        <div class="alert alert-dismissible
                    <c:if test="${credit.creditRating=='超低风险'}">alert-vrisk</c:if>
                	<c:if test="${credit.creditRating=='低风险'}">alert-success</c:if>
                	<c:if test="${credit.creditRating=='中等风险'}">alert-warning</c:if>
                	<c:if test="${credit.creditRating=='高风险'}">alert-moderate</c:if>
                	<c:if test="${credit.creditRating=='超高风险'}">alert-danger</c:if>
                	<c:if test="${credit.creditRating=='未评级'}">alert-info</c:if>
                ">

                                            <div align="center"><strong>企业偿还指数:</strong>${credit.resultSolvency}</div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-4">
                                    <div class="bs-component">
                                        <div class="alert alert-dismissible           <c:if test="${credit.creditRating=='超低风险'}">progress-bar-colora</c:if>
                	 <c:if test="${credit.creditRating=='超低风险'}">alert-vrisk</c:if>
                	<c:if test="${credit.creditRating=='低风险'}">alert-success</c:if>
                	<c:if test="${credit.creditRating=='中等风险'}">alert-warning</c:if>
                	<c:if test="${credit.creditRating=='高风险'}">alert-moderate</c:if>
                	<c:if test="${credit.creditRating=='超高风险'}">alert-danger</c:if>
                	<c:if test="${credit.creditRating=='未评级'}">alert-info</c:if>
                ">

                                            <div align="center"><strong>建议信用额度(CNY):</strong>${credit.resultRecommended}
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>


    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">法律注册
                <span class="pull-right">
                    <a href="javascript:void(0);" onClick="updateChina()" class="btn btn-xs btn-default btn-update">更新</a>
                </span></h3>
        </div>
        <div class="panel-body">
            <div class="panel panel-default">
                <div class="panel-heading">注册信息</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td width="23%" class="formleft"><strong>注册地址</strong></td>
                            <td  width="77%" class="formright"><div align="left">${reg.addressCN}<br>
                                ${reg.streetCN}
                                <br>
                                ${reg.zip}
                            </div></td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>注册日期</strong></td>
                            <td  class="formright"><div align="left">${reg.establishDate}</div></td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>经营期限</strong></td>
                            <td  class="formright"><div align="left">${reg.deadline}</div></td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>企业性质</strong></td>
                            <td  class="formright"><div align="left">${reg.entOwnership}</div></td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>企业类型</strong></td>
                            <td  class="formright"><div align="left">${reg.enttype}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>企业现状</strong></td>
                            <td valign="top"  class="formright"><div align="left">${reg.entstatus}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>注册资本</strong></td>
                            <td valign="top"  class="formright"><div align="left">${reg.regCapital}</div></td>
                        </tr>
                        <tr>
                            <td class="formleft"><strong>实收资本</strong></td>
                            <td  class="formright"><div align="left">${reg.paidCapital}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>注册登记机关</strong></td>
                            <td valign="top"  class="formright"><div align="left">${reg.registrationCN}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>法定代表人</strong></td>
                            <td valign="top"  class="formright"><div align="left">${reg.legalNameCN}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>经营范围</strong></td>
                            <td valign="top"  class="formright"><div align="left">${reg.businessScopeCN}</div></td>
                        </tr>
                        <%-- <tr>
                          <td valign="top"  class="formleft"><strong>企业公示信息</strong></td>
                          <td valign="top"  class="formright"><div align="left">${reg.entstatus}</div></td>
                        </tr> --%>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">工商注册变更</div>
                <div class="panel-body">
                    <table class="table table-hover table-bordered table-responsive">
                        <thead>
                        <tr>
                            <th width="12%">变更日期</th>
                            <th width="18%">变更类型</th>
                            <th width="35%">变更前</th>
                            <th width="35%">变更后</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty changeList}">
                            <c:forEach items="${changeList}" var="list">
                                <tr>
                                    <td>${list.changeDate}</td>
                                    <td>${list.changeType}</td>
                                    <td>${list.beforeCN}</td>
                                    <td>${list.afterCN}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${ empty changeList}">
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

            <div class="panel panel-default">
                <div class="panel-heading">股东结构</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty shareList}">
                            <c:forEach items="${shareList}" var="list">
                                <tr>
                                    <td width="23%" class="formleft"><p><strong>${list.nameCN}</strong></p>
                                        <c:if test="${list.nameCN.length()>5}">
                                    <p><strong>
                                        <button type="button" class="btn btn-xs btn-primary" onclick="searchCompany('${list.nameCN}')">查询该公司</button><br>
                                        </strong></p>
                                        </c:if>
                                    </td>
                                    <td width="77%"  class="formright"><div align="left">
                                        <div title="Page 4">
                                            <div>
                                                <div>
                                                    <div>
                                                        <p>股权：${list.shares} <br>出资额：${list.subconam} <br>出资日期：${list.condate}
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty shareList}">
                            <tr>
                                <td width="23%" class="formleft"><strong>-</strong></td>
                                <td width="77%"  class="formright"><div align="left">
                                    <div title="Page 4">
                                        <div>
                                            <div>
                                                <div>
                                                    <p>股权：- <br>出资额：- <br>出资日期：-
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">管理人员</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty manageList}">
                            <c:forEach items="${manageList}" var="list">
                                <tr>
                                    <td width="23%" class="formleft"><strong>${list.nameCN}</strong></td>
                                    <td width="77%"  class="formright"><div align="left">${list.position}</div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty manageList}">
                            <tr>
                                <td width="23%" class="formleft"><strong>-</strong></td>
                                <td width="77%"  class="formright"><div align="left">-</div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">关联公司
                <span class="pull-right">
                    <a href="javascript:void(0);" onClick="updateChina()" class="btn btn-xs btn-default btn-update">更新</a>
                </span></h3>
        </div>
        <div class="panel-body">
            <div class="panel panel-default">
                <div class="panel-heading">企业对外投资</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty entinvList}">
                            <c:forEach items="${entinvList}" end="1" var="list" varStatus="status">
                                <tr>
                                    <td width="23%" rowspan="2" valign="top"  class="formleft"><strong>${list.entNameCn}</strong></td>
                                    <td width="77%"  class="formright"><div align="left">出资比例：${list.fundedRatio}</div></td>
                                </tr>
                                <tr>
                                    <td class="formright"><div align="left">成立时间：${list.esDate}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft">
                                        <c:if test="${list.entNameCn.length()>5}">
                                        <button type="button" class="btn btn-xs btn-primary" onclick="searchCompany('${list.entNameCn}')">查询该公司</button>
                                        </c:if>
                                    </td>
                                    <td class="formright"><div align="left">公司类型：${list.entType}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td class="formright"><div align="left">注册资本：${list.regCapCur} ${list.regCap}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td class="formright"><div align="left">公司状态：${list.entStatus}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td class="formright"><div align="left">登记机关：${list.regOrgCn}</div></td>
                                </tr>
                                <c:if test="${status.index!=entinvList.size()-1 }">
                                    <tr>
                                        <td width="23%"  class="formleft"><strong></strong></td>
                                        <td class="formright"><div align="left"></div></td>
                                    </tr>
                                </c:if>
                            </c:forEach>

                        </c:if>
                        <c:if test="${empty entinvList}">
                            <tr>
                                <td width="23%"  class="formleft"><strong>-</strong></td>
                                <td width="77%"  class="formright"><div align="left">出资比例：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">成立时间：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">公司类型：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">注册资本：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">公司状态：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">登记机关：-</div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">法人对外投资</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty frinvList}">
                            <c:forEach items="${frinvList}" var="list" varStatus="status">
                                <tr>
                                    <td width="23%" rowspan="2" valign="top"  class="formleft"><strong>${list.entNameCn}</strong><strong></strong></td>
                                    <td width="77%"  class="formright"><div align="left">出资比例：${list.fundedRatio}</div></td>
                                </tr>
                                <tr>
                                    <td class="formright"><div align="left">成立时间：${list.esDate}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft">
                                        <c:if test="${list.entNameCn.length()>5}">
                                        <button type="button" class="btn btn-xs btn-primary" onclick="searchCompany('${list.entNameCn}')">查询该公司</button>
                                        </c:if>
                                    </td>
                                    <td class="formright"><div align="left">公司类型：${list.entType}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td class="formright"><div align="left">注册资本：${list.regCapCur} ${list.regCap}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td class="formright"><div align="left">公司状态：${list.entStatus}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td class="formright"><div align="left">登记机关：${list.regOrgCn}</div></td>
                                </tr>
                                <c:if test="${status.index!=frinvList.size()-1 }">
                                    <tr>
                                        <td width="23%"  class="formleft"><strong></strong></td>
                                        <td class="formright"><div align="left"></div></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty frinvList}">
                            <tr>
                                <td width="23%"  class="formleft"><strong>-</strong></td>
                                <td width="77%"  class="formright"><div align="left">出资比例：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">成立时间：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">公司类型：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">注册资本：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">公司状态：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">登记机关：-</div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">法人在外任职</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty frpositList}">
                            <c:forEach items="${frpositList}" var="list" varStatus="status">
                                <tr>
                                    <td width="23%" rowspan="2" valign="top"  class="formleft"><strong>${list.entNameCn}</strong><strong></strong></td>
                                    <td width="77%"  class="formright"><div align="left">担任职务：${list.position}</div></td>
                                </tr>
                                <tr>
                                    <td class="formright"><div align="left">成立时间：${list.esDate}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft">
                                        <c:if test="${list.entNameCn.length()>5}">
                                        <button type="button" class="btn btn-xs btn-primary" onclick="searchCompany('${list.entNameCn}')">查询该公司</button>
                                        </c:if>
                                    </td>
                                    <td class="formright"><div align="left">公司类型：${list.entType}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td class="formright"><div align="left">注册资本：${list.regCapCur} ${list.regCap}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td class="formright"><div align="left">公司状态：${list.entStatus}</div></td>
                                </tr>
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td class="formright"><div align="left">登记机关：${list.regOrgCn}</div></td>
                                </tr>
                                <c:if test="${status.index!=frpositList.size()-1 }">
                                    <tr>
                                        <td width="23%"  class="formleft"><strong></strong></td>
                                        <td class="formright"><div align="left"></div></td>
                                    </tr>
                                </c:if>
                            </c:forEach>


                        </c:if>
                        <c:if test="${empty frpositList}">
                            <tr>
                                <td width="23%"  class="formleft"><strong>-</strong></td>
                                <td width="77%"  class="formright"><div align="left">担任职务：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">成立时间：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">公司类型：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">注册资本：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">公司状态：-</div></td>
                            </tr>
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td class="formright"><div align="left">登记机关：-</div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
    <c:if test="${level eq '1'}">

        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">财务信息</h3>
            </div>
            <div class="panel-body">
                <div class="panel panel-default">
                    <div class="panel-heading">财务数据</div>
                    <div class="panel-body">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                            <tr>
                                <td width="23%" class="formleft"><strong>说明</strong></td>
                                <td colspan="2"  class="formright"><div align="left">单位：千；货币：人民币</div></td>
                            </tr>
                            <tr>
                                <td valign="top"  width="23%" class="formleft"><strong>年份</strong></td>
                                <c:if test="${not empty financiallist}">
                                    <c:forEach items="${financiallist}" var="list">
                                        <td  valign="top"  class="formright"><div align="right">${list.year}</div></td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financiallist}">
                                    <c:forEach items="${financiallist}" var="list">
                                        <td width="20%" valign="top"  class="formright"><div align="right">-</div></td>
                                    </c:forEach>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top"  class="formleft"><strong>资产总额</strong></td>
                                <c:if test="${not empty financiallist}">
                                    <c:forEach items="${financiallist}" var="list">
                                        <td valign="top"  class="formright"><div align="right">${list.totalAssets}</div></td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financiallist}">
                                    <c:forEach items="${financiallist}" var="list">
                                        <td valign="top"  class="formright"><div align="right">-</div></td>
                                    </c:forEach>
                                </c:if>
                            </tr>
                            <tr>
                                <td valign="top"  class="formleft"><strong>主营收入</strong></td>
                                <c:if test="${not empty financiallist}">
                                    <c:forEach items="${financiallist}" var="list">
                                        <td valign="top"  class="formright"><div align="right">${list.turnover}</div></td>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty financiallist}">
                                    <c:forEach items="${financiallist}" var="list">
                                        <td valign="top"  class="formright"><div align="right">-</div></td>
                                    </c:forEach>
                                </c:if>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </c:if>




    <c:if test="${level eq '3'}">

    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">财务信息
                <span class="pull-right">
                    <a href="javascript:void(0);" onClick="updateChina()" class="btn btn-xs btn-default btn-update">更新</a>
                </span></h3>
        </div>
        <div class="panel-body">         <h6 class="mb-2">说明：单位（千），货币（CNY）</h6>

            <div class="panel panel-default">
                <div class="panel-heading">资产</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table table-striped table-responsive">
                        <tbody>
                        <tr>
                            <td valign="top"  width="23%" class="formleft"><strong>年份</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td  valign="top"  class="formright"><div align="right">${list.year}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td width="20%" valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>流动资产</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>货币资金</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.cashAndBank}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>短期投资</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.shortTermInvestment}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>应收票据</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.billReceivable}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>应收账款</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.accountReceivable}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>其它应收款</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.otherReceivable}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>预付款项</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.advancesToSuppliers}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>存货</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.inventory}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>待摊费用</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.toBeAppointedExpense}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>其它流动资产</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.otherCurrentAssets}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>流动资产合计</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.totalCurrentAssets}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong> </strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>非流动资产</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>长期投资</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.totalLongTermInvestment}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>固定资产净值</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.fixedAssetsNetValue}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>在建工程</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.projectsUnderConstruction}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>无形资产</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.intangibleAssets}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>长期待摊费用</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.longTermToBeAppointedExpense}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>其它长期资产</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.otherLongTermAssets}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>其它资产</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.otherAssets}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>递延税款借项</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.deferredTaxDebit}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>非流动资产合计</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.totalNonCurrentAssets}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>资产合计</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.totalAssets}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">负债及股东权益</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table table-striped table-responsive">
                        <tbody>
                        <tr>
                            <td valign="top"  width="23%" class="formleft"><strong>年份</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td  valign="top"  class="formright"><div align="right">${list.year}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td width="20%" valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>流动负债</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>短期贷款</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.shortTermLoans}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>应付票据</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.notePayable}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>应付帐款</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.accountsPayable}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>预收账款</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.advancesFromClients}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>应付工资</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.salariesPayable}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>应付福利费</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.welfarePayable}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>应付税金</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.taxesPayable}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>其它应付款</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.otherAccountsPayable}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>预提费用</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.accruedExpenses}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>其它流动负债</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.otherCurrentLiabilities}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>流动负债合计</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.totalCurrentLiabilites}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong></strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>非流动负债</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>长期负债</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.totalLongTermLiabilities}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>递延税款贷项</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.deferredTaxCredit}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>其它负债</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.otherLiabilities}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>非流动负债合计</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.totalNonCurrentLiabilities}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong></strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>负债合计</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.totaLliabilities}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong></strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>股东权益</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>实收资本</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.paidUpCapital}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>资本公积</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.capitalReserve}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>盈余公积</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.surplusReserve}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>未分配利润</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.undistributedProfit}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>所有者权益合计</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.totalShareholdersEquity}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong></strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right"></div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>负债及所有者权益总计</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.totalLiabilitiesEquities}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>


            <div class="panel panel-default">
                <div class="panel-heading">损益表</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table table-striped table-responsive">
                        <tbody>
                        <tr>
                            <td valign="top"  width="23%" class="formleft"><strong>年份</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td  valign="top"  class="formright"><div align="right">${list.year}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td width="20%" valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>主营业务收入</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.turnover}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>减: 主营业务成本</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.costsOfGoodsSold}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>减: 主营业务税金及附加</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.salesTax}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>主营业务利润</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.grossProfit}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>加: 其它业务利润</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.otherOperatingProfits}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>减: 营业费用</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.salesExpense}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>减: 管理费用</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.managementExpense}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>减: 财务费用</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.financeExpense}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>营业利润</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.operatingProfit}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>加: 投资损益</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.investmentProfit}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>加: 补贴收入</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.allowanceIncomes}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>减: 资产减值损失</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.assetsDevaluation}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>加: 营业外收入</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.nonOperatingIncome}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>减: 营业外支出</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.nonOperatingExpense}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>利润总额</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.profitBeforeTax}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>减: 所得税</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.incomeTax}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td valign="top"  class="formleft"><strong>净利润</strong></td>
                            <c:if test="${not empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">${list.netIncome}</div></td>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty financiallist}">
                                <c:forEach items="${financiallist}" var="list">
                                    <td valign="top"  class="formright"><div align="right">-</div></td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">财务说明</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table table-striped table-responsive">
                        <tbody>
                        <tr>
                            <td valign="top"  width="23%" class="formleft"><strong>数据来源</strong></td>
                            <td  valign="top"  class="formright"><div align="left">${figures.sourceCN}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  width="23%" class="formleft"><strong>审计单位</strong></td>
                            <td  valign="top"  class="formright"><div align="left">${figures.auditorNameCN}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  width="23%" class="formleft"><strong>审计意见</strong></td>
                            <td  valign="top"  class="formright"><div align="left">${figures.auditorCommentCN}</div></td>
                        </tr>
                        <tr>
                            <td valign="top"  width="23%" class="formleft"><strong>注释</strong></td>
                            <td  valign="top"  class="formright"><div align="left">${figures.noteCN}</div></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>


        </div>
    </div>


    </c:if>


    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"> 司法信息
                <span class="pull-right">
                    <a href="javascript:void(0);" onClick="updateChina()" class="btn btn-xs btn-default btn-update">更新</a>
                </span></h3>
        </div>
        <div class="panel-body">
            <div class="panel panel-default">
                <div class="panel-heading">裁判文书</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty rulingdocumenList}">
                            <c:forEach items="${rulingdocumenList}" var="list">
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td width="77%"  class="formright"><div align="left">标题：${list.caseCauseCN}<br>
                                        法院：${list.courtCN}<br>
                                        案号：${list.docketNoCN}<br>
                                        日期：${list.sortTime}<br>
                                        类型：${list.casetype}
                                    </div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty rulingdocumenList}">
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td width="77%"  class="formright"><div align="left">标题：-<br>
                                    法院：-<br>
                                    案号：-<br>
                                    日期：-<br>
                                    类型：-
                                </div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">执行记录 </div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty executiveList}">
                            <c:forEach items="${executiveList}" var="list">
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td width="77%"  class="formright"><div align="left">案由：${list.caseCauseCN}<br>
                                        法院：${list.courtCN}<br>
                                        案号：${list.docketNoCN}<br>
                                        日期：${list.sortTime}<br>
                                        类型：${list.casetype}
                                    </div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty executiveList}">
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td width="77%"  class="formright"><div align="left">案由：-<br>
                                    法院：-<br>
                                    案号：-<br>
                                    日期：-<br>
                                    类型：-
                                </div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">失信记录</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty sxggList}">
                            <c:forEach items="${sxggList}" var="list">
                                <tr>
                                    <td width="23%"  class="formleft"><strong></strong></td>
                                    <td width="77%"  class="formright"><div align="left">案由：${list.caseCauseCN}<br>
                                        法院：${list.courtCN}<br>
                                        案号：${list.sortTime}<br>
                                        日期：${list.casetype}<br>
                                        类型：${list.docketNoCN}
                                    </div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty sxggList}">
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td width="77%"  class="formright"><div align="left">案由：-<br>
                                    法院：-<br>
                                    案号：-<br>
                                    日期：-<br>
                                    类型：-
                                </div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"> 其他信息
                <span class="pull-right">
                    <a href="javascript:void(0);" onClick="updateChina()" class="btn btn-xs btn-default btn-update">更新</a>
                </span></h3>
        </div>
        <div class="panel-body">
            <div class="panel panel-default">
                <div class="panel-heading">品牌专利</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty brandsList}">
                            <c:forEach items="${brandsList}" var="list">
                                <tr>
                                    <td width="23%" class="formleft"><strong>${list.patentName}</strong></td>
                                    <td width="77%"  class="formright"><div align="left">
                                        申请日期：${list.applicationDate}<br>
                                        发布日期：${list.releaseDate}<br>
                                        类型：${list.type}<br>
                                        申请号：${list.applicationNumber}<br>
                                        主分类号：${list.classificationNumber}</div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty brandsList}">
                            <tr>
                                <td width="23%" class="formleft"><strong>-</strong></td>
                                <td width="77%"  class="formright"><div align="left">
                                    申请日期：- <br>
                                    发布日期：-<br>
                                    类型：-<br>
                                    申请号：-<br>
                                    主分类号：-</div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">互联网登记 </div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty websiteList}">
                            <c:forEach items="${websiteList}" var="list">
                                <tr>
                                    <td width="23%"  class="formleft"><strong>${list.website}</strong></td>
                                    <td width="77%"  class="formright"><div align="left">
                                        注册时间：${list.registrationTime}<br>
                                        公司性质网站备案/许可证号：${list.licenseKey}</div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty websiteList}">
                            <tr>
                                <td width="23%"  class="formleft"><strong></strong></td>
                                <td width="77%"  class="formright"><div align="left">网址：-<br>
                                    注册时间：-<br>
                                    公司性质网站备案/许可证号：-</div></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">媒体记录</div>
                <div class="panel-body">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <c:if test="${not empty mediaList}">
                            <c:forEach items="${mediaList}" var="list">
                                <tr>
                                    <td class="formleft"><strong>${list.date}</strong></td>
                                    <td width="77%"  class="formright"><div align="left">标题：${list.title} <br>
                                        详情：<a target="_blank" href="${list.source}" >${list.title}</a><br>
                                    </div></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty mediaList}">
                            <tr>
                                <td class="formleft"><strong>-</strong></td>
                                <td width="77%"  class="formright"><div align="left">标题：- <br>
                                    详情：-<br>
                                    信息来源：-<br>
                                    内容：-<br>
                                </div></td>
                            </tr>
                        </c:if>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <p>报告结束</p>
    <div class="col-lg-3">
        <div class="bs-component">
            <div class="alert alert-dismissible alert-success">

                <div align="center"><span><a onclick="credit()" style="color: white"><strong>针对该公司的实地认证服务</strong></a></span></div>
            </div>
        </div>
    </div>
    <div class="col-lg-3">
        <div class="bs-component">
            <div class="alert alert-dismissible alert-success">

                <div align="center"><strong>针对该公司的应收帐催收服务</strong></div>
            </div>
        </div>
    </div>

    <div class="col-lg-3">
        <div class="bs-component">
            <div class="alert alert-dismissible alert-success">

                <div align="center"><strong>针对该公司所属国的司法服务</strong></div>
            </div>
        </div>
    </div>
    <div class="col-lg-3">
        <div class="bs-component">
            <div class="alert alert-dismissible alert-success">

                <div align="center"><strong>针对该公司其他商业服务</strong></div>
            </div>
        </div>
    </div>
    <p>&nbsp; </p>
</div>
</c:if>
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


<footer>
    <div class="row" style=" background-color:#f2f2f2; padding-top:50px">
        <div class="container">

            <div class="row">

                <div class="col-lg-6">
                    <div class="bs-component">
                        <h5>法律声明</h5>
                        <p style="font-size:11px">未经全搜书面同意，本报告不得以任何形式或部分提供给第三人。
                            <br>
                            本报告仅供签约客户作为信用、保险、营销及其他商业决策时的参考因素之一，不能用于其它用途。
                            本报告某些信息来源于非全搜所能控制的渠道，除非特别注明，此类信息均未经复核，全搜不能保证所提供信息的准确性、完整性和时效性。全搜提供本报告并不意味着为客户的商业风险提供担保,在任何情况下，对于客户的商业决策所造成的损失，无论该商业决策的做出是否参考了本报告所载信息，全搜不承担使用者的任何商业风险，也不承担由于非控因素和疏忽而引起的相应的损失和损害。</p>


                    </div>

                </div>
                <div class="col-lg-3">
                    <div class="bs-component">
                        <h5>支持及解决方案</h5>


                        <p style="font-size:11px">报告问题：report@global-eagle.cn
                            <br>
                            热线支持：4008 388 2938 9:00am-18:00pm<br>
                            帐户及充值问题<br>
                            优惠及折扣方案<br>
                            常见问题汇总<br>
                            联系方式<br>
                        </p>

                    </div>

                </div>


                <div class="col-lg-3">
                    <div class="bs-component">
                        <h5>更多服务</h5>


                        <p style="font-size:11px">报告问题：report@global-eagle.cn
                            <br>
                            热线支持：4008 388 2938 9:00am-18:00pm<br>
                            帐户及充值问题<br>
                            优惠及折扣方案<br>
                            常见问题汇总<br>
                            联系方式<br>
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
    $(document).ready( function() {

        $('.navbar .dropdown, .dropdown-submenu').hover(function() {
            //$(this).find('.dropdown-menu').first().stop(true, true).delay(250).slideDown();
            //$(this).find('.dropdown-menu').show().removeClass('flipOutY').addClass('animated flipInY');
            //$(this).find('.dropdown-menu').show().removeClass('bounceOut').addClass('animated bounceIn');
            //$(this).find('.dropdown-menu').first().show();


        }, function() {
            //$(this).find('.dropdown-menu').first().stop(true, true).delay(100).slideUp();
            //$(this).find('.dropdown-menu').removeClass('flipInY').addClass('animated flipOutY').fadeOut();
            //$(this).find('.dropdown-menu').removeClass('bounceIn').addClass('animated bounceOut').fadeOut();
            //$(this).find('.dropdown-menu').first().hide();

        });

//        $('#featureCarousel').carousel({
//            interval:   4000
//        });

        var clickEvent = false;
        $('#featureCarousel').on('click', '.nav a', function() {
            clickEvent = true;
            $('.nav li').removeClass('active');
            $(this).parent().addClass('active');
        }).on('slid.bs.carousel', function(e) {
            if(!clickEvent) {
                var count = $('#featureCarousel .nav').children().length -1;
                var current = $('#featureCarousel .nav li.active');
                current.removeClass('active').next().addClass('active');
                var id = parseInt(current.data('slide-to'));

                if(count == id) {
                    $('#featureCarousel .nav li').first().addClass('active');
                }
            }
            clickEvent = false;
        });
    });

</script>

</body>
</html>