<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="tab-pane fade in" id="Location">
    <table class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
        <tbody>
        <%--<tr>--%>
            <%--<td align="right">&nbsp;</td>--%>
            <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
        <%--</tr>--%>
        <c:if test="${city.getCityEN()!=null&&province.getProvinceEN()==null}">
            <tr>
                <td width="14%" height="35" align="right"><strong>City / Province</strong></td>
                <td width="27%"
                    style="padding-left:20px"> ${city.getCityEN()}/
                </td>
                <td width="24%" height="35" align="right"><strong>Metropolitan Area</strong></td>
                <td width="35%"><span style="padding-left:20px">${city.getMetropolitanAreaEN()}</span></td>
            </tr>
            <tr>
                <td height="35" align="right"><strong>Area</strong></td>

                    <td style="padding-left:20px">
                        <c:if test="${city.getArea()!=null&&city.getArea()!=''}">${city.getArea()} million sq km</c:if>
                    </td>
                <td height="35" align="right"><strong>Population</strong></td>
                <td><c:if test="${city.getPopulation()!=null&&city.getPopulation()!=''}">
                    <span style="padding-left:20px">
                    <c:if test="${city.getPopulation() !=''}">
                        <fmt:formatNumber value="${city.getPopulation()}0000" pattern="#,#00"/>
                    </c:if>
                    </span>
                </c:if></td>
            </tr>
            <tr>
                <td height="35" align="right" valign="top"><strong>Nominal Gdp Total</strong>
                </td>
                <td valign="top" style="padding-left:20px">
                    <c:if test="${city.getNominalGdpTotal()!=null&&city.getNominalGdpTotal()!=''}">
                        <span>CNY ${city.getNominalGdpTotal()} billion</span>
                    </c:if>
                </td>
                <td height="35" align="right"><strong>Nominal Gdp Per Capita</strong></td>
                <td>
                    <c:if test="${city.getNominalGdpPerCapita()!=null&&city.getNominalGdpPerCapita()!=''}">
                        <span style="padding-left:20px">CNY
                            <c:if test="${city.getNominalGdpPerCapita() !=''}">
                                <fmt:formatNumber value="${city.getNominalGdpPerCapita()}0000" pattern="#,#00"/>
                            </c:if>
                        </span>
                    </c:if>
                </td>


            </tr>
        </c:if>
        <c:if test="${province.getProvinceEN()!=null&&city.getCityEN()==null}">
            <tr>
                <td width="14%" height="35" align="right"><strong>City / Province</strong></td>
                <td width="27%"
                    style="padding-left:20px"> /${province.getProvinceEN()}
                </td>
                <td width="24%" height="35" align="right"><strong>Metropolitan Area</strong></td>
                <td width="35%"><span style="padding-left:20px">${province.getMetropolitanAreaEN()}</span></td>
            </tr>
            <tr>
                <td height="35" align="right"><strong>Area</strong></td>

                    <td style="padding-left:20px">
                        <c:if test="${province.getArea()!=null&&province.getArea()!=''}">${province.getArea()} million sq km</c:if>
                    </td>
                <td height="35" align="right"><strong>Population</strong></td>
                <td><c:if test="${province.getPopulation()!=null&&province.getPopulation()!=''}">
                    <span style="padding-left:20px">
                    <c:if test="${province.getPopulation() !=''}">
                        <fmt:formatNumber value="${province.getPopulation()}0000" pattern="#,#00"/>
                    </c:if>
                    </span>
                </c:if></td>
            </tr>
            <tr>
                <td height="35" align="right" valign="top"><strong>Nominal Gdp Total</strong>
                </td>
                <td valign="top" style="padding-left:20px">
                    <c:if test="${province.getNominalGdpTotal()!=null&&province.getNominalGdpTotal()!=''}">
                        <span>CNY ${province.getNominalGdpTotal()} billion</span>
                    </c:if>
                </td>
                <td height="35" align="right"><strong>Nominal Gdp Per Capita</strong></td>
                <td>
                    <c:if test="${province.getNominalGdpPerCapita()!=null&&province.getNominalGdpPerCapita()!=''}">
                        <span style="padding-left:20px">CNY

                            <c:if test="${province.getNominalGdpPerCapita() !=''}">
                                <fmt:formatNumber value="${province.getNominalGdpPerCapita()}0000" pattern="#,#00"/>
                            </c:if>
                        </span>
                    </c:if>
                </td>

            </tr>
        </c:if>
        <c:if test="${province.getProvinceEN()!=null&&city.getCityEN()!=null}">
            <tr>
                <td width="14%" height="35" align="right"><strong>City / Province</strong></td>
                <td width="27%"
                    style="padding-left:20px"> ${city.getCityEN()}/${province.getProvinceEN()}
                </td>
                <td width="24%" height="35" align="right"><strong>Metropolitan Area</strong></td>
                <td width="35%"><span style="padding-left:20px">${city.getMetropolitanAreaEN()}</span></td>
            </tr>
            <tr>
                <td height="35" align="right"><strong>Area</strong></td>
                <td style="padding-left:20px"><c:if test="${city.getArea()!=null&&city.getArea()!=''}">${city.getArea()} million sq km</c:if></td>
                <td height="35" align="right" ><strong>Population</strong></td>
                <td><c:if test="${city.getPopulation()!=null&&city.getPopulation()!=''}">
                    <span style="padding-left:20px">
                    <c:if test="${city.getPopulation() !=''}">
                        <fmt:formatNumber value="${city.getPopulation()}0000" pattern="#,#00"/>
                    </c:if>
                    </span>
                </c:if></td>
            </tr>
            <tr>
                <td height="35" align="right" valign="top"><strong>Nominal Gdp Total</strong>
                </td>
                <td valign="top" style="padding-left:20px">
                    <c:if test="${city.getNominalGdpTotal()!=null&&city.getNominalGdpTotal()!=''}">
                        <span>CNY ${city.getNominalGdpTotal()} billion</span>
                    </c:if>
                </td>
                <td height="35" align="right"><strong>Nominal Gdp Per Capita</strong></td>
                <td>
                    <c:if test="${city.getNominalGdpPerCapita()!=null&&city.getNominalGdpPerCapita()!=''}">
                        <span style="padding-left:20px">CNY
                            <fmt:formatNumber value="${city.getNominalGdpPerCapita()}0000" pattern="#,#00"/>
                        </span>
                    </c:if>
                </td>

            </tr>
        </c:if>
        <c:if test="${province.getProvinceEN()==null&&city.getCityEN()==null}">
            <tr>
                <td width="14%" height="35" align="right"><strong>City / Province</strong></td>
                <td width="27%"
                    style="padding-left:20px"> /
                </td>
                <td width="24%" height="35" align="right"><strong>Metropolitan Area</strong></td>
                <td width="35%"><span style="padding-left:20px"></span></td>
            </tr>
            <tr>
                <td height="35" align="right"><strong>Area</strong></td>
                <td style="padding-left:20px"></td>
                <td height="35" align="right"><strong>Population</strong></td>
                <td><span style="padding-left:20px"></span></td>
            </tr>
            <tr>
                <td height="35" align="right" valign="top"><strong>Nominal Gdp Total</strong>
                </td>
                <td valign="top" style="padding-left:20px">
                    <span></span>
                </td>
                <td height="35" align="right"><strong>Nominal Gdp Per Capita</strong></td>
                <td>
                    <span style="padding-left:20px"></span>
                </td>

            </tr>
        </c:if>
        <%--<tr>--%>
            <%--<td height="35" colspan="4" align="right">&nbsp;</td>--%>
        <%--</tr>--%>
        <tr>
            <td height="35" colspan="4" align="left">
                <div class="panel panel-default">
                    <div class="panel-heading">Map</div>
                    <div class="panel-body">
                        <table  class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                            <tr>
                                <td>
                                    <iframe src="http://j.map.baidu.com/7PcTj" width="98%"
                                            height="350px" frameborder="0" scrolling="no"
                                            marginwidth="0" marginheight="0"></iframe>
                                </td>
                                <td>
                                    <iframe src="http://j.map.baidu.com/7PcTj" width="98%"
                                            height="350px" frameborder="0" scrolling="no"
                                            marginwidth="0" marginheight="0"></iframe>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>