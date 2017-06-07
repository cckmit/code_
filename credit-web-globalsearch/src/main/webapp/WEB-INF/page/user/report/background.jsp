<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="tab-pane fade active in" id="Background">

    <div class="slimScrollBar">
        <div class="scrollable">

            <table class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
                <c:if test="${not empty companyBasicInfo}">
                <tbody>
                <%--<tr>--%>
                    <%--<td align="right">&nbsp;</td>--%>
                    <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                <%--</tr>--%>
                <tr>
                    <td width="15%" height="35" align="right"><strong>Company Name</strong></td>
                    <td width="39%" style="padding-left:20px">${companyName}
                    </td>
                    <td width="15%" height="35" align="right"><strong>Reg ID</strong></td>
                    <td width="35%"><span
                            style="padding-left:20px">${companyBasicInfo.registrationId}</span>
                    </td>
                </tr>
                <tr>
                    <td height="35" align="right"><strong>Chinese Name</strong></td>
                    <td style="padding-left:20px">${companyBasicInfo.companyName}</td>
                    <td height="35" align="right"><strong>Local</strong></td>
                    <td><span style="padding-left:20px">${companyBasicInfo.localEn}</span></td>
                </tr>
                <tr>
                    <td height="35" align="right"><strong>Trade Name</strong></td>
                    <td><span style="padding-left:20px">-</span>
                    </td>
                    <td height="35" align="right" valign="top"><strong>Website</strong></td>
                    <td valign="top"><a href="${companyBasicInfo.url}" target="_blank"><span
                            style="padding-left:20px">${companyBasicInfo.url}</span></a></td>
                </tr>
                <%--<tr>--%>
                    <%--<td height="35" colspan="4" align="right">&nbsp;</td>--%>
                <%--</tr>--%>
                <tr>
                    <td height="35" colspan="4" align="left">
                        <div class="panel panel-default">
                            <div class="panel-heading">Products &amp; Services</div>
                            <div class="panel-body">
                                <table  class="" width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <%--<tr>--%>
                                        <%--<td width="15%" align="right">&nbsp;</td>--%>
                                        <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                                    <%--</tr>--%>
                                    <tr>
                                        <td height="35" width="10%" align="right" valign="top"><strong>Main Product </strong></td>
                                        <td  valign="top"
                                            style="padding-left:20px"> ${companyBasicInfo.productIntroductionEn}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="10%" height="35" align="right" valign="top">
                                            <strong>Link</strong></td>
                                        <td  valign="top"
                                            style="padding-left:20px"><a
                                                href="https://ydwatch.en.alibaba.com"
                                                target="_blank">-</a>
                                        </td>
                                    </tr>
                                    <%--<tr>--%>
                                        <%--<td height="35" align="right" valign="top"><strong>Services--%>
                                            <%--introduction </strong></td>--%>
                                        <%--<td width="39%" valign="top"--%>
                                            <%--style="padding-left:20px"> ${companyBasicInfo.servicesIntroductionEn}--%>
                                        <%--</td>--%>
                                        <%--<td width="15%" height="35" align="right" valign="top">--%>
                                            <%--<strong>Link</strong></td>--%>
                                        <%--<td width="39%" valign="top"--%>
                                            <%--style="padding-left:20px">---%>
                                        <%--</td>--%>
                                    <%--</tr>--%>
                                    <%--<tr>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                    <%--</tr>--%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4"  style="border: 0;background: #fff">
                        <div class="panel panel-default">
                            <div class="panel-heading">Contact Info</div>
                            <div class="panel-body">
                                <table  class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <%--<tr>--%>
                                        <%--<td width="15%" align="right">&nbsp;</td>--%>
                                        <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                                    <%--</tr>--%>
                                    <tr>
                                        <td height="35" align="right" valign="top"><strong>Headquater Address</strong></td>
                                        <td width="39%" valign="top"
                                            style="padding-left:20px">${report.basicInfos.streetEN} ${report.basicInfos.districtEN} ${report.basicInfos.cityEN} ${report.basicInfos.provinceEN} ${report.basicInfos.countryEN}</td>
                                        <td width="15%" align="right" valign="top">
                                            <strong>Region</strong></td>
                                        <td width="39%" valign="top" style="padding-left:20px">
                                            <c:if test="${city.getCityEN()!=null&&province.getProvinceEN()==null}">
                                                ${city.getMetropolitanAreaEN()}
                                            </c:if>
                                            <c:if test="${city.getCityEN()==null&&province.getProvinceEN()!=null}">
                                                ${province.getMetropolitanAreaEN()}
                                            </c:if>
                                            <c:if test="${city.getCityEN()!=null&&province.getProvinceEN()!=null}">
                                                ${city.getMetropolitanAreaEN()}
                                            </c:if>
                                            <c:if test="${city.getCityEN()==null&&province.getProvinceEN()!=null}">

                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="35" align="right" valign="top">
                                            <strong>Email</strong></td>
                                        <td width="39%" valign="top"
                                            style="padding-left:20px">${report.basicInfos.email}
                                        </td>
                                        <td align="right" valign="top"><strong>Tel</strong></td>
                                        <td width="39%" valign="top"
                                            style="padding-left:20px">
                                            <c:if test="${report.basicInfos.areaCode!=null && report.basicInfos.tel!=null}">${report.basicInfos.areaCode}-${report.basicInfos.tel}</c:if>
                                            <c:if test="${report.basicInfos.areaCode==null && report.basicInfos.tel==null}">-</c:if>
                                        </td>
                                    </tr>
                                    <%--<tr>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td align="right" valign="top">&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                    <%--</tr>--%>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4"  style="border: 0;background: #fff">
                        <div class="panel panel-default">
                            <div class="panel-heading">Company Info</div>
                            <div class="panel-body">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <%--<tr>--%>
                                        <%--<td width="15%" align="right">&nbsp;</td>--%>
                                        <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                                    <%--</tr>--%>
                                    <tr>
                                        <td height="35" align="right" valign="top"><strong>Company Size</strong></td>
                                        <td height="35" colspan="3" valign="top"
                                            style="padding-left:20px"><p>${companyBasicInfo.aboutUsEn}</p></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td width="39%">&nbsp;</td>
                                        <td width="15%">&nbsp;</td>
                                        <td width="39%">&nbsp;</td>
                                    </tr>
                                    <%--<tr>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                    <%--</tr>--%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" colspan="4" style="border: 0;background: #fff">
                        <div class="panel panel-default" style="position: relative;margin-bottom: 0;">
                            <div class="panel-heading">Company Pictures</div>
                            <div class="panel-body">
                                <img src="<%=basePath%>../images/site/ban4.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                                <img src="<%=basePath%>../images/site/ban3.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                                <img src="<%=basePath%>../images/site/ban2.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                                <img src="<%=basePath%>../images/site/ban1.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                            </div>
                            <div class="fxq-photo-mask">
                                <div class="photo-pre"> < </div>
                                <div class="photo-next"> > </div>
                            </div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            </c:if>



            <c:if test="${empty report.basicInfos}">
                <tbody>
                <%--<tr>--%>
                    <%--<td align="right">&nbsp;</td>--%>
                    <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                <%--</tr>--%>
                <tr>
                    <td width="15%" height="35" align="right"><strong>Company Name</strong></td>
                    <td width="39%" style="padding-left:20px">${companyName}
                    </td>
                    <td width="15%" height="35" align="right"><strong>Reg ID</strong></td>
                    <td width="35%"><span
                            style="padding-left:20px">-</span>
                    </td>
                </tr>
                <tr>
                    <td height="35" align="right"><strong>Chinese Name</strong></td>
                    <td style="padding-left:20px">-</td>
                    <td height="35" align="right"><strong>Local</strong></td>
                    <td><span style="padding-left:20px">-</span></td>
                </tr>
                <tr>
                    <td height="35" align="right"><strong>Trade Name</strong></td>
                    <td><span style="padding-left:20px">-</span>
                    </td>
                    <td height="35" align="right" valign="top"><strong>Website</strong></td>
                    <td valign="top"><a href="${report.basicInfos.website}" target="_blank"><span
                            style="padding-left:20px">-</span></a></td>
                </tr>
                <%--<tr>--%>
                    <%--<td height="35" colspan="4" align="right">&nbsp;</td>--%>
                <%--</tr>--%>
                <tr>
                    <td height="35" colspan="4" align="left">
                        <div class="panel panel-default">
                            <div class="panel-heading">Products &amp; Services</div>
                            <div class="panel-body">
                                <table class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <%--<tr>--%>
                                        <%--<td width="15%" align="right">&nbsp;</td>--%>
                                        <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                                    <%--</tr>--%>
                                    <tr>
                                        <td height="35" width="10%" align="right" valign="top"><strong>Main Product</strong></td>
                                        <td  valign="top"
                                            style="padding-left:20px"> -
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="10%" height="35" align="right" valign="top">
                                            <strong>Link</strong></td>
                                        <td valign="top" style="padding-left:20px"><a href="https://ydwatch.en.alibaba.com" target="_blank">-</a>
                                        </td>
                                    </tr>
                                    <%--<tr>--%>
                                        <%--<td height="35" align="right" valign="top"><strong>Services--%>
                                            <%--introduction </strong></td>--%>
                                        <%--<td width="39%" valign="top"--%>
                                            <%--style="padding-left:20px"> ---%>
                                        <%--</td>--%>
                                        <%--<td width="15%" height="35" align="right" valign="top">--%>
                                            <%--<strong>Link</strong></td>--%>
                                        <%--<td width="39%" valign="top"--%>
                                            <%--style="padding-left:20px">---%>
                                        <%--</td>--%>
                                    <%--</tr>--%>
                                    <%--<tr>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                    <%--</tr>--%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4"  style="border: 0;background: #fff">
                        <div class="panel panel-default">
                            <div class="panel-heading">Contact Info</div>
                            <div class="panel-body">
                                <table  class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <tr>
                                        <td height="35" align="right" valign="top"  >
                                            <strong>Headquater Address</strong>
                                        </td>
                                        <td width="39%" valign="top" style="padding-left:20px">-</td>
                                        <td width="15%" align="right" valign="top">
                                            <strong>Region</strong>
                                        </td>
                                        <td width="39%" valign="top" style="padding-left:20px">-</td>
                                    </tr>
                                    <tr>
                                        <td height="35" align="right" valign="top">
                                            <strong>Email</strong></td>
                                        <td width="39%" valign="top"
                                            style="padding-left:20px">-
                                        </td>
                                        <td align="right" valign="top"><strong>Tel</strong></td>
                                        <td width="39%" valign="top"
                                            style="padding-left:20px">-
                                        </td>
                                    </tr>
                                    <%--<tr>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td align="right" valign="top">&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                    <%--</tr>--%>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4"  style="border: 0;background: #fff">
                        <div class="panel panel-default">
                            <div class="panel-heading">Company Info</div>
                            <div class="panel-body">
                                <table class="table table-hover table-striped table-responsive"  width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <%--<tr>--%>
                                        <%--<td width="15%" align="right">&nbsp;</td>--%>
                                        <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
                                    <%--</tr>--%>
                                    <tr>
                                        <td height="35" align="right" valign="top"  width="11%">
                                            <strong>Company Size</strong>
                                        </td>
                                        <td height="35" colspan="3" valign="top"
                                            style="padding-left:20px"><p></p></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td width="39%">&nbsp;</td>
                                        <td width="15%">&nbsp;</td>
                                        <td width="39%">&nbsp;</td>
                                    </tr>
                                    <%--<tr>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                        <%--<td>&nbsp;</td>--%>
                                    <%--</tr>--%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4"  style="border: 0;background: #fff">
                        <div class="panel panel-default" style="position: relative;margin-bottom: 0;">
                            <div class="panel-heading">Company Pictures</div>
                            <div class="panel-body">
                                <img src="<%=basePath%>../images/site/ban4.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                                <img src="<%=basePath%>../images/site/ban3.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                                <img src="<%=basePath%>../images/site/ban2.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                                <img src="<%=basePath%>../images/site/ban1.jpg" style="width:240px;margin: 8px;height:170px;" class="fxq-photo">
                            </div>

                            <div class="fxq-photo-mask">
                                <div class="photo-pre"> < </div>
                                <div class="photo-next"> > </div>
                            </div>
                        </div>
                    </td>
                </tr>
                </tbody>
                </table>
            </c:if>

        </div>
    </div>
</div>
