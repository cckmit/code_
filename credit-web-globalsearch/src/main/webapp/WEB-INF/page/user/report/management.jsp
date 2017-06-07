<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="tab-pane fade in" id="Management">
    <table class="table table-hover table-bordered table-responsive">
        <tbody>
        <thead>
        <tr>
            <th>Name</th>
            <th>Position</th>
        </tr>
        </thead>


        <tr>
            <td width="50%"><p><strong>-</strong></p>
            </td>
            <td width="50%">-</td>
        </tr>
        </tbody>
    </table>
</div>