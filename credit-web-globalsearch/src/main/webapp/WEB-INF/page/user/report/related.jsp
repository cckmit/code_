<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="tab-pane fade in" id="Related">
    <div class="row">
        <div class="panel-group" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapseOne"
                           aria-expanded="true"
                           aria-controls="collapseOne">
                            Foreign Investment of Enterprises（-） </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="headingOne">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive">
                            <thead>
                            <tr>
                                <th width="">Company Name</th>
                                <th width="">Contribution Ratio</th>
                                <th width="">Registered Capital</th>
                                <th width="">Date</th>
                                <th width="">Company Type</th>
                                <th width="">Company Status</th>
                                <th width="">Search</th>
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
                            Enterprise Branch（-）
                        </a>
                    </h4>
                </div>
                <div id="collapseFour" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="headingFour">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive">
                            <thead>
                            <tr>
                                <th width="">Company Name</th>
                                <th width="">Registration Number</th>
                                <th width="">Tel</th>
                                <th width="">Date</th>
                                <th width="">Nature of Company</th>
                                <th width="">Company Status</th>
                                <th width="">Search</th>
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
                            Corporate Foreign Investment（-）
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="headingTwo">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive">
                            <thead>
                            <tr>
                                <th width="">Company Name</th>
                                <th width="">Contribution Ratio</th>
                                <th width="">Registered Capital</th>
                                <th width="">Date</th>
                                <th width="">Company Type</th>
                                <th width="">Company Status</th>
                                <th width="">Search</th>
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
                            Legal Person Outside the Office（-）
                        </a>
                    </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                     aria-labelledby="headingThree">
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive">
                            <thead>
                            <tr>
                                <th width="">Company Name</th>
                                <th width="">Contribution Ratio</th>
                                <th width="">registered Capital</th>
                                <th width="">Date</th>
                                <th width="">Company Type</th>
                                <th width="">Company Status</th>
                                <th width="">Search</th>
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