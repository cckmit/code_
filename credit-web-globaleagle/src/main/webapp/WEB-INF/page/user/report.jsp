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

    <style>
        .btn-update {
            margin-top: -5px;
        }
    </style>

</head>
<body>
<jsp:include page="../include/report/payReportTop.jsp"/>
<div class="container">

    <div class="row">

        <div class="bs-component">
            <ul class="nav nav-tabs">
                <li class="active"><a aria-expanded="false" href="#home" data-toggle="tab">公司概况</a></li>
                <li class=""><a aria-expanded="true" href="#tab02" data-toggle="tab">法律注册</a></li>
                <li class=""><a aria-expanded="true" href="#tab03" data-toggle="tab">股东结构</a></li>
                <li class=""><a aria-expanded="true" href="#tab04" data-toggle="tab">关联公司</a></li>
                <li class=""><a aria-expanded="true" href="#tab05" data-toggle="tab">财务数据</a></li>
                <li class=""><a aria-expanded="true" href="#tab06" data-toggle="tab">司法信息</a></li>
                <li class=""><a aria-expanded="true" href="#tab07" data-toggle="tab">负面信息</a></li>
                <li class=""><a aria-expanded="true" href="#tab08" data-toggle="tab">运营信息</a></li>
                <li class=""><a aria-expanded="true" href="#tab09" data-toggle="tab">其他信息</a></li>
                <li class="dropdown">
                    <a aria-expanded="false" class="dropdown-toggle" data-toggle="dropdown" href="#">
                        公共信息 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#dropdown1" data-toggle="tab">媒体记录</a></li>
                        <li><a href="#dropdown2" data-toggle="tab">ICP备案</a></li>
                        <li><a href="#dropdown3" data-toggle="tab">专利及资质</a></li>
                    </ul>
                </li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <c:if test="${countryName=='中国'}">
                    <div class="tab-pane fade active in" id="home">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                            <tbody>
                            <tr style="border-bottom: 1px solid #eee;">
                                <td width="12%" class="formleft"><strong>注册名称</strong></td>
                                <td width="38%" class="formright">
                                    <div align="left">${companyName}</div>
                                </td>
                                <td width="12%" class="formright">&nbsp;</td>
                                <td width="38%" class="formright">
                                    <div align="left"></div>
                                </td>
                            </tr>
                            <tr style="border-bottom: 1px solid #eee;">
                                <td class="formleft"><strong>英文名称</strong></td>
                                <td class="formright">
                                    <div align="left">${companyBasicInfo.nameEN}</div>
                                </td>
                                <td class="formright">&nbsp;</td>
                                <td class="formright">
                                    <div align="left"></div>
                                </td>
                            </tr>
                            <tr style="border-bottom: 1px solid #eee;">
                                <td valign="top" class="formleft"><strong>贸易名称</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">-</div>
                                </td>
                                <td class="formleft">&nbsp;</td>
                                <td valign="top" class="formright">&nbsp;</td>
                            </tr>
                            <tr>
                                <td class="formleft">&nbsp;</td>
                                <td class="formright">&nbsp;</td>
                                <td class="formleft">&nbsp;</td>
                                <td valign="top" class="formright">&nbsp;</td>
                            </tr>
                            <tr style="border-bottom: 1px solid #eee;">
                                <td class="formleft"><strong>运营地址</strong></td>
                                <td class="formright">${report.basicInfos.countryCN}${report.basicInfos.provinceCN}
                                        ${report.basicInfos.cityCN}${report.basicInfos.districtCN}${report.basicInfos.streetCN} </td>
                                <td class="formleft"><strong>邮编</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">${report.basicInfos.zip}</div>
                                </td>
                            </tr>
                            <tr style="border-bottom: 1px solid #eee;">
                                <td class="formleft"><strong>省份/城市</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">${companyBasicInfo.provinceCN}/${companyBasicInfo.cityCN}</div>
                                </td>
                                <td class="formleft"><strong>电话</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left"><c:if test="${report.basicInfos.areaCode!=null && report.basicInfos.tel!=null}">${report.basicInfos.areaCode}-${report.basicInfos.tel}</c:if>
                                        <c:if test="${report.basicInfos.areaCode==null && report.basicInfos.tel==null}">-</c:if></div>
                                </td>
                            </tr>
                            <tr style="border-bottom: 1px solid #eee;">
                                <td class="formleft"><strong>网址</strong></td>
                                <td valign="top" class="formright">
                                    <a href="${companyBasicInfo.website}" target="_blank"><span>${companyBasicInfo.website}</span></a>
                                </td>
                                <td class="formleft"><strong>邮箱</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">${report.basicInfos.email}</div>
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
                             src="${pageContext.request.contextPath}/images/creditRatingCN/0.jpg"/>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                            <tbody>
                            <tr>
                                <td width="12%" class="formleft">&nbsp;</td>
                                <td width="38%" class="formright">&nbsp;</td>
                                <td width="12%" class="formleft">&nbsp;</td>
                                <td width="38%" valign="top" class="formright">&nbsp;</td>
                            </tr>
                            <tr style="border-bottom: 1px solid #eee;">
                                <td class="formleft"><strong>企业现状</strong></td>
                                <td class="formright">
                                    <div align="left">-</div>
                                </td>
                                <td class="formleft"><strong>风险评级</strong></td>
                                <td valign="top" class="formright">-</td>
                            </tr>
                            <tr style="border-bottom: 1px solid #eee;">
                                <td valign="top" class="formleft"><strong>统一征信码</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">-</div>
                                </td>
                                <td class="formleft"><strong>偿还指数</strong></td>
                                <td valign="top" class="formright">-</td>
                            </tr>
                            <tr style="border-bottom: 1px solid #eee;">
                                <td valign="top" class="formleft"><strong>行业代码</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">-</div>
                                </td>
                                <td valign="top" class="formleft"><strong>信用额度</strong></td>
                                <td valign="top" class="formright">-（元）</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </c:if>

                <c:if test="${countryName!='中国'}">
                    <div class="tab-pane fade active in" id="home">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                            <tbody>
                            <tr>
                                <td width="20%" class="formleft"><strong>Business Name</strong></td>
                                <td colspan="3" class="formright">
                                    <div align="left">${companyName}</div>
                                    <div align="left"></div>
                                </td>
                            </tr>
                            <tr>
                                <td class="formleft"><strong>Registered Name</strong></td>
                                <td colspan="3" class="formright">
                                    <div align="left">-</div>
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
                                <td class="formright">-</td>
                                <td class="formleft"><strong>Post</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">-</div>
                                </td>
                            </tr>
                            <tr>
                                <td class="formleft"><strong>States/City</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">-</div>
                                </td>
                                <td class="formleft"><strong>Phone</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">-</div>
                                </td>
                            </tr>
                            <tr>
                                <td class="formleft"><strong>Website</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">
                                        <div align="left"><a href="http://-" target="_parent">-</a></div>
                                    </div>
                                </td>
                                <td class="formleft"><strong>Email</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">
                                        <div align="left">-</div>
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
                             src="${pageContext.request.contextPath}/images/creditRatingEN/0.jpg"/>
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
                                    <div align="left">-</div>
                                </td>
                                <td class="formleft"><strong>Score</strong></td>
                                <td valign="top"
                                    class="formright">-
                                </td>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft"><strong>Registration ID </strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">-</div>
                                </td>
                                <td class="formleft"><strong>Rating</strong></td>
                                <td valign="top" class="formright">-</td>
                            </tr>
                            <tr>
                                <td valign="top" class="formleft"><strong>Main Activity Description</strong></td>
                                <td valign="top" class="formright">
                                    <div align="left">-</div>
                                </td>
                                <td valign="top" class="formleft"><strong>Recommended
                                    Credit</strong></td>
                                <td valign="top"
                                    class="formright">-
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </c:if>


                <div class="tab-pane fade " id="tab02">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr style="border-bottom: 1px solid #eee;">
                            <td width="12%" class="formleft"><strong>法定代表人</strong></td>
                            <td width="38%" class="formright">-</td>
                            <td width="12%" class="formleft"><strong>企业现状</strong></td>
                            <td width="38%" valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                        </tr>
                        <tr style="border-bottom: 1px solid #eee;">
                            <td class="formleft"><strong>企业性质</strong></td>
                            <td valign="top" class="formright">-</td>
                            <td class="formleft"><strong>企业类型</strong></td>
                            <td valign="top" class="formright">-</td>
                        </tr>
                        <tr style="border-bottom: 1px solid #eee;">
                            <td class="formleft"><strong>注册资本</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                            <td class="formleft"><strong>统一征信码</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                        </tr>
                        <tr style="border-bottom: 1px solid #eee;">
                            <td class="formleft"><strong>注册日期</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                            <td class="formleft"><strong>经营期限</strong></td>
                            <td valign="top" class="formright">
                                <div align="left">-</div>
                            </td>
                        </tr>
                        <tr style="border-bottom: 1px solid #eee;">
                            <td class="formleft"><strong>注册地址</strong></td>
                            <td class="formright">
                                <div align="left">-</div>
                            </td>
                            <td class="formleft"><strong>注册登记机关</strong></td>
                            <td valign="top" class="formright">-</td>
                        </tr>
                        <tr style="border-bottom: 1px solid #eee;">
                            <td valign="top" class="formleft"><strong>经营范围</strong></td>
                            <td colspan="3" valign="top" class="formright">
                                <div align="left">-</div>
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
                                        <th width="35%">变更后</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                        <td>-</td>
                                    </tr>
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


                    <table class="table table-hover table-bordered table-responsive">
                        <tbody>
                        <thead>
                        <tr>
                            <th>名称</th>
                            <th>股权</th>
                            <th>出资额</th>
                            <th>出资日期</th>
                            <th>&nbsp;</th>
                        </tr>
                        </thead>

                        <tr>
                            <td width="40%"><p><strong>-</strong></p>

                            </td>
                            <td width="10%">-</td>
                            <td width="25%">-</td>
                            <td width="15%">-</td>
                            <td width="10%">
                            </td>
                        </tr>

                        </tbody>
                    </table>

                    <table class="table table-hover table-bordered table-responsive">
                        <tbody>
                        <thead>
                        <tr style="background: #fffccc">
                            <th><strong style="color: brown">- </strong></th>
                            <th>实缴日期</th>
                            <th>实缴金额</th>
                            <th>认缴日期</th>
                            <th>认缴金额</th>
                            <th>&nbsp;</th>
                        </tr>
                        </thead>


                        <tr>
                            <td width="40%"><p><strong>-</strong></p>

                            </td>
                            <td width="10%">-</td>
                            <td width="15%">-</td>
                            <td width="10%">-</td>
                            <td width="15%">-</td>
                            <td width="10%">

                            </td>
                        </tr>
                        </tbody>
                    </table>

                </div>

                <div class="tab-pane fade" id="tab04">
                    <div class="row">

                        <div class="panel-group" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingOne">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                           aria-expanded="true"
                                           aria-controls="collapseOne">
                                            企业对外投资(0) </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse" role="tabpanel"
                                     aria-labelledby="headingOne">
                                    <div class="panel-body">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="28%">公司名称</th>
                                                <th width="8%">出资比列</th>
                                                <th width="15%">注册资本</th>
                                                <th width="12%">成立日期</th>
                                                <th width="17%">公司类型</th>
                                                <th width="10%">公司状态</th>
                                                <th width="10%">查询</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingFour">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseFour"
                                           aria-expanded="false" aria-controls="collapseFour">
                                            企业分支机构（0）
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseFour" class="panel-collapse collapse" role="tabpanel"
                                     aria-labelledby="headingFour">
                                    <div class="panel-body">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="28%">公司名称</th>
                                                <th width="8%">注册号码</th>
                                                <th width="15%">电话</th>
                                                <th width="12%">成立日期</th>
                                                <th width="17%">公司性质</th>
                                                <th width="10%">公司状态</th>
                                                <th width="10%">查询</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>


                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingTwo">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseTwo"
                                           aria-expanded="false" aria-controls="collapseTwo">
                                            法人对外投资（0）
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
                                     aria-labelledby="headingTwo">
                                    <div class="panel-body">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="28%">公司名称</th>
                                                <th width="8%">出资比列</th>
                                                <th width="15%">注册资本</th>
                                                <th width="12%">成立日期</th>
                                                <th width="17%">公司类型</th>
                                                <th width="10%">公司状态</th>
                                                <th width="10%">查询</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingThree">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapseThree"
                                           aria-expanded="false" aria-controls="collapseThree">
                                            法人在外任职（0）
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                                     aria-labelledby="headingThree">
                                    <div class="panel-body">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                            <tr>
                                                <th width="28%">公司名称</th>
                                                <th width="8%">出资比列</th>
                                                <th width="15%">注册资本</th>
                                                <th width="12%">成立日期</th>
                                                <th width="17%">公司类型</th>
                                                <th width="10%">公司状态</th>
                                                <th width="10%">查询</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>-</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>

                <div class="tab-pane fade" id="tab05">

                    <table width="100%" border="0" cellspacing="0" cellpadding="0"
                           class="table table-striped table-responsive">
                        <tbody>
                        <tr>
                            <td valign="top" width="23%" class="formleft"><strong>年份</strong></td>
                            <td width="20%" valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                            <td width="20%" valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                            <td width="20%" valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                        </tr>

                        <tr>
                            <td valign="top" class="formleft"><strong>资产合计</strong></td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                        </tr>

                        <tr>
                            <td valign="top" class="formleft"><strong>实收资本</strong></td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                        <tr>
                            <td valign="top" class="formleft"><strong>主营业务收入</strong></td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top" class="formleft"><strong>利润总额</strong></td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                            <td valign="top" class="formright">
                                <div align="right">-</div>
                            </td>
                        </tr>

                        </tbody>
                    </table>


                    <p>备注：单位（千元），货币（人民币）</p>
                    <div class="row">

                        <div class="panel-group" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="heading01">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse01"
                                           aria-expanded="true"
                                           aria-controls="collapse01">
                                            资产表
                                        </a>
                                    </h4>
                                </div>
                            </div>


                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="heading02">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse02"
                                           aria-expanded="false" aria-controls="collapse02">
                                            负债及股东权益
                                        </a>
                                    </h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="heading03">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse03"
                                           aria-expanded="false" aria-controls="collapse03">
                                            损益表
                                        </a>
                                    </h4>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>

                <div class="tab-pane fade" id="tab06">
                    <div class="row">

                        <p>数据显示：
                            <label style="width: 80px">
                                <input type="checkbox" checked id="allZxgg" onclick="screen(1)"> 全部&nbsp;
                            </label>
                            <label style="width: 100px">
                                <input type="checkbox" id="pjws" onclick="screen(2)"> 裁判文书&nbsp;
                            </label>
                            <label style="width: 100px">
                                <input type="checkbox" id="fygg" onclick="screen(3)"> 法院公告&nbsp;
                            </label>
                            <label style="width: 100px">
                                <input type="checkbox" id="ktjl" onclick="screen(4)"> 开庭记录&nbsp;
                            </label>
                            <label style="width: 100px">
                                <input type="checkbox" id="zxjl" onclick="screen(5)"> 执行记录&nbsp;
                            </label>
                            <label style="width: 100px">
                                <input type="checkbox" id="ajlc" onclick="screen(6)"> 案件流程&nbsp;
                            </label>

                            <input class="btn btn-success btn-sm" type="button" style="float:right;" value="我的收藏"
                                   onclick="loadColInfo();">

                        </p>

                        <table class="display table table-bordered table-striped" id="dynamic-table" style="width:100%">
                            <tbody>
                            </tbody>
                        </table>

                    </div>
                </div>

                <div class="tab-pane fade" id="tab07">
                    <table class="table table-hover table-bordered table-responsive">
                        <thead>
                        <tr>
                            <th width="17%">失信记录</th>
                            <th width="17%">欠税记录</th>
                            <th width="17%">工商异常</th>
                            <th width="17%">网贷黑名单</th>
                            <th width="17%">催收记录</th>
                            <th width="15%">其他负面信息</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><strong><span
                                    class="formleft">0条记录</span></strong></td>
                            <td><strong>0条记录</strong></td>
                            <td><strong>0条记录</strong></td>
                            <td><strong>0条记录</strong></td>
                            <td><strong>0条记录</strong></td>
                            <td><strong>0条记录</strong></td>
                        </tr>
                        </tbody>
                    </table>
                    <p>备注：记录不代表所有记录，存在时间误差
                    </p>

                    <p>&nbsp; </p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                </div>

                <div class="tab-pane fade" id="tab08">

                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading11">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse11"
                                       aria-expanded="true"
                                       aria-controls="collapse11">
                                        人员结构（0） </a>
                                </h4>
                            </div>
                            <div id="collapse11" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading11">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tr>
                                            <th bgcolor="#eef1f7"><strong>员工人数</strong></th>
                                            <th>-</th>
                                            <th>-</th>
                                        </tr>
                                        <tr>
                                            <th width="40%" bgcolor="#eef1f7">姓名</th>
                                            <th width="40%" bgcolor="#eef1f7" colspan="2">职位</th>
                                        </tr>
                                        </tr>
                                        <tbody>
                                        <tr>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading12">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse12"
                                       aria-expanded="true"
                                       aria-controls="collapse12">
                                        运营场所信息 </a>
                                </h4>
                            </div>
                            <div id="collapse12" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading12">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tbody>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">场所描述</td>
                                            <td width="40%" bgcolor="#eef1f7">-</td>
                                            <td width="10%" bgcolor="#eef1f7">场地规模</td>
                                            <td width="10%" bgcolor="#eef1f7">-㎡</td>
                                        </tr>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">地点类型</td>
                                            <td width="40%" bgcolor="#eef1f7">-</td>
                                            <td width="10%" bgcolor="#eef1f7">所有权</td>
                                            <td width="10%" bgcolor="#eef1f7">-</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="operating">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse30"
                                       aria-expanded="true"
                                       aria-controls="collapse12">
                                        运营现状 </a>
                                </h4>
                            </div>
                            <div id="collapse30" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading12">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tbody>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">主营描述</td>
                                            <td width="90%" bgcolor="#eef1f7" colspan="3">-</td>
                                        </tr>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">产能规模</td>
                                            <td width="90%" bgcolor="#eef1f7" colspan="3">-</td>
                                        </tr>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">来自目标公司</td>
                                            <td width="90%" bgcolor="#eef1f7" colspan="3">-</td>
                                        </tr>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">进口比例</td>
                                            <td width="40%" bgcolor="#eef1f7">-%</td>
                                            <td width="10%" bgcolor="#eef1f7">进口地</td>
                                            <td width="10%" bgcolor="#eef1f7">-</td>
                                        </tr>
                                        <tr>
                                            <td width="10%" bgcolor="#eef1f7">出口比例</td>
                                            <td width="40%" bgcolor="#eef1f7">-%</td>
                                            <td width="10%" bgcolor="#eef1f7">出口地</td>
                                            <td width="10%" bgcolor="#eef1f7">-</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading13">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse13"
                                       aria-expanded="true"
                                       aria-controls="collapse13">
                                        银行信息（0） </a>
                                </h4>
                            </div>
                            <div id="collapse13" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading13">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tr>
                                            <th width="40%" bgcolor="#eef1f7">名称</th>
                                            <th width="30%" bgcolor="#eef1f7">账号</th>
                                            <th width="30%" bgcolor="#eef1f7">银行评价</th>
                                        </tr>
                                        <tbody>

                                        <tr>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading14">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse14"
                                       aria-expanded="true"
                                       aria-controls="collapse14">
                                        客户信息（0） </a>
                                </h4>
                            </div>
                            <div id="collapse14" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading14">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tr>
                                            <th width="60%" bgcolor="#eef1f7">姓名</th>
                                            <th width="40%" bgcolor="#eef1f7">电话</th>
                                        </tr>
                                        <tbody>
                                        <tr>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading15">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse15"
                                       aria-expanded="true"
                                       aria-controls="collapse15">
                                        供应商信息（0） </a>
                                </h4>
                            </div>
                            <div id="collapse15" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading15">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tr>
                                            <th width="60%" bgcolor="#eef1f7">姓名</th>
                                            <th width="40%" bgcolor="#eef1f7">电话</th>
                                        </tr>
                                        <tbody>

                                        <tr>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="heading16">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse16"
                                       aria-expanded="true"
                                       aria-controls="collapse16">
                                        海关信息（0） </a>
                                </h4>
                            </div>
                            <div id="collapse16" class="panel-collapse collapse" role="tabpanel"
                                 aria-labelledby="heading15">
                                <div class="panel-body">
                                    <table class="table table-hover table-bordered table-responsive">
                                        <tr>
                                            <th width="10%" bgcolor="#eef1f7">海关编码</th>
                                            <th width="40%" bgcolor="#eef1f7">管理类别</th>
                                            <th width="10%" bgcolor="#eef1f7">报关类别</th>
                                            <th width="40%" bgcolor="#eef1f7">注册有效日期</th>
                                        </tr>
                                        <tbody>

                                        <tr>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                            <td>-</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                    </div>

                </div>

                <div class="tab-pane fade" id="dropdown1">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td class="formleft"><strong>-</strong></td>
                            <td width="77%" class="formright">
                                <div align="left">标题：- <br>
                                    详情：-<br>
                                    信息来源：-<br>
                                    内容：-<br>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="dropdown2">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>

                        <tr>
                            <td width="23%" class="formleft"><strong></strong></td>
                            <td width="77%" class="formright">
                                <div align="left">网址：-<br>
                                    注册时间：-<br>
                                    公司性质网站备案/许可证号：-
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="dropdown3">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td width="23%" class="formleft"><strong>-</strong></td>
                            <td width="77%" class="formright">
                                <div align="left">
                                    申请日期：- <br>
                                    发布日期：-<br>
                                    类型：-<br>
                                    申请号：-<br>
                                    主分类号：-
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
<br><br>
    <%--<c:if test="${message==false}">--%>
        <%--<div class="panel panel-info">--%>
            <%--<div class="panel-heading">--%>
                <%--<h3 class="panel-title" style="font-family:苹方">--%>
                    <%--提示--%>
                <%--</h3>--%>
            <%--</div>--%>
            <%--<div class="panel-body text-center">--%>
                <%--<h4>数据正在传输中，请稍候再试！</h4>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</c:if>--%>
</div>
</div></div>


<p>&nbsp;</p>
<p>&nbsp;</p>

<footer>
    <div class="row" style=" background-color:#f2f2f2; padding-top:50px">
        <div class="container">

            <div class="row" style="padding-bottom:20px;border-bottom: 1px solid #999;">

                <div class="col-lg-6">
                    <div class="bs-component" style="line-height: 22px;">
                        <h5>法律声明</h5>
                        <p style="font-size:12px">未经全球鹰书面同意，本报告不得以任何形式或部分提供给第三人。
                            <br>
                            本报告仅供签约客户作为信用、保险、营销及其他商业决策时的参考因素之一，不能用于其它用途。
                            本报告某些信息来源于非全球鹰所能控制的渠道，除非特别注明，此类信息均未经复核，全球鹰不能保证所提供信息的准确性、完整性和时效性。全球鹰提供本报告并不意味着为客户的商业风险提供担保,在任何情况下，对于客户的商业决策所造成的损失，无论该商业决策的做出是否参考了本报告所载信息，全球鹰不承担使用者的任何商业风险，也不承担由于非控因素和疏忽而引起的相应的损失和损害。
                        </p>


                    </div>

                </div>
                <div class="col-lg-3">
                    <div class="bs-component" style="padding-left: 80px;line-height: 22px;">
                        <h5>支持及服务</h5>


                        <p style="font-size:12px">
                            帐户及充值问题<br>
                            优惠及折扣方案<br>
                            常见问题汇总<br>
                            在线帮助<br>
                        </p>

                    </div>

                </div>


                <div class="col-lg-3">
                    <div class="bs-component" style="line-height: 22px;">
                        <h5>联系方式</h5>


                        <p style="font-size:12px">
                            热线：400-7729-029(AM9:00-PM18:00) <br>
                            电话：021-3638-6226 <br>
                            邮箱：report@global-eagle.cn <br>
                            地址：上海市静安区愚园路168好环球世界大厦26层 <br>
                        </p>

                    </div>

                </div>


            </div>


            <p style="padding-top: 20px">Global Eagle 全球鹰 </p>

        </div>
    </div>

</footer>


<script>
    var message = "${message}";
    var countryName = "${countryName}";
    var companyNo = "${companyNo}";
    var companyName = "${companyName}";


    $(document).ready(function () {

//        if(message=='false'){
//            var t=setTimeout(function(){
//                reloadDate();
//            },5000);
//        }

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

//    function reloadDate() {
//        window.location.reload();
//    }

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