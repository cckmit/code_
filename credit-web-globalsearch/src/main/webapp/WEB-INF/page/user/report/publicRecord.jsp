<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
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
            <td width="25%">Taxes owed</td>
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
                    class="formleft">0 records</span></strong>
            </td>
            <td><strong>0 records</strong></td>
            <td><strong>0 records</strong></td>
        </tr>
        <tr>
            <td width="25%">Judgments</td>
            <td><strong><span
                    class="formleft">0 records</span></strong>
            </td>
            <td><strong>0 records</strong></td>
            <td><strong>0 records</strong></td>
        </tr>
        <tr>
            <td width="25%">Enforcement Records</td>
            <td><strong><span
                    class="formleft">0 records</span></strong>
            </td>
            <td><strong>0 records</strong></td>
            <td><strong>0 records</strong></td>
        </tr>
        <tr>
            <td width="25%">The faithless persons
                subjected to execution</td>
            <td><strong><span
                    class="formleft">0 records</span></strong>
            </td>
            <td><strong>0 records</strong></td>
            <td><strong>0 records</strong></td>
        </tr>
        </tbody>
    </table>
    <p>Note: record does not represent all records
    </p>


    <tr name="-">
        <td>
            <table class="table table-hover table-striped table-responsive">
                <%--name="${list.dataType}"--%>
                <tr>
                    <td width="15%" bgcolor="#eef1f3">Data Type</td>
                    <td width="10%">-</td>
                    <td width="6%" bgcolor="#eef1f3">Court</td>
                    <td width="17%">-</td>
                    <td width="10%" bgcolor="#eef1f3">Case No</td>
                    <td width="24%">-</td>
                    <td width="6%" bgcolor="#eef1f3">Date</td>
                    <td width="17%">-</td>
                </tr>
                <tr>
                    <td bgcolor="#eef1f3">Brief Introduction&nbsp;</td>
                    <td colspan="5">-</td>
                    <td><label>
                        <%--<input type="checkbox">&nbsp;收藏--%>
                        <%--<button type="button" class="btn btn-prime btn-sm">--%>
                        <%--Collection--%>
                        <%--</button>--%>
                    </label></td>
                    <td>
                        <%--<button type="button" class="btn btn-prime btn-sm">--%>
                        <%--Detail--%>
                        <%--</button>--%>
                    </td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>


</div>