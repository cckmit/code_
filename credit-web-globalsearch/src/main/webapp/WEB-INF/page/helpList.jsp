<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String patd = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + patd + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="include/include.jsp"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Full search - help</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="include/include.jsp"/>
    <script type="text/javascript" src="<%=basePath%>js/base64.js"></script>
    <script src="<%=basePath%>/js/helpList.js"></script>

</head>
<body>
<jsp:include page="${basePath}include/top.jsp"/>
<div class="container">
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
    <div id="banner">
        <p class="lead">Help</p>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Help Document</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <div class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input id="queryTitle" class="form-control" placeholder="Key word" type="text" onkeypress="if(event.keyCode==13) {query();}">
                            <button type="button" class="btn btn-default" onclick="query();">Search</button>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
        <div class="row">
            <div class="col-lg-3">
                <div class="bs-component">
                    <div class="list-group" id="helpCateSupportMenu">

                    </div>
                </div>
                <%--&lt;%&ndash;添加问题&ndash;%&gt;--%>
                <%--<div class="fxq-add-q">--%>
                    <%--<div href="#" class="list-group-item active">--%>
                        <%--Can't find the problem?--%>
                    <%--</div>--%>
                    <%--<textarea name="" id="" placeholder="Please enter a problem here..."></textarea>--%>
                    <%--<button type="button" class="btn btn-default" style="background: #1abc9c;margin-top: 5px;padding: 3px 10px;" onclick="massge()">Submit</button>--%>
                <%--</div>--%>
            </div>

            <div class="col-lg-9">
                <div class="bs-component">
                    <table id="helpListGrid" class="table table-hover table-responsive bootgrid-table" style="border-bottom:1px solid #dddddd ">
                        <thead>
                        <tr>
                            <th data-column-id="id" data-type="numeric" data-identifier="true" data-visible="false">ID</th>
                            <th data-column-id="title" data-type="string" data-formatter="title" data-width="77%">Title</th>
                            <th data-column-id="cateName" data-type="string" data-formatter="cateName" data-width="23%">Classification</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

        <p class="pull-right">If the problem cannot be solved, please Email to<a href="mailto:help@global-search.cn?subject=帮助">help@global-search.cn </a></p>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="helpTitle"></h4>
            </div>
            <div class="modal-body" id="helpContent"></div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<jsp:include page="${basePath}include/bottom.jsp"/>
</body>
</html>