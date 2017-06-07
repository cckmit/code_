
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="tab-pane fade in" id="Business">
    <%--<p>暂留.</p>--%>
    <div class="row">
        <div class="panel-group" role="tablist" aria-multiselectable="true">
            <%--Current Operation--%>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="fxqOne8">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#current8"
                           aria-expanded="true"
                           aria-controls="currentOne">
                            Current Operations </a>
                    </h4>
                </div>
                <div id="current8" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqOne8">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive fxq-report-table">
                            <tbody>
                            <tr>
                                <td width="15%" rowspan="6" style="background: #F5F5F5     ">Business:</td>
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
                                <td  width="15%" rowspan="6" style="background: #F5F5F5">Territories: </td>
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
                            <td  width="15%" style="background: #F5F5F5">Import: </td>
                            <td width="20%">Purchase:</td>
                            <td>-</td>
                            </tr>
                            <tr>
                                <td  width="15%" style="background: #F5F5F5">Export: </td>
                                <td width="20%">Purchase:</td>
                                <td>-</td>
                            </tr>

                            <tr>
                                <td  width="15%" rowspan="5" style="background: #F5F5F5">Terms:  </td>
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
                                <td width="15%" style="background: #F5F5F5">Certification:</td>
                                <td colspan="2">-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Employees:</td>
                                <td colspan="2">-</td>
                            </tr>

                            <tr>
                                <td  width="15%" rowspan="4" style="background: #F5F5F5">Facility:  </td>
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
                                <td width="15%" style="background: #F5F5F5">Location:</td>
                                <td colspan="2">-</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <%--Import&Export--%>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="fxqtwo8">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#import8"
                           aria-expanded="true"
                           aria-controls="currentOne">
                            Import&Export </a>
                    </h4>
                </div>
                <div id="import8" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqtwo8">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive fxq-report-table">
                            <tbody>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Customer Nr:</td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Clearance Type: </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Co Category: </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Reg. Expiration:</td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Comments: </td>
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
                <div class="panel-heading" role="tab" id="fxqthr8">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#industryblock8"
                           aria-expanded="true"
                           aria-controls="currentOne">
                            Industry </a>
                    </h4>
                </div>
                <div id="industryblock8" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqthr8">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive fxq-report-table">
                            <tbody>
                            <tr>
                                <td width="20%" style="background: #F5F5F5">Chinese (CSIC): </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="20%" style="background: #F5F5F5">American (ISIC): </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="20%" style="background: #F5F5F5">European (NACE): </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="20%" style="background: #F5F5F5">Industry Description: </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="20%" style="background: #F5F5F5">Industry Overview:</td>
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
                <div class="panel-heading" role="tab" id="fxqfour8">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#bank8"
                           aria-expanded="true"
                           aria-controls="currentOne">
                            Bank Reference </a>
                    </h4>
                </div>
                <div id="bank8" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqfour8">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive fxq-report-table">
                            <tbody>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Bank Name:  </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Bank Address:  </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Account Nr:  </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Phone:</td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Banker </td>
                                <td>-</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <%--Payment History--%>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="fxqfive8">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#payment8"
                           aria-expanded="true"
                           aria-controls="currentOne">
                            Payment History </a>
                    </h4>
                </div>
                <div id="payment8" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqfive8">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive fxq-report-table">
                            <tbody>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Company Name:   </td>
                                <td>-</td>
                                <td width="15%" style="background: #F5F5F5">Crefo Nr.:   </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Interview:  </td>
                                <td>-</td>
                                <td width="15%" style="background: #F5F5F5">Phone:  </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Main Activities:   </td>
                                <td colspan="3">-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Payment Mode:</td>
                                <td colspan="3">-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Delinquent:</td>
                                <td colspan="3">-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Debt Collection: </td>
                                <td colspan="3">-</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <%--Trade Reference--%>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="fxqsix8">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#trade8"
                           aria-expanded="true"
                           aria-controls="currentOne">
                            Trade Reference </a>
                    </h4>
                </div>
                <div id="trade8" class="panel-collapse collapse" role="tabpanel" aria-labelledby="fxqsix8">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive fxq-report-table">
                            <tbody>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Company Name:   </td>
                                <td>-</td>
                                <td width="15%" style="background: #F5F5F5">Crefo Nr.:   </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Phone:   </td>
                                <td>-</td>
                                <td width="15%" style="background: #F5F5F5">Relationship:   </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Comments:    </td>
                                <td colspan="3">-</td>
                            </tr>
                            <tr>
                                <td colspan="4" style="background: #fff"></td>
                            </tr>

                            <tr>
                                <td width="15%" style="background: #F5F5F5">Company Name:   </td>
                                <td>-</td>
                                <td width="15%" style="background: #F5F5F5">Crefo Nr.:   </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Phone:   </td>
                                <td>-</td>
                                <td width="15%" style="background: #F5F5F5">Relationship:   </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Comments:    </td>
                                <td colspan="3">-</td>
                            </tr>
                            <tr>
                                <td colspan="4" style="background: #fff"></td>
                            </tr>

                            <tr>
                                <td width="15%" style="background: #F5F5F5">Company Name:   </td>
                                <td>-</td>
                                <td width="15%" style="background: #F5F5F5">Crefo Nr.:   </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Phone:   </td>
                                <td>-</td>
                                <td width="15%" style="background: #F5F5F5">Relationship:   </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Comments:    </td>
                                <td colspan="3">-</td>
                            </tr>
                            <tr>
                                <td colspan="4" style="background: #fff"></td>
                            </tr>

                            <tr>
                                <td width="15%" style="background: #F5F5F5">Company Name:   </td>
                                <td>-</td>
                                <td width="15%" style="background: #F5F5F5">Crefo Nr.:   </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Phone:   </td>
                                <td>-</td>
                                <td width="15%" style="background: #F5F5F5">Relationship:   </td>
                                <td>-</td>
                            </tr>
                            <tr>
                                <td width="15%" style="background: #F5F5F5">Comments:    </td>
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