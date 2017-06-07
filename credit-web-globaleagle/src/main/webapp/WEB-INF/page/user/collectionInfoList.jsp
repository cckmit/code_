<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>我的收藏</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
</head>

<body>
<div id="myColModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div>
        <div class="modal-content" style="width:1200px; height: 700px;margin:0px auto;">
           <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="countryModalLabel">我的收藏</h4>
            </div>
            <div class="modal-body">
                <div style="padding:0 20px 0 20px;">
                    <div id="scrolldIV" style="overflow:auto; background:#FFF; overflow-x: hidden; border:medium double  #CCC;" >
                        <table id="colListGrid" class="table table-hover table-bordered table-responsive bootgrid-table">
                            <thead>
                            <tr>
                                <th data-column-id="id" data-type="numeric" data-identifier="true" data-visible="false">ID</th>
                                <th data-column-id="type" data-type="string" data-width="80px;">类型</th>
                                <th data-column-id="court" data-type="string" data-width="190px;">法院</th>
                                <th data-column-id="caseNo" data-formatter="string" data-type="string" data-width="180px;">案号</th>
                                <th data-column-id="createDate" data-formatter="createDate" data-type="sring" data-width="86px;">日期</th>
                                <th data-column-id="topic" data-formatter="topic" data-type="sring">简介</th>
                                <th data-column-id="content" data-formatter="content" data-sortable="false" data-width="95px;">详细内容</th>
                                <th data-column-id="operate" data-formatter="operate" data-sortable="false" data-width="70px;">操作</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>