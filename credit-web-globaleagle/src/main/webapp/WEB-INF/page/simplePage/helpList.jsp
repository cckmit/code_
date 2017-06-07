<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>全球鹰-帮助</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="include/include.jsp"/>
    <script type="text/javascript" src="<%=basePath%>js/base64.js"></script>
    <script src="<%=basePath%>js/helpList.js"></script>

</head>
<%--<%--%>
    <%--List<HelpCate> cates = ((HelpCateMapper)SpringContextUtils.getBean("helpCateMapper")).queryAll();--%>
    <%--pageContext.setAttribute("cates", cates);--%>
<%--%>--%>
<script type="text/javascript">
    var basePath = "<%=basePath%>";
    $(document).ready(function () {
        $("#helpLi").addClass("active");
    });
    curCate = '${cateId}';
</script>
<body>
<jsp:include page="${basePath}include/topCommon.jsp"/>
<div class="container">
    <%--         <jsp:include page="${basePath}../include/customer/left.jsp"/>
     --%>
    <div id="banner">
        <p class="lead">帮助</p>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">帮助文档</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <div class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input id="queryTitle" class="form-control" placeholder="关键词" type="text" onkeypress="if(event.keyCode==13) {query();}">
                            <button type="button" class="btn btn-default" onclick="query();">搜索</button>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
        <div class="row">
            <div class="col-lg-3">
                <div class="bs-component">
                    <div class="list-group">
                        <a name="cateA" value="0" href="javascript:void(0);" onclick="changeHelpCate(this);" class="list-group-item active">
                            全部内容
                        </a>
                        <c:if test="${cates != null}">
                            <c:forEach items="${cates}" var="cate">
                        <a name="cateA" value="${cate.id}" href="javascript:void(0);" onclick="changeHelpCate(this);" class="list-group-item">${cate.name}</a>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>

            <div class="col-lg-9">
                <div class="bs-component">
                    <table id="helpListGrid" class="table table-hover table-responsive bootgrid-table">
                        <thead>
                        <tr>
                            <th data-column-id="id" data-type="numeric" data-identifier="true" data-visible="false">ID</th>
                            <th data-column-id="title" data-type="string" data-formatter="title" data-width="100%">标题</th>
                            <th data-column-id="cateName" data-type="string" data-formatter="cateName" data-width="100">分类</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

        <p class="pull-right">如问题无法解决，请Email至<a href="mailto:help@global-eagle.cn?subject=帮助">help@global-eagle.cn </a></p>
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
<jsp:include page="${basePath}include/bottomCommon.jsp"/>
</body>
</html>