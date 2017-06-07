<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="tab-pane fade in" id="History">
    <table width="80%" class="table table-hover table-striped table-responsive">
        <thead>
        <tr>
            <th width="10%">Date</th>
            <th width="20%">Changes</th>
            <th width="35%">Before Changes</th>
            <th width="35%">After Changes
            </th>
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
</div>