<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="tab-pane fade in" id="Registration">

    <table  class="table table-hover table-striped table-responsive" width="100%" border="0" cellspacing="0" cellpadding="0">
        <tbody>
        <%--<tr>--%>
            <%--<td align="right">&nbsp;</td>--%>
            <%--<td colspan="3" style="padding-left:20px">&nbsp;</td>--%>
        <%--</tr>--%>
        <tr>
            <td width="20%" height="35" align="right"><strong>Register Name</strong></td>
            <td colspan="3" style="padding-left:20px">-
            </td>
        </tr>
        <%--<tr>--%>
        <%--<td height="35" align="right"><strong>Chinese Name</strong></td>--%>
        <%--<td colspan="3" style="padding-left:20px">-</td>--%>
        <%--</tr>--%>
        <tr>
            <td height="35" align="right"><strong>Registration Nr</strong></td>
            <td colspan="3"><span style="padding-left:20px">-</span></td>
            <%--<td width="20%" height="35" align="right"><strong>Status</strong></td>--%>
            <%--<td width="30%"><span style="padding-left:20px">-</span></td>--%>
        </tr>
        <tr>
            <%--<td height="35" align="right"><strong>Legal Form</strong></td>--%>
            <%--<td><span style="padding-left:20px">-</span></td>--%>
            <td height="35" align="right"><strong>Company Type</strong></td>
            <td colspan="3"><span style="padding-left:20px">-</span></td>
        </tr>
        <tr>
            <td height="35" align="right"><strong>Registered Capital</strong></td>
            <td width="30%"><span style="padding-left:20px">-</span></td>
            <td height="35" align="left"><strong>Paid Up Capital</strong><span style="padding-left:20px">-</span></td>
        </tr>
        <tr>
            <td height="35" align="right"><strong>Incorporation Date</strong></td>
            <td><span style="padding-left:20px">-</span></td>
            <td height="35" align="left"><strong>Expiration Date</strong><span style="padding-left:20px">-</span></td>
        </tr>
        <tr>
            <td height="35" align="right" valign="top"><strong>Registry</strong></td>
            <td valign="top" style="padding-left:20px">-
            </td>
            <td height="35" align="left" valign="top"><strong>Legal Representative</strong>
                <span style="padding-left:20px">-</span>
            </td>
        </tr>
        <tr>
            <td height="35" align="right" valign="top"><strong>Registered Address</strong>
            </td>
            <td colspan="3" valign="top" style="padding-left:20px">-
            </td>
            <%--<td height="35" align="right" valign="top"><strong>Registered Address--%>
            <%--(CN)</strong>--%>
            <%--</td>--%>
            <%--<td valign="top" style="padding-left:20px"><span>-</span></td>--%>
        </tr>
        <tr>
            <td height="35" align="right" valign="top"><strong>Business Scope</strong></td>
            <td height="35" colspan="3" style="padding-left:20px">-
            </td>
        </tr>
        <tr>
            <td colspan="4" align="center">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="4" align="center">
            </td>
        </tr>
        </tbody>
    </table>
    <%--新添加可折叠块--%>
    <div class="panel-group" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="registra">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#registraOne"
                       aria-expanded="true"
                       aria-controls="collapseOne">
                        Shareholder（-） </a>
                </h4>
            </div>
            <div id="registraOne" class="panel-collapse collapse" role="tabpanel"
                 aria-labelledby="registra">
                <div class="panel-body">
                    <table width="80%" class="table table-hover table-striped table-responsive">
                        <thead>
                        <tr>
                            <th width="9%">Shares</th>
                            <th width="47%">Shareholder Names</th>
                            <th width="22%"> Shareholder Capital</th>
                            <%--<th width="22%">Order</th>--%>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <%--<td><a href="#" class="btn btn-info">Order this Company</a>--%>
                            <%--</td>--%>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="regis">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#regisOne"
                       aria-expanded="true"
                       aria-controls="collapseOne">
                        Managerments（-） </a>
                </h4>
            </div>
            <div id="regisOne" class="panel-collapse collapse" role="tabpanel"
                 aria-labelledby="regis">
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


                        <tr>
                            <td width="25%"><p><strong>-</strong></p>
                            </td>
                            <td width="25%">-</td>
                            <td width="25%">-</td>
                            <td width="25%">-</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>