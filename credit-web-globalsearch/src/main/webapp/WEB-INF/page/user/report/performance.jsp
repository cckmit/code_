<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>



<div class="tab-pane fade in" id="Performance">
    <table width="100%" border="0" cellspacing="0" cellpadding="0"
           class="table table-striped table-responsive">
        <tbody>
        <tr>
            <td valign="top" width="23%" class="formleft"><strong>Year</strong></td>
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
            <td valign="top" class="formleft"><strong>Turnover</strong> </td> <td valign="top" class="formright">
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
            <td valign="top" class="formleft"><strong>Profit Before Tax</strong> </td> <td valign="top" class="formright">
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
            <td valign="top" class="formleft"><strong>Total Assets</strong> </td> <td valign="top" class="formright">
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
            <td valign="top" class="formleft"><strong>Paid-up Capital</strong> </td> <td valign="top" class="formright">
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

    <p>Note: Unit (1000 Yuan) Currency (RMB)</p>
    <div class="row">
        <div  style="background: #0C8BDE;color: #fff;padding:10px 25px 10px 15px;margin-bottom: 10px;overflow: hidden;">
            <div style="float: left;;width: 20%;">Fianncial Ratio</div>
            <table style="float: right;;width: 72%;vertical-align: middle;">
                <tr>
                    <td valign="top"  width="30%">
                        <div align="right">2016</div>
                    </td>
                    <td valign="top"  width="30%">
                        <div align="right">2015</div>
                    </td>
                    <td valign="top"  width="30%">
                        <div align="right">2014</div>
                    </td>
                </tr>
            </table>
        </div>
        <div class="panel-group" role="tablist"
             aria-multiselectable="true">
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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Return on Assets (%)</strong>
                                    <div class="fxq-basic fxq-ratio">
                                        Profit before tax / Total assets  x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Profit Margin (%) </strong>
                                    <div class="fxq-basic fxq-ratio">
                                        Profit before tax / Turnover  x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Gross Margin (%)</strong>
                                    <div class="fxq-basic fxq-ratio">Gross Margin / Turnover  x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading02">
                    <h4 class="panel-title">
                        <a class="collapsed" data-toggle="collapse"
                           data-parent="#accordion"
                           href="#collapse02"
                           aria-expanded="false" aria-controls="collapse02">
                            Operating Ratios
                        </a>
                    </h4>
                </div>
                <div id="collapse02" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="heading02">
                    <div class="panel-body">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0"
                               class="table table-striped table-responsive"  style="margin-bottom: 0;">
                            <tbody>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Assets Turnover (x)</strong>
                                    <div class="fxq-basic fxq-ratio">Turnover / Total assets
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Stock Turnover (x) </strong>
                                    <div class="fxq-basic fxq-ratio">Turnover / Stock
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Sales Period (days) </strong>
                                    <div class="fxq-basic fxq-ratio">Inventory/COGS*365
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Collection Period (days)</strong>
                                    <div class="fxq-basic fxq-ratio">Account Receivable/Sales*365
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Credit Period (days) </strong>
                                    <div class="fxq-basic fxq-ratio">Account Payable/Sales*365
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading03">
                    <h4 class="panel-title">
                        <a class="collapsed" data-toggle="collapse"
                           data-parent="#accordion"
                           href="#collapse03"
                           aria-expanded="false" aria-controls="collapse03">
                            Structure Ratios
                        </a>
                    </h4>
                </div>
                <div id="collapse03" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="heading03">
                    <div class="panel-body">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0"
                               class="table table-striped table-responsive"  style="margin-bottom: 0;">
                            <tbody>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Current Ratio (x)  </strong>
                                    <div class="fxq-basic fxq-ratio">Current Asset / Current Liabilities
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Quick Ratio (x)</strong>
                                    <div class="fxq-basic fxq-ratio">
                                        (Current Assets - Stocks) / Current Liabilities
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Shareholders Liquidity Ratio (x) </strong>
                                    <div class="fxq-basic fxq-ratio">
                                        Shareholders Funds / Long-term Liabilities
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Solvency Ratio (%) </strong>
                                    <div class="fxq-basic fxq-ratio">
                                        Shareholders Funds / Total Assets  x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Debt Ratio (%)</strong>
                                    <div class="fxq-basic fxq-ratio">Debts / Equity  x100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                    </div>
                </div>
            </div>
            <%--新添加可折叠块--%>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading04">
                    <h4 class="panel-title">
                        <a class="collapsed" data-toggle="collapse"
                           data-parent="#accordion"
                           href="#collapse04"
                           aria-expanded="false" aria-controls="collapse03">
                            Productivity Ratios
                        </a>
                    </h4>
                </div>
                <div id="collapse04" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="heading04">
                    <div class="panel-body">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0"
                               class="table table-striped table-responsive"  style="margin-bottom: 0;">
                            <tbody>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Profit Per Employee (th) </strong>
                                    <div class="fxq-basic fxq-ratio">Profit / Employees 
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Operating Revenue Per Employee (th) </strong>
                                    <div class="fxq-basic fxq-ratio">Operating Revenue /Employees
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Shareholders Funds Per Employee (th) </strong>
                                    <div class="fxq-basic fxq-ratio">Equity /Employees
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Total Assets Per Employee (th)</strong>
                                    <div class="fxq-basic fxq-ratio">Total Assets /Employees
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="heading05">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapse05"
                           aria-expanded="true"
                           aria-controls="collapse01">
                            Growth Ratios
                        </a>
                    </h4>
                </div>
                <div id="collapse05" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="heading05">
                    <div class="panel-body">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0"
                               class="table table-striped table-responsive" style="margin-bottom: 0;">
                            <tbody>
                            <tr>
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Sales Growth Rate (%) </strong>
                                    <div class="fxq-basic fxq-ratio">
                                        (Yr1 Sales - Yr2 Sales) /Yr2 Sales x 100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong>Net Profit Growth Rate (%) </strong>
                                    <div class="fxq-basic fxq-ratio">
                                        (Yr1 Net profit - Yr2 Net profit) /Yr2 Net profit x 100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
                                <td valign="top" class="formleft fxq-basic-hover" style="position: relative;">
                                    <strong> Total Assets Growth Rate (%)</strong>
                                    <div class="fxq-basic fxq-ratio">
                                        (Yr1 Total Assets - Yr2 Total Assets) /Yr2 Total Assets x 100
                                        <div class="fxq-basic-sjx1"></div>
                                        <div class="fxq-basic-sjx2"></div>
                                    </div>
                                </td>

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
    </div>
</div>